package main.day13;

import java.util.ArrayList;
import java.util.List;

public class Firewall {
	

	private int value = 0;
	private int maxDepth = 0;
	private List<FirewallLayer> firewallLayers = new ArrayList<>();
	
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
	public List<FirewallLayer> getFirewallLayers() {
		return firewallLayers;
	}
	public void setFirewallLayers(List<FirewallLayer> firewallLayers) {
		this.firewallLayers = firewallLayers;
	}


}
