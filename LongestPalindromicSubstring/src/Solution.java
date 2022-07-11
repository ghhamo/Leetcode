public class Solution {

    public String longestPalindrome2(String fullStr) {
        int len = fullStr.length();
        for (int i = len; i > 0; i--) {
            String palindrome = findPalindromeOfLength(fullStr, i);
            if (palindrome != null) {
                return palindrome;
            }
        }
        return fullStr.substring(0, 1);
    }

    public String findPalindromeOfLength(String str, int searchLength) {
        int strLen = str.length();
        for (int l = 0, r = searchLength; r < strLen; l++, r++) {
            if (isPalindrome(str, l, r)) {
                return str.substring(l, r + 1);
            }
        }
        return null;
    }

    public boolean isPalindrome(String str, int l, int r) {
        for (; l < r; l++, r--) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
        }
        return true;
    }
}
