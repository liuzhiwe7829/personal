package designPattern.behavioral.observer.weatherDemo.subjects;

/**
 * @author zhiwei.liu003
 * @date 2019/9/89:56
 */

import designPattern.behavioral.observer.weatherDemo.observers.Observer;

/**
 * 被观察者接口
 */
public interface Subject {
    void registerObserver(Observer o); //注册
    void removeObservers(Observer o); //移除
    void  notifyObservers();//通知
}
