import java.util.List;

public class DayTwo {

	// part 1

	public static int getRowSum(int[] sampleRow) {
		int sum = 0;
		int lowest = sampleRow[0];
		int highest = sampleRow[0];
		for (int i = 0; i < sampleRow.length; i++) {
			// highest = (sampleRow[i] > highest) ? sampleRow[i] : highest;
			if (sampleRow[i] > highest) {
				highest = sampleRow[i];
			}
			if (sampleRow[i] < lowest) {
				lowest = sampleRow[i];
			}
		}
		return highest - lowest;
	}

	private static int getRowSumDivisionsBruteForce(int[] sampleRow) {
		int result = 0;
		boolean foundResult = false;
		if (sampleRow.length < 2) {
			System.out.println("whoops, array is too small");
		} else {
			for (int i = 0; i < sampleRow.length; i++) {
				for (int v = 1; v < sampleRow.length; v++) {
					if (v != i) {

						if ((double) sampleRow[i] % (double) sampleRow[v] == 0) {
							result = sampleRow[i] / sampleRow[v];
							System.out.println("Found a result! sampleRow[i] is " + sampleRow[i]
									+ " and sampleRow[v] is " + sampleRow[v] + ".");
							foundResult = true;
							i = sampleRow.length;
							v = sampleRow.length;
							break;
						} else if ((double) sampleRow[v] % (double) sampleRow[i] == 0) {
							result = sampleRow[v] / sampleRow[i];
							System.out.println("Found a result! sampleRow[i] is " + sampleRow[i]
									+ " and sampleRow[v] is " + sampleRow[v] + ".");
							foundResult = true;
							i = sampleRow.length;
							v = sampleRow.length;
							break;
						} else {
							// these two numbers don't divide well
						}
					}

				}
			}
		}
		if (!foundResult) {
			System.out.println("Didn't find one :(");
		}
		return result;
	}

	public static int getListRowSum(List<int[]> listOfArrays) {
		int sum = 0;
		for (int i = 0; i < listOfArrays.size(); i++) {
			sum = sum + getRowSum(listOfArrays.get(i));
		}
		return sum;
	}

	public static int getListRowSumDivisions(List<int[]> listOfArrays) {
		int sum = 0;
		for (int i = 0; i < listOfArrays.size(); i++) {
			sum = sum + getRowSumDivisionsBruteForce(listOfArrays.get(i));
		}
		return sum;
	}

}
