package com.app.string;

public class LongestPelindromicSubstring{
    public static void main(String [] args){
        String str = "acbacbcadbxaaaabaaaa";
        String longestPelindrome = "";
        for(int i = 0;i<str.length();i++){
            
            String subString1 = expand(str,i,i); 
            if(subString1.length()>longestPelindrome.length()){
                longestPelindrome = subString1;
            }
            
            String subString2 = expand(str,i,i+1); 
            if(subString2.length()>longestPelindrome.length()){
                longestPelindrome = subString2;
            }
        }
        System.out.println(longestPelindrome);
    }
    
        public static String expand(String str,int left,int right){
            while(left>=0 && right<str.length()&& str.charAt(left)==str.charAt(right)){
                left--;right++;
            }
            return str.substring(left+1,right);
        }
}