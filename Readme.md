#XDroid 轻量级的Android快速开发框架

## 概述

<p align="center">
	<img src="xdroid_logo_128.png"/>
	
</p>

**XDroid**是一个轻量级的Android快速开发框架，由`UI`、`Cache`、`Event`、`ImageLoader`、`Kit`、`Log`、`Router`、`Net`等几个部分组成。其设计思想是使用接口对各模块解耦规范化，不强依赖某些明确的三方类库，使得三方类库可自由搭配组装，方便替换。可快速、自由的进行App开发。

> Demo详细使用可参看Demo


## XDroid-Base

XDroid-Base包含开发中常用的一些快速开发类，可作为一个简单的开发框架,由Base、Cache、ImageLoader、Kit、Log、Router等几个部分组成。可快速、自由的按需扩展进行App开发。

传送门：[**https://github.com/fodroid/XDroid-Base**](https://github.com/fodroid/XDroid-Base)

## XDroid-Databinding

XDroid-Databinding是XDroid快速开发框架的Databinding版本，大部分源码也与XDroid类似。

传送门：[**https://github.com/fodroid/XDroid-Databinding**](https://github.com/fodroid/XDroid-Databinding)


## XDroidMvp

XDroidMvp是基于XDroid的MVP实现，不是传统意义的MVP，不需写接口，可无缝切换MVC，可能是当前最好用的MVP框架。

传送门：[**https://github.com/limedroid/XDroidMvp**](https://github.com/limedroid/XDroidMvp)

## XDroidMvp-Databinding

XDroidMvp-Databinding是基于XDroidMvp的Databinding版本，大部分源码也与XDroidMvp类似。

传送门：开发中


XDroid推出以来，得到了很多朋友的快速反馈，目前有很多朋友在新项目或是老项目中使用XDroid，为了方便学习和交流，可以加入QQ群：

XDroid交流群：**153569290**


## 特性

**XDroid**主要有这些特性：

* 基于MVC，可快速切换到MVP
* 提供`XActivity`、`XFragment`、`SimpleRecAdapter`、`SimpleListAdapte`r等基类，可快速进行开发
* 完整封装XRecyclerView，可实现绝大部分需求
* QTContentLayout、XRecyclerContentLayout实现loading、error、empty、content四种状态的自由切换
* 实现了Memory、Disk、SharedPreferences三种方式的缓存，可自由扩展
* 内置了`EventBus`，可自由切换到其他事件订阅库
* 内置`Glide`，可自由切换其他图片加载库
* 可输出漂亮的`Log`，支持Json、Xml、Throwable等，蝇量级实现
* 内置链式路由
* 内置常用工具类：package、random、file...,提供的都是非常常用的方法
* 内置加密工具类 `XCodec`，你想要的加密姿势都有
* 默认使用`okhttputils`作为api请求，可任性切换retrofit等其他库
* 引入三方库极少


详细说明请前往[wiki](https://github.com/limedroid/XDroid/wiki)


## Get Started

使用，仅需四步：

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

拷贝`conf.gradle`到您的项目根目录，并修改项目gradle文件下引入：
```groovy
apply from: "conf.gradle"
```

并添加:

```groovy
allprojects {
    repositories {
        jcenter()
        maven { url "https://jitpack.io" }
    }
}
```

### step4

修改`XDroidConf`配置类，主要针对log、cache、router、imageloader。若采用默认配置，此步骤可略过.


## Demo效果

<p align="center">
	<img src="art/snapshot_2.png"/>
</p>

<p align="center">
	<img src="art/snapshot_1.png"/>
</p>


## 重要说明

* [ButterKnife](https://github.com/JakeWharton/butterknife)使用的是8.4.0版本，重点是 `@BindView`，可以去项目官网查看。
* [EventBus](https://github.com/greenrobot/EventBus)使用的是3.0.0版本,使用注解`@Subscribe`，具体如何使用可以查看官网。

## ToDo

* MVP、retrofit、rx迁移（v2.0）
* 权限适配（v2.0）
* compact工具（v3.0）


## 相关文档

[我是如何搭建Android快速开发框架的(概述)](http://www.jianshu.com/p/cde5468029b4)

[我是如何搭建Android快速开发框架的之UI篇(上)](http://www.jianshu.com/p/c909f72cdd02)

## 感谢

* 感谢干货提供的api


# 关于我们
### droidlover
**Email** : droidlover@126.com

**Github** : https://github.com/limedroid

**简书**：http://www.jianshu.com/u/276be5744ca0
### fodroid
**Email** : me.shihao@qq.com

**Github** : https://github.com/fodroid

**简书**：http://www.jianshu.com/u/caf7ea3607ed

