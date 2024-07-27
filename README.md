# InlongSDK-10463

## 代码逻辑情况

1. 在 **ConfigConstants.java** 文件中添加一个默认的最大消息长度常量。

![](.\imgs\configConstant-1.png)

2. 在 **ProxyClientConfig.java** 文件中添加一个可配置的最大消息长度属性，并提供相应的 getter 和 setter 方法。

![](.\imgs\ProxyClientConfig-1.png)

![](.\imgs\ProxyClientConfig-2.png)

3. 在 **DefaultMessageSender.java** 文件中修改 sendMessage 方法，添加自动截断逻辑。

![](.\imgs\DefaultMessageSender-1.png)

![](.\imgs\DefaultMessageSender-2.png)

![](.\imgs\DefaultMessageSender-3.png)

## 环境部署情况

1. 初步写好处理代码，但是在测试**TcpClientExample.java**文件（根据调用修改后），报链接错误：
   `Connect Manager error, message: Unsupported or unrecognized SSL message`

![](.\imgs\wrong-1.jpg)

在调查问题后，手动修改为http后，可以连接，但从代码角度来看，要修改TcpClientExample.java和ProxyClientConfig.java文件

![](.\imgs\wrong-2.jpg)

2. 然后，我是从官方文档【Java SDK】的部分学习的测试步骤，因此从下方代码进行修改

![](.\imgs\wrong-3.jpg)

![](.\imgs\wrong-4.jpg)

3. 然后因为出现参数只接收http的情况，我看代码里面修改，会动其他文件TcpClientExample.java 和 ProxyClientConfig.java文件

![](.\imgs\wrong-5.jpg)

![](.\imgs\wrong-6.jpg)

4. 分析问题后，确实是http修改改了1、2个参数，但链接需要组id和流id，就走了一遍【数据接入：Pulsar 示例】的文档，但是在clickhouse的时候报错了。

![](.\imgs\ckWrong-3.png)

![](.\imgs\ckWrong-4.png)

![](.\imgs\ckWrong-5.png)

![](.\imgs\ckWrong-6.png)

![](.\imgs\ckWrong-7.png)



## 目前情况

分跟导师充分交流后，怀疑是win11某一步骤的环境搭建错误，建议换成Linux环境的docker容器里面进行编译执行。

但在docker下拉环境时编译错误，正在纠正。

后续希望能在linux 环境中，实现测试上述代码运行情况，以便修正。

![](.\imgs\dockerWrong-1.png)