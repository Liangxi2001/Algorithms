import java.util.HashSet;
import java.util.Set;

/**
 * @author 此间凉汐
 * @date 2022/6/4 8:59
 */
public class Solution929 {
    public static void main(String[] args) {
        String[] ans = new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        System.out.println(new Solution929().numUniqueEmails(ans));
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            StringBuilder stringBuilder = new StringBuilder();
            int index = email.indexOf('@');
            String temp = email.substring(index);
            int i1 = email.indexOf('+');
            if (i1 >= 0) {
                email = email.substring(0, i1) + temp;
            }
            index = email.indexOf('@');
            for (int i = 0; i < index; i++) {
                char ch = email.charAt(i);
                if (ch == '.') {
                    continue;
                }
                stringBuilder.append(ch);
            }
            stringBuilder.append(temp);
            set.add(stringBuilder.toString());
        }
        return set.size();
    }
}
