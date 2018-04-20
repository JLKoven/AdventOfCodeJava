package main.day13;

public class FirewallLayer {
	


	private int firewallIndex;
	private int range;
	private int currentLocation=0;
	private boolean descending=true;
	
	public int getFirewallIndex() {
		return firewallIndex;
	}
	public void setFirewallIndex(int firewallIndex) {
		this.firewallIndex = firewallIndex;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public int getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(int currentLocation) {
		this.currentLocation = currentLocation;
	}
	public boolean isDescending() {
		return descending;
	}
	public void setDescending(boolean descending) {
		this.descending = descending;
	}

}
