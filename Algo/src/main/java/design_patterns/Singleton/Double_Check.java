package design_patterns.Singleton;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description 双重判空的懒加载机制
 * @date 2022/4/13 9:49
 */
public class Double_Check {
  //加上volatile 禁止指令重排
  private static volatile Double_Check INSTANCE = null;

  private Double_Check() {
  }

  public Double_Check getInstance() {
    if (INSTANCE == null) {
      //在加锁与第一次判空期间  可能有别的线程率先完成了实例化  因此需要在加锁后二次判断
      synchronized (Double_Check.class) {
        if (INSTANCE == null) {
          INSTANCE = new Double_Check();
        }
      }
    }
    return INSTANCE;
  }
}
