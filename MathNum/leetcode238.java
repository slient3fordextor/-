package MathNum;

public class leetcode238 {
    public int[] productExceptSelf(int[] nums) {
        int []ans = new int[nums.length];
        int []tmp = new int[nums.length];
        ans[1] = 1;
        int n  = nums.length;
        tmp[n-1] = 1;
        for (int i = 1; i < ans.length; i++) {
            ans[i] = ans[i-1] * nums[i - 1];
        }
        for (int i = tmp.length - 2; i >= 0 ; i --) {
            tmp[i] = tmp[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < ans.length; i++) {
            ans[i] = ans[i] * tmp [i];
        }
        return ans;

    }
}
