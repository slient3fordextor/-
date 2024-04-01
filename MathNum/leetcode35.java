package MathNum;

public class leetcode35 {
    public int searchInsert(int[] nums, int target) {
        int pos = -1;
        for (int i = 0; i < nums.length; i++) {

            if(nums[i] >= target) {
                pos = i;
                break;
            }
        }
        if(pos == -1) pos = nums.length;
        return pos;
    }
}
