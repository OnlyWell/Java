## 高级配置
### 1.网络相关配置
#### 1.1本地网关配置
##### gateway.expected_nodes: 0  // 集群中预计节点
##### gateway.expected_master_nodes: 0 //集群中主节点预计数量
#### 1.2HTTP配置
	HTTP模块允许通过HTTP来调用Elasticsearch接口
##### 禁用http
	http.enabled:　false
#### 1.3网络配置
	network.host: 节点会绑定这个主机名或ip地址并且发布(广播)到集群中的其他节点.
	discovery.zen.ping.unicast.hosts 为了加入一个集群,节点至少需要知道一些集群中其他节点的主机名或IP地址.这个设置节点尝试连接其他节点的最初列表
	http.port: 绑定接收http的端口.接受单独的值或者一个范围.默认为9200-9300
	transport.tcp.port:　绑定节点间通信的端口．默认为9300~9400
	