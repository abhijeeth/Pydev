/*
 * Author: atotic
 * Created: Jun 23, 2003
 * License: Common Public License v1.0
 */
package org.python.pydev.plugin;

import org.eclipse.core.runtime.Preferences;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * Pydev preference page
 * 
 * Uses FieldEditor framework for preference editing
 * Defaults are declared here as constants.
 * There is a string constant for every prefernce you can use for access
 * Framework takes care of storing of the prefs
 */
public class PydevPrefs extends FieldEditorPreferencePage 
	implements IWorkbenchPreferencePage{

	// Preferences	
	public static final String SUBSTITUTE_TABS = "SUBSTITUTE_TABS";
	public static final String CODE_COLOR = "CODE_COLOR";
	private static final RGB DEFAULT_CODE_COLOR = new RGB(0, 0, 0);
	public static final String KEYWORD_COLOR = "KEYWORD_COLOR";
	private static final RGB DEFAULT_KEYWORD_COLOR = new RGB(160, 32, 240);
	public static final String STRING_COLOR = "STRING_COLOR";
	private static final RGB DEFAULT_STRING_COLOR = new RGB(120, 130, 61);
	public static final String COMMENT_COLOR = "COMMENT_COLOR";
	private static final RGB DEFAULT_COMMENT_COLOR = new RGB(178, 34, 34);

	/**
	 * Initializer sets the preference store
	 */
	public PydevPrefs() {
		super(GRID);
		setPreferenceStore(PydevPlugin.getDefault().getPreferenceStore());
	}

	public void init(IWorkbench workbench) {		
	}
	
	/**
	 * Creates the editors
	 */
	protected void createFieldEditors() {
		Composite p = getFieldEditorParent();
		addField(new BooleanFieldEditor(
			SUBSTITUTE_TABS, "Substitute spaces for tabs?", p));
		addField(new ColorFieldEditor(
			CODE_COLOR, "Code", p));
		addField(new ColorFieldEditor(
			KEYWORD_COLOR, "Keywords", p));
		addField(new ColorFieldEditor(
			STRING_COLOR, "Strings", p));
		addField(new ColorFieldEditor(
			COMMENT_COLOR, "Comments", p));
	}
	
	/**
	 * Sets default preference values
	 */
	protected static void initializeDefaultPreferences(Preferences prefs) {
		prefs.setDefault(SUBSTITUTE_TABS, true);
		prefs.setDefault(CODE_COLOR,StringConverter.asString(DEFAULT_CODE_COLOR));
		prefs.setDefault(KEYWORD_COLOR,StringConverter.asString(DEFAULT_KEYWORD_COLOR));
		prefs.setDefault(STRING_COLOR,StringConverter.asString(DEFAULT_STRING_COLOR));
		prefs.setDefault(COMMENT_COLOR,StringConverter.asString(DEFAULT_COMMENT_COLOR));
	}
}
