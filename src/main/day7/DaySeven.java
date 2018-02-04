package main.day7;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import main.GeneralFunction;

public class DaySeven {

	public static void executeStandardPart1() {
		// Wandering further through the circuits of the computer, you come upon
		// a tower of programs that have gotten themselves into a bit of
		// trouble. A recursive algorithm has gotten out of hand, and now
		// they're balanced precariously in a large tower.
		//
		// One program at the bottom supports the entire tower. It's holding a
		// large disc, and on the disc are balanced several more sub-towers. At
		// the bottom of these sub-towers, standing on the bottom disc, are
		// other programs, each holding their own disc, and so on. At the very
		// tops of these sub-sub-sub-...-towers, many programs stand simply
		// keeping the disc below them balanced but with no disc of their own.
		//
		// You offer to help, but first you need to understand the structure of
		// these towers. You ask each program to yell out their name, their
		// weight, and (if they're holding a disc) the names of the programs
		// immediately above them balancing on that disc. You write this
		// information down (your puzzle input). Unfortunately, in their panic,
		// they don't do this in an orderly fashion; by the time you're done,
		// you're not sure which program gave which information.
		//
		// For example, if your list is the following:
		//
		// pbga (66)
		// xhth (57)
		// ebii (61)
		// havc (66)
		// ktlj (57)
		// fwft (72) -> ktlj, cntj, xhth
		// qoyq (66)
		// padx (45) -> pbga, havc, qoyq
		// tknk (41) -> ugml, padx, fwft
		// jptl (61)
		// ugml (68) -> gyxo, ebii, jptl
		// gyxo (61)
		// cntj (57)
		// ...then you would be able to recreate the structure of the towers
		// that looks like this:
		//
		// gyxo
		// /
		// ugml - ebii
		// / \
		// | jptl
		// |
		// | pbga
		// / /
		// tknk --- padx - havc
		// \ \
		// | qoyq
		// |
		// | ktlj
		// \ /
		// fwft - cntj
		// \
		// xhth
		// In this example, tknk is at the bottom of the tower (the bottom
		// program), and is holding up ugml, padx, and fwft. Those programs are,
		// in turn, holding up other programs; in this example, none of those
		// programs are holding up any other programs, and are all the tops of
		// their own towers. (The actual tower balancing in front of you is much
		// larger.)
		//
		// Before you're ready to help them, you need to make sure your
		// information is correct. What is the name of the bottom program?
		System.out.println("Answer to part 1 is " + getAnswerPartOneImperative(getStandardInputDaySeven()) + ".");

	}
	
	public static void executeStandardPart2() {
//		--- Part Two ---
//		The programs explain the situation: they can't get down. Rather, they could get down, if they weren't expending all of their energy trying to keep the tower balanced. Apparently, one program has the wrong weight, and until it's fixed, they're stuck here.
//
//		For any program holding a disc, each program standing on that disc forms a sub-tower. Each of those sub-towers are supposed to be the same weight, or the disc itself isn't balanced. The weight of a tower is the sum of the weights of the programs in that tower.
//
//		In the example above, this means that for ugml's disc to be balanced, gyxo, ebii, and jptl must all have the same weight, and they do: 61.
//
//		However, for tknk to be balanced, each of the programs standing on its disc and all programs above it must each match. This means that the following sums must all be the same:
//
//		ugml + (gyxo + ebii + jptl) = 68 + (61 + 61 + 61) = 251
//		padx + (pbga + havc + qoyq) = 45 + (66 + 66 + 66) = 243
//		fwft + (ktlj + cntj + xhth) = 72 + (57 + 57 + 57) = 243
//		As you can see, tknk's disc is unbalanced: ugml's stack is heavier than the other two. Even though the nodes above ugml are balanced, ugml itself is too heavy: it needs to be 8 units lighter for its stack to weigh 243 and keep the towers balanced. If this change were made, its weight would be 60.
//
//		Given that exactly one program is the wrong weight, what would its weight need to be to balance the entire tower?
		System.out.println("Answer to part 2 is " + getAnswerPartTwoImperative(getStandardInputString()) + ".");

	}
	
	//Imperative

	public static String getAnswerPartOneImperative(DiscTowerImperative outputTower) {
		String stringToReturn = outputTower.getBase().getName();
		return stringToReturn;
	}

	public static List<DiscForTowerImperative> generateListOfDiscsFromStringInput(List<String> stringInput) {
		List<DiscForTowerImperative> resultingList = new ArrayList<DiscForTowerImperative>();
		for (int i = 0; i < stringInput.size(); i++) {
			String[] parts = stringInput.get(i).split("->");
			String source = parts[0];
			DiscForTowerImperative newDisc = new DiscForTowerImperative();
			String[] sourceParts = source.split(" ");
			newDisc.setName(sourceParts[0]);
			newDisc.setValue(Integer.parseInt(GeneralFunction.removeNonNumericLeaveDashAndDot(sourceParts[1])));
			if (parts.length > 1) {
				String results = parts[1];
				String[] resultsParts = results.split(", ");
				resultsParts[0] = GeneralFunction.removeWhitespace(resultsParts[0]);
				List<String> listOfNames = newDisc.getNamesOfDescendants();
				for (int v = 0; v < resultsParts.length; v++) {
					listOfNames.add(resultsParts[v]);
				}
				newDisc.setNamesOfDescendants(listOfNames);
			}
			resultingList.add(newDisc);

		}
		return resultingList;

	}




	public static Integer getAnswerPartTwoImperative(List<String> defaultInput) {
		Integer intToReturn = 0;
		

		List<DiscForTowerImperative> listForTower = new ArrayList<DiscForTowerImperative>();
		DiscTowerImperative outputTower = new DiscTowerImperative();
//		processTower(defaultInput, listForTower, outputTower);
		
		// please bundle these?		
		listForTower = 								
				generateListOfDiscsFromStringInput(defaultInput);
		DiscTowerImperative.createNetworkFromStringValues(listForTower);
		outputTower = DiscTowerImperative.formNewTowerFrom(listForTower);
		// please bundle these?


		for (DiscForTowerImperative disc : listForTower) {
			
			if (disc.isUnbalanced()) {
				intToReturn = 
						
						(disc.getStandardValueOfChildren()
								> disc.getDiscrepantDisc().getSumValue()
								)
						
						? disc.getDiscrepantDisc().getValue()+Math.abs(disc.getDiscrepancyValue()) : disc.getDiscrepantDisc().getValue()-Math.abs(disc.getDiscrepancyValue());
				
				break;

			}


		}

		System.out.println(intToReturn);
		return intToReturn;
	}

//	private static void processTower(List<String> defaultInput, List<DiscForTower> listForTower, DiscTower outputTower) {
//		listForTower = 								
//				generateListOfDiscsFromStringInput(defaultInput);
//		DiscTower.createNetworkFromStringValues(listForTower);
//		outputTower = DiscTower.formNewTowerFrom(listForTower);	
//		}

	private static DiscTowerImperative getStandardInputDaySeven() {

		List<String> defaultInput = getStandardInputString();

		// please bundle these?
		List<DiscForTowerImperative> listForTower = generateListOfDiscsFromStringInput(defaultInput);
		DiscTowerImperative.createNetworkFromStringValues(listForTower);
		DiscTowerImperative outputTower = DiscTowerImperative.formNewTowerFrom(listForTower);
		// please bundle these?

		return outputTower;
	}

