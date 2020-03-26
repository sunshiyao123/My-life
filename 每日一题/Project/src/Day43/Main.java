package Day43;

import java.util.Scanner;

//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        solution(n,m);
//    }
//    public static void solution(int n,int m) {
//        if (n >= m) {
//            print(1,m-1);
//        }
//        else if (n > m/2) {
//            print1(m-n,n);
//        }
//    }
//    public static void print(int i,int j) {
//        int temp = j+1;
//        while (i < j) {
//            System.out.println(i+" "+j);
//            i++;
//            j--;
//        }
//        System.out.println(temp);
//    }
//    public static void print1(int i,int j) {
//        while (i < j) {
//            System.out.println(i+" "+j);
//            i++;
//            j--;
//        }
//    }
//}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int line = Integer.valueOf(scanner.nextLine());
        String[] data = new String[line];
        for (int i = 0;i < line;i++) {
            data[i] = change(scanner.nextLine());
        }
        for (String s : data) {
            System.out.println(s);
        }
    }
    private static String change(String s) {
        char[] data = s.toCharArray();
        for (int i = 0;i < data.length;i++) {
            if (data[i] == '-')
                continue;
            if (data[i] == 'a' || data[i] == 'A' ||data[i] == 'b' ||data[i] == 'B'
                    ||data[i] == 'c' ||data[i] == 'C') {
                data[i] = '2';
            }
            if (data[i] == 'd' || data[i] == 'D' ||data[i] == 'e' ||data[i] == 'E'
                    ||data[i] == 'f' ||data[i] == 'F') {
                data[i] = '3';
            }
            if (data[i] == 'h' || data[i] == 'H' ||data[i] == 'i' ||data[i] == 'I'
                    ||data[i] == 'g' ||data[i] == 'G') {
                data[i] = '4';
            }
            if (data[i] == 'k' || data[i] == 'K' ||data[i] == 'l' ||data[i] == 'L'
                    ||data[i] == 'j' ||data[i] == 'J') {
                data[i] = '5';
            }
            if (data[i] == 'm' || data[i] == 'M' ||data[i] == 'n' ||data[i] == 'N'
                    ||data[i] == 'o' ||data[i] == 'O') {
                data[i] = '6';
            }
            if (data[i] == 'p' || data[i] == 'P' ||data[i] == 'q' ||data[i] == 'Q'
                    ||data[i] == 'r' ||data[i] == 'R'||data[i] == 's' ||data[i] == 'S') {
                data[i] = '7';
            }
            if (data[i] == 't' || data[i] == 'T' ||data[i] == 'u' ||data[i] == 'U'
                    ||data[i] == 'v' ||data[i] == 'V') {
                data[i] = '8';
            }
            if (data[i] == 'w' || data[i] == 'W' ||data[i] == 'x' ||data[i] == 'X'
                    ||data[i] == 'y' ||data[i] == 'Y'||data[i] == 'z' ||data[i] == 'Z') {
                data[i] = '9';
            }
        }
        String result = new String(data);
        String[] data1 = result.split("-");
        result = "";
        for (String string : data1) {
            result += string;
        }
        return result.substring(0,3)+"-"+result.substring(3,result.length());
    }
}
