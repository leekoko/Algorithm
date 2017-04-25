# 1. 暴力破解法

---

## 1.神奇算式

>由4个不同的数字，组成的一个乘法算式，它们的乘积仍然由这4个数字组成。
>比如：
>210 x 6 = 1260
>8 x 473 = 3784
>27 x 81 = 2187
>都符合要求。
>如果满足乘法交换律的算式算作同一种情况，那么，包含上边已列出的3种情况，一共有多少种满足要求的算式。

---

题目分析：
1.这里需要解决三个问题：  
          a.左右数字相同     b.交换律不算     c.数字互不相同            
2.左右数字相同：将结果排序后进行比较  
3.交换律不算：限定前面的数小于后面的数  
4.数字互不相同，用自身与自身进行比较  

```java
	public static void main(String[] args) {
		int count=0;
		for (int i = 1; i < 100; i++) {
			for (int j = 10; j < 1000; j++) {
				String st=i+""+j;
				String result=i*j+"";
				if(st.length()!=4||result.length()!=4||i>=j){  //限定长度		前面小于后面（防止重复）
					continue;
				}
				if(f(st,result)){
					count++;
				}	
			}			
		}
		System.out.println(count);	
	}

	public static boolean f(String st, String jieguo) {
		char[] num1=st.toCharArray();
		char[] num2=jieguo.toCharArray();
		Arrays.sort(num1);   //排序进行对比
		Arrays.sort(num2);
		for (int i = 0; i < num2.length; i++) {    //判断相同
			if(num1[i]!=num2[i]){
				return false;
			}
		}
		for (int i = 0; i < num2.length; i++) {     //各个数字不同
			for (int j = i+1; j < num2.length; j++) {
				if(num2[i]==num2[j]){
					return false;
				}
			}
		}
		return true;
	}
```
[源码](../SourceCode/MagicFormula.java)

---





