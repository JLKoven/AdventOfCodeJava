package main.day13;

import java.util.ArrayList;
import java.util.List;

public class FirewallLayer {
	


	private int firewallIndex;
	private int range;
	private int currentLocation=0;
	private boolean descending=true;
//	private List<Integer> listOfTimesAtZero = new ArrayList<>();
	
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
//	public List<Integer> getListOfTimesAtZero() {
//		return listOfTimesAtZero;
//	}
//	public void setListOfTimesAtZero(List<Integer> listOfTimesAtZero) {
//		this.listOfTimesAtZero = listOfTimesAtZero;
//	}
//	public Integer getLatestTimeAtZero(){
//		if (this.getListOfTimesAtZero().isEmpty()){
//			this.addToListOfTimesAtZero();
//		} // else {//do nothing}
//		return (this.getListOfTimesAtZero().get((this.getListOfTimesAtZero().size()-1)));
//	}
//	public void addToListOfTimesAtZero(){
//		if (this.getListOfTimesAtZero().isEmpty()){
//			List<Integer> newListOfTimesAtZero = this.getListOfTimesAtZero();
//			newListOfTimesAtZero.add(0);
//			this.setListOfTimesAtZero(newListOfTimesAtZero);
//		} else {
//			
//			// else {//do nothing}
//		}
//	}
	
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
		//if range is 1, then, if seconds % range+1 = 0;
		boolean value = false;
		System.out.println("secondsElapsed is "+secondsElapsed+", this.getRange() is "+this.getRange()+".");
		if (0 == secondsElapsed % ((this.getRange()*2))){
			System.out.println("found at time "+secondsElapsed+".");
			value = true;
		} else {
			System.out.println("not found at time "+secondsElapsed+".");
		}
		System.out.println(".");
		return value;
	}
	
	//range 1
	//0, now at 0
	//1, now at 1
	//2, now at 0
	//3, now at 1

	//range 3
	//0, now at 0
	//1, now at 1
	//2, now at 2
	//3, now at 3
	//4, now at 2
	//5, now at 1
	//6, now at 0
	//7, now at 1

	
}
