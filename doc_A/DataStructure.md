# 数据结构  

收集数据结构的相关知识：栈,队列,二叉树...  

---

## 1.栈  

**问题：判断1 2 3 4 5 6能不能利用栈变成6 5 4 3 2 1**

```java
public static void main(String[] args) {
	Stack<Integer> stack=new Stack<Integer>();
	int[] arr={1,2,3,4,5,6};
	for (int i = 0; i < arr.length; i++) {
		stack.push(arr[i]);
	}
	for (int i = 0; i < arr.length; i++) {
		System.out.print(stack.pop()+" ");
	}
}
```
[出栈次序](../doc_B/doc_B/Stack.md#1出栈次序)  
[铁轨](../doc_B/doc_B/Stack.md#2铁轨)  

---