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
1. mongo : doc/run_test_env.sh
2. 前端:  npm run dev
3. 区块链浏览器: cd explorer  && npm start
4. mysql : 一直在运行
5. testrpc: 模拟区块链私链

准备数据【演示之前必须完成该步骤】:
1。首先启动 testrpc， 拿到一个私钥，
1.1 用该私钥启动并部署智能合约 DeployBcc
2。看"智能合约部署成功"日志拿到合约部署的地址，然后通过load进行区块链智能合约调用
3。然后可以进行数据模拟 启动 BccMocker，获得身份证列表

开始进行系统展示：
1。【【每次都需要先刷新页面！】】先从列表中选取2～3个人的身份证号码【解释：由于数据敏感，身份证手机号都是修改过的】进行查询。演示报告  ---》 这就是多人
2。再对其中一个人，演示其数据添加记录。【切换前后台进行操作】
3。再对其中一个人，演示因子规则修改，【添加一个预先准备好的银行因子】
4。再对其中一个人，演示报告添加【增加共享单车的数据，让他在首页可以展示】  --》 这就是多维度


