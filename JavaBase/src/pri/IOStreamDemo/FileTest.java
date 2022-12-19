package pri.IOStreamDemo;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


/**
 * @author OpensourceHU
 * @version V1.0
 * @Description
 * @date 2020/5/30 0030 21:46
 */
public class FileTest {
  public static void main(String[] args) {
    File aaa = new File("aaa.txt");
    OutputStream outputStream = null;
    try {
      outputStream = new FileOutputStream("aaa.txt");
      outputStream.write("OpensourceHU".getBytes());
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        outputStream.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    //现在将abc内容写入到aaa中
    InputStream inputStream = null;
    outputStream = null;
    byte[] buffer = new byte[1024];
    try {
      inputStream = new FileInputStream("abc.txt");
      outputStream = new FileOutputStream("aaa.txt");
      try {
        inputStream.read(buffer);
      } catch (IOException e) {
        e.printStackTrace();
      }
      outputStream.write("\n".getBytes());
      outputStream.write(buffer);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        inputStream.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        outputStream.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      buffer = null;
    }

  }
}
