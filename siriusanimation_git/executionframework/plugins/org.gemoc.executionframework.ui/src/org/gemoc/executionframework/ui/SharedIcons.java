package org.gemoc.executionframework.ui;

import java.util.HashMap;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

public class SharedIcons {

	public static ImageDescriptor ENGINE_ICON = ImageDescriptor.createFromFile(SharedIcons.class, "/icons/settings-5-16.png");
	public static ImageDescriptor RUNNING_ENGINE_ICON = ImageDescriptor.createFromFile(SharedIcons.class, "/icons/services-16-green.png");
	public static ImageDescriptor STOPPED_ENGINE_ICON = ImageDescriptor.createFromFile(SharedIcons.class, "/icons/services-16-red.png");
	public static ImageDescriptor WAITING_ENGINE_ICON = ImageDescriptor.createFromFile(SharedIcons.class, "/icons/services-16-blue.png");
	
	public static ImageDescriptor RESUME_ENGINE_DECIDER_ICON = ImageDescriptor.createFromFile(SharedIcons.class, "/icons/resume_co.png");
	public static ImageDescriptor SUSPEND_ENGINE_DECIDER_ICON = ImageDescriptor.createFromFile(SharedIcons.class, "/icons/suspend_co.png");
	
	static HashMap<ImageDescriptor, Image> imageMap = new HashMap<ImageDescriptor, Image>();
	
	static public Image getSharedImage(ImageDescriptor descriptor){
		Image res = imageMap.get(descriptor);
		if(res == null){
			res = descriptor.createImage();
			imageMap.put(descriptor, res);
		}
		return res;
	}
}
