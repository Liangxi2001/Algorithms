/**
 * 868. 二进制间距
 *
 * @author 此间凉汐
 * @date 2022/4/24 8:49
 */
public class Solution868 {
    public int binaryGap(int n) {
        String binaryString = Integer.toBinaryString(n);
        int last = 0, cnt = 0;
        for (int i = 1; i < binaryString.length(); i++) {
            if ('1' == binaryString.charAt(i)) {
                cnt = Math.max(cnt, i - last);
                last = i;
            }
        }
        return cnt;
    }
}
