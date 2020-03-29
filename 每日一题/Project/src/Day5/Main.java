package Day5;
//
//import java.util.Scanner;
//import java.util.Stack;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] data = new int[n];
//        for (int i = 0; i < n; i++) {
//            data[i] = scanner.nextInt();
//        }
//        System.out.println(selection(data,3,0));
//        System.out.println(3);
//    }

//    public static int selection(int[] data,int i,int add) {
//        if (add == 0){
//            return 1;
//        }
//        if (add < 0) {
//            return 0;
//        }
//        if (i == 1) {
//            if (data[i-1]==add) {
//                return 1;
//            } else
//                return 0;
//        }
//        return selection(data,i-1,add+=data[i])+selection(data,i-1,add);
//        Stack
//
//    }
//}