[toc]

##### 1.示例图 线程池流程图
![image](B997B87031AF457BBD7F176509A360C9)
##### 2.有道云 markdown flow 效果图  
```
graph TB
    1(execute  执行任务)-->2{线程数是否小于coreSize?}
    2 -->|是| 2.1[创建核心线程]
    2.1-->2.1.1{创建成功}
    2.1.1-->|是| 2.1.2[不断从队列去除任务执行,直至空]
    2 -->|否| 2.2(任务尝试入队)
    2.2-->2.2.1{入队成功}
    2.2.1-->|是|2.2.1.1[存放在队列中等待着被领取]
    2.2.1-->|否|2.2.1.2[创建非核心线程]
    2.2.1.2-->2.2.1.2.1{创建成功}
    2.2.1.2.1-->|是|2.1.2
    2.2.1.2.1-->|否|2.2.1.2.2[拒绝策略]

```

##### 3. 总结
1、有道云与标准的markdown语法还是有区别，特别是流程图 flowChart 不支持，变成graph 类似这样,简单的示意图 graph可以用用，流程图还是用专业的
2、markdown 本身流程图也比较畸形

##### 4. 参考
https://mermaid-js.github.io/mermaid/#/examples
https://www.zhihu.com/question/41706270


