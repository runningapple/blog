---
title: JAVA 拾遗之集合接口2
date: 2017-09-11 22:57:58
comments: false
categories: R&D
tags: []
---
### 概要
上篇文章已经总结了最原始的集合接口 Collection 和 工具类 Iterator 迭代器。这篇文章将更全面的梳理一下 Java 集合体系。  
在 Java 中，集合类主要是从 Collection 和 Map 这两个接口 extends 或者 implements 来的。  

Collection 体系树图：  
![](http://wx1.sinaimg.cn/mw690/ad108d28gy1fjlci6lgogj20nt0cqdfz.jpg)  

Collection 集合体系中，Queue 是 Java 提供的队列实现。另外 Set 和 List 接口是继承于 Collection 接口的子接口，Set 属于无序集合，List 属于有序集合。  

Map 体系树图：  
![](http://wx3.sinaimg.cn/mw690/ad108d28gy1fjlci6zkstj20lc0dm3yk.jpg)  

Map 集合体系相较于 Collection 集合体系有一个很明显的特征，Map 都是以 Key-value 形式保存数据的，并且 Key 值唯一。  

一般我们把 Java 中的集合分成三大类，List、Map、Set。  
* List：有序的集合，可以对列表中每个元素的位置进行精确的控制。可以根据元素的整数索引访问元素。列表允许重复的元素存在。  

* Set：不允许重复元素的集合（Set 不包含满足 e1.equals(e2) 的元素 e1 和 e2）。Set 中最多包含一个 null 元素  

* Map：将键映射到值的对象。一个映射不能包含重复的键，每个键最多只能映射到一个值。Map 接口取代了 Dictionary （抽象）类。  


下面来细细研究下 Java 中具体的集合实现
### ArrayList

### LinkedList

### Vector

### Stack

### ArrayDeque

### HashSet

### TreeSet

### EnumSet

### LinkedHashSet

### PriorityQueue

### HashMap

### HashTable

### TreeMap

### EnumMap

### LinkedHashMap

### WeakHashMap

### IdentityHashMap