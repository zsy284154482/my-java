package org;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {
    public static void main(String[] args) throws IOException {
        //创建一个server对象，绑定端口号
        ServerSocket serverSocket=new ServerSocket(9999);
        while (true){
            Socket clientSocket = serverSocket.accept();
            new Thread(){
                @Override
                public void run() {
                    try {
                        InputStream is=clientSocket.getInputStream();
                        OutputStream os=clientSocket.getOutputStream();
                        BufferedReader br=new BufferedReader(new InputStreamReader(is));
                        PrintWriter ps=new PrintWriter(os);
                        while (true) {
                            String line=br.readLine();
                            if (line!=null){
                                System.out.println(new Date()+"接收到客户端的数据："+line);
                                ps.write("接收成功\r\n");
                                ps.flush();
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}
