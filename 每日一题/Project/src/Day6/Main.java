package Day6;
//
//import java.util.Scanner;
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//        int c = scanner.nextInt();
//        int d = scanner.nextInt();
//        int i = run(a, b, c, d);
//        if (i == 30)
//            System.out.println("No");
//        else {
//            System.out.println(i + " " + (c - i) + " " + (d - c + i));
//        }
//    }
//
//    public static int run(int a, int b, int c, int d) {
//        for (int i = 0; i < 30; i++) {
//            for (int j = 0; j < 30; j++) {
//                for (int k = 0; k < 30; k++) {
//                    if ((i - j == a) && (j - k == b) && (i + j == c) && (j + k) == d) {
//                        return i;
//                    }
//                }
//            }
//        }
//        return 30;
//    }
//}

import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] str = s.split(" ");
            Integer[] arr = new Integer[str.length];
            for (int i = 0;i < str.length;i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(search(arr));
        }
    }
    public static int search(Integer[] data) {
        for(int i = 0;i < data.length;i++) {
            for(int j = 0;j < data.length-i-1; j++) {
                if(data[j] > data[j+1]){
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }
        return data[data.length/2];
    }
}