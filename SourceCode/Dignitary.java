import java.util.Scanner;

import javax.xml.soap.Text;
/*7.高僧斗法
问题描述
　　古时丧葬活动中经常请高僧做法事。仪式结束后，有时会有“高僧斗法”的趣味节目，以舒缓压抑的气氛。
　　节目大略步骤为：先用粮食（一般是稻米）在地上“画”出若干级台阶（表示N级浮屠）。又有若干小和尚随机地“站”在某个台阶上。最高一级台阶必须站人，其它任意。(如图1所示)
　　两位参加游戏的法师分别指挥某个小和尚向上走任意多级的台阶，但会被站在高级台阶上的小和尚阻挡，不能越过。两个小和尚也不能站在同一台阶，也不能向低级台阶移动。
　　两法师轮流发出指令，最后所有小和尚必然会都挤在高段台阶，再也不能向上移动。轮到哪个法师指挥时无法继续移动，则游戏结束，该法师认输。
　　对于已知的台阶数和小和尚的分布位置，请你计算先发指令的法师该如何决策才能保证胜出。
输入格式
　　输入数据为一行用空格分开的N个整数，表示小和尚的位置。台阶序号从1算起，所以最后一个小和尚的位置即是台阶的总数。（N<100, 台阶总数<1000）
输出格式
　　输出为一行用空格分开的两个整数: A B, 表示把A位置的小和尚移动到B位置。若有多个解，输出A值较小的解，若无解则输出-1。
样例输入
1 5 9
样例输出
1 4
样例输入
1 5 8 10
样例输出
1 3
*/
public class Main {
/*	题目分析：
	1.没有数量限定的输入，需要用spilt方法
	2.首先要获取每个和尚的位置，遍历每个和尚，让其走尽可能的步数（到下一个和尚之前）
	3.走之前将old位置存起来，方便后面回溯
	4.判断对方走的结果是输，那我方就必胜
	5.判断对方是赢是输其实又是重复1,2，3,4的步骤（对手是相互的）
	只是对方的对比对象是自身方法（都一样），由于其return之后要执行回溯，所以需要添加try catch*/
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String[] temp=input.nextLine().split(" ");
		int[] arr=new int[temp.length];
		for (int i = 0; i < arr.length; i++) {   //转化为int
			arr[i]=Integer.parseInt(temp[i]);
		}
		for (int i = 0; i < arr.length-1; i++) {   //第一层循环最后一个和尚不需要行走
			for (int j = arr[i]+1; j < arr[i+1]; j++) {
				int old=arr[i];
				arr[i]=j;
				if(!f(arr)){
					System.out.println(old+" "+j);   //输出应该是旧的位置，而不是改后的arr[i]
					return;
				}
				arr[i]=old;   //回溯
			}
		}
	}

	public static boolean f(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = arr[i]+1; j < arr[i+1]; j++) {
				int old=arr[i];
				arr[i]=j;
				try{
					if(!f(arr)){
						return true;
					}
				}finally {
					arr[i]=old;
				}
			}
		}
		return false;
	}


}
