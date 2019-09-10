package pattern.behavioral.observer.weatherJavaInnerDemo.observers;


import pattern.behavioral.observer.weatherJavaInnerDemo.subjects.WeatherData;

import java.util.Observable;
import java.util.Observer;

/**
 * @author zhiwei.liu003
 * @date 2019/9/810:59
 */
public class CurrentConditionDisplay  implements Observer {
    private  double temperature;
    private  double humidity;
    private  double pressure;

    @Override
    public void update(Observable o, Object data) {
        this.temperature =((WeatherData.Data)data).getTemperature();
        this.humidity =((WeatherData.Data)data).getHumidity();
        this.pressure =((WeatherData.Data)data).getPressure();
        display();
    }

    private void display() {
        System.out.println("CurrentDisplay:"+temperature+
                ":"+humidity+
                ":"+pressure);
    }
}
