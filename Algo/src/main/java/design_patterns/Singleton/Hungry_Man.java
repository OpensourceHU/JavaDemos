package design_patterns.Singleton;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 饿汉式, 即使用Java的类加载机制实现单例
 * 构造函数私有化,实例化在类加载时完成  暴露公共接口
 * @date 2022/4/13 9:46
 */
public class Hungry_Man {

    private static final Hungry_Man INSTANCE = new Hungry_Man();

    private Hungry_Man() {
    }

    public static Hungry_Man getInstance() {
        return INSTANCE;
    }

}
