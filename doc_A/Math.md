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



