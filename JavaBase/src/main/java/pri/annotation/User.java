package pri.annotation;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 定义一个便于测试的类
 * @date 2020/5/26 0026 11:06
 */
public class User {
    String name;
    int id;
    private String sex;

    public User() {
    }

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void introduce(String a) {
        System.out.println(a);
        System.out.println(this.name + " " + this.id + " " + this.sex);
    }
}
