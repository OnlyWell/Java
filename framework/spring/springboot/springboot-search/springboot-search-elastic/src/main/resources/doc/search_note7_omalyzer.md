## 索引分词器
### 分词器
#### 分词器(omalyzer)是由一个分解器(tokenizer)、零个或多个词元过滤器(token filters)组成.
#### 索引分析模块包括分词器(analyzer),分解器(tokenizer)和次元过滤器#### (token filters).如果没有明确定义分析模块,系统会用内置的分词器、分解器和过滤器.
### 中文分词器
#### 1>安装smartcn 
#####  elasticsearch-plugin.bat install analysis-smartcn  

#####  安装核心分词器必须使用 elasticsearch-plugin install plugin-name即可
#####  安装其他的分词器只需要

#### `NLP中文的处理插件  https://github.com/NLPchina/nlp-lang`
#### `在ES6之后增加的插件不需要到elasticsearch.yml中配置`
#### `中文分词器ik的安装只需要下载安装包,解压到plugins下, ik分词器的github网址 https://github.com/medcl/elasticsearch-analysis-ik`
