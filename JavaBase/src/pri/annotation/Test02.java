package pri.annotation;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 加载器classloader
 * @date 2020/5/26 0026 9:59
 */
public class Test02 {
  public static void main(String[] args) {
    //获取系统类加载器
    ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
    System.out.println(systemClassLoader);
    //获取系统类加载器的父类加载器-->扩展类加载器
    ClassLoader systemClassLoaderParent = systemClassLoader.getParent();
    System.out.println(systemClassLoaderParent);
    //获取扩展类加载器的父加载器-->根类加载器/启动类加载器
    ClassLoader rootclassloader = systemClassLoaderParent.getParent();
    System.out.println(rootclassloader);//c++写的  找不到类

    //自顶向下尝试加载类
    //双亲委派机制:尽可能地让上级加载器去加载
    //Boot>Extension>System>自定义

  }
}
