package org.coursera.dataStructure.progAssign1.checkBracketProblem;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestBracket {

	Bracket brcType1; // type (
	Bracket brcType2; // type {
	Bracket brcType3; // type [
	
	@Before
	public void setup(){
		brcType1 = new Bracket('(', 1);
		brcType2 = new Bracket('{', 1);
		brcType3 = new Bracket('[', 1);
	}
	
	@Test
	public void testMatchType1() {
		assertTrue(brcType1.match(')'));
		assertFalse(brcType1.match('{'));
		assertFalse(brcType1.match('['));
		assertFalse(brcType1.match('('));
		assertFalse(brcType1.match('}'));
		assertFalse(brcType1.match(']'));
		assertFalse(brcType1.match('r'));
	}
	
	@Test
	public void testMatchType2() {
		assertTrue(brcType2.match('}'));
		assertFalse(brcType2.match('('));
		assertFalse(brcType2.match('['));
		assertFalse(brcType2.match('{'));
		assertFalse(brcType2.match(')'));
		assertFalse(brcType2.match(']'));
		assertFalse(brcType2.match('r'));
	
	}

	@Test
	public void testMatchType3() {
		assertTrue(brcType3.match(']'));
		assertFalse(brcType3.match('{'));
		assertFalse(brcType3.match('('));
		assertFalse(brcType3.match('['));
		assertFalse(brcType3.match('}'));
		assertFalse(brcType3.match(')'));
		assertFalse(brcType3.match('r'));
	
	}

}
