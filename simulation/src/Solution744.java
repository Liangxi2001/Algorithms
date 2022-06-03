/**
 * 744. 寻找比目标字母大的最小字母
 *
 * @author 此间凉汐
 * @date 2022/4/3 8:20
 */
public class Solution744 {
    //暴力
    public char nextGreatestLetter(char[] letters, char target) {
        char cnt = letters[0];
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] > target) {
                cnt = letters[i];
                break;
            }
        }
        return cnt;
    }
}
