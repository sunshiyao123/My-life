package Day25;//package Day25;
//
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String string1 = scanner.nextLine();
//        String string2 = scanner.nextLine();
//        String string3 = scanner.nextLine();
//        int length = Integer.valueOf(string1);
//        String[] data1 = new String[length];
//        data1 = string2.split(" ");
//        String[] data2 = new String[length];
//        data2 = string3.split(" ");
//        float GPA = 0;
//        for (int i = 0; i < length;i++) {
//            GPA += jiDian(Integer.valueOf(data2[i]),Integer.valueOf(data1[i]));
//        }
//        int add = 0;
//        for (int i = 0;i < length;i++) {
//            add += Integer.valueOf(data1[i]);
//        }
//        float result = (float) (GPA/add);
//        System.out.printf("%.2f",result);
//
//    }
//    public static double jiDian(double data1,double data2) {
//        if (data1 < 60)
//            return 0;
//        if (data1 >= 60 && data1 < 64)
//            return (float)1.0 * data2;
//        if (data1 >= 64 && data1 < 68)
//            return (float)1.5 * data2;
//        if (data1 >= 68 && data1 < 72)
//            return (float)2.0 * data2;
//        if (data1 >= 72 && data1 < 75)
//            return (float)2.3 * data2;
//        if (data1 >= 75 && data1 < 78)
//            return (float)2.7 * data2;
//        if (data1 >= 78 && data1 < 82)
//            return (float)3.0 * data2;
//        if (data1 >= 82 && data1 < 85)
//            return (float)3.3 * data2;
//        if (data1 >= 85 && data1 < 90) {
//            return (float)3.7 * data2;
//        }
//        return (float)4.0*data2;
//    }
//}


import java.util.*;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in=new Scanner(System.in);
        while(in.hasNext())
        {
            int n=in.nextInt();
            double[] num=new double[n];
            double[] sum=new double[n];
            double sumnum=0;
            double sumsum=0;
            for(int i=0;i<num.length;i++)
            {
                num[i]=in.nextInt();
                sumnum+=num[i];
            }
            for(int j=0;j<sum.length;j++)
            {
                int temp=in.nextInt();
                if(temp>=90&&temp<=100)
                {
                    sum[j]=num[j]*4.0;

                }
                if(temp>=85&&temp<=89)
                {
                    sum[j]=num[j]*3.7;

                }
                if(temp>=82&&temp<=84)
                {
                    sum[j]=num[j]*3.3;

                }
                if(temp>=78&&temp<=81)
                {
                    sum[j]=num[j]*3.0;

                }
                if(temp>=75&&temp<=77)
                {
                    sum[j]=num[j]*2.7;

                }
                if(temp>=72&&temp<=74)
                {
                    sum[j]=num[j]*2.3;
                }
                if(temp>=68&&temp<=71)
                {
                    sum[j]=num[j]*2.0;
                }
                if(temp>=64&&temp<=67)
                {
                    sum[j]=num[j]*1.5;
                }
                if(temp>=60&&temp<=63)
                {
                    sum[j]=num[j]*1.0;
                }
                if(temp<60)
                {
                    sum[j]=num[j]*0;
                }
                sumsum+=sum[j];
            }
            System.out.printf("%.2f",sumsum/sumnum);

        }

    }
}

