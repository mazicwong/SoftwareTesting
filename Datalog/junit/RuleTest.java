import static org.junit.Assert.*;

import org.junit.Test;


public class RuleTest {
	String name = "1";
	Predicate P = new Predicate(name);
	String mm = "1";
	Value v = new Value(mm);
	Variable vv = new Variable(mm);
	Argument A1 = new Argument(v,vv,false);
	Argument A2 = new Argument(v,vv,true);
	Argument[] AA = {A1,A2};
	//ÎÈÈçºº±¤°ü
	//Datalog D = new Datalog(P,AA);
	Datalog head = new Datalog(P,AA);
	Datalog body1 = new Datalog(P,AA);
	Datalog body2 = new Datalog(P,AA);
	Datalog[] body = {body1,body2};
	
	Rule R = new Rule(head,body);
	

	@Test
	public void testRule() {
		new Rule(head,body);
	}

	@Test
	public void testGetHead() {
		assertEquals(head,R.getHead());
	}

	@Test
	public void testGetBody() {
		assertEquals("[LDatalog;@54a8f58d",R.getBody());
	}

	@Test
	public void testDeriveOnce() {
		
	}

	@Test
	public void testToString() {
		assertEquals("1(VAR:1,1) :- 1(VAR:1,1),1(VAR:1,1).",R.toString());
	}

}
