# Excel地址

D：今天快速做一道简单的题目

```
标题： Excel地址

Excel单元格的地址表示很有趣，它使用字母来表示列号。
比如，
A表示第1列，
B表示第2列，
Z表示第26列，
AA表示第27列，
AB表示第28列，
BA表示第53列，
....

当然Excel的最大列号是有限度的，所以转换起来不难。
如果我们想把这种表示法一般化，可以把很大的数字转换为很长的字母序列呢？

本题目既是要求对输入的数字, 输出其对应的Excel地址表示方式。

例如，
输入：
26
则程序应该输出：
Z

再例如，
输入：
2054
则程序应该输出：
BZZ

我们约定，输入的整数范围[1,2147483647]

资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 1000ms


请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。

所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
不要使用package语句。不要使用jdk1.7及以上版本的特性。
主类的名字必须是：Main，否则按无效代码处理。

------------------------------

笨笨有话说：
    这有点像进制关系，又不完全是。好像末2位是以1当26，末3位是以1当26*26

歪歪有话说：
    要是从字母序列转数字还好点，倒过来有点麻烦，不过计算机跑得快啊。
```

M: 这道题当初做过，但是现在没有太大印象。

Z: 题不难，研究却花不少时间，思路一直禁锢在处理26的时候不进一的问题上

```java
import java.util.Scanner;

public class Main2 {
	static String result = "";
	public static void main(String[] args) {
		int num = 2054;
		change(num);
		System.out.println(result);
	}

	private static void change(int num) {
		int tail = num % 26;
		if(tail > 0){ 
			tail(tail);
			num = (num-tail) / 26;
		}else{
			tail(26);
			num = (num-tail) / 26 -1;    
		}
		if(num > 26){     //处理后值仍然大于26，需要再处理
			change(num);
		}else{
			if(num > 0){
				tail(num);   //小于26，说明不能再进制，直接输出即可
			}
		}	
	}

	private static void tail(int tail) {
		result = (char)(tail+64) + result; 
	}

}
```

处理被%的值，主要就分为两种情况：

1. 值不为26
2. 值为26，需要单独处理，不进1

M：使用ASCLL来对应数字与字母，但是为什么知道是64呢？

Z:  在java中，直接打印``(int)'A'``就可以获取该字符的ASCLL码。而要将ASCLL码转化为字符，则数字前加上（char）就可以了。   