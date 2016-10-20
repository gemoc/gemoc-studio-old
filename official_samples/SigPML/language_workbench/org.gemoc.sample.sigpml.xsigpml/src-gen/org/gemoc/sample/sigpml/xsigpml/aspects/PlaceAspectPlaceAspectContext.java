package org.gemoc.sample.sigpml.xsigpml.aspects;

import java.util.Map;
import org.gemoc.sample.sigpml.xsigpml.sigpml.Place;
import org.gemoc.sample.sigpml.xsigpml.aspects.PlaceAspectPlaceAspectProperties;

@SuppressWarnings("all")
public class PlaceAspectPlaceAspectContext {
  public final static PlaceAspectPlaceAspectContext INSTANCE = new PlaceAspectPlaceAspectContext();
  
  public static PlaceAspectPlaceAspectProperties getSelf(final Place _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.sigpml.xsigpml.aspects.PlaceAspectPlaceAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Place, PlaceAspectPlaceAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.sigpml.xsigpml.sigpml.Place, org.gemoc.sample.sigpml.xsigpml.aspects.PlaceAspectPlaceAspectProperties>();
  
  public Map<Place, PlaceAspectPlaceAspectProperties> getMap() {
    return map;
  }
}
