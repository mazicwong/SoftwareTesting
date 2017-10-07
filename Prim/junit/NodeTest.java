import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NodeTest {
	//List<Path> paths = new ArrayList<Path>();
	
	String V1="1", V2="2", V3="3";
	Node N1 = new Node(V1);
	Node N2 = new Node(V2);
	Node N3 = new Node(V3);
	
	Path P1 = new Path(1,N1,N2); //weight, to ,from
	Path P2 = new Path(2,N2,N3);
	Path P3 = new Path(1,N1,N3);

	List<Path> L1 = new ArrayList<Path>();


//	Node N4 = new Node(V1,P1,P2,P3);
	Path P4 = new Path(1,N1);    //weight, to
	
	@Test
	public void testNodeStringPathArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testNodeString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPaths() {
		assertEquals(V1,N1.getName());
	}

	
	@Test
	public void testAddPathWithoutSource() {
		N1.addPathWithoutSource(P1);
		N1.addPathWithoutSource(P4);
		
	}
	
	/* private
	@Test
	public void testAddPathWithSource() {
		N1.addPathWithSource(P1);
	}*/
	
	
	
	@Test
	public void testGetName() {
		assertEquals(V1,N1.getName());
	}

	
	@Test
	public void testEqualsObject() {
		assertEquals(false,N1.equals(null));
		assertEquals(true,N1.equals(N1));
		assertEquals(false,N1.equals(N2));
		assertEquals(false,N1.equals(P1));
	}

}
