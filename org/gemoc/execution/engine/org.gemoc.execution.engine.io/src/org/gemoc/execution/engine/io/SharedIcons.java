package org.gemoc.execution.engine.io;

import java.util.HashMap;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

public class SharedIcons {

	public static ImageDescriptor ENGINE_ICON = ImageDescriptor.createFromFile(SharedIcons.class, "/icons/settings-5-16.png");
	
	public static ImageDescriptor LOGICALSTEP_ICON = ImageDescriptor.createFromFile(SharedIcons.class, "/icons/footprints-cat-16.png");
	
	public static ImageDescriptor VISIBLE_EVENT_ICON = ImageDescriptor.createFromFile(SharedIcons.class, "/icons/visible-16.png");
		
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
