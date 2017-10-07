import static org.junit.Assert.*;

import org.junit.Test;


public class ExampleTest {

	//Constructor
	Example Q1 = new Example(1,1,1);
	Example Q2 = new Example(10,10,10);
	
	@Test
	public void testA() {
		int a=1;int b=10;
		assertEquals("4",Q1.A(a));
		assertEquals("-11",Q2.A(b));
		//assertEquals("103",Q1.A(118));
		//assertEquals("-21",Q1.A(0));
		//assertEquals("-4",Q1.A(-1));
		//fail("Not yet implemented");
	}
	
/*
	@Test
	public void testB() {
		//assertEquals("-4",Q1.B(-1));
		//assertEquals("3",Q1.B(0));
		
		//fail("Not yet implemented");
	}*/

	@Test
	public void testC() {
		assertEquals("-4",Q1.C(-1));
		//assertEquals("3",Q1.C(0));
		//fail("Not yet implemented");
	}

}
