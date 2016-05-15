package org.coursera.dataStructure.progAssign1.treeHeightProblem;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.coursera.dataStructure.progAssign1.CommonTestCaseFileReader;
import org.coursera.dataStructure.progAssign1.checkBracketProblem.CheckBracketMain;
import org.junit.Before;
import org.junit.Test;

public class TestTree {
	int testCaseCount;
	String testDir;
	CheckBracketMain ck;
	BufferedReader testCaseReader;
	BufferedReader testResultReader;
	String expectedResult;
	String output;
	
	@Before
	public void setup(){
		testDir = "E:\\Coursera_Working_Directory\\DataStructure\\assignment1\\Starters PA1\\tree_height\\tests\\";
		testCaseCount = 24;

	}

	@Test
	public void testTreeHeight() throws IOException, InterruptedException {
		CommonTestCaseFileReader testInputFileReader = new CommonTestCaseFileReader(testDir, testCaseCount);
		CommonTestCaseFileReader testResultFileReader = new CommonTestCaseFileReader(testDir, testCaseCount , ".a");
		int ct = 0;
		while(testInputFileReader.hasMoreFiles() && testResultFileReader.hasMoreFiles()){
			ct++;
			Thread t1 = new Thread(null, new Runnable() {
				
				@Override
				public void run() {
					try{
						System.out.println("-----Thread running :- " + Thread.currentThread().getName() + "-------");
					testCaseReader = testInputFileReader.getNextFileReader();
					testResultReader = testResultFileReader.getNextFileReader();
					//String text = testCaseReader.readLine();
					TreeHeightMain.readOneTestScenario(testCaseReader);
					testCaseReader.close();
					//tree.printTree();
//					System.out.println("~~~~~~ " + TreeHeightMain.tree.getTreeHeight());
					expectedResult = testResultReader.readLine();
					output = TreeHeightMain.tree.getTreeHeight()+"";
					}catch(Exception e){
						
					}
				}
			}, "T-"+ct, 1<<26);
			t1.start();
			t1.join();
			System.out.println(ct + ") Expected : " + expectedResult + " got : " + output);
			assertEquals(expectedResult, output);
			testCaseReader.close();
			testResultReader.close();
		}
		
	}

}