# 赢球票

D：来一道简单的题目

```
赢球票

某机构举办球票大奖赛。获奖选手有机会赢得若干张球票。

主持人拿出 N 张卡片（上面写着 1~N 的数字），打乱顺序，排成一个圆圈。
你可以从任意一张卡片开始顺时针数数: 1,2,3.....
如果数到的数字刚好和卡片上的数字相同，则把该卡片收入囊中，从下一个卡片重新数数。
直到再无法收获任何卡片，游戏结束。囊中卡片数字的和就是赢得球票的张数。

比如：
卡片排列是：1 2 3
我们从1号卡开始数，就把1号卡拿走。再从2号卡开始，但数的数字无法与卡片对上，
很快数字越来越大，不可能再拿走卡片了。因此这次我们只赢得了1张球票。

还不算太坏！如果我们开始就傻傻地从2或3号卡片数起，那就一张卡片都拿不到了。

如果运气好，卡片排列是 2 1 3
那我们可以顺利拿到所有的卡片！

本题的目标就是：已知顺时针卡片序列。
随便你从哪里开始数，求最多能赢多少张球票（就是收入囊中的卡片数字之和）

输入数据：
第一行一个整数N(N<100)，表示卡片数目
第二行 N 个整数，表示顺时针排列的卡片

输出数据：
一行，一个整数，表示最好情况下能赢得多少张球票

比如：
用户输入：
3
1 2 3

程序应该输出：
1

比如：
用户输入：
3
2 1 3

程序应该输出：
6

资源约定：
峰值内存消耗 < 256M
CPU消耗  < 1000ms

请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。

所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
注意：不要使用package语句。不要使用jdk1.7及以上版本的特性。
注意：主类的名字必须是：Main，否则按无效代码处理。
```

M：不太理解为什么下面情况可以全部拿走，答案为6，到底我是哪里理解错了。

```
3
2 1 3
```

Z：主要是循环的关系，拿的顺序可以这样：

``` 
2 1 3
从第二位开始，第二位=1，刚好数到1，拿走第二位：2 3
从原第三位开始，第三位=1，重新数到1，不拿走：2 3
回到原第一位开始，第一位=2，刚好数到2，拿走原第一位：3
从原第三位开始，第三位=3，重新数到1，不拿走：3
从原第三位开始，第三位=3，数到2，不拿走：3
从原第三位开始，第三位=3，数到3，拿走原第三位：null 
全部被拿走，值为 2+1+3=6
```

M：刚刚尝试做了一下，由于数组没有回溯，一直找不到问题

```java
import java.util.Scanner;

/*用户输入：
3
2 1 3

程序应该输出：
6*/
public class Test{
	static int maxIn = 0;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num  = input.nextInt();
		int[] arr = new int[num];
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = input.nextInt();
			if(arr[i] > maxIn){
				maxIn = arr[i];
			}
		}
		for (int i = 0; i < arr.length; i++) {
			boolean[] check = new boolean[num];  //回溯标记
			int result = run(arr, check, i);
			if(result > max){
				max = result;
			}
		}
		System.out.println(max);
	}
	/**
	 * 返回手中的牌数
	 * @param arr      数组
	 * @param check       标记数组
	 * @param startPoint   开始数的数组位置
	 * @return
	 */
	private static int run(int[] arr, boolean[] check, int startPoint) {
		int sum = 0;
		int numPoint = 1;
		while(numPoint <= maxIn && hasFalse(check)){
			startPoint = startPoint % arr.length;    //循環圓圈
			if(check[startPoint] == false){
				if(numPoint == arr[startPoint]){
					sum += arr[startPoint];
					check[startPoint] = true;
					numPoint = 1;   //从1开始数
					startPoint++;
					continue;
				}
				numPoint++;
			}
			startPoint++;
		}
		return sum;
	}
	/**
	 * 全部都已标记
	 * @param check
	 * @return
	 */
	private static boolean hasFalse(boolean[] check) {
		for (int i = 0; i < check.length; i++) {
			if(check[i] == false){
				return true;
			}
		}
		return false;
	}
		
}
```

M：为什么要判断是否全部为false

```java
		while(numPoint <= maxIn && hasFalse(check)){
			startPoint = startPoint % arr.length;    //循環圓圈
			if(check[startPoint] == false){
```

Z：因为numPoint的控制在``if(check[startPoint] == false){``判断里面，如果不判断的话，可能会进入死循环。所以要在全部都为false的情况下，跳出循环。   

M：怎么处理循环数字？

Z：使用mol就可以了``startPoint = startPoint % arr.length;    //循環圓圈``    

