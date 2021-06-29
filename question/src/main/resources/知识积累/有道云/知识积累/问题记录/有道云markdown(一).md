[toc]
#### 1、流程图graph
##### 1.1 图示
```
graph LR
A-->B
A-->B
B-->C
B-->C
B-->D(大刘)
B-->E>意呆利]
```
##### 1.2 编码
```
## 
graph LR
A-->B
A-->B
B-->C
B-->C
B-->D
B-->E
```
##### 1.3 解释
###### 1.3.1 图方向
```
图方向 
TB，从上到下
TD，从上到下
BT，从下到上
RL，从右到左
LR，从左到右
T = TOP，B = BOTTOM，L = LEFT，R = RIGHT，D = DOWN
```
###### 1.3.2 节点类型
```
默认节点 A
文本节点 B[bname]
圆角节点 C(cname)
圆形节点 D((dname))
非对称节点 E>ename]
菱形节点 F{fname}
A~F 是当前节点名字，类似于变量名，画图时便于引用
[b~f]name是节点中显示的文字，默认节点的名字和显示的文字都为A
```
###### 1.3.3 连线类型
```
graph TD
  A1-->B1
  A2---B2
  A3--text---B3
  A4--text-->B4
  A5-.-B5
  A6-.->B6
  A7-.text.-B7
  A8-.text.->B8
  A9===B9
  A10==>B10
  A11==text===B11
  A12==text==>B12
```

```
箭头连接 A1–->B1
开放连接 A2—B2
标签连接 A3–text—B3
箭头标签连接 A4–text–>B4
虚线开放连接 A5.-B5
虚线箭头连接 A6-.->B6
标签虚线连接 A7-.text.-B7
标签虚线箭头连接 A8-.text.->B8
粗线开放连接 A9===B9
粗线箭头连接 A10==>B10
标签粗线开放连接 A11==text===B11
标签粗线箭头连接 A12==text==>B12
```
##### 2 subgraph（子图）
```
graph LR
  subgraph g1
    a1-->b1
  end
  subgraph g2
    a2-->b2
  end
  subgraph g3
    a3-->b3
  end
  a3-->a2
  b2-->a1
  b2-->b1
```
```

graph LR
  subgraph g1
    a1-->b1
  end
  subgraph g2
    a2-->b2
  end
  subgraph g3
    a3-->b3
  end
  a3-->a2
  b2-->a1
  b2-->b1
```

```

```

##### 参考
https://blog.csdn.net/lis_12/article/details/80693975