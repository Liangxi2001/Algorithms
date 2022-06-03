/**
 * 1021. 删除最外层的括号
 *
 * @author 此间凉汐
 * @date 2022/5/28 9:09
 */
public class Solution1021 {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        if (len == 1) {
            return s;
        }
        //flag用来判断是否是一次截取中的开始，以保证start不会出错
        boolean flag = true;
        int start = -1;
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt == 1 && flag) {
                start = i;
                flag = false;
            }
            if (cnt == 0) {
                sb.append(s.substring(start + 1, i));
                flag = true;
            }
        }
        return sb.toString();
    }
}