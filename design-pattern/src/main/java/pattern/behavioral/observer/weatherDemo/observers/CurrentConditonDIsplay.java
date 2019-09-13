package pattern.behavioral.observer.weatherDemo.observers;

/**
 * @author zhiwei.liu003
 * @date 2019/9/89:55
 */
public class CurrentConditonDIsplay implements Observer {
    private double temperature;
    private double humidity;
    private double pressure;

    @Override
    public void update(double temperature, double humidity, double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    public void display() {
        System.out.println("CurrentDisplay:" + temperature + ":" + humidity + ":" + pressure);
    }
}
