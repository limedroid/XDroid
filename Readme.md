#XDroid 轻量级的Android快速开发框架

## 概述

**XDroid**是一个轻量级的Android快速开发框架，由UI、Cache、Event、ImageLoader、Kit、Log、Router、Net等几个部分组成。其设计思想是使用接口对各模块解耦规范化，不强依赖某些明确的三方类库，使得三方类库可自由搭配组装，方便替换。可快速、自由的进行App开发。

## 特性

**XDroid**主要有这些特性：

* 基于MVC，可快速切换到MVP
* 提供XActivity、XFragment、SimpleRecAdapter、SimpleListAdapter等基类，可快速进行开发
* 完整封装XRecyclerView，可实现绝大部分需求
* QTContentLayout、XRecyclerContentLayout实现loading、error、empty、content四种状态的自由切换
* 实现了Memory、Disk、SharedPreferences三种方式的缓存，可自由扩展
* 内置了EventBus，可自由切换到其他事件订阅库
* 内置Glide，可自由切换其他图片加载库
* 可输出漂亮的Log，支持Json、Xml、Throwable等，实现蝇量级
* 内置链式路由
* 内置常用工具类：package、random、file...,提供的都是非常常用的方法
* 内置加密工具类 XCodec，你想要的加密姿势都有
* 默认使用okhttputils作为api请求，可任性切换retrofit等其他库
* 引入三方库极少


详细说明请前往[wiki](https://github.com/limedroid/XDroid/wiki)


## Get Started

使用，仅需三步：

### step1  

clone 'XDroid'库到本地:
```groovy
git clone https://github.com/limedroid/XDroid.git
```

### step2

将library作为依赖库，在您的app module 中 添加如下依赖:
```groovy
compile project(':library')
```


### step3

修改'kit'包下的'XDroidConf'配置类，主要针对log、cache、router。若采用默认配置，此步骤可略过.
