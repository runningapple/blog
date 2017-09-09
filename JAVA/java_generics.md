---
title: JAVA 拾遗之泛型程序设计
date: 2017-09-09 22:57:58
comments: false
categories: R&D
tags: []
---

### 泛型类
    泛型类就是具有一个或者多个类型变量的类。下面就是一个简单的泛型类：
```java
public class Pair<T, U> {
    private T first;
    private T second;
    private U other;

    public Pair() {
        first = null;
        second = null;
        other = null;
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public Pair(T first, T second, U other) {
        this.first = first;
        this.second = second;
        this.other = other;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public U getOther() {
        return other;
    }

    public void setOther(U other) {
        this.other = other;
    }

    public static void main(String[] args) {
        String first = "hello";
        String second = "world";
        Integer other = 666;
        Pair<String, Integer> pair = new Pair<String, Integer>(first, second, other);//注意这里不能用基本数据类型，因为类型擦除后，类型参数替换成 Object 类型，而 Object 类型不能存储 基本数据类型
        System.out.println(pair.getFirst());//输出：hello
        System.out.println(pair.getSecond());//输出：world
        System.out.println(pair.getOther());//输出：666
    }
}
```
从上面代码可以看出来 Pair 类引入了两个类型变量 T 和 U。用尖括号 <> 扩起来，并防止类名后面。泛型类可以有多个类型变量。例如这里的泛型类还可以添加其他不同的类型如：
```java
public class Pair<T, U, S> {...}
```
类型变量一般使用大写形式，且字符较短。在 Java 库中，使用变量 E 表示集合的元素类型，K 和 V 分别表示关键字与值的类型。T,U,S 表示任意类型。

### 泛型方法
    泛型类已经介绍过了，接下来看看泛型方法。
```java
    public static <T> T myPrint(T[] a) {
        System.out.println(Arrays.toString(a));
        return a[0];
    }

    public static void main(String[] args) {
        String[] strings = {"hello", "world"};
        Integer[] integers = new Integer[]{1, 2, 3};
        GenericTest.<String>myPrint(strings);
        //调用方法时可以在方法名前添加具体的类型。大部分时候也可以省略，编译器能够根据信息判断出来。
        myPrint(integers);
    }
```
可以看出来泛型方法与普通方法的区别就是多了个尖括号和泛型变量。这个修饰符一般放置在修饰符后面，返回类型前面。  

### 类型变量的限定
    有时候，我们希望类和方法需要对类型变量进行约束，比如一个比较大小的方法，在 Java 中不是所有类的对象都可以进行比较的，只有实现了 compareTo 的接口才能进行比较。所以如果我们想要一个方法限定只有实现了 compareTo 接口的类才能调用。这个时候我们就可以对类型变量设定“限定范围”来实现这个功能：
```java
public <T extends Comparable> T max(T[] items) {...}
//这里的 Comparable 虽然是接口但是并没有使用 implements 而是使用 extends 。其实这里 T 应该是绑定类型的子类型。T 和 绑定类型可以是类，也可以是接口。选择 extends 原因是这里更接近子类的概念。
```
这样只有实现了 compareTo 接口的类才能调用该方法，如果没有实现 compareTo 接口的类调用该方法，将会报编译错误。
如果想要设置多个限定，则可以用下面的写法：
```java
public <T extends Comparable & Serializable> T max(T[] items){...}
//限定中至多有一个类，如果用一个类作为限定，它必须是限定列表中的第一个。类型擦除的时候如果有限定，会用第一个限定类型变量来替换 T 。这时候为了提高效率，类放前面，标签接口放后面（没有方法的接口，如Serializable接口）
```

### 泛型代码与虚拟机
    虚拟机是没有泛型类型对象的，所有对象都是属于普通类。  
    定义一个泛型类型，都会自动提供一个相应的原始类型。擦除类型变量后，会替换为限定类型（如果没有限定，则替换为 Object）
```java
public class Pair<T, U> {
    private T first; //按道理这里的 T 和 U 都会替换成 Object 才对，但是我用 Java8 编译出来并没有替换掉。？ 
    private T second;
    private U other;

    public Pair() {
        this.first = null;
        this.second = null;
        this.other = null;
    }

    public Pair(T var1, T var2, U var3) {
        this.first = var1;
        this.second = var2;
        this.other = var3;
    }

    public T getFirst() {
        return this.first;
    }
    ...
    public U getOther() {
        return this.other;
    }
        public static void main(String[] var0) {
        String var1 = "hello";
        String var2 = "world";
        Integer var3 = Integer.valueOf(666);
        Pair var4 = new Pair(var1, var2, var3);
        System.out.println((String)var4.getFirst());//但是这里做了强制转换，所以其实还是有进行类型擦除的，估计是编译的姿势不对。
        System.out.println((String)var4.getSecond());
        System.out.println(var4.getOther());
    }
}
```
泛型虽好，但是有时候用的不小心就会犯错。下面这段代码就出现了一个问题。
```java
public class SonPair extends Pair {
    public void setSecond(Date second) {
        System.out.println(second);
    }
    public Date getSecond(){
        return new Date();
    }
}
```
很显然这里的 SonPair 是为了覆盖父类的方法，但是 Pair 在编译时就已经进行类型擦除了，所有类型变量都变成 Object 了。这样一来 SonPair 没法覆盖父类的方法了。这就失去了多态性，这个问题最终还是由编译器来解决了，编译器会在 SonPair 中生成一个桥方法。
```java
public void setSecond(Object second) {
    setSecond((Date) second);
}
```
这正好到达了我们所期望的效果。  
但是 getSecond 方法是不合法的，不能这么写，在虚拟机中，用参数类型和方法名确定一个方法的，所以这么写是不行的。
总结：虚拟机中没有泛型，只有普通类和普通方法。
所有类型参数都用它们的限定类型替换。
桥方法被合成来保持多态。
为保持类型安全性，必要时插入强制类型转换。
