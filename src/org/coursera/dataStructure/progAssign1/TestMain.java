package org.coursera.dataStructure.progAssign1;

public class TestMain {

	public static void main(String[] args) {
		long val1 = (1<<25);
		long val2 = (1<<26);
		System.out.println((val1/1024)+"Kb");
		System.out.println((val1/(1024*1024)) + "Mb");
		System.out.println((val2/1024)+"Kb");
		System.out.println((val2/(1024*1024)) + "Mb");
		
		
		char blank = ' ';
		String test = "abc Abc !#!$! ";
		
		System.out.println(blank <= 'a');
		System.out.println(blank <= 'A');
	}

}
