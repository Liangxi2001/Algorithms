/**
 * @author 此间凉汐
 * @date 2022/5/29 8:38
 * "2001:0db8:85a3:0:0:8A2E:0370:7334:"
 */
public class Solution486 {
    public static void main(String[] args) {
        String str = "12..33.4";
        Solution486 solution486 = new Solution486();
        String s = solution486.validIPAddress(str);
        System.out.println(s);
    }

    public String validIPAddress(String queryIP) {
        if (queryIP == null || queryIP.equals("")) {
            return "Neither";
        }
        if (!((queryIP.charAt(queryIP.length() - 1) - '0' >= 0 && queryIP.charAt(queryIP.length() - 1) - '0' <= 9) || (queryIP.charAt(queryIP.length() - 1) - 'a' >= 0 && queryIP.charAt(queryIP.length() - 1) - 'a' <= 25))) {
            return "Neither";
        }
        String[] words;
        if (queryIP.indexOf('.') >= 0) {
            words = queryIP.split("\\.");
            if (words.length != 4) {
                return "Neither";
            }
            for (String s : words) {
                if (s.equals("") || s.length() > 3) return "Neither";
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
                        continue;
                    } else {
                        return "Neither";
                    }
                }
                int i = Integer.parseInt(s);
                if (i < 0 || i > 255) {
                    return "Neither";
                }
                if (i == 0) {
                    if (s.length() != 1) {
                        return "Neither";
                    }
                }
                if (i != 0) {
                    if (s.charAt(0) == '0') {
                        return "Neither";
                    }
                }
            }
            return "IPv4";
        } else {
            queryIP = queryIP.toLowerCase();
            words = queryIP.split(":");
            if (words.length != 8) {
                return "Neither";
            }
            for (String s : words) {

                if (s.length() < 1 || s.length() > 4 || s.equals("")) {
                    return "Neither";
                }
                for (int i = 0; i < s.length(); i++) {
                    if ((s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) || (s.charAt(i) - 'a' >= 0 && s.charAt(i) - 'a' <= 5)) {
                        continue;
                    } else {
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        }
    }
}
