商户数据传输使用http来推过来。
提供http接口来获取数据。

界面就搞得和开放平台差不多就好了，也搞一个数据统计页，和报告页。
还有贴脚本的页面。

# config
主目录

# common
常用工具类

# credit
征信数据存储,具体数据源格式

# report
征信报告计算

# user
用户登陆等模块

# chain
一些工具shell和源文件

## 智能合约在线编辑器地址
http://remix.ethereum.org/#optimize=false&version=soljson-v0.4.0+commit.acd334c9.js


# 初始化:

## 新建credit表

在mongoshell中运行
```
use bcc
db.createCollection("credit")
```

# 启动

所需环境:
```
mongo：
cd /Users/xj/code/bcc/block-chain-credit
mongod --dbpath data/db

testRPC:
testrpc


todo
取消因子的概念，机构可以主动添加因子，
一个脚本只存放一个因子，
只要贴了的脚本都去计算

```
