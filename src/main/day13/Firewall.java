package main.day13;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Firewall {
	

	private int value = 0;
	private int maxDepth = 0;
	private Map<Integer, FirewallLayer> firewallLayers = new HashMap<>();
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getMaxDepth() {
		return maxDepth;
	}
	public void setMaxDepth(int maxDepth) {
		this.maxDepth = maxDepth;
	}
	public Map<Integer, FirewallLayer> getFirewallLayers() {
		return firewallLayers;
	}
	public void setFirewallLayers(Map<Integer, FirewallLayer> firewallLayers) {
		this.firewallLayers = firewallLayers;
	}
	
	public void incrementCounter(int positionOfPacket){
		if (getFirewallLayers().containsKey(positionOfPacket)){
			FirewallLayer present = getFirewallLayers().get(positionOfPacket);
			if (0 == present.getCurrentLocation()){
				Integer currentPenalty = getValue();
				Integer newPenalty = (present.getRange() * positionOfPacket);
				Integer newCombinedPenalty = currentPenalty+newPenalty ;
				setValue(newCombinedPenalty);
			} else {
				//move on, firewallLayer didn't hit
			}
						
		} else {
			//move on, no firewallLayer here
		}
	}
	
	void tick(){
		Map<Integer, FirewallLayer> fireWall = getFirewallLayers();
//		Collection<FirewallLayer> layers = fireWall.values();
		for (FirewallLayer layer : fireWall.values()){
			layer.tick();
		}
		//do I need to call another set?
		
		setFirewallLayers(fireWall);
	}


}
