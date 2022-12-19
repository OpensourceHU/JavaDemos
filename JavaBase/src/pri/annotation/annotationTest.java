package pri.annotation;

import java.lang.annotation.ElementType;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 注释类测试
 * @date 2020/5/25 0025 22:03
 */
public class annotationTest {
  public static void main(String[] args) {
    person person = new person();
    //获得class对象法1   .class
    System.out.println(person.class);
    //获得class对象法2  .getclass()
    System.out.println(person.getClass());
    //获得class对象法3   包名检索
    //  System.out.println(Class.forName("annotation.annotationTest"));

    Class c1 = Object.class;
    Class c2 = Comparable.class;
    Class c3 = String[].class;
    Class c4 = int[][].class;
    Class c5 = Override.class;
    Class c6 = ElementType.class;
    Class c7 = Integer.class;
    Class c8 = int.class;
    Class c9 = void.class;
    Class c10 = Class.class;

    System.out.println(c1);
    System.out.println(c2);
    System.out.println(c3);
    System.out.println(c4);
    System.out.println(c5);
    System.out.println(c6);
    System.out.println(c7);
    System.out.println(c8);
    System.out.println(c9);
    System.out.println(c10);
    //同一个类只会加载在内存中一次  所以一个类只有一个Class对象
    int[] arr1 = new int[10];
    int[] arr2 = new int[1];
    System.out.println(arr1.getClass().hashCode());
    System.out.println(arr2.getClass().hashCode());
    //两者的hashcode一致  只可能是同一个对象

  }
}

class person {
  public String name;

  public person() {
  }

  public person(String name) {
    this.name = name;
  }

}
