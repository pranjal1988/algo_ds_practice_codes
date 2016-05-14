package org.coursera.dataStructure.progAssign1.treeHeightProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.coursera.dataStructure.progAssign1.CommonTestCaseFileReader;

public class TreeHeightMain {
	
	TreeNode rootNode;
	static String text;
	
	public static void main(String[] args) throws IOException {
		InputStreamReader input_stream = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input_stream);
		text = reader.readLine();
		TreeHeightMain th = new TreeHeightMain();
		if(!text.equals("file")){
			th.readOneTestScenario(reader);
			reader.close();
			input_stream.close();
		}else{
			int testCaseSize = Integer.parseInt(reader.readLine());
			reader.close();
			String testDir = "E:\\Coursera_Working_Directory\\DataStructure\\assignment1\\Starters PA1\\tree_height\\tests\\";
			CommonTestCaseFileReader cr = new CommonTestCaseFileReader(testDir, testCaseSize);
			while(cr.hasMoreFiles()){
				reader = cr.getNextFileReader();
				th.readOneTestScenario(reader);
				reader.close();
			}
		}
		
		th.printTree();
	}
	
	public void readOneTestScenario(BufferedReader reader) throws NumberFormatException, IOException{
		int row = 1;
		int nodesCount = 0;
		String[] inputs = null;
		text = reader.readLine();
		while(true){
			if(row == 1){
				nodesCount = Integer.parseInt(text);
				inputs = new String[nodesCount];
			}else{
				Map map = buildTree(inputs, text);
			}
			row++;
			text = reader.readLine();
			if(text == null) break;
			if(text.trim().equals("")) break;
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
	
	public void printTree(){
		Queue<TreeNode> queue = new ConcurrentLinkedQueue<TreeNode>();
		queue.add(rootNode);
		printLevel(queue, 1);
	}
	
	private void printLevel(Queue<TreeNode> queue, int levelCount){
		int nextLevelCount = 0;
		for(int i = 0; i < levelCount; i++){
			TreeNode item = queue.poll();
			System.out.print(item + "\t");
			nextLevelCount += item.getChilds().size();
			if(item.getChilds().size() != 0){
				queue.addAll(item.getChilds());
			}
		}
		System.out.println("\n");
		if(!queue.isEmpty()){
			printLevel(queue, nextLevelCount);
		}			
	}
	
	
}
