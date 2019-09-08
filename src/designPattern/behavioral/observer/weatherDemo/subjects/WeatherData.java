package designPattern.behavioral.observer.weatherDemo.subjects;

import designPattern.behavioral.observer.weatherDemo.observers.Observer;

import java.util.ArrayList;

/**
 * @author zhiwei.liu003
 * @date 2019/9/89:57
 * 被观察者的实现
 * 里边有：
 * 1、观察者的集合数据结构
 * 2、实现添加观察方法（registerObservers）
 * 3、移除观察者方法（removerObservers）
 * 4、通知所有观察者的方法（notifyObservers）
 */
public class WeatherData implements Subject {
    private double temperature;
    private double humidity;
    private double pressure;

    //可以提供getter()方法
    private ArrayList<Observer> observers;

    public WeatherData() {
        observers = new ArrayList<>();
    }
    public  void  setData(double temperature,double humidity ,double pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        dataChanged();//更新完信息就马上通知观察者
    }
    //数据改变后就通知观察者（从气象站的到更新后的观测值，通知观察者）
    public void dataChanged (){
        notifyObservers();
    }
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObservers(Observer o) {
        int index = observers.indexOf(o);
        if(index >= 0){
            observers.remove(o);
        }
    }

    @Override
    public void notifyObservers() {
        for(int i =0 ; i< observers.size();i++){
            Observer observer = observers.get(i);
            observer.update(temperature,humidity,pressure);
        }
    }
}
