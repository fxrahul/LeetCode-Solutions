
// https://leetcode.com/problems/longest-substring-without-repeating-characters/
class Solution {
    public int sizeArray(int[] a){
        int count = 0;
        for(int k = 0; k < a.length; k++){
            if(a[k] == 1){
                count++;
            }
        }
        return count;
    }
    public int lengthOfLongestSubstring(String s) {
        // HashSet<Character> h = new HashSet<>();
        // int max = 0;
        // for(int i = 0; i < s.length(); i++){
        //     for(int j = i;j < s.length();j++){
        //         if(!h.contains(s.charAt(j))){
        //             h.add(s.charAt(j));
        //         }else{
        //             if(h.size() > max){
        //                 max = h.size();
        //             }
        //             h = new HashSet<>();
        //             break;
        //         }
        //     }
        // }
        // if(h.size() > max){
        //     max = h.size();
        // }
        // return max;

        // int[] c = new int[256];
        // int max = 0;
        // for(int i = 0; i < s.length(); i++){
        //     for(int j = i;j < s.length();j++){
        //         if(c[s.charAt(j)] != 1){
        //             c[s.charAt(j)]++;
        //         }else{
        //             int size = sizeArray(c);
        //             if(size > max){
        //                 max = size;
        //             }
        //             c = new int[256];
        //             break;
        //         }
        //     }
        // }
        // int size = sizeArray(c);
        // if(size > max){
        //     max = size;
        // }
        // return max;
        int i = 0;
        int j = 0;
        int max = 0;
        HashSet<Character> h = new HashSet<>();
        while(j < s.length()){

            if(!h.contains(s.charAt(j))){
                h.add(s.charAt(j));
                max = Math.max(max, h.size());
                j++;
            }else{
                h.remove(s.charAt(i));
                i++;
            }

        }

        return max;
    }
}