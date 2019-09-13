package pattern.behavioral.observer.weatherDemo.observers;

/**
 * @author zhiwei.liu003
 * @date 2019/9/89:56
 */
public class TomorrowConditionDisplay implements Observer {
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
        System.out.println("TommorrowDisplay:" + temperature * ((int) (10 * Math.random()) / 2 + 1) +
                ":" + humidity * ((int) (10 * Math.random()) / 2 + 1) +
                ":" + pressure * ((int) (10 * Math.random()) / 2 + 1));

    }

}
