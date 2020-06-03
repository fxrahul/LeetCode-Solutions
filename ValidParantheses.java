//https://leetcode.com/problems/valid-parentheses/
class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        HashMap<Character,Character> h = new HashMap<>();
        h.put('{','}');
        h.put('(',')');
        h.put('[',']');
        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                st.push(s.charAt(i));
            }else if(st.isEmpty() == true || s.charAt(i) != h.get(st.pop())){
                return false;
            }
        }
        if(st.isEmpty()==true){
            return true;
        }else{
            return false;
        }
    }
}