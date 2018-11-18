import java.util.*;

public class Test {

  public static void main(String[] args) {


//    combinationSum(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);


    System.out.println(myPow(2.0,-2147483648));

    System.out.println(2 & 1);
  }

  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
//    List<List<Integer>> res = doSum(candidates, 0, candidates.length - 1, target);
    List<List<Integer>> res = doSum2(candidates, candidates.length - 1, target);
    return res;
  }

  public static List<List<Integer>> doSum(int[] nums, int start, int end, int target) {


    if (end == 0) {
      List<List<Integer>> res = new ArrayList<>();
      if (target % nums[start] == 0) {
        int p = target / nums[start];

        List<Integer> one = new ArrayList<>();
        for (int i = 0; i < p; i++) {
          one.add(nums[start]);
        }
        res.add(one);
      }
      return res;
    }

    List<List<Integer>> res = new ArrayList<>();

    int temp = nums[end];
    int k = 0;

    while (temp * k <= target) {
      if (temp * k < target) {
        List<List<Integer>> pRes = doSum(nums, start, end - 1, target - temp * k);
        for (List<Integer> list2 : pRes) {
          for (int i = 0; i < k; i++) {
            list2.add(temp);
          }
          res.add(list2);
        }
      } else if (temp * k == target) {
        List<Integer> one = new ArrayList<>();
        for (int i = 0; i < k; i++) {
          one.add(temp);
        }
        res.add(one);
        break;
      }

      k++;
    }
    return res;
  }

  public static List<List<Integer>> doSum2(int[] nums, int p, int target) {
    if ((p + 1) < nums.length && nums[p] == nums[p + 1]) {
      return new ArrayList<>();
    }
    if (p == 0) {
      List<List<Integer>> res = new ArrayList<>();
      if (nums[0] == target) {
        res.add(new ArrayList<>(Arrays.asList(nums[0])));
      }
      return res;
    }
    List<List<Integer>> res = new ArrayList<>();

    if (target == nums[p]) {
      res.add(new ArrayList<>(Arrays.asList(nums[p])));
      return res;
    } else {
      List<List<Integer>> preR = doSum2(nums, p - 1, target - nums[p]);

      for (List<Integer> one : preR) {
        one.add(nums[p]);
        res.add(one);
      }

      List<List<Integer>> preR2 = doSum2(nums, p - 1, target);
      res.addAll(preR2);
    }

    return res;
  }

  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> res = new ArrayList<>();
    Map<Map<Character, Integer>, Integer> map = new HashMap<>();
    for (int i = 0; i < strs.length; i++) {
      String temp = strs[i];
      Map<Character, Integer> sets = new HashMap<>();
      for (int j = 0; j < temp.length(); j++) {
        if (sets.containsKey(temp.charAt(j))) {
          int p = sets.get(temp.charAt(j));
          sets.put(temp.charAt(j), p + 1);
        } else {
          sets.put(temp.charAt(j), 1);
        }
      }

      if (map.containsKey(sets)) {
        int index = map.get(sets);
        List<String> pp = res.get(index);
        pp.add(temp);

        res.remove(index);
        res.add(index, pp);

      } else {
        int size = map.size();
        map.put(sets, size);
        List<String> pp = new ArrayList<>();
        pp.add(temp);
        res.add(size, pp);
      }
    }
    return res;
  }


  public static String multiply(String num1, String num2) {
    String res = "";
    int len1 = num1.length();
    int len2 = num2.length();
    if (len1 < 1 || len2 < 1) {
      return "0";
    }

    if ("0".equals(num1) || "0".equals(num2)) {
      return "0";
    }

    int[] resNum = new int[len2 + len1];

    for (int i = 0; i < len1; i++) {
      for (int j = 0; j < len2; j++) {
        resNum[len2 + len1 - i - j - 1] += (num1.charAt(len1 - i - 1) - '0') * (num2.charAt(len2 - j - 1) - '0');
      }
    }

    int countAdd = 0;
    for (int i = len1 + len2 - 1; i >= 0; i--) {
      int count = countAdd + resNum[i];
      res = (count % 10) + res;
      countAdd = count / 10;
    }

    if (countAdd > 0) {
      res = countAdd + res;
    } else {
      while (res.startsWith("0")) {
        res = res.substring(1);
      }
    }

    return res;
  }


  public static double myPow(double x, int n) {
    double res = 1.0d;
    if(n == 0){
      return res;
    }
    if(n == 1){
      return x;
    }
    if(n == 2){
      return x * x;
    }
    if(n < 0){
      res = 1.0d / quickPow(x, (long) -n);
    }else{
      res = quickPow(x, (long) n);
    }

    return res;
  }

  public static double quickPow(double x, long n){
    if(n < 0)
      return 1.0/quickPow(x, -n);
    double res = 1.0d;
    while(n>0){
      if(n % 2 != 0){
        res = res * x;
      }
      n = n >> 1;
      x = x * x;
    }
    return res;
  }
}
