package org;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 9999);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        PrintWriter pw = new PrintWriter(os);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String s = scanner.nextLine();
            pw.write(s+"\r\n");
            pw.flush();
            if (s.equals("quit")) {
                break;
            }

            System.out.println("读取响应数据：" + br.readLine());


        }
        br.close();
        socket.close();
    }
}

