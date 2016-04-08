`${clipboard}` editor variable for oXygen [![Release](https://img.shields.io/github/release/paginagmbh/oxygen-plugin_clipboard-editor-variable.svg)](https://github.com/paginagmbh/oxygen-plugin_clipboard-editor-variable/releases/latest)
============================================

This plugin adds support for a `${clipboard}` editor variable in <oXygen/> XML Editor.

When using `${clipboard}` (e.g. in a code template) it will insert the contents from your clipboard in **plain text**.

The editor variable may be used in all contexts where oXygen allows to use editor variables.
However it will not show up in the context menu of the "green arrow button variable chooser"!


Download & Install
------------------

1. Check the [releases page](https://github.com/paginagmbh/oxygen-plugin_clipboard-editor-variable/releases) to get the latest distribution.
2. Download and unzip the file.
3. Copy the folder `clipboardEditorVariable/` to your local oXygen plugin directory
  * _e.g. `C:\Program Files\Oxygen XML Editor 17\plugins\`_
4. Restart oXygen


Building the plugin
-------------------

### Packaging

Run `mvn clean package` to trigger a ZIP + folder build in `target/` directory:

* `target/clipboardEditorVariable.zip`
* `target/clipboardEditorVariable/`

### Install to Maven

Run `mvn clean install` to install the current version of the plugin in your local Maven repository.

### Debugging

To debug plugin internals follow the oXygen users guide at https://www.oxygenxml.com/doc/versions/17.1/ug-editor/index.html#topics/debug-plugin.html

### Deploy to oXygen

On Mac OS X you can deploy the plugin automatically to the oXygen plugins directory in `/Applications/OXYGEN-DIR/plugins/`

### Commandline (Mac only)
`mvn clean install -Doxygen.plugins.dir=/Applications/oxygen-17/plugins/`

### Eclipse (Windows & Mac)
* Add a Maven launch scenario
* Set the _Goal_ to `install`
* Add a new _Parameter_:
  * _Name:_ `oxygen.plugins.dir`
  * _Value:_ `/Applications/oxygen-17/plugins/`
