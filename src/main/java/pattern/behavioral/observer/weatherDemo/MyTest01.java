package pattern.behavioral.observer.weatherDemo;

import designPattern.behavioral.observer.weatherDemo.observers.CurrentConditonDIsplay;
import designPattern.behavioral.observer.weatherDemo.observers.TomorrowConditionDisplay;
import designPattern.behavioral.observer.weatherDemo.subjects.WeatherData;

/**
 * @author zhiwei.liu003
 * @date 2019/9/89:58
 */
public class MyTest01 {
    public static  void main(String [] args){
        //创建一个被观察者
        WeatherData weatherData = new WeatherData();

        //创建两个观察者（Observer实现类）
        CurrentConditonDIsplay currentConditonDIsplay = new CurrentConditonDIsplay();
        TomorrowConditionDisplay tomorrowConditionDisplay = new TomorrowConditionDisplay();

        //在被观察者的List中注册两个观察者
        weatherData.registerObserver(currentConditonDIsplay);
        weatherData.registerObserver(tomorrowConditionDisplay);

        //设置完（天气更新）就会通知两个观察者
        weatherData.setData(10,100,50);


        System.out.println("-----------------移除Tommorrow公告板----------------");
        weatherData.removeObservers(tomorrowConditionDisplay);
        weatherData.setData(20,200,25);
    }
}
