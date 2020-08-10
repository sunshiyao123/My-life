package KeywordPractice.try_catch_finally_throw_throws;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(fun());

    }
    private static int fun() {
        int i = 0;
        try {
            System.out.println(10/0); //有错误
            return i+1;
        } finally {
            System.out.println("我进来过");
            return i+3;
        }
    }
}




