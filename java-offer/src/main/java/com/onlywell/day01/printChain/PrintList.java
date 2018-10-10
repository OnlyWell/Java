package com.onlywell.day01.printChain;

import java.util.Stack;

/**
 * 倒着打印列表,可以利用栈先进后出
 * @author harry
 */
public class PrintList {
	public static void main(String[] args) {
		Node node = new Node();
		Node node1 = new Node();
		Node node2 = new Node();
		Node node3 = new Node();
		node.setData("0");
		node1.setData("1");
		node2.setData("2");
		node3.setData("3");
		node.setNextNode(node1);
		node1.setNextNode(node2);
		node2.setNextNode(node3);
		
		printNode(node);
	}

	public static void printNode(Node node) {
		Stack<String> stack = new Stack<>();
		while(node.getNextNode() != null) {
			stack.push(node.getData());
			node = node.getNextNode();
		}
		//因为上面会漏掉最后一个节点的值,这儿加上
		stack.push(node.getData());
		//做出栈操作
		if(stack.size() < 1) {
			return;
		}
		
		for(int i = 0; i < stack.size(); i++) {
			System.out.println(stack.get(i));
		}
	}
}
