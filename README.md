# netRepeater

个人主页链接：[digitzh.github.io](digitzh.github.io)

## 1 介绍

手把手教你网络转发，免费转，轻松发。

近期实验室在做铁科院要求的C++项目[ComoFramework: 功能安全应用框架](https://gitee.com/tjopenlab/ComoFramework)。然而，项目依赖于重量级组件COMO，牵一发而动全身，灵活性不足。基于实际功能需求，本系列尝试用Java实现其部分功能，在锻炼Java项目设计能力的同时，加深对相关技术和模块的理解。出于单一职责原则的考虑，本系列将原项目功能拆分为不同小项目（如消息转发、同步、调度、表决等），分而治之。

本项目netRepeater实现了TCP/UDP网络消息转发，支持指定网卡/端口转发等功能。

项目仍在进行，目前大体分为3个模块：

- UDPSender：发送UDP包；
- UDPRepeater：中继（接收+发送）；
- UDPReceiver：接收UDP包。

发送、接收等方法可以复用，所以设计UDPUtils存放公共方法。总体上有5个文件：

- Main.java
- UDPReceiver.java
- UDPRepeater.java
- UDPSender.java
- UDPUtils.java

## 2 测试

运行程序，Receiver将打印从Sender发出的消息（序号+时间戳）：

```
0 1748178490569
1 1748178491585
2 1748178492597
3 1748178493599
...
```

不定期更新，敬请期待！
