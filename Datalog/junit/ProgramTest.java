import static org.junit.Assert.*;

import org.junit.Test;


public class ProgramTest {

	//Program P = new Program(RR);
	String name = "1";
	Predicate P = new Predicate(name);
	String mm = "1";
	Value v = new Value(mm);
	Variable vv = new Variable(mm);
	Argument A1 = new Argument(v,vv,false);
	Argument A2 = new Argument(v,vv,true);
	Argument[] AA = {A1,A2};
	//ÎÈÈçºº±¤°ü
	Datalog head = new Datalog(P,AA);
	Datalog body1 = new Datalog(P,AA);
	Datalog body2 = new Datalog(P,AA);
	Datalog[] body = {body1,body2};
	Rule R1 = new Rule(head,body);
	Rule R2 = new Rule(head,body);
	Rule[] RR = {R1,R2};
	
	Program PP = new Program(RR);
	
	@Test
	public void testProgram() {
		
	}

	@Test
	public void testGetProgram() {
		assertEquals(PP,PP.getProgram());
	}

	@Test
	public void testCanDerive() {
		fail("Not yet implemented");
	}

	@Test
	public void testQuery() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeriveAll() {
		fail("Not yet implemented");
	}

}
