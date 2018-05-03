package test.day13;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.day13.DayThirteen;
import main.day13.Firewall;


public class TestDayThirteen {
	
//	@Test
//	public void testPartOneTestImperative1() {
//		
//
//		List<String> input = new ArrayList<>();
//		input.add("0: 3");
//		input.add("1: 2");
//		input.add("4: 4");
//		input.add("6: 4");
//		
//		Integer value = DayThirteen.getAnswerPartOneImperative(input);
//		assertEquals(
//				value==24
//				,
//				true);
//		System.out.println("Success on Day13.testPartOneTest1!");
//	}
	
	/*
	@Test
	public void testPartOneTestCouldBeZeroAtGivenTime() {
		

		List<String> input = new ArrayList<>();
		input.add("0: 3");
		input.add("1: 2");
		input.add("4: 4");
		input.add("6: 4");
		
		Firewall firewall = DayThirteen.createFirewallFromInput(input);
		List<Boolean> booleanList = new ArrayList<>();
		booleanList.add(firewall.getFirewallLayers().get(6).couldBeZeroAtGivenTime(0));
		booleanList.add(firewall.getFirewallLayers().get(6).couldBeZeroAtGivenTime(1));
		booleanList.add(firewall.getFirewallLayers().get(6).couldBeZeroAtGivenTime(2));
		booleanList.add(firewall.getFirewallLayers().get(6).couldBeZeroAtGivenTime(3));
		booleanList.add(firewall.getFirewallLayers().get(6).couldBeZeroAtGivenTime(4));
		booleanList.add(firewall.getFirewallLayers().get(6).couldBeZeroAtGivenTime(5));
		booleanList.add(firewall.getFirewallLayers().get(6).couldBeZeroAtGivenTime(6));
		booleanList.add(firewall.getFirewallLayers().get(6).couldBeZeroAtGivenTime(7));
		booleanList.add(firewall.getFirewallLayers().get(6).couldBeZeroAtGivenTime(8));
		booleanList.add(firewall.getFirewallLayers().get(6).couldBeZeroAtGivenTime(9));
		booleanList.add(firewall.getFirewallLayers().get(6).couldBeZeroAtGivenTime(10));
		booleanList.add(firewall.getFirewallLayers().get(6).couldBeZeroAtGivenTime(11));
		booleanList.add(firewall.getFirewallLayers().get(6).couldBeZeroAtGivenTime(12));
		booleanList.add(firewall.getFirewallLayers().get(6).couldBeZeroAtGivenTime(13));
		booleanList.add(firewall.getFirewallLayers().get(6).couldBeZeroAtGivenTime(14));
		
		booleanList.add(firewall.getFirewallLayers().get(1).couldBeZeroAtGivenTime(0));
		booleanList.add(firewall.getFirewallLayers().get(1).couldBeZeroAtGivenTime(1));
		booleanList.add(firewall.getFirewallLayers().get(1).couldBeZeroAtGivenTime(2));
		booleanList.add(firewall.getFirewallLayers().get(1).couldBeZeroAtGivenTime(3));
		booleanList.add(firewall.getFirewallLayers().get(1).couldBeZeroAtGivenTime(4));
		booleanList.add(firewall.getFirewallLayers().get(1).couldBeZeroAtGivenTime(5));
		booleanList.add(firewall.getFirewallLayers().get(1).couldBeZeroAtGivenTime(6));
		booleanList.add(firewall.getFirewallLayers().get(1).couldBeZeroAtGivenTime(7));
		booleanList.add(firewall.getFirewallLayers().get(1).couldBeZeroAtGivenTime(8));
		booleanList.add(firewall.getFirewallLayers().get(1).couldBeZeroAtGivenTime(9));
		booleanList.add(firewall.getFirewallLayers().get(1).couldBeZeroAtGivenTime(10));
		booleanList.add(firewall.getFirewallLayers().get(1).couldBeZeroAtGivenTime(11));
		booleanList.add(firewall.getFirewallLayers().get(1).couldBeZeroAtGivenTime(12));
		booleanList.add(firewall.getFirewallLayers().get(1).couldBeZeroAtGivenTime(13));
		booleanList.add(firewall.getFirewallLayers().get(1).couldBeZeroAtGivenTime(14));
		
		booleanList.add(firewall.getFirewallLayers().get(4).couldBeZeroAtGivenTime(0));
		booleanList.add(firewall.getFirewallLayers().get(4).couldBeZeroAtGivenTime(1));
		booleanList.add(firewall.getFirewallLayers().get(4).couldBeZeroAtGivenTime(2));
		booleanList.add(firewall.getFirewallLayers().get(4).couldBeZeroAtGivenTime(3));
		booleanList.add(firewall.getFirewallLayers().get(4).couldBeZeroAtGivenTime(4));
		booleanList.add(firewall.getFirewallLayers().get(4).couldBeZeroAtGivenTime(5));
		booleanList.add(firewall.getFirewallLayers().get(4).couldBeZeroAtGivenTime(6));
		booleanList.add(firewall.getFirewallLayers().get(4).couldBeZeroAtGivenTime(7));
		booleanList.add(firewall.getFirewallLayers().get(4).couldBeZeroAtGivenTime(8));
		booleanList.add(firewall.getFirewallLayers().get(4).couldBeZeroAtGivenTime(9));
		booleanList.add(firewall.getFirewallLayers().get(4).couldBeZeroAtGivenTime(10));
		booleanList.add(firewall.getFirewallLayers().get(4).couldBeZeroAtGivenTime(11));
		booleanList.add(firewall.getFirewallLayers().get(4).couldBeZeroAtGivenTime(12));
		booleanList.add(firewall.getFirewallLayers().get(4).couldBeZeroAtGivenTime(13));
		booleanList.add(firewall.getFirewallLayers().get(4).couldBeZeroAtGivenTime(14));
		
		booleanList.add(firewall.getFirewallLayers().get(6).couldBeZeroAtGivenTime(0));
		booleanList.add(firewall.getFirewallLayers().get(6).couldBeZeroAtGivenTime(1));
		booleanList.add(firewall.getFirewallLayers().get(6).couldBeZeroAtGivenTime(2));
		booleanList.add(firewall.getFirewallLayers().get(6).couldBeZeroAtGivenTime(3));
		booleanList.add(firewall.getFirewallLayers().get(6).couldBeZeroAtGivenTime(4));
		booleanList.add(firewall.getFirewallLayers().get(6).couldBeZeroAtGivenTime(5));
		booleanList.add(firewall.getFirewallLayers().get(6).couldBeZeroAtGivenTime(6));
		booleanList.add(firewall.getFirewallLayers().get(6).couldBeZeroAtGivenTime(7));
		booleanList.add(firewall.getFirewallLayers().get(6).couldBeZeroAtGivenTime(8));
		booleanList.add(firewall.getFirewallLayers().get(6).couldBeZeroAtGivenTime(9));
		booleanList.add(firewall.getFirewallLayers().get(6).couldBeZeroAtGivenTime(10));
		booleanList.add(firewall.getFirewallLayers().get(6).couldBeZeroAtGivenTime(11));
		booleanList.add(firewall.getFirewallLayers().get(6).couldBeZeroAtGivenTime(12));
		booleanList.add(firewall.getFirewallLayers().get(6).couldBeZeroAtGivenTime(13));
		booleanList.add(firewall.getFirewallLayers().get(6).couldBeZeroAtGivenTime(14));
		
//		Integer value = DayThirteen.getAnswerPartOneImperativeModular(input);
//		System.out.println(value);
		assertEquals(
//				value==24
//				, 
				1==1
				,
				true);
		System.out.println("Success on Day13.testPartOneTestCouldBeZeroAtGivenTime!");
	}
	*/
	
//	@Test
//	public void testPartOneTestImperativeModular1() {
//		
//
//		List<String> input = new ArrayList<>();
//		input.add("0: 3");
//		input.add("1: 2");
//		input.add("4: 4");
//		input.add("6: 4");
//		
//		Integer value = DayThirteen.getAnswerPartOneImperativeModular(input);
//		System.out.println(value);
//		assertEquals(
//				value==24
//				,
//				true);
//		System.out.println("Success on Day13.testPartOneModularTest1!");
//	}
	
//	@Test
//	public void testPartTwoTestImperative1() {
//		
//
//		List<String> input = new ArrayList<>();
//		input.add("0: 3");
//		input.add("1: 2");
//		input.add("4: 4");
//		input.add("6: 4");
//		
//		Integer value = DayThirteen.getAnswerPartTwoImperative(input);
//		assertEquals(
//				value==10
//				,
//				true);
//		System.out.println("Success on Day13.testPartTwoTest1!");
//	}
	
	@Test
	public void testPartTwoTestImperativeModular1() {
		

		List<String> input = new ArrayList<>();
		input.add("0: 3");
		input.add("1: 2");
		input.add("4: 4");
		input.add("6: 4");
		
		Integer value = DayThirteen.getAnswerPartTwoImperativeModular(input);
		System.out.print("value is "+value+".");
		assertEquals(
				value==10
				,
				true);
		System.out.println("Success on Day13.testPartOneTest1!");
	}
	

}
