package pattern.behavioral.observer.weatherJavaInnerDemo.observers;


import pattern.behavioral.observer.weatherJavaInnerDemo.subjects.WeatherData;

import java.util.Observable;
import java.util.Observer;

/**
 * @author zhiwei.liu003
 * @date 2019/9/811:00
 */
public class TomorrowConditionDisplay  implements Observer {
    private  double temperature;
    private  double humidity;
    private  double pressure;

    @Override
    public void update(Observable o, Object data) {
        //两种更新方式 "推"|"拉"
        //推过来
//        this.temperature =((WeatherData.Data)data).getTemperature();
//        this.humidity =((WeatherData.Data)data).getHumidity();
//        this.pressure =((WeatherData.Data)data).getPressure();

        //拉过来
        this.temperature =((WeatherData)o).getTemperature();
        this.humidity =((WeatherData)o).getHumidity();
        this.pressure =((WeatherData)o).getPressure();
        display();

    }

    private void display() {
        System.out.println("CurrentDisplay:"+temperature+
                ":"+humidity+
                ":"+pressure);
    }
}
