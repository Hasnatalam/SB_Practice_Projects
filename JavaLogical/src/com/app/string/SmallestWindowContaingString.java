package com.app.string;

import java.util.*;

public class SmallestWindowContaingString {

    public static void main(String[] args) {

        String str = "abcxyz";
        String target = "cy";

        String ans = "";

        for (int i = 0; i < str.length(); i++) {

            HashSet<Character> set = new HashSet<>();

            for (int j = i; j < str.length(); j++) {

                char ch = str.charAt(j);

                if (target.contains(ch + "")) {
                    set.add(ch);
                }

                if (set.size() == target.length()) {

                    String window = str.substring(i, j + 1);

                    if (ans.equals("") ||
                            window.length() < ans.length()) {

                        ans = window;
                    }

                    break;
                }
            }
            if(ans.length()==target.length())break;
        }

        System.out.println(ans);
    }
}