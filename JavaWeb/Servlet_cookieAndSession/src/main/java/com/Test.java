package com;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        String request = "GET/ HTTP/1.0\r\nHost:www.baidu.com\r\n\r\n";
        Socket socket = new Socket("www.baidu.com",80);
        byte[] bytes = new byte[4096];
        int len = socket.getInputStream().read(bytes);
        int index = -1;
        for (int i = 0;i < len-3;i++) {
            if (bytes[i] == '\r' && bytes[i+1] == '\n'
                    && bytes[i+2] == '\r' && bytes[i+3] == '\n') {
                index = i;
                break;
            }
        }
        ByteArrayInputStream byteArrayInputStream =
                new ByteArrayInputStream(bytes);
        Scanner scanner = new Scanner
                (byteArrayInputStream,"UTF-8");
        String statusLine = scanner.nextLine();
        System.out.println("状态行："+statusLine);
        String line;
        int contentLength = -1;
        while(!(line = scanner.nextLine()).isEmpty()) {
            String[] kv = line.split(":");
            String key = kv[0].trim();
            String value = kv[1].trim();
            System.out.println("响应头："+key+" = "+value);
            if (key.equalsIgnoreCase("Content.length()")) {
                contentLength = Integer.valueOf(value);
            }
        }
        int start = len - index - 4;
        int end = contentLength - start;
        byte[] body = new byte[contentLength];
        System.arraycopy(bytes,index+4,body,0,);
    }
}
