package pattern.structure.proxy.tankDemo;

/**
 * @author zhiwei.liu003
 * @date 2019/9/923:42
 */
public class TankTimeProxy implements Movable {
    private Movable tank;

    public TankTimeProxy(Movable tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        System.out.println("start time : " + start);

        tank.move();

        long end = System.currentTimeMillis();
        System.out.println("ent time : " + end);
        System.out.println("spend all time :" + (end - start));

    }
}
