package EverydayPractice.Day2;

import java.util.*;
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length1 = Integer.valueOf(scanner.nextLine());
        String[] name = new String[length1];
        for (int i = 0;i <length1;i++) {
            name[i] = scanner.next();
        }
        int length2 = Integer.valueOf(scanner.nextLine());
        String[] data = new String[length2];
        for (int i = 0;i <length1;i++) {
            data[i] = scanner.next();
        }
        Map<String,Integer> map = new LinkedHashMap();
        for(int i = 0;i < length1;i++) {
            map.put(name[i],0);
        }
        map.put("Invalid",0);
        for(int i = 0;i < length2;i++) {
            if (map.containsKey(data[i]))
                map.put(data[i],map.get(data[i])+1);
            else
                map.put("Invalid",map.get("Invalid")+1);
        }
        Set<String> set = map.keySet();
        for (String s : set) {
            System.out.println(s+":"+map.get(s));
        }

    }

}