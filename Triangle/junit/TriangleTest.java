import static org.junit.Assert.*;

import org.junit.Test;


public class TriangleTest {
	//Constructor
	Triangle T1 = new Triangle(2, 3, 4);
	Triangle T2 = new Triangle(0,0,0);
	Triangle T3 = new Triangle(2,3,6);
	Triangle T4 = new Triangle(3,3,3);
	Triangle T5 = new Triangle(3,3,2);

	//Triangle T3 = new Triangle(Long.MAX_VALUE+1,0,0);

	@Test
	// point:50
	public void testIsTriangle() {
		assertEquals(true, T1.isTriangle(T1));
		assertEquals(false, T2.isTriangle(T2));
		assertEquals(false, T3.isTriangle(T3));
	}

	@Test
	// point:50
	public void testGetType(){
		assertEquals("Illegal",T2.getType(T2));
		assertEquals("Regular",T4.getType(T4));
		assertEquals("Scalene",T1.getType(T1));
		assertEquals("Isosceles",T5.getType(T5));
	}
	
	
	/*@Test
	//only want to improve the ' Branch Coverage '
	long a=2;
	long b=5;
	public void testDiffOfBorders(){
		assertEquals("3",T1.diffOfBorders(a,b));
		//assertEquals("3",T1.diffOfBorders(b,a));
	}*/
	
	/*
	@Test
	public void testGetBorders(){
		long[] borders = new long[3];
		borders[0] = 2;
		borders[1] = 3;
		borders[2] = 4;
		assertEquals(borders,T1.getBorders());
	}*/
}
