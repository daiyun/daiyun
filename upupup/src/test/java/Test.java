import java.util.*;

public class Test {

  public static void main(String[] args) {

//    System.out.println(myAtoi("    -91"));


//    searchInsert(new int[]{1,3,5,6},4);

    ListNode one1 = new ListNode(1);
    ListNode one2 = new ListNode(2);
    ListNode one3 = new ListNode(3);
    ListNode one4 = new ListNode(4);
    ListNode one5 = new ListNode(5);
    one1.next = one2;
    one2.next = one3;
    one3.next = one4;
    one4.next = one5;


    String str = "asfasd fasdf fasdf  fasdffa 辅导费";

    String[] sts = str.split("\\s");
    System.out.println();


//    System.out.println(multiply("123","456"));


//    int a = divide(Integer.MIN_VALUE, 1);
//    System.out.println(a);


//    findSubstring("barfoofoobarthefoobarman",
//        new String[]{"bar", "foo", "the"});


    longestValidParentheses(")(((((()())()()))()(()))(");

//    )(((((()())()()))()(()))(

//    combinationSum2(new int[]{1,1,1,1,2,2,2,2}, 4);

//    permute(new int[]{1,1,2,2});


    //reverseKGroup(one1, 2);

//    System.out.println(myPow(2, 10));

//    groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});

    int[][] arr = new int[3][3];
    arr[0] = new int[]{1, 2, 3};
    arr[1] = new int[]{4, 5, 6};
    arr[2] = new int[]{7, 8, 9};
//    rotate(arr);

  }

  public static int myAtoi(String str) {
    int length = str.length();
    if (length == 0) {
      return 0;
    }

    boolean start = false;
    int res = 0;
    int flag = 1;
    for (int i = 0; i < length; i++) {
      Character p = str.charAt(i);
      System.out.println(p + 1);
      if (p == '+' || p == '-') {
        if (start) {
          break;
        } else {
          start = true;
          if (p == '-') {
            flag = -1;
          }
        }
      } else if (p >= '0' && p <= '9') {
        start = true;
        int k = (p - '0') * flag;
        if (k > 0 && res > Integer.MAX_VALUE / 2 || (res == Integer.MAX_VALUE / 10 && k > 7)) {
          return Integer.MAX_VALUE;
        }

        if (k < 0 && res < Integer.MIN_VALUE / 2 || (res == Integer.MIN_VALUE / 10 && k < -8)) {
          return Integer.MIN_VALUE;
        }

        res = res * 10 + k;

      } else {
        if (start) {
          break;
        }
      }
    }
    return res;
  }

  public static int searchInsert(int[] nums, int target) {

    int start = 0;
    int end = nums.length - 1;
    while (start < end) {
      if (target == nums[(start + end) / 2]) {
        return (start + end) / 2;
      } else if (target > nums[(start + end) / 2]) {
        start = (start + end) / 2;
      } else if (target < nums[(start + end) / 2]) {
        end = (start + end) / 2;
      }
    }
    return end + 1;

  }

  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode mergeKLists(ListNode[] lists) {
    ListNode res = new ListNode(0);
    ListNode returnList = res;
    int kLength = lists.length;

    boolean start = true;
    while (start) {
      start = false;
      Integer p = null;
      for (int i = 0; i < kLength; i++) {
        if (lists[i] != null) {
          if (p == null || lists[p].val > lists[i].val) {
            p = i;
          }
        }
      }
      if (p != null) {
        start = true;
        res.next = lists[p];
        res = res.next;
        lists[p] = lists[p].next;
      }
    }
    return returnList.next;
  }

  public static ListNode reverseKGroup(ListNode head, int k) {
    ListNode res = new ListNode(0);
    ListNode p = res;

    LinkedList<ListNode> stack = new LinkedList<>();

    while (head != null) {
      stack.push(head);
      head = head.next;
      if (stack.size() == k) {
        while (stack.size() > 0) {
          p.next = stack.pop();
          p = p.next;
        }
      }
    }

    while (stack.size() > 0) {
      if (stack.size() == 1) {
        p.next = stack.poll();
      } else {
        stack.pop();
      }
    }

    return res.next;
  }

  public static double myPow(double x, int n) {


    return doMypow(x, (long) n);
  }

  public static double doMypow(double x, long n) {

    if (x == 0) {
      return 1;
    }
    if (x == 1) {
      return x;
    }
    if (n < 0) {
      return 1 / doMypow(x, -n);
    }

    double res = 1.0d;

    while (n > 0) {
      if (n % 2 != 0) {
        res = res * x;
      }
      n = n >> 1;
      x = x * x;
    }

    return res;
  }

  public static List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> res = new ArrayList<>();
    int length = strs.length;

    for (int i = 0; i < length; i++) {
      int j = 0;
      for (; j < res.size(); j++) {
        if (isSampleChar(strs[i], res.get(j).get(0))) {
          break;
        }
      }
      if (j < res.size()) {
        res.get(j).add(strs[i]);
      } else {
        res.add(new ArrayList(Arrays.asList(strs[i])));
      }
    }


    return res;
  }

  public static boolean isSampleChar(String aa, String bb) {
    if (aa.length() != bb.length()) {
      return false;
    }
    int[] a = new int[26];
    for (int i = 0; i < aa.length(); i++) {

      a[aa.charAt(i) - 'a'] = a[aa.charAt(i) - 'a'] + 1;

    }

    int[] b = new int[26];
    for (int i = 0; i < bb.length(); i++) {
      b[bb.charAt(i) - 'a'] = b[bb.charAt(i) - 'a'] + 1;
    }

    for (int i = 0; i < 26; i++) {
      if (a[i] != b[i]) {
        return false;
      }
    }

    return true;
  }

  public static void rotate(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n / 2; i++) {
      for (int k = i; k < n - i - 1; k++) {
        int temp = matrix[i][k];

        matrix[i][k] = matrix[n - 1 - k][i];

        matrix[n - 1 - k][i] = matrix[n - 1 - i][n - 1 - k];

        matrix[n - 1 - i][n - 1 - k] = matrix[k][n - 1 - i];

        matrix[k][n - 1 - i] = temp;
      }
    }
  }

  public static List<List<Integer>> permute(int[] nums) {
    int length = nums.length;
    List<List<Integer>> res = new ArrayList<>();
    for (int one : nums) {
      Set<List<Integer>> nextRes = new HashSet<>();
      if (res.size() > 0) {
        for (int i = 0; i < res.size(); i++) {
          List<Integer> oneList = res.get(i);
          for (int j = 0; j <= oneList.size(); j++) {
            List<Integer> ss = new ArrayList<>(oneList);
            ss.add(j, one);
            nextRes.add(ss);
          }
        }
      } else {
        nextRes.add(new ArrayList(Arrays.asList(one)));
      }
      res.clear();
      res.addAll(new ArrayList<>(nextRes));
    }
    return res;
  }

  public int jump(int[] nums) {
    int length = nums.length;
    int step = 0;
    for (int i = 0; i < length - 1; ) {

      int maxWays = nums[i];
      {
        int nextIndex = i;
        for (int j = i + maxWays; j > i; j--) {
          if ((nums[j] + j) > (nums[nextIndex] + nextIndex)) {
            nextIndex = j;
          }
        }
        i = nextIndex;
        step++;
      }
    }
    return step;
  }

  public static String multiply(String num1, String num2) {
    int num1Length = num1.length();
    int num2Length = num2.length();
    int[][] sumRes = new int[num2Length][num1Length + num2Length];

    for (int i = num2Length - 1; i >= 0; i--) {
      int pre = 0;
      int b = num2.charAt(i) - '0';
      int j = num1Length - 1;
      for (; j >= 0; j--) {
        int a = num1.charAt(j) - '0';
        int temp = a * b + pre;
        pre = temp / 10;

        sumRes[num2Length - 1 - i][(num2Length - 1 - i) + (num1Length - 1 - j)] = temp % 10;
      }
      if (pre != 0) {

        sumRes[num2Length - 1 - i][(num2Length - 1 - i) + (num1Length - 1 - j)] = pre;
      }
    }

    int pre = 0;
    String res = "";
    for (int i = 0; i < num1Length + num2Length; i++) {
      int sumOne = pre;
      for (int j = 0; j < num2Length; j++) {
        sumOne = sumOne + sumRes[j][i];
      }
      if (i == num1Length + num2Length - 1 && sumOne == 0) {
        continue;
      }
      pre = sumOne / 10;
      res = sumOne % 10 + res;
    }
    if (pre != 0) {
      res = pre + res;
    }

    return res;

  }

  public int firstMissingPositive(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
        int temp = nums[nums[i] - 1];
        nums[nums[i] - 1] = nums[i];
        nums[i] = temp;
      }
    }

    for (int i = 0; i < n; i++) {
      if (nums[i] != i + 1) {
        return i + 1;
      }
    }
    return n + 1;
  }

  public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    return doSum2(candidates, 0, candidates.length - 1, target);
  }

  public static List<List<Integer>> doSum2(int[] candidates, int start, int end, int target) {
    List<List<Integer>> res = new ArrayList<>();
    for (int i = end; i >= start; i--) {
      if (i < end && candidates[i] == candidates[i + 1]) {
        System.out.println("===");
        continue;
      }
      if (candidates[i] > target) {
        continue;
      } else if (candidates[i] == target) {
        res.add(new ArrayList(Arrays.asList(candidates[i])));
      } else {

        List<List<Integer>> nextList = doSum2(candidates, start, i - 1, target - candidates[i]);
        for (List<Integer> one : nextList) {
          one.add(candidates[i]);
          res.add(one);
        }
      }
    }
    return res;
  }

  public static int divide(int dividend, int divisor) {
    if (dividend == Integer.MIN_VALUE) {
      if (divisor == -1) {
        return Integer.MAX_VALUE;
      } else if (divisor == 1) {
        return Integer.MIN_VALUE;
      }
    }


    int flag = 1;
    if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
      flag = -1;
    }

    long a = Math.abs((long) dividend);
    long b = Math.abs((long) divisor);

    int k = 1;
    while (true) {
      if (a >= (b << 1)) {
        b = b << 1;
        k = k << 1;
      } else {
        break;
      }
    }

    int res = 0;
    while (true) {
      if (a >= b) {
        res = res + k;
        a = a - b;
      } else {
        b = b >> 1;
        k = k >> 1;
        if (k < 1) {
          break;
        }
      }
    }
    if (flag == -1) {
      return -res;
    }
    return res;

  }

  public static List<Integer> findSubstring(String s, String[] words) {
    List<Integer> res = new ArrayList<>();
    if (words == null) {
      return res;
    }
    if (words.length == 0) {
      if ("".equals(s)) {
        res.add(0);
        return res;
      }
    }

    int length = words[0].length();

    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      if (map.containsKey(words[i])) {
        map.put(words[i], map.get(words[i]) + 1);
      } else {
        map.put(words[i], 1);
      }
    }

    for (int i = 0; i <= s.length() - length * words.length; i++) {

      Map<String, Integer> flag = new HashMap(map);
      for (int j = i; j < i + length * words.length; j = j + length) {
        String str = s.substring(j, j + length);
        if (flag.containsKey(str)) {
          int f = flag.get(str);
          if (f > 1) {
            flag.put(str, f - 1);
          } else {
            flag.remove(str);
          }
        } else {
          break;
        }
      }
      if (flag.size() == 0) {
        res.add(i);
      }
    }
    return res;
  }

  public static int longestValidParentheses(String s) {
    LinkedList<String> stack = new LinkedList<>();

    int[] count = new int[s.length()];
    for (int i = 0; i < s.length(); i++) {
      Character ch = s.charAt(i);
      if (ch == '(') {
        stack.push(ch + "-" + i);
      } else if (ch == ')') {
        if (stack.size() > 0) {
          String peek = stack.peek();
          if (peek.charAt(0) == '(') {
            String pop = stack.pop();
            count[i] = 1;
            count[Integer.parseInt(peek.substring(2))] = 1;
          }
        }
      }
    }

    int res = 0;
    int pre = 0;
    for (int i = 0; i < s.length(); i++) {
      if (count[i] == 1) {
        pre = pre + 1;
      } else {
        if (pre > res) {
          res = pre;
        }
      }
    }
    if (pre > res) {
      res = pre;
    }
    return res;
  }
}
