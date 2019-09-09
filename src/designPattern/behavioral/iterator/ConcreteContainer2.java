package designPattern.behavioral.iterator;

import java.util.ArrayList;

/**
 * @author zhiwei.liu003
 * @date 2019/9/922:47
 */
public class ConcreteContainer2 implements Container {
    public  ArrayList arr;

    public ConcreteContainer2(){
        arr = new ArrayList();
        for(int i = 0; i< 10 ; i++)arr.add(i);
    }
    @Override
    public Iterator getIterator() {
        return new ConcreteIterator1<Integer>();
    }

    private class  ConcreteIterator1<E> implements Iterator{
        int index;

        @Override
        public boolean hashNext() {
            if(index < arr.size())
                return  true;
            return false;
        }

        @Override
        public Object next() {
            if(hashNext())
                return  arr.get(index++);
            return null;
        }

    }
}
