package nz.ac.auckland.softeng281.a3;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StringRelationTest {

	private StringRelation relation;
	private SetOfStrings setMembers;

	@Before
	public void setUp() {
		setMembers = new SetOfStrings();
		relation = new StringRelation(setMembers);
	}

	@After
	public void tearDown() {

	}

	@Test
	public void testReflexive() {
		relation.insertElement("1,1");
		setMembers.insertElement("1");
		assertTrue(relation.isReflexive());
	}
	
	@Test
	public void testReflexive2() {
		relation.insertElement("1,1");
		relation.insertElement("2,2");
		relation.insertElement("3,3");
		relation.insertElement("4,4");
		setMembers.insertElement("1");
		setMembers.insertElement("2");
		setMembers.insertElement("3");
		setMembers.insertElement("4");
		
		assertTrue(relation.isReflexive());
	}
	@Test
	public void testReflexive3() {
		relation.insertElement("4,4");
		relation.insertElement("2,1");
		relation.insertElement("1,2");
		relation.insertElement("3,5");
		setMembers.insertElement("3");
		
		assertTrue(!relation.isReflexive());
	}
	
	@Test
	public void testReflexive4() {
		relation.insertElement("1,1");
		relation.insertElement("2,2");
		relation.insertElement("3,3");
		setMembers.insertElement("1");
		setMembers.insertElement("2");
		setMembers.insertElement("3");
		setMembers.insertElement("4");
		
		assertTrue(!relation.isReflexive());
	}

	@Test
	public void testReflexive5() {
		relation.insertElement("1,1");
		relation.insertElement("2,2");
		relation.insertElement("3,3");
		relation.insertElement("4,4");
		setMembers.insertElement("1");
		setMembers.insertElement("2");
		setMembers.insertElement("3");
		
		assertTrue(!relation.isReflexive());
	}
	
	@Test 
	public void testReflexive6() {
		relation.insertElement("1,1");
		relation.insertElement("2,2");
		relation.insertElement("3,3");
		relation.insertElement("3,1");
		relation.insertElement("3,2");
		setMembers.insertElement("1");
		setMembers.insertElement("2");
		setMembers.insertElement("3");
		
		assertTrue(relation.isReflexive());
	}
	
	@Test
	public void testReflexive7() {
		relation.insertElement("hello,hello");
		relation.insertElement("apples,apples");
		relation.insertElement("no,yes");
		relation.insertElement("yes,yes");
		relation.insertElement("no,no");
		setMembers.insertElement("no");
		setMembers.insertElement("yes");
		setMembers.insertElement("apples");
		setMembers.insertElement("hello");
		
		assertTrue(relation.isReflexive());
	}
	
	@Test 
	public void testReflexive8() {
		relation.insertElement("a,a");
		relation.insertElement("ab,ab");
		relation.insertElement("abc,a");
		relation.insertElement("abc,abc");
		relation.insertElement("a,ab");
		setMembers.insertElement("a");
		setMembers.insertElement("ab");
		setMembers.insertElement("abc");
		setMembers.insertElement("abcd");
		
		assertTrue(!relation.isReflexive());
	}
	
	@Test
	public void testSymmetric() {
		relation.insertElement("1,2");
		relation.insertElement("2,1");
		setMembers.insertElement("1");
		setMembers.insertElement("2");
		
		assertTrue(relation.isSymmetric());
	}
	
	@Test
	public void testSymmetric2() {
		relation.insertElement("1,2");
		relation.insertElement("2,1");
		relation.insertElement("3,2");
		relation.insertElement("2,3");
		relation.insertElement("4,2");
		relation.insertElement("2,4");
		setMembers.insertElement("1");
		setMembers.insertElement("2");
		setMembers.insertElement("3");
		setMembers.insertElement("4");
		
		assertTrue(relation.isSymmetric());
	}
	
	@Test
	public void testSymmetric3() {
		relation.insertElement("1,2");
		relation.insertElement("2,1");
		setMembers.insertElement("1");
		
		assertTrue(!relation.isSymmetric());
	}
	
	@Test
	public void testSymmetric4() {
		relation.insertElement("1,1");
		setMembers.insertElement("1");
		setMembers.insertElement("2");
		
		assertTrue(relation.isSymmetric());
	}
	
	@Test
	public void testSymmetric5() {
		relation.insertElement("hello,hello");
		setMembers.insertElement("hello");
		setMembers.insertElement("bye");
		
		assertTrue(relation.isSymmetric());
	}
	
	@Test
	public void testSymmetric6() {
		relation.insertElement("hello,hello");
		relation.insertElement("bye,hello");
		setMembers.insertElement("hello");
		setMembers.insertElement("bye");
		
		assertTrue(!relation.isSymmetric());
	}
	
	@Test
	public void testSymmetric7() {
		relation.insertElement("ab,ab");
		relation.insertElement("ab,ba");
		relation.insertElement("ba,ab");
		setMembers.insertElement("ab");
		setMembers.insertElement("ba");
		
		assertTrue(relation.isSymmetric());
	}
	
	@Test
	public void testSymmetric8() {
		relation.insertElement("hello,hello");
		relation.insertElement("bye,hello");
		relation.insertElement("hello,bye");
		setMembers.insertElement("hello");
		setMembers.insertElement("bye");
		
		assertTrue(relation.isSymmetric());
	}
	
	@Test
	public void testTransitive() {
		relation.insertElement("1,2");
		relation.insertElement("2,3");
		relation.insertElement("1,3");
		setMembers.insertElement("1");
		setMembers.insertElement("2");
		setMembers.insertElement("3");
		
		assertTrue(relation.isTransitive());
	}
	
	@Test
	public void testTransitive2() {
		relation.insertElement("1,1");
		relation.insertElement("1,2");
		relation.insertElement("1,3");
		relation.insertElement("2,2");
		relation.insertElement("2,3");
		relation.insertElement("3,3");
		setMembers.insertElement("1");
		setMembers.insertElement("2");
		setMembers.insertElement("3");
		
		assertTrue(relation.isTransitive());
	}
	
	@Test
	public void testTransitive3() {
		relation.insertElement("1,1");
		relation.insertElement("1,2");
		relation.insertElement("2,1");
		relation.insertElement("2,2");
		relation.insertElement("3,1");
		relation.insertElement("3,2");
		relation.insertElement("3,3");
		setMembers.insertElement("1");
		setMembers.insertElement("2");
		setMembers.insertElement("3");
		
		assertTrue(relation.isTransitive());
	}
	
	@Test
	public void testTransitive4() {
		relation.insertElement("1,1");
		relation.insertElement("1,2");
		relation.insertElement("2,1");
		relation.insertElement("2,2");
		relation.insertElement("2,3");
		relation.insertElement("3,2");
		relation.insertElement("3,3");
		setMembers.insertElement("1");
		setMembers.insertElement("2");
		setMembers.insertElement("3");
		
		assertTrue(!relation.isTransitive());
	}
	
	@Test
	public void testTransitive5() {
		relation.insertElement("1,1");
		relation.insertElement("1,2");
		relation.insertElement("2,2");
		relation.insertElement("2,3");
		relation.insertElement("3,3");
		setMembers.insertElement("1");
		setMembers.insertElement("2");
		setMembers.insertElement("3");
		
		assertTrue(!relation.isTransitive());
	}
	
	@Test
	public void testTransitive6() {
		relation.insertElement("1,1");
		relation.insertElement("1,2");
		relation.insertElement("2,2");
		setMembers.insertElement("1");
		setMembers.insertElement("2");
		setMembers.insertElement("3");
		
		assertTrue(relation.isTransitive());
	}
	
	@Test
	public void testTransitive7() {
		relation.insertElement("1,1");
		relation.insertElement("1,2");
		relation.insertElement("2,2");
		setMembers.insertElement("1");

		assertTrue(!relation.isTransitive());
	}
	
	@Test
	public void testTransitive8() {
		relation.insertElement("a,ab");
		relation.insertElement("ab,abc");
		relation.insertElement("a,abc");
		setMembers.insertElement("a");
		setMembers.insertElement("ab");
		setMembers.insertElement("abc");
		
		assertTrue(relation.isTransitive());
	}
	
	@Test
	public void testTransitive9() {
		relation.insertElement("morning,morning");
		relation.insertElement("night,morning");
		setMembers.insertElement("morning");
		setMembers.insertElement("noon");
		setMembers.insertElement("night");
		
		assertTrue(relation.isTransitive());
	}
	
	@Test
	public void testTransitive10() {
		relation.insertElement("morning,morning");
		relation.insertElement("night,morning");
		relation.insertElement("night,night");
		relation.insertElement("night,morning");
		relation.insertElement("noon,morning");
		setMembers.insertElement("morning");
		setMembers.insertElement("noon");
		setMembers.insertElement("night");
		
		assertTrue(relation.isTransitive());
	}
	
	@Test
	public void testTransitive11() {
		relation.insertElement("a,ab");
		relation.insertElement("ab,abc");
		relation.insertElement("a,a");
		relation.insertElement("abc,ab");
		relation.insertElement("abc,abc");
		relation.insertElement("abc,a");
		setMembers.insertElement("a");
		setMembers.insertElement("ab");
		setMembers.insertElement("abc");

		assertTrue(!relation.isTransitive());
	}
	
	
	@Test
	public void testEquivalence() {
		relation.insertElement("1,1");
		relation.insertElement("3,2");
		relation.insertElement("3,3");
		relation.insertElement("2,3");
		relation.insertElement("2,2");
		setMembers.insertElement("1");
		setMembers.insertElement("2");
		setMembers.insertElement("3");
		
		assertTrue(relation.isEquivalence());
	}
	
	@Test
	public void testEquivalence2() {
		relation.insertElement("1,1");
		relation.insertElement("3,2");
		relation.insertElement("3,3");
		relation.insertElement("2,3");
		relation.insertElement("1,2");
		setMembers.insertElement("1");
		setMembers.insertElement("2");
		setMembers.insertElement("3");
		
		assertTrue(!relation.isEquivalence());
	}
	
	@Test
	public void testEquivalence3() {
		relation.insertElement("1,1");
		setMembers.insertElement("1");
		
		assertTrue(relation.isEquivalence());
	}
	
	@Test
	public void testEquivalence4() {
		relation.insertElement("1,1");
		relation.insertElement("1,2");
		relation.insertElement("2,1");
		relation.insertElement("2,2");
		relation.insertElement("2,3");
		relation.insertElement("3,2");
		relation.insertElement("3,3");
		setMembers.insertElement("1");
		setMembers.insertElement("2");
		setMembers.insertElement("3");
		
		assertTrue(!relation.isEquivalence());
	}
	
	@Test
	public void testEquivalence5() {
		relation.insertElement("abracadabra,abracadabra");
		setMembers.insertElement("abracadabra");
		
		assertTrue(relation.isEquivalence());
	}
	
	@Test
	public void testEquivalence6() {
		relation.insertElement("hello,hello");
		relation.insertElement("bye,bye");
		relation.insertElement("good,good");
		relation.insertElement("good,bye");
		relation.insertElement("bye,good");
		setMembers.insertElement("hello");
		setMembers.insertElement("bye");
		setMembers.insertElement("good");
		
		assertTrue(relation.isEquivalence());
	}
	
	@Test
	public void testEquivalenceClass() {
		relation.insertElement("1,1");
		relation.insertElement("1,2");
		relation.insertElement("2,1");
		relation.insertElement("2,2");
		relation.insertElement("2,3");
		relation.insertElement("3,2");
		relation.insertElement("3,3");
		setMembers.insertElement("1");
		setMembers.insertElement("2");
		setMembers.insertElement("3");
		
		SetOfStrings expected = new SetOfStrings();
		
		
		assertEquals(expected, relation.computeEqClass("2"));
	}
	
	@Test
	public void testEquivalenceClass2() {
		relation.insertElement("1,1");
		relation.insertElement("3,2");
		relation.insertElement("3,3");
		relation.insertElement("2,3");
		relation.insertElement("1,2");
		setMembers.insertElement("1");
		setMembers.insertElement("2");
		setMembers.insertElement("3");
		
		SetOfStrings expected = new SetOfStrings();
		
		assertEquals(expected, relation.computeEqClass("1"));
	}
	
	@Test
	public void testEquivalenceClass3() {
		relation.insertElement("1,1");
		relation.insertElement("3,2");
		relation.insertElement("3,3");
		relation.insertElement("2,3");
		relation.insertElement("2,2");
		setMembers.insertElement("1");
		setMembers.insertElement("2");
		setMembers.insertElement("3");
		
		SetOfStrings expected = new SetOfStrings();
		expected.insertElement("2");
		expected.insertElement("3");
		
		assertEquals(expected, relation.computeEqClass("3"));
	}
	
	@Test
	public void testEquivalenceClass4() {
		relation.insertElement("hello,hello");
		relation.insertElement("bye,bye");
		relation.insertElement("good,good");
		relation.insertElement("good,bye");
		relation.insertElement("bye,good");
		setMembers.insertElement("hello");
		setMembers.insertElement("bye");
		setMembers.insertElement("good");
		
		SetOfStrings expected = new SetOfStrings();
		expected.insertElement("good");
		expected.insertElement("bye");
		
		assertEquals(expected, relation.computeEqClass("good"));
	}
	
	@Test
	public void testEquivalenceClass5() {
		relation.insertElement("hello,hello");
		relation.insertElement("bye,bye");
		relation.insertElement("good,good");
		relation.insertElement("good,bye");
		relation.insertElement("bye,good");
		setMembers.insertElement("hello");
		setMembers.insertElement("bye");
		setMembers.insertElement("good");
		
		SetOfStrings expected = new SetOfStrings();
		expected.insertElement("hello");
		
		assertEquals(expected, relation.computeEqClass("hello"));
	}
	
	@Test
	public void testEquivalenceClass6() {
		relation.insertElement("hello,hello");
		relation.insertElement("bye,bye");
		relation.insertElement("good,good");
		relation.insertElement("good,bye");
		setMembers.insertElement("hello");
		setMembers.insertElement("bye");
		setMembers.insertElement("good");
		
		SetOfStrings expected = new SetOfStrings();
		
		assertEquals(expected, relation.computeEqClass("hello"));
	}
	

}