package main.year2017.day13;


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

	
	public void tick() {
		if (this.descending){
			//increment change by 1
			if (this.range==this.currentLocation){
				setDescending(false);
				setCurrentLocation(getCurrentLocation()-1);
			} else {
				setCurrentLocation(getCurrentLocation()+1);
			}
		} else {//not descending
			//increment change by 1
			if (0==this.currentLocation){
				setDescending(true);
				setCurrentLocation(getCurrentLocation()+1);
			} else {
				setCurrentLocation(getCurrentLocation()-1);
				
			}
		}
		
	}
	public boolean couldBeZeroAtGivenTime(Integer secondsElapsed) {
		boolean value = false;
		if (0 == secondsElapsed % ((this.getRange()*2))){
			value = true;
		} //else {}
		return value;
	}
	
	
}
