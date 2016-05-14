package org.coursera.dataStructure.progAssign1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CommonTestCaseFileReader {

	BufferedReader reader;
	String basePath;
	int testFileCounts;
	int counter;
	String fileAppender = "";
	
	public CommonTestCaseFileReader(String testFilePath, int fileCounts){
		basePath = testFilePath;
		testFileCounts = fileCounts;
		counter = 0;
	}
	
	public CommonTestCaseFileReader(String testFilePath, int fileCounts, String appender){
		basePath = testFilePath;
		testFileCounts = fileCounts;
		counter = 0;
		this.fileAppender = appender;
	}
	
	
	public boolean hasMoreFiles(){
		return (counter < testFileCounts);
	}
	
	public BufferedReader getNextFileReader() throws FileNotFoundException{
		counter++;
		return new BufferedReader(new FileReader(basePath+"" + String.format("%02d", counter) + fileAppender));
	}
	
}
