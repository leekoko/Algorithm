# 尼姆游戏

## 1.取球游戏
>今盒子里有n个小球，A、B两人轮流从盒中取球，每个人都可以看到另一个人取了多少个，  
>也可以看到盒中还剩下多少个，并且两人都很聪明，不会做出错误的判断。  
>我们约定：  
>每个人从盒子中取出的球的数目必须是：1，3，7或者8个。  
>轮到某一方取球时不能弃权！  
>A先取球，然后双方交替取球，直到取完。  
>被迫拿到最后一个球的一方为负方（输方）  
>
>请编程确定出在双方都不判断失误的情况下，对于特定的初始球数，A是否能赢？  
>程序运行时，从标准输入获得数据，其格式如下：  
>先是一个整数n(n<100)，表示接下来有n个整数。然后是n个整数，每个占一行（整数<10000），表示初始球数。  
>程序则输出n行，表示A的输赢情况（输为0，赢为1）。  
>例如，用户输入：  
>4  
>1  
>2  
>10  
>18  
>则程序应该输出：  
>0  
>1  
>1  
>0  

---

题目分析：  
1. 输入一个数判断自己能不能赢，使用递归的方式判断  
2. 尝试各种不同的取法，要是能让对方输就执行，否则最终自己执行  
3. 由于数值重复运算较多，所以使用缓存区  

```java
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int num=input.nextInt();
		int[] arr=new int[num];
		for (int i = 0; i < num; i++) {
			arr[i]=f(input.nextInt());
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static int f(int num) {
		if(num>1&&f(num-1)==0){  //有得取，取完别人输
			return 1;  //相当于我赢
		}
		if(num>3&&f(num-3)==0){  //有得取，取完别人输
			return 1;  //相当于我赢
		}
		if(num>7&&f(num-7)==0){  //有得取，取完别人输
			return 1;  //相当于我赢
		}
		if(num>8&&f(num-8)==0){  //有得取，取完别人输
			return 1;  //相当于我赢
		}
		return 0;   //最后我输
	}
```
[源码](../SourceCode/GetBallGame.java)

---








