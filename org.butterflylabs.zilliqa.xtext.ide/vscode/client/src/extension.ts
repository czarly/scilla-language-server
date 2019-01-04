/* --------------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */
'use strict';

import * as path from 'path';
import * as net from 'net';

import {Trace} from 'vscode-jsonrpc';
import { commands, window, workspace, ExtensionContext, Uri} from 'vscode';

import {
	LanguageClient,
	LanguageClientOptions,
	StreamInfo,
	ServerOptions,
	TransportKind
} from 'vscode-languageclient';

let lc: LanguageClient;

export function activate(context: ExtensionContext) {

	/*** this is for starting the server as part of the extension */

	let executable = process.platform == 'win32' ? 'org.butterflylabs.zilliqa.xtext.ide.bat' : 'org.butterflylabs.zilliqa.xtext.ide';
	let serverLauncher = context.asAbsolutePath(path.join(
        'org.butterflylabs.zilliqa.xtext.ide', 'bin', executable));
	let serverOptions: ServerOptions = {
		run : { command: serverLauncher, args: ['-Xdebug','-Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n,quiet=y','-Xmx256m'] },
		debug: { command: serverLauncher, args: ['-Xdebug','-Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n,quiet=y','-Xmx256m'] }
	};

	/*** starting server as part of the extension end */

	/*** this is for starting hte server in eclipse and debugging  */
	// let connectionInfo = {
    //     port: 5007
    // };
    // let serverOptions = () => {
    //     // Connect to language server via socket
    //     let socket = net.connect(connectionInfo);
    //     let result: StreamInfo = {
    //         writer: socket,
    //         reader: socket
    //     };
    //     return Promise.resolve(result);
    // };
	/*** starting external server and */

	// Options to control the language client
	let clientOptions: LanguageClientOptions = {
        documentSelector: ['scilla'],
        synchronize: {
            fileEvents: workspace.createFileSystemWatcher('**/*.*')
        }
    };

	lc = new LanguageClient('Xtext Server', serverOptions, clientOptions);

	var disposable2 =commands.registerCommand("scilla.a.proxy", async () => {
        let activeEditor = window.activeTextEditor;
        if (!activeEditor || !activeEditor.document || activeEditor.document.languageId !== 'scilla') {
            return;
        }

        if (activeEditor.document.uri instanceof Uri) {
            commands.executeCommand("scilla.a", activeEditor.document.uri.toString());
        }
    })
    context.subscriptions.push(disposable2);
    
    // enable tracing (.Off, .Messages, Verbose)
    lc.trace = Trace.Verbose;
    let disposable = lc.start();
    
    // Push the disposable to the context's subscriptions so that the 
    // client can be deactivated on extension deactivation
    context.subscriptions.push(disposable);
}

export function deactivate(): Thenable<void> {
	if (!lc) {
		return undefined;
	}
	return lc.stop();
}
