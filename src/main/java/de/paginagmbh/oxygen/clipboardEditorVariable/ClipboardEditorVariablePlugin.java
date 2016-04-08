package de.paginagmbh.oxygen.clipboardEditorVariable;

import ro.sync.exml.plugin.Plugin;
import ro.sync.exml.plugin.PluginDescriptor;


/**
 * @author Tobias Fischer
 * @copyright pagina GmbH, Tübingen
 * @email tobias.fischer@pagina-tuebingen.de
 */
public class ClipboardEditorVariablePlugin extends Plugin {

	/**
	 * The static plugin instance.
	 */
	private static ClipboardEditorVariablePlugin instance = null;

	/**
	 * Constructs the plugin.
	 *
	 * @param descriptor
	 *            The plugin descriptor
	 */
	public ClipboardEditorVariablePlugin(PluginDescriptor descriptor) {
		super(descriptor);
		if (instance != null) {
			throw new IllegalStateException("Already instantiated!");
		}
		instance = this;
	}

	/**
	 * Get the plugin instance.
	 *
	 * @return the shared plugin instance.
	 */
	public static ClipboardEditorVariablePlugin getInstance() {
		return instance;
	}
}