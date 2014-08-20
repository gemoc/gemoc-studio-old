/*******************************************************************************
 * Copyright (c) 2013 Obeo. All Rights Reserved.
 *
 * This software and the attached documentation are the exclusive ownership
 * of its authors and was conceded to the profit of Obeo SARL.
 * This software and the attached documentation are protected under the rights
 * of intellectual ownership, including the section "Titre II  Droits des auteurs (Articles L121-1 L123-12)"
 * By installing this software, you acknowledge being aware of this rights and
 * accept them, and as a consequence you must:
 * - be in possession of a valid license of use conceded by Obeo only.
 * - agree that you have read, understood, and will comply with the license terms and conditions.
 * - agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries
 * or the authors of this software
 *
 * Should you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.
 *
 *******************************************************************************/
package org.gemoc.gemoc_language_workbench.process.specific;

import fr.obeo.dsl.process.IProcessRunner;

import org.gemoc.gemoc_language_workbench.process.ProcessRunner;

/**
 * The Gemoc language {@link IProcessRunner}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class GemocLanguageProcessRunner extends ProcessRunner
{

	/**
	 * Constructor.
	 */
	public GemocLanguageProcessRunner(GemocLanguageProcessContext processContext) 
	{
		super("/process/gemoc_language.process", processContext);
	
		// Resource resource = new XMIResourceImpl();
		// try
		// {
		// InputStream is =
		// GemocLanguageProcessRunner.class.getResourceAsStream("/process/gemoc_language.process");
		// resource.load(is, new HashMap<String, String>());
		// }
		// catch (IOException e)
		// {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// _process = (Process)resource.getContents().get(0);
//		GemocLanguageProcessContext processContext = new GemocLanguageProcessContext();
//		processContext.setDefinition(getProcess());
//		processContext.initialize(xdsmlUri);
	}

	public GemocLanguageProcessContext getCastedContext() {
		return (GemocLanguageProcessContext)getContext();
	}

}
