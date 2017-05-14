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
[取球游戏](../doc_B/NimGame.md#1取球游戏)  
[高僧斗法](../doc_B/NimGame.md#2高僧斗法)


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
随机算法就是用随机数，模拟出抽取的情况，最后算出概率的多少

**问题1：30人的班级，出现生日重复的概率有多大？**

题目分析：
1. 设定足够多的班级，声明重复的班级为n
2. 产生随机数，判断一但重复，n++
3. 全部班级循环之后，算出重复班级所占的比例

```java	
	public static void main(String[] args) {
		int N=1000*100;   //班级数量
		int n=0;    //重复的班级数
		for (int i = 0; i < N; i++) {
			int[] arr=new int[365];   //一年的标记
			for (int j = 0; j < 30; j++) {   //循环30个同学
				int p=(int)(Math.random()*365);
				if(arr[p]==1){
					n++;
					break;
				}else{
					arr[p]=1;
				}
			}
		}
		System.out.println((double)n/N);
	}
```
**问题2：[洗牌]将数组中的4个数随机打乱顺序**

题目分析：  
采用for循环遍历每一个数，跟随机数位置的数交换位置（for是为了更彻底洗牌），从而产生随机数组  

```java
	public static void main(String[] args) {
		int[] arr={1,2,3,4};
		for (int i = 0; i < 10; i++) {   //洗十次
			f(arr);
			show(arr);			
		}
	}

	public static void show(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

	public static void f(int[] arr) {
		for (int i = 0; i < arr.length; i++) {   //for循环洗得彻底一点
			int ran=(int)(Math.random()*4);
			int temp=arr[i];
			arr[i]=arr[ran];
			arr[ran]=temp;
		}
	}
```

[运算24点数](../doc_B/random.md#1运算24点数)

---

## 10.逆波兰表达式  
逆波兰表达式又叫做后缀表达式。每一运算符都置于其运算对象之后，故称为后缀表示。  

a+b ---> a,b,+  
a+(b-c) ---> a,b,c,-,+  
a+(b-c)*d ---> a,b,c,-,d,*,+  
a+d*(b-c)--->a,d,b,c,-,*,+  

**问题1：输入一条逆波兰表达式，将它转化为中缀式**

题目分析：  
1. 声明一个Stack，Stack的使用方式：  
 - 弹栈操作：stk.pop()         
 - 压栈操作：stk.push()  
2. 做循环，如果是符号，将数组从栈里面拿出来，处理后再压栈  
3. 如果是数字，直接压栈备用

```java
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		String[]  arr=input.nextLine().split(",");
		
		Stack stk=new Stack();
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].equals("+")||arr[i].equals("-")||arr[i].equals("*")||arr[i].equals("/")){
				String b=(String)stk.pop();
				String a=(String)stk.pop();
				stk.push("("+a+arr[i]+b+")");
			}else{
				stk.push(arr[i]);
			}
		}
		System.out.println(stk.pop());
	}
```
_但是这种解法有缺陷，不规范的逆波兰会导致其报错_

**问题2：运算逆波兰表达式：给出一个随意的逆波兰表达式，如果式子正确，则输出结果。式子不正确，则输出-1**

题目分析：  
1. 这道题主要是对逆波兰式子规范进行判断，其不符合的情况有：  
- 数字和字母的位置分配不正确  
- 相除出现小数  
- 运算后栈中数字残余  
2. 问题1使用try catch捕捉异常，防止取空栈    
3. 问题2就是检查不能除尽就抛出异常让前面捕捉  
4. 问题3在输出前检查栈中是否只剩下一个数  

```java
public static void main(String[] args) {
	Scanner input=new Scanner(System.in);
	String[] arr=input.nextLine().split(",");
	System.out.println(f(arr));
	
}

public static int f(String[] arr) {
	Stack stack=new Stack();
	try{
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].equals("+")||arr[i].equals("-")||arr[i].equals("*")||arr[i].equals("/")){
				int b=Integer.parseInt((String)stack.pop());
				int a=Integer.parseInt((String)stack.pop());
				stack.push(g(a,b,arr[i])+"");    //注意，存入int就不能再将其转化为int了，所以逆波兰表达式一般存入的是String
			}else{
				stack.push(arr[i]);
			}
		}
		if(stack.size()==1){    //栈不清完也是错误情况
			return Integer.parseInt((String)stack.pop());			
		}else{
			return -1;
		}
	}catch(Exception e){     //只要一pop不出来就捕捉异常
		return -1;
	}
	
}

public static int g(int a, int b, String st) throws Exception {
	if(st.equals("+")){
		return a+b;
	}else if(st.equals("-")){
		return a-b;
	}else if(st.equals("*")){
		return a*b;
	}else{
		if(a%b!=0){
			throw new Exception("no /");
		}
	}
	return a/b;
	
}
```
_注意：运算后重新存入栈中要转化为字符串，否者后面再次转化为int会出错_

---

## 11.二叉树排序

二叉树是每个节点最多有两个子树的树结构。通常子树被称作“左子树”和“右子树”。二叉树常被用于实现二叉查找树和二叉堆。

**问题：使用二叉树排序数字100,50,80,60,30,90**

题目分析：  
1. 二叉树作为一个对象BiTree，其由int型的根部和BiTree的左根与右根  
2. 首先，通过构造函数添加根部数据  
3. 往第一个个根部添加分支，所以需要编写add方法  
add方法需要判断当前分支是否为null，为null就放入，否则就调用分支的add方法  
4. 遍历二叉树的方法：一直寻找左边，直到为空，输出中间内容，再找右边  

```java
public class Main {
	public static void main(String[] args) {
		BiTree biTree=new BiTree(100);
		biTree.add(new BiTree(50));
		biTree.add(new BiTree(80));
		biTree.add(new BiTree(60));
		biTree.add(new BiTree(30));
		biTree.add(new BiTree(90));
		
		biTree.show();
		
	}
}
class BiTree{
	int gen;
	BiTree zuo;
	BiTree you;
	
	public BiTree(int num) {
		this.gen=num;
	}

	public void show() {
		if(this.zuo!=null){
			this.zuo.show();
		}
		System.out.println(this.gen);
		if(this.you!=null){
			this.you.show();
		}
	}

	public void add(BiTree biTree) {
		if(biTree.gen>this.gen){
			if(this.zuo==null){
				this.zuo=biTree;
			}else{
				this.zuo.add(biTree);   //往分支再调用add方法
			}
		}else{
			if(this.you==null){
				this.you=biTree;
			}else{
				this.you.add(biTree);
			}
		}
	}
	
}
```

---




