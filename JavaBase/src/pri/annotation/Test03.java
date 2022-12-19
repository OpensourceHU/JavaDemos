package pri.annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 通过反射获取运行时类的完整结构
 * @date 2020/5/26 0026 10:38
 */
public class Test03 {
  public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
      IllegalAccessException, InstantiationException, InvocationTargetException,
      NoSuchFieldException {
    Class<?> aClass = Class.forName("pri.annotation.son");
    //获取全部接口
    System.out.println(aClass.getInterfaces());
    //
    for (Field declaredField : aClass.getDeclaredFields()) {
      System.out.println(declaredField);
    }
    //获取所有构造器
    System.out.println("        //获取所有构造器");
    for (Constructor<?> constructor : aClass.getConstructors()) {
      System.out.println(constructor);
    }
    //
    System.out.println("获取全部构造器");
    for (Constructor<?> constructor : aClass.getConstructors()) {
      System.out.println(constructor);
    }
    //获取指定类构造器
    System.out.println("获取指定构造器");
    Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(int.class);
    System.out.println(declaredConstructor);


    //通过反射动态创建对象  直接newInstance相当于调用无参构造器
    System.out.println("========通过反射创建对象===========");
    Class<?> Userclass = Class.forName("pri.annotation.User");
    System.out.println(Userclass.newInstance());
    //通过反射获取含参数构造器
    System.out.println("通过反射获取含参构造器");
    Constructor<?> declaredConstructor1 = Userclass.getDeclaredConstructor(String.class, int.class);
    //含参构造器创建对象
    pri.annotation.User
        hukaiyuan = (pri.annotation.User) declaredConstructor1.newInstance("hukaiyuan", 19);
    hukaiyuan.introduce("haha");
    //通过反射拿到特定方法
    Method introduce = Userclass.getDeclaredMethod("introduce", String.class);
    introduce.invoke(hukaiyuan, "123");//第一个参数是类的实例  后面的参数是方法需要传入的参数
    //通过反射操作属性
    //如果操作私有属性  需要先把setAccessible 设置为true;
    Field sexfild = Userclass.getDeclaredField("sex");
    sexfild.setAccessible(true);
    sexfild.set(hukaiyuan, "man");
    hukaiyuan.introduce("changes");
  }
}
