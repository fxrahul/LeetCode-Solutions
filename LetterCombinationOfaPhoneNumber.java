
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
class Solution {
    List<String> list = new LinkedList();
    HashMap<String, String> hm = new HashMap<String, String>(){{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    public void backtracking(String combinations,String nextDigits){
        if(nextDigits.length() == 0){
            list.add(combinations);
        }else{
            String digit = nextDigits.substring(0,1);// inorder to get first digit of all digits
            String letters = hm.get(digit);
            for(int i = 0 ; i < letters.length() ; i++){
                String letter = letters.substring(i,i+1); // get letters of digit one by one
                backtracking(combinations+letter, nextDigits.substring(1));
                //1 for iterating to remaining digits
            }
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length() !=0){
            backtracking("",digits);
        }
        return list;
    }
}