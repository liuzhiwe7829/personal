[toc]
#### 问题
##### 有哪些Map？还有啥Map？用的jdk几？
##### 说一下HashMap数据结构，put值散列冲突怎么解决？
##### 链表树化转移数量？为什么是8为什么是6？？
##### 为什么数组要是二次幂？
##### 怎么扩容的？扩容rehash的流程？
##### concurrentHashMap的散列流程？
##### concurrentHashMap怎么实现的线程安全？CAS什么意思，怎么实现的？Unsafe怎么实现？
##### concurrentHashMap什么时候用到CAS？并发情况下两个线程都到之后怎么插入的？
#####初始化的时候两个线程都检测到需要初始化了，然后怎么做的？

#### map类型
```
Map->HashMap   ->1.7、1.8
->HashTable
->LinkedHashMap
->TreeMap
->ConcurrentHashMap
```
#### hashMap
```
结构 HashMap 数据+链表/红黑树
put值散列冲突怎么解决->哈希冲突？
线性探测法（Linear Probing）
链表法  ------
链表树化转移数量？为什么是8为什么是6？
统计概率 泊松分布统计 --
8、6避免来回转化
```

##### 为什么数组要是二次幂？
```


```













































