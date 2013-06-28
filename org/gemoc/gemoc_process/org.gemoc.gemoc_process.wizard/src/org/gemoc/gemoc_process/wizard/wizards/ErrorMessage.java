package org.gemoc.gemoc_process.wizard.wizards;

public class ErrorMessage {
	
	private String messageError;
	private boolean bActiv;
	
	public ErrorMessage() {
		this.messageError = null;
		this.bActiv = false;
	}
	
	public ErrorMessage(String messageError, boolean bActiv) {
		this.messageError = messageError;
		this.bActiv = bActiv;
	}
	
	public void setActive (boolean bActiv) {
		this.bActiv = bActiv;
	}
	
	public boolean isActive () {
		if (this.bActiv)
			return true;
		else
			return false;
	}
	
	public String getMessageError () {
		return this.messageError;
	}
	
}