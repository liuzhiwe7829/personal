package pattern.create.singleton;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author zhiwei.liu003
 * @date 2019/9/1020:59
 * 静态内部类实现
 */
public class Singleton06 {

    private Singleton06(){

    }
    private static Singleton06 newInstance() {
        return Sing.INSTANCE.newInstance();
    }
    private  enum  Sing{
        INSTANCE;
        private  Singleton06 singleton06;
        Sing() {
            singleton06 = new Singleton06();
        }
        public  Singleton06 newInstance(){
            return  singleton06;
        }
    }
    public  static  int clientTotal = 1000;
    public  static  int threadTotal = 200;
    public static  void main(String[] args)throws InterruptedException{
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(threadTotal);
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        Set<Singleton06> set = Collections.synchronizedSet(new HashSet<>());

        for(int i = 0 ; i< clientTotal ; i++){
            executorService.execute(()->{
                try
                {
                    semaphore.acquire();
                    set.add(Singleton06.newInstance());
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
            countDownLatch.await();
            executorService.shutdown();
            System.out.println(set.size());
        }
    }


}
