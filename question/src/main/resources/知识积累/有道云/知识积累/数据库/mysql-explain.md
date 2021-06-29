
#### 查询sql
```
explain SELECT t.* from prop_order t 
```
#### 结果
![image](BA34E8EE18C34F948EDCF6B1B237E9CA)
#### 分析
```
id:
    1.id相同时，执行顺序由上至下
    2.子查询，id序号递增，id值越大优先级越高，越先被执行
    3.id如果相同，可以认为是一组，从上往下顺序执行；在所有组中，id值越大，优先值越高
select_type:SIMPLE --查询类型（简单查询、联合查询、子查询）
table: t 属于哪张表，如果有别名显示别名
type: ALL 代表扫描了全表确定结果，一般保证查询至少达到range级别，最好能达到ref。
    从最好到最差的连接类型为：system>const>eq_ref>ref>fulltext>ref_or_null>index_merge>unique_subquery>index_subquery>range>index>ALL 
    const 代表一次就命中
possible_keys:指出MySql能使用哪个索引在该表中找到行。空则表示没有相关索引，这时要提高性能，可通过检验where子句，
看是否引用某些字段，或者检查字段否是索引
key:  ---实际使用到的索引。如果null ，则没有使用索引，如果为primary，表示使用了主键。
key_len:  --最长的索引宽度。如果键是null，长度就是null。在不损失精确性的情况下，长度越短越好。
ref:const ---显示那个字段或者常数与key一起被使用。
rows: 表示mysql 要遍历多少数据才能找到，innodb上是不准确的
Extra: Using where;Using index --- 执行状态说明
```
#### 补充
##### select_tpye
```
1. simple:简单select(不使用union或者子查询)
2. primary:最外面的select。
3. union:union中的第二个或后面的select语句。
4. dependent union:union中的第二个或者后面select语句，取决于外面的查询。
5. union result:union的结果
6. subquery:子查询中的第一个select
7. dependent subquery:子查询中的第一个select,取决于外面的查询
8. derived:导出表的select(from字句的子查询)
```
##### type
```
对表的访问方式，标识mysql在表中找到所需行的方式，又称访问类型
常用的类型:ALL、index、range、ref、eq_ref、const、system、NULL
ALL:Full Table Scan ,MySql遍历全表
index:Full Index Scan,index与All区别只遍历索引树
range:只检索给定范围的行，使用一个索引来选择行
ref:表示上述表的连接匹配条件，即哪些列或常量被用于查找索引列上的值
eq_ref:类似ref,区别就在使用的索引是唯一索引，对于每个索引键值，表中只有一条记录匹配，简单来说，就是多表连接中使用primary key或者unique key作为关联条件
const、system:当Mysql对查询某部分进行优化，并转化为一个常量时，使用这些类型访问。如将主键置于where列表中，MySql就能将改查询转换为一个常量，system是const类型特例，当查询的表只有一行的情况下，使用system
null:mysql在优化过程中分解语句，执行时甚至不用访问表或索引，例如从一个索引列表选取最小值可以通过单独索引查找完成
```


