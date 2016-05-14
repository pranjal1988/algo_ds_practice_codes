package org.coursera.dataStructure.progAssign1.treeHeightProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.coursera.dataStructure.progAssign1.CommonTestCaseFileReader;

public class TreeHeightMain {
	
	TreeNode rootNode;

	public static void main(String[] args) throws IOException {
		InputStreamReader input_stream = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input_stream);
		String text = reader.readLine();
		TreeHeightMain th = new TreeHeightMain();
		if(!text.equals("file")){
			while((text=reader.readLine()) != null){
				System.out.println();
			}
			reader.close();
			input_stream.close();
		}else{
			int testCaseSize = Integer.parseInt(reader.readLine());
			reader.close();
			String testDir = "E:\\Coursera_Working_Directory\\DataStructure\\assignment1\\Starters PA1\\tree_height\\tests\\";
			CommonTestCaseFileReader cr = new CommonTestCaseFileReader(testDir, testCaseSize);
			while(cr.hasMoreFiles()){
				reader = cr.getNextFileReader();
				int row = 1;
				int nodesCount = 0;
				String[] inputs = null;
				while((text = reader.readLine()) != null){
					if(row == 1){
						nodesCount = Integer.parseInt(text);
						inputs = new String[nodesCount];
					}else{
						Map map = th.buildTree(inputs, text);
					}
					row++;
				}
				reader.close();
			}
		}
	}
	
	public Map<Integer, TreeNode> buildTree(String[] inputs, String inputText){
		Map<Integer, TreeNode> nodeMap = new HashMap<Integer, TreeNode>();
		inputs = inputText.split(" ");
		for(int i = 0; i < inputs.length ; i++){
			TreeNode node;
			if((node = nodeMap.get(i)) == null) {
				node =  new TreeNode(i);
				nodeMap.put(i, node);
			}
			int parentNodeVertice = Integer.parseInt(inputs[i]);
			if(parentNodeVertice == -1){
				rootNode = node;
				continue;
			}
			TreeNode nodeFromMap = nodeMap.get(parentNodeVertice);
			if(nodeFromMap != null){
				node.parent = nodeFromMap;
			}else{
				node.parent = new TreeNode(parentNodeVertice);
				nodeMap.put(parentNodeVertice, node.parent);
			}
			node.parent.addChild(node);
		}
		return nodeMap;
	}
	
}
