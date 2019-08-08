import java.util.Scanner;

/*11.带分数
    100 可以表示为带分数的形式：100 = 3 + 69258 / 714
    还可以表示为：100 = 82 + 3546 / 197
    注意特征：带分数中，数字1~9分别出现且只出现一次（不包含0）。
    类似这样的带分数，100 有 11 种表示法。
题目要求：
从标准输入读入一个正整数N (N<1000*1000)
程序输出该数字用数码1~9不重复不遗漏地组成带分数表示的全部种数。
注意：不要求输出每个表示，只统计有多少表示法！

例如：
用户输入：
100
程序输出：
11

再例如：
用户输入：
105
程序输出：
6

资源约定：
峰值内存消耗（含虚拟机） < 64M
CPU消耗  < 3000ms*/

public class Main {
/*	题目分析：
题目分析：
1.循环a与c，根据公式算出b的值     c为什么循环到10000，因为用最大的数除以10000最多也只有100
2.获取到abc之后要判断其出现且仅出现一次（不包括0，所以统计的时候要减去0）
3.判断的时候要判断，每个数出现的总和是9并且有出现的数的总和也是9

*/
//	100 = 3 + 69258 / 714
public static void main(String[] args) {
	Scanner input=new Scanner(System.in);
	int num=input.nextInt();
	int count=0;
	for (int a = 1; a < num; a++) {
		for (int b = 1; b < 1000000/num; b++) {
			int c=(num-a)*b;   //转化除法为乘法
			String all=""+a+b+c;
			int[] arr=new int[10];
			int rel=0;
			for (int i = 0; i < all.length(); i++) {
				arr[all.charAt(i)-'0']=1;
				rel++;   //计算数字出现的次数
			}
			int temp=0;
			for (int i = 1; i < arr.length; i++) {
				temp+=arr[i];    //统计是否每个数字都有出现
			}
			if(rel==9&&temp==9){
				count++;
			}
			
		}
	}
	System.out.println(count);
}
}
