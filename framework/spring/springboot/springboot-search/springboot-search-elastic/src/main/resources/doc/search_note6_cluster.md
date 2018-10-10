## 集群管理
### 集群节点监控、集群分片迁移、集群节点配置、节点发现、集群平衡位置.
### 1.集群节点监控
#### 1.1集群健康值
##### GET http://127.0.0.1:9200/_cluster/health?pretty=true
##### status反应了集群整体的健康程度
		{
		  "cluster_name" : "elasticsearch",
		  "status" : "green",//green,所有的主分片和副本分片都处于活动状态;yellow,所有的主分片都处于活动状态,但不是所有的分片都处于活动,但是并不是所有的副本分片都处于活动状态;red,不是所有的主分片都处于活动状态.
		  "timed_out" : false,
		  "number_of_nodes" : 1,
		  "number_of_data_nodes" : 1,
		  "active_primary_shards" : 0,
		  "active_shards" : 0,
		  "relocating_shards" : 0,
		  "initializing_shards" : 0,
		  "unassigned_shards" : 0,
		  "delayed_unassigned_shards" : 0,
		  "number_of_pending_tasks" : 0,
		  "number_of_in_flight_fetch" : 0,
		  "task_max_waiting_in_queue_millis" : 0,
		  "active_shards_percent_as_number" : 100.0
		}
		
##### 1.2集群状态
###### GET http://127.0.0.1:9200/_cluster/state
###### GET http://127.0.0.1:9200/_cluster/state/metadata,routing_table/foo,bar
	{
	  "cluster_name" : "elasticsearch",
	  "compressed_size_in_bytes" : 9470,
	  "cluster_uuid" : "MRNFnyBYQ0aBQ-9IwQontQ",
	  "metadata" : {
	    "cluster_uuid" : "MRNFnyBYQ0aBQ-9IwQontQ",
	    "templates" : { },
	    "indices" : { },
	    "index-graveyard" : {
	      "tombstones" : [ ]
	    }
	  },
	  "routing_table" : {
	    "indices" : { }
	  }
####### GET http://127.0.0.1:9200/_cluster/state/blocks?pretty=true
	{
	  "cluster_name" : "elasticsearch",
	  "compressed_size_in_bytes" : 9470,
	  "cluster_uuid" : "MRNFnyBYQ0aBQ-9IwQontQ",
	  "blocks" : { }
	}
#### 1.3集群统计
###### GET http://127.0.0.1:9200/_cluster/stats
#### 1.4集群任务管理
#### 1.5待定集群任务
###### GET http://127.0.0.1:9200/_cluster/pending_tasks
#### 1.6节点信息
###### GET http://127.0.0.1:9200/_nodes?pretty=true
##### 活跃线程查看
###### GET http://127.0.0.1:9200/_nodes/hot_threads?pretty=true
#### 1.7节点统计
###### GET http://127.0.0.1:9200/_nodes/stats?pretty=true

### 2.集群分片迁移
###### 通过集群路由API_cluster/reroute来对集群中的分片进行操作.可以在集群中从一个分片从一个节点迁移到另一个节点,
###### 将未分配的分片可以分配到一个特定节点上.如果想完全手动,必须先把cluster.routing.allocation.disable_allocation=true
##### POST http://127.0.0.1:9200/_cluster/reroute
##### PUT 127.0.0.1:9200/_cluster/settings
### 3.集群节点配置
#####  主(master)节点:node.master=true时,有资格被选作为主节点,控制着整个集群.
#####  数据(data)节点:node.data=true的时候,该节点保存数据和执行数据相关的操作,如增删改查、搜索和聚合.
###### `默认情况下,节点同时是主节点和数据节点,这是非常方便的小集群,但随着集群的发展,分离主节点和数据节点将变得非常重要` 
##### 客户端节点: 当一个节点的node.master和node.data都设置为false的时候，它既不能保持数据也不能成为主节点,该节点可以作为客户端节点
##### 可以响应用户的请求,并把相关操作发送到其他节点.
##### 部落节点:当一个节点配置tribe.*的时候,它是一个特殊的客户端,它可以连接多个集群,在所有的集群上执行搜索和其他操作.
	 tribe:
		t1:
			cluster.name: cluster_one
		t2: 
			cluster.name: cluster_two
		blocks:
		# 部落节点可以通过block设置所有的写操作和所有的元数据操作.
			write:	true
			metadata:　true
		#部落节点也可以在选中的索引块中单独配置以上操作.
			write.indices: hk*,ldn*
			metadata.indices: hk*, ldn*
###	4.节点发现
##### 在ES内部,zen发现机制是默认的发现模块.它提供了单播发现方式,能够很容易地扩展到云环境.发现模块分为两个
##### 模块:
		ping模块,通过ping模块可以寻找其他节点.
		单播模块,需要提供一个主机列表作为路由列表.以discovery.zen.ping.unicast作为前缀
		主机列表设置: hosts,配置全路径为: discovery.zen.ping.unicast.hosts.
#### 4.1主节点选举
###### 系统会自动通过ping来进行选举主节点或者加入主节点,这些都是自动完成的:
###### discovery.zen.ping_timeout(默认3秒)
###### discovery.zen.minnimum_master_nodes设置需要加入一个新当选的最小节点的数目,或者接收它作为主节点的最小节点数.
#### 4.2故障检测
######
### 5.集群平衡配置
#### 5.1分片分配设置



		




















