import java.text.DecimalFormat;
import java.util.Scanner;

/*3.机器人行走
某少年宫引进了一批机器人小车。可以接受预先输入的指令，按指令行动。小车的基本动作很简单，只有3种：左转（记为L），右转（记为R），向前走若干厘米（直接记数字）。

例如，我们可以对小车输入如下的指令：15L10R5LRR10R20 则，小车先直行15厘米，左转，再走10厘米，再右转，…
不难看出，对于此指令串，小车又回到了出发地。
你的任务是：编写程序，由用户输入指令，程序输出每条指令执行后小车位置与指令执行前小车位置的直线距离。

输入、输出格式要求
用户先输入一个整数n（n<100），表示接下来将有n条指令。接下来输入n条指令。每条指令只由L、R和数字组成（数字是0~100之间的整数），每条指令的长度不超过256个字符。
程序则输出n行结果。每条结果表示小车执行相应的指令前后位置的直线距离。要求四舍五入到小数后2位。 例如：用户输入：
5
L100R50R10
3LLL5RR4L12
LL
100R
5L5L5L5

则程序输出：
102.96
9.06
0.00
100.00
0.00
题目分析：
1.首先要解决位置问题，定义xy全局变量
2.方向问题，使用xy两个数组
3.输入问题，最后用input.nextLine结尾
4.判断是不是数字，是的话把步数存起来，连续数字用*10累加
5.对步数对应方向进行行走，注意初始化步数，根据字符改变方向，注意%适配数组范围
6.输出保留两位数字，初始化x，y的值*/

public class Main {
	static int point=0;
	static int x=0;
	static int y=0;
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int num=in.nextInt();
		String[] arr=new String[num];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=in.next();
		}
		for (int i = 0; i < arr.length; i++) {
			run(arr[i]+"L");
		}
	}

	private static void run(String st) {
		int step=0;
		for (int i = 0; i < st.length(); i++) {
			char a=st.charAt(i);
			if(a>='0'&&a<='9'){
				step=step*10;
				step+=a-'0';
			}else{
				if(point%4==0){
					x=x-step;
				}else if(point%4==1){
					y=y+step;
				}else if(point%4==2){
					x=x+step;
				}else{
					y=y-step;
				}
				if(a=='L'){
					point+=3;
				}else if(a=='R'){
					point+=1;
				}
				step=0;
			}
		}
		System.out.println(new DecimalFormat("0.00").format(Math.sqrt(x*x+y*y)));
		x=0;
		y=0;
	}

}
