package Day31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)        );
        String line = reader.readLine();
        String[] words = line.split(" ");
        for (int i = 0; i < words.length - 1; i++) {
            System.out.format("%s ", words[words.length - 1 - i]);
        }
        System.out.println(words[0]);
    }
}