package com.app.string;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {

        String[] arr = {
                "eat", "tea", "tan",
                "ate", "nat", "bat"
        };

        HashMap<String, List<String>> map =
                new HashMap<>();

        for (String str : arr) {

            char[] ch = str.toCharArray();

            Arrays.sort(ch);

            String key = String.valueOf(ch);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(str);
        }

        System.out.println(
                new ArrayList<>(map.values()));
    }
}