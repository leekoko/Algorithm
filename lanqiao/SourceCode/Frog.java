import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;
/*9.讨厌的青蛙

每只青蛙总是沿着一条直线跳跃稻田 • 且每次跳跃的距离都相同
请写一个程序, 确定: • 在各条青蛙行走路径中, 踩踏水稻最多的那一条上, 有多 少颗水稻被踩踏 •
例如, 图4中答案是7, 因为第6行上全部水稻恰好构成一 条青蛙行走路径
程序输入
• 从标准输入设备上读入数据
• 第一行上两个整数R, C, 分别表示稻田中水稻的行数和 列数, 1≤R, C≤5000
• 第二行是一个整数N, 表示被踩踏的水稻数量, 3≤N≤5000
• 在剩下的N行中, 每行有两个整数, 分别是一颗被踩踏水 稻的行号(1~R)和列号(1~C), 两个整数用一个空格隔开
• 且每棵被踩踏水稻只被列出一次 7 程序输出
• 从标准输出设备上输出一个整数
• 如果在稻田中存在青蛙行走路径, 则输出包含最多水稻 的青蛙行走路径中的水稻数量, 否则输出0

样例输入   //6 行 7 列
6 7 
14
2 1
6 6
4 2
2 5
2 6
2 7
3 4
6 1
6 2
2 3
6 3
6 4
6 5
6 7

样例输出
7*/





public class Main {
/*	题目分析：
	1.首先获取数据，获取水稻位置的时候，将其存进对象里面。因为用到对象，所以需要用ArrayList存储
	2.寻找头两个点：
	计算两个点的跨度
	4.筛选不符合的情况：
	当走之前就已经再田里（>=1）,跳过这个循环
	当到max的前一步之前（max初始化为2），如果已经越界了跳过循环（x跳x层的，y跳y层的）
	符合的话进行计算步数
	5.计算步数方法：
	只要没越界， 无限循环。拿出第一步的xy位置，每次都往上面添加距离。添加完之后判断新的点有没有存在（判断存不存在函数），不存在则取消这次跳动，步数归0
	6.筛选返回的步数
	调用步数方法之后会返回一个步数，判断其是否比最大的小，并且>2，如果符合的话，输出最大步数
*/
	static ArrayList<Sign> al;
	static int r;
	static int c;
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		r=input.nextInt();
		c=input.nextInt();
		int num=input.nextInt();
		al=new ArrayList<Sign>();
		int max=2;   //初始化最大步数为2
		for (int i = 0; i < num; i++) {
			al.add(new Sign(input.nextInt(), input.nextInt()));
		}
		for (int i = 0; i < al.size(); i++) {
			for (int j = i+1; j < al.size(); j++) {
				int dX=al.get(j).x-al.get(i).x;
				int dY=al.get(j).y-al.get(i).y;
				int tX=al.get(i).x-dX;
				int tY=al.get(i).y-dY;
				if(tX>=1&&tY>=1){
					continue;
				}
				if(al.get(i).x+dX*(max-1)>r||al.get(i).y+dY*(max-1)>c){
					continue;
				}
				if(al.get(i).x==6&&al.get(i).y==1){
					System.out.println("stop");
				}
				int step=f(al.get(i),dX,dY);
				if(step>max){
					max=step;
				}
			}
		}
		System.out.println(max);
	}
	public static int f(Sign sign, int dX, int dY) {
		int x=sign.x;
		int y=sign.y;
		int step=0;
		while(x<=r&&y<=c){
			if(!isCao(x,y)){
				return 0;
			}
			x=x+dX;
			y=y+dY;
			step++;   //多处一步补起点没有计算
		}
		return step;
	}
	private static boolean isCao(int x, int y) {
		for (int i = 0; i < al.size(); i++) {
			if(al.get(i).x==x&&al.get(i).y==y){
				return true;
			}
		}
		return false;
	}

}
class Sign{
	int x;
	int y;
	public Sign(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
}
