# 闲聊蓝桥杯JAVA - 移动距离

D:今晚做这一道题

```
移动距离

X星球居民小区的楼房全是一样的，并且按矩阵样式排列。其楼房的编号为1,2,3...
当排满一行时，从下一行相邻的楼往反方向排号。
比如：当小区排号宽度为6时，开始情形如下：

1  2  3  4  5  6
12 11 10 9  8  7
13 14 15 .....

我们的问题是：已知了两个楼号m和n，需要求出它们之间的最短移动距离（不能斜线方向移动）

输入为3个整数w m n，空格分开，都在1到10000范围内
要求输出一个整数，表示m n 两楼间最短移动距离。

例如：
用户输入：
6 8 2
则，程序应该输出：
4

再例如：
用户输入：
4 7 20
则，程序应该输出：
5

资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 1000ms
```

Z：这道题我以前接触过

```java
	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		int length = input.nextInt();
		int one = input.nextInt();
		int two = input.nextInt();
		
		int ox=one/length;
		int oy=one%length;
		int tx=two/length;
		int ty=two%length;

		if(one%length==0){
			oy=length;
		}else{
			ox=ox+1;
		}
		if(two%length==0){
			ty=length;
		}else{
			tx=tx+1;
		}
		if(ox%2==0){
			oy=length-oy+1;
		}
		if(tx%2==0){
			ty=length-ty+1;
		}
		System.out.println(Math.abs(ox-tx)+Math.abs(oy-ty));
	}
```

M:首先有个语法问题，Math.abs()是干嘛用的？

Z:算出绝对值。

M:one是第一栋楼的编号，``int ox=one/length;``表示什么？

Z:ox是区域高的部分，通过 楼房编号/宽度 得到。但是除了每行的最后一个数，其他的 楼房编号/宽度 得出的高都比实际少1。

所以要对普遍情况进行处理，判断是否是最后一个数，除了最后一个数其他的都要+1。

```java
		if(one%length==0){
			...
		}else{
			ox=ox+1;
		}
```

M:那``int oy=one%length;``就是计算它的宽度啦。不过它的顺序是S型增加，怎么来确定宽度差呢？

Z:这就是这道题的核心部分，区分不同情况的宽度差。

1. 当处于最后一个位置的时候，宽度变成了0 ，编号6 % 楼数6 == 0。所以要将其恢复为宽度长度

   ```java
   		if(one%length==0){
   			oy=length;
   		}
   ```

M:那这段代码是怎么用的？

```java
		if(ox%2==0){
			oy=length-oy+1;
		}
```

Z:因为偶数行的渐变序是从右到左，所以需要把它的位置进行转化，转化为左到右

```java
		if(ox%2==0){
			oy=length-oy+1;
		} 
```

M:但是为什么要算出绝对值呢？

```java
Math.abs(ox-tx)+Math.abs(oy-ty)
```

Z:因为不知道大的数在前面还是小的数在前面，所以相减之后可能是负数，但是我们要的结果只是相对差，所以算出其绝对值即可。

M:总结一下，这道题的重点就是通过/ 和 % 算出宽高差，而S型的宽处理，需要将从右到左的排序转化为从左到右。