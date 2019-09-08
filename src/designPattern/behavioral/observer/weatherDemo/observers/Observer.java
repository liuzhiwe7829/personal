package designPattern.behavioral.observer.weatherDemo.observers;

/**
 * @author zhiwei.liu003
 * @date 2019/9/89:56
 * 观察者接口
 */
public interface Observer {
    void update(double temperature, double humidity, double pressure);
}
