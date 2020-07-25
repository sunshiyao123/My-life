package EverydayPractice.Day1;

/**
 * 学分绩点：
 * 数字按照保留两位输出：
 *  printf("%.2f",1.2222222)    //1.22
 */

import java.util.*;
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String length = in.nextLine();
        String subjectData = in.nextLine();
        String studentData = in.nextLine();
        Double result = solution(length,subjectData,studentData);
        System.out.printf("%.2f",result);
    }

    private static double solution(String a,String b,String c) {
        int length = Integer.valueOf(a);
        String[] subjectData = b.split(" ");
        String[] studentData = c.split(" ");
        double studentAdd = 0;
        int subjectAdd = 0;
        for(int i = 0;i < length;i++) {
            studentAdd += jiDian(subjectData[i],studentData[i]);
            subjectAdd += Integer.valueOf(subjectData[i]);
        }
        return studentAdd/subjectAdd;
    }
    private static double jiDian(String subject,String student) {
        double temp = Double.valueOf(student);
        if(temp >= 90 && temp <= 100)
            return 4.0*Integer.valueOf(subject);
        if(temp >= 85 && temp <= 89)
            return 3.7*Integer.valueOf(subject);
        if(temp >= 82 && temp <= 84)
            return 3.3*Integer.valueOf(subject);
        if(temp >= 78 && temp <= 81)
            return 3.0*Integer.valueOf(subject);
        if(temp >= 75 && temp <= 77)
            return 2.7*Integer.valueOf(subject);
        if(temp >= 72 && temp <= 74)
            return 2.3*Integer.valueOf(subject);
        if(temp >= 68 && temp <= 71)
            return 2.0*Integer.valueOf(subject);
        if(temp >= 64 && temp <= 67)
            return 1.5*Integer.valueOf(subject);
        if(temp >= 60 && temp <= 63)
            return 1.0*Integer.valueOf(subject);
        return 0;
    }
}
