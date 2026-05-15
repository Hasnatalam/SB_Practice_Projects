package com.app.string;

public class AllPermutation {

    public static void main(String[] args) {

        String str = "ABC";

        permutation(str, "");
    }

    public static void permutation(String str, String ans) {

        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            String left = str.substring(0, i);

            String right = str.substring(i + 1);

            String remaining = left + right;

            permutation(remaining, ans + ch);
        }
    }
}