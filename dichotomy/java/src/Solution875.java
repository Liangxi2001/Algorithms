package java.src;

/**
 * 875. 爱吃香蕉的珂珂
 *
 * @author 此间凉汐
 * @date 2022/6/7 13:54
 */
public class Solution875 {
    /**
     * 二分法求取速度，首先确定速度的边界，最小是0，最大是数组中最大的数字，因为一次只能吃一堆，速度太大没用
     *
     * @param piles
     * @param h
     * @return
     */
    public int minEatingSpeed(int[] piles, int h) {
        int l = 0, r = 0;
        for (int pile : piles) {
            r = Math.max(r, pile);
        }
        while (l < r) {
            int mid = l + r >> 1;
            //如果满足，就说明该速度<=最小速度
            if (check(piles, mid, h)) r = mid;
            else l = mid + 1;
        }
        return r;
    }

    /**
     * 确定该速度下是否满足时间<=h
     * 即把需要吃完每一堆香蕉的速度求出来相加，然后进行比较
     *
     * @param piles
     * @param mid
     * @param h
     * @return
     */
    private boolean check(int[] piles, int mid, int h) {
        int ans = 0;
        for (int pile : piles) {
            ans += Math.ceil(pile * 1.0 / mid);
        }
        return ans <= h;
    }
}
