package main.day7;
import java.util.ArrayList;
import java.util.List;

public class DaySeven {

	public static String printAnswerPartOne(DiscTower outputTower) {
		String stringToReturn = "";
		// TODO Auto-generated method stub
		return stringToReturn ;
	}

	public static List<DiscForTower> generateListOfDiscsFromStringInput(List<String> stringInput) {
		List<DiscForTower> resultingList = new ArrayList<DiscForTower>();
		for (int i=0; i<stringInput.size(); i++){
			String[] parts = stringInput.get(i).split("->");
			String source = parts[0]; 
			DiscForTower newDisc = new DiscForTower();	
			String[] sourceParts = source.split(" ");
			newDisc.setName(sourceParts[0]);
			System.out.println("sourceParts[1] is "+sourceParts[1]+".");
			System.out.println("GeneralFunction.removeNonNumericLeaveDashAndDot(sourceParts[1]) is "+GeneralFunction.removeNonNumericLeaveDashAndDot(sourceParts[1])+".");
			System.out.println("Integer.parseInt(GeneralFunction.removeNonNumericLeaveDashAndDot(sourceParts[1])) is "+Integer.parseInt(GeneralFunction.removeNonNumericLeaveDashAndDot(sourceParts[1]))+".");
//			newDisc.setValue(Integer.getInteger(GeneralFunction.removeNonNumericLeaveDashAndDot(sourceParts[1])));
			newDisc.setValue(Integer.parseInt(GeneralFunction.removeNonNumericLeaveDashAndDot(sourceParts[1])));
			if (parts.length>1){
				String results = parts[1]; 
				String[] resultsParts = results.split(", ");
				resultsParts[0] = GeneralFunction.removeNonNumericLeaveDashAndDot(resultsParts[0]);
				List<String> listOfNames = newDisc.getNamesOfDescendants();
				for (int v=0; v<resultsParts.length; v++){
					listOfNames.add(resultsParts[v]);
				}
				newDisc.setNamesOfDescendants(listOfNames);
			}
			resultingList.add(newDisc);
			
			
		}
		return resultingList ;
		// TODO Auto-generated method stub
		
	}

}
