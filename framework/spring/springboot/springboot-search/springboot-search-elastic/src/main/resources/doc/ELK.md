## ELK应用
#### Elasticsearch + Logstash + Kibana(ELK)
### 1.Logstash
#### 启动的时候加上-f参数启动:
##### logstash -f logstash-simple.conf
##### 配置文件的结构
		input{
		}
		filter{
		}
		output{
		}
##### 一个插件的配置由插件的名称和插件的配置设置组成.
	input{
		file { path => "vat/log/messages" type => "syslog"}
		file {path => "/var/log/apache/access.log" type = "apache"}
	}
	
	数组操作:
	path => ["var/log/messages","var/log/*.log"]
#### 1.1条件语法
	if expression{
	
	} else if expression {
	
	} else {
	}
#### 1.2插件管理
	Logstash有丰富的输入、过滤、输出插件.插件可以作为独立的软件包存在
	i>列出现有插件
	logstash-plugin list
	logstash-plugin list --verbose
	
	.\logstash-plugin.bat list --group output //按组
	.\logstash-plugin.bat list '*name*'  //正则
	
	ii>增加插件
	.\logstash-plugin.bat install logstash-output-kakfka
	
	iii>更新插件
	.\logstash-plugin.bat update
	.\logstash-plugin.bat update logstash-output-kakfka
	iiii>移除插件
	.\logstash-plugin.bat uninstall logstash-output-kakfka
	
	iiiii>输入插件
		input{
			syslog {port => 514}
		}
	iiiiii>过滤插件
		grok类型的
		filter{
			grok{
				match => {
					"message" => %{IP:client} %{WORD:method} 
				}
			}
		}
		json类型的
		filter{
			json{
			"foo_%{somefield}" => "hello world, from %{host}"
			"new_field" => "new_static_value"
			}
		}
	}
	
		
		
				
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
