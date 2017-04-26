# 数学基础

这个模块单纯地对数学知识进行归纳，很单纯的数学知识

---

## 1.素数

素数的定义：除了1和它本身以外不再有其他因数的数称为质数（素数）

问题：判断10是不是素数

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

``待定：对应的大题``

---

## 2.次方&开方

这部分简单地介绍数学的一些函数的使用：pow sqrt      
因为次方可能设计到大数运算，所以也简单介绍下multiply(大数的相乘法)

问题：求9的三次方与开方的值，333333333333*3的次方

```java
	public static void main(String[] args) {
		System.out.println(Math.pow(9, 3));	   //次方
		System.out.println(Math.sqrt(9));     //开方

		BigInteger bi=new BigInteger(String.valueOf("333333333333")); 
		System.out.println(bi.multiply(bi));  //大数平方
		
	}
```

``待定：对应的大题``

---

## 3.交叉相乘

为什么要用到交叉相乘呢，当涉及分式的时候，如果直接用除法，非常容易导致精度变化，从而产生错误的结果

问题：判断3/5*1/6是否等于1/10

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

问题：求斐波那契数列的第10位值

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

问题：输入一个数n，列出从1到该数的所有排列情况

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

``待定：对应的大题``

---






