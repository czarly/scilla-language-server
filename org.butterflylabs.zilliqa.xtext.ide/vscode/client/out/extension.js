/* --------------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 * ------------------------------------------------------------------------------------------ */
'use strict';
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : new P(function (resolve) { resolve(result.value); }).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
Object.defineProperty(exports, "__esModule", { value: true });
const path = require("path");
//import * as net from 'net';
const vscode_jsonrpc_1 = require("vscode-jsonrpc");
const vscode_1 = require("vscode");
const vscode_languageclient_1 = require("vscode-languageclient");
let lc;
function activate(context) {
    /*** this is for starting the server as part of the extension */
    let executable = process.platform == 'win32' ? 'org.butterflylabs.zilliqa.xtext.ide.bat' : 'org.butterflylabs.zilliqa.xtext.ide';
    let serverLauncher = context.asAbsolutePath(path.join('org.butterflylabs.zilliqa.xtext.ide', 'bin', executable));
    let serverOptions = {
        run: { command: serverLauncher, args: ['-Xdebug', '-Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n,quiet=y', '-Xmx256m'] },
        debug: { command: serverLauncher, args: ['-Xdebug', '-Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n,quiet=y', '-Xmx256m'] }
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
    let clientOptions = {
        documentSelector: ['scilla'],
        synchronize: {
            fileEvents: vscode_1.workspace.createFileSystemWatcher('**/*.*')
        }
    };
    lc = new vscode_languageclient_1.LanguageClient('Xtext Server', serverOptions, clientOptions);
    var disposable2 = vscode_1.commands.registerCommand("scilla.a.proxy", () => __awaiter(this, void 0, void 0, function* () {
        let activeEditor = vscode_1.window.activeTextEditor;
        if (!activeEditor || !activeEditor.document || activeEditor.document.languageId !== 'scilla') {
            return;
        }
        if (activeEditor.document.uri instanceof vscode_1.Uri) {
            vscode_1.commands.executeCommand("scilla.a", activeEditor.document.uri.toString());
        }
    }));
    context.subscriptions.push(disposable2);
    // enable tracing (.Off, .Messages, Verbose)
    lc.trace = vscode_jsonrpc_1.Trace.Verbose;
    let disposable = lc.start();
    // Push the disposable to the context's subscriptions so that the 
    // client can be deactivated on extension deactivation
    context.subscriptions.push(disposable);
}
exports.activate = activate;
function deactivate() {
    if (!lc) {
        return undefined;
    }
    return lc.stop();
}
exports.deactivate = deactivate;
//# sourceMappingURL=extension.js.map