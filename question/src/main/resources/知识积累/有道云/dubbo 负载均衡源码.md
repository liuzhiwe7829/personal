[toc]
```
RandomLoadBalance:随机负载均衡。随机的选择一个。是Dubbo的默认负载均衡策略。
RoundRobinLoadBalance:轮询负载均衡。轮询选择一个。
LeastActiveLoadBalance:最少活跃调用数，相同活跃数的随机。活跃数指调用前后计数差。
使慢的 Provider 收到更少请求，因为越慢的 Provider 的调用前后计数差会越大。
ConsistentHashLoadBalance:一致性哈希负载均衡。相同参数的请求总是落在同一台机器上。
```


```
public class RandomLoadBalance extends AbstractLoadBalance {

    private final Random random = new Random();

    protected <T> Invoker<T> doSelect(List<Invoker<T>> invokers, URL url, Invocation invocation) {
        int length = invokers.size();      // Invoker 总数
        int totalWeight = 0;               // 所有 Invoker 的权重的和

        // 判断是不是所有的 Invoker 的权重都是一样的
        // 如果权重都一样，就简单了。直接用Random生成索引就可以了。
        boolean sameWeight = true;
        for (int i = 0; i < length; i++) {
            int weight = getWeight(invokers.get(i), invocation);
            totalWeight += weight; // Sum
            if (sameWeight && i > 0 && weight != getWeight(invokers.get(i - 1), invocation)) {
                sameWeight = false;
            }
        }

        if (totalWeight > 0 && !sameWeight) {
            // 如果不是所有的 Invoker 权重都相同，那么基于权重来随机选择。权重越大的，被选中的概率越大
            int offset = random.nextInt(totalWeight);
            for (int i = 0; i < length; i++) {
                offset -= getWeight(invokers.get(i), invocation);
                if (offset < 0) {
                    return invokers.get(i);
                }
            }
        }
        // 如果所有 Invoker 权重相同
        return invokers.get(random.nextInt(length));
    }
}
```