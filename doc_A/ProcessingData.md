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

## 2.合成法

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

---

