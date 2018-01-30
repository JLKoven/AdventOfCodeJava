package main.day7;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class DiscForTower {
	

	private String name;
	private Integer value;
	private List<String> namesOfDescendants = new ArrayList<String>();
//	private List<DiscForTower> descendants = new ArrayList<DiscForTower>();
	
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
//	public List<DiscForTower> getDescendants() {
//		return descendants;
//	}
//	public void setDescendants(List<DiscForTower> descendants) {
//		this.descendants = descendants;
//	}
	
	public Integer directValueOfChildren(Map<String, DiscForTower> dictionary
//			, Stack<DiscForTower> stackOfChildren
//			, Integer sumValue
			){
		Integer sumValue = 0;//getValue();
//		System.out.println("Value for me is currently "+sumValue+"");
		Stack<DiscForTower> stackOfChildren = new Stack<DiscForTower>();
		for (String name : getNamesOfDescendants()){
			stackOfChildren.push(dictionary.get(name));
		}
		while (!stackOfChildren.isEmpty()){
			sumValue=sumValue+(stackOfChildren.pop().getValue());
		}
		return sumValue;
			
	}
//	public String sumValueOfChildren(Map<String, DiscForTower> dictionary, Stack<DiscForTower> stackOfChildren) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
