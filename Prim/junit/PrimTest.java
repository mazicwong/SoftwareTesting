import static org.junit.Assert.*;

import org.junit.Test;


public class PrimTest {
	NodeNetwork NN = new NodeNetwork();
	Prim PP = new Prim(NN);

	@Test
	public void testPrim() {
		new Prim(NN);
	}

	@Test
	public void testFindWholeCaravaneWithPrim() {
		assertEquals(null,PP.findWholeCaravaneWithPrim());
	}

	@Test
	public void testPrintWholeCaravaneWithPrim() {
		PP.printWholeCaravaneWithPrim();
	}

}
