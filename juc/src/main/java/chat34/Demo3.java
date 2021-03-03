package chat34;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * 跟着阿里p7学并发，微信公众号：javacode2018
 */
@Slf4j
public class Demo3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        log.info("star");
        ExecutorService delegate = Executors.newFixedThreadPool(5);
        try {
            ListeningExecutorService executorService = MoreExecutors.listeningDecorator(delegate);
            List<ListenableFuture<Integer>> futureList = new ArrayList<>();
            for (int i = 5; i >= 0; i--) {
                int j = i;
                futureList.add(executorService.submit(() -> {
                    TimeUnit.SECONDS.sleep(j);
                    return j;
                }));
            }
            //获取一批任务的执行结果
            List<Integer> resultList = Futures.allAsList(futureList).get();
            //输出
            resultList.forEach(item -> {
                log.info("{}", item);
            });
        } finally {
            delegate.shutdown();
        }
    }
    /**
     * 结果中按顺序输出了6个异步任务的结果，此处用到了Futures.allAsList方法，看一下此方法的声明：
     *
     * public static <V> ListenableFuture<List<V>> allAsList(
     *       Iterable<? extends ListenableFuture<? extends V>> futures)
     * 传递一批ListenableFuture，返回一个ListenableFuture<List<V>>，内部将一批结果转换为了一个ListenableFuture对象。
     */
}