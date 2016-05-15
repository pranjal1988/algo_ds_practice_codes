package org.coursera.dataStructure.progAssign1.treeHeightProblem;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Tree {
	
	TreeNode rootNode;
	
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
				rootNode.setHeight(1);
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
			if(item.parent != null){
				item.setHeight(item.getParent().getHeight()+1);
			}
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
	
	public int getTreeHeight(){
		Queue<TreeNode> queue = new ConcurrentLinkedQueue<TreeNode>();
		queue.add(rootNode);
		return getLevelHeight(queue, 1);
	}
	
	private int getLevelHeight(Queue<TreeNode> queue, int levelCount){
		int nextLevelCount = 0;
		for(int i = 0; i < levelCount; i++){
			TreeNode item = queue.poll();
			if(item.parent != null){
				item.setHeight(item.getParent().getHeight()+1);
			}
			nextLevelCount += item.getChilds().size();
			if(item.getChilds().size() != 0){
				queue.addAll(item.getChilds());
			}
		}
		if(!queue.isEmpty()){
			return 1 + getLevelHeight(queue, nextLevelCount);
		}
		return 1;
	}

}
