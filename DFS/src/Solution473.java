import java.util.Arrays;

/**
 * @author 此间凉汐
 * @date 2022/6/1 11:05
 */
public class Solution473 {
    public static void main(String[] args) {
        int[] ans = new int[]{1, 1, 2, 2, 2};
        System.out.println(new Solution473().makesquare(ans));
    }

    public boolean makesquare(int[] matchsticks) {
        int totalLen = Arrays.stream(matchsticks).sum();
        if (totalLen % 4 != 0) {
            return false;
        }
        Arrays.sort(matchsticks);
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }
        int[] edges = new int[4];
        return dfs(0, matchsticks, edges, totalLen / 4);
    }

    private boolean dfs(int index, int[] matchsticks, int[] edges, int len) {
        if (index == matchsticks.length) {
            return true;
        }
        for (int i = 0; i < edges.length; i++) {
            edges[i] += matchsticks[index];
            if (edges[i] <= len && dfs(index + 1, matchsticks, edges, len)) {
                return true;
            }
            edges[i] -= matchsticks[index];
        }
        return false;
    }
}
