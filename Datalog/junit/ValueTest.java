import static org.junit.Assert.*;

import org.junit.Test;


public class ValueTest {
	String qq = "1";
	Value V = new Value(qq);
	@Test
	public void test() {
		Value V1 = new Value("111");
		assertEquals("111", V1.getValue());
		
		Object o = new Object();
		assertEquals(false,V1.equals(o));
		
		Value V2 = new Value(null);
		assertEquals(false,V2.equals(V2));
		
		
		String aa = "qqq";
		Predicate P1 = new Predicate(aa);
		assertEquals(false,P1.equals(P1));
		
		//fail("Not yet implemented");
	}
	
	@Test
	public void testHashCode(){
		assertEquals(49,V.hashCode());//运行算出来的。。
	}
	
	@Test
	public void testToString(){
		String q = "1";
		assertEquals(q,V.toString());
	}
	
}
