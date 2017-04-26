# 1. 素数

---

## 1.第100002个素数
>求第100002个素数是多少？

---

题目分析：  
这里主要有三种方式进行加速：  
1. 质数（素数）都是奇数  
2. 求质数mol的值都是质数，其他根本不用考虑，已经包含在质数中了，所以要把质数存进数组里面（个数记得加上）  
3. ！！当求的这个质数小于被mol的质数的平方，不用看了，这就是质数  

```java
static ArrayList<Integer> al;
public static void main(String[] args) {
	al=new ArrayList<Integer>();
	al.add(2);
	al.add(3);
	al.add(5);
	al.add(7);
	
	int count=4;
	
	for (int i = 11; ; i+=2) {
		if(isPrime(i)){
			count++;
			if(count==100002){
				System.out.println(i);
				return;
			}
		}
		
	}
}

private static boolean isPrime(int num) {
	for (int j = 0; j < al.size(); j++) {
		if(num%al.get(j)==0){
			return false;
		}
		if(num<al.get(j)*al.get(j)){
			break;
		}
	}
	al.add(num);
	return true;
}
```
[源码](../SourceCode/Prime100002.java)

---


