package pri.IOStreamDemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description
 * @date 2020/6/3 0003 16:43
 */
public class RandomAccessFiletest {
  public static void main(String[] args) {
    File file = new File("doc.txt");
    RandomAccessFile randomAccessFile = null;
    long length = file.length();
    double blocksize = 1024.0;
    int blocks = (int) Math.ceil(length / blocksize);
    try {
      randomAccessFile = new RandomAccessFile(file, "w");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    for (int i = 0; i < blocks; i++) {
      try {
        randomAccessFile.skipBytes((int) blocksize * i);


      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