	private static List<String> getStandardInputString() {
		List<String> defaultInput = new ArrayList<String>();
		defaultInput.add("yjmbbu (75)");
		defaultInput.add("zdhvqrl (40) -> fpbsu, fwpfjjd, viqhfi");
		defaultInput.add("dywqvqh (9)");
		defaultInput.add("gewgn (31)");
		defaultInput.add("xfekjt (67)");
		defaultInput.add("zezowe (31)");
		defaultInput.add("wgqkdcr (79)");
		defaultInput.add("ljhwzvv (258)");
		defaultInput.add("vustse (1584) -> ffnabs, qinmi, qhafxnl");
		defaultInput.add("idfwjgx (112) -> buoakk, itwbpot");
		defaultInput.add("lxesg (71)");
		defaultInput.add("qkbnq (99)");
		defaultInput.add("jppgd (27)");
		defaultInput.add("ztghd (125) -> bcibchp, aaheijb");
		defaultInput.add("qcrpdy (29)");
		defaultInput.add("fwidkbp (152) -> mnkwo, ehjooz, jvccsp, cyrrjtx, imynb, chnkkj, agywjrs");
		defaultInput.add("nymhem (52)");
		defaultInput.add("cazid (93)");
		defaultInput.add("olspit (121) -> bqtas, fhuiyrl");
		defaultInput.add("ayteb (92)");
		defaultInput.add("hjucki (58)");
		defaultInput.add("wrqtk (305)");
		defaultInput.add("jfjemon (217) -> bjhickt, uacjhqx");
		defaultInput.add("mcmqliy (925) -> coopirx, ekohgo, ioywk");
		defaultInput.add("rsancy (70) -> aeuub, vchuc, heacb");
		defaultInput.add("zjwpbzs (23) -> jysaup, pgubexv, lckuoqf, eeguu");
		defaultInput.add("qflouyn (90)");
		defaultInput.add("nswximo (65478) -> ibjvonk, sdhtguj, dxyifeb");
		defaultInput.add("rymkqd (102) -> vgqeyx, zezowe");
		defaultInput.add("wlujpl (92) -> sjwhig, wymfopy, ylfsnz");
		defaultInput.add("imcczga (95)");
		defaultInput.add("xehdglb (52)");
		defaultInput.add("twubx (46) -> goimlra, vlimzz, xaoncma, gfzbp, spdhhoe, fhmauag, cyapi");
		defaultInput.add("yjhes (72)");
		defaultInput.add("ymcuygn (81)");
		defaultInput.add("yatbsip (19) -> bkdtinl, nzqcq, tkmed, ysbrui");
		defaultInput.add("yipoeia (58)");
		defaultInput.add("chophr (27)");
		defaultInput.add("tdwtlf (305) -> epuaii, idfwjgx, nwikpdm");
		defaultInput.add("emzrj (119) -> aimav, dtscjna");
		defaultInput.add("vbxmpc (7)");
		defaultInput.add("nrpxx (21)");
		defaultInput.add("wgexpa (103) -> paxzd, vgdwm");
		defaultInput.add("vnrmx (359) -> knzppj, gkkgkp, ttwfig, vcixs");
		defaultInput.add("knltna (677) -> zbhtee, ztzwh");
		defaultInput.add("ojvlwm (52)");
		defaultInput.add("bgflw (27)");
		defaultInput.add("lsdrwz (73)");
		defaultInput.add("hswzo (40)");
		defaultInput.add("spwgm (351) -> mizab, cyzkk");
		defaultInput.add("jlnyr (16)");
		defaultInput.add("nwikpdm (36) -> ihwaeuw, wwkeej");
		defaultInput.add("qbmtmcs (34)");
		defaultInput.add("djirpp (19)");
		defaultInput.add("pkfhp (59)");
		defaultInput.add("qfypnb (76)");
		defaultInput.add("jzequar (272) -> mtcrswx, wkcyd");
		defaultInput.add("tttle (71) -> xlskkfi, ayteb");
		defaultInput.add("zbhtee (48)");
		defaultInput.add("iriun (9)");
		defaultInput.add("dwezv (73)");
		defaultInput.add("tojyt (58) -> dwezv, nbngkou, wnjtb, rarkunn");
		defaultInput.add("bsorz (27)");
		defaultInput.add("qvkotfd (337)");
		defaultInput.add("azxjd (268) -> exeub, lryzkx, nqvxs");
		defaultInput.add("wpxxh (998) -> wrqtk, yosnw, vyxfljc");
		defaultInput.add("gwournc (85)");
		defaultInput.add("aghdlll (88)");
		defaultInput.add("lejgcu (19)");
		defaultInput.add("lxlbt (363) -> oiosol, mpchqe, bsorz, jbpjt");
		defaultInput.add("nbeagw (94)");
		defaultInput.add("vbbgeo (19)");
		defaultInput.add("lqfyzo (21) -> tggkm, zdbqs");
		defaultInput.add("vqclii (331) -> dmkbnot, omdpc");
		defaultInput.add("lhmnd (216) -> onnylx, khaupo");
		defaultInput.add("wwkeej (60)");
		defaultInput.add("laczal (99)");
		defaultInput.add("xrbjn (20)");
		defaultInput.add("qvteg (64)");
		defaultInput.add("ogbsm (92) -> xpzhy, mhsjkm");
		defaultInput.add("ymckwqo (41)");
		defaultInput.add("ghsjtj (271) -> hhmwlo, faixe");
		defaultInput.add("sjrxs (259) -> mnijdlk, hygfoe");
		defaultInput.add("hdvel (197) -> upuxd, dtstgj");
		defaultInput.add("lckuoqf (78)");
		defaultInput.add("yppydul (91)");
		defaultInput.add("frirj (6)");
		defaultInput.add("duftj (42)");
		defaultInput.add("dnmvzeg (64)");
		defaultInput.add("cpazlc (19)");
		defaultInput.add("krxyaak (198) -> maqgick, xbnmvd");
		defaultInput.add("oyczfgb (395) -> rxcnn, ktpte, qybmgto");
		defaultInput.add("oxiuaz (12)");
		defaultInput.add("wfphcf (6)");
		defaultInput.add("ihtnbb (87)");
		defaultInput.add("omsroa (45)");
		defaultInput.add("lybkeg (6022) -> oyczfgb, jzequar, yrcgsnx, ujulj");
		defaultInput.add("agywjrs (184) -> anpnrdt, hgdbaol, hcjmsd, kzbvrxk");
		defaultInput.add("tiujei (34)");
		defaultInput.add("lwencl (28) -> ieusgd, mthhq, fsuzqyz, miwoup, isrtfc");
		defaultInput.add("wekya (34)");
		defaultInput.add("bkdtinl (1167) -> ojsjuts, euoclfs, xbkeua, mykrcq, jjsvfy, aazxafl");
		defaultInput.add("qinmi (1896) -> qshbt, ruozmjk");
		defaultInput.add("yfmxvay (46)");
		defaultInput.add("kgpwo (52)");
		defaultInput.add("fgjjwep (14)");
		defaultInput.add("odvtiti (76)");
		defaultInput.add("ienye (19)");
		defaultInput.add("tcvabyz (99)");
		defaultInput.add("ycclns (7)");
		defaultInput.add("njogewi (30)");
		defaultInput.add("bfchbs (87) -> jykbb, qnbfk");
		defaultInput.add("dlbzng (99)");
		defaultInput.add("xnmvtem (51)");
		defaultInput.add("ccciux (94)");
		defaultInput.add("xwlmsqy (25)");
		defaultInput.add("wekkbw (17)");
		defaultInput.add("yipzce (21)");
		defaultInput.add("hcjmsd (10)");
		defaultInput.add("upvhfmn (68) -> fvlfq, ivmndi, ussmw, ccciux");
		defaultInput.add("hacwv (50)");
		defaultInput.add("redqvw (269)");
		defaultInput.add("dtpexjq (52)");
		defaultInput.add("kmlwj (84)");
		defaultInput.add("mluykm (19)");
		defaultInput.add("ucbbun (114) -> hrqzqqh, ccuarv");
		defaultInput.add("kymhbse (155) -> tznudmk, hnlgkv");
		defaultInput.add("xomnhw (185)");
		defaultInput.add("nsmoh (65) -> ceuygh, acpfsnb, vgubuy, apkwi, yoeau, pdosfg, lfpzff");
		defaultInput.add("zvepqr (51)");
		defaultInput.add("wnotwt (99)");
		defaultInput.add("lcrwbqi (27)");
		defaultInput.add("hdlqvlg (27)");
		defaultInput.add("iphgmyt (160) -> woolxv, ewyzqg");
		defaultInput.add("ujulj (50) -> cazid, npmwcx, yeooycn, dmeee");
		defaultInput.add("zjaklmn (52)");
		defaultInput.add("bjrpalu (53) -> rhodopg, tcospq, cvrcvgp");
		defaultInput.add("azdei (48)");
		defaultInput.add("snzfrer (149) -> bhsbd, tgdzl");
		defaultInput.add("zsxizw (18)");
		defaultInput.add("fwpfjjd (89)");
		defaultInput.add("fndxl (36)");
		defaultInput.add("uzrnud (14)");
		defaultInput.add("igyxt (41)");
		defaultInput.add("vxdkej (135) -> diomq, qokscr");
		defaultInput.add("gjuekv (5)");
		defaultInput.add("uzufet (143) -> fgjjwep, uzrnud");
		defaultInput.add("vzuqbye (87) -> eviqjr, cgxsmq, egmfbdq");
		defaultInput.add("zirocl (29)");
		defaultInput.add("jonshpm (99)");
		defaultInput.add("zmlth (154) -> zhxhkgf, cokzlht");
		defaultInput.add("bujroda (51)");
		defaultInput.add("bdvtvcu (74) -> tvcod, ouamzwh");
		defaultInput.add("jdrdxu (36)");
		defaultInput.add("troyu (29)");
		defaultInput.add("nrczsn (86)");
		defaultInput.add("aihow (92)");
		defaultInput.add("gaihmf (84)");
		defaultInput.add("ehjooz (124) -> hgwsl, mefxonk");
		defaultInput.add("omydd (6)");
		defaultInput.add("raevpsw (64)");
		defaultInput.add("aylmbfh (188) -> ddspu, thdwfw, kxnkbs, rziezq, jfjemon");
		defaultInput.add("diomq (65)");
		defaultInput.add("jjyjrtr (87) -> fjduphn, yjvgwdl");
		defaultInput.add("zsiziaa (38)");
		defaultInput.add("lyptirp (8)");
		defaultInput.add("lctdjj (56)");
		defaultInput.add("pbtks (85)");
		defaultInput.add("jxhrar (227) -> barnhza, iqovqp");
		defaultInput.add("neqfzm (13)");
		defaultInput.add("dhwauy (48)");
		defaultInput.add("qvjqfi (80)");
		defaultInput.add("ivstcsm (72)");
		defaultInput.add("aabrjf (72)");
		defaultInput.add("jvccsp (86) -> gukuqw, hpmbkwb");
		defaultInput.add("ddspu (113) -> yjmbbu, dzbrgb");
		defaultInput.add("zgevpxx (48)");
		defaultInput.add("qrrey (588) -> bhvmgw, wgexpa, xiotwdk");
		defaultInput.add("ncodn (62)");
		defaultInput.add("rbcqgqv (75) -> imcczga, xzurwza");
		defaultInput.add("fpxtub (11)");
		defaultInput.add("ldfopw (30)");
		defaultInput.add("ewyzqg (49)");
		defaultInput.add("iuhlc (6)");
		defaultInput.add("oqphsw (2722) -> iueejt, ekdqf, btbxk, jdshuob");
		defaultInput.add("eysrnaa (71)");
		defaultInput.add("ojsjuts (176) -> njxyw, dzasw, rpzaqc");
		defaultInput.add("ozyexx (83)");
		defaultInput.add("nnldikq (316) -> upwlxnb, vbxmpc, dgwcz");
		defaultInput.add("tfmtk (69)");
		defaultInput.add("hwctdr (76)");
		defaultInput.add("rothisa (66)");
		defaultInput.add("qnbfk (91)");
		defaultInput.add("qcgxvx (99)");
		defaultInput.add("igyiie (237) -> knirl, trbzi, auxvur, rvhxik");
		defaultInput.add("cverrt (52)");
		defaultInput.add("orrutjs (93)");
		defaultInput.add("ffloi (25) -> kflize, icgwppo");
		defaultInput.add("phrxnli (21)");
		defaultInput.add("eopxpo (41)");
		defaultInput.add("vlfouc (62)");
		defaultInput.add("fdnom (87)");
		defaultInput.add("wuxhvnx (86) -> ikfpktb, zcvipz");
		defaultInput.add("flefy (38)");
		defaultInput.add("yoeau (206) -> rfwgtb, drmyco");
		defaultInput.add("ozatmpe (34)");
		defaultInput.add("ydbri (66)");
		defaultInput.add("tufds (42)");
		defaultInput.add("pprhx (57) -> xitzb, zqyua, dtpexjq, zyradhz");
		defaultInput.add("zhxhkgf (29)");
		defaultInput.add("qwzmv (52)");
		defaultInput.add("paxzd (53)");
		defaultInput.add("cyzkk (60)");
		defaultInput.add("gyjxkl (37)");
		defaultInput.add("pzpjw (54)");
		defaultInput.add("svayf (89)");
		defaultInput.add("xxxqpkx (7)");
		defaultInput.add("imihjj (69) -> yygqky, qlkslp");
		defaultInput.add("tkpvf (47)");
		defaultInput.add("tljdqy (81) -> sxllorg, yatfpqx, zbznuyf, kymhbse, rfmeug, tetmzw");
		defaultInput.add("iphzyj (260) -> omsroa, mxupea");
		defaultInput.add("xiotwdk (177) -> jlnyr, nsqqw");
		defaultInput.add("eyyzy (274) -> opuaau, qolnvo, jxhrar");
		defaultInput.add("baewpe (55) -> svkdyq, hitoud, zvnxfa, emfctr, facrq, vykqcnj, bckuyxm");
		defaultInput.add("barnhza (20)");
		defaultInput.add("oafnfo (51)");
		defaultInput.add("pjcttzo (50)");
		defaultInput.add("aooni (205) -> xrvbzya, gvjrx");
		defaultInput.add("scchi (48)");
		defaultInput.add("zcgrnt (73)");
		defaultInput.add("pmsdv (93) -> pyypotx, marzlxh, zvepqr");
		defaultInput.add("kngbqid (89)");
		defaultInput.add("iwhqlr (949) -> ztkgsyt, ffloi, hzgig");
		defaultInput.add("vyxfljc (92) -> pyrlph, wdsiq, eysrnaa");
		defaultInput.add("hddzn (69)");
		defaultInput.add("cxvqvjz (136) -> kfrti, nslettz");
		defaultInput.add("tcospq (96) -> aabrjf, dllgpye");
		defaultInput.add("mnmwzz (142)");
		defaultInput.add("xfblj (40)");
		defaultInput.add("vfwegiu (46)");
		defaultInput.add("iphncut (138) -> wslsg, qhnaxuy");
		defaultInput.add("algqhtz (37) -> qeojk, sybpano");
		defaultInput.add("dmoxr (73)");
		defaultInput.add("tozktyo (29)");
		defaultInput.add("npjxq (46)");
		defaultInput.add("uvfyo (675) -> lxlbt, gnjvf, nfsuzef, spwgm");
		defaultInput.add("ollhxuy (821) -> vefzbc, faecnr, geldsqv, xneoi, cxvqvjz, jgkvfa, xtwdx");
		defaultInput.add("ksvfdcc (72)");
		defaultInput.add("avycyh (180) -> hwosyg, alqim");
		defaultInput.add("nsqqw (16)");
		defaultInput.add("nsfsj (99)");
		defaultInput.add("tpphe (64887) -> yatbsip, syzlt, uttujj");
		defaultInput.add("miwoup (40) -> gyjpoco, apgjv, eknui");
		defaultInput.add("iljwgzf (92)");
		defaultInput.add("bfuywyg (82)");
		defaultInput.add("aaqdb (44)");
		defaultInput.add("fgbyre (11)");
		defaultInput.add("kywfqzv (41) -> lajidkr, gyjxkl, wfhyr, evhsybt");
		defaultInput.add("aiovxpk (95) -> yoxvx, pbtks");
		defaultInput.add("hrovawq (50)");
		defaultInput.add("ajenoz (48)");
		defaultInput.add("aeuub (53)");
		defaultInput.add("gxjvj (163) -> yiusa, nrczsn");
		defaultInput.add("ippzix (9)");
		defaultInput.add("ttllx (73)");
		defaultInput.add("rorqy (43)");
		defaultInput.add("dqash (96)");
		defaultInput.add("lwvnbzs (24)");
		defaultInput.add("ckheb (34)");
		defaultInput.add("rgfndsx (18) -> qkbnq, welll, bkextqn, wnotwt");
		defaultInput.add("rsazi (62)");
		defaultInput.add("rpfmi (52)");
		defaultInput.add("uxslfay (72)");
		defaultInput.add("aemgsa (40)");
		defaultInput.add("jfmnsqg (85)");
		defaultInput.add("ggnsa (114) -> xhmfmo, azdei");
		defaultInput.add("lndaa (175) -> qvjqfi, iyuuh");
		defaultInput.add("kjdoubx (128) -> eopxpo, igyxt");
		defaultInput.add("dzasw (47)");
		defaultInput.add("emfctr (9120) -> qzckx, fsaoa, bjrpalu, mdneq, tdwtlf, hswrbpz, knltna");
		defaultInput.add("srqntb (137) -> raevpsw, qvteg");
		defaultInput.add("wweusm (66)");
		defaultInput.add("hawsl (13)");
		defaultInput.add("cupsjm (146) -> baiaa, pcqyagx");
		defaultInput.add("ppqlc (42)");
		defaultInput.add("tadnt (47) -> ufefj, rwxggm, rorqy");
		defaultInput.add("rvhxik (11)");
		defaultInput.add("vijkx (32)");
		defaultInput.add("lqcar (71)");
		defaultInput.add("dhkahb (49)");
		defaultInput.add("ftuemb (19)");
		defaultInput.add("ewdqb (50)");
		defaultInput.add("npmwcx (93)");
		defaultInput.add("wwezydn (97)");
		defaultInput.add("fuvru (98)");
		defaultInput.add("cdpwklz (83)");
		defaultInput.add("dtscjna (46)");
		defaultInput.add("exuusj (7)");
		defaultInput.add("ouamzwh (88)");
		defaultInput.add("ggvbqrp (145) -> opohwq, yrmgc, gewgn");
		defaultInput.add("ekdqf (467) -> ugvqayz, ysgsry, ogbsm");
		defaultInput.add("torxqh (90) -> dzwol, lepja");
		defaultInput.add("hpmbkwb (69)");
		defaultInput.add("ripqyzr (48)");
		defaultInput.add("eiklbh (32)");
		defaultInput.add("omdlwm (168) -> ihtnbb, hjjkx, bomho");
		defaultInput.add("lbwzat (74) -> iivncbz, dmoxr");
		defaultInput.add("pyypotx (51)");
		defaultInput.add("bjabd (7)");
		defaultInput.add("auzbdlz (95)");
		defaultInput.add("sxfilp (72) -> livlj, lgenxz");
		defaultInput.add("kxvlprg (60)");
		defaultInput.add("rfmeug (121) -> apygt, viwns, chtlcwq, wekkbw");
		defaultInput.add("xajjyba (164)");
		defaultInput.add("kzltfq (94288) -> vnrmx, lrihy, arqoys, nsmoh");
		defaultInput.add("mbhld (73)");
		defaultInput.add("rwxggm (43)");
		defaultInput.add("vapwxei (61)");
		defaultInput.add("ufefj (43)");
		defaultInput.add("oajawn (34)");
		defaultInput.add("dgnjf (335) -> yxseri, nscbsob");
		defaultInput.add("xaoncma (296) -> yipzce, nrpxx, rrfbngi");
		defaultInput.add("kqlsniq (95) -> qwsxpnc, mqmbcl, gtbbuvb");
		defaultInput.add("jrvbacq (49)");
		defaultInput.add("oavluo (21)");
		defaultInput.add("qpldch (54)");
		defaultInput.add("ieusgd (295)");
		defaultInput.add("tifgptk (100) -> ddldgex, ggvbqrp, focqhgt, cncak, ksvpnt, weuwc");
		defaultInput.add("lhradm (583) -> vusxa, lbwzat, ucbbun");
		defaultInput.add("apgjv (85)");
		defaultInput.add("cbibo (99)");
		defaultInput.add("jxhngrl (48)");
		defaultInput.add("qwsxpnc (96)");
		defaultInput.add("ysbrui (1293) -> iqggu, upvhfmn, kpqyb, wdeuy");
		defaultInput.add("ekvall (209) -> jxhngrl, aplvqql, drwfop");
		defaultInput.add("mkwfj (35)");
		defaultInput.add("pjiqvd (87)");
		defaultInput.add("pgubexv (78)");
		defaultInput.add("vbhnmr (2850) -> iftfc, kunzpa, qrrey, tljdqy");
		defaultInput.add("sjwhig (93)");
		defaultInput.add("zyradhz (52)");
		defaultInput.add("wcexum (116) -> eiklbh, vijkx");
		defaultInput.add("cdcye (53) -> izppmg, rxvyqsp");
		defaultInput.add("bdinafh (10)");
		defaultInput.add("rziezq (145) -> taiho, pkfhp");
		defaultInput.add("nslettz (10)");
		defaultInput.add("svhbd (109) -> xcvxle, fqzsq, jopjvd");
		defaultInput.add("limljj (68)");
		defaultInput.add("kauphp (231) -> dyxsmz, yzxzo");
		defaultInput.add("caryo (7)");
		defaultInput.add("nahovfk (109) -> flefy, cfztpc");
		defaultInput.add("qolnvo (267)");
		defaultInput.add("cmqwplb (9)");
		defaultInput.add("cfhuce (71) -> cecsr, josdslh");
		defaultInput.add("zwnvqu (88)");
		defaultInput.add("mhjtjp (91)");
		defaultInput.add("apkwi (222) -> rxragg, zsxizw");
		defaultInput.add("ioywk (16) -> ozyexx, eikmns, ktjav");
		defaultInput.add("yrmgc (31)");
		defaultInput.add("kqzemkv (96)");
		defaultInput.add("rxvyqsp (60)");
		defaultInput.add("hnlgkv (17)");
		defaultInput.add("raryuo (73)");
		defaultInput.add("bomho (87)");
		defaultInput.add("rixnft (85) -> cpndnx, fpxtub");
		defaultInput.add("zoewj (193) -> ohbuhy, ymckwqo");
		defaultInput.add("hnyqq (34)");
		defaultInput.add("tkmed (1959) -> tuqmup, jwgchxu, sjforw, zmsosb, tqikxkp");
		defaultInput.add("wlpyulp (10)");
		defaultInput.add("pixjzh (158) -> fgjwz, lsknlg, hlcghe, txhfuoh, hdvel");
		defaultInput.add("likvlm (62)");
		defaultInput.add("xhmfmo (48)");
		defaultInput.add("rgrxpe (69)");
		defaultInput.add("weuwc (84) -> xtwdau, muncur");
		defaultInput.add("uevcwul (92)");
		defaultInput.add("kpxqlr (155) -> nbbyqsa, ilkqp");
		defaultInput.add("fqzsq (98) -> tiujei, yhubw");
		defaultInput.add("ubovv (6)");
		defaultInput.add("knirl (11)");
		defaultInput.add("lzvniiz (60)");
		defaultInput.add("cwtdf (29)");
		defaultInput.add("qeojk (99)");
		defaultInput.add("ycxzfkf (131) -> bgflw, chophr");
		defaultInput.add("thjulip (20)");
		defaultInput.add("vgdwm (53)");
		defaultInput.add("myhch (25)");
		defaultInput.add("bovno (175)");
		defaultInput.add("uqlso (48)");
		defaultInput.add("rhnkdt (59) -> rsazi, ncodn, pwizhzr, likvlm");
		defaultInput.add("acpfsnb (204) -> nmlcne, vfsttaj");
		defaultInput.add("wzfkk (99)");
		defaultInput.add("oqlpz (81)");
		defaultInput.add("nscbsob (24)");
		defaultInput.add("mzmfygf (171) -> jxyoypa, ippzix");
		defaultInput.add("rvrlma (211)");
		defaultInput.add("pfphng (90)");
		defaultInput.add("mdiqsgg (12)");
		defaultInput.add("jtzkva (274) -> flomey, ukvvt");
		defaultInput.add("tvwxmur (64) -> yodoqn, ksvfdcc, ivstcsm, pvgzz");
		defaultInput.add("aplvqql (48)");
		defaultInput.add("qybmgto (9)");
		defaultInput.add("mtcrswx (75)");
		defaultInput.add("aphpzub (29)");
		defaultInput.add("vchsdif (105) -> ofisj, zwnvqu");
		defaultInput.add("dllgpye (72)");
		defaultInput.add("lfzahrm (79)");
		defaultInput.add("oiosol (27)");
		defaultInput.add("geldsqv (80) -> ienye, eeppf, ftuemb, vbbgeo");
		defaultInput.add("vlbba (81) -> ewdqb, vfzby, pjcttzo, abddskq");
		defaultInput.add("nfsuzef (75) -> dlbzng, cbibo, wzfkk, jonshpm");
		defaultInput.add("lryzkx (71)");
		defaultInput.add("mhndszl (190) -> tbrfk, xprzeeb");
		defaultInput.add("jbepak (66)");
		defaultInput.add("nmlcne (27)");
		defaultInput.add("gfffvbp (8)");
		defaultInput.add("bqtas (93)");
		defaultInput.add("fhmauag (221) -> vantwg, kzwqzqf, vfwegiu");
		defaultInput.add("misyfn (82) -> uixlx, oupzsh, bovno");
		defaultInput.add("jtauf (13) -> xskehl, bmfhjm, srhirm, kjfmqkt, qzxaqvy");
		defaultInput.add("eerktn (85) -> npjxq, kasfuwe, ljbss, theau");
		defaultInput.add("ktaet (58)");
		defaultInput.add("eeppf (19)");
		defaultInput.add("vgqeyx (31)");
		defaultInput.add("qhnaxuy (31)");
		defaultInput.add("xrvbzya (35)");
		defaultInput.add("nzqcq (66) -> vewgrvp, vfngjd, sjrxs, hvjtn, ecokyy, gcaxntb, omdlwm");
		defaultInput.add("sybpano (99)");
		defaultInput.add("ebsniof (39)");
		defaultInput.add("urzul (9)");
		defaultInput.add("srmiagk (292) -> dvdgowj, vqpeg, gjuekv");
		defaultInput.add("uexdnv (82)");
		defaultInput.add("pgspysb (40)");
		defaultInput.add("wymfopy (93)");
		defaultInput.add("nqhdt (164) -> mkwfj, gjwaqu, sxmbcwp");
		defaultInput.add("twzpqip (41)");
		defaultInput.add("bniti (66)");
		defaultInput.add("yfjenp (295) -> qxfce, zsiziaa");
		defaultInput.add("meoeea (60) -> laczal, tcvabyz");
		defaultInput.add("heacb (53)");
		defaultInput.add("focqhgt (238)");
		defaultInput.add("dtstgj (36)");
		defaultInput.add("kkmqko (7)");
		defaultInput.add("vcjjo (98)");
		defaultInput.add("nnnkeh (445) -> gzzpja, bhuyfk, xnukvni, tttle, snzfrer");
		defaultInput.add("baesyhf (1013) -> tznkwk, hcjxz");
		defaultInput.add("hygfoe (85)");
		defaultInput.add("wtxbqe (87)");
		defaultInput.add("vwzglf (58)");
		defaultInput.add("hswrbpz (254) -> flcqsb, sbguah, cdcye");
		defaultInput.add("axtqrx (29)");
		defaultInput.add("auxvur (11)");
		defaultInput.add("iqggu (444)");
		defaultInput.add("kceusl (42)");
		defaultInput.add("jykbb (91)");
		defaultInput.add("nxzkuj (75)");
		defaultInput.add("xzurwza (95)");
		defaultInput.add("rrflox (52)");
		defaultInput.add("kfmzbvk (10)");
		defaultInput.add("mnkwo (212) -> jyskb, wfphcf");
		defaultInput.add("dfvhic (82) -> fhmazv, hwctdr");
		defaultInput.add("gfzbp (197) -> ymcuygn, mxzbcqn");
		defaultInput.add("tlednk (39)");
		defaultInput.add("lgenxz (54)");
		defaultInput.add("emwbbut (9)");
		defaultInput.add("exoft (17)");
		defaultInput.add("woolxv (49)");
		defaultInput.add("auxqbbc (87)");
		defaultInput.add("wvocz (67)");
		defaultInput.add("hvjtn (325) -> cverrt, kfxoi");
		defaultInput.add("aunhcg (613) -> kjdoubx, ggnsa, acknlp");
		defaultInput.add("absdwf (39)");
		defaultInput.add("wajnxjj (40) -> imjzf, wwezydn");
		defaultInput.add("hgdbaol (10)");
		defaultInput.add("cfztpc (38)");
		defaultInput.add("chlxm (46)");
		defaultInput.add("ljbss (46)");
		defaultInput.add("gauumxf (230) -> tkiraal, lyptirp");
		defaultInput.add("nhlittn (22)");
		defaultInput.add("gcaxntb (405) -> mdiqsgg, oxiuaz");
		defaultInput.add("lfxew (66)");
		defaultInput.add("bamxg (66)");
		defaultInput.add("wdsiq (71)");
		defaultInput.add("mykrcq (98) -> zcgrnt, raryuo, okrdziq");
		defaultInput.add("erpvue (91)");
		defaultInput.add("kmwbbz (93)");
		defaultInput.add("vsgaam (7)");
		defaultInput.add("hokyk (66)");
		defaultInput.add("pjzpmq (38)");
		defaultInput.add("iqovqp (20)");
		defaultInput.add("mmcychg (65)");
		defaultInput.add("guncf (259) -> proshun, wxjka");
		defaultInput.add("jatnl (216) -> oavluo, phrxnli");
		defaultInput.add("nhkvp (100) -> rgrxpe, nscav, illjvf");
		defaultInput.add("hcjxz (31)");
		defaultInput.add("mqrroj (243) -> jtjcj, dnmvzeg");
		defaultInput.add("lvksghj (18)");
		defaultInput.add("mhsjkm (84)");
		defaultInput.add("popplum (89)");
		defaultInput.add("vusxa (30) -> ieadjz, mzmtuw");
		defaultInput.add("dmkbnot (26)");
		defaultInput.add("httit (18)");
		defaultInput.add("tbrfk (19)");
		defaultInput.add("ztzwh (48)");
		defaultInput.add("imjzf (97)");
		defaultInput.add("rypdxr (105) -> qyoqb, lejgcu, djirpp");
		defaultInput.add("qzckx (35) -> qzzkvf, pmsdv, gauumxf");
		defaultInput.add("xbnmvd (76)");
		defaultInput.add("ouymke (47)");
		defaultInput.add("rajtef (365) -> iriun, ezaypy");
		defaultInput.add("itngcua (65)");
		defaultInput.add("orxoo (66)");
		defaultInput.add("tcdwurt (18)");
		defaultInput.add("auqoj (99)");
		defaultInput.add("sqnvvbg (36)");
		defaultInput.add("rxragg (18)");
		defaultInput.add("kpqyb (258) -> sqkcdf, iqxwh, vnhvilk");
		defaultInput.add("proshun (47)");
		defaultInput.add("uscufoy (15)");
		defaultInput.add("tpipb (61)");
		defaultInput.add("owhjmt (155) -> vsruoi, ifxcrug");
		defaultInput.add("bkvle (9)");
		defaultInput.add("yosnw (32) -> ilymgq, yppydul, yamclb");
		defaultInput.add("iynywq (66)");
		defaultInput.add("nxpexoq (92)");
		defaultInput.add("eviqjr (25)");
		defaultInput.add("trbzi (11)");
		defaultInput.add("rfvomn (95)");
		defaultInput.add("ohbuhy (41)");
		defaultInput.add("vkpltts (73)");
		defaultInput.add("ktpte (9)");
		defaultInput.add("bbgwzg (79)");
		defaultInput.add("bgcigo (8) -> bruzfkf, lxcbjgy, vlmcmcu");
		defaultInput.add("ecokyy (357) -> iaphzk, httit, vztnh, owmni");
		defaultInput.add("jwgchxu (32) -> rfvomn, auzbdlz");
		defaultInput.add("xlskkfi (92)");
		defaultInput.add("uxjasn (36)");
		defaultInput.add("dcumfo (73)");
		defaultInput.add("wpnqet (87)");
		defaultInput.add("ilqol (88)");
		defaultInput.add("bhsbd (53)");
		defaultInput.add("flcqsb (115) -> meypo, aphpzub");
		defaultInput.add("yvqtyi (85)");
		defaultInput.add("oyvhouc (37) -> cdpgoi, bbgwzg, xoziel, lfzahrm");
		defaultInput.add("bjhickt (23)");
		defaultInput.add("hmvwl (32) -> nswximo, tpphe, baewpe, hghnmib, kzltfq");
		defaultInput.add("oiijtm (20)");
		defaultInput.add("ylfsnz (93)");
		defaultInput.add("imynb (146) -> absdwf, cikaze");
		defaultInput.add("yygqky (82)");
		defaultInput.add("yuswp (68)");
		defaultInput.add("izppmg (60)");
		defaultInput.add("itwbpot (22)");
		defaultInput.add("hwosyg (42)");
		defaultInput.add("mkrzp (211) -> laxsl, zirocl");
		defaultInput.add("vqpeg (5)");
		defaultInput.add("gddkqw (244) -> vhtyadn, lvksghj");
		defaultInput.add("bhuyfk (79) -> aghdlll, ilqol");
		defaultInput.add("yrfqaga (103) -> jqinti, zjaklmn");
		defaultInput.add("bnfopv (118) -> cjmxed, zlzers, qrlggma");
		defaultInput.add("welll (99)");
		defaultInput.add("ehuzoq (77)");
		defaultInput.add("nqyok (77)");
		defaultInput.add("rrfbngi (21)");
		defaultInput.add("yoezrpw (38)");
		defaultInput.add("rpzaqc (47)");
		defaultInput.add("qxlucvg (84)");
		defaultInput.add("tehyhc (13)");
		defaultInput.add("gqrfok (231) -> kfhnhm, aituccf, qrkhol");
		defaultInput.add("zvnxfa (10022) -> aylmbfh, lwencl, pixjzh");
		defaultInput.add("gzzpja (255)");
		defaultInput.add("ofrwmq (205) -> iigvpqy, wweusm");
		defaultInput.add("qanbo (50)");
		defaultInput.add("obslyn (13)");
		defaultInput.add("hwovhvw (915) -> qdhrchr, nahovfk, xomnhw, ycxzfkf");
		defaultInput.add("smlfbc (1615) -> wnjwnr, pprhx, aiovxpk");
		defaultInput.add("xbkeua (157) -> pgspysb, aemgsa, xfblj, hswzo");
		defaultInput.add("btklib (51)");
		defaultInput.add("owmni (18)");
		defaultInput.add("qzzkvf (108) -> aobitc, tsrogy");
		defaultInput.add("umtrod (22)");
		defaultInput.add("vxajmkg (71)");
		defaultInput.add("jmlmzpz (62)");
		defaultInput.add("plurwe (228)");
		defaultInput.add("jyskb (6)");
		defaultInput.add("xnuoujm (16)");
		defaultInput.add("nakmo (10)");
		defaultInput.add("uzhlers (50)");
		defaultInput.add("umlkxqv (20) -> ecimj, wudjf, jfmnsqg");
		defaultInput.add("ziqwzzy (204) -> uscufoy, fooyrq");
		defaultInput.add("ymrogz (272) -> ebsniof, tlednk");
		defaultInput.add("lpuass (28)");
		defaultInput.add("qrkhol (9)");
		defaultInput.add("hpkpw (38)");
		defaultInput.add("gtzcxq (73)");
		defaultInput.add("gvjrx (35)");
		defaultInput.add("ieadjz (95)");
		defaultInput.add("tcukgv (66)");
		defaultInput.add("ifxcrug (55)");
		defaultInput.add("thxtoc (178) -> trtgn, fdnom");
		defaultInput.add("puwvse (414)");
		defaultInput.add("pvppi (246) -> qlwxeb, nuqyqh");
		defaultInput.add("vcixs (260) -> noipcz, frohei");
		defaultInput.add("cichyqw (71)");
		defaultInput.add("ugvqayz (126) -> xfekjt, wvocz");
		defaultInput.add("hrqzqqh (53)");
		defaultInput.add("qedst (18)");
		defaultInput.add("wnjtb (73)");
		defaultInput.add("kjfmqkt (138) -> pzpjw, qpldch");
		defaultInput.add("ussmw (94)");
		defaultInput.add("sxmbcwp (35)");
		defaultInput.add("dqdfv (73)");
		defaultInput.add("ptyxo (13)");
		defaultInput.add("upuxd (36)");
		defaultInput.add("fppcif (209) -> uxslfay, yjhes");
		defaultInput.add("kxykfr (82) -> twzpqip, qymwy");
		defaultInput.add("yodoqn (72)");
		defaultInput.add("mnzbkuh (28) -> jtouvtb, wdvwub");
		defaultInput.add("omdpc (26)");
		defaultInput.add("ccrftvw (62)");
		defaultInput.add("bmfhjm (222) -> lyvyhkm, sbyxyf, kblshw");
		defaultInput.add("fwgqj (1924) -> zmcgfdp, vzuqbye, rypdxr");
		defaultInput.add("rlbom (79)");
		defaultInput.add("livlj (54)");
		defaultInput.add("ybvgki (8)");
		defaultInput.add("zcvipz (97)");
		defaultInput.add("xyohoxa (928) -> qkkzzlm, lmuyfcw, avycyh");
		defaultInput.add("dchts (99) -> lctdjj, oevyknd");
		defaultInput.add("ksfok (217) -> gfffvbp, ybvgki");
		defaultInput.add("hoomyh (88) -> aaqdb, ljfqvk");
		defaultInput.add("qijarlh (58)");
		defaultInput.add("tznudmk (17)");
		defaultInput.add("cyrrjtx (124) -> oqbdf, xwlmsqy, ulztj, rjsnth");
		defaultInput.add("nuqyqh (52)");
		defaultInput.add("oblsboq (85)");
		defaultInput.add("imnhql (94)");
		defaultInput.add("hxswghs (126) -> dwwsu, hdlqvlg, jppgd");
		defaultInput.add("ulztj (25)");
		defaultInput.add("hgwsl (50)");
		defaultInput.add("ksvpnt (96) -> fqlezvk, lqcar");
		defaultInput.add("mjpzp (10)");
		defaultInput.add("fsaoa (89) -> dbwmq, uzufet, arwmalf, gobrf");
		defaultInput.add("iftfc (159) -> thxtoc, jtzkva, tvwxmur");
		defaultInput.add("zjpsm (83)");
		defaultInput.add("vwfhi (9)");
		defaultInput.add("opuaau (75) -> dqash, kqzemkv");
		defaultInput.add("mxupea (45)");
		defaultInput.add("dmkyzy (15) -> ttllx, horqcc, dcumfo");
		defaultInput.add("sxllorg (69) -> kxvlprg, lzvniiz");
		defaultInput.add("txhfuoh (219) -> lwdqnj, myhch");
		defaultInput.add("chtlcwq (17)");
		defaultInput.add("hlcbqu (104) -> ccrftvw, jmlmzpz");
		defaultInput.add("ivmndi (94)");
		defaultInput.add("lficpr (62)");
		defaultInput.add("ortqc (99)");
		defaultInput.add("dvzlq (33)");
		defaultInput.add("acknlp (56) -> aozoac, ehuzoq");
		defaultInput.add("jqxnf (60)");
		defaultInput.add("hfftu (52)");
		defaultInput.add("ihzvygq (94) -> kmwbbz, orrutjs");
		defaultInput.add("rarkunn (73)");
		defaultInput.add("hitoud (5511) -> vcktg, rqbjbio, xtyzy, ssdgbnh");
		defaultInput.add("sdhtguj (58) -> uklsrym, mcmqliy, nnnkeh, clinrg, fwidkbp, hzmhm, xyohoxa");
		defaultInput.add("hrlkgen (99)");
		defaultInput.add("vuyzhsh (61)");
		defaultInput.add("nzzfer (85) -> qcgxvx, ortqc, auqoj, ilfzi");
		defaultInput.add("tuqmup (222)");
		defaultInput.add("zbznuyf (137) -> ptyxo, qwtzc, neqfzm, hawsl");
		defaultInput.add("qwtzc (13)");
		defaultInput.add("vykqcnj (71) -> jitzj, nkhadt, tcsbho, fhxpkd, fwgqj, smlfbc");
		defaultInput.add("mjzksjz (7)");
		defaultInput.add("yfdtz (36)");
		defaultInput.add("faixe (56)");
		defaultInput.add("tejnuve (209) -> jgmisxl, dhkahb");
		defaultInput.add("opohwq (31)");
		defaultInput.add("lsknlg (95) -> vwzglf, hjucki, yrkvb");
		defaultInput.add("fhmazv (76)");
		defaultInput.add("egmfbdq (25)");
		defaultInput.add("rxcnn (9)");
		defaultInput.add("tboizos (250)");
		defaultInput.add("glwhd (122) -> ceoav, troyu");
		defaultInput.add("ykehxw (19)");
		defaultInput.add("bruzfkf (91)");
		defaultInput.add("rjjlus (87)");
		defaultInput.add("ocnna (18)");
		defaultInput.add("qshbt (73)");
		defaultInput.add("raakduh (85) -> fuvru, vcjjo");
		defaultInput.add("wudjf (85)");
		defaultInput.add("ihwaeuw (60)");
		defaultInput.add("kfxoi (52)");
		defaultInput.add("oewzluz (39)");
		defaultInput.add("coopirx (251) -> exuusj, rvimq");
		defaultInput.add("cokzlht (29)");
		defaultInput.add("uacjhqx (23)");
		defaultInput.add("tznkwk (31)");
		defaultInput.add("mthhq (111) -> uevcwul, nxpexoq");
		defaultInput.add("uixlx (7) -> kmlwj, gaihmf");
		defaultInput.add("nqvxs (71)");
		defaultInput.add("ktjav (83)");
		defaultInput.add("eknui (85)");
		defaultInput.add("fhuiyrl (93)");
		defaultInput.add("fktsu (65)");
		defaultInput.add("vugnug (65)");
		defaultInput.add("ilymgq (91)");
		defaultInput.add("clinrg (1033) -> rsancy, jrqorlo, lvklj");
		defaultInput.add("bkextqn (99)");
		defaultInput.add("ekohgo (251) -> xxxqpkx, wkphn");
		defaultInput.add("alkneau (34)");
		defaultInput.add("mnijdlk (85)");
		defaultInput.add("dyxsmz (38)");
		defaultInput.add("mefxonk (50)");
		defaultInput.add("lajidkr (37)");
		defaultInput.add("uiuokpq (89)");
		defaultInput.add("oupzsh (43) -> bzmade, bamxg");
		defaultInput.add("cijptz (18)");
		defaultInput.add("khibjj (89)");
		defaultInput.add("yamclb (91)");
		defaultInput.add("okrdziq (73)");
		defaultInput.add("sbyxyf (8)");
		defaultInput.add("zknziw (18)");
		defaultInput.add("fobzai (75)");
		defaultInput.add("rjsnth (25)");
		defaultInput.add("iaphzk (18)");
		defaultInput.add("lufgosn (10)");
		defaultInput.add("rzkcu (34)");
		defaultInput.add("xlhfyw (471) -> yuswp, limljj");
		defaultInput.add("tcsbho (1842) -> mnmwzz, mnzbkuh, zpidc, cpqti");
		defaultInput.add("docln (85)");
		defaultInput.add("neeqb (7)");
		defaultInput.add("tvcod (88)");
		defaultInput.add("uklsrym (40) -> bbhniy, gddkqw, lhmnd, ihzvygq, nhkeb, wuxhvnx");
		defaultInput.add("qkkzzlm (76) -> imnhql, nbeagw");
		defaultInput.add("qywkuqu (20)");
		defaultInput.add("fvgbg (191) -> iwkntdi, jdrdxu, sqnvvbg, yfdtz");
		defaultInput.add("qlkslp (82)");
		defaultInput.add("iqxwh (62)");
		defaultInput.add("mdneq (623) -> uzhlers, qanbo, tedplb");
		defaultInput.add("msmgk (173) -> fygmpjn, exoft");
		defaultInput.add("euoclfs (241) -> pjzpmq, hpkpw");
		defaultInput.add("vlimzz (19) -> yvqtyi, gwournc, docln, oblsboq");
		defaultInput.add("zoqni (189) -> chlxm, yfmxvay");
		defaultInput.add("oignan (206) -> hdaqxlh, fgbyre");
		defaultInput.add("zpidc (40) -> bujroda, btklib");
		defaultInput.add("aazxafl (215) -> xnmvtem, oafnfo");
		defaultInput.add("yhubw (34)");
		defaultInput.add("xneoi (138) -> vwfhi, cmqwplb");
		defaultInput.add("vefzbc (138) -> dywqvqh, emwbbut");
		defaultInput.add("ruozmjk (73)");
		defaultInput.add("jrwfehi (75) -> kcnim, bdvtvcu, tfsoxgb, tboizos");
		defaultInput.add("iivncbz (73)");
		defaultInput.add("ccuarv (53)");
		defaultInput.add("lrihy (185) -> vchsdif, bgcigo, raakduh, vlbba, igyiie, zoqni");
		defaultInput.add("vewgrvp (73) -> dntphko, svayf, uiuokpq, popplum");
		defaultInput.add("iigvpqy (66)");
		defaultInput.add("fjduphn (91)");
		defaultInput.add("uttujj (11755) -> glwhd, sxfilp, wcexum");
		defaultInput.add("tluap (6)");
		defaultInput.add("exeub (71)");
		defaultInput.add("dzwol (61)");
		defaultInput.add("ilfzi (99)");
		defaultInput.add("cdpgoi (79)");
		defaultInput.add("hxckb (71)");
		defaultInput.add("yoxvx (85)");
		defaultInput.add("theau (46)");
		defaultInput.add("vwnjh (233) -> jqxnf, qfpwln");
		defaultInput.add("jbpjt (27)");
		defaultInput.add("zmsosb (14) -> rrflox, ovluts, rpfmi, ojvlwm");
		defaultInput.add("yoivja (59)");
		defaultInput.add("towlhi (36)");
		defaultInput.add("zcrjb (253) -> qhohy, uwaiki");
		defaultInput.add("josdslh (59)");
		defaultInput.add("xoziel (79)");
		defaultInput.add("fsuzqyz (169) -> duftj, ppqlc, kceusl");
		defaultInput.add("chwjiub (96)");
		defaultInput.add("fpbsu (89)");
		defaultInput.add("qyoqb (19)");
		defaultInput.add("dfeomzr (38)");
		defaultInput.add("kfhnhm (9)");
		defaultInput.add("oevyknd (56)");
		defaultInput.add("buoakk (22)");
		defaultInput.add("wduqgix (77)");
		defaultInput.add("qokscr (65)");
		defaultInput.add("oqbdf (25)");
		defaultInput.add("jjsvfy (199) -> yoivja, gdnsat");
		defaultInput.add("ssdgbnh (887) -> qtsjbq, plurwe, mhndszl, hlcbqu, pgskth, oignan");
		defaultInput.add("lrsedv (213) -> eaqjcju, cekpxgj");
		defaultInput.add("iwkntdi (36)");
		defaultInput.add("qfgzmtz (73)");
		defaultInput.add("rfwgtb (26)");
		defaultInput.add("alcvj (7)");
		defaultInput.add("bvdxf (30)");
		defaultInput.add("ofisj (88)");
		defaultInput.add("mpchqe (27)");
		defaultInput.add("pwizhzr (62)");
		defaultInput.add("wkcyd (75)");
		defaultInput.add("mxzbcqn (81)");
		defaultInput.add("npzdqeg (227) -> tufds, msxhvo, pcsucog");
		defaultInput.add("illjvf (69)");
		defaultInput.add("iyuuh (80)");
		defaultInput.add("fygmpjn (17)");
		defaultInput.add("dvdgowj (5)");
		defaultInput.add("hlcghe (91) -> khibjj, kngbqid");
		defaultInput.add("zvurtb (77)");
		defaultInput.add("ouspx (46)");
		defaultInput.add("dbvxai (76)");
		defaultInput.add("facrq (13496) -> fkbla, ffvprc, yrfqaga, msmgk, hxswghs");
		defaultInput.add("xbcgipi (66)");
		defaultInput.add("wfhyr (37)");
		defaultInput.add("ziyata (221) -> oqlpz, jjtrisl");
		defaultInput.add("muncur (77)");
		defaultInput.add("vlvss (183) -> odvtiti, fazqw");
		defaultInput.add("kvdkwy (96)");
		defaultInput.add("ddldgex (84) -> nqyok, wduqgix");
		defaultInput.add("trtgn (87)");
		defaultInput.add("jitzj (65) -> fvgbg, nbfqgr, zjwpbzs, lndaa, vlvss, gxjvj, zcrjb");
		defaultInput.add("hkhoyje (95) -> frirj, iuhlc");
		defaultInput.add("gtbbuvb (96)");
		defaultInput.add("tfsoxgb (250)");
		defaultInput.add("rohvy (95)");
		defaultInput.add("qhohy (41)");
		defaultInput.add("goimlra (227) -> orxoo, lfxew");
		defaultInput.add("hubbqbi (95)");
		defaultInput.add("vchuc (53)");
		defaultInput.add("svkdyq (9559) -> akmgfo, lhradm, jtauf, aunhcg");
		defaultInput.add("fazqw (76)");
		defaultInput.add("flomey (39)");
		defaultInput.add("apygt (17)");
		defaultInput.add("wjptb (43)");
		defaultInput.add("srhirm (147) -> bicsjoc, dvzlq, olykwbi");
		defaultInput.add("wdeuy (254) -> hubbqbi, rohvy");
		defaultInput.add("yeooycn (93)");
		defaultInput.add("qoyzgsp (28)");
		defaultInput.add("sqkcdf (62)");
		defaultInput.add("rgbvlc (49)");
		defaultInput.add("qinzaf (813) -> aooni, zoewj, ogzrdrk, umlkxqv");
		defaultInput.add("kflize (84)");
		defaultInput.add("isrtfc (201) -> vmutyru, ouymke");
		defaultInput.add("nkhadt (292) -> fppcif, vwnjh, oyvhouc, ekvall, guncf, npzdqeg");
		defaultInput.add("nbbyqsa (40)");
		defaultInput.add("ikfpktb (97)");
		defaultInput.add("maqgick (76)");
		defaultInput.add("xtwdx (156)");
		defaultInput.add("sbyzsq (10)");
		defaultInput.add("vgubuy (74) -> iljwgzf, aihow");
		defaultInput.add("taiho (59)");
		defaultInput.add("cpndnx (11)");
		defaultInput.add("vhtyadn (18)");
		defaultInput.add("aaheijb (54)");
		defaultInput.add("rykadr (19)");
		defaultInput.add("onnylx (32)");
		defaultInput.add("gukuqw (69)");
		defaultInput.add("fooyrq (15)");
		defaultInput.add("zqyua (52)");
		defaultInput.add("vsruoi (55)");
		defaultInput.add("ikmvhid (2745) -> hwovhvw, arsuc, yzrdupu");
		defaultInput.add("vztnh (18)");
		defaultInput.add("khaupo (32)");
		defaultInput.add("cpqti (142)");
		defaultInput.add("qtsjbq (126) -> wekya, rzkcu, alkneau");
		defaultInput.add("pcsucog (42)");
		defaultInput.add("lepja (61)");
		defaultInput.add("ibjvonk (10277) -> xlhfyw, svhbd, misyfn");
		defaultInput.add("rqbjbio (29) -> mqrroj, hjeysaa, wlujpl, vooac, rrggg, yfjenp");
		defaultInput.add("ceuygh (90) -> aqxsjq, qxlucvg");
		defaultInput.add("qzxaqvy (78) -> fwskxtt, jlgvplm");
		defaultInput.add("fwskxtt (84)");
		defaultInput.add("yrkvb (58)");
		defaultInput.add("thdwfw (219) -> umtrod, nhlittn");
		defaultInput.add("zpkbe (73) -> cwtdf, tozktyo, qcrpdy, axtqrx");
		defaultInput.add("hjjkx (87)");
		defaultInput.add("jxyoypa (9)");
		defaultInput.add("ilkqp (40)");
		defaultInput.add("akwvj (238) -> jatnl, iphgmyt, meoeea, gqrfok, ljhwzvv");
		defaultInput.add("lkcddrg (2238) -> lqfyzo, rixnft, hkhoyje");
		defaultInput.add("xprzeeb (19)");
		defaultInput.add("rhodopg (94) -> qfgzmtz, dqdfv");
		defaultInput.add("ttwfig (340) -> rykadr, ykehxw");
		defaultInput.add("kueyf (85) -> ulbbc, nzzfer, azxjd");
		defaultInput.add("zmcgfdp (136) -> tehyhc, obslyn");
		defaultInput.add("ffnabs (20) -> guehoas, nnldikq, ofrwmq, lrsedv, qvkotfd, shfdaba");
		defaultInput.add("arwmalf (143) -> vsgaam, bjabd, ycclns, kkmqko");
		defaultInput.add("gyjpoco (85)");
		defaultInput.add("drmyco (26)");
		defaultInput.add("arqoys (1859) -> urzul, bkvle");
		defaultInput.add("nscav (69)");
		defaultInput.add("tsrogy (69)");
		defaultInput.add("qhafxnl (1337) -> xbcskih, kpxqlr, algqhtz");
		defaultInput.add("yiusa (86)");
		defaultInput.add("zdbqs (43)");
		defaultInput.add("xzppxad (58) -> ltxkw, ollhxuy, qinzaf, wpxxh");
		defaultInput.add("dxyifeb (1862) -> twubx, lkcddrg, uwqgz, uvfyo");
		defaultInput.add("zlzers (49)");
		defaultInput.add("gkkgkp (358) -> wlpyulp, nakmo");
		defaultInput.add("abddskq (50)");
		defaultInput.add("tggkm (43)");
		defaultInput.add("dgwcz (7)");
		defaultInput.add("bhvmgw (29) -> qflouyn, pfphng");
		defaultInput.add("guehoas (283) -> qedst, cijptz, zknziw");
		defaultInput.add("marzlxh (51)");
		defaultInput.add("mizab (60)");
		defaultInput.add("jgkvfa (120) -> ocnna, tcdwurt");
		defaultInput.add("jopjvd (80) -> dnouufu, wjptb");
		defaultInput.add("lwdqnj (25)");
		defaultInput.add("xpzhy (84)");
		defaultInput.add("noipcz (59)");
		defaultInput.add("bbhniy (20) -> itngcua, mmcychg, vugnug, fktsu");
		defaultInput.add("jtjcj (64)");
		defaultInput.add("tgdzl (53)");
		defaultInput.add("gobrf (25) -> gtzcxq, lsdrwz");
		defaultInput.add("arsuc (65) -> rbcqgqv, huwsoc, bnfopv, srqntb, vxdkej, owhjmt");
		defaultInput.add("ogzrdrk (101) -> vztbn, wtxbqe");
		defaultInput.add("oxbkwyr (91)");
		defaultInput.add("yatfpqx (109) -> xrbjn, qywkuqu, thjulip, oiijtm");
		defaultInput.add("jlgvplm (84)");
		defaultInput.add("bcibchp (54)");
		defaultInput.add("glgnecl (16)");
		defaultInput.add("tqikxkp (222)");
		defaultInput.add("bhcal (7)");
		defaultInput.add("vmutyru (47)");
		defaultInput.add("kzwqzqf (46)");
		defaultInput.add("evhsybt (37)");
		defaultInput.add("gdnsat (59)");
		defaultInput.add("cikaze (39)");
		defaultInput.add("jrqorlo (229)");
		defaultInput.add("ovluts (52)");
		defaultInput.add("nbfqgr (169) -> cdpwklz, zjpsm");
		defaultInput.add("nbngkou (73)");
		defaultInput.add("wslsg (31)");
		defaultInput.add("aobitc (69)");
		defaultInput.add("htgxu (24)");
		defaultInput.add("wjolzt (46)");
		defaultInput.add("hzgig (95) -> jrvbacq, rgbvlc");
		defaultInput.add("ulbbc (217) -> bniti, jbepak, iynywq, xbcgipi");
		defaultInput.add("wkphn (7)");
		defaultInput.add("fkbla (207)");
		defaultInput.add("jqinti (52)");
		defaultInput.add("yhiogu (256) -> neusnw, tkpvf");
		defaultInput.add("ebjsluk (39)");
		defaultInput.add("shfdaba (76) -> wpnqet, rjjlus, pjiqvd");
		defaultInput.add("anpnrdt (10)");
		defaultInput.add("jdshuob (491) -> kywfqzv, zpkbe, cfhuce, mzmfygf");
		defaultInput.add("vooac (341) -> lufgosn, sbyzsq, mjpzp");
		defaultInput.add("frohei (59)");
		defaultInput.add("baiaa (15)");
		defaultInput.add("pyrlph (71)");
		defaultInput.add("cgxsmq (25)");
		defaultInput.add("ukvvt (39)");
		defaultInput.add("gaujsyk (26) -> ktaet, yipoeia, qijarlh");
		defaultInput.add("gnjvf (375) -> ajenoz, ripqyzr");
		defaultInput.add("hghnmib (47802) -> vbhnmr, vustse, lybkeg, ikmvhid, oqphsw, xzppxad, gvkcsad");
		defaultInput.add("yrcgsnx (270) -> qfypnb, dbvxai");
		defaultInput.add("kwqrbav (34)");
		defaultInput.add("wdvwub (57)");
		defaultInput.add("viqhfi (89)");
		defaultInput.add("akmgfo (243) -> zhvji, iphncut, oyxbblb, gaujsyk, ybftt");
		defaultInput.add("faecnr (80) -> dfeomzr, yoezrpw");
		defaultInput.add("xskehl (228) -> ubovv, omydd, tluap");
		defaultInput.add("pdosfg (21) -> rlbom, lbjwlov, wgqkdcr");
		defaultInput.add("tkiraal (8)");
		defaultInput.add("aimav (46)");
		defaultInput.add("ecimj (85)");
		defaultInput.add("eikmns (83)");
		defaultInput.add("fqlezvk (71)");
		defaultInput.add("qrlggma (49)");
		defaultInput.add("ztkgsyt (29) -> bfuywyg, uexdnv");
		defaultInput.add("tedplb (50)");
		defaultInput.add("cvrcvgp (86) -> zvurtb, dkcix");
		defaultInput.add("bckuyxm (11306) -> eyyzy, jrwfehi, baesyhf");
		defaultInput.add("ffvprc (65) -> vxajmkg, cichyqw");
		defaultInput.add("jjtrisl (81)");
		defaultInput.add("vantwg (46)");
		defaultInput.add("vlmcmcu (91)");
		defaultInput.add("qdhrchr (89) -> dhwauy, uqlso");
		defaultInput.add("ceoav (29)");
		defaultInput.add("bhrbod (50) -> oxbkwyr, erpvue, zhrnwk, mhjtjp");
		defaultInput.add("yxseri (24)");
		defaultInput.add("kzbvrxk (10)");
		defaultInput.add("kcnim (76) -> zjoxibi, auxqbbc");
		defaultInput.add("ltxkw (30) -> eerktn, nqhdt, jjyjrtr, bfchbs, redqvw, mkrzp, nymguj");
		defaultInput.add("rrggg (371)");
		defaultInput.add("uwqgz (1923) -> torxqh, zmlth, lnctft");
		defaultInput.add("dbwmq (117) -> bmecxwd, lcrwbqi");
		defaultInput.add("kasfuwe (46)");
		defaultInput.add("btbxk (755) -> xajjyba, kxykfr, rymkqd");
		defaultInput.add("njxyw (47)");
		defaultInput.add("fvlfq (94)");
		defaultInput.add("zhvji (162) -> cpazlc, mluykm");
		defaultInput.add("aozoac (77)");
		defaultInput.add("chnkkj (86) -> tfmtk, hddzn");
		defaultInput.add("dkcix (77)");
		defaultInput.add("lxcbjgy (91)");
		defaultInput.add("mofks (30)");
		defaultInput.add("yzrdupu (719) -> wajnxjj, dfvhic, dmkyzy, ziqwzzy");
		defaultInput.add("wxjka (47)");
		defaultInput.add("xitzb (52)");
		defaultInput.add("rvimq (7)");
		defaultInput.add("qddsx (30)");
		defaultInput.add("lvklj (97) -> ydbri, tcukgv");
		defaultInput.add("sjforw (208) -> alcvj, neeqb");
		defaultInput.add("yjvgwdl (91)");
		defaultInput.add("fhxpkd (261) -> kauphp, zdhvqrl, rhnkdt, nhkvp, tejnuve, olspit, srmiagk");
		defaultInput.add("eaqjcju (62)");
		defaultInput.add("ybftt (122) -> oewzluz, ebjsluk");
		defaultInput.add("jgmisxl (49)");
		defaultInput.add("hdaqxlh (11)");
		defaultInput.add("cjmxed (49)");
		defaultInput.add("aqxsjq (84)");
		defaultInput.add("cekpxgj (62)");
		defaultInput.add("tetmzw (121) -> ozatmpe, qbmtmcs");
		defaultInput.add("mqmbcl (96)");
		defaultInput.add("xtyzy (155) -> yhiogu, iphzyj, pvppi, tojyt, krxyaak, ymrogz");
		defaultInput.add("drwfop (48)");
		defaultInput.add("pgskth (86) -> hxckb, lxesg");
		defaultInput.add("pvgzz (72)");
		defaultInput.add("kunzpa (687) -> tadnt, cupsjm, hoomyh");
		defaultInput.add("nhkeb (252) -> caryo, bhcal, mjzksjz, ufitse");
		defaultInput.add("cncak (182) -> qoyzgsp, lpuass");
		defaultInput.add("aituccf (9)");
		defaultInput.add("qfpwln (60)");
		defaultInput.add("laxsl (29)");
		defaultInput.add("yzxzo (38)");
		defaultInput.add("lnctft (116) -> zgevpxx, scchi");
		defaultInput.add("lyvyhkm (8)");
		defaultInput.add("vcktg (1556) -> ztghd, imihjj, ksfok");
		defaultInput.add("dzbrgb (75)");
		defaultInput.add("xbcskih (85) -> fobzai, nxzkuj");
		defaultInput.add("jtouvtb (57)");
		defaultInput.add("ufitse (7)");
		defaultInput.add("upwlxnb (7)");
		defaultInput.add("jysaup (78)");
		defaultInput.add("ysgsry (228) -> glgnecl, xnuoujm");
		defaultInput.add("horqcc (73)");
		defaultInput.add("vfsttaj (27)");
		defaultInput.add("gvkcsad (5412) -> ghsjtj, dgnjf, ziyata, rajtef, kqlsniq, vqclii");
		defaultInput.add("lbjwlov (79)");
		defaultInput.add("vnhvilk (62)");
		defaultInput.add("dntphko (89)");
		defaultInput.add("syzlt (6183) -> tifgptk, iwhqlr, akwvj, kueyf");
		defaultInput.add("hzmhm (1087) -> rvrlma, dchts, emzrj");
		defaultInput.add("neusnw (47)");
		defaultInput.add("vfzby (50)");
		defaultInput.add("cecsr (59)");
		defaultInput.add("uwaiki (41)");
		defaultInput.add("msxhvo (42)");
		defaultInput.add("fgjwz (113) -> qwzmv, xehdglb, kgpwo");
		defaultInput.add("lmuyfcw (164) -> hrovawq, hacwv");
		defaultInput.add("zjoxibi (87)");
		defaultInput.add("viwns (17)");
		defaultInput.add("olykwbi (33)");
		defaultInput.add("meypo (29)");
		defaultInput.add("sbguah (49) -> vlfouc, lficpr");
		defaultInput.add("oyxbblb (92) -> towlhi, fndxl, uxjasn");
		defaultInput.add("bzmade (66)");
		defaultInput.add("lfpzff (238) -> bdinafh, kfmzbvk");
		defaultInput.add("epuaii (88) -> ckheb, kwqrbav");
		defaultInput.add("dwwsu (27)");
		defaultInput.add("xnukvni (207) -> htgxu, lwvnbzs");
		defaultInput.add("zhrnwk (91)");
		defaultInput.add("vfngjd (325) -> hfftu, nymhem");
		defaultInput.add("vztbn (87)");
		defaultInput.add("kxnkbs (19) -> tpipb, vuyzhsh, vapwxei, wbxdta");
		defaultInput.add("bmecxwd (27)");
		defaultInput.add("nymguj (123) -> vkpltts, mbhld");
		defaultInput.add("qlwxeb (52)");
		defaultInput.add("kfrti (10)");
		defaultInput.add("xcvxle (106) -> qddsx, bvdxf");
		defaultInput.add("wbesqn (99)");
		defaultInput.add("kblshw (8)");
		defaultInput.add("qymwy (41)");
		defaultInput.add("ezaypy (9)");
		defaultInput.add("dnouufu (43)");
		defaultInput.add("cyapi (227) -> rothisa, hokyk");
		defaultInput.add("itbsk (30)");
		defaultInput.add("alqim (42)");
		defaultInput.add("hjeysaa (251) -> mofks, itbsk, njogewi, ldfopw");
		defaultInput.add("ljfqvk (44)");
		defaultInput.add("iueejt (5) -> rgfndsx, bhrbod, puwvse");
		defaultInput.add("knzppj (81) -> hrlkgen, nsfsj, wbesqn");
		defaultInput.add("wnjwnr (197) -> hnyqq, oajawn");
		defaultInput.add("xtwdau (77)");
		defaultInput.add("dmeee (93)");
		defaultInput.add("qxfce (38)");
		defaultInput.add("pcqyagx (15)");
		defaultInput.add("bicsjoc (33)");
		defaultInput.add("eeguu (78)");
		defaultInput.add("wbxdta (61)");
		defaultInput.add("gjwaqu (35)");
		defaultInput.add("mzmtuw (95)");
		defaultInput.add("huwsoc (173) -> ouspx, wjolzt");
		defaultInput.add("spdhhoe (167) -> chwjiub, kvdkwy");
		defaultInput.add("hhmwlo (56)");
		defaultInput.add("icgwppo (84)");
		return defaultInput;
	}

}
