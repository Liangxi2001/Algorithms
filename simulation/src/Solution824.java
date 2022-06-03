import java.util.Arrays;
import java.util.List;

/**
 * 824. 山羊拉丁文
 *
 * @author 此间凉汐
 * @date 2022/4/21 8:33
 */
public class Solution824 {
    public String toGoatLatin(String sentence) {
        List list = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        String[] s = sentence.split(" ");
        int len = s.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (list.contains(s[i].charAt(0))) {
                //如果是以元音字母开头，直接添加
                sb.append(s[i]);
            } else {
                //如果不是，把第一个字母放在最后添加
                sb.append(s[i].substring(1, s[i].length()));
                sb.append(s[i].charAt(0));
            }
            //无论是不是都要添加ma
            sb.append("ma");
            //在第i个单词后面添加i个a
            for (int j = 0; j < i + 1; j++) {
                sb.append('a');
            }
            if (i != len - 1) sb.append(' ');
        }
        return sb.toString();
    }
}
