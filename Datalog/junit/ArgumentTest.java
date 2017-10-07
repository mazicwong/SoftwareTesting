import static org.junit.Assert.*;

import org.junit.Test;


public class ArgumentTest {

	String mm = "1";
	Value v = new Value(mm);
	Variable vv = new Variable(mm);
	boolean iss = true;
	
	
	Argument A = new Argument(v, vv, iss);
	
	

	@Test
	public void testValue() {
		Argument A1 = new Argument(v,null,true);
		assertEquals(A1,Argument.value(v));
		
		//fail("Not yet implemented");
	}

	@Test
	public void testVariable() {
		Argument A2 = new Argument(null,vv,false);
		assertEquals(A2,Argument.variable(vv));
		//fail("Not yet implemented");
	}

	@Test
	public void testIsValue() {
		assertEquals(true,A.isValue());
	}

	@Test
	public void testIsVariable() {
		assertEquals(null,A.isVariable());
	}

	@Test
	public void testGetValue() {
		assertEquals(v,A.getValue());
	}

	@Test
	public void testGetVariable() {
		assertEquals(vv,A.getVariable());
	}

	@Test
	public void testToString() {
		Argument BB = new Argument(v,vv,false);
		assertEquals(v,A.toString());
		assertEquals(vv,BB.toString());
	}

}
