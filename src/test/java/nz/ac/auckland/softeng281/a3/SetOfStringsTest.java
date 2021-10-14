package nz.ac.auckland.softeng281.a3;

// YOU SHOULD ADD NEW TEST CASES

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SetOfStringsTest {
	SetOfStrings set1, set2;

	@Before
	public void setUp() {
		set1 = new SetOfStrings();
		set2 = new SetOfStrings();
	}

	@After
	public void tearDown() {

	}

	@Test
	public void testUnion() {

		set1.insertElement("a");
		set2.insertElement("b");

		SetOfStrings expected = new SetOfStrings();
		expected.insertElement("a");
		expected.insertElement("b");
		assertEquals(expected, set1.union(set2));
	}
	
	@Test
	public void testUnion2() {

		set1.insertElement("a");
		set2.insertElement("b");
		set2.insertElement("3");
		set2.insertElement("hello");

		SetOfStrings expected = new SetOfStrings();
		expected.insertElement("a");
		expected.insertElement("b");
		expected.insertElement("3");
		expected.insertElement("hello");
		assertEquals(expected, set1.union(set2));
	}
	
	@Test
	public void testUnion3() {

		set1.insertElement("a");
		set1.insertElement("cheese");
		set1.insertElement("c");
		set1.insertElement("d");
		set1.insertElement("e");
		

		SetOfStrings expected = new SetOfStrings();
		expected.insertElement("a");
		expected.insertElement("cheese");
		expected.insertElement("c");
		expected.insertElement("d");
		expected.insertElement("e");
		assertEquals(expected, set1.union(set2));
	}
	
	@Test
	public void testIntersection() {
		set1.insertElement("a");
		set1.insertElement("b");
		set2.insertElement("b");
		set2.insertElement("a");
		
		SetOfStrings expected = new SetOfStrings();
		expected.insertElement("a");
		expected.insertElement("b");
		assertEquals(expected, set1.intersection(set2));
	}
	
	@Test
	public void testIntersection2() {
		set1.insertElement("a");
		set1.insertElement("b");
		
		SetOfStrings expected = new SetOfStrings();
		assertEquals(expected, set1.intersection(set2));
	}
	
	@Test
	public void testIntersection3() {
		set1.insertElement("a");
		set1.insertElement("e");
		set2.insertElement("a");
		set2.insertElement("b");
		set2.insertElement("c");
		set2.insertElement("d");
		
		SetOfStrings expected = new SetOfStrings();
		expected.insertElement("a");
		assertEquals(expected, set1.intersection(set2));
	
	}
	
	@Test
	public void testDifference() {
		set1.insertElement("a");
		set1.insertElement("b");
		set2.insertElement("a");
		
		SetOfStrings expected = new SetOfStrings();
		expected.insertElement("b");
		assertEquals(expected, set1.difference(set2));
	}
	
	@Test
	public void testDifference2() {
		set1.insertElement("a");
		set1.insertElement("b");
		set2.insertElement("c");		
		SetOfStrings expected = new SetOfStrings();
		expected.insertElement("a");
		expected.insertElement("b");
		assertEquals(expected, set1.difference(set2));
	}
	
	@Test
	public void testDifference3() {
		set1.insertElement("a");	
		
		SetOfStrings expected = new SetOfStrings();
		assertEquals(expected, set2.difference(set1));
	}
	
	@Test
	public void testDifference4() {
		set1.insertElement("hello");
		set1.insertElement("goodbye");
		set2.insertElement("hello");
		set2.insertElement("goodbye");
		set2.insertElement("c");
		set2.insertElement("d");
		
		SetOfStrings expected = new SetOfStrings();
		expected.insertElement("c");
		expected.insertElement("d");
		assertEquals(expected, set2.difference(set1));
	}
	
	@Test
	public void testDifference5() {
		set1.insertElement("a");
		set1.insertElement("b");
		set2.insertElement("a");
		set2.insertElement("b");
		set2.insertElement("c");
		set2.insertElement("d");
		
		SetOfStrings expected = new SetOfStrings();
		assertEquals(expected, set1.difference(set2));
	}	
}
