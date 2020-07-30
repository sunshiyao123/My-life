package EverydayPractice.Day3;

/**
 * 球的半径和体积
 * 输入球的中心点和球上某一点的坐标，计算球的半径和体积
 *
 * 注意点：Math类用法
 */

import java.util.*;
public class Main2 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNextLine()) {
//            String[] temp = scanner.nextLine().split(" ");
//            int[] result = new int[6];
//            int i = 0;
//            for(String s : temp){
//                result[i++] = Integer.valueOf(s);
//            }
//            //得到半径
//            double radius = countRadius(result);
//            System.out.printf("%.3f",radius);
//            System.out.printf(" ");
//            double area = countArea(radius);
//            System.out.printf("%.3f",area);
//        }
        System.out.println(Math.acos(-1));
    }
    private static double countRadius(int[] data) {
        double x0 = data[0];
        double y0 = data[1];
        double z0 = data[2];
        double x1 = data[3];
        double y1 = data[4];
        double z1 = data[5];
        double temp = (x1-x0)*(x1-x0) + (y1-y0)*(y1-y0) + (z1-z0)*(z1-z0);
        return Math.sqrt(temp);
    }
    private static double countArea(double radius) {
        return (4*Math.PI*Math.pow(radius,3))/3;
    }
}