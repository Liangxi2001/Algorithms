package java.src;

/**
 * 寻找旋转排序数组中的最小值
 */
public class Solution153 {
    public int findMin(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int min = Integer.MAX_VALUE;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < min) {
                min = nums[mid];
            }

        }

    }
}