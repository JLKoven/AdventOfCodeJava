package main.day7;
import java.util.ArrayList;
import java.util.List;

public class DiscForTower {
	

	private String name;
	private Integer value;
	private List<String> namesOfDescendants = new ArrayList<String>();
	private List<DiscForTower> descendants = new ArrayList<DiscForTower>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public List<String> getNamesOfDescendants() {
		return namesOfDescendants;
	}
	public void setNamesOfDescendants(List<String> namesOfDescendants) {
		this.namesOfDescendants = namesOfDescendants;
	}
	public List<DiscForTower> getDescendants() {
		return descendants;
	}
	public void setDescendants(List<DiscForTower> descendants) {
		this.descendants = descendants;
	}

}
