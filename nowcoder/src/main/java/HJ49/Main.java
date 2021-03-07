package HJ49;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @author zhiwei.liu003
 * @date 2021/3/623:22
 */
public class Main {
    public  static void main(String [] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int size = in.nextInt();
            char[] arr =new char[size*4];
            CountDownLatch cdl = new CountDownLatch(4);
            Semaphore a = new Semaphore(1);
            Semaphore b = new Semaphore(0);
            Semaphore c = new Semaphore(0);
            Semaphore d = new Semaphore(0);
            new Thread(()->{
                for(int i = 0 ;i<arr.length;i+=4){
                    try {
                        a.acquire();
                    }catch (Exception e){}
                        arr[i] = 'A';
                        b.release();
                }
                cdl.countDown();
            }).start();
            new Thread(()->{
                for(int i = 1 ;i<arr.length;i+=4){
                    try {
                        b.acquire();
                    }catch (Exception e){}
                        arr[i] = 'B';
                        c.release();
                }
                cdl.countDown();
            }).start();
            new Thread(()->{
                for(int i = 2 ;i<arr.length;i+=4){
                    try {
                        c.acquire();
                    }catch (Exception e){}
                    arr[i] = 'C';
                    d.release();
                }
                cdl.countDown();
            }).start();
            new Thread(()->{
                for(int i = 3 ;i<arr.length;i+=4){
                    try {
                        d.acquire();
                    }catch (Exception e){}
                    arr[i] = 'D';
                    a.release();
                }
                cdl.countDown();
            }).start();

            try {
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (char c1:arr){
                System.out.print(c1);
            }
            System.out.println();
        }
    }
}
