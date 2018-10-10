package com.onlywell.day02.binaryTree;

import java.util.Arrays;

import lombok.Data;

/**
 * @author harry
 */
public class RebuildBinaryTree {
	public static void main(String[] args) throws Exception {
		int[] preSort = { 1, 2, 4, 7, 3, 5, 6, 8 };//先序
		int[] inSort = { 4, 7, 2, 1, 5, 3, 8, 6 };//中序
		BinaryTree root = constructCore(preSort, inSort);
	}

	public static BinaryTree constructCore(int[] preOrder, int[] inOrder) throws Exception {
		if ((preOrder == null) || (inOrder == null) || (preOrder.length != inOrder.length)) {
			throw new Exception("非法输入!");
		}

		BinaryTree root = new BinaryTree();
		for (int i = 0; i < inOrder.length; i++) {
			if (inOrder[i] == preOrder[0]) {
				root.value = inOrder[i];
				System.out.println("当前的值为:" +root.value);
				root.leftTree = constructCore(Arrays.copyOfRange(preOrder, 1, i + 1),
						Arrays.copyOfRange(inOrder, 0, i));
				root.rightTree = constructCore(Arrays.copyOfRange(preOrder, i + 1, preOrder.length),
						Arrays.copyOfRange(inOrder, i + 1, inOrder.length));
			}
		}
		return root;
	}

	@Data
	static class BinaryTree {
		private BinaryTree leftTree;
		private BinaryTree rightTree;
		private int value;
	}
}
