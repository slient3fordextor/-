package Hash;

import java.util.*;


//哈希表
public class Hash {
}
//两数之和
class Solution1{
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]) , i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}
//判断字符串相等的哈希表
class Solution2{
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> hashtable = new java.util.HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String>value = hashtable.getOrDefault(key, new ArrayList<String>());
            value.add(str);
            hashtable.put(key , value);
            //if(!hashtable.containsKey(key)) hashtable.put(key,)
            //String Array sort = str.Array sort
        }
        return new ArrayList<List<String>>(hashtable.values());
    }
}


//最长连续子序列
class Sollution3{
//    public int longestConsecutive(int[] nums) {
//        解法一:链表+哈希
//        Arrays.sort(nums);
//        Set<Integer> ms = new LinkedHashSet<Integer>();
//        for (int num : nums)
//            ms.add(num);
//        int res = 1;
//        int pre = Integer.MIN_VALUE;
//        int tmp = 1;
//        for (int num : ms) {
//            if (num-pre==1) tmp++;
//            else tmp = 1;
//            pre = num;
//            res = Math.max(res,tmp);
//        }
//        return res;
//    }
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
