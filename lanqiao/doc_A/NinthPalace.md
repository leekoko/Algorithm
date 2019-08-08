# 九宫幻方

D: 今天做一道题目  九宫幻方

```
小明最近在教邻居家的小朋友小学奥数，而最近正好讲述到了三阶幻方这个部分。
三阶幻方指的是将1~9不重复的填入一个3*3的矩阵当中，使得每一行、每一列和每一条对角线的和都是相同的。	
三阶幻方又被称作九宫格，在小学奥数里有一句非常有名的口诀： “二四为肩，六八为足，左三右七，戴九履一，五居其中”， 通过这样的一句口诀就能够非常完美的构造出一个九宫格来。	
4  9  2 
3  5  7
8  1  6 

有意思的是，所有的三阶幻方，都可以通过这样一个九宫格进行若干镜像和旋转操作之后得到。 现在小明准备将一个三阶幻（不一定是上图中的那个）中的一些数抹掉，交给邻居家的小朋友来进行还原，并且希望她能够判断出究竟是不是只有一个解。 
而你呢，也被小明交付了同样的任务，但是不同的是，你需要写一个程序~ 

输入格式： 
输入仅包含单组测试数据。 每组测试数据为一个3*3的矩阵，其中为0的部分表示被小明抹去的部分。 对于100%的数据，满足给出的矩阵至少能还原出一组可行的三阶幻方。 
输出格式： 
如果仅能还原出一组可行的三阶幻方，则将其输出，否则输出“Too Many”（不包含引号）。 

样例输入
0  7  2 
0  5  0
0  3  0

样例输出
6  7  2
1  5  9
8  3  4
 
本题思路为列出所有的九宫幻方，将输入的数字与其一 一比较，用字符串来储存幻方。
```

Z: 这道题题意大概是，通过上方的幻方本体，可以变化成所有不同的幻方。而我们要做的就是将被抹掉的数字还原。如果还原情况有多种，则返回``Too Many``

M: 这题没有什么太好的思路，求解！

Z: 我先把答案给出来：

```java
import java.util.Scanner;

public class Main2 {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s = "";
		for (int i = 0; i < 9; i++) {
			s += input.next();   //输入间隔字符
		}
		
		String[] arr = {    //所有情况列出
			"492357816",	
			"294753618",	
			"438951276",	
			"276951438",	
			"618753294",	
			"816357492",	
			"672159834",	
			"834159672",	
		};
		int arrIndex = -1;
		for (int i = 0; i < arr.length; i++) {
			if(test(arr[i],s)){
				if(arrIndex == -1){   //首次
					arrIndex = i;
				}else{
					System.out.println("Too Many");  //多次
					return;
				}
			}
		}
		show(arr[arrIndex]);
	}
	/**
	 * 判断是否符合
	 * @param str
	 * @param s
	 * @return
	 */
	private static boolean test(String str, String s) {
		for (int i = 0; i < str.length(); i++) {
			if(s.charAt(i) == '0'){
				continue;
			}
			if(str.charAt(i) != s.charAt(i)){
				return false;
			}
		}
		return true;
	}
	/**
	 * 打印
	 * @param str
	 */
	private static void show(String str) {
		for (int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(i)+" ");
			if((i+1) % 3 == 0){   //加法先运算需要加括号
				System.out.println();
			}
		}
	}

}  
```

M: 这道题我大概明白了，就是将所有可能的情况列出来，对已知的数据进行匹配。

Z: 以后遇到这种转化的题目，

1. 具有二维特征的数字，转化为一维进行处理。
2. 考虑它们的所有变化情况是否 少量有限 ，是的话就可以逐个进行匹配。

