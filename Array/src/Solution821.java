/**
 * 821. 字符的最短距离
 *
 * @author 此间凉汐
 * @date 2022/4/19 18:59
 */
public class Solution821 {
    public int[] shortestToChar(String s, char c) {
        int len = s.length();
        if (len == 1) {
            return new int[]{0};
        }
        int[] result = new int[len];
        int index = 0, temp = -1;
        while (index < len) {
            if (s.charAt(index) == 'c') {
                if (temp == -1) {
                    for (int i = 0; i <= index; i++) {
                        result[i] = Math.abs(i - index);
                    }
                    temp = index;
                }
                if (temp != -1) {
                    for (int i = temp + 1; i <= index; i++) {
                        result[i] = Math.abs(i - index) < Math.abs(i - temp) ? Math.abs(i - index) : Math.abs(i - temp);
                    }
                    temp = index;
                }
            }
            index++;
        }
        for (int i = temp; i < len; i++) {
            result[i] = Math.abs(i - temp);
        }
        return result;
    }
}
