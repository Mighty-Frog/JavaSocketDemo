import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Server {

    public static void main(String[] args) throws IOException {
        //1. 创建对象ServerSocket，触发含参构造
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("server has been built...");
        //2. 接受客户端发来的连接请求，并建立连接通道
        Socket socket = serverSocket.accept();
        System.out.println("Server accepted a connect request");
        //3.创建输入流,读取客户端发来的输出流
        InputStream in = socket.getInputStream();
        System.out.println("创建输入流完成");
        /*
        while(true) {
            int temp =   in.read();
            if (temp != -1) {    //网络编程in会一直传输，没有-1，所以要用for（i = 0; i< 5)
                System.out.println(temp);
            } else {
                break;
            }
        }
        */
        //in接收的数据一定要大于下面的5，否则会暂停在末端，而不会进行下一行代码
         for(int i = 0; i < 5; i ++ ) {
             char temp = (char) in.read();
             System.out.println("打印 " + temp);
         }
        //in.close();
        System.out.println("打印server发送数据完成， 输入流关闭");
         //4.给客户端写数据-out
        // 创建输出流,并写入数据
         OutputStream out = socket.getOutputStream();
         System.out.println("输出流开启， 发给客户端信息");
         String outStr = "我（服务器）已经收到信息，";
         out.write(outStr.getBytes());
         out.close();
         System.out.println("发送客户端数据完成，输出流关闭");



    }

}
