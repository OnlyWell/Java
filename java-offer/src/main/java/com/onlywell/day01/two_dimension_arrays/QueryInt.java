/**
 * 
 */
package com.onlywell.day01.two_dimension_arrays;

/**
 * @author harry
 */
public class QueryInt {

	public static void main(String[] args) throws Exception {
		int num = 12;
		int[][] array1 = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] array2 = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
		queryNumer(array2, num);
	}

	/*
	 * 查询二维数组中是否存在数字Num
	 */
	public static boolean queryNumer(int[][] array, int num) throws Exception {
		if ((array == null) || (array.length < 1)) {
			throw new Exception("数组不合法");
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] == num) {
					System.out.println("array中存在数字:" + num + ",对应array中的位置array[" + i + "][" + j + "]");
					return true;
				}
			}
		}
		System.out.println("不存在当前数字");
		return false;
	}
}
