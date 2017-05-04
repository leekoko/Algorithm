# 数学基础

这个模块单纯地对数学知识进行归纳，很单纯的数学知识

---

## 1.素数

素数的定义：除了1和它本身以外不再有其他因数的数称为质数（素数）

**问题：判断10是不是素数**

```java
	public static boolean isPrime(int num) {
		if(num<2){
			return false;
		}
		for (int i = 2; i < num; i++) {
			if(num%i==0){
				return false;
			}
		}
		return true;
	}
	
```
[第100002个素数](../doc_B/Prime.md#1第100002个素数)

---

## 2.次方&开方

这部分简单地介绍数学的一些函数的使用：pow sqrt      
因为次方可能设计到大数运算，所以也简单介绍下multiply(大数的相乘法)

**问题：求9的三次方与开方的值，333333333333*3的次方**

```java
	public static void main(String[] args) {
		System.out.println(Math.pow(9, 3));	   //次方
		System.out.println(Math.sqrt(9));     //开方

		BigInteger bi=new BigInteger(String.valueOf("333333333333")); 
		System.out.println(bi.multiply(bi));  //大数平方
		
	}
```
除了大数乘法，这里还有大浮点数的除法

`` 	
	BigDecimal a=new BigDecimal("1.5");
	BigDecimal b=new BigDecimal("0.5");
	System.out.println(a.divide(b));
``


``待定:花朵数``

---

## 3.交叉相乘

为什么要用到交叉相乘呢，当涉及分式的时候，如果直接用除法，非常容易导致精度变化，从而产生错误的结果

**问题：判断3/5*1/6是否等于1/10**

```java
public static void main(String[] args) {
	int a1=3;
	int a2=5;
	int b1=1;
	int b2=6;
	if(a1*b1*10==a2*b2*1){
		System.out.print("3/5*1/6是等于1/10");
	}
}	
```

``待定：对应的大题``

---

## 4.斐波那契数列

斐波那契数列比较常见，这里用递归的方式来求。普通的递归速度很慢，但是用上数组存值之后可以加速很多。

**问题：求斐波那契数列的第10位值**

```java
static int[] arr=new int[100000000];
public static void main(String[] args) {
	System.out.println(f(10));
}

public static int f(int num) {
	if(arr[num]!=0){
		return arr[num];
	}
	if(num==1||num==2){
		return 1;
	}
	return arr[num]=f(num-1)+f(num-2);
}
```

``待定：对应的大题``

---

## 5.全排列

这里的全排列使用递归方式来实现

**问题：输入一个数n，列出从1到该数的所有排列情况**

题目分析：  
1. 为了简化递归函数，除了变化的point之外，存储的数组都声明为全局的  
2. 对1~num之间的数字一个个进行代入  
3. 解决重复代入的问题:先判断该数字没出现过，再代入

```java
import java.util.Scanner;

public class Main {
static int num;
static int[] arr;
public static void main(String[] args) {
	Scanner in=new Scanner(System.in);
	num=in.nextInt();
	arr=new int[num];
	f(0);
}

public static void f(int point) {
	if(point>=num){
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
		return;
	}
	for (int i = 1; i <=num; i++) {
		boolean isExist=false;
		for (int j = 0; j < point; j++) {
			if(arr[j]==i){
				isExist=true;
			}
		}
		if(!isExist){
			arr[point]=i;
			f(point+1);
		}
	}
}
}
```

[ABC回溯全排列](../doc_B/FullPermutation.md#1ABC回溯全排列) 

---

## 6.最大公约数&最小公倍数

这里使用辗转相除法来求最大公约数

**问题：求15，40的最大公约数&最小公倍数**

题目分析：  
1. 关系式：将两个数交换位置进行递归，其中一个数mol另一个数不断缩小
2. 而节点在于，当缩小那个位置为0的时候，返回另一个数，其为最大公约数  
3. 最小公倍数=数a*数b/最大公约数

```java
public class Main {
public static void main(String[] args) {
	int num=f(15,40); //最大公约数
	System.out.println(num);
	System.out.println(15*40/num);  //最小公倍数
}

public static int f(int a, int b) {
    if(a==0){
        return b;
    }
    return f(b%a,a);
}
}
```

``待定：对应的大题``

---

## 7.尼姆游戏

尼姆游戏是一种两个人玩的回合制数学战略游戏。游戏者轮流从一堆棋子中取走一个或者多个，最后不能再取的就是输家。

**问题：You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.  
Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.  
For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend**

题目分析：
1. 这道题跟普通的尼姆游戏有一点不同，它要求的是最后一个拿的才是胜者  
2. 因为拿的范围是1~3，所以当4的时候，先者必败
3. 通过推导可以发现，当数目为4的倍数时，先者必败

```java
public static boolean f(int num) {
	if(num%4==0){
		return false;
	}
	return true;
}
``` 
``待定大题：高僧斗法``

---

## 8.不定方程

所谓不定方程，是指未知数的个数多于方程个数，且未知数受到某些限制（如要求是有理数、整数或正整数等等）的方程或方程组。  

**问题：解不定方程4x-5y=7**

题目分析：  
1. 要求不定方程，先将它从本来的二层循环转化为单层循环  
2. 将 ax+by=c 转化为 ax=c-by  ，然后假设一个特殊解  
3. 通过%这个特殊解求出所有的y解，再通过y解求出对应的x解  

```java
public static void main(String[] args) {
	//4x-5y=7     x=(7+5y)/4
	for (int y = 0; y < 100; y++) {
		if((7+5*y)%4==0){   
			System.out.print("y="+y+" ");      //用x为4的倍数筛选出所有的y值

			System.out.println("x="+(7+5*y)/4);      //同过y值再次推导出x值

		}
	}
}
```
``待定大题``

---

## 9.随机算法


**问题：**

题目分析：
1. 这是第一个分析


``待定大题``

---










