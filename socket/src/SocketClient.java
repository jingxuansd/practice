import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * @Author: Xuan Jing
 * @Date: 2020/4/20 8:41 PM
 */
public class SocketClient {
    public static void main(String[] args) {
        String charset = Charset.defaultCharset().name();
        try (Socket socket = new Socket(InetAddress.getLocalHost(), 13)) {
            InputStream inputStream = socket.getInputStream();
            StringBuilder sb = new StringBuilder();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
            for (int c=inputStreamReader.read(); c!=-1; c=inputStreamReader.read()) {
                sb.append((char)c);
            }
            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
