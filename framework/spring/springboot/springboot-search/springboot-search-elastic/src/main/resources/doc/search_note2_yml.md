### 一、elasticsearch.yml
#### 1>集群名称
##### cluster.name: my-application
#### 2>节点名称
##### node.name: node-1
#### 3>节点描述:
##### node.rack: rl
#### 4>索引存储位置
##### path.data: /path/to/data
#### 5>日志存储位置
##### path.logs: /path/to/logs
#### 6>内存分配模式:
#####  bootstrap.mlockall: true
#### 7>绑定的网卡IP
##### network.host: 192.168.0.1
#### 8>http协议端口
#####  http.port: 9200
#### 9>开始发现新节点的IP地址:
##### discovery.zen.ping.unicast.hosts: ["host1","host2"]
#### 10>最多发现主节点的个数
#####  discovery.zen.minimum_master_nodes: 3
#### 11>当重启集群节点最少启动N个节点后开始做恢复
##### gateway.recover_after_nodes:　3
#### 12>在一台机器上最多启动的节点数:
##### node.max_local_storage_nodes: 1
#### 13>当删除一个索引的时候,需要指定具体索引的名称:
#####  action.destructive_requires_name: true
### 二、索引配置说明
##### 1> index.refresh_interval: 5s
##### 2>elasticsearch -Des.index.refresh_intervals = 5s

### 三、日志配置说明
#### 支持的后缀格式,例如:(.yml,.yaml,.json or .properties)






















格式