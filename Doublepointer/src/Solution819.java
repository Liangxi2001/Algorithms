import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 819. 最常见的单词
 *
 * @author 此间凉汐
 * @date 2022/4/17 7:48
 */
public class Solution819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        char[] cs = paragraph.toCharArray();
        //存放禁用列表内的单词
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        //使用map为单词计数
        HashMap<String, Integer> map = new HashMap<>();
        //使用双指针的方式截取单词
        for (int i = 0; i < cs.length; i++) {
            int k = i;
            while (k < cs.length && Character.isAlphabetic(cs[k])) {
                k++;
            }
            String word = paragraph.substring(i, k).toLowerCase();
            i = k;
            //判断此单词是否在禁用列表中
            if (set.contains(word) || "".equals(word) || null == word) {
                continue;
            }
            //为单词计数，如果没有则为1，有则为get(word)+1
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        //找出出现次数最多的单词
        int max = 0;
        String res = "";
        for (String word : map.keySet()) {
            int cnt = map.get(word);
            if (cnt > max) {
                max = cnt;
                res = word;
            }
        }
        return res;
    }
}
