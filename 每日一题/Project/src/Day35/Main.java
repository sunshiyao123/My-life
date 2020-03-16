package Day35;

//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String data1 = scanner.nextLine();
//        String data2 = scanner.nextLine();
//        for (int i = 0;i < data2.length();i++) {
//            String[] data = data1.split(data2.substring(i,i+1));
//            data1 = pinJie(data);
//        }
//
//    }
//    private static String pinJie(String[] data) {
//        StringBuilder sb = new StringBuilder();
//        for (String s : data) {
//            sb.append(s);
//        }
//        return sb.toString();
//    }
//}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] data = new int[6];
        int i = 0;
        while (scanner.hasNextInt()) {
            data[i] = scanner.nextInt();
            i++;
        }
        int x = data[3] - data[0];
        int y = data[4] - data[1];
        int z = data[5] - data[2];
    }
}
