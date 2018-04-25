package test.day13;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.day13.DayThirteen;
import main.day13.Firewall;


public class TestDayThirteen {
	
	@Test
	public void testPartOneTestImperative1() {
		

		List<String> input = new ArrayList<>();
		input.add("0: 3");
		input.add("1: 2");
		input.add("4: 4");
		input.add("6: 4");
		
		Integer value = DayThirteen.getAnswerPartOneImperative(input);
		System.out.println("value is "+value+".");
		assertEquals(
				value==24
				,
				true);
		System.out.println("Success on Day13.testPartOneTest1!");
	}
	
//	@Test
//	public void testTick(){
//		
//		List<String> input = new ArrayList<>();
//		input.add("0: 3");
//		input.add("1: 2");
//		input.add("4: 4");
//		input.add("6: 4");
//		
//		Firewall firewall = DayThirteen.createFirewallFromInput(input);
//		firewall.tick();
//		System.out.println("firewall at second layer has range "+firewall.getFirewallLayers().get(1).getRange()+".");
//		System.out.println("firewall at second layer is at index "+firewall.getFirewallLayers().get(1).getCurrentLocation()+".");
//		System.out.println("firewall at second layer has descending value "+firewall.getFirewallLayers().get(1).isDescending()+".");
//		firewall.tick();
//		System.out.println("firewall at second layer is at index "+firewall.getFirewallLayers().get(1).getCurrentLocation()+".");
//		System.out.println("firewall at second layer has descending value "+firewall.getFirewallLayers().get(1).isDescending()+".");
//		firewall.tick();
//		System.out.println("firewall at second layer is at index "+firewall.getFirewallLayers().get(1).getCurrentLocation()+".");
//		System.out.println("firewall at second layer has descending value "+firewall.getFirewallLayers().get(1).isDescending()+".");
//		
//		assertEquals(1==1,true);
//		System.out.println("Success on Day13.testTick!");
//		
//	}
	

}
