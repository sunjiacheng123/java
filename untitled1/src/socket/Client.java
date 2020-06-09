package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) {
        try {
            //创建socket
            Socket socket=new Socket("127.0.0.1",6000);
            //发送消息
            OutputStream outputStream=socket.getOutputStream();
            PrintWriter printWriter=new PrintWriter(outputStream);
            printWriter.print("hello, i am wang.");
            printWriter.flush();
            socket.shutdownOutput();
            //接收消息
            InputStream inputStream=socket.getInputStream();
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String temp=null;
            while((temp=bufferedReader.readLine())!=null){
                System.out.println("server reply:"+temp);
            }
            //关闭资源
            bufferedReader.close();
            inputStream.close();
            printWriter.close();
            outputStream.close();
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (ConnectException e){
            System.out.println("服务器未运行");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

