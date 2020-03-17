package Day38;

import java.util.Scanner;

public class LCA {
    public static void main(String[] args) {
//        System.out.println(getLCA(2,3));
        Replacement r = new Replacement();
        System.out.println(r.replaceSpace("Hello  World",12));
    }
//    public static int getLCA(int a, int b) {
//        // write code here
//        StringBuilder sb1 = new StringBuilder();
//        StringBuilder sb2 = new StringBuilder();
//        while (a > 0){
//            sb1.append(a);
//            a /= 2;
//        }
//        while (b > 0){
//            sb2.append(b);
//            b /= 2;
//        }
//        char[] data1 = sb1.toString().toCharArray();
//        char[] data2 = sb2.toString().toCharArray();
//        int temp = 0;
//        for (int i = 0;i < data1.length;i++) {
//            for (int j = 0;j < data2.length;j++) {
//                if (data1[i] == data2[j])
//                    temp = data1[i]-'0';
//            }
//        }
//        return temp;
//    }
//    static int getLCA(int a, int b) {
//        // write code here
//        while(a != b)
//        {
//            if(a > b)
//                a /= 2;
//            else
//                b /= 2;
//        }
//        return a;
//    }

}

class Replacement {
    public String replaceSpace(String iniString, int length) {
        String[] temp = iniString.split(",");
        String[] data = temp[0].split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < data.length;i++) {
            sb.append(data[i]);
            sb.append("%20");
        }
        String result = sb.toString().substring(0,sb.length()-3);
        result = "\"" + result + "\"";
        return result;
    }
}


