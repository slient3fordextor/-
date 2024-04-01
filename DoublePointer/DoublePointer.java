package DoublePointer;

import java.util.*;

//双指针
public class DoublePointer {
    public static void main(String[] args) {
        int[] abs = new int[]{1,8,6,2,5,4,8,3,7};
        Solution2 solution1 = new Solution2();
        System.out.println(solution1.maxArea(abs));
    }
}
//将数组中所有的0移动到函数的末尾
class Solution1{
    public int[] moveZeroes(int[] nums) {
        int left = 0, right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) left++;
            else nums[right++] = nums[i];
        }
        for (int i = nums.length - left; i < nums.length; i++) {
            nums[i] = 0;
        }
        return nums;
    }
}
//盛水的容器问题
//（求最广面积问题）
class Solution2{
    public int maxArea(int[] height) {
//        解法一：最直接的暴力
//        int maxn = 0;
//        for (int i = 0; i < height.length ; i++) {
//            for (int j = i+1; j < height.length ; j++) {
//                maxn = Math.max(maxn ,(j-i)*Math.min(height[i],height[j]));
//            }
//        }
//        return maxn;

//        解法二：真正的双指针
        int l = 0 , r = height.length - 1;
        int ans = 0;
        while (l < r){
            int area = Math.min(height[l] , height[r]) * (r - l);
            ans = Math.max(area, ans);
            if (height[l] < height[r] ) l ++;
            else  r--;
        }
        return ans;
    }
}
//我是傻逼
//class Solution3{
//    public List<List<Integer>> threeSum(int[] nums) {
//
//        Arrays.sort(nums);
//        List<List<Integer>> list = new ArrayList<List<Integer>>();
//        for (int i = 0; i < nums.length - 2; i++) {
//            if ( i > 0 && nums[i] == nums[i - 1]) continue;
//            int j = i + 1, k = nums.length - 1;
//            while ( j < k ) {
//                if (nums[i] + nums[j] == nums[k]) {
//                    List<Integer> list1 = new ArrayList<Integer>();
//                    list1.add(nums[i]);
//                    list1.add(nums[j]);
//                    list1.add(nums[k]);
//                    list.add(list1);
//                }
//                else if (nums[i]+nums[j] > nums[k]) j++;
//                else k--;
//            }
//        }
//        return list;
//    }
//}
class Solution3 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n - 2; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n - 1; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums  [second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) break;
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}

class Solution4 {
//    public int trap(int[] height) {
//        int le = 0, re = 0;
//        int ans = 0;
//        for (int k = le; k < height.length; k++) {
//            if(height[k] > height[le]) {
//                int reins = Math.min(height[k],height[le]) * (le - k - 1);
//                int res = 0;
//                for (int i = le + 1; i < k ; i++) {
//                    res += height[i];
//                }
//                le = k;
//                ans += reins - res;
//            }
//        }
//        return ans;
//    }
public int trap(int[] height) {
    int sum = 0;
    //最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
    for (int i = 1; i < height.length - 1; i++) {
        int max_left = 0;
        //找出左边最高
        for (int j = i - 1; j >= 0; j--) {
            if (height[j] > max_left) {
                max_left = height[j];
            }
        }
        int max_right = 0;
        //找出右边最高
        for (int j = i + 1; j < height.length; j++) {
            if (height[j] > max_right) {
                max_right = height[j];
            }
        }
        //找出两端较小的
        int min = Math.min(max_left, max_right);
        //只有较小的一段大于当前列的高度才会有水，其他情况不会有水
        if (min > height[i]) {
            sum = sum + (min - height[i]);
        }
    }
    return sum;
}
}
class Leetcode189{
    public void rotate(int[] nums, int k) {
        int [] arr = new int [nums.length];
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            arr[(i+k) % n] = nums[i];
        }
        System.arraycopy(arr , 0 , nums , 0 , n);
    }
}
