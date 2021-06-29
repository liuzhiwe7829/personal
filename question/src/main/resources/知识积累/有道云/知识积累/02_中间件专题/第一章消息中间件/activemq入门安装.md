演示环境： Centos7、jdk8、activemq5.15.8<br>
下载地址： http://activemq.apache.org/activemq-5158-release.html<br>
解压： tar -zxvf apache-activemq-5.15.8-bin.tar.gz -C /var <br>
修改目录名称 mv /var/apache-activemq-5.15.8/ /var/activemq/<br>
 
启动： ./bin/activemq start <br>
停止：./bin/activemq stop<br>

做成系统服务

1、创建一个systemd服务文件：vi  /usr/lib/systemd/system/activemq.service

2、 放入内容
```
[Unit]
Description=ActiveMQ service
After-network. target
[Service]
Type=forking
ExecStart=/var/ activemq/bin/activemq start
ExecStop=/var/ activemq/bin/activemq stop
User=root
Group=root
Restart=always
RestartSec=9
Standard0utput=syslog
StandardError=syslog
SyslogIdentifier-activemq
[Install]
WantedBy=multi-user . target

```
3、 找到java命令所在的目录 whereis java

4、设置activemq配置文件/var/activemq/bin/env中的JAVA_HOME
```
# Location of the java installation
# Specify the location of your java installation using JAVA_ HOME， or specify the
# path to the "j ava" binary using JAVACMD
# (set JAVACMD to "auto" for automatic detection)
JAVA_ HOME=" /usr/local/java/jdk1.8.0 181"
JAVACMD= "auto"
```
5、 通过systemctl管理activemq启停
•启动activemq服务: systemctl start activemq<br>
•查看服务状态: systemctl status activemq<br>
•创建软件链接：ln -s /usr/lib/systemd/system/activemq.service  /etc/systemd/system/multi-user.target.wants/activemq.service<br>
•开机自启: systemctl enable activemq<br>
•检测是否开启成功(enable)： systemctl list-unit-files |grep activemq<br>

6、 防火墙配置，Web管理端口默认为8161，通讯端口默认为61616
•添加并重启防火墙
```
firewall-cmd --zone=public --add-port=8161/tcp --permanent
firewall-cmd --zone=public --add- port=61616/tcp --permanent
systemctl restart firewalld. service
```
•或者直接关闭防火墙: systemctl stop firewalld.service

防火墙状态查看<br>
1. 查看firewalld状态:systemctl status firewalld，如果是dead状态，即防火墙未开启。<br>
```
[mwuser@SZ-CX-SpringUat-001 conf]$ firewall-cmd --zone=public --add-port=8161/tcp --permanent
FirewallD is not running
[mwuser@SZ-CX-SpringUat-001 conf]$ systemctl status firewalld
● firewalld.service - firewalld - dynamic firewall daemon
   Loaded: loaded (/usr/lib/systemd/system/firewalld.service; disabled; vendor preset: enabled)
   Active: inactive (dead)
     Docs: man:firewalld(1)

```
2. 开启防火墙systemctl start firewalld<br>
3. 确认firewalld状态:systemctl status firewalld<br>
4. 开放默认端口号 3306，出现success表示成功<br>
```
firewall-cmd --permanent --zone=public --add-port=3306/tcp
```


