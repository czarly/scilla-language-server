---
title: "Hello Community"
date: 2019-01-09T13:56:23+07:00
draft: false
---
# First public build

As **Zilliqa** is going live soon, I decided to brush up the build scripts
and the repository structure to allow anyone to participate in the
development of the language server for the [**Scilla**](http://scilla-lang.org) programming language
which is the language in which **Zilliqa** smart contracts are deployed.

You can find the repository and the build instructions in the **Github**
[repsitory](https://github.com/czarly/scilla-language-server)

You can download the latest build for inclusion as a plugin
[here](/builds/scilla-vscode-extension-1.0.0.vsix)

to install it to your local **Visual Studio Code** you can open a
terminal and run the following command with the right path to your downlad.

```
code --install-extension /path/to/scilla-vscode-extension-1.0.0.vsix
```

Afterwards you have the plugin available in your workspace and you can
start editing *.scilla files which are already associated with the
plugin.

Beware that you will need **Java** >= 1.8 installed on your system.

The generated plugin supports many features like auto completition
within the file and for using functions provided by the standard
libraries. Formatting and code outline as well as finding references
and jump to definition is implemented.

The usage of the **Xtext** framework as the foundation allows to create
**Eclipse** plugins that can be used as a building block of a
integrated development environment. A complete out of the box
environment based on **Docker** containers is planned as the next
extension, with the goal of setting up new developers at workshops
with the click of a button in a hosted environment.

With the release of **Zilliqa** to the public scaling in a trustless
setting comes a big step closer and I'm excited to contribute my part.
