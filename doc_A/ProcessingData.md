# 多个数据处理

这是利用数组的一些基础知识

---

## 1.数字互不相同

数字互不相同就是利用数组脚标，来记录这个数字有没有出现过

问题：判断3,4,2,1,6,0,5,3每个数字出现的次数

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

``待定：对应的大题``

---

## 2.暴力破解法：合成&拆分

### 合成法

通过枚举每一项，进行合成，筛选后输出正确的数字（当对数字每一项进行操作的时候使用）

问题：输出从大到小的三位数偶数

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

``待定：对应的大题``

### 拆分法

将一个数字的各项提取出来进行运算。相比合成法，拆分法对单个数字控制更小,但是写起来更简洁

问题：输出从大到小的三位数偶数

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

问题：数字1，2，3，4，5   删除奇数位置上的数，形成的新串再删除奇数位置上的数，求最后留下的数

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

``待定：对应的大题   猜字母``

---


