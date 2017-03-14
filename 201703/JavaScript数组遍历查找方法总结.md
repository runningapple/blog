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

