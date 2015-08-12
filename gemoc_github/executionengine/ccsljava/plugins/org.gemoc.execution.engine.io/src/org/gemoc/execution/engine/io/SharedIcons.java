package org.gemoc.execution.engine.io;

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
	
	public static ImageDescriptor LOGICALSTEP_ICON = ImageDescriptor.createFromFile(SharedIcons.class, "/icons/footprints-cat-16.png");
	
	public static ImageDescriptor LOGICALSTEP_RUNNING_ICON = ImageDescriptor.createFromFile(SharedIcons.class, "/icons/footprints-running-cat-16.png");
	
	public static ImageDescriptor VISIBLE_EVENT_ICON = ImageDescriptor.createFromFile(SharedIcons.class, "/icons/visible-16.png");

	public static ImageDescriptor PAST_CHOSEN_LOGICALSTEP_ICON = ImageDescriptor.createFromFile(SharedIcons.class, "/icons/circle-blue-16.png");
	public static ImageDescriptor PAST_POSSIBLE_LOGICALSTEP_ICON = ImageDescriptor.createFromFile(SharedIcons.class, "/icons/circle-blue-outline-16.png");
	public static ImageDescriptor PRESENT_CHOSEN_LOGICALSTEP_ICON = ImageDescriptor.createFromFile(SharedIcons.class, "/icons/circle-green-16.png");
	public static ImageDescriptor PRESENT_POSSIBLE_LOGICALSTEP_ICON = ImageDescriptor.createFromFile(SharedIcons.class, "/icons/circle-green-outline-16.png");
	public static ImageDescriptor FUTUR_CHOSEN_LOGICALSTEP_ICON = ImageDescriptor.createFromFile(SharedIcons.class, "/icons/circle-yellow-16.png");
	public static ImageDescriptor FUTUR_POSSIBLE_LOGICALSTEP_ICON = ImageDescriptor.createFromFile(SharedIcons.class, "/icons/circle-yellow-outline-16.png");
	
	public static ImageDescriptor FORCED_CLOCK_SET = ImageDescriptor.createFromFile(SharedIcons.class, "/icons/new-forced-to-1-16.png");
	public static ImageDescriptor FORCED_CLOCK_NOTSET = ImageDescriptor.createFromFile(SharedIcons.class, "/icons/new-forced-to-0-16.png");
	public static ImageDescriptor NOTFORCED_CLOCK_SET = ImageDescriptor.createFromFile(SharedIcons.class, "/icons/new-free-to-1-16.png");
	public static ImageDescriptor NOTFORCED_CLOCK_NOTSET = ImageDescriptor.createFromFile(SharedIcons.class, "/icons/new-free-to-0-16.png");
	public static ImageDescriptor INDECISION = ImageDescriptor.createFromFile(SharedIcons.class, "/icons/decision-16.png");

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
