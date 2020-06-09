package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) {
        try {
            //创建socket链接，端口6000
            ServerSocket server = new ServerSocket(6000);
            System.out.println("server is start,waiting for client.");
            //接收客户端消息
            Socket socket = server.accept();
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String temp = null;
            while ((temp = bufferedReader.readLine()) != null) {
                System.out.println("recv:" + temp);
            }
            //反馈给客户端消息
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.print("I have accepted.");
            printWriter.flush();
            socket.shutdownOutput();
            //关闭资源
            printWriter.close();
            outputStream.close();
            bufferedReader.close();
            inputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
