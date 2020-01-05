package leetcode3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * User: 宁
 * Date: 2020-01-05
 * Time: 22:17
 */
public class leetcode3 {
    public static void main(String[] args) {
        System.out.println(Solution.lengthOfLongestSubstring("pwwkew"));
    }
}

class Solution {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hashMap= new HashMap<>();
        char[] array = s.toCharArray();
        int max = 0;
        for (int i = 0;i<array.length;i++){
            if (!hashMap.containsKey(array[i])){
                hashMap.put(array[i],i);
            }else{
                i = hashMap.get(array[i]);
                max = Math.max(hashMap.size(),max);
                hashMap.clear();
            }
        }
        return Math.max(hashMap.size(), max);
    }
}


//class Solution {
//    public static int lengthOfLongestSubstring(String s) {
//        int n = s.length(), ans = 0;
//        int[] index = new int[128]; // current index of character
//        // try to extend the range [i, j]
//        for (int j = 0, i = 0; j < n; j++) {
//            i = Math.max(index[s.charAt(j)], i);
//            ans = Math.max(ans, j - i + 1);
//            index[s.charAt(j)] = j + 1;
//        }
//        return ans;
//    }
//}
