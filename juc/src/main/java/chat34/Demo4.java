package chat34;

import com.google.common.util.concurrent.*;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 跟着阿里p7学并发，微信公众号：javacode2018
 */
@Slf4j
public class Demo4 {
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
            ListenableFuture<List<Integer>> listListenableFuture = Futures.allAsList(futureList);
            Futures.addCallback(listListenableFuture, new FutureCallback<List<Integer>>() {
                @Override
                public void onSuccess(@Nullable List<Integer> result) {
                    log.info("result中所有结果之和：" + result.stream().reduce(Integer::sum).get());
                }

                @Override
                public void onFailure(Throwable t) {
                    log.error("执行任务发生异常:" + t.getMessage(), t);
                }
            }, MoreExecutors.directExecutor());
        } finally {
            delegate.shutdown();
        }
    }
    /**
     * 代码中异步执行了一批任务，所有任务完成之后，回调了上面的onSuccess方法，内部对所有的结果进行sum操作
     */
}