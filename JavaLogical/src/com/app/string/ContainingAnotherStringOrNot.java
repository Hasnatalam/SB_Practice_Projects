package com.app.string;

public class ContainingAnotherStringOrNot {
	public static void main(String[] args) {
		String str = "abcxyz";
		String s = "bxy";
		boolean flag = true;
		for (int i = 0; i < s.length(); i++) {
			if (!str.contains(s.substring(i, i + 1))) {
				flag = false;
				return;
			}
		}
		if (flag)
			System.out.println("Contains");
	}
}