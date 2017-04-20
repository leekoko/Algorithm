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

## 2.排序字符串

先转化为字符数组，sort排序后再转化为String字符串

问题：给你字符串vsghvukdn,要求排序后输出

```java

public static void main(String[] args) {
	String st="vsghvukdn";
	char[] temp=st.toCharArray();
	Arrays.sort(temp);
	System.out.println(new String(temp));
	
}
```
``待定：对应的大题``
---
