package EverydayPractice.Day4;

public class Main {
    public static void main(String[] args) {
        System.out.println(30*10);
        int sum = 1;
        for(int i = 1;i < 30;i++) {
            sum += Math.pow(2,i);
        }
        System.out.println(sum);
    }
}