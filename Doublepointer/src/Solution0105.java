/**
 * 面试题 01.05. 一次编辑
 *
 * @author 此间凉汐
 * @date 2022/5/13 15:01
 */

import org.jetbrains.annotations.NotNull;

/**
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 * 根据描述，两个字符串的长度只有相差1或0两种结果
 */
public class Solution0105 {
    public boolean oneEditAway(@NotNull String first, @NotNull String second) {
        int lenFirst = first.length(), i = 0;
        int lenSecond = second.length(), j = 0;
        int cnt = 0;
        //两个字符串的长度只有相差1或0两种结果
        if (Math.abs(lenFirst - lenSecond) > 1) return false;
        while (i < lenFirst && j < lenSecond) {
            if (first.charAt(i) == second.charAt(j)) {
                i++;
                j++;
                continue;
            }
            /**
             * 如果出现不同的情况，哪个长哪个多走一步，如果一样长则都走一步
             * 无论哪种情况，都要执行一次操作
             */
            if (lenFirst < lenSecond) i++;
            if (lenFirst > lenSecond) j++;
            if (lenSecond == lenFirst) {
                i++;
                j++;
            }
            cnt++;
        }
        return cnt <= 1 ? true : false;
    }
}
