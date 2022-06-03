/**
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * @author 此间凉汐
 * @date 2022/4/16 14:09
 */
public class Solution02 {
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (0 == nums[i]) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (0 != nums[j]) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }
    }

    public int removeElement(int[] nums, int val) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (val != nums[right]) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }

    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 1;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                nums[slow + 1] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow + 1;
    }
}
