package pri.classload;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description
 * @date 2020/6/15 0015 8:58
 */

class Candy {
  static {
    System.out.println("Loading Candy");
  }
}

class Gum {
  static {
    System.out.println("Loading Gum");
  }
}

class Cookie {
  static {
    System.out.println("Loading Cookie");
  }
}

public class thinking {
  public static class SweetShop {
    public static void print(Object obj) {
      System.out.println(obj);
    }

    public static void main(String[] args) {
      print("inside main");
      new Candy();
      print("After creating Candy");
      try {
        Class.forName("com.zejian.Gum");
      } catch (ClassNotFoundException e) {
        print("Couldn't find Gum");
      }
      print("After Class.forName(\"com.zejian.Gum\")");
      new Cookie();
      print("After creating Cookie");
    }
  }
}
