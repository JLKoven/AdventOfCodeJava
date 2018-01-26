import java.util.ArrayList;
import java.util.List;

public class DayFive {

	private static final Integer INTCONSTFORPARTTWO = 3;


	public static void executeStandardPart1() {
//		--- Day 5: A Maze of Twisty Trampolines, All Alike ---
//		An urgent interrupt arrives from the CPU: it's trapped in a maze of jump instructions, and it would like assistance from any programs with spare cycles to help find the exit.
//
//		The message includes a list of the offsets for each jump. Jumps are relative: -1 moves to the previous instruction, and 2 skips the next one. Start at the first instruction in the list. The goal is to follow the jumps until one leads outside the list.
//
//		In addition, these instructions are a little strange; after each jump, the offset of that instruction increases by 1. So, if you come across an offset of 3, you would move three instructions forward, but change it to a 4 for the next time it is encountered.
//
//		For example, consider the following list of jump offsets:
//
//		0
//		3
//		0
//		1
//		-3
//		Positive jumps ("forward") move downward; negative jumps move upward. For legibility in this example, these offset values will be written all on one line, with the current instruction marked in parentheses. The following steps would be taken before an exit is found:
//
//		(0) 3  0  1  -3  - before we have taken any steps.
//		(1) 3  0  1  -3  - jump with offset 0 (that is, don't jump at all). Fortunately, the instruction is then incremented to 1.
//		 2 (3) 0  1  -3  - step forward because of the instruction we just modified. The first instruction is incremented again, now to 2.
//		 2  4  0  1 (-3) - jump all the way to the end; leave a 4 behind.
//		 2 (4) 0  1  -2  - go back to where we just were; increment -3 to -2.
//		 2  5  0  1  -2  - jump 4 steps forward, escaping the maze.
//		In this example, the exit is reached in 5 steps.
//
//		How many steps does it take to reach the exit?
		System.out.println("Day 5 Part 1");
		System.out.println(
				"Answer to array part 1 is " + printAnswerDayFivePartOne(getStandardInputDayFivePartOneAndTwo()) + ".");
	}


	public static int printAnswerDayFivePartOne(List<Integer> intList) {
		int counter = 0;
		int position = 0;
		//start at instruction 1 
		while (
				(position>=0)
				&&
				(position<intList.size())
				){
			counter++;
			position = findNextPosition(position, intList);
		}
		
		return counter;
	}

	private static int findNextPosition(int position, List<Integer> intList) {
		int startingPosition=position;
		int nextPosition=position+intList.get(position);
		intList.set(startingPosition, intList.get(position)+1);
		return nextPosition;
	}

	public static void executeStandardPart2() {
	//		--- Part Two ---
	//		Now, the jumps are even stranger: after each jump, if the offset was three or more, instead decrease it by 1. Otherwise, increase it by 1 as before.
	//
	//		Using this rule with the above example, the process now takes 10 steps, and the offset values after finding the exit are left as 2 3 2 3 -1.
	//
	//		How many steps does it now take to reach the exit?	
		System.out.println("Day 5 Part 2");
		System.out.println(
				"Answer to array part 1 is " + printAnswerDayFivePartTwo(getStandardInputDayFivePartOneAndTwo()) + ".");
		}


	
	public static int printAnswerDayFivePartTwo(List<Integer> intList) {
		int counter = 0;
		int position = 0;
		//start at instruction 1 
		while (
				(position>=0)
				&&
				(position<intList.size())
				){
			counter++;
			position = findNextPositionPartTwo(position, intList);
		}
		
		return counter;
	}

	private static int findNextPositionPartTwo(int position, List<Integer> intList) {
		int startingPosition=position;
		int nextPosition=position+intList.get(position);
		if (intList.get(position)>=INTCONSTFORPARTTWO){
			intList.set(startingPosition, intList.get(position)-1);
		} else {
			intList.set(startingPosition, intList.get(position)+1);
		}
		return nextPosition;
	}


