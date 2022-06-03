/**
 * 排序工具类
 *
 * @author 此间凉汐
 * @date 2022/4/28 13:39
 */
public class SortUtil {
    //对元素两个进行比较,若v<m时，返回true
    private static Boolean less(Comparable v, Comparable m) {
        //v.compareTo(m) < 0 == v < m
        return v.compareTo(m) < 0;
    }

    //将元素位置进行交换
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    //验证数组是否有序
    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1]))
                return false;
        }
        return true;
    }

    /**
     * 选择排序
     *
     * @param a
     */
    public static void selectionSort(Comparable[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
        }
    }

    /**
     * 插入排序
     *
     * @param a
     */
    public static void insertionSort(Comparable[] a) {
        int len = a.length;
        for (int i = 1; i < len; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--)
                exch(a, j, j - 1);
        }
    }


}
