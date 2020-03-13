package Day28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            int data = scanner.nextInt();
            int result = data * data - data;
            if (data >= 10) {
                if (result % 10 == 0 && result / 10 % 10 == 0) {
                    System.out.println("Yes!");
                } else {
                    System.out.println("No!");
                }
            } else {
                if (result % 10 == 0) {
                    System.out.println("Yes!");
                } else  {
                    System.out.println("No!");
                }
            }
        }
    }
}
//public class Main{
//
//    public static void main(String[] args) throws IOException {
//        // TODO Auto-generated method stub
//        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        String line=null;
//        while((line=br.readLine())!=null){
//            int n=Integer.parseInt(line);
//            String s=n*n+"";
//            if(line.equals(s.substring(s.length()-line.length(), s.length()))){
//                System.out.println("Yes!");
//            }
//            else{
//                System.out.println("No!");
//            }
//        }
//    }
//
//}