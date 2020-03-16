package Day36;

//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
//        int[] temp = new int[26];
//        String[] data = new String[]{"A","B","C","D","E","F","G","H",
//                "I","J","K","L","M","N","O","P","Q","R","S","T","U",
//                "V","W","X","Y","Z"};
//        for (int i = 0;i < s.length();i++) {
//            int a = search(s.substring(i,i+1));
//            if (a != -1) {
//                temp[a]++;
//            }
//        }
//        for (int i = 0;i < 26;i++) {
//            System.out.println(data[i]+":"+temp[i]);
//        }
//
//    }
//    private static int search(String s) {
//        String[] data = new String[]{"A","B","C","D","E","F","G","H",
//                "I","J","K","L","M","N","O","P","Q","R","S","T","U",
//                "V","W","X","Y","Z"};
//        int result = -1;
//        for (int i = 0;i < 26;i++) {
//            if (data[i].equals(s)) {
//                result = i;
//                break;
//            }
//        }
//        return result;
//    }
//}


//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
//        char[] data = s.toCharArray();
//        int line = data.length;
//        int result = 0;
//        for (int i = 2;i < line;i++) {
//            result *= 16;
//            char temp = data[i];
//            if (temp >= 'a' && temp <='f' ) {
//                int n = temp-'a'+
//            }
//        }
//    }
//}