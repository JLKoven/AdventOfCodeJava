import java.util.HashMap;
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

	
}