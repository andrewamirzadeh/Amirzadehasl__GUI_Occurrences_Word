package application;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
//Author Name: Bijan Amirzadehasl
///Date: 3/17/2022
//Program Name: Amirzadehasl__GUI_Occurences_Word
//Purpose: Create three test cases for my GUI word occurences program
class testOccur {

	@Test
	void test() {
		var test = new Main();
		String string = test.sayThankYou();
		assertEquals("Thank you for using the program Professor Shah!", string);
	}
	
	@Test
	void secondTest() {
		var test = new Main();
		
		var<String, Integer> foodTable = new HashMap<String, Integer>();
		
		foodTable.put("Apple", 2);
		foodTable.put("Banana", 3);
		
		int output = test.countUniqueWords(foodTable);
		
		assertEquals(2, output);
		
	}
	
	@Test
	void thirdTest(){
		var test = new Main();
		double output = test.squareNum(10.5);
		assertEquals(110.25, output);
		
		
	}

}
