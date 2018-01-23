import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayOne {
	
	//part 1

	public static int printAnswerGeneric(String input, Character lastChar){//, Character firstChar) {
		int sum=0;
		Character currentChar;
		Character previousChar = lastChar;
		
		for (int i=0; i<input.length(); i++){
			currentChar = input.charAt(i);
			if (currentChar == previousChar){
				sum = sum+(Integer.parseInt(currentChar.toString()));
			}
			previousChar = currentChar;
		}
		return sum;
	}



	public static int printAnswerSingleInput(String input) {
		return printAnswerGeneric(input, input.charAt(input.length()-1));
//		return printAnswerGeneric(input, input.charAt(input.length()-1), input.charAt(0));
	}



	public static int printAnswerDayOne(List<String> stringList) {
		int sum = 0;
		for (int i = 0; i < stringList.size(); i++) {
			if (i != 0) {
				sum = sum + (printAnswerGeneric(stringList.get(i),
						stringList.get(i - 1).charAt(stringList.get(i - 1).length() - 1)));
			} else {
				sum = sum + (printAnswerGeneric(stringList.get(i), stringList.get(stringList.size() - 1)
						.charAt(stringList.get(stringList.size() - 1).length() - 1)));
			}
		}
		System.out.println(sum);
		return sum;
	}



	public static int printAnswerDayTwo(List<String> stringList) {
		int answer = 0;
		CircularArray circularArray = streamInStringList(stringList);
		for (int i=0; i<(circularArray.getArrayAsList().size()/2); i++){
			if (circularArray.getArrayAsList().get(i).getValue() 
					== 
					circularArray.getArrayAsList()
					.get(i+
							(circularArray.getArrayAsList().size()/2)
							).getValue()){
				answer = answer+circularArray.getArrayAsList().get(i).getValue();
				//System.out.println("circularArray.getArrayAsList().get(i).getValue() is "+circularArray.getArrayAsList().get(i).getValue()+".");
			}
		}
		return answer*2;
	}



	private static CircularArray streamInStringList(List<String> stringList) {
		CircularArray arrayToReturn = new CircularArray();
		int i=0;
		for (int v=0; v<stringList.size(); v++){
			String stringToStream = stringList.get(v);
			for (int c=0; c<stringToStream.length(); c++){
				List<CircularArrayNode> nodeList = new ArrayList<CircularArrayNode>();
				if (arrayToReturn.getArrayAsList()!= null){
					nodeList = arrayToReturn.getArrayAsList();
				} else {
//					List<CircularArrayNode> nodeList = new ArrayList<CircularArrayNode>();
				}
				CircularArrayNode nodeToAdd = new CircularArrayNode();
//				nodeToAdd.setIndex(i);
				Character characterToConvert = stringToStream.charAt(c);
				nodeToAdd.setValue(Integer.parseInt(characterToConvert.toString()));
				i++;
				nodeList.add(nodeToAdd);
				arrayToReturn.setArrayAsList(nodeList);
			}
		}
		return arrayToReturn;
	}

	
}