	private static List<Integer> getStandardInputDayFivePartOneAndTwo() {
		List<Integer> defaultInput = new ArrayList<Integer>();
		defaultInput.add(0);
		defaultInput.add(0);
		defaultInput.add(1);
		defaultInput.add(2);
		defaultInput.add(0);
		defaultInput.add(1);
		defaultInput.add(0);
		defaultInput.add(2);
		defaultInput.add(-2);
		defaultInput.add(-6);
		defaultInput.add(0);
		defaultInput.add(-7);
		defaultInput.add(2);
		defaultInput.add(2);
		defaultInput.add(1);
		defaultInput.add(-2);
		defaultInput.add(1);
		defaultInput.add(1);
		defaultInput.add(-11);
		defaultInput.add(-14);
		defaultInput.add(-16);
		defaultInput.add(-14);
		defaultInput.add(-12);
		defaultInput.add(-5);
		defaultInput.add(-2);
		defaultInput.add(-21);
		defaultInput.add(-15);
		defaultInput.add(-9);
		defaultInput.add(0);
		defaultInput.add(-13);
		defaultInput.add(-4);
		defaultInput.add(-19);
		defaultInput.add(-31);
		defaultInput.add(1);
		defaultInput.add(-15);
		defaultInput.add(-1);
		defaultInput.add(-23);
		defaultInput.add(-18);
		defaultInput.add(0);
		defaultInput.add(-18);
		defaultInput.add(-11);
		defaultInput.add(-21);
		defaultInput.add(-6);
		defaultInput.add(2);
		defaultInput.add(-38);
		defaultInput.add(2);
		defaultInput.add(-38);
		defaultInput.add(-40);
		defaultInput.add(-15);
		defaultInput.add(-2);
		defaultInput.add(-23);
		defaultInput.add(-42);
		defaultInput.add(-23);
		defaultInput.add(-36);
		defaultInput.add(-37);
		defaultInput.add(-34);
		defaultInput.add(-26);
		defaultInput.add(-51);
		defaultInput.add(-14);
		defaultInput.add(-8);
		defaultInput.add(-56);
		defaultInput.add(-11);
		defaultInput.add(-14);
		defaultInput.add(-40);
		defaultInput.add(-39);
		defaultInput.add(-26);
		defaultInput.add(-35);
		defaultInput.add(-48);
		defaultInput.add(-52);
		defaultInput.add(-18);
		defaultInput.add(-16);
		defaultInput.add(-11);
		defaultInput.add(-38);
		defaultInput.add(-4);
		defaultInput.add(-70);
		defaultInput.add(-20);
		defaultInput.add(-10);
		defaultInput.add(-37);
		defaultInput.add(-75);
		defaultInput.add(-33);
		defaultInput.add(-39);
		defaultInput.add(-37);
		defaultInput.add(-74);
		defaultInput.add(-17);
		defaultInput.add(-83);
		defaultInput.add(-13);
		defaultInput.add(-75);
		defaultInput.add(-56);
		defaultInput.add(-44);
		defaultInput.add(-40);
		defaultInput.add(-20);
		defaultInput.add(-18);
		defaultInput.add(-74);
		defaultInput.add(-32);
		defaultInput.add(-48);
		defaultInput.add(-11);
		defaultInput.add(-80);
		defaultInput.add(-88);
		defaultInput.add(-33);
		defaultInput.add(-67);
		defaultInput.add(-96);
		defaultInput.add(-67);
		defaultInput.add(-49);
		defaultInput.add(-55);
		defaultInput.add(-101);
		defaultInput.add(-8);
		defaultInput.add(-77);
		defaultInput.add(-33);
		defaultInput.add(-93);
		defaultInput.add(-22);
		defaultInput.add(-21);
		defaultInput.add(-99);
		defaultInput.add(-33);
		defaultInput.add(-12);
		defaultInput.add(-111);
		defaultInput.add(-105);
		defaultInput.add(-77);
		defaultInput.add(-76);
		defaultInput.add(-90);
		defaultInput.add(-63);
		defaultInput.add(-76);
		defaultInput.add(-55);
		defaultInput.add(-65);
		defaultInput.add(-106);
		defaultInput.add(-56);
		defaultInput.add(-93);
		defaultInput.add(-121);
		defaultInput.add(-31);
		defaultInput.add(-86);
		defaultInput.add(-102);
		defaultInput.add(-116);
		defaultInput.add(-120);
		defaultInput.add(-17);
		defaultInput.add(-95);
		defaultInput.add(-110);
		defaultInput.add(-128);
		defaultInput.add(-122);
		defaultInput.add(-135);
		defaultInput.add(-133);
		defaultInput.add(-124);
		defaultInput.add(-50);
		defaultInput.add(-32);
		defaultInput.add(-86);
		defaultInput.add(-11);
		defaultInput.add(-127);
		defaultInput.add(-42);
		defaultInput.add(-9);
		defaultInput.add(-41);
		defaultInput.add(-28);
		defaultInput.add(-93);
		defaultInput.add(-13);
		defaultInput.add(-16);
		defaultInput.add(-8);
		defaultInput.add(-138);
		defaultInput.add(-111);
		defaultInput.add(-103);
		defaultInput.add(-25);
		defaultInput.add(-22);
		defaultInput.add(-133);
		defaultInput.add(-52);
		defaultInput.add(-27);
		defaultInput.add(-6);
		defaultInput.add(-67);
		defaultInput.add(-72);
		defaultInput.add(-115);
		defaultInput.add(-133);
		defaultInput.add(-146);
		defaultInput.add(-46);
		defaultInput.add(-128);
		defaultInput.add(-99);
		defaultInput.add(-115);
		defaultInput.add(-16);
		defaultInput.add(-113);
		defaultInput.add(-105);
		defaultInput.add(1);
		defaultInput.add(-76);
		defaultInput.add(-2);
		defaultInput.add(1);
		defaultInput.add(-66);
		defaultInput.add(-164);
		defaultInput.add(-87);
		defaultInput.add(-8);
		defaultInput.add(-92);
		defaultInput.add(-180);
		defaultInput.add(-137);
		defaultInput.add(-39);
		defaultInput.add(-127);
		defaultInput.add(-124);
		defaultInput.add(-66);
		defaultInput.add(-96);
		defaultInput.add(-185);
		defaultInput.add(-13);
		defaultInput.add(-65);
		defaultInput.add(-178);
		defaultInput.add(-16);
		defaultInput.add(-32);
		defaultInput.add(-24);
		defaultInput.add(-84);
		defaultInput.add(-49);
		defaultInput.add(-7);
		defaultInput.add(-198);
		defaultInput.add(-101);
		defaultInput.add(-119);
		defaultInput.add(-187);
		defaultInput.add(-71);
		defaultInput.add(-125);
		defaultInput.add(-130);
		defaultInput.add(-72);
		defaultInput.add(-130);
		defaultInput.add(-43);
		defaultInput.add(-136);
		defaultInput.add(-171);
		defaultInput.add(-32);
		defaultInput.add(-210);
		defaultInput.add(-69);
		defaultInput.add(-195);
		defaultInput.add(-207);
		defaultInput.add(-197);
		defaultInput.add(-190);
		defaultInput.add(-117);
		defaultInput.add(-196);
		defaultInput.add(-143);
		defaultInput.add(-128);
		defaultInput.add(-155);
		defaultInput.add(-160);
		defaultInput.add(-53);
		defaultInput.add(-205);
		defaultInput.add(-15);
		defaultInput.add(-86);
		defaultInput.add(-227);
		defaultInput.add(-128);
		defaultInput.add(-115);
		defaultInput.add(-58);
		defaultInput.add(-96);
		defaultInput.add(-52);
		defaultInput.add(-100);
		defaultInput.add(-41);
		defaultInput.add(-84);
		defaultInput.add(-61);
		defaultInput.add(-50);
		defaultInput.add(-91);
		defaultInput.add(-158);
		defaultInput.add(-30);
		defaultInput.add(-230);
		defaultInput.add(-125);
		defaultInput.add(-177);
		defaultInput.add(-181);
		defaultInput.add(-47);
		defaultInput.add(-43);
		defaultInput.add(-241);
		defaultInput.add(-52);
		defaultInput.add(-102);
		defaultInput.add(-161);
		defaultInput.add(-16);
		defaultInput.add(-130);
		defaultInput.add(-21);
		defaultInput.add(-22);
		defaultInput.add(-249);
		defaultInput.add(-78);
		defaultInput.add(-101);
		defaultInput.add(-51);
		defaultInput.add(-229);
		defaultInput.add(-148);
		defaultInput.add(-132);
		defaultInput.add(-213);
		defaultInput.add(-264);
		defaultInput.add(-175);
		defaultInput.add(-128);
		defaultInput.add(-102);
		defaultInput.add(-26);
		defaultInput.add(-86);
		defaultInput.add(-84);
		defaultInput.add(-100);
		defaultInput.add(-132);
		defaultInput.add(-228);
		defaultInput.add(-118);
		defaultInput.add(-46);
		defaultInput.add(-77);
		defaultInput.add(-230);
		defaultInput.add(-98);
		defaultInput.add(-193);
		defaultInput.add(-191);
		defaultInput.add(-142);
		defaultInput.add(-193);
		defaultInput.add(-183);
		defaultInput.add(-58);
		defaultInput.add(-59);
		defaultInput.add(-254);
		defaultInput.add(-256);
		defaultInput.add(-108);
		defaultInput.add(-12);
		defaultInput.add(-46);
		defaultInput.add(-11);
		defaultInput.add(-143);
		defaultInput.add(-22);
		defaultInput.add(-121);
		defaultInput.add(-68);
		defaultInput.add(-282);
		defaultInput.add(-94);
		defaultInput.add(-22);
		defaultInput.add(-172);
		defaultInput.add(-246);
		defaultInput.add(-174);
		defaultInput.add(-76);
		defaultInput.add(-3);
		defaultInput.add(-117);
		defaultInput.add(-237);
		defaultInput.add(-258);
		defaultInput.add(-29);
		defaultInput.add(-105);
		defaultInput.add(-32);
		defaultInput.add(-177);
		defaultInput.add(-125);
		defaultInput.add(-70);
		defaultInput.add(-176);
		defaultInput.add(-113);
		defaultInput.add(-152);
		defaultInput.add(-227);
		defaultInput.add(-298);
		defaultInput.add(-199);
		defaultInput.add(-179);
		defaultInput.add(-162);
		defaultInput.add(-241);
		defaultInput.add(-230);
		defaultInput.add(-8);
		defaultInput.add(-202);
		defaultInput.add(-296);
		defaultInput.add(-194);
		defaultInput.add(-82);
		defaultInput.add(-188);
		defaultInput.add(-136);
		defaultInput.add(-24);
		defaultInput.add(-171);
		defaultInput.add(-185);
		defaultInput.add(-272);
		defaultInput.add(-124);
		defaultInput.add(-306);
		defaultInput.add(-230);
		defaultInput.add(-249);
		defaultInput.add(-64);
		defaultInput.add(-139);
		defaultInput.add(-143);
		defaultInput.add(-293);
		defaultInput.add(-218);
		defaultInput.add(-167);
		defaultInput.add(-208);
		defaultInput.add(-254);
		defaultInput.add(-171);
		defaultInput.add(-119);
		defaultInput.add(-82);
		defaultInput.add(-284);
		defaultInput.add(-262);
		defaultInput.add(-252);
		defaultInput.add(-92);
		defaultInput.add(-230);
		defaultInput.add(-193);
		defaultInput.add(-173);
		defaultInput.add(-269);
		defaultInput.add(-173);
		defaultInput.add(-13);
		defaultInput.add(0);
		defaultInput.add(-148);
		defaultInput.add(-151);
		defaultInput.add(-241);
		defaultInput.add(-120);
		defaultInput.add(-20);
		defaultInput.add(-22);
		defaultInput.add(-218);
		defaultInput.add(-6);
		defaultInput.add(-314);
		defaultInput.add(-347);
		defaultInput.add(-58);
		defaultInput.add(-180);
		defaultInput.add(-242);
		defaultInput.add(-333);
		defaultInput.add(-247);
		defaultInput.add(-67);
		defaultInput.add(-137);
		defaultInput.add(-102);
		defaultInput.add(-32);
		defaultInput.add(-102);
		defaultInput.add(-88);
		defaultInput.add(-42);
		defaultInput.add(-284);
		defaultInput.add(-109);
		defaultInput.add(-281);
		defaultInput.add(-43);
		defaultInput.add(-63);
		defaultInput.add(-205);
		defaultInput.add(-268);
		defaultInput.add(-273);
		defaultInput.add(-235);
		defaultInput.add(-119);
		defaultInput.add(-185);
		defaultInput.add(-62);
		defaultInput.add(-56);
		defaultInput.add(-260);
		defaultInput.add(-47);
		defaultInput.add(-353);
		defaultInput.add(-123);
		defaultInput.add(-312);
		defaultInput.add(0);
		defaultInput.add(-76);
		defaultInput.add(-352);
		defaultInput.add(-365);
		defaultInput.add(-284);
		defaultInput.add(-105);
		defaultInput.add(-62);
		defaultInput.add(-165);
		defaultInput.add(-292);
		defaultInput.add(-5);
		defaultInput.add(-46);
		defaultInput.add(-31);
		defaultInput.add(-116);
		defaultInput.add(-147);
		defaultInput.add(-34);
		defaultInput.add(-149);
		defaultInput.add(-79);
		defaultInput.add(-139);
		defaultInput.add(-132);
		defaultInput.add(-84);
		defaultInput.add(-58);
		defaultInput.add(-130);
		defaultInput.add(-125);
		defaultInput.add(-188);
		defaultInput.add(-227);
		defaultInput.add(-2);
		defaultInput.add(-220);
		defaultInput.add(-88);
		defaultInput.add(-96);
		defaultInput.add(-38);
		defaultInput.add(-308);
		defaultInput.add(-214);
		defaultInput.add(-357);
		defaultInput.add(-19);
		defaultInput.add(-410);
		defaultInput.add(-292);
		defaultInput.add(-150);
		defaultInput.add(-151);
		defaultInput.add(1);
		defaultInput.add(-252);
		defaultInput.add(-172);
		defaultInput.add(-414);
		defaultInput.add(-15);
		defaultInput.add(-207);
		defaultInput.add(-184);
		defaultInput.add(-286);
		defaultInput.add(-161);
		defaultInput.add(-55);
		defaultInput.add(-158);
		defaultInput.add(-330);
		defaultInput.add(-53);
		defaultInput.add(-310);
		defaultInput.add(-295);
		defaultInput.add(-248);
		defaultInput.add(-126);
		defaultInput.add(-425);
		defaultInput.add(-10);
		defaultInput.add(-289);
		defaultInput.add(-148);
		defaultInput.add(-146);
		defaultInput.add(-436);
		defaultInput.add(-279);
		defaultInput.add(-48);
		defaultInput.add(-321);
		defaultInput.add(-196);
		defaultInput.add(-162);
		defaultInput.add(-55);
		defaultInput.add(-125);
		defaultInput.add(-62);
		defaultInput.add(-381);
		defaultInput.add(-337);
		defaultInput.add(-85);
		defaultInput.add(-428);
		defaultInput.add(-470);
		defaultInput.add(-180);
		defaultInput.add(-392);
		defaultInput.add(-450);
		defaultInput.add(-376);
		defaultInput.add(-73);
		defaultInput.add(-206);
		defaultInput.add(-115);
		defaultInput.add(-289);
		defaultInput.add(-318);
		defaultInput.add(-22);
		defaultInput.add(-200);
		defaultInput.add(-176);
		defaultInput.add(-410);
		defaultInput.add(-380);
		defaultInput.add(-470);
		defaultInput.add(-418);
		defaultInput.add(-163);
		defaultInput.add(-424);
		defaultInput.add(-288);
		defaultInput.add(-374);
		defaultInput.add(-358);
		defaultInput.add(-386);
		defaultInput.add(-340);
		defaultInput.add(-403);
		defaultInput.add(-81);
		defaultInput.add(-7);
		defaultInput.add(-378);
		defaultInput.add(1);
		defaultInput.add(-320);
		defaultInput.add(-323);
		defaultInput.add(-288);
		defaultInput.add(-439);
		defaultInput.add(-437);
		defaultInput.add(-90);
		defaultInput.add(-159);
		defaultInput.add(-379);
		defaultInput.add(-69);
		defaultInput.add(-236);
		defaultInput.add(-168);
		defaultInput.add(-232);
		defaultInput.add(-232);
		defaultInput.add(-42);
		defaultInput.add(-257);
		defaultInput.add(-437);
		defaultInput.add(-40);
		defaultInput.add(-390);
		defaultInput.add(-241);
		defaultInput.add(-54);
		defaultInput.add(-247);
		defaultInput.add(-76);
		defaultInput.add(-325);
		defaultInput.add(-351);
		defaultInput.add(-259);
		defaultInput.add(-328);
		defaultInput.add(-283);
		defaultInput.add(-5);
		defaultInput.add(-169);
		defaultInput.add(-114);
		defaultInput.add(-252);
		defaultInput.add(-131);
		defaultInput.add(-223);
		defaultInput.add(-446);
		defaultInput.add(-482);
		defaultInput.add(-7);
		defaultInput.add(-285);
		defaultInput.add(-486);
		defaultInput.add(-260);
		defaultInput.add(-421);
		defaultInput.add(-498);
		defaultInput.add(-32);
		defaultInput.add(-182);
		defaultInput.add(-317);
		defaultInput.add(-201);
		defaultInput.add(-370);
		defaultInput.add(-518);
		defaultInput.add(-129);
		defaultInput.add(-359);
		defaultInput.add(-67);
		defaultInput.add(-209);
		defaultInput.add(-541);
		defaultInput.add(-323);
		defaultInput.add(-132);
		defaultInput.add(-197);
		defaultInput.add(-70);
		defaultInput.add(-171);
		defaultInput.add(-258);
		defaultInput.add(-372);
		defaultInput.add(-228);
		defaultInput.add(-4);
		defaultInput.add(-360);
		defaultInput.add(-144);
		defaultInput.add(-307);
		defaultInput.add(-226);
		defaultInput.add(-533);
		defaultInput.add(-435);
		defaultInput.add(-318);
		defaultInput.add(-284);
		defaultInput.add(-284);
		defaultInput.add(-150);
		defaultInput.add(-539);
		defaultInput.add(-46);
		defaultInput.add(-81);
		defaultInput.add(-144);
		defaultInput.add(-188);
		defaultInput.add(-264);
		defaultInput.add(-136);
		defaultInput.add(-138);
		defaultInput.add(-106);
		defaultInput.add(-65);
		defaultInput.add(-262);
		defaultInput.add(-250);
		defaultInput.add(-176);
		defaultInput.add(-261);
		defaultInput.add(-112);
		defaultInput.add(-227);
		defaultInput.add(-304);
		defaultInput.add(-159);
		defaultInput.add(-425);
		defaultInput.add(-117);
		defaultInput.add(-441);
		defaultInput.add(-111);
		defaultInput.add(-468);
		defaultInput.add(-2);
		defaultInput.add(-84);
		defaultInput.add(-197);
		defaultInput.add(1);
		defaultInput.add(-575);
		defaultInput.add(-305);
		defaultInput.add(-401);
		defaultInput.add(-114);
		defaultInput.add(-143);
		defaultInput.add(-180);
		defaultInput.add(-16);
		defaultInput.add(-450);
		defaultInput.add(-24);
		defaultInput.add(-357);
		defaultInput.add(-104);
		defaultInput.add(-434);
		defaultInput.add(-435);
		defaultInput.add(-345);
		defaultInput.add(-247);
		defaultInput.add(-484);
		defaultInput.add(-282);
		defaultInput.add(-263);
		defaultInput.add(-389);
		defaultInput.add(-463);
		defaultInput.add(-178);
		defaultInput.add(-144);
		defaultInput.add(-256);
		defaultInput.add(-94);
		defaultInput.add(-522);
		defaultInput.add(-302);
		defaultInput.add(-524);
		defaultInput.add(-309);
		defaultInput.add(-275);
		defaultInput.add(-350);
		defaultInput.add(-596);
		defaultInput.add(-462);
		defaultInput.add(-317);
		defaultInput.add(-543);
		defaultInput.add(-8);
		defaultInput.add(-374);
		defaultInput.add(-404);
		defaultInput.add(-302);
		defaultInput.add(-610);
		defaultInput.add(-111);
		defaultInput.add(-358);
		defaultInput.add(2);
		defaultInput.add(-353);
		defaultInput.add(-397);
		defaultInput.add(-165);
		defaultInput.add(-324);
		defaultInput.add(-574);
		defaultInput.add(-618);
		defaultInput.add(-168);
		defaultInput.add(-636);
		defaultInput.add(-389);
		defaultInput.add(-609);
		defaultInput.add(-54);
		defaultInput.add(-121);
		defaultInput.add(-256);
		defaultInput.add(-604);
		defaultInput.add(-588);
		defaultInput.add(-454);
		defaultInput.add(-100);
		defaultInput.add(-212);
		defaultInput.add(-65);
		defaultInput.add(-300);
		defaultInput.add(-592);
		defaultInput.add(-43);
		defaultInput.add(-230);
		defaultInput.add(-652);
		defaultInput.add(-638);
		defaultInput.add(-67);
		defaultInput.add(-499);
		defaultInput.add(-614);
		defaultInput.add(-419);
		defaultInput.add(-577);
		defaultInput.add(-96);
		defaultInput.add(-257);
		defaultInput.add(-519);
		defaultInput.add(-458);
		defaultInput.add(-14);
		defaultInput.add(-26);
		defaultInput.add(-370);
		defaultInput.add(-187);
		defaultInput.add(-319);
		defaultInput.add(-528);
		defaultInput.add(-436);
		defaultInput.add(-87);
		defaultInput.add(-673);
		defaultInput.add(-535);
		defaultInput.add(-473);
		defaultInput.add(-670);
		defaultInput.add(-594);
		defaultInput.add(-589);
		defaultInput.add(-629);
		defaultInput.add(-180);
		defaultInput.add(-13);
		defaultInput.add(-668);
		defaultInput.add(-369);
		defaultInput.add(-679);
		defaultInput.add(-587);
		defaultInput.add(-624);
		defaultInput.add(-123);
		defaultInput.add(-363);
		defaultInput.add(-241);
		defaultInput.add(-343);
		defaultInput.add(-259);
		defaultInput.add(-123);
		defaultInput.add(-319);
		defaultInput.add(-608);
		defaultInput.add(-470);
		defaultInput.add(-336);
		defaultInput.add(-291);
		defaultInput.add(-676);
		defaultInput.add(-535);
		defaultInput.add(-226);
		defaultInput.add(-11);
		defaultInput.add(-224);
		defaultInput.add(-43);
		defaultInput.add(-30);
		defaultInput.add(-605);
		defaultInput.add(-670);
		defaultInput.add(-544);
		defaultInput.add(-248);
		defaultInput.add(-609);
		defaultInput.add(-144);
		defaultInput.add(-328);
		defaultInput.add(-177);
		defaultInput.add(-360);
		defaultInput.add(-628);
		defaultInput.add(-51);
		defaultInput.add(-724);
		defaultInput.add(-407);
		defaultInput.add(-625);
		defaultInput.add(-433);
		defaultInput.add(-192);
		defaultInput.add(-455);
		defaultInput.add(-603);
		defaultInput.add(-581);
		defaultInput.add(-33);
		defaultInput.add(-696);
		defaultInput.add(-160);
		defaultInput.add(-464);
		defaultInput.add(-510);
		defaultInput.add(-3);
		defaultInput.add(-144);
		defaultInput.add(-113);
		defaultInput.add(-87);
		defaultInput.add(-519);
		defaultInput.add(-263);
		defaultInput.add(-161);
		defaultInput.add(-94);
		defaultInput.add(-716);
		defaultInput.add(-484);
		defaultInput.add(-509);
		defaultInput.add(-615);
		defaultInput.add(-373);
		defaultInput.add(-734);
		defaultInput.add(-686);
		defaultInput.add(-732);
		defaultInput.add(-395);
		defaultInput.add(-163);
		defaultInput.add(-432);
		defaultInput.add(-26);
		defaultInput.add(-716);
		defaultInput.add(-599);
		defaultInput.add(-596);
		defaultInput.add(-648);
		defaultInput.add(-91);
		defaultInput.add(-716);
		defaultInput.add(-540);
		defaultInput.add(-429);
		defaultInput.add(-456);
		defaultInput.add(-744);
		defaultInput.add(-344);
		defaultInput.add(-298);
		defaultInput.add(-689);
		defaultInput.add(-428);
		defaultInput.add(-119);
		defaultInput.add(-323);
		defaultInput.add(-196);
		defaultInput.add(-41);
		defaultInput.add(-602);
		defaultInput.add(-724);
		defaultInput.add(-413);
		defaultInput.add(-444);
		defaultInput.add(-614);
		defaultInput.add(-331);
		defaultInput.add(-697);
		defaultInput.add(-115);
		defaultInput.add(-7);
		defaultInput.add(-409);
		defaultInput.add(-272);
		defaultInput.add(-672);
		defaultInput.add(-224);
		defaultInput.add(-732);
		defaultInput.add(-203);
		defaultInput.add(-37);
		defaultInput.add(-397);
		defaultInput.add(-794);
		defaultInput.add(-161);
		defaultInput.add(-512);
		defaultInput.add(-664);
		defaultInput.add(-193);
		defaultInput.add(-245);
		defaultInput.add(-490);
		defaultInput.add(-439);
		defaultInput.add(-696);
		defaultInput.add(-661);
		defaultInput.add(-717);
		defaultInput.add(-424);
		defaultInput.add(-308);
		defaultInput.add(-481);
		defaultInput.add(-215);
		defaultInput.add(-658);
		defaultInput.add(-705);
		defaultInput.add(-389);
		defaultInput.add(-90);
		defaultInput.add(-619);
		defaultInput.add(-297);
		defaultInput.add(-670);
		defaultInput.add(-125);
		defaultInput.add(-119);
		defaultInput.add(-268);
		defaultInput.add(-553);
		defaultInput.add(-227);
		defaultInput.add(-733);
		defaultInput.add(-142);
		defaultInput.add(-333);
		defaultInput.add(-52);
		defaultInput.add(-609);
		defaultInput.add(-795);
		defaultInput.add(-422);
		defaultInput.add(-202);
		defaultInput.add(-579);
		defaultInput.add(-397);
		defaultInput.add(-431);
		defaultInput.add(-561);
		defaultInput.add(-140);
		defaultInput.add(-467);
		defaultInput.add(-688);
		defaultInput.add(-486);
		defaultInput.add(-493);
		defaultInput.add(-279);
		defaultInput.add(-457);
		defaultInput.add(-295);
		defaultInput.add(-181);
		defaultInput.add(-823);
		defaultInput.add(-808);
		defaultInput.add(-495);
		defaultInput.add(-620);
		defaultInput.add(-652);
		defaultInput.add(-80);
		defaultInput.add(-22);
		defaultInput.add(-26);
		defaultInput.add(-769);
		defaultInput.add(0);
		defaultInput.add(-439);
		defaultInput.add(-31);
		defaultInput.add(-458);
		defaultInput.add(-5);
		defaultInput.add(-221);
		defaultInput.add(-675);
		defaultInput.add(-443);
		defaultInput.add(-809);
		defaultInput.add(-845);
		defaultInput.add(-234);
		defaultInput.add(-429);
		defaultInput.add(-425);
		defaultInput.add(-754);
		defaultInput.add(-820);
		defaultInput.add(-442);
		defaultInput.add(-561);
		defaultInput.add(-513);
		defaultInput.add(-462);
		defaultInput.add(-840);
		defaultInput.add(-596);
		defaultInput.add(-113);
		defaultInput.add(-736);
		defaultInput.add(-12);
		defaultInput.add(-123);
		defaultInput.add(-747);
		defaultInput.add(-735);
		defaultInput.add(-732);
		defaultInput.add(-209);
		defaultInput.add(-478);
		defaultInput.add(-504);
		defaultInput.add(-784);
		defaultInput.add(-522);
		defaultInput.add(-257);
		defaultInput.add(-695);
		defaultInput.add(-676);
		defaultInput.add(-331);
		defaultInput.add(-767);
		defaultInput.add(-801);
		defaultInput.add(-128);
		defaultInput.add(-571);
		defaultInput.add(-683);
		defaultInput.add(-757);
		defaultInput.add(-475);
		defaultInput.add(-749);
		defaultInput.add(-53);
		defaultInput.add(-366);
		defaultInput.add(-795);
		defaultInput.add(-562);
		defaultInput.add(-632);
		defaultInput.add(-284);
		defaultInput.add(-488);
		defaultInput.add(-692);
		defaultInput.add(-368);
		defaultInput.add(-883);
		defaultInput.add(-542);
		defaultInput.add(-745);
		defaultInput.add(-10);
		defaultInput.add(-693);
		defaultInput.add(-752);
		defaultInput.add(-136);
		defaultInput.add(-736);
		defaultInput.add(-347);
		defaultInput.add(-855);
		defaultInput.add(-521);
		defaultInput.add(-151);
		defaultInput.add(-324);
		defaultInput.add(-126);
		defaultInput.add(-678);
		defaultInput.add(-28);
		defaultInput.add(-875);
		defaultInput.add(-832);
		defaultInput.add(-474);
		defaultInput.add(-657);
		defaultInput.add(-569);
		defaultInput.add(-518);
		defaultInput.add(-642);
		defaultInput.add(-351);
		defaultInput.add(-850);
		defaultInput.add(-45);
		defaultInput.add(-383);
		defaultInput.add(-362);
		defaultInput.add(-655);
		defaultInput.add(-590);
		defaultInput.add(-184);
		defaultInput.add(-543);
		defaultInput.add(-563);
		defaultInput.add(-631);
		defaultInput.add(-165);
		defaultInput.add(-607);
		defaultInput.add(-732);
		defaultInput.add(-450);
		defaultInput.add(-219);
		defaultInput.add(-774);
		defaultInput.add(-461);
		defaultInput.add(-823);
		defaultInput.add(-651);
		defaultInput.add(-48);
		defaultInput.add(-750);
		defaultInput.add(-246);
		defaultInput.add(-341);
		defaultInput.add(-805);
		defaultInput.add(-620);
		defaultInput.add(-425);
		defaultInput.add(-696);
		defaultInput.add(-874);
		defaultInput.add(-502);
		defaultInput.add(-186);
		defaultInput.add(-143);
		defaultInput.add(-77);
		defaultInput.add(-452);
		defaultInput.add(-710);
		defaultInput.add(-103);
		defaultInput.add(-836);
		defaultInput.add(-824);
		defaultInput.add(-775);
		defaultInput.add(-108);
		defaultInput.add(-823);
		defaultInput.add(-937);
		defaultInput.add(-969);
		defaultInput.add(-392);
		defaultInput.add(-17);
		defaultInput.add(-725);
		defaultInput.add(-226);
		defaultInput.add(-441);
		defaultInput.add(-489);
		defaultInput.add(-669);
		defaultInput.add(-665);
		defaultInput.add(-182);
		defaultInput.add(-625);
		defaultInput.add(-905);
		defaultInput.add(-523);
		defaultInput.add(-925);
		defaultInput.add(-573);
		defaultInput.add(-821);
		defaultInput.add(-786);
		defaultInput.add(-734);
		defaultInput.add(-21);
		defaultInput.add(-819);
		defaultInput.add(-181);
		defaultInput.add(-342);
		defaultInput.add(-625);
		defaultInput.add(-12);
		defaultInput.add(-705);
		defaultInput.add(-275);
		defaultInput.add(-756);
		defaultInput.add(-79);
		return defaultInput;
	}





}
