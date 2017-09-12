---
title: JAVA 拾遗之集合接口
date: 2017-09-11 22:57:58
comments: false
categories: R&D
tags: []
---
### 概要
与现代等数据结构类库一样（C++ 中的 STL），Java 集合类库也将接口与实现分离。值得一提的是从 Java 1.5 之后，集合类都是带有类型参数的泛型类，这对于开发带来的便利性不言而喻。  

### 集合接口
* Collection
在 Java 类库中，集合类的基本接口是 Collection 接口。Collection 只表示一组对象，这些对象也称之为 collection 的元素。一些 collec 允许有重复的元素，而外一些则不允许。一些是 collection 是有序的，另外一些则是无序的。JDK 不提供此接口的任何直接实现。它提供更具体的子接口实现（如 Set 和 List）。  
