import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayOne {

	public static void executeStandardPart1() {
	// --- Day 1: Inverse Captcha ---
	// The night before Christmas, one of Santa's Elves calls you in a panic.
	// "The printer's broken! We can't print the Naughty or Nice List!" By the
	// time you make it to sub-basement 17, there are only a few minutes until
	// midnight. "We have a big problem," she says; "there must be almost fifty
	// bugs in this system, but nothing else can print The List. Stand in this
	// square, quick! There's no time to explain; if you can convince them to
	// pay you in stars, you'll be able to--" She pulls a lever and the world
	// goes blurry.
	//
	// When your eyes can focus again, everything seems a lot more pixelated
	// than before. She must have sent you inside the computer! You check the
	// system clock: 25 milliseconds until midnight. With that much time, you
	// should be able to collect all fifty stars by December 25th.
	//
	// Collect stars by solving puzzles. Two puzzles will be made available on
	// each day millisecond in the advent calendar; the second puzzle is
	// unlocked when you complete the first. Each puzzle grants one star. Good
	// luck!
	//
	// You're standing in a room with "digitization quarantine" written in LEDs
	// along one wall. The only door is locked, but it includes a small
	// interface. "Restricted Area - Strictly No Digitized Users Allowed."
	//
	// It goes on to explain that you may only leave by solving a captcha to
	// prove you're not a human. Apparently, you only get one millisecond to
	// solve the captcha: too fast for a normal human, but it feels like hours
	// to you.
	//
	// The captcha requires you to review a sequence of digits (your puzzle
	// input) and find the sum of all digits that match the next digit in the
	// list. The list is circular, so the digit after the last digit is the
	// first digit in the list.
	//
	// For example:
	//
	// 1122 produces a sum of 3 (1 + 2) because the first digit (1) matches the
	// second digit and the third digit (2) matches the fourth digit.
	// 1111 produces 4 because each digit (all 1) matches the next.
	// 1234 produces 0 because no digit matches the next.
	// 91212129 produces 9 because the only digit that matches the next one is
	// the last digit, 9.
	// What is the solution to your captcha?
	// input provided below
	//
		System.out.println("Day 1 Part 1");
		System.out.println("Answer to part 1 is " + printAnswerPartOne(getStandardInputDayOnePartOneAndTwo()) + ".");
	}

	public static List<String> getStandardInputDayOnePartOneAndTwo() {
		List<String> standardInputDayOneAndTwo = new ArrayList<String>();
		standardInputDayOneAndTwo.add("32941994713271959948248321");
		standardInputDayOneAndTwo.add("975648598766826381888897682988942438326656546814128868");
		standardInputDayOneAndTwo.add("622345259915532765786412655899591784142183893293614966");
		standardInputDayOneAndTwo.add("739916146736263445521794139955622668181383723932139661");
		standardInputDayOneAndTwo.add("431249144693976925872511126632178628792332267635339111");
		standardInputDayOneAndTwo.add("288933545363532138471222514638578941598198287248279695");
		standardInputDayOneAndTwo.add("764321918477877727328812668754697211893318822281465768");
		standardInputDayOneAndTwo.add("329213146382213173932564719985981172896326846633552738");
		standardInputDayOneAndTwo.add("459839338457217134978117669953677958579652221836687655");
		standardInputDayOneAndTwo.add("174542633541111348413346313451115961316827261965747631");
		standardInputDayOneAndTwo.add("651878893375995833456344134361655397441888661567715856");
		standardInputDayOneAndTwo.add("477185551825299366696835816623986187653914871647157248");
		standardInputDayOneAndTwo.add("498945633144269593481192869551444394527317626665687416");
		standardInputDayOneAndTwo.add("121532544691317241376998329847289378659567119255926284");
		standardInputDayOneAndTwo.add("566171336952595545487193282");
		standardInputDayOneAndTwo.add("29938621332325125972547181");
		standardInputDayOneAndTwo.add("236812263887375866231118312954369432937359357266467383");
		standardInputDayOneAndTwo.add("318326239572877314765121844831126178173988799765218913");
		standardInputDayOneAndTwo.add("178825966268816476559792947359956859989228917136267178");
		standardInputDayOneAndTwo.add("571776316345292573489873792149646548747995389669692188");
		standardInputDayOneAndTwo.add("457724414468727192819919448275922166321158141365237545");
		standardInputDayOneAndTwo.add("222633688372891451842434458527698774342111482498999383");
		standardInputDayOneAndTwo.add("831492577615154591278719656798277377363284379468757998");
		standardInputDayOneAndTwo.add("373193231795767644654155432692988651312845433511879457");
		standardInputDayOneAndTwo.add("921638934877557575241394363721667237778962455961493559");
		standardInputDayOneAndTwo.add("848522582413748218971212486373232795878362964873855994");
		standardInputDayOneAndTwo.add("697149692824917183375545192119453587398199912564474614");
		standardInputDayOneAndTwo.add("219929345185468661129966379693813498542474732198176496");
		standardInputDayOneAndTwo.add("694746111576925715493967296487258237854152382365579876");
		standardInputDayOneAndTwo.add("894391815759815373319159213475555251488754279888245492");
		standardInputDayOneAndTwo.add("373595471189191353244684697662848376529881512529221627");
		standardInputDayOneAndTwo.add("313527441221459672786923145165989611223372241149929436");
		standardInputDayOneAndTwo.add("247374818467481641931872972582295425936998535194423916");
		standardInputDayOneAndTwo.add("544367799522276914445231582272368388831834437562752119");
		standardInputDayOneAndTwo.add("325286474352863554693373718848649568451797751926315617");
		standardInputDayOneAndTwo.add("575295381964426843625282819524747119726872193569785611");
		standardInputDayOneAndTwo.add("959896776143539915299968276374712996485367853494734376");
		standardInputDayOneAndTwo.add("257511273443736433464496287219615697341973131715166768");
		standardInputDayOneAndTwo.add("916149828396454638596713572963686159214116763");
		return standardInputDayOneAndTwo;
	}

	// part 1

	public static int printAnswerGeneric(String input, Character lastChar) {// ,
																			// Character
																			// firstChar)
																			// {
		int sum = 0;
		Character currentChar;
		Character previousChar = lastChar;

		for (int i = 0; i < input.length(); i++) {
			currentChar = input.charAt(i);
			if (currentChar == previousChar) {
				sum = sum + (Integer.parseInt(currentChar.toString()));
			}
			previousChar = currentChar;
		}
		return sum;
	}

	public static int printAnswerSingleInput(String input) {
		return printAnswerGeneric(input, input.charAt(input.length() - 1));
	}

	public static int printAnswerPartOne(List<String> stringList) {
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
	
	public static void executeStandardPart2() {
//	--- Part Two ---
//	You notice a progress bar that jumps to 50% completion. Apparently, the door isn't yet satisfied, but it did emit a star as encouragement. The instructions change:
//
//	Now, instead of considering the next digit, it wants you to consider the digit halfway around the circular list. That is, if your list contains 10 items, only include a digit in your sum if the digit 10/2 = 5 steps forward matches it. Fortunately, your list has an even number of elements.
//
//	For example:
//
//	1212 produces 6: the list contains 4 items, and all four digits match the digit 2 items ahead.
//	1221 produces 0, because every comparison is between a 1 and a 2.
//	123425 produces 4, because both 2s match each other, but no other digit has a match.
//	123123 produces 12.
//	12131415 produces 4.
//	What is the solution to your new captcha?
		System.out.println("Day 1 Part 2");
		System.out.println("Answer to part 2 is " + printAnswerPartTwo(getStandardInputDayOnePartOneAndTwo()) + ".");
	}

	public static int printAnswerPartTwo(List<String> stringList) {
		int answer = 0;
		CircularArray circularArray = streamInStringList(stringList);
		for (int i = 0; i < (circularArray.getArrayAsList().size() / 2); i++) {
			if (circularArray.getArrayAsList().get(i).getValue() == circularArray.getArrayAsList()
					.get(i + (circularArray.getArrayAsList().size() / 2)).getValue()) {
				answer = answer + circularArray.getArrayAsList().get(i).getValue();
			}
		}
		return answer * 2;
	}

	private static CircularArray streamInStringList(List<String> stringList) {
		CircularArray arrayToReturn = new CircularArray();
		int i = 0;
		for (int v = 0; v < stringList.size(); v++) {
			String stringToStream = stringList.get(v);
			for (int c = 0; c < stringToStream.length(); c++) {
				List<CircularArrayNode> nodeList = new ArrayList<CircularArrayNode>();
				if (arrayToReturn.getArrayAsList() != null) {
					nodeList = arrayToReturn.getArrayAsList();
				} else {
					// List<CircularArrayNode> nodeList = new
					// ArrayList<CircularArrayNode>();
				}
				CircularArrayNode nodeToAdd = new CircularArrayNode();
				// nodeToAdd.setIndex(i);
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