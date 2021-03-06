---
title: 使用预排序遍历树算法进行无限分类
date: 2017-07-16 22:58:58
comments: false
categories: R&D
tags: [技术,R&D,数据库,优化]
---
一年前在做毕业设计的时候，做了一个针对在校大学生的网上二手街，虽然最后功能都实现了，但是还有一个地方并没有很好的实现，就是用户评论。当时只是用简单的树形结构来设计评论表，再查询表的时候只能用递归查询，效率非常低。前些天在浏览网页的时候，看到一个很不错的算法———“预排序遍历树”可以用来高效的实现这种场景。  

分类是各行各业必不可少的一个场景，如你扔个垃圾会先把垃圾分类，去买水果，水果店会根据水果类型和特点进行分类摆放，买衣服会根据男装、女装、衣服、裤子等进行分类，去点菜时候，菜单上会根据冷热、甜辣等进行分类。所以分类在生活中十分常见，但是对于软件行业来说，分类最经典的应用莫过于菜单、评论等场景。  

在开发菜单、评论功能时候，主要难点是在如何设计一个表结构，支持高效的读取数据。最常用也是最简单粗暴的方法就是设计一个表结构有 ID ， parentID ，name 字段的树形菜单结构。这种结构在查询数据的时候，如果要查询子节点数据，就需要进行递归查询，所以在数据很多的情况下，查询效率就会变得十分低，这将会带来十分糟糕的用户体验。  

那么有什么比较优秀的数据结构可以保证高效率的查询数据呢？当然有，我们只需要在原先的表结构上加上几个字段，另外辅之以“预排序遍历树算法”即可做到高效的数据查询。  

下面先来看下实际应用场景，首先我们先模拟一个服装店的分类场景，让后对其进行模拟分类成一棵树。  
![](http://wx1.sinaimg.cn/mw690/ad108d28gy1fhlr0ipg5lj20zb0jygs6.jpg)  
我们现在已经有了一棵分类树了，那么接下来我们在每个节点的左右两边标上一个值，规则就是预排序遍历树算法其实和先序遍历没什么差别，如图，标好之后就如下图，不懂先序遍历的看完图应该也能了解其中的规律了。  
![](http://wx3.sinaimg.cn/mw690/ad108d28gy1fhlr0j7ylvj20yl0ho10u.jpg)  
接下来要做的就是将这棵树转换成表。如图：  
![](http://wx1.sinaimg.cn/mw690/ad108d28gy1fhlrfuzrhzj20bj07lq2x.jpg)  
如果我们要查询某个类别商品下单所有子类，就可以用如下SQL：  
<pre><code>SELECT t.* from t_cloth t WHERE t.LEFT_WEIGHT BETWEEN 2 AND 22</code></pre>  
如果我们要知道某个类别商品下有多少个子类呢？这回不用SQL，自己口算就行了。  
<pre><code>公式：子类数量=(父类右值-父类左值-1)/2</code></pre>  

那么如何将这个缺点尽量的避开呢？  

我想了两种方案：  
1. 一种是将左右权重值设置为浮点数类型，这样再新增子节点的时，就不需要进行 update 操作了，因为我们可以将子节点的左右值设置为在左右区间范围内的任意浮点数即可，如我们要在 13 和 14 之间添加一个节点，那么这个节点的左右权重值可以设为 13.1 和 13.2 这样就可以完美的避免了 update 操作了。

2. 第二种可以采用节点权重值递增不连续，动态扩展节点区间的方法，这个方法名自己瞎取的。顾名思义，就是一个节点的左右两边的值虽然是递增的但是并不是连续的，如果要添加一个子节点，我们需要先算一下这个节点所在层级的空间利用率是否已经达到阈值，如果达到了那么我们就动态增加这个节点相邻右边所有节点的值。至于增加的值的范围和阈值可以自己定。可以参考 vector 的实现方式。