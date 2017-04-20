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