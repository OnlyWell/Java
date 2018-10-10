/**
 * 
 */
package com.onlywell.day01.replaceblank;

/**
 * @author harry
 */
public class ReplaceBlank {

	public static String replaceBlank(String str) {
		if (null == str || str == "") {
			return null;
		}
		return str.replaceAll(" ", "%20");
	}
	
	public static void main(String[] args) {
		System.out.println(replaceBlank("Hello World,Hello everyOne."));
	}
}
