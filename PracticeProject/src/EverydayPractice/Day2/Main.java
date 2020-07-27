package EverydayPractice.Day2;

import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            int temp = scanner.nextInt();
            System.out.println(solution(temp)+" "+solution(temp*temp));
        }
    }
    private static int solution(int data) {
        int result = 0;
        while(data != 0){
            result += data%10;
            data /= 10;
        }
        return result;
    }
}