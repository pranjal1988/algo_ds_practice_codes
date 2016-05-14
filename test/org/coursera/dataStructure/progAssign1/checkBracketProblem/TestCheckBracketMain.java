package org.coursera.dataStructure.progAssign1.checkBracketProblem;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class TestCheckBracketMain {
	int testCaseCount;
	String testDir;
	CheckBracketMain ck;
	
	@Before
	public void setup(){
		testDir = "E:\\Coursera_Working_Directory\\DataStructure\\assignment1\\Starters PA1\\check_brackets_in_code\\tests\\";
		testCaseCount = 54;
		ck = new CheckBracketMain();
	}

	@Test
	public void testdoBracketChecking() throws IOException {
		for(int i = 1; i <= testCaseCount; i++){
			System.out.println(i + ") : - ");
			String testCaseFile = testDir+"" + String.format("%02d", i);
			String testResultsFile = testDir+"" + String.format("%02d", i) + ".a";
			BufferedReader testInput = new BufferedReader(new FileReader(testCaseFile));
			BufferedReader testResult = new BufferedReader(new FileReader(testResultsFile));
			String text = testInput.readLine();
			String expectedResult = testResult.readLine();
			String output = ck.doBracketChecking(text);
			assertEquals(expectedResult, output);
		}
	}

}
