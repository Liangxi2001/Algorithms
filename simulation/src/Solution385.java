//import java.util.Stack;
//
///**
// * 385. 迷你语法分析器
// *
// * @author 此间凉汐
// * @date 2022/4/15 13:55
// */
//public class Solution385 {
//    /**
//     * 栈
//     * @param s
//     * @return
//     */
//    public NestedInteger deserialize(String s) {
//        if (s.charAt(0) != '[') {
//            return new NestedInteger(Integer.parseInt(s));
//        }
//        Stack<NestedInteger> stack = new Stack<NestedInteger>();
//        //sign:记录正负
//        int num = 0, sign = 1;
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c == '[') {
//                stack.push(new NestedInteger());
//            } else if ('0' <= c && c <= '9') {
//                num = num * 10 + (c - '0');
//            } else if (c == '-') {
//                sign *= -1;
//            } else if (c == ',' || c == ']') {
//                char preChar = s.charAt(i - 1);
//                if ('0' <= preChar && preChar <= '9') {
//                    num *= sign;
//                    stack.peek().add(new NestedInteger(num));
//                }
//                num = 0;
//                sign = 1;
//                if (c == ']' && stack.size() > 1) {
//                    NestedInteger lastList = stack.pop();
//                    stack.peek().add(lastList);
//                }
//            }
//        }
//        return stack.pop();
//    }
//}
