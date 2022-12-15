package pri.IOStreamDemo;

import jdk.nashorn.api.scripting.URLReader;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description
 * @date 2020/6/3 0003 11:48
 */
public class BaiduTest {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader =
                    new BufferedReader(new InputStreamReader(new URL("http://www.baidu.com").openStream(),
                            "UTF-8"));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("baidu.html")));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String msg = "";
        try {
            while ((msg = bufferedReader.readLine()) != null) {
                System.out.println(msg);
                bufferedWriter.write(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
