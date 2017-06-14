/*$Id:  $
* License : EPL
* Copyright : IRISA / INRIA 
* ----------------------------------------------------------------------------
* Creation date : 9 août 2011
* Authors : 
*      Didier Vojtisek <didier.vojtisek@inria.fr>
*/
package org.eclipse.gemoc.commons.eclipse.messagingsystem.ui.internal;


import java.io.IOException;
import java.io.OutputStream;

import org.eclipse.gemoc.commons.eclipse.messagingsystem.ui.internal.console.ConsoleIO;
import org.eclipse.gemoc.commons.eclipse.messagingsystem.ui.internal.console.message.ErrorMessage;

/**
 * Stream dedicated to redirecting OutputStream to a ConsoleIO
 * (Note: we cannot simply use the ConsoleIO outputstream since it may change over time (generally due to color changes)
 * It is buffered in order to minimize 
 */
public class EclipseConsoleOutputStream extends OutputStream {

	

	ConsoleIO consoleIO;
	Boolean isErrStream = false;
	
	StringBuffer singleByteBuffer = new StringBuffer();
	
	public EclipseConsoleOutputStream(ConsoleIO consoleIO) {
		this.consoleIO = consoleIO;
	}
	public EclipseConsoleOutputStream(ConsoleIO consoleIO, Boolean isErrStream) {
		this.consoleIO = consoleIO;
		this.isErrStream = isErrStream;
	}

	
	@Override
	public void write(int b) throws IOException {
		byte[] bytes = {new Integer(b).byteValue()};
		String s = new String(bytes); 
		singleByteBuffer.append(s);
		if(singleByteBuffer.length() > 1024 || b==10 || b==13 ) flush();
	}

	@Override
	public void write(byte[] b) throws IOException {
		String s = new String(b);
		flush(); 
		if(isErrStream){
			consoleIO.print(new ErrorMessage(s));
		}
		else{
			consoleIO.print(s);
		}
	}
	
	
	@Override
	public synchronized void flush() throws IOException {
		super.flush();
		if(isErrStream){
			consoleIO.print(singleByteBuffer.toString());
		}
		else{
			consoleIO.print(singleByteBuffer.toString());
		}
		singleByteBuffer = new StringBuffer();
	}
	
	@Override
	public void close() throws IOException {
		flush();
		super.close();
	}
	
	

}
