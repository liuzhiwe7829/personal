package designPattern.behavioral.iterator;

import java.util.ArrayList;

/**
 * @author zhiwei.liu003
 * @date 2019/9/922:53
 */
public class MyTest {

    public  static  void main(String[] args){
        Container c1 = new ConcreteContainer1();
        Container c2 = new ConcreteContainer2();

        ArrayList<Iterator> its = new ArrayList<>();
        its.add(c1.getIterator());
        its.add(c2.getIterator());

        //实现统一遍历，将迭代器加入到its中
        for(Iterator it :its){
            while (it.hashNext()){
                System.out.print(it.next()+"");
            }
            System.out.println();
        }
    }
}
