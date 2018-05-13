# 小计算器

D:来一道真题，小计算器

```
标题：小计算器

模拟程序型计算器，依次输入指令，可能包含的指令有

1. 数字：'NUM X'，X为一个只包含大写字母和数字的字符串，表示一个当前进制的数
2. 运算指令：'ADD','SUB','MUL','DIV','MOD'，分别表示加减乘，除法取商，除法取余
3. 进制转换指令：'CHANGE K'，将当前进制转换为K进制(2≤K≤36)
4. 输出指令：'EQUAL'，以当前进制输出结果
5. 重置指令：'CLEAR'，清除当前数字

指令按照以下规则给出：
数字，运算指令不会连续给出，进制转换指令，输出指令，重置指令有可能连续给出
运算指令后出现的第一个数字，表示参与运算的数字。且在该运算指令和该数字中间不会出现运算指令和输出指令
重置指令后出现的第一个数字，表示基础值。且在重置指令和第一个数字中间不会出现运算指令和输出指令
进制转换指令可能出现在任何地方

运算过程中中间变量均为非负整数，且小于2^63。
以大写的'A'~'Z'表示10~35

[输入格式]
第1行：1个n，表示指令数量
第2..n+1行：每行给出一条指令。指令序列一定以'CLEAR'作为开始，并且满足指令规则

[输出格式]
依次给出每一次'EQUAL'得到的结果

[样例输入]
7
CLEAR
NUM 1024
CHANGE 2
ADD
NUM 100000
CHANGE 8
EQUAL

[样例输出]
2040

资源约定：
峰值内存消耗 < 256M
CPU消耗  < 1000ms

请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。

所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
注意：不要使用package语句。不要使用jdk1.7及以上版本的特性。
注意：主类的名字必须是：Main，否则按无效代码处理。
```
Z：这道题主要是模拟计算机的命令：功能1，运算。功能2，进制转化。

M：要怎么实现动态的进制转化呢？

Z：看一下网友的代码实现

```java
import java.util.Scanner;

public class Main3
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int jinZhi = 10;
		int x = 0;
		String yunSuan = "ADD";
		scanner.nextLine();
		for(int i=0;i<n;i++)
		{
			String string = scanner.nextLine();
			if(string.indexOf("CLEAR")!=-1)x=0;
			else if(string.indexOf("NUM")!=-1){
				string = string.split(" ")[1];
				if(yunSuan.indexOf("ADD")!=-1)x += Integer.parseInt(string, jinZhi);
				else if(yunSuan.indexOf("SUB")!=-1)x -= Integer.parseInt(string, jinZhi);
				else if(yunSuan.indexOf("MUL")!=-1)x *= Integer.parseInt(string, jinZhi);
				else if(yunSuan.indexOf("DIV")!=-1)x /= Integer.parseInt(string, jinZhi);
				else if(yunSuan.indexOf("MOD")!=-1)x %= Integer.parseInt(string, jinZhi);
			}
			else if(string.indexOf("ADD")!=-1)
			{
				yunSuan = "ADD";
			}
			else if(string.indexOf("SUB")!=-1)
			{
				yunSuan = "SUB";
			}
			else if(string.indexOf("MUL")!=-1)
			{
				yunSuan = "MUL";
			}
			else if(string.indexOf("DIV")!=-1)
			{
				yunSuan = "DIV";
			}
			else if(string.indexOf("MOD")!=-1)
			{
				yunSuan = "MOD";
			}
			else if(string.indexOf("CHANGE")!=-1)
			{
				string = string.split(" ")[1];
				jinZhi = Integer.parseInt(string);
			}
			else if(string.indexOf("EQUAL")!=-1)
			{
				System.out.println(Integer.toString(x, jinZhi));
			}
			else if(string.indexOf("CLEAR")!=-1)
			{
				x=0;
				yunSuan="ADD";
			}
		}
	}

}
```

十进制转化为二进制竟然有现成的方法``Integer.toString(x, jinZhi)``,我试了一下

```java
System.out.println(Integer.toString(5, 2));    //原数    进制数
```

蛮好用的...

另外还有逆向过来的，其他进制转化为十进制

