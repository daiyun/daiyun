package daiyun.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Question3 {

  /**
   * 给定一个字符串，找出不含有重复字符的最长子串的长度。
   * <p>
   * 示例 1:
   * <p>
   * 输入: "abcabcbb"
   * 输出: 3
   * 解释: 无重复字符的最长子串是 "abc"，其长度为 3。
   * 示例 2:
   * <p>
   * 输入: "bbbbb"
   * 输出: 1
   * 解释: 无重复字符的最长子串是 "b"，其长度为 1。
   * 示例 3:
   * <p>
   * 输入: "pwwkew"
   * 输出: 3
   * 解释: 无重复字符的最长子串是 "wke"，其长度为 3。
   * 请注意，答案必须是一个子串，"pwke" 是一个子序列 而不是子串。
   */

  public class Solution {
    public int lengthOfLongestSubstring(String s) {
      int maxLength = 0;

      for(int i = 0;i<s.length();i++){
        for(int j = i;j<s.length();j++){
          if(isUnion(s,i,j)){
            if(maxLength<(j-i+1)){
              maxLength = j-i+1;
            }
          }
        }
      }

      return maxLength;

    }

    public boolean isUnion(String s,int start,int end){
      Set<Character> set = new HashSet<>();
      for(int i = start;i<=end;i++){
        if(set.contains(s.charAt(i))){
          return false;
        }
        set.add(s.charAt(i));
      }
      return true;
    }
  }

  public class SolutionB {
    public int lengthOfLongestSubstring(String s) {

      int length = s.length();

      int st = 0;
      int e = 0;
      int ans = 0;

      Set<Character> set = new HashSet<>();
      while(st < length && e < length){
        if(set.contains(s.charAt(e))){
          set.remove(s.charAt(st++));
        }else{
          set.add(s.charAt(e++));
          ans = Math.max(ans, e - st);
        }
      }
      return ans;
    }
  }

  class SolutionC {
    public int lengthOfLongestSubstring(String s) {
      int length = s.length();
      HashMap<Character,Integer> map = new HashMap<>();
      int ans = 0;
      int j = 0;
      for(int i = 0;i < length; i++){
        if(map.containsKey(s.charAt(i))){
          j = Math.max(map.get(s.charAt(i)),i);
        }
        ans = Math.max(ans,i-j+1);
        map.put(s.charAt(i),i);
      }
      return ans;
    }
  }

}


