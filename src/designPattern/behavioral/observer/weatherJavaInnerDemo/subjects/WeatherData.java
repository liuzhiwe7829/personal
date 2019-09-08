package designPattern.behavioral.observer.weatherJavaInnerDemo.subjects;

import java.util.Observable;

/**
 * @author zhiwei.liu003
 * @date 2019/9/811:00
 * 被观察者
 */
public class WeatherData extends Observable {
    private double temperature;
    private double humidity;
    private double pressure;
    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setData(double temperature, double humidity, double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        dataChanged();
    }

    public void dataChanged() {
        this.setChanged(); //java底层boolean设置变化
        notifyObservers(new Data(temperature, humidity, pressure));//推
        //观察者自己拉数据
       // notifyObservers();
    }



    public static class Data {
        private double temperature;
        private double humidity;
        private double pressure;

        public Data(double temperature, double humidity, double pressure) {
            this.temperature = temperature;
            this.humidity = humidity;
            this.pressure = pressure;
        }

        public double getTemperature() {
            return temperature;
        }

        public double getHumidity() {
            return humidity;
        }

        public double getPressure() {
            return pressure;
        }
    }
}
