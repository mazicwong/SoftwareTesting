import static org.junit.Assert.*;

import org.junit.Test;


public class PredicateTest {
	
	String mm = "1";
	Predicate P = new Predicate(mm);

	@Test
	public void testPredicate() {
		new Predicate(null); //point 1
		//fail("Not yet implemented");
	}

	@Test
	public void testGetName() {
		assertEquals(mm,P.getName());
		//fail("Not yet implemented");
	}

	@Test
	public void testEqualsObject() {
		String qq = null;
		assertEquals(false,P.equals(qq)); //point 1
		assertEquals(false,P.equals(mm)); //point 2
		assertEquals(false,P.equals(P));  //point 1
		//fail("Not yet implemented");
	}
	
	@Test   //no point
	public void testHashCode() {
		assertEquals(49,P.hashCode());
		//fail("Not yet implemented");
	}


	@Test   //no point
	public void testToString() {
		assertEquals(mm,P.toString());
		//fail("Not yet implemented");
	}

}
