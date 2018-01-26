import java.util.ArrayList;
import java.util.List;

public class DayFive {

	public static void executeStandardPart1() {
		System.out.println("Day 5 Part 1");
		System.out.println(
				"Answer to array part 1 is " + printAnswerDayFivePartOne(getStandardInputDayFivePartOneAndTwo()) + ".");
	}

	public static int printAnswerDayFivePartOne(List<String> stringList) {
		int counter = 0;
		return counter;
	}

//	private static boolean findDuplicatesHashMap(String[] parts) {
//		boolean boolToReturn = false;
//		Map<String, Integer> dictionary = new HashMap<String, Integer>();
//		for (int i = 0; i < parts.length; i++) {
//			if (dictionary.containsKey(parts[i])) {
//				return true;
//			} else {
//				dictionary.put(parts[i], 1);
//			}
//		}
//
//		return boolToReturn;
//	}
//
//	public static void executeStandardPart2() {
//		System.out.println("Day 4 Part 2");
//		System.out.println(
//				"Answer to array part 1 is " + printAnswerDayFourPartTwo(getStandardInputDayOnePartOneAndTwo()) + ".");
//	}
//
//	private static int printAnswerDayFourPartTwo(List<String> stringList) {
//		int counter = 0;
//		for (int i = 0; i < stringList.size(); i++) {
//			String[] parts = stringList.get(i).split(" ");
//			if (!findDuplicatesOfPermutationsHashMap(parts)) {
//				counter++;
//			}
//		}
//		return counter;
//	}
//
//	private static boolean findDuplicatesOfPermutationsHashMap(String[] parts) {
//		boolean boolToReturn = false;
//		Map<String, Integer> dictionary = new HashMap<String, Integer>();
//		for (int i = 0; i < parts.length; i++) {
//			if (dictionary.containsKey(sortString(parts[i]))) {
//				return true;
//			} else {
//				dictionary.put(sortString(parts[i]), 1);
//			}
//		}
//
//		return boolToReturn;
//	}
//
//	
//
//    private static String sortString(String inputString) {
//    	char[] chars = inputString.toCharArray();
//    	Arrays.sort(chars);
//	    String stringToReturn = new String(chars);
//		return stringToReturn;
//	}



	private static List<String> getStandardInputDayFivePartOneAndTwo() {
		// --- Day 4: High-Entropy Passphrases ---
		// A new system policy has been put in place that requires all accounts
		// to use a passphrase instead of simply a password. A passphrase
		// consists of a series of words (lowercase letters) separated by
		// spaces.
		//
		// To ensure security, a valid passphrase must contain no duplicate
		// words.
		//
		// For example:
		//
		// aa bb cc dd ee is valid.
		// aa bb cc dd aa is not valid - the word aa appears more than once.
		// aa bb cc dd aaa is valid - aa and aaa count as different words.
		// The system's full passphrase list is available as your puzzle input.
		// How many passphrases are valid?
		List<String> defaultInput = new ArrayList<String>();
		defaultInput.add("vxjtwn vjnxtw sxibvv mmws wjvtxn icawnd rprh");
		defaultInput.add("fhaa qwy vqbq gsswej lxr yzl wakcige mwjrl");
		defaultInput.add("bhnlow huqa gtbjc gvj wrkyr jgvmhj bgs umo ikbpdto");
		defaultInput.add("drczdf bglmf gsx flcf ojpj kzrwrho owbkl dgrnv bggjevc");
		defaultInput.add("ndncqdl lncaugj mfa lncaugj skt pkssyen rsb npjzf");
		defaultInput.add("kdd itdyhe pvljizn cgi");
		defaultInput.add("jgy pyhuq eecb phwkyl oeftyu pyhuq hecxgti tpadffm jgy");
		defaultInput.add("zvc qdk mlmyj kybbh lgbb fvfzcer frmaxa yzgw podt dbycoii afj");
		defaultInput.add("zfr msn mns leqem frz");
		defaultInput.add("golnm ltizhd dvwv xrizqhd omegnez nan yqajse lgef");
		defaultInput.add("gbej rvek aehiz bgje");
		defaultInput.add("yej cphl jtp swe axhljo ddwk obwsq mnewiwu klddd");
		defaultInput.add("ipiev henods rpn qfpg gjfdgs zcpt sswab eosdhn teeil");
		defaultInput.add("gzje ydu oiu jzge udy sqjeoo olxej");
		defaultInput.add("mgn gox tcifta vzc lxry gox gox mvila qdl jipjnw dvu");
		defaultInput.add("hxk xhk unhdmdz yomze povrt nbww bxu qqsqc rvuk tgffy twddm");
		defaultInput.add("fyx fyx nzkm fyx");
		defaultInput.add("ymnoc zogudq yncom tqrob sidvy dfuu ccjpiej yidvs");
		defaultInput.add("bxebny akknwxw jeyxqvj syl cedps akknwxw akknwxw zpvnf kuoon pnkejn wqjgc");
		defaultInput.add("kcebrkj zmuf ueewxhi mgyepbr nleviqc dez");
		defaultInput.add("argavx fqguii gebohvw klnrq rkqnl goevhbw");
		defaultInput.add("ywqi abwi eswph nlplbl pswhe lnqx fpgk lllnpb");
		defaultInput.add("abpb mpkw ampey yapme xnuyj");
		defaultInput.add("tmuaq asd bhbs sqmbsnw wsbnqsm ydwdncn rpa vrllkh");
		defaultInput.add("dnltf cck djy ydj");
		defaultInput.add("wywwl scezo clowuz dkgqaj dohyzcp");
		defaultInput.add("diimshr vlmsnlj whqb dkicau ckdaiu terp kgcii npqc vvzrqzv nol");
		defaultInput.add("wfpxe sqf tbb ruqpcq zfgb");
		defaultInput.add("kajykuz tsxgtys vuz kglmgg ihnnn plyjxj rcrvo mij plyjxj jqiur");
		defaultInput.add("pxs hmet dwgvd mvhkvn cjxg yvid vmhnkv kwxz rfemsua wdgvd okixk");
		defaultInput.add("lzwxas ddtyeh ivyama crrhxdt hedytd jfw");
		defaultInput.add("vjfv oyd fvjv kfwlj mradbx mckseee xradmb");
		defaultInput.add("llga yytxyvj lstspek lstspek lstspek");
		defaultInput.add("fabgf wgop fabgf bvsfoaw");
		defaultInput.add("grqnbvo tntomdw hizg tmotdwn");
		defaultInput.add("mau ufkw cxfi rhehj ebe xyv rhehj acxngo arl qtl rhehj");
		defaultInput.add("kbkto stqjtm tpcwshj saerkrt pffj dthp pfjf axc gwmmfdw glnqtdy xmskw");
		defaultInput.add("veff zqm hzhxap lgwnwq twsdk mqz xbbarbv cdx fhnwt qjcji bbvbrxa");
		defaultInput.add("fjw eds hofskl nkbsv des hvx xyn");
		defaultInput.add("qzort qzort qesz rtq oonk vwzlw wapoj ifr cta");
		defaultInput.add("pja hvy nhjg paj smtfe fmtse");
		defaultInput.add("xvi tcjj xvkjtab nqftt aumijl xkd cmilegf hvsmodx uuo igmcelf mslkq");
		defaultInput.add("mdhezgv lelzy kzfvsqu hvmvaxw pxiqjc hvmvaxw kzfvsqu");
		defaultInput.add("hsicsav csshrhx znojm eapi lhmzq bbwnz seao gfk azk");
		defaultInput.add("pup xtgjyzy wqt ijeektl");
		defaultInput.add("ktwh qdegzs btj pfwzzho");
		defaultInput.add("xdkmdm izqtjrr iqbke vtp");
		defaultInput.add("fmrbpdr zpccv tmtwx tmtwx tmtwx bys");
		defaultInput.add("ehphfgq idd ehphfgq ehphfgq uphe hvrc jcscne nbnslqy");
		defaultInput.add("xzqucgj fcih fljk barz lvln hcfi azrb");
		defaultInput.add("cmfmclv mfgvifw rnxgn jpg bsnq wnduzj ymsdx smdxy pqomf");
		defaultInput.add("rlqsm qrsml emts qsmcowv scmvwqo");
		defaultInput.add("tshzkpa zwtpda ftsiwo nil tpawdz kjpa ptzashk");
		defaultInput.add("mnep sfc swjawtd vnwud gyulluw zpa kmwyvln evd btnmoi dnwe");
		defaultInput.add("jwq scepq redoxmw rbdzsa wlkzso kxpm bttg vxuc moxwdre ijtdd rzsabd");
		defaultInput.add("wpvo dsjox amuwjm pls lgwksva ctakgpl rmsjj lzwwpr zzm udg");
		defaultInput.add("bji obbn tmwyc afpmkxr glvrd kahhgpq rna qkxyntp vmd mloshc");
		defaultInput.add("ymq rtnr nxjzm pqiddrn qmy vgxw ull");
		defaultInput.add("mmzk ikge zhtzhs xyo qwe lll gjjm icetq qgrr mzwqa knec");
		defaultInput.add("kxomfck idlh xrbowo nyetbnl qskh xuwkkxe upmmmf zhvuyp");
		defaultInput.add("srcwyhl czgr xmhuws jueyh xcuib xhsuwm bxuic");
		defaultInput.add("crkueh beyxopz xpyozbe dxgadw qktmce rjropjg");
		defaultInput.add("lbktun imdpcp fkssp fhcpt fehho jqdnt aoewa");
		defaultInput.add("jmun pynzjo trs ijwcc pelf oft pcsqdxg zvql");
		defaultInput.add("mneaaq vjrg jidlrzz phd mvxpivd ldkhu");
		defaultInput.add("sao xqw nrukn gatkz quscpsx vmz oscoeb");
		defaultInput.add("goi wzxhb rrk aylqqcd mlcbvvf ororn heptid kdu byevr");
		defaultInput.add("qsj lsbieef deez vzwdx hez iwd");
		defaultInput.add("lmgfb keqt mqbsuis ogrr errbi xiqe xsszacp");
		defaultInput.add("ato hmk zfjaj kmh plxup cida dqd pfwh nkbxvpr buajw pxkrvnb");
		defaultInput.add("cli bdwu vrwott vowtrt grle");
		defaultInput.add("zisgks ciuaqr zvk tcb kvz ugmtv");
		defaultInput.add("oegrojm wofpwp gnaocx rweyull ellhwow dtefylf dqsz oiw varr bcirpf oxusz");
		defaultInput.add("oydkmib oydkmib yefts gbl gbl");
		defaultInput.add("sruwjk pgkrp kea gppkr zdcky cfljh");
		defaultInput.add("obpxbax jhpcrj slcsa lgd fborz vvpaus wsrpsws ifijuzo");
		defaultInput.add("rixz jwh uhdaf hoacv hdfua");
		defaultInput.add("kntk qprmfow kntk tbmcjx");
		defaultInput.add("vnqe ooyxtb ixl hdmnpn orpz ykspl xromvj kowtq wmho gquos");
		defaultInput.add("ynk xjjqw sut lmtub bmtlu zdo dztlk bpkuul smhpx rbczg");
		defaultInput.add("zals csdbe sbj dibicq kdfwwt");
		defaultInput.add("coyy pjddlfc lwvhyms ldjdcfp ryubz kfwst dqjrjja jtv jjjaqrd");
		defaultInput.add("jaexhms iqoiln ewgyr exmnrr fsr lgmyy fdofhn");
		defaultInput.add("pjgyn hfoz zbcnz nczbz");
		defaultInput.add("ovntivq vcey vdrkse giu ohyaxy ionyy fvpn yvwrgrv qta");
		defaultInput.add("yelpz htbk njgeyub tggh mdthzp fwyux rduqli twlhfp pnh gywif ttn");
		defaultInput.add("yxhsbil vplsmmx rgtq grsf lyibxhs hctnkfr awg lmloz jroy lpgb wga");
		defaultInput.add("kzytass szyksat tyskasz ehmhhu");
		defaultInput.add("jkus hwjv ymnnkk yffugg cvtnits gbl lywkn szihcn dbrbalf rxqpbqh");
		defaultInput.add("koyfcef wkom mwok qgjrytl");
		defaultInput.add("slmhry lcr slmhry lcr");
		defaultInput.add("mvoxbt cfkz purnsui xar ouhtc thbx");
		defaultInput.add("xcdifw kvvxyrj knac qmypw bou tmukqy eusgaoo bktiu");
		defaultInput.add("ablgnhb axumg bwpxnjp zqpc vtw ghhoxu zqpc znfpvl ghhoxu jlg ntdk");
		defaultInput.add("vmvc cdkhrx cvz rvxk mmcuo udpcayd lsmm gufduzt linj");
		defaultInput.add("mgyeqkv hqionh rgnqgz kkc qrgnzg egkmqyv topdp");
		defaultInput.add("koa dimwx gjxa atlfdy");
		defaultInput.add("uuez ueuz zeuu ezo daq");
		defaultInput.add("ofpaw bgomvmt mqa dexpy mbipd epyzcoa nuwrh vwly xppz qkjrleo rwhnu");
		defaultInput.add("wok grxk lchvtg plrzr lwaax cfeu ijapws dmkdwc cfeu");
		defaultInput.add("zkd hysxxip hlydw wicsvy gbwoaw dapre ktjn dzg uri");
		defaultInput.add("blzh hblz qgmjceg fyf");
		defaultInput.add("vkhpn xnc ogva pjrh cxn hkpnv");
		defaultInput.add("aja cldzta tdcazl lorr fwmxxh knilf ges tdhp gnlo vihrl");
		defaultInput.add("ucpr peair nlbmc msfg");
		defaultInput.add("trv ppq bmo xqd vbui yegsr xqxawu fvuz aclhspo wnan");
		defaultInput.add("loiq fvg kare rmgq hir rzo ossd ziw renh ygtkjys vda");
		defaultInput.add("xmans kio alexs ujekfl vvf ddghn");
		defaultInput.add("fcxvsf bjuytet zrzsobo uhn mlfzhlq bjefs");
		defaultInput.add("zys htlqvky plno pbcqfuf fjwc vshkxrl lonp lyzmy dqmui vyyc glad");
		defaultInput.add("tlc krhcter krhcter bolk tlc opryl");
		defaultInput.add("idcii dverl uswb wusb zgax zhbt gjsnlso yhs");
		defaultInput.add("cti npri rcbxjdw ollj nirp ghfvxzh");
		defaultInput.add("blyhug aflnrrz zudyw ccnstq cyoju jxtqoj ntuknjq gunjiwy ycuoj igac cqctns");
		defaultInput.add("bul yehpnw jifjrhc ifetu ufrodp hqzpeqf hdvpc qtvgxg ibb wcxsitx xztshb");
		defaultInput.add("xzct scetn eoaufyo jtudgkx xrpgxip lpubtq juezstc nuc hokswh obkf ipbu");
		defaultInput.add("nfq lwpmn qltal xnphsqs zlrgf iewtrtd mqzsob duokpy kfbqs icg");
		defaultInput.add("vil zjz xkqrvni uay ystq");
		defaultInput.add("terrrnt lnfg clm lbs ptpiy ybcuup ayzjm pqugx lmc yppit mbf");
		defaultInput.add("dtajh vqivg vnblt fmn qxkw stiwna pclrrr fro khu wbslnqp tjyosu");
		defaultInput.add("uqlehn tjuiy obt uedct bbwiq uxndqn");
		defaultInput.add("hiqfovy xiimca zwne ivunvjk cmctzi mxnnrx dclib xzaoq ieztkg");
		defaultInput.add("shpr xuorihj chuwq poadbo mhtvex gymsp iltgl sypjfua fmyh sgiv");
		defaultInput.add("alv nxjt txnj bhact");
		defaultInput.add("vjvtrex obmrxk fgigs meixbc fggsi awi rxdjpeg");
		defaultInput.add("ypwo oicmbdw xbpeeyj uabzj cjvutvc oicmbdw immtmks");
		defaultInput.add("exijri hogl epr gzdqyur xiiejr pre ihzlgzu");
		defaultInput.add("rlh qfhx lrh qmvrx");
		defaultInput.add("kogq okhd mivmivb mivmivb okhd");
		defaultInput.add("taekt nhjaa znbaahn iaospxy jawwf");
		defaultInput.add("ytdvq ghtqwud jkiig mre kzmmjxu jba nwpykc");
		defaultInput.add("ktyzr aczd exgadhb uinrgac izazxky yyfe");
		defaultInput.add("yrifb qgc lsiuapg teyelxn ugezu");
		defaultInput.add("wdzkc ltx fkhncb hwrecp kfbchn sfcpc hjvq");
		defaultInput.add("rjdjyt ahwxh nvggsmx lmz oshd xbcik powse ahhxw yhiq gxmgsnv");
		defaultInput.add("qdr qjnam gag qjamn kooek mqnaj");
		defaultInput.add("pza gml opf ilfbblu kjp luilbfb rhfrzgp ixagj ofp");
		defaultInput.add("yphz runy dhull bozcsgk wfxekrd akgkbz urcphc");
		defaultInput.add("tfyxwol lhcl npik beug");
		defaultInput.add("szatel yfkve yfkve lzqhs");
		defaultInput.add("yjzqon pcjibu bdncmcl kczuymm pbmg nyn");
		defaultInput.add("rerqvs aoxucwi pmstl sstawu joqu abvcchg mvgjn mslpt vhmfkr utusuh");
		defaultInput.add("gqbec jjpqdh yeaiavi nledfi jhzwc vyxjpf momnm vnknjs nvgjzik ipm");
		defaultInput.add("psirt rispt lrkgma irtsp");
		defaultInput.add("jbbaph xvunete gsvnr mjd ifxhpry cpsx hmuokkx vhcm yth shrrl zbhd");
		defaultInput.add("gfa bcmlxtf sqyanrp cugg qxfvftz pbl ujsgc jajxltm gugc oil");
		defaultInput.add("xjuhyg aht vmyvzhh oby oyb ybo xbybgmx");
		defaultInput.add("atfk qjudfzz mky tfy");
		defaultInput.add("nxk yzy jqgg qxgjt bevvvv efi xcbw bohc zaqlqjq");
		defaultInput.add("hdc qpnx ygmtqw acvoa udboxw dhc klh mwgpk xfpuri");
		defaultInput.add("cycgbkq skwhyf skwhyf veaqss skwhyf");
		defaultInput.add("jnezf jowjt vsdu uck scgxd fvopomz vfajslp");
		defaultInput.add("djvi epgkyqn apzd cpm owm kpwih fsr adlhqu jicp pmc");
		defaultInput.add("erxlmhj wqxvofi ugj ttrmtsb");
		defaultInput.add("omku vmrgoy tdicbje ewml dfnwbap");
		defaultInput.add("gpih pyt ptsmzc gmdbu rqxkqmz objm nurxjz oozbere ztxug koth");
		defaultInput.add("jpnl jpnl dmeh qed");
		defaultInput.add("intdwv ksgw qwlzhq zpd lrl mwjl dozrjwq aujbet bsnf vhqyg");
		defaultInput.add("eqs uot qyz xor aem kmrh mrhk jqx tsbrf");
		defaultInput.add("irytjab mdzm qbb kkjt gofiwo xgbovg kyeyxqn tcks tljhx");
		defaultInput.add("zgejy qodgah nqavvx xnigdvt");
		defaultInput.add("eqve bizrxq lkhz yzwxgt nwe zfe sxypkz xnssept");
		defaultInput.add("bxqn lkfg yfxbszo sphwifz wnj crhbq dvokzw");
		defaultInput.add("vzn afatwye ogzvnu vnz rfjba xtugnj kpbgly ocsjd");
		defaultInput.add("xrc cxr rahv yvhk khyv bed ctgbuq cmqwpqa jlbg hpj vmesvw");
		defaultInput.add("jbshkya dgqw lfl mzcch jxsg czcmh ifruvlw ufwrlvi xcczlol cqqchmr");
		defaultInput.add("rbk mhn tnmqdc sxnnn kvoa mhn sxnnn mgemob ieiyajs");
		defaultInput.add("cqi ghxg ghxg ghxg");
		defaultInput.add("uqwdxn qli gdtkngp gnptdgk udxqwn");
		defaultInput.add("dmcczr dnjaqc qwdta rhrbi hkdwe qdjcan peic iulaz xns");
		defaultInput.add("tcmppb nzq ecy sitdud nft ecy afrbf wvnc vmfpzx tcmppb cgb");
		defaultInput.add("plitv efnpq mjqav nrxxo izg lpitv rwbzdo rdbzwo");
		defaultInput.add("day dntga adtng agndt hhvtd");
		defaultInput.add("yrg iudsh gyr ryg");
		defaultInput.add("qttyeew tco flq bszw jkzftc wdh efcwnp mja rfmju");
		defaultInput.add("moch prkze uslzyv plhjuy kxczyq qlmm hgq");
		defaultInput.add("xtg ypz izy ixg bvs xlqgj xcy sepza abiylsg");
		defaultInput.add("wxvsxn bqag jnlzgxq ikxwa dfd plqxl xlgqnjz nuqvoyb emhodso gaqb");
		defaultInput.add("bzjdsm xmxkj fhuqn gauyw ntl kjxmx zcxdr vrds");
		defaultInput.add("ofjcc uxyzlk ofjcc ofjcc");
		defaultInput.add("zwosex kkvwobl cpudsmb kes zklf bayuojr otqnyr udbbs");
		defaultInput.add("iqpvzh ybds piovrh oivprh voprih pov sfl");
		defaultInput.add("upns cpeelht xboyk itb hsxdmt dnwgfbw upns fygf kwdpxzm mli dyy");
		defaultInput.add("djwutl sikh shki ikhs gecd jqkon trqyw");
		defaultInput.add("prbbdf vdp bvvfjcg ydqb muxygg");
		defaultInput.add("vhpurzn psemqe xwqfk hrvonxu nxkxacq");
		defaultInput.add("xicmhss tnpja qiad woipfy uvadcq usljh hzgs jntvfv wzikk");
		defaultInput.add("mmupc twntp upcmm pumcm");
		defaultInput.add("qnisuzy lppnfd uiqr eyqbain uxlp eyrfwjo olgkrps sbikam zin vckr");
		defaultInput.add("nmokl skfni jcdfot njzqeaj nqzjjea");
		defaultInput.add("slmaxx offfzqp wudicrf nfn rwfcdui cwirufd");
		defaultInput.add("paffi murnjd oyj lbtjdqe babuas dtqh qkt stapzl yrqlp");
		defaultInput.add("eedc rig zmnfmn edec ecde");
		defaultInput.add("bcfdf edovdj lacx nzvze sordvxj ybs ujh zvvvp rzstejg ueosuq");
		defaultInput.add("xrrfsd okuvem znzlvmb jwzcb bfg bmuxbc qzwfry");
		defaultInput.add("pqgxybd cvgra acgn ocd ancg fvfcx fbb bfb zfzv");
		defaultInput.add("tmmv mpywyg fwl bnvcv lcnv flw");
		defaultInput.add("xxnfbro papc ianru beuzx apcp rnt");
		defaultInput.add("wuyhycj nrnc cka ebg rncn rvo wcyhjuy");
		defaultInput.add("thh cmoog hwf imqfp okzpxd");
		defaultInput.add("rzxiqt rtaiy ytria tyria");
		defaultInput.add("cjkmro myif myif xyirn aqxlol wlhwibi dhzsen pzwgm bfbz bufjs qwffg");
		defaultInput.add("mxhiui umiihx zomyll vfieccs");
		defaultInput.add("yyntf rjk iivgj mwh rjk");
		defaultInput.add("dsshx wsmaxhc xcwuelh rdsgtr wsmaxhc rgtsfj");
		defaultInput.add("rdh nwlxiwu xsjzbpr bsgps");
		defaultInput.add("ufyo vqtzkg kpeohu mxzt fyuo gawgaq youf");
		defaultInput.add("hzbhut bxsnjwb zuhhbt zhhtbu");
		defaultInput.add("pdz sgntypg ragev hrrji goitft yphnebs xjzoo sqf jsuzijq dsocb hcxg");
		defaultInput.add("pptsq woomypc woomypc woomypc");
		defaultInput.add("axcg wfbnpql ejqb cmnn nncm csvlc wraludb pkmp whtht tfpicer");
		defaultInput.add("moom oomm ommo vfqeii");
		defaultInput.add("xvrgpp rofl yxyrkb oage nypzau pwfnkn jxnhkw cyxsi clzb adwpuh");
		defaultInput.add("mfbz vdtt muzhm wvwwfl ttdv");
		defaultInput.add("cpqgvbu byc pgfrlkr aftl tqm zcqxi juu gnf ppovxh huoa");
		defaultInput.add("konpcp lzordid jqng lwxs nqgj gghkxmf kyn ngqj");
		defaultInput.add("iorhccj xfygc cnfr tysqc xpcyf vmjpitf nut zmrk mgbrtb tcblxwf dkadwrm");
		defaultInput.add("kov jtmp xoatesx qxkilp rmggpfx ltpxzwf vko reqms mqq nps");
		defaultInput.add("hjigmk fyqy wpuwe mwmso thsimfs okcmeyh mzqkez duzaq vzhyrm uyvpkox cwivpls");
		defaultInput.add("ukoerf korufe zhs ntwfz hugem vriyk enfaib hrrcdgf zllsk vkiyr");
		defaultInput.add("shkx khxs wntpjv qdevaw noqyht nwpvjt egh hgok mukdjfi law bzbvjz");
		defaultInput.add("dquk kczxsq tdu trnkjs wqtdc ybvcb");
		defaultInput.add("hlrotxn cumcjkm qwufgle ylm nejh hnje pvaigrx myl sfvsd");
		defaultInput.add("szmvisn aywic vsnimsz iufmybr");
		defaultInput.add("zjozr zojzr qmn ffrggdh wam dafvok");
		defaultInput.add("nxkvlhr posmf posmf posmf zhlzb");
		defaultInput.add("ywis kpqpyb qae zqxpuz pcj hbsfz ejlwa lajew znuom");
		defaultInput.add("qxsl ussivur dstd avojo");
		defaultInput.add("yoeagao egpaqm ymzf kkauy ivm illir wsvchne skmamvn nqxc");
		defaultInput.add("cldo ixzzy vhk nra zhypgab");
		defaultInput.add("qjdd ecxud tbuqq mpotbdk tjdpczn knncm tyy");
		defaultInput.add("rbfc fhhjf innia tsjbbbv fmtcuup rapvhqz ebpzt whdbms gvjoy lykl fquvcby");
		defaultInput.add("bihhfwi lhal udxz uwjwp dmb");
		defaultInput.add("fekxamy uophet yzvv rqj zawlp ldrv mdymkzy taauf");
		defaultInput.add("rcwxvmh edueui ltdyo xfghz dgjig senm ifj");
		defaultInput.add("qcu fii axmgijj ifi oixjfsg jxagijm");
		defaultInput.add("sdtyr rbdh yvnvq czzuig wro");
		defaultInput.add("lot xkto cmpiena nht ozcg aotcw xiegl cyaouj und lsclep cexn");
		defaultInput.add("pgihljk cmgmv sajhi zfvbqij ogwoc ajsih zmppe");
		defaultInput.add("jexwkdp dwpexjk mzjydfu bff rubgdb");
		defaultInput.add("yshfhx emkl hshxyf mkle");
		defaultInput.add("dxgti jdo tkwprv pbxbrqd oiz gsbdphd qotu utfdnq tzvve bqc");
		defaultInput.add("ovdf bshfxyl xspjpd vljdsm mgkd djlsvm mlsjdv");
		defaultInput.add("etyia eytai sfq qafj xzgp ewhsn snwhe lhqp");
		defaultInput.add("zjz mwh dorxm ges gexo rckwsa dltoq mmntha");
		defaultInput.add("hqkuj ypsjcxo dixbe rmvnhjh ovnr");
		defaultInput.add("edc iffaxc lolu xwrvpb gva vti vit");
		defaultInput.add("ceuxq xbwejr lzyvm rozseit cwe mham fivpwj qtv omaktaw");
		defaultInput.add("alzdrk tsxbuld mdbq pgbdtoo xwf vzalric nqe jqwlxsy cbtylu dtubxsl lqm");
		defaultInput.add("rqjmjcs exjpn kpilcgu ihcm lfadjm mlri hpd vqs cxqwqhu twxrtk");
		defaultInput.add("aeuvlcp aubvnw riedvz arypagp uuvg kliehx cokt ogh xsdw cdsyywv");
		defaultInput.add("ddwrgvp bscaq bbfv qrbutp");
		defaultInput.add("jpdg uey eyu uyarl zgbk qyhqq fdvlql zmwkp");
		defaultInput.add("kbt bkt lebhpfu smrzt xalw mmwa zmtzfry tkb");
		defaultInput.add("fcvcv oewfzu fvvcc mldww lwdmw");
		defaultInput.add("ejrltsu sqoyx wfvsdbp bfdspvw bfir jqhgrmt ofdmrjg ysq");
		defaultInput.add("jzwucwn erqjd eikq knpf cvk xvqnscy eei wvfjzmj xujq cqaim boev");
		defaultInput.add("jqhkmr ipjpj zwno ybu krhqjm zqfyyzb dyciy");
		defaultInput.add("ugwsw rpwteje qtvwi pwyhrzt hfcdfmc qbovk ibws");
		defaultInput.add("ffy kdder qjookz bfvmvvq yjzuaj fvxllfb pjyz jcezhye fimyydt qjookz qjookz");
		defaultInput.add("loupd nwsc yytvuqo ltcqxnf");
		defaultInput.add("iho ulvxguz fxbf iqu ofjtmvq xhs ybbusd kxg mebdnah ucttcf zufb");
		defaultInput.add("wzdb wumuhtv kef aavv buu xmjtlur faaccl wospwff bjasr eapfsi");
		defaultInput.add("jau qzszci ciu inagax");
		defaultInput.add("kui tqig fyovsp fvwol fyovsp mzth tcp nhoq");
		defaultInput.add("ajdla wtpj amylu jly tvq wjqef");
		defaultInput.add("ofqc einz bdze tows bdze eew");
		defaultInput.add("avwavzt aesrsjv lbmpi hllv chdbul ezelxn");
		defaultInput.add("imcprs cafb clfg rsjo iylqu nvk vkrq izezlnu vkqr tyhnv");
		defaultInput.add("rwj zboui reh buzio wuhpvid cpzy jrw tsbuiby hmxwqr ute");
		defaultInput.add("ixq luwbi uoiwsjh souz ysoubw uilbw ffwjvw ewzswoh hci zmfdaov whowzse");
		defaultInput.add("xrhgqf xrhgqf giyv giyv");
		defaultInput.add("toiqgzv gakg udgdlb wvi carrn pjyha muqclu");
		defaultInput.add("wuxthi srtszr ourab hpds bakvy fnk yefe yfee doowxcx");
		defaultInput.add("ijdc ujhvls xmy hwg yetsda qelbe nang xgywo wgh");
		defaultInput.add("bhm icq cnam dec enksf qfctz pwxoo bdf cnma xoowp rbls");
		defaultInput.add("jguzh fextz yax kesaunn waljo jltcza tfzxe dezs syi ebwxnks");
		defaultInput.add("flvq bzgd clvqw ahtyvu xbdyv wssxx boscm grgl nqcg");
		defaultInput.add("caskpli hqctxxc nwpyo wjlqfqf ebti dva");
		defaultInput.add("wmsz fzpd ikgeq gti ejftoou ezs cqef mybojc rgwz");
		defaultInput.add("mdaay yfppa pavl fuuvfkh hpod tpb dhxmia emdecm rbqcwbk vecyt");
		defaultInput.add("neha rmvl ndp vlrm dpn debghi vyhvc");
		defaultInput.add("bnp zkxdu iqqkesd abtlx hmjasdq kyvekr krt srrjyd oxmfev oot");
		defaultInput.add("dumlcqd ccm hyir oritdz madjjw");
		defaultInput.add("oakqrs advfmu verrc zkfdcn btndsp");
		defaultInput.add("onlkinl rdtm bscfxre bnu oumyrvv kgc zkj");
		defaultInput.add("tfxfsgm uwmic agswclg uofezgc");
		defaultInput.add("wpfdyjn kjlihk etbot fbu scm gwccce xgownte wig cuaijbo");
		defaultInput.add("bzbdk etozk qracb oftfoo lkooe");
		defaultInput.add("xupzw vmxwu sis wzpxu");
		defaultInput.add("gbz oqbgh jwgrru bzg kwmxcfc jrurgw");
		defaultInput.add("agyjnyc tuec imxlult omwiyjg fiwnoqx nhmnro qtg kbr agyjnyc");
		defaultInput.add("koiq llreotu elrtoul dubfvgy whq");
		defaultInput.add("htm lll crzppb gdjaae nsmxzh gnfvn obiuy ymspzbo iuboy");
		defaultInput.add("thm xlfrr pbxdfo mht tygi sapxgbv mmngzf dej");
		defaultInput.add("eus seu qmstw ues");
		defaultInput.add("yvfsw esut biblze kbjcpk estu xih qzki ezlbbi blzv");
		defaultInput.add("ohq ugc tqqeo jygvpwm vfs ldnfibp ycbpa sml rmime");
		defaultInput.add("kuuow gbg nzwdaf wiimtg lam oqmm");
		defaultInput.add("wsbwkdd hda nqk ticz mvt");
		defaultInput.add("gqbljyh zqugqs cjod sxwlqy qkfs wwvwvt dsojb qbhjlgy riusoa uosari");
		defaultInput.add("jkphfx dbt les jsvoij rnuw mxmmchu dol vto swn");
		defaultInput.add("qqxe vwvephr twdqlyg cvdu xjiych clooq vkwavl whvverp yuz vkwval");
		defaultInput.add("txtbudi tiutdbx wqhx tws utgbf amh hmf izsez ooz");
		defaultInput.add("egdube nhsxjs nxjshs xoy sjsxnh");
		defaultInput.add("egdziod diodegz ejxn zogedid uhhkr rnm cyvvuc uqbl");
		defaultInput.add("rbn pinwag sidwdwv jqdbe jlbemk blkeaqq ipfqbtn zkrbp");
		defaultInput.add("bdryz sbh wxvn mhot wemsfm oemkff");
		defaultInput.add("vxyn xvdwwo xhd vyca zxjaw vfkz xhg ofsphks dyq mmzzd");
		defaultInput.add("yjrqsjf iiesdh envwyx rmtbmiv ggzsg ukx bprfym qmyqc vag ymho hjtoh");
		defaultInput.add("fuxxrd wbweptd vkoffr wbweptd");
		defaultInput.add("gfwcez smetli yjyh pslpz qyokpsm qsy cxjymg wqfkf obuq awz");
		defaultInput.add("eqhm ceest kayf heqm");
		defaultInput.add("rdi dti vntcf ewkmpvf jjwoihc");
		defaultInput.add("sfq qlb xrm ocy vtnj zdznbal zvon stln zwnj wsgalvq vhphap");
		defaultInput.add("pya jay mgnyo pya xmapdn");
		defaultInput.add("hrwbj xhr gvwl ktq ktq gvwl");
		defaultInput.add("rzgqi hjwtthl kxhggbl wepc hgavj ctmqug");
		defaultInput.add("tzfwkc xeqfath iiuwq iiuwq dhwuvy");
		defaultInput.add("gibagy smq getjofc lum msq ulm xuxu bilrus ily");
		defaultInput.add("xlv ndrkch hdcknr nqltoze xvl");
		defaultInput.add("wmc vuzlrj mwc atp cvpx atv ujatz");
		defaultInput.add("hxpafgl ymjltv nvvpy ahycdk jhpdcks ettm lvqyw ertpivm dnezwxx usi kdhcay");
		defaultInput.add("vrh hqyomv mcq ilwjbkz yprjxad");
		defaultInput.add("ugv szfitxg zeluib pfj ijm zmiigxx gltxzz jzljhgh otskue");
		defaultInput.add("mxp bilj jlbi tce yfted zxsqas ftyed");
		defaultInput.add("ykasqv ehye kirmnl upmi dojwmw wzj ykasqv ifixn vreoypz");
		defaultInput.add("kerbgub nnroqk onkqnr gbebkur tjhl knjo ccsem yozvrcg");
		defaultInput.add("ygq evkoj wkn ffljhds scxeibh egsybeg mwvi vgjblj qda ywqpp");
		defaultInput.add("hocvpl ozgkxp xgmj ejzyxm");
		defaultInput.add("gernu kks lxe nxzv sypg xle goz");
		defaultInput.add("xoatis fjp wzlbo dzkonz jtutyj vdonj swro tqclemv xhomap ymeqkua vaxcw");
		defaultInput.add("mxcyjs ywyxndk wng vpftv nsuvu");
		defaultInput.add("jmiyyhh gwser shgcu jmyg cjzegc hmhe eopg kmkan");
		defaultInput.add("smdd dmds mgqhtkh qtamih haqmit skkcy");
		defaultInput.add("dnj rmggy rgymg uburbao rymgg");
		defaultInput.add("klcpjgq ons ajyv sqryt son pjlcgkq xlobdt");
		defaultInput.add("piw shonk tzi mcdumz noskh tebolw yaypn");
		defaultInput.add("ozm mvmjgtg nxj weommiq asnmhzq xjn uobztuo cqgjh utfb oydt ommiewq");
		defaultInput.add("qlwgsc vvpe xgft ahpjc zjtx iyof scwqlg dxgcokx ltrefj xyzq rwto");
		defaultInput.add("ggqdd dqgdg ggdqd kjkmmfp");
		defaultInput.add("htzjam fjbg iagc xls iagc iydtf ihxl boa iydtf");
		defaultInput.add("vhe nqj bwgdoi hhaoa qtulz");
		defaultInput.add("axvyja hpdkwee hnryj prou rgadv oubjdqg knjbc");
		defaultInput.add("caz xibj wqkzwe peioeya vmz hesy ftb");
		defaultInput.add("dudwcr gupj sjrtzc xsqbb hiet nujv bebcvsj eks uuzlcx gex");
		defaultInput.add("kywozi tfzuc mflssw hnxxxqt zzc tzfuc hkokuv mnjg lwkavjp lvpwjak xez");
		defaultInput.add("izgh zfv cingjt dkf cknite qox vfz zvf");
		defaultInput.add("ojpu dzk tehpgnt gntpteh");
		defaultInput.add("glxfxa uxq ajtles ahgzn ajlste zwgc mrpu adz wuunwhc zda");
		defaultInput.add("hdgdtn hnoyz aromkb qujfv yjgmn tbf atw");
		defaultInput.add("uyvsv oaopjv uyvemxk ldpp tthe iisjk txr hebmd yxevukm rkziao znt");
		defaultInput.add("ypdr mnwuzvw acpg kzwz ywbn wcrr umrnlbe lkult ljify azyhu mgqoo");
		defaultInput.add("abmpl omsd xmyl mxyl mgoq kracrf ufm ppwi zpggh");
		defaultInput.add("uxfdpv jnm vvc vchunhl ubv ktj mxolsxz");
		defaultInput.add("fcja eci edzrb nlvksaw lhf ycohh tfztt xso ceub tyv");
		defaultInput.add("rkwtp tcmmvv kufg cxui hdamg suuaej fgku cvjlv");
		defaultInput.add("oldbgy riadoyo djsi wca zxoeq pmemqap aijxa");
		defaultInput.add("nyy ruxcosx xisqoz yny jvzfpbe tlfdiaj ybd jifatdl zuzv");
		defaultInput.add("kxwdz qvrvx svllp ergmme");
		defaultInput.add("swjfuv eronk favcxfm acptbh pnbjn ciqcrlt rgvdnlt icgahb");
		defaultInput.add("ddza xxfn use obqka bfzwjp gmf bld fyvde mxdfdl");
		defaultInput.add("ame bmxbyf ame bmxbyf");
		defaultInput.add("rdgby pyfog dybrg gdryb lpztd");
		defaultInput.add("sntg impd uxgxai naoalb ntnk xgix");
		defaultInput.add("oadpmqj oso criln izih oos");
		defaultInput.add("ouzjq gtl ito xefqt phnv ouzjq hoyjjj");
		defaultInput.add("mlp rboq lpm roqb whvp");
		defaultInput.add("tghcw ggshevw dzsgj ggshevw kec ggshevw");
		defaultInput.add("kmwhb kfcb mbhkw gemz fdh");
		defaultInput.add("euve veue kplrq evue");
		defaultInput.add("hikfiw bcdktj hcnawja gjasvwc vcht igrzly rkxijxe ikfwhi dvmp");
		defaultInput.add("hvksis kafs ktcs sfyqzyt etctrgt vodwr wff tskc juobnm");
		defaultInput.add("dpcsodn ehwc pglywfl yhdp mdiyzx");
		defaultInput.add("ibog umftejh cfm pnxhna wqwx yabnk ygws dqw");
		defaultInput.add("dezz tqw qism rarfe fpmlab xvbau irwtfs wwmoyss yvn xetqp xtqep");
		defaultInput.add("pchqwk npsmd jefec qok uuc ucnpz rlkakn");
		defaultInput.add("kudh rjysb xrdbx bkbmjfo xrdbx");
		defaultInput.add("rogu ssdwsus voa ncw obkxsr");
		defaultInput.add("tflf hlevus scq rrbpat tau wxsq wxoblt");
		defaultInput.add("rzr lex kqdy whtj ffnys xlgkkff msjhy dimaq hrc wyde qkwf");
		defaultInput.add("ghtwd wernjpn tdgwh olrfvmr edq gxvp");
		defaultInput.add("rjirvf skhdgln aauit bipu mubjiwp kowz gyjfbjx cmgdqs");
		defaultInput.add("aftfpbv agajyy aqjll vsf twh robpys lebt eav yribup");
		defaultInput.add("sby ymkla sxkbfwl awmd nhb vlp");
		defaultInput.add("kizvjj ycjswr jkzjiv vuy jijzkv jcs");
		defaultInput.add("cwvch xzqfal tephz lqfzax cnkbdcr mql zflaxq");
		defaultInput.add("jjxzwl himpra ssjf bibfiui seeaq pzse");
		defaultInput.add("jogrn jogrn sqew jogrn oixgwr");
		defaultInput.add("khonpyw iiyxir vybhc ndnxxv kzlt ipmncn");
		defaultInput.add("okqkqu svbemi nfn ovd xgwy edd ujet nrrbv dde vdo");
		defaultInput.add("jobvf dus asvio vaosi sovia");
		defaultInput.add("knmz qbz nkmz zmkn");
		defaultInput.add("isbmopr unduey impobrs hea zswciev sopbmri duuj");
		defaultInput.add("ocs ntgnrdu kbvtzp cvyieu fiyn znmh lhrz ixtnzrj vktbpz lbpqx vzkpbt");
		defaultInput.add("muduhc sabc dlyoisz kuaz ogpyepw yuog ictiiqt");
		defaultInput.add("xjflsf nfklvml thfh uajnmby cichyj xxoqi lpime bxpyx");
		defaultInput.add("riahifn bohbgd obhdgb jni qzvkf ybp hjkkwq ytutd cakcsh smfdoe tuytd");
		defaultInput.add("iddku nccp zgtl yne ppzpqcx lwm");
		defaultInput.add("refpcz uqt uqt uqt");
		defaultInput.add("mtn czxkagb nmt caqacrg bcakxgz");
		defaultInput.add("itxjii uethxbj vpds bsqod diqax inv zrwt doepe");
		defaultInput.add("bfyaj nbvhg zmi buf");
		defaultInput.add("dtre dkwdr nrapm qtfth odvt bbcnae vxuk gqm enlg");
		defaultInput.add("ybt qcfozrk yzrh bfp euuozuz pzsdkxx mhi nbkzprb");
		defaultInput.add("vpuhqn gyx caint antci vfep incat kqdakdx");
		defaultInput.add("ddhi chgnjk ibg xbemitr mjtdph eovw");
		defaultInput.add("ngbtuvq qdttlsg dbqhhwk bkrqze qdttlsg qdttlsg");
		defaultInput.add("evn smvhi dgcmn xjo ascc ahbpj uvzc pwn tung");
		defaultInput.add("ksu thr omg onvsqzz rllakar ysfjtfj grxwyx oawix gpk suk");
		defaultInput.add("qvb iouav yhtndkd vuoia ouaiv");
		defaultInput.add("kud kofcip hcczrgc cvvxxlk rvyamwe duthdzr dftun");
		defaultInput.add("rgv ynw gph tmxwfup nwy");
		defaultInput.add("dnc trawj kwzbx trawj zvp");
		defaultInput.add("ogqxijy tbqtsg tbo vqinnlq jbvgl sfafh rve mcxqs ubh");
		defaultInput.add("qccr lpv puuvdyb tydaflf uxic");
		defaultInput.add("tlon tbfwkxg tlon tlon");
		defaultInput.add("iytiz qjlqaqw uixb lnt zwro uzgxqfi gklgnqs zwgoidw iifk wkwdo");
		defaultInput.add("tmvhxw tmvhxw tmvhxw fhiqpjy ejk kvysd");
		defaultInput.add("cmphg xjjz groiccd dvetuk xbwa zhm lyi ohhd neg bxaw yil");
		defaultInput.add("kdmzopy lxx bvhach goxmxu qbqvzcm qbbrhvb nrfom aixmio grpxz hbrqbbv lkucih");
		defaultInput.add("bnqn phqr uycuxc mopyyfh bbpesqm stgigq stggqi cwtjm asqhpl imvlxj lbmloo");
		defaultInput.add("pws iuvbvjr cwccm qbr srqnstz cjebq");
		defaultInput.add("bfh jobkcy gtbroe lpagq icmax jobyck fbh");
		defaultInput.add("ounqdo qrrr pwi alho rrqr beao rsioepe");
		defaultInput.add("vrccqge qvcgrce cbslkjs qnclw rvmjkw");
		defaultInput.add("aaxjns deupjs wtgxtp penad depbho tbrdt depbho qxg zhjxpgd");
		defaultInput.add("drqfo kbp jfa jaf");
		defaultInput.add("izn oczcitj cpae quvzqo iwwk jck idjdpm");
		defaultInput.add("ecort zgcvxx bvh vrprsf");
		defaultInput.add("fhubfvy ndcfjo kol hyufbfv hvpka");
		defaultInput.add("kpt zgajpc rjvsxa gayznjd");
		defaultInput.add("xeoixk peq kfu lqa mjnv mzvh bicl hlfk");
		defaultInput.add("wyt imdx lksy twy");
		defaultInput.add("xeptp ilxs qbsqzwn rsy slxi xtpep dsdkekl");
		defaultInput.add("rotvbt fuirp elos ciu nhx bxej trmtx ixn xbpc vrxtma");
		defaultInput.add("skcprn yns sao ghlq vftezvc aaryahy telt");
		defaultInput.add("fkaov gexa xijv yiksa xega dhgw okfva gxxs edkecag mqbqvrm nrzcqub");
		defaultInput.add("ljc jujxeof fdj gdzjzr mabbktu pmyrfv uspven zxry snt hrah");
		defaultInput.add("nhujhdr jdhrnuh midm bbavhpp cpjk zmpbasz eptrpou znq zqn");
		defaultInput.add("ywzfq wuu lfflon uuw rke qzwyf hjbms gakx");
		defaultInput.add("yqrq zsk jzn uuuzrml kzs lseupsg waynfh blech");
		defaultInput.add("gwyqej weyjqg uwuje uujwe");
		defaultInput.add("lxud rnwkc bgygkh csq rfvtos ystqp keb gkakodj uthcce eqxifl");
		defaultInput.add("elvj evj rfwo vvgkosh aarcgjs utsbh orwf jxcqvmh uowmktl qtgf");
		defaultInput.add("bqszre oxntty ombwiz mbiwzo");
		defaultInput.add("ccp iilcc tacf czk giwv erqi jgdfah wip xtrzhv wosvbyb");
		defaultInput.add("gymyw rwsxeg gvydr izyk spsonkg knospsg");
		defaultInput.add("djj tbr tbr tbr ice");
		defaultInput.add("yyzh zkykapw puydtik ysxc hjumhsd cuhhw dnnhida yyzh lnklymg");
		defaultInput.add("nhbcxsu ccrbbyw scbxunh ghxrkqh brcwcyb");
		defaultInput.add("latdaav sexa ipzuzjl ayusb etb fshh");
		defaultInput.add("giz akqd vjmabii arfuzgv efrww jxkvolg efrww vrnzgbx");
		defaultInput.add("jmcc vqy adkzj fqrkdo tjrczp ccmj cfponk rptzjc");
		defaultInput.add("jsviu sraw imsj fujm cdf xwqhl lhz ojejzuy trtqblg");
		defaultInput.add("ibz dulm muoq quom etvjzxn tuhrpp jfukac jqctqn qhgbae msgmcit ludm");
		defaultInput.add("zgx bpfa elhp rnyqtq wyceube nkeuxz");
		defaultInput.add("lzxfo vygpecv jszacku zfxlo");
		defaultInput.add("cpmv ysaaj xnp wbvqg hrsiuj venjxna yeqvwmk ftaga dcqxc jgapb rqdixp");
		defaultInput.add("xpbbe tyn hfdlu fto wrgzkou sxylv cqto wdv xqc pnu rapk");
		defaultInput.add("pkrxypl wnu oipq tzbhnc gpug tgzf ofjb");
		defaultInput.add("mvaz bwcv gll itgcye dessw szt gzimgeu bvmohh wbywyhc kzerxbr anjsive");
		defaultInput.add("lhvnrzs qkmjwy pnyciwp mgp jfdz ghvtf yusfzg upab");
		defaultInput.add("xbscukx aubulj snbcmc uscxkbx ddpucyg");
		defaultInput.add("hgv ollh yzpjmpy fcicyae vhg gvh");
		defaultInput.add("prd onyd iux oik xui");
		defaultInput.add("zipadig nvewx cir lbpcusx dljqy");
		defaultInput.add("ifyxzsc btmy lsu tmyb lus ldyzx");
		defaultInput.add("egmyxbe ieasvek dylmj qahtatr uyqgbk");
		defaultInput.add("mejjczw spj vaekp kdud");
		defaultInput.add("vwan mgenld mnlged vpfuil euoxlr rclkpi dfknyoa rhthij kcyxl qaxab crlpik");
		defaultInput.add("pqm eihogk iwml nuauxi ngilkoh jmu mbdi cqxz nblb rmuj zczdgp");
		defaultInput.add("pswbe mtzch wbeps fxtnc psa aioff pas");
		defaultInput.add("prwrpvz oadpqvz tgzrt giom pjyihh rxdir dmya xjolzxv");
		defaultInput.add("khdybe obqkjn kdq jkvmgwo enpat wyw qjbnko waid msest wwkoyts");
		defaultInput.add("yep liv ofmtpod imdd qyw");
		defaultInput.add("afnrx jgn gxarpb myltj ggrsajy mdaobjo vbtn vbtn zlziz eds");
		defaultInput.add("hqr kqu oub skoeqk icnfm cqvld aay bto");
		defaultInput.add("rga odaf exoosh pwevx zpbd plaa xoseoh");
		defaultInput.add("mbr gqu oxvchrt nqa larxmjx pfozej");
		defaultInput.add("ozuo ywubjbg xcua eblwqp nfdvw hmhen zkjfu gmhgp bsyi ktprtf");
		defaultInput.add("src vrysby srybvy znwjm hmypwdl gdmau pqe");
		defaultInput.add("cldr crhi lbaq fbuduyn hygbz uhida");
		defaultInput.add("qrxukq dygkp oaks soka oask");
		defaultInput.add("vpido ajgfq pwlv hezt fmg epwrxo rqvjke iovpd hhkjm");
		defaultInput.add("anxf ydl xnfa hqph olorp");
		defaultInput.add("exydcg onxjm psqlbv ehz boar hze qsblpv");
		defaultInput.add("mnzrvc ipj swg ijp sgw gdkntsd fzz grqwly");
		defaultInput.add("erpq qghpj fay gci uglm afy");
		defaultInput.add("jwbq hbxaub jpdilyt yvalrlk topl qup");
		defaultInput.add("eczonk ftcc paltirb owz tihhe dglxory wthvqcb qdnxm lirejh alyxsr");
		defaultInput.add("ooruaby gboyeu lkv arrz jcqyzl uxlfk fhmeony fcmh");
		defaultInput.add("wzr xjb pwmf okqj adwcedy lkidve uwekxf asbdzr biub");
		defaultInput.add("dikhur pxgh urdinjh wednf ulzdxs");
		defaultInput.add("iplf byt tyt qnnlba pzt bednml ljjtkvo tjovlkj uwms xat");
		defaultInput.add("htzk ltmfha xikeze atfmhl fchxhyz");
		defaultInput.add("lqala bqwgcul vetaa xuxjau zcb wtdmomu wfqmpq sief uyblyz ahv");
		defaultInput.add("aytvvo awm ojaaigg awm dbfaokz");
		defaultInput.add("abq npcyld fzbfku oia qss jkxldm wgtmki pasgxi dieix rpqnuac tecnfy");
		defaultInput.add("nmr qzfj qjfz lsz vnahex");
		defaultInput.add("djxoo jzlkh svy xige");
		defaultInput.add("tjlkkg glcuvmh fwzlhi ecun qlgulj hrfhyql qgdlf ofakqdf zokkvm gelxkq oowgs");
		defaultInput.add("upfpk gfstjlv lxc rjd nhj sbq jpzsz zsjzp");
		defaultInput.add("favd nzqfdid nekfjsf mtjndu");
		defaultInput.add("sgdqx uvpuefv vhwrgd aivav gsqxd jdhfoq");
		defaultInput.add("llaf cthbgy njrpw fqgkx jzf xqkgf lnrfrm gkxqf");
		defaultInput.add("wzdwlc wisst alw kyjeur sjsqfcr tta bijnyn whfyoxl");
		defaultInput.add("dtjr baxkj lmnyrlg nrmyllg");
		defaultInput.add("mtgky xmwf zdko nnocxye gytkm ygp hixk xwmf");
		defaultInput.add("maudjy okgjga uadjmy dzfrk omd");
		defaultInput.add("azz ajdcqkd bcafn zaz dcjaqdk gylyzo");
		defaultInput.add("xzvfbf fopmfxu mvftgr mfupoxf coyhof talcc vpkslo");

		return defaultInput;
	}

}
