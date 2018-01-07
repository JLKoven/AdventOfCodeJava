import java.util.List;

public class DayTwo {

	public static int getRowSum(int[] sampleRow) {
		int sum = 0;
		int lowest = sampleRow[0];
		int highest = sampleRow[0];
		for (int i=0; i<sampleRow.length; i++){
//			highest = (sampleRow[i] > highest) ? sampleRow[i] : highest;
			if (sampleRow[i] > highest){
				highest = sampleRow[i];
			}
			if (sampleRow[i] < lowest){
				lowest = sampleRow[i];
			}
		}
		return highest - lowest;
	}

	public static int getListRowSum(List<int[]> listOfArrays) {
		int sum = 0;
		for (int i=0; i<listOfArrays.size(); i++){
			sum = sum + getRowSum(listOfArrays.get(i));
		}
		return sum;
	}

}
