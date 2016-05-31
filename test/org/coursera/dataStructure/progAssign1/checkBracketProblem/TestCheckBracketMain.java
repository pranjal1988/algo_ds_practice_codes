package org.coursera.dataStructure.progAssign1.checkBracketProblem;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;

import org.coursera.dataStructure.CommonTestCaseFileReader;
import org.junit.Before;
import org.junit.Test;

public class TestCheckBracketMain {
	int testCaseCount;
	String testDir;
	CheckBracketMain ck;
	BufferedReader testCaseReader;
	BufferedReader testResultReader;
	
	@Before
	public void setup(){
		testDir = "E:\\Coursera_Working_Directory\\DataStructure\\assignment1\\Starters PA1\\check_brackets_in_code\\tests\\";
		testCaseCount = 54;
		ck = new CheckBracketMain();
	}

	@Test
	public void testdoBracketChecking() throws IOException {
		CommonTestCaseFileReader testInputFileReader = new CommonTestCaseFileReader(testDir, testCaseCount);
		CommonTestCaseFileReader testResultFileReader = new CommonTestCaseFileReader(testDir, testCaseCount , ".a");
		int ct = 1;
		while(testInputFileReader.hasMoreFiles() && testResultFileReader.hasMoreFiles()){
			testCaseReader = testInputFileReader.getNextFileReader();
			testResultReader = testResultFileReader.getNextFileReader();
			String text = testCaseReader.readLine();
			String expectedResult = testResultReader.readLine();
			String output = ck.doBracketChecking(text);
			System.out.println(ct + ") Expected : " + expectedResult + " got : " + output);
			assertEquals(expectedResult, output);
			testCaseReader.close();
			testResultReader.close();
			ct++;
		}
	}

}
