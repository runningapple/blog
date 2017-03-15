<center><h2>JavaScript数组遍历查找过滤方法总结</h2></center>
******  
<center>&copy;runningapple</center>  

###some() 方法

1. some() 方法用于检测数组中的元素是否满足制定的查询条件。    

2. some() 方法会依次对数组中的每个元素进行判断：  
    * 如果数组中存在一个元素满足条件，则返回true，剩下的元素不会再进行判断。
    * 如果没有满足条件的元素，则返回false。
    * some() 方法不会改变原始数组。  

3. 语法： array.some(callbackFn, thisValue);  
<table>
<tr><th>参数</th><th>定义</th></tr>
<tr><th>array</th><th>必须。一个数组对象</th></tr>
<tr><th>callbackFn</th><th>必须。一个最少接收一个参数，最多接收三个参数的函数。  
function(currentValue, index, arr)  
currentValue，必须，表示当前元素的值；  
index，可选，当前元素的索引值；  
arr，可选当前元素所属的数组对象。
</th></tr>
<tr><th>thisValue</th><th>可选。可在 callbackFn 函数中为其引用 this 关键字的对象。  
如果省略 thisValue，则 undefined 将用作 this 值。</th></tr>
</table>  
  
  
<pre>
<code>
/**定义数组**/
var nArray = [1, 2, 3, 4, 5];
var sArray = ['Tom', 'David', 'Lisa', 'Jeff'];

/**指定条件（即函数）**/
function checkNum( num ) {
	return num > 2;
}

function checkStr( str ) {
	return str === 'Lisa';
}

console.log('result:', nArray.some(checkNum)); 
//输出：result: true

console.log('result:', sArray.some(checkStr)); 
//输出：result: true

/*为了方便，下面用箭头函数来演示:
数组中如果存在一个满足条件的元素，则剩下的元素不会再进行判断:
*/
var result = nArray.some((num, index) => { 
	console.log('当前判断的元素下标是：', index);
	return num > 2;
})

console.log('result:', result); 
/*输出：
当前判断的元素下标是：0
当前判断的元素下标是：1
result: true
*/

/*验证数组中的元素不满足查询条件则返回false：*/
console.log('result:', sArray.some((str) => {return str === 'Jane'}));
/*
输出：
result: false
*/
</code>
</pre>  

******

###every() 方法  
every() 方法和 some() 方法唯一的不同就是判断数组中的每一个元素都需要符合条件才返回 true ，否则返回 false 。
every() 方法语法和参数定义和 some() 一致。这里不再做演示。  

******

###forEach() 方法  

1. 为数组中的每个元素执行操作。
2. 参数和语法同 some() 方法。  

*******

###indexOf() 方法  

1. 返回某个值在数组中的第一个匹配索引，如果没有找到则返回-1  

2. 语法：array1.indexOf(searchElement[, fromIndex])  

3. 参数：  

<table>
<tr><th>参数</th><th>定义</th></tr>
<tr><th>array</th><th>必须。一个数组对象</th></tr>
<tr><th>searchElement</th><th>必须。要在 array1 中定位的值。</th></tr>
<tr><th>fromIndex</th><th>可选。用于开始搜索的数组索引。如果省略 fromIndex，则从索引 0 处开始搜索。</th></tr>
</table>  

4.提示：indexOf() 按升序查找。数组数组元素将与searchElement值进行全等比较，与 === 运算类似。  
可选的 fromIndex 参数制定用于开始搜索的数组索引。如果 fromIndex 大雨或等于数组长度，则返回 -1。如果 fromIndex 为负，则搜索从数组长度加上 fromIndex 的位置开始。  

<pre>
	<code>
		var arr = [3, 2, 3, 1];
		console.log('result: ', a.indexOf(3));
		//result: 0
		console.log('result: ', a.indexOf(2));
		//result: 1
		console.log('result: ', a.indexOf(3, 1));
		//result: 2
		console.log('result: ', a.indexOf(3, -3));
		//result: 2
	</code>
</pre>  

*******

###lastIndexOf() 方法  

lastIndexOf() 方法与 indexOf() 方法一样，唯一不同的是返回指定的值在数组中的最后一个匹配项的索引。  

******

###filter() 方法  

1. 返回数组中的满足回调函数中指定的条件的元素  

2. 语法： array1.filter(callbackfn[, thisArg])  

3. 参数：  

<table>
<tr><th>参数</th><th>定义</th></tr>
<tr><th>array</th><th>必须。一个数组对象</th></tr>
<tr><th>searchElement</th><th>必需。一个接受最多三个参数的函数。对于数组中的每个元素，filter 方法都会调用 callbackfn 函数一次。</th></tr>
<tr><th>fromIndex</th><th>可选。可在 callbackfn 函数中为其引用 this 关键字的对象。如果省略 thisArg，则 undefined 将用作 this 值。</th></tr>
</table>  

###map() 方法  
