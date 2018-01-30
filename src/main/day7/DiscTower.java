package main.day7;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DiscTower {
	
	private DiscForTower base;	
	private Map<String, DiscForTower> dictionary;// = createDictionary(inputList);

	public static DiscTower formNewTowerFrom(List<DiscForTower> inputList) {
		DiscTower outputTower = new DiscTower();
		
		Map<String, DiscForTower> dictionary = createDictionary(inputList);
		
//		Set<DiscForTower> visited = new HashSet<DiscForTower>();
		Set<String> visited = new HashSet<String>();
		for (int i=0; i<inputList.size(); i++){
			if (!inputList.get(i).getNamesOfDescendants().isEmpty()){
				for (String name : inputList.get(i).getNamesOfDescendants()){
					visited.add(name);
				}
			}
		}
		
		for (String name : dictionary.keySet()){
			if (!visited.contains(
					name
					)){
				outputTower.setBase(dictionary.get(
						name
						));
				break;
			}
		}
		
//		for (int i=0; i<inputList.size(); i++){
//			if (!visited.contains(
//					
//					)){
//				outputTower.setBase(dictionary.get(
//						inputList.get(i).getName()
//						));
//				break;
//			}
//		}
		outputTower.setDictionary(dictionary);
		return outputTower;
	}

	private static Map<String, DiscForTower> createDictionary(List<DiscForTower> inputList) {
		Map<String, DiscForTower> dictionary = new HashMap<String, DiscForTower>();
		for (DiscForTower disc : inputList){
			dictionary.put(disc.getName(), disc);
		}
		return dictionary;
	}

//	private static DiscForTower getDiscWithThisName(String name) {
//		DiscForTower disc = new DiscForTower();
//		// TODO Auto-generated method stub
//		return disc;
//	}

	public DiscForTower getBase() {
		return base;
	}

	public void setBase(DiscForTower base) {
		this.base = base;
	}

	public Map<String, DiscForTower> getDictionary() {
		return dictionary;
	}

	public void setDictionary(Map<String, DiscForTower> dictionary) {
		this.dictionary = dictionary;
	}

}
