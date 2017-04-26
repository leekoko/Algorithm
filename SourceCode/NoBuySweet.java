import java.util.Scanner;

/*12.买不到的数目
    小明开了一家糖果店。他别出心裁：把水果糖包成4颗一包和7颗一包的两种。糖果不能拆包卖。
    小朋友来买糖的时候，他就用这两种包装来组合。当然有些糖果数目是无法组合出来的，比如要买 10 颗糖。
    你可以用计算机测试一下，在这种包装情况下，最大不能买到的数量是17。大于17的任何数字都可以用4和7组合出来。
    本题的要求就是在已知两个包装的数量时，求最大不能组合出的数字。
输入：
两个正整数，表示每种包装中糖的颗数(都不多于1000)

要求输出：
一个正整数，表示最大不能买到的糖数
不需要考虑无解的情况
例如：
用户输入：
4 7
程序应该输出：
17

再例如：
用户输入：
3 5
程序应该输出：
7

资源约定：
峰值内存消耗（含虚拟机） < 64M
CPU消耗  < 3000ms
*/
public class Main {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int num1=in.nextInt();
		int num2=in.nextInt();
		int N=100000;   //定义数值足够大，这里用1000 00 （不能加0了）
		int[] arr=new int[N];
		for (int i = 0; i < N/num1; i++) {
			for (int j = 0; j < (N-i*num1)/num2; j++) {
				arr[i*num1+j*num2]=1;
			}
		}
		int count=0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==1){
				count++;
				if(count==num1){
					System.out.println(i-num1);
					return;
				}else if(count==num2){
					System.out.println(i-num2);
					return;
				}
			}else{
				count=0;
			}
		}
	}
}
