package java.src;

/**
 * 33. 搜索旋转排序数组
 */
public class Solution33 {
    /**
     * 利用二分搜索
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 1) {
            return target == nums[0] ? 0 : -1;
        }
        int left = 0, right = len - 1;
        //二分继续进行的条件：left<=right
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //只查找有序的区间
            if (nums[0] <= nums[mid]) {
                //如果target在这个区间[0,mid)
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[len - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}