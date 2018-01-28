package main.day7;
import java.util.ArrayList;
import java.util.List;

public class GeneralFunction {

	public static Integer[] shallowCopyOfArray(Integer[] arrayToBeCopied) {

		Integer[] newArray = new Integer[arrayToBeCopied.length];
		for (int i=0; i<arrayToBeCopied.length; i++){
			newArray[i] = arrayToBeCopied[i];
		}
		return newArray;
	}
	
//ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(array)
	
	public static List<Integer> shallowCopyOfArrayList(List<Integer> arrayToBeCopied) {
		List<Integer> newList = new ArrayList<Integer>();
		for (Integer value : arrayToBeCopied){
			newList.add(value);
		}
		return newList;
	}

	public static void systemPrintArrayList(List<Integer> array) {
		for (Integer integer : array){
			System.out.print(integer);
			System.out.print(" ");
		}
		
	}



	public static String removeNonNumericLeaveDashAndDot(String inputString) {
		String outputString = inputString.replaceAll("[^\\d.-]", "");;
		return outputString;
	}
	
	public static String removeWhitespace(String inputString) {
		String outputString = inputString.replaceAll(" ", "");;
		return outputString;
	}

}
