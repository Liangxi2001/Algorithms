/**
 * 面试题 17.11. 单词距离
 *
 * @author 此间凉汐
 * @date 2022/5/27 11:56
 */
public class Solution1711 {
    public int findClosest(String[] words, String word1, String word2) {
        int res = Integer.MAX_VALUE;
        int index1 = -1, index2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1 = i;
            }
            if (words[i].equals(word2)) {
                index2 = i;
            }
            if (index1 != -1 && index2 != -1) {
                res = Math.min(res, Math.abs(index1 - index2));
            }
        }
        return res;
    }
}
