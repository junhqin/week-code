package com.junhqin.leetcode;
//动态规划
public class problem5 {
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;
        int[][] dp = new int[len][len];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        int maxlen = 1, begin = 0;
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) dp[i][j] = 0;
                else {
                    if (j - i + 1 <= 3) dp[i][j] = 1;
                    else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] == 1 && (j - i + 1 > maxlen)) {
                    maxlen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxlen);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }
}
