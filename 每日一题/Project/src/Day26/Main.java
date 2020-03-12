package Day26;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = null;
        while (scanner.hasNextLine()){
            int temp = Integer.valueOf(scanner.nextLine());
            System.out.println(add(temp)+" "+ addTwo(temp*temp));

        }
    }
    public static int add(int data) {
        int result = 0;
        while (data > 9){
            result += data % 10;
            data = data / 10;
        }
        result += data;
        return result;
    }
    private static int addTwo(int data) {
        int result = 0;
        while (data > 9){
            result += data%10;
            data = data / 10;
        }
        result += data;
        return result;
    }
}
