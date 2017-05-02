/*如，对于正整数n=6，可以分划为：
6
5+1
4+2, 4+1+1
3+3, 3+2+1, 3+1+1+1
2+2+2, 2+2+1+1,2+1+1+1+1
1+1+1+1+1+1+1
现在的问题是，对于给定的正整数n,编写算法打印所有划分。
用户从键盘输入 n（范围1~10）*/

public class Main {
/*	题目分析：
	1.前面设置数字，后面设置指针，现在第几个数
	2.递归式：将数字存入数组，剩下的传到下一级，计数+1
	3.节点：判断第一个数为0的时候，输出节点范围内的数组内容
	4.解决位置交换的重复：在存入数组之前判断：1.在非第一个数的情况下    2.要存入这个数如果比前一项大，就continue跳过*/
static int[] arr;
public static void main(String[] args) {
	arr=new int[10000];
	f(6,0);
}
public static void f(int num, int point) {
	if(num==0){
		for (int i = 0; i < point-1; i++) {
			System.out.print(arr[i]+"+");
		}
		System.out.print(arr[point-1]);   //解决最后一个不用+问题
		System.out.println();
	}
	
	for (int i = num; i >0; i--) {
		if(point>0&&i>arr[point-1]){
			continue;
		}
		arr[point]=i;
		f(num-i,point+1);
	}
}
}
