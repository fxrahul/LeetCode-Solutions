// https://leetcode.com/problems/longest-palindromic-substring/
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n == 0){
            return "";
        }

        boolean palindromeTable[][] = new boolean[n][n];
        int maxPalindromeLength = 1;
        // for length 1 palindrome
        for(int i = 0 ; i < n; i++){
            palindromeTable[i][i] = true;
        }

        //for length2 plaindrome
        int start = 0;
        for(int i = 0 ; i < n-1 ; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                palindromeTable[i][i+1] = true;
                start = i;
                maxPalindromeLength = 2;

            }
        }

        //for length3 palindrome
        for(int k = 3; k <=n ; k++){
            for(int i = 0 ; i < n-k+1; i++){ //for all possible length3 string to be palindrome or not
                int j = i + k - 1; // if you want to consider 4 length and i is 0 the j will be 4(i+k) - 1 as it is array and start from 0, so it will be o to 3 making 4 lements
                if(palindromeTable[i+1][j-1] && s.charAt(i) == s.charAt(j)){
                    palindromeTable[i][j] = true;
                    if(k>maxPalindromeLength){
                        start = i;
                        maxPalindromeLength = k;
                    }
                }

            }
        }

        return s.substring(start,(start+maxPalindromeLength-1)+1); //maxPalindromeLength,since array starts from 0, so 0 to 3 if maxLength  = 4 and ''+1', since in substring second index is till index-1. we have to go till last index..
    }
}