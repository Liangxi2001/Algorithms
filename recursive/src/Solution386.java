import java.util.ArrayList;
import java.util.List;

/**
 * 386. 字典序排数
 * 10叉树+递归
 *
 * @author 此间凉汐
 * @date 2022/4/18 8:05
 */
public class Solution386 {

    List<Integer> res = new ArrayList<>();

    /**
     * 寻找以1，2...9开始的所有数，每一次都找完
     *
     * @param n
     * @return
     */
    public List<Integer> lexicalOrder(int n) {
        for (int i = 1; i <= 9; i++) {
            dfs(i, n);
        }
        return res;
    }

    private void dfs(int cur, int n) {
        if (cur > n) {
            return;
        }
        res.add(cur);
        //找以10，11，12，13...19开始的所有数，
        for (int i = 0; i <= 9; i++) {
            dfs(cur * 10 + i, n);
        }
    }
}
