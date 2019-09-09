package designPattern.behavioral.iterator;

/**
 * @author zhiwei.liu003
 * @date 2019/9/922:53
 */
public interface Iterator<E> {
    boolean hashNext();
    E next();
}
