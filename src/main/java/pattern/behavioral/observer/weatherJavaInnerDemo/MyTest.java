package pattern.behavioral.observer.weatherJavaInnerDemo;

import pattern.behavioral.observer.weatherJavaInnerDemo.observers.CurrentConditionDisplay;
import pattern.behavioral.observer.weatherJavaInnerDemo.observers.TomorrowConditionDisplay;
import pattern.behavioral.observer.weatherJavaInnerDemo.subjects.WeatherData;

/**
 * @author zhiwei.liu003
 * @date 2019/9/810:59
 */
public class MyTest {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();// 创建被观察者

        // 创建两个观察者
        CurrentConditionDisplay current = new CurrentConditionDisplay();
        TomorrowConditionDisplay tomorrow = new TomorrowConditionDisplay();

        weatherData.addObserver(current);
        weatherData.addObserver(tomorrow);

        weatherData.setData(11,222,33);

        System.out.println("----------移除Tomorrow公告板----------");
        weatherData.deleteObserver(tomorrow);
        weatherData.setData(22,444,66);
    }
}

