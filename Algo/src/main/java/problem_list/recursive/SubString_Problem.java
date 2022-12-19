package problem_list.recursive;

import java.util.ArrayList;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 子串问题, 返回所有子串 要求相对顺序不变,包含空
 * @date 2020/5/13 0013 11:25
 */
public class SubString_Problem {
  public static ArrayList<String> substring(String str) {
    ArrayList<String> ret = new ArrayList<String>();
    if (str == null) {
      return null;
    }
    if (str.length() == 0) {
      ret.add("");
      return ret;
    }
    char[] value = str.toCharArray();
    process(value, 0, "", ret);
    return ret;
  }

  public static void process(char[] str, int index, String touched, ArrayList<String> ans) {
    if (index == str.length) {
      ans.add(touched);
      return;
    }
    process(str, index + 1, touched + String.valueOf(str[index]), ans);//要这个字母
    process(str, index + 1, touched, ans);
  }

  public static void main(String[] args) {
    ArrayList<String> ary = substring("abc");
    for (String str : ary
    ) {
      System.out.println(str);
    }
  }
}
