import java.util.ArrayList;
import java.util.List;

/**
 * 417. 太平洋大西洋水流问题
 *
 * @author 此间凉汐
 * @date 2022/4/27 8:48
 */
public class Solution417 {
    //控制当前格向四周迁移
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int[][] heights;
    int m, n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        this.m = heights.length;
        this.n = heights[0].length;
        //可以流向太平洋
        boolean[][] pacific = new boolean[m][n];
        //可以流向大西洋
        boolean[][] atlantic = new boolean[m][n];
        //第一列
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacific);
        }
        //第一行
        for (int j = 1; j < n; j++) {
            dfs(0, j, pacific);
        }
        //最后一列
        for (int i = 0; i < m; i++) {
            dfs(i, n - 1, atlantic);
        }
        //最后一行
        for (int j = 0; j < n - 1; j++) {
            dfs(m - 1, j, atlantic);
        }
        ArrayList<List<Integer>> result = new ArrayList<>();
        //如果某一个地方的水既可以从流向太平洋，又可以流向大西洋，那么将该坐标加入结果
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    result.add(temp);
                }
            }
        }
        return result;
    }

    private void dfs(int row, int col, boolean[][] ocean) {
        //如果确定可以流向某一个大洋，则返回
        if (ocean[row][col]) {
            return;
        }
        //既然找到了该点，那么该点一定通向某大洋
        ocean[row][col] = true;
        //确定该点四周通不通向某大洋
        for (int[] dir : dirs) {
            int newRow = row + dir[0], newCol = col + dir[1];
            //如果不在二维数组，直接跳过，否则查找四周高度<=该高度的坐标
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && heights[newRow][newCol] >= heights[row][col]) {
                dfs(newRow, newCol, ocean);
            }
        }
    }
}
