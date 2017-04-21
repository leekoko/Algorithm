# String字符串处理

这是对String字符串操作的一些方法

---

## 1.排序字符串

先转化为字符数组，sort排序后,再转化为String字符串

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

## 2.分组字符串

做一个截取方法，对其进行递归调用

问题：对abcdefg进行三个一组，不足补0

```java
public static void cut(String a) {
	if(a.length()>3){
		System.out.print(a.substring(0,3)+"\t");  //0-2:截头不截尾
		a=a.substring(3);   //从当前数开始
		cut(a);     //还没切完，递归调用自身
	}else{
		System.out.print(a);
		for (int i = 0; i < 3-a.length(); i++) {
			System.out.print("0");
		}
	}
}
```
``待定，对应的大题``

---


