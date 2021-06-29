[toc]

### 版本信息 
```
kie-wb、kie-server 7.28
wildfly 14.0.0
```
### 地址
```
workbeanch  
workbench/workbench!
http://192.168.13.60:8080/kie-wb/kie-wb.jsp?locale=zh_CN

部署机器  ----此机器临时使用 -- 资源不足，后续请单独申请资源
192.168.13.60 mwuser/mwuser

kie-wb、kie-server 7.28
wildfly 14.0.0


192.168.26.183
192.168.26.184
192.168.26.185
用户密码均为mwuser/mwuser


```

### 启动
```
./standalone.sh -c standalone-full.xml &
```
### 外网访问
```
修改
/mwbase/appsystem/wildfly-23.0.0.Final/standalone/configuration
standalone.xml standalone-full.xml 
    <interface name="management">
       <!--  <inet-address value="${jboss.bind.address.management:127.0.0.1}"/>-->
    <any-address/>
    </interface>
    <interface name="public">
        <!-- <inet-address value="${jboss.bind.address:127.0.0.1}"/> -->
    <any-address/>
    </interface>

```
### 增加用户
```
./add-user.sh
jboss /jboss 
```
workbench 用户 ，kie用户
```
linux
./add-user.sh -a -u workbench -p workbench! -g admin,kie-server,rest-all
windos
.\add-user.bat -a -u workbench -p workbench! -g admin,kie-server,rest-all
```
### jvm 修改
```
/mwbase/appsystem/wildfly-23.0.0.Final/bin
vi standalone.conf

#
# Specify options to pass to the Java VM.
#
if [ "x$JAVA_OPTS" = "x" ]; then
   JAVA_OPTS="-Xms64m -Xmx1024m -XX:MetaspaceSize=96M -XX:MaxMetaspaceSize=256m -Djava.net.preferIPv4Stack=true"
   JAVA_OPTS="$JAVA_OPTS -Djboss.modules.system.pkgs=$JBOSS_MODULES_SYSTEM_PKGS -Djava.awt.headless=true"
else
   echo "JAVA_OPTS already set in environment; overriding default settings with values: $JAVA_OPTS"
fi

```

#### 参考文档
```
参考文档
https://github.com/hongwen1993/fast-drools-spring-boot-starter
https://github.com/cncduLee/rule-engine.git
```

#### 问题
```

1、规则备份
2、集群


https://docs.wildfly.org/18/High_Availability_Guide.html#Distributable_Web_Applications
https://docs.jboss.org/drools/release/7.52.0.Final/drools-docs/html_single/index.html#_wb.datasources
https://www.pianshen.com/article/9835115068/
```

### 示例  
```
rule "hello"

when
    eval(true);
then
    System.out.println("hello world");
end
```


```
1、同步时问题  -------解决
2、规则备份问题
```