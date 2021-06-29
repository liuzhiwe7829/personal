```
@RestController
public class RedisLockController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/testRedis")
    public String testRedis(){
        String lockKey = "lockKey";
        String clientId = UUID.randomUUID().toString(); //防止 自己线程加的锁，总是有可能被别的线程删掉
        try {
            //设值和设置过期必须是 原子性的操作
            Boolean res = stringRedisTemplate.opsForValue().setIfAbsent(lockKey, clientId, 10, TimeUnit.SECONDS);
            if(!res){
                return "error";
            }
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock")); //jedis.get()
            if(stock > 0){
                int newStock = stock-1;
                stringRedisTemplate.opsForValue().set("stock", newStock + "");
                System.out.println("扣减成功, 剩余库存: " + newStock + "");
            }else{
                System.out.println("扣减失败, 库存不足");
            }
        }finally {
            //解锁 , 就是判断这把锁是不是自己加的
            if(clientId.equals(stringRedisTemplate.opsForValue().get(lockKey))){
                stringRedisTemplate.delete(lockKey);
            }
        }
        return "success";
    }
}
```

![image](DAEDF9936E8A4EC5A73EA56E4E915B2B)
```
@RestController
public class RedissonLockController {

    @Autowired
    Redisson redisson;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/testRedisson")
    public String testRedis() throws InterruptedException {
        String lockKey = "lockKey";
        String clientId = UUID.randomUUID().toString();
        RLock lock = redisson.getLock(lockKey); // 得到锁
        try {
            lock.tryLock(30, TimeUnit.SECONDS); // 超时时间
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock")); //jedis.get()
            if (stock > 0) {
                int newStock = stock - 1;
                stringRedisTemplate.opsForValue().set("stock", newStock + "");
                System.out.println("扣减成功, 剩余库存: " + newStock + "");
            } else {
                System.out.println("扣减失败, 库存不足");
            }
        } finally {
            lock.unlock();
        }
        return "success";
    }
}
```