package de.paginagmbh.oxygen.clipboardEditorVariable;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ro.sync.exml.plugin.workspace.WorkspaceAccessPluginExtension;
import ro.sync.exml.workspace.api.standalone.StandalonePluginWorkspace;
import ro.sync.exml.workspace.api.util.EditorVariableDescription;
import ro.sync.exml.workspace.api.util.EditorVariablesResolver;


/**
 * @author Tobias Fischer
 * @copyright pagina GmbH, Tübingen
 * @email tobias.fischer@pagina-tuebingen.de
 */
public class ClipboardEditorVariablePluginExtension implements WorkspaceAccessPluginExtension {

	@Override
	public void applicationStarted(StandalonePluginWorkspace pluginWorkspaceAccess) {
		pluginWorkspaceAccess.getUtilAccess().addCustomEditorVariablesResolver(new EditorVariablesResolver() {

			/**
			 * @see ro.sync.exml.workspace.api.util.EditorVariablesResolver#getCustomResolverEditorVariableDescriptions()
			 * @since 18.1.0.0
			 */
			@Override
			public List<EditorVariableDescription> getCustomResolverEditorVariableDescriptions() {
				List<EditorVariableDescription> customEditorVariables = new ArrayList<EditorVariableDescription>();
				customEditorVariables.add(new EditorVariableDescription("${clipboard}", "Inserts the content from your clipboard in plain text"));
				return customEditorVariables;
			}

			/**
			 * @see ro.sync.exml.workspace.api.util.EditorVariablesResolver#resolveEditorVariables(java.lang.String, java.lang.String)
			 */
			@Override
			public String resolveEditorVariables(String contentWithEditorVariables, String currentEditedFileURL) {
				String clipboardPattern = "clipboard";
				if(contentWithEditorVariables != null && contentWithEditorVariables.contains("${" + clipboardPattern + "}")){
					Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
					try {
						String clipboardData = (String) clipboard.getData(DataFlavor.stringFlavor);
						return contentWithEditorVariables.replaceAll("\\$\\{" + clipboardPattern + "\\}", clipboardData);

					} catch (UnsupportedFlavorException | IOException e) {
						// error: don't replace variable
						return contentWithEditorVariables;
					}
				}
				return contentWithEditorVariables;
			}
		});
	}

	@Override
	public boolean applicationClosing() {
		return true;
	}
}
