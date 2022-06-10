import java.util.Random;

/**
 * 478. 在圆内随机生成点
 *
 * @author 此间凉汐
 * @date 2022/6/5 9:55
 */

/**
 * 拒绝采样：从以圆心为中心，2r为边长的正方形中随机选点，落在圆内就返回这个点
 */
public class Solution478 {
    Random random;
    double x, y, r;

    public Solution478(double radius, double x_center, double y_center) {
        random = new Random();
        this.x = x_center;
        this.y = y_center;
        this.r = radius;
    }

    public double[] randPoint() {
        while (true) {
            double xx = (random.nextDouble() * 2 * r) - r;
            double yy = (random.nextDouble() * 2 * r) - r;
            if (xx * xx + yy * yy <= r * r) {
                return new double[]{xx + x, yy + y};
            }
        }
    }
}
