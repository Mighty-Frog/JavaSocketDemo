import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * 代表Socket的客户端--利用Socket
 * 负责：
 * 1. 读取服务器发来的数据-in-InputStream
 * 2. 给服务器写出数据-out-OutputStream
 */
public class Client {
    /**
     * Commut.
     *
     * @throws IOException the io exception
     */
    public static void main(String[] args) throws Exception {
        // 1. 创建对象Socket,指定服务器ip和端口号，注意socket表示的是一个通道
        String host = InetAddress.getLocalHost().getHostAddress();
        int port = 9999;
        Socket socket = new Socket(host, port);
        System.out.println("与服务器连接成功...");
        //2.给服务器写出Hello:先返回字节写出流，然后在流里写出数据（以比特写出），最后发出flush，或两个动作一个语句：发出且关闭资源close。
        System.out.println("下方请输入需要发给服务器的信息");
        String typeIn = new Scanner(System.in).nextLine();
        OutputStream out = socket.getOutputStream();
        out.write(typeIn.getBytes());
        //out.close(); socket就是流，关了流就是关了socket
        out.flush();
        System.out.println("输出客户端数据完成，输出流发送");

        //3.接收服务器发来的数据

        InputStream in = socket.getInputStream();
        System.out.println("输入流(接收服务器数据)开启");
        String strGet = new String(in.readAllBytes());
        System.out.println("下方打印收到服务器的信息");

        System.out.println("\"" + strGet + "\"");
        in.close();
        System.out.println("接收服务器数据并完成打印，输入流关闭");






    }

    }


