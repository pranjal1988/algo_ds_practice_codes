package org.coursera.dataStructure.progAssign1.treeHeightProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import org.coursera.dataStructure.CommonTestCaseFileReader;

public class TreeHeightMain {
	
	static String text;
	static Tree tree;
	
	public static void main(String[] args) throws IOException {
		 new Thread(null, new Runnable() {
             public void run() {
                 try {
                     new TreeHeightMain().run();
                 } catch (IOException e) {
                 }
             }
         }, "1", 1 << 26).start();
	}
	
	public void run() throws IOException{
		InputStreamReader input_stream = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input_stream);
		text = reader.readLine();
		if(!text.equals("file")){
			readOneTestScenario(reader);
			reader.close();
			input_stream.close();
			tree.printTree();
			System.out.println("~~~~~~ " + tree.getTreeHeight());
		}else{
			int testCaseSize = Integer.parseInt(reader.readLine());
			reader.close();
			String testDir = "E:\\Coursera_Working_Directory\\DataStructure\\assignment1\\Starters PA1\\tree_height\\tests\\";
			CommonTestCaseFileReader cr = new CommonTestCaseFileReader(testDir, testCaseSize);
			while(cr.hasMoreFiles()){
				System.out.println("------------------------------------");
				reader = cr.getNextFileReader();
				readOneTestScenario(reader);
				reader.close();
				tree.printTree();
				System.out.println("~~~~~~ " + tree.getTreeHeight());
			}
		}
	}
	
	public static void readOneTestScenario(BufferedReader reader) throws NumberFormatException, IOException{
		int row = 1;
		int nodesCount = 0;
		String[] inputs = null;
		text = reader.readLine();
		tree = new Tree();
		while(true){
			if(row == 1){
				nodesCount = Integer.parseInt(text);
				inputs = new String[nodesCount];
			}else{
				Map map = tree.buildTree(inputs, text);
			}
			row++;
			text = reader.readLine();
			if(text == null) break;
			if(text.trim().equals("")) break;
		}
	}
	
}
