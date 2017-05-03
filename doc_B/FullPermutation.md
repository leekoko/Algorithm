# 全排列

## 1.ABC回溯全排列
>列出字母ABC全排列的所有情况

---

题目分析：  
1. 将字符串转化为char数组  
2. 递归式：通过指定位置，将该位置与后面的数位置交换
3. 执行下一个数，执行完之后进行回溯
4. 结点就是当指针指向最后一个数的时候

```java
	static char[] arr="ABCD".toCharArray();
	public static void main(String[] args) {
		f(0);
	}

	public static void f(int point) {
		if (point==arr.length) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]);
			}
			System.out.println();
			return;
		}
		
		for (int i = point; i < arr.length; i++) {
			char temp=arr[point];
			arr[point]=arr[i];
			arr[i]=temp;
			f(point+1);
			temp=arr[point];
			arr[point]=arr[i];
			arr[i]=temp;
		}
	}
```
[源码](../SourceCode/ABC_Full.java)

---