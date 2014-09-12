package org.gemoc.gemoc_language_workbench.conf.presentation;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


/**
 * Wrapper dedicated to support changes on a complex model and to be used as support for a View
 * @author dvojtise
 *
 */
public class ViewModelWrapper {
	  private PropertyChangeSupport changeSupport = 
	      new PropertyChangeSupport(this);

	  public void addPropertyChangeListener(PropertyChangeListener 
	      listener) {
	    changeSupport.addPropertyChangeListener(listener);
	  }

	  public void removePropertyChangeListener(PropertyChangeListener 
	      listener) {
	    changeSupport.removePropertyChangeListener(listener);
	  }

	  public void addPropertyChangeListener(String propertyName,
	      PropertyChangeListener listener) {
	    changeSupport.addPropertyChangeListener(propertyName, listener);
	  }

	  public void removePropertyChangeListener(String propertyName,
	      PropertyChangeListener listener) {
	    changeSupport.removePropertyChangeListener(propertyName, listener);
	  }

	  protected void firePropertyChange(String propertyName, 
	      Object oldValue,
	      Object newValue) {
	    changeSupport.firePropertyChange(propertyName, oldValue, newValue);
	  }
	} 
