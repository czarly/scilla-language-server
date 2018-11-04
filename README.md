# Scilla Language Server

A analysis server for the smart contract language Scilla following the **language server protocol**.

# Features

The implementation is based on [**Xtext**](https://www.eclipse.org/Xtext/) which is a Eclipse project for building tool support for DSL. Therefore running the language server and the **Visual Studio Code** plugin requires Java to be installed on the machine. The planned features include what is provided by the **Xtext** language server implementation:

 - [x] Syntax Coloring 
 - [x] Error Checking
 - [x] Auto-Completion
 - [ ] Formatting
 - [ ] Hover Information
 - [ ] Mark Occurences
 - [x] Go To Declaration
 - [ ] Rename Refactoring
 - [ ] Toggle Comments
 - [ ] Outline / Structure View
 - [ ] Quick Fix Proposals
 - [x] Find References

# Deployment

Currently a build is provided as a Zip file that can be extracted in your local extension folder for **Visual Studio Code**:

 - Windows:  `%USERPROFILE%\.vscode\extensions`
 - macOS/Linux:  `$HOME/.vscode/extensions`

 It will be associated with *.scillla files and provide basic functionality.

# Known Limitations

The extension loads and parses the source code using a grammar. It's generating recommendations for auto-completition based on context and can import namespaces whose exports are available to the auto-completition and validator as well.

Currently the imported namespaces have to reside in the same folder next to the source code file to be recognized. Imports of libraries other than the standard libraries are possible in the editor but not allowed by **Scilla** at this point in time.

Static fields that are made implicitly available by the runtime (like _balance) do not validate correctly as they are unknown to the AST. Implicit parameters to transitions are not available to the validator and the auto suggestions in the scope of the transition for the same reason as of yet. 

# Roadmap

The more refined parts of the protocol didn't get much attention as the basics have to be carved out. Parsing and Scoping works pretty well already and the language server speaks its protocol. 

Next steps:

 - **Using the generated meta model and update it with implicit parameters and fields**
 - Integrating [**Xsemantics**](https://github.com/eclipse/xsemantics)
   for type checking including classifying variables as functions or values
 - Writing tests

This provided the language server will not give the cosy feeling that I would like it to, but the further changes are more of a cosmetic nature, like proper naming of nodes in the outline view or better tooltips with additional information to elements. 

# Motivation

I took on this project as part of the **Zilliqa** ecosystem grant. I intended to work on parts that where more related to my actual coding experience, but ended up learning something new and finally work with Java again after 6 years of JavaScript. 

Turns out the parser is complicated but the easiest part. All the auto magic impresses at first sight but quickly develops into a bottleneck as it has to be fully understood to be adapted in the way you need it to work. Through the nature of a the task of specifying a new language it's natural for **Xtext** tools to favor you to adapt your DSL instead of the default plumbing, because you can. But they also provide structure and insights that gives a handle to approach the topic in a orderly manner if you have to.

After finishing this project I will be pretty good at parsing, scoping, linking, formatting and probably more. 

# Ideas

Maybe next i can build a compiler. **Xtext** provides a generator to produce any kind of text file from the user defined models. It's straight forward to produce Java source code that can be compiled and executed. But thats probably more useful to generate templates. 

After all through the approach of using a framework to produce a editor component for a framework to build developer tools it might be possible to come up with a integrated development environment for **Zilliqa** based on Eclipse. I'm wary of using the word straight forward here. 

As I understand it, Eclipse has a browser based workspace solution that can be hosted using Docker and extended with standard Eclipse plugins. This might be a way to provide hosted adhoc development environments for teaching programming for **Zilliqa**.
