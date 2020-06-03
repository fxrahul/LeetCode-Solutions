// https://leetcode.com/problems/regular-expression-matching/

public class RegularExpressionMatchingclass Solution {
    public boolean isMatch(String s, String p) {

        boolean [][] match = new boolean[s.length()+1][p.length()+1];
        match[0][0] = true;
        char[] string = s.toCharArray();
        char[] pattern = p.toCharArray();

        for(int k = 1;k < match[0].length; k++){ // for 1st row with string as empty and pattern something
            if(pattern[k - 1] == '*'){
                match[0][k] = match[0][k-2]; //as we can take o occurence of preceeding character and check characters before preceeding character are matching or not
            }
        }

        for(int i = 1; i < match.length; i++){
            for(int j = 1; j < match[0].length; j++){
                if(pattern[j-1]== '.' || pattern[j -1]==string[i-1]){
                    match[i][j] = match[i-1][j-1];
                }
                else if(pattern[j-1] == '*'){
                    match[i][j] = match[i][j - 2];
                    if (pattern[j-2] == '.' || pattern[j - 2] == string[i - 1]) {
                        match[i][j] = match[i][j] | match[i - 1][j];
                    }
                }else{
                    match[i][j] = false;
                }
            }
        }
        return match[string.length][pattern.length];
    }
} {
}
