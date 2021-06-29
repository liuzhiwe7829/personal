
```
#slave
daemonize yes
#默认情况下redis不是作为守护进程运行的，如果你想让它在后台运行，你就把它改成yes.当redis作为守护进程运行的时候，它会写一个pid到/var/run/redis.pid文件里面
pidfile "/mwbase/appsystem/Redis/redis-cluster/6379/redis_6379.pid"
#配置PID文件路径，当redis作为守护线程运行时，它会把pid默认写到/var/run/redis_6379.pid里面
port 6379
timeout 0
#指定在一个client空闲多少秒之后关闭连接（0表示永不关闭）
maxclients 10000
#  设置客户端最大并发连接数，默认无限制，Redis可以同时打开的客户端连接数为Redis进程可以打开的最大文件
#  描述符数-32（redis server自身会使用一些），如果设置 maxclients为0
#  表示不作限制。当客户端连接数到达限制时，Redis会关闭新的连接并向客户端返回max number of clients reached错误信息
tcp-keepalive 0
#单位是秒，表示将周期性的使用SO_KEEPALIVE检测客户端是否还处于健康状态，避免服务器一直阻塞，官方给出的建议值是300s，如果设置为0，则不会周期性的检测
loglevel notice
#定义日志级别。
#  可以是下面的这些值：
#  debug（记录大量日志信息，适用于开发、测试阶段）
#  verbose（较多日志信息）
#  notice（适量日志信息，使用于生产环境）
#  warning（仅有部分重要、关键信息才会被记录）
logfile "/mwbase/applogs/rtlog/redis.log"
#日志文件的位置，当指定为空字符串时，为标准输出，如果redis已守护进程模式运行，那么日志将会输出到/dev/null
databases 16
#设置数据库的数目。默认的数据库是DB 0 ，可以在每个连接上使用select  <dbid> 命令选择一个不同的数据库，dbid是一个介于0到databases - 1 之间的数值。
save 900 1
save 300 10
save 60 10000
#存 DB 到磁盘：
#    格式：save <间隔时间（秒）> <写入次数>
#    根据给定的时间间隔和写入次数将数据保存到磁盘
#    下面的例子的意思是：
#    900 秒内如果至少有 1 个 key 的值变化，则保存
#    300 秒内如果至少有 10 个 key 的值变化，则保存
#    60 秒内如果至少有 10000 个 key 的值变化，则保存　
#    注意：你可以注释掉所有的 save 行来停用保存功能。
#    也可以直接一个空字符串来实现停用：
#    save ""
stop-writes-on-bgsave-error yes
#  如果用户开启了RDB快照功能，那么在redis持久化数据到磁盘时如果出现失败，默认情况下，redis会停止接受所有的写请求。
#  这样做的好处在于可以让用户很明确的知道内存中的数据和磁盘上的数据已经存在不一致了。
#  如果redis不顾这种不一致，一意孤行的继续接收写请求，就可能会引起一些灾难性的后果。
#  如果下一次RDB持久化成功，redis会自动恢复接受写请求。
#  如果不在乎这种数据不一致或者有其他的手段发现和控制这种不一致的话，可以关闭这个功能，
#  以便在快照写入失败时，也能确保redis继续接受新的写请求。
rdbcompression yes
#  对于存储到磁盘中的快照，可以设置是否进行压缩存储。
#  如果是的话，redis会采用LZF算法进行压缩。如果你不想消耗CPU来进行压缩的话，
#  可以设置为关闭此功能，但是存储在磁盘上的快照会比较大。
rdbchecksum yes
#  在存储快照后，我们还可以让redis使用CRC64算法来进行数据校验，但是这样做会增加大约10%的性能消耗，
#  如果希望获取到最大的性能提升，可以关闭此功能。
dbfilename "dump.rdb"
# 设置快照的文件名
dir "/mwbase/appsystem/Redis/redis-4.0.9"
#主节点密码
masterauth "123456"
#如果master需要密码认证，就在这里设置，默认不设置
slave-serve-stale-data yes
slave-read-only yes
repl-disable-tcp-nodelay no
#  同步之后是否禁用从站上的TCP_NODELAY
#  如果你选择yes，redis会使用较少量的TCP包和带宽向从站发送数据。但这会导致在从站增加一点数据的延时。
#  Linux内核默认配置情况下最多40毫秒的延时。
#  如果选择no，从站的数据延时不会那么多，但备份需要的带宽相对较多。
#  默认情况下我们将潜在因素优化，但在高负载情况下或者在主从站都跳的情况下，把它切换为yes是个好主意。
slave-priority 98
requirepass "123456"
appendonly yes
#  默认redis使用的是rdb方式持久化，这种方式在许多应用中已经足够用了。但是redis如果中途宕机，
#  会导致可能有几分钟的数据丢失，根据save来策略进行持久化，Append Only File是另一种持久化方式，
#  可以提供更好的持久化特性。Redis会把每次写入的数据在接收后都写入appendonly.aof文件，
#  每次启动时Redis都会先把这个文件的数据读入内存里，先忽略RDB文件。
# appendfsync always
appendfsync everysec
# appendfsync no
#  aof持久化策略的配置
#  no表示不执行fsync，由操作系统保证数据同步到磁盘，速度最快。
#  always表示每次写入都执行fsync，以保证数据同步到磁盘。
#  everysec表示每秒执行一次fsync，可能会导致丢失这1s数据
no-appendfsync-on-rewrite no
#   在aof重写或者写入rdb文件的时候，会执行大量IO，此时对于everysec和always的aof模式来说，
#   执行fsync会造成阻塞过长时间，no-appendfsync-on-rewrite字段设置为默认设置为no。
#   如果对延迟要求很高的应用，这个字段可以设置为yes，否则还是设置为no，这样对持久化特性来说这是更安全的选择。
#   设置为yes表示rewrite期间对新写操作不fsync,暂时存在内存中,等rewrite完成后再写入，默认为no，建议yes。
#   Linux的默认fsync策略是30秒。可能丢失30秒数据。
auto-aof-rewrite-percentage 100
#  aof自动重写配置，当目前aof文件大小超过上一次重写的aof文件大小的百分之多少进行重写，
#  即当aof文件增长到一定大小的时候，Redis能够调用bgrewriteaof对日志文件进行重写。
#  当前AOF文件大小是上次日志重写得到AOF文件大小的二倍（设置为100）时，自动启动新的日志重写过程。
auto-aof-rewrite-min-size 64mb
设置允许重写的最小aof文件大小，避免了达到约定百分比但尺寸仍然很小的情况还要重写
lua-time-limit 5000
#  如果达到最大时间限制（毫秒），redis会记个log，然后返回error。当一个脚本超过了最大时限。
#  只有SCRIPT KILL和SHUTDOWN NOSAVE可以用。第一个可以杀没有调write命令的东西。
#  要是已经调用了write，只能用第二个命令杀
slowlog-log-slower-than 10000
# slog log是用来记录redis运行中执行比较慢的命令耗时。
# 当命令的执行超过了指定时间，就记录在slow log中，slog log保存在内存中，所以没有IO操作。
# 执行时间比slowlog-log-slower-than大的请求记录到slowlog里面，单位是微秒，所以1000000就是1秒。
# 注意，负数时间会禁用慢查询日志，而0则会强制记录所有命令。
slowlog-max-len 128
#慢查询长度。当一个新的命令被写进日志的时候，最老的那个记录会被删掉，这个长度没有限制。
#只要有足够的内存就行，你可以通过SLOWLOG RESET来释放内存
notify-keyspace-events ""
#键空间通知使得客户端可以通过订阅频道或模式，来接收那些以某种方式改动了 Redis 数据集的事件。因为开启键空间通知功能需要消耗一些 CPU ，所以在默认配置下，该功能处于关闭状态。
# notify-keyspace-events 的参数可以是以下字符的任意组合，它指定了服务器该发送哪些类型的通知：
#  K 键空间通知，所有通知以 __keyspace@__ 为前缀
#  E 键事件通知，所有通知以 __keyevent@__ 为前缀
#  g DEL 、 EXPIRE 、 RENAME 等类型无关的通用命令的通知
#  $ 字符串命令的通知
#  l 列表命令的通知
#  s 集合命令的通知
#  h 哈希命令的通知
#  z 有序集合命令的通知
#  x 过期事件：每当有过期键被删除时发送
#  e 驱逐(evict)事件：每当有键因为 maxmemory 政策而被删除时发送
#  A 参数 g$lshzxe 的别名
# 输入的参数中至少要有一个 K 或者 E，否则的话，不管其余的参数是什么，都不会有任何 通知被分发。
hash-max-ziplist-entries 512
# hash类型的数据结构在编码上可以使用ziplist和hashtable。
# ziplist的特点就是文件存储(以及内存存储)所需的空间较小,在内容较小时,性能和hashtable几乎一样。
# 因此redis对hash类型默认采取ziplist。如果hash中条目的条目个数或者value长度达到阀值,将会被重构为hashtable。
# 这个参数指的是ziplist中允许存储的最大条目个数，，默认为512，建议为128
hash-max-ziplist-value 64
# ziplist中允许条目value值最大字节数，默认为64，建议使用1024
list-max-ziplist-entries 512
list-max-ziplist-value 64
set-max-intset-entries 512
zset-max-ziplist-entries 128
zset-max-ziplist-value 64
activerehashing yes
#  Redis将在每100毫秒时使用1毫秒的CPU时间来对redis的hash表进行重新hash，可以降低内存的使用。
#  当你的使用场景中，有非常严格的实时性需要，不能够接受Redis时不时的对请求有2毫秒的延迟的话，把这项配置为no。
#  如果没有这么严格的实时性要求，可以设置为yes，以便能够尽可能快的释放内存
client-output-buffer-limit normal 0 0 0
# 对客户端输出缓冲进行限制可以强迫那些不从服务器读取数据的客户端断开连接，用来强制关闭传输缓慢的客户端。
# 对于normal client，第一个0表示取消hard limit，第二个0和第三个0表示取消soft limit，normal client默认取消限制，因为如果没有寻问，他们是不会接收数据的
client-output-buffer-limit slave 256mb 64mb 60
client-output-buffer-limit pubsub 32mb 8mb 60
hz 10
# redis执行任务的频率为1s除以hz
aof-rewrite-incremental-fsync yes
# 在aof重写的时候，如果打开了aof-rewrite-incremental-fsync开关，系统会每32MB执行一次fsync。
# 这对于把文件写入硬盘是有帮助的，可以避免过大的延迟峰值
# Generated by CONFIG REWRITE
#配置主节点信息
slaveof 192.168.26.55 6379
```
