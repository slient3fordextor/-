package String;
import java.util.*;

public class StringAble {
    public static void main(String[] args) {
//        String a=" ";
//        int length = a.length();

    }
}

class Solution1 {
    public int lengthOfLongestSubstring(String s) {

        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}

/**
 * leetcode.438.找到字符串中所有字母异位词
 */
class Solution2 {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

}

/**
 *  leetcode 560.和为k的子数组
 */

class Solution3 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;

        for (int i = 0 ;i < nums.length ; i ++){
            int sum = 0;
            for (int end = i ; end >= 0; --end){
                sum += nums[end];
                if(sum ==  k) count++;
//                else if(sum > k) break; 考虑到存在负数的问题
            }
        }
        return count;
    }
}