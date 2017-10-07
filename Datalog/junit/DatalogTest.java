import static org.junit.Assert.*;

import org.junit.Test;


public class DatalogTest {
	String name = "1";
	Predicate P = new Predicate(name);
	String mm = "1";
	Value v = new Value(mm);
	Variable vv = new Variable(mm);
	Argument A1 = new Argument(v,vv,false);
	Argument A2 = new Argument(v,vv,true);
	Argument[] AA = {A1,A2};

	//稳如汉堡包
	Datalog D = new Datalog(P,AA);
	
	
	//写这种会出问题的要用try except
	@Test
	public void testDatalog() {
		try{
			new Datalog(null,AA);
		}catch(Exception e1){
			assertEquals(e1 instanceof NullPointerException, true);
		}
		
		try{
			Argument[] BB = {};
			new Datalog(P,BB);
		}catch(Exception e2){
			assertEquals(e2 instanceof NullPointerException, true);
		}
	}
	

	@Test
	public void testGetPredicate() {
		assertEquals(P, D.getPredicate());
	}
	

	@Test  //????
	public void testGetArgumentsaaa() {
		try{
			assertEquals("[LArgument;@2999d183", D.getArguments());
		}catch(Exception e3){
			assertEquals(e3 instanceof NullPointerException, true);
		}
	}

	
	//good
	@Test
	public void testEqualsObject() {
		assertEquals(false, D.equals(null));
		assertEquals(true, D.equals(D));
		assertEquals(false, D.equals(P));


	}

	//no point
	@Test
	public void testHashCode() {
		assertEquals("", D.hashCode());
	}


	@Test
	public void testCompatibleWith() {
		Predicate pp = new Predicate(name);
		Value vv = new Value("1");
		Value vvv = new Value("2");
		Value [] V = {vv,vvv};
		Fact F = new Fact(pp,V);
		
		assertEquals(false, D.compatibleWith(F));
		
		
	//	assertEquals(true, D.compatibleWith(fff));
	}

	@Test
	public void testSubstituteTo() {
		Predicate pp = new Predicate(name);
		Value vv = new Value("1");
		Value vvv = new Value("2");
		Value [] V = {vv,vvv};
		Fact F = new Fact(pp,V);
		
		assertEquals(null, D.substituteTo(F));
	}

	@Test
	public void testToFact() {
		assertEquals(null, D.toFact());
	}

	@Test
	public void testToString() {
		assertEquals("1(VAR:1,1)", D.toString());
	}

}
