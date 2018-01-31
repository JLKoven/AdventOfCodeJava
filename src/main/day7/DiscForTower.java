package main.day7;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class DiscForTower {
	

	private String name;
	private Integer value;
	private List<String> namesOfDescendants = new ArrayList<String>();
	private List<DiscForTower> descendants = new ArrayList<DiscForTower>();//could be a Set instead of a list, I dunno
	
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
	public Integer getSumValue() {
		Integer sumValue = getValue();
		Stack<DiscForTower> stackOfChildren = new Stack<DiscForTower>();
		for (DiscForTower descendant : getDescendants()){
			stackOfChildren.push(descendant);
		}
		while (!(stackOfChildren.isEmpty())){
			sumValue = sumValue + stackOfChildren.peek().getValue();
			DiscForTower currentNode = stackOfChildren.pop();
			for (DiscForTower descendant : currentNode.getDescendants()){
				stackOfChildren.push(descendant);
			}
		}
		return sumValue;
	}
	public Integer sumValueOfChildren(
//			, Stack<DiscForTower> stackOfChildren
//			, Integer sumValue
			){
		Integer sumValue =0;
		Stack<DiscForTower> stackOfChildren = new Stack<DiscForTower>();
		for (DiscForTower descendant : getDescendants()){
			stackOfChildren.push(descendant);
		}
		while (!(stackOfChildren.isEmpty())){
			sumValue = sumValue + stackOfChildren.peek().getValue();
			DiscForTower currentNode = stackOfChildren.pop();
			for (DiscForTower descendant : currentNode.getDescendants()){
				stackOfChildren.push(descendant);
			}
		}
		return sumValue;
	}
	public boolean isUnbalanced() {
		boolean boolToReturn = false;
		if (!getDescendants().isEmpty()){
			int firstVal = getDescendants().get(0).getSumValue();
			for (int i=0; i<getDescendants().size(); i++){
				if (firstVal != getDescendants().get(i).getSumValue()){
					boolToReturn = true;
				}
			}
		}
		return boolToReturn;
	}

	public int getDiscrepancyValue() {
		int intToReturn=0;
		if (!getDescendants().isEmpty()){
			int firstVal = getDescendants().get(0).getSumValue();
			for (int i=0; i<getDescendants().size(); i++){
				if (firstVal != getDescendants().get(i).getSumValue()){
					intToReturn = firstVal - getDescendants().get(i).getSumValue();
				}
			}
		}
		return intToReturn;
	}
	
//	public DiscForTower getUnbalancedDisc() {
//		
//		if (!getDescendants().isEmpty()){
//			int firstVal = getDescendants().get(0).getSumValue();
//			for (int i=0; i<getDescendants().size(); i++){
//				if (firstVal != getDescendants().get(i).getSumValue()){
//					boolToReturn = true;
//				}
//			}
//		}
//		return discToReturn;
//	}

}
