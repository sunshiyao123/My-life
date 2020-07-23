package EverydayPractice.Day1;
/**
 * Double.valueOf()
 * Double强制转为int损失数据
 */

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String data = in.nextLine();
        String result = solution(data);
        System.out.println(result);
    }
    private static String solution(String data) {
        double temp1 = Double.valueOf(data);
        Stack<Integer> intData = new Stack();
        Stack<Integer> doubleData = new Stack();
        int count = 0;

        while(temp1*10%10 != 0) {
            temp1 *= 10;
            count++;
        }
        int temp = (int) temp1;
        for(int i = 0;i < count;i++) {
            doubleData.push(temp%10);
            temp /= 10;
        }
        while(temp != 0) {
            intData.push(temp%10);
            temp /= 10;
        }
        StringBuilder result = new StringBuilder("人民币");
        result.append(connect(intData,doubleData));
        return result.toString();
    }

    //字符串的拼接连接
    private static StringBuilder connect(Stack intData,Stack doubleData) {
        String[] standard = new String[]{"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
        int size = intData.size();
        StringBuilder[] data = new StringBuilder[size];
        /**
         * 1.这里intData：栈顶存的是最高位的数  1 5 1 1 2 1
         * 2.150000：十五万;
         */
        int count = size-1;
        int i = 0;
        if ((count%4 == 1) && (data[count].toString().equals("壹"))) {
            data[0] = new StringBuilder("拾");
            count--;
            i++;
        }
        for(i = 0;i < size;i++) {
            data[i] = new StringBuilder(standard[(int)intData.pop()]);
            if(count%4 == 1) {
                    data[i].append("拾");
            }
            if(count%4 == 2)
                data[i].append("佰");
            if(count%4 == 3)
                data[i].append("仟");
            if(count == 4)
                data[i].append("万");
            if(count == 8)
                data[i].append("亿");
            count--;
        }
        StringBuilder result = new StringBuilder();
        for(StringBuilder sb : data) {
            result.append(sb);
        }
        result.append("元整");
        //加上几角几分
        int jiao = (int)doubleData.pop();
        if(jiao != 0) {
            result.append(standard[jiao]);
            result.append("角");
        }
        int fen = (int)doubleData.pop();
        if(fen != 0) {
            result.append(standard[jiao]);
            result.append("分");
        }
        return result;
    }
}