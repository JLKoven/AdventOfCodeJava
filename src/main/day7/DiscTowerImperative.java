package main.day7;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DiscTowerImperative {
	
	private DiscForTowerImperative base;	
	private Map<String, DiscForTowerImperative> dictionary;

	public static DiscTowerImperative formNewTowerFrom(List<DiscForTowerImperative> inputList) {
		DiscTowerImperative outputTower = new DiscTowerImperative();
		
		Map<String, DiscForTowerImperative> dictionary = createDictionary(inputList);
		
		Set<String> visited = new HashSet<String>();
		for (int i=0; i<inputList.size(); i++){
			if (!inputList.get(i).getNamesOfDescendants().isEmpty()){
				for (String name : inputList.get(i).getNamesOfDescendants()){
					visited.add(name);
				}
			}
		}
		
		outputTower.setDictionary(dictionary);
		
		for (DiscForTowerImperative disc : inputList){
			List<DiscForTowerImperative> nodesToSet = new ArrayList<DiscForTowerImperative>();
			for (String name : disc.getNamesOfDescendants()){
				nodesToSet.add(dictionary.get(name));
			}
			disc.setDescendants(nodesToSet);
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
		
		return outputTower;
	}

	private static Map<String, DiscForTowerImperative> createDictionary(List<DiscForTowerImperative> inputList) {
		Map<String, DiscForTowerImperative> dictionary = new HashMap<String, DiscForTowerImperative>();
		for (DiscForTowerImperative disc : inputList){
			dictionary.put(disc.getName(), disc);
		}
		return dictionary;
	}


	public DiscForTowerImperative getBase() {
		return base;
	}

	public void setBase(DiscForTowerImperative base) {
		this.base = base;
	}

	public Map<String, DiscForTowerImperative> getDictionary() {
		return dictionary;
	}

	public void setDictionary(Map<String, DiscForTowerImperative> dictionary) {
		this.dictionary = dictionary;
	}


}
