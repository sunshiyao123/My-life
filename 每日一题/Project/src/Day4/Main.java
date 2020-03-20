package Day4;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.Scanner;

//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        System.out.println(run(in.nextInt()));
//    }
//    public static int run (int n) {
//        int add;
//        int temp = -1;
//        int count = 0;
//        for (int a = 0;a <= 16;a++) {
//            for (int b = 0;b <= 12;b++){
//                add = a*6 + b*8;
//                if (add == n){
//                    if (count == 0) {
//                        temp = a+b;
//                    } else {
//                        if (temp > a+b){
//                            temp = a+b;
//                        }
//                    }
//                    count++;
//                }
//            }
//        }
//        return temp;
//    }
//}

public class Main{
    public static void main(String[] args) {
        Scanner str1 = new Scanner(System.in);
        Scanner str2 = new Scanner(System.in);
        System.out.println(Delate(str1.nextLine(), str2.nextLine()));
    }
    public static String Delate(String a,String b) {
        String temp;
        for (int i = 0; i < b.length();i++) {
            temp = b.substring(i,i+1);
            String[] data = a.split(temp);
            a = "";
            for (String s : data) {
                a += s;
            }
        }
        return a;
    }
}
