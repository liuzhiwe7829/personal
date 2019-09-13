package pattern.structure.proxy.tankDemo;

/**
 * @author zhiwei.liu003
 * @date 2019/9/923:45
 */
public class TankLogProxy implements Movable {
    private  Movable tank;
    public  TankLogProxy(Movable tank){
        this.tank = tank;
    }
    @Override
    public void move() {
        System.out.println("Tank Log start------------");
        tank.move();
        System.out.println("Tank Log end------------");

    }
}
