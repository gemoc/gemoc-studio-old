/*$Id: WarningMessage.java 12250 2010-08-20 11:20:47Z dvojtise $
* Project : fr.irisa.triskell.kermeta.kpm
* File : 	sdfg.java
* License : EPL
* Copyright : IRISA / INRIA / Universite de Rennes 1
* ----------------------------------------------------------------------------
* Creation date : Feb 20, 2007
* Authors : ftanguy
*/
package org.eclipse.gemoc.commons.eclipse.messagingsystem.ui.internal.console.message;


public class WarningMessage extends ConsoleMessage {

	public WarningMessage(String content) {
		super(content, ConsoleMessage.WARNING);
	}
	
}