```java
Integer.parseInt("100000", 2);     //一个2进制数100000转化为十进制：32
```

M：进制转化的命令，是会不会对输入之前的数影响？如果数转化进制参与运算之后，结果是否还需要转化进制？

Z：看一下案例执行的过程就知道

```
7
CLEAR 
NUM 1024
CHANGE 2
ADD
NUM 100000
CHANGE 8
EQUAL
```

M：进制转换指令可能出现在任何地方，意思就是我们输入第一个数根本就不知道它是几进制的，怎么办？而且输出结果是否要再转化进制？

Z：在哪个地方转化进制，从题目中确实不好理解处理。回到这道题目的主题，这是一个小计算器。它目的是计算两个数的结果，并且进行进制转化。

如果从字面理解，有的数转成二进制，有的数还是十进制，两者再进行运算，那肯定是一个没有什么意义的结果。

所以应从产品的方向思考，这应该是一个有意义的结果，所以两个数的进制数应该是相同的。

观察案例可知1024加上10000的值为1040，这么大幅度的变化，可以猜测出10000应该是一个被转化后的二进制。所以运算前要对第二个数进行进制转化。统一转化为十进制进行运算存储：

```java
if(yunSuan.indexOf("ADD")!=-1)x += Integer.parseInt(string, jinZhi);
```

M：为什么用nextLine()而不用next()？

Z：因为输入的内容是以每行为单位，其中有空格，如果使用next识别的是以空格隔开为单位。

而使用nextLine()也有缺陷，就是从nextInt到nextLine，第一行不能获取到，所以需要排除掉。

Z：下面是我自己另外写的版本，与上面类似：

```java
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		String[] arr = new String[num];
		input.nextLine();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = input.nextLine();
		}
		runCommond(arr);
	}
	/**
	 * 获取命令
	 * @param arr
	 */
	private static void runCommond(String[] arr) {
		Integer firstNum = -1;
		int jinzhi = 10;
		String commond = "";
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].contains("NUM")){
				String[] tempArr = arr[i].split(" ");
				if(firstNum == -1){   //第一个数的情况
					firstNum = Integer.parseInt(tempArr[1]);
				}else{
					firstNum = operation(firstNum,commond,jinzhi,tempArr[1]);
				}
			}else if(arr[i].contains("ADD")){
				commond = "ADD";
			}else if(arr[i].contains("SUB")){
				commond = "SUB";
			}else if(arr[i].contains("MUL")){
				commond = "MUL";
			}else if(arr[i].contains("DIV")){
				commond = "DIV";
			}else if(arr[i].contains("MOD")){
				commond = "MOD";
			}else if(arr[i].contains("CHANGE")){
				String[] tempArr = arr[i].split(" ");
				jinzhi = Integer.parseInt(tempArr[1]);
			}else if(arr[i].contains("EQUAL")){
				System.out.println(Integer.toString(firstNum,jinzhi));   //输出转化进制后的数
			}else if(arr[i].contains("CLEAR")){
				firstNum = -1;
			}
		}
	}
	/**
	 * 两数计算
	 * @param firstNum   第一个数
	 * @param commond    符号
	 * @param jinzhi     进制数
	 * @param second     第二个数
	 * @return
	 */
	private static Integer operation(Integer firstNum, String commond, int jinzhi, String second) {
		int secondTen = Integer.parseInt(second,jinzhi);   //转化为十进制数
		int result = -1;
		if(commond.contains("ADD")){
			result = firstNum + secondTen;
		}else if(commond.contains("SUB")){
			result = firstNum - secondTen;
		}else if(commond.contains("MUL")){
			result = firstNum * secondTen; 
		}else if(commond.contains("DIV")){
			result = firstNum / secondTen;
		}else if(commond.contains("MOD")){
			result = firstNum % secondTen;
		}
		return result;
	}
	
}	
```

M：总结一下，这道题主要要知道进制的转化方法：

	1. 10转n：``Integer.toString(firstNum,jinzhi);``   
	2. n转10：``Integer.parseInt(second,jinzhi);``   

进制的转化时机，从产品的角度来理解这道题，需要一个有意义的答案，所以都转化为十进制进行运算存储，最后统一转为指定进制的值。