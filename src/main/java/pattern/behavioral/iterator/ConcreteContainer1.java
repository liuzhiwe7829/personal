package pattern.behavioral.iterator;

/**
 * @author zhiwei.liu003
 * @date 2019/9/922:47
 */
public class ConcreteContainer1 implements Container {
    public  Integer[] arr;

    public ConcreteContainer1(){
        arr = new Integer[10];
        for(int i = 0; i< 10 ; i++)arr[i] = i;
    }
    @Override
    public Iterator getIterator() {
        return new ConcreteIterator1<Integer>();
    }

    private class  ConcreteIterator1<E> implements Iterator{
        int index;

        @Override
        public boolean hashNext() {
            if(index < arr.length)
                return  true;
            return false;
        }

        @Override
        public Object next() {
            if(hashNext())
                return  arr[index++];
            return null;
        }

    }
}
