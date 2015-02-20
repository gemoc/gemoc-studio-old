package org.gemoc.sigpmlextended.k3dsa;

import java.util.Map;
import sigpmlextended.Place;
import org.gemoc.sigpmlextended.k3dsa.PlaceAspectPlaceAspectProperties;

@SuppressWarnings("all")
public class PlaceAspectPlaceAspectContext {
  public final static PlaceAspectPlaceAspectContext INSTANCE = new PlaceAspectPlaceAspectContext();
  
  public static PlaceAspectPlaceAspectProperties getSelf(final Place _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sigpmlextended.k3dsa.PlaceAspectPlaceAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Place, PlaceAspectPlaceAspectProperties> map = new java.util.HashMap<sigpmlextended.Place, org.gemoc.sigpmlextended.k3dsa.PlaceAspectPlaceAspectProperties>();
  
  public Map<Place, PlaceAspectPlaceAspectProperties> getMap() {
    return map;
  }
}
