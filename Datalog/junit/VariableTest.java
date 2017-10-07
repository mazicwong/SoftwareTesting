import static org.junit.Assert.*;

import org.junit.Test;


public class VariableTest {

	String qq = "1";
	Variable V = new Variable(qq);
	
	
	@Test
	public void testVariable() {
		String aa = null;
		try{
			new Variable(aa);
		}catch(Exception e){
    		assertEquals(e instanceof NullPointerException, true);
		}
	}

	@Test
	public void testGetIdentifier() {
		assertEquals("1",V.getIdentifier());
		//fail("Not yet implemented");
	}

	@Test
	public void testEqualsObject() {
		Object o = new Object();
		assertEquals(false,V.equals(o)); //2 points ! 
		//类名要用这个类的，这样才是调用这个类的方法,然后参数可以用别的类的

		String aa = "qqq";
		Predicate P1 = new Predicate(aa);
		assertEquals(false,V.equals(P1)); //1 points !

		assertEquals(false,V.equals(V)); //1 points  !
		//fail("Not yet implemented"); 
	}
	
	@Test
	public void testHashCode() {
		assertEquals(49,V.hashCode());
		//fail("Not yet implemented");
	}
	
	@Test
	public void testToString() {
		assertEquals("VAR:1",V.toString());
		//fail("Not yet implemented");
	}

}

