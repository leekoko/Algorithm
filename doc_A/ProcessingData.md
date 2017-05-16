# 数据处理

这是利用数组的一些基础知识

---

## 1.数字互不相同

数字互不相同就是利用数组脚标，来记录这个数字有没有出现过

**问题1：判断3,4,2,1,6,0,5,3每个数字出现的次数**

```java
public static void main(String[] args) {
	int[] arr=new int[20];
	int[] num={3,4,2,1,6,0,5,3};
	for (int i = 0; i < num.length; i++) {
		arr[num[i]]=1;
	}
	int count=0;   //有多少种数字的个数
	for (int i = 0; i < arr.length; i++) {
		if(arr[i]==1){
			count++;			
		}
	}
	System.out.println(count);
}
```
**问题2：计算1-9的21次方，存进数组中**

题目分析：  
1. 这里用到了BigInteger与其运算方法bi.multiply(xxx);  

```java
	public static void main(String[] args) {
		BigInteger[] arr=new BigInteger[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=f(i);
		}
		show(arr);
	}

	public static void show(BigInteger[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static BigInteger f(int num) {
		BigInteger bi=new BigInteger("1");  //相乘的初始化为1
		for (int i = 0; i < 21; i++) {
			bi=bi.multiply(new BigInteger(num+""));
		}
		return bi;
	}
```
**问题3：遍历21位数字     （只知道每个数出现的次数，而不是具体位置）**

题目分析：  
1. 怎么遍历每一种情况呢，计算每个数字出现的次数  
2. 所以需要两个参数，指针point和数量sum，执行递归方法  
3. 递归是为，将21个可能一个个代进point位置里面，进行下一层递归（最后回溯函数）  
4. 递归的结点是：1.当sum全部使用完毕之后，显示计数数组的内容  
5. 当指针指向最后一个数字的时候，将剩余所有的数字都给它，sum清0  

```java
	public static void main(String[] args) {
		int[] arr=new int[10];
		f(arr,0,21);
	}

	public static void f(int[] arr, int point, int sum) {
		if(sum==0){
			show(arr);
			return;
		}
		if(point==arr.length-1){
			arr[point]=sum;
			f(arr,point+1,0);
			return;
		}
		for (int i = 0; i < sum; i++) {
			arr[point]=i;
			f(arr,point+1,sum-i);
			arr[point]=0;
		}
	}

	public static void show(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(i+":"+arr[i]);
		}
		System.out.println();
	}
```

[买不到的数目](../doc_B/DifferentNum.md#1买不到的数目)  
[花朵数](../doc_B/DifferentNum.md#2花朵数)  

---

## 2.暴力破解法：合成&拆分

### 合成法

通过枚举每一项，进行合成，筛选后输出正确的数字（当对数字每一项进行操作的时候使用）

**问题：输出从大到小的三位数偶数**

```java
public static void main(String[] args) {
	for(int a=1;a<10;a++){  //第一位从1开始
		for (int b = 0; b < 10; b++) {
			for (int c = 0; c < 10; c++) {
				int c1=a*100+b*10+c;    //合成的过程
				if(c1%2==0&&a>b&&b>c){
					System.out.println(c1);
				}
			}
		}
	}
}
```
[神奇算式](../doc_B/Violence.md#1神奇算式)  
[熄灯问题](../doc_B/Violence.md#2熄灯问题)  
[讨厌的青蛙](../doc_B/Violence.md#3讨厌的青蛙) 

---

### 拆分法

将一个数字的各项提取出来进行运算。相比合成法，拆分法对单个数字控制更小,但是写起来更简洁

**问题：输出从大到小的三位数偶数**

```java
public static void main(String[] args) {
	for (int i = 100; i < 1000; i++) {
		int a=i/100;
		int b=i/10%10;
		int c=i%10;
		if(i%2==0&&a>b&&b>c){
			System.out.println(i);
		}
	}
}
```
``待定：对应的大题``

---

## 3.循环删除

用数组存储数字，删除规定的数字，后面的值顶替上来，以此循环，一直到最后一个值就是结果

**问题：数字1，2，3，4，5   删除奇数位置上的数，形成的新串再删除奇数位置上的数，求最后留下的数**

分析：这道题涉及奇偶，需要利用要存入数是当前这个数的2倍，而不能用ArrayList，因为ArrayList删除一个坐标就会变一次，相当混乱。所以用普通数组+规律。

```java
public static void main(String[] args) {
	int[] arr={1,2,3,4,5};
	int size=arr.length; 
	while(size>1){
		//因为剩余偶数项，偶数比较少，所以直接去尾（奇数还得考虑加不加1）
		size=size/2;       
		for (int i = 0; i < size; i++) {
			arr[i]=arr[i]*2;
		}		
	}
	System.out.println(arr[0]);
}
```
[猜字母](../doc_B/LoopDelete.md#1猜字母) 

---

## 4.递归

递归就是通过调用自身将问题细化，一直循环到结点

**问题1：使用递归的方式打印0到9**

分析：递归式可以在筛选条件里面，也可以在外面

方法1：写在筛选条件里边

```java
public static void main(String[] args) {
	f(9);
}

public static void f(int num) {
	if(num>0){
		f(num-1);
	}
	System.out.println(num);
}
```
方法2：写在筛选条件外边（需要加参数，相比之下，开头更可控）

```java
public static void main(String[] args) {
	f(0,9);   //找相似性：填参数
}

public static void f(int begin, int end) {
	if(begin==end){ //不能继续
		return;
	}
	System.out.println(begin);
	f(begin+1,end);
}
```

**问题2：3个A，2个B，能组成多少排列   (两组有差异)**

分析：这里是有明显差异性：取A没取B，或者取B没取A

```java
public static void main(String[] args) {
	System.out.println(f(3,2));
}

public static int f(int m, int n) {
	if(m==0||n==0){
		return 1;
	}
	return f(m-1,n)+f(m,n-1);
}
```

**问题3：在3个球中，任意取出2个（不放回），求有多少种不同的取法  (两组无差异性)**

分析：这里是一个类似于完整无缺的组合，通过我们自己对它进行区分来构造差异性  
假设里面有一个奇特球，其差异性就是，取了一个球：取得到奇特球+取不到  

```java
	public static void main(String[] args) {
		System.out.println(f(3,2));
	}

	public static int f(int n, int m) {
		if(m==0){   //m是先完的数
			return 1;
		}
		if(m==n){   //取的等于原有的，一种结果
			return 1;
		}
		if(m>n){     //m很有可能大于n，这是不符合的情况  因为这个关系，不用判断n==0
			return 0;
		}
		return f(n-1,m-1)+f(n-1,m);   //取了指定一个&没取指定那个
	}
```

**问题4：求两个串的最大公共子序列的长度:"abc","xbacd"(选优情况)**

分析：对比返回数量的递归式，其结点为：  
1. 当长度为0的情况  
2. 当头字母相同，返回后面的情况+数量1

```java
	public static void main(String[] args) {
		System.out.println(f("abc","xbacd"));
	}

	public static int f(String st1, String st2) {
		if(st1.length()==0||st2.length()==0){
			return 0;
		}
		if(st1.charAt(0)==st2.charAt(0)){
			return f(st1.substring(1),st2.substring(1))+1;
		}
		return Math.max(f(st1.substring(1),st2), f(st1,st2.substring(1)));
	}
```



[奇怪的比赛](../doc_B/Recursion.md#1奇怪的比赛)   
[加法划分](../doc_B/Recursion.md#2加法划分)  
[绳圈](../doc_B/Recursion.md#3绳圈)  

---
















































