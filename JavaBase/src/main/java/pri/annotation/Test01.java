package pri.annotation;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 测试类什么时候会初始化
 * @date 2020/5/26 0026 9:27
 */
public class Test01 {
    static {
        System.out.println("static class Init====");
    }

    public static void main(String[] args) {
        //     new son();//主动引用

//        不会产生类的引用的方法 3 种
//        子类引用的是父类的static变量 不会初始化子类
        System.out.println(son.a);
//        子类常量池中的数据 连接时就进入常量池了
//        直接用  不会触发类初始化
        System.out.println(son.c);
//        创建数组的时候 并没有初始化类
//        只是开辟了数组空间
        son[] arr = new son[10];

    }
}

class father {
    static int a = 1;

    static {
        System.out.println("father has been init");
    }
}

class son extends father {
    static int b = 100;
    final static int c = 10;
    String name;
    int ID;

    public son() {
    }

    public son(String name) {
        this.name = name;
    }

    public son(int ID) {
        this.ID = ID;
    }

    static {
        System.out.println("son has been init");
    }
}