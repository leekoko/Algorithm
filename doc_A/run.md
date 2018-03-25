# 闲聊蓝桥杯JAVA - 模拟行走

D:来一道比较需要细心的题目，兰顿蚂蚁

```
标题：兰顿蚂蚁

    兰顿蚂蚁，是于1986年，由克里斯·兰顿提出来的，属于细胞自动机的一种。

    平面上的正方形格子被填上黑色或白色。在其中一格正方形内有一只“蚂蚁”。
    蚂蚁的头部朝向为：上下左右其中一方。

    蚂蚁的移动规则十分简单：
    若蚂蚁在黑格，右转90度，将该格改为白格，并向前移一格；
    若蚂蚁在白格，左转90度，将该格改为黑格，并向前移一格。

    规则虽然简单，蚂蚁的行为却十分复杂。刚刚开始时留下的路线都会有接近对称，像是会重复，但不论起始状态如何，蚂蚁经过漫长的混乱活动后，会开辟出一条规则的“高速公路”。

    蚂蚁的路线是很难事先预测的。

    你的任务是根据初始状态，用计算机模拟兰顿蚂蚁在第n步行走后所处的位置。

【数据格式】

输入数据的第一行是 m n 两个整数（3 < m, n < 100），表示正方形格子的行数和列数。
接下来是 m 行数据。
每行数据为 n 个被空格分开的数字。0 表示白格，1 表示黑格。

接下来是一行数据：x y s k, 其中x y为整数，表示蚂蚁所在行号和列号（行号从上到下增长，列号从左到右增长，都是从0开始编号）。s 是一个大写字母，表示蚂蚁头的朝向，我们约定：上下左右分别用：UDLR表示。k 表示蚂蚁走的步数。

输出数据为两个空格分开的整数 p q, 分别表示蚂蚁在k步后，所处格子的行号和列号。


例如, 输入：
5 6
0 0 0 0 0 0
0 0 0 0 0 0
0 0 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
2 3 L 5
程序应该输出：
1 3

再例如, 输入：
3 3
0 0 0
1 1 1
1 1 1
1 1 U 6
程序应该输出：
0 0


资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 1000ms
```

Z:这道题我做过，下面提供一下思路

```java
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		//获取数据
		Scanner input=new Scanner(System.in);
		int row=input.nextInt();//获取行
		int column=input.nextInt();   //获取列
		
		int arr[][]=new int[row][column];//获取数组内容
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j]=input.nextInt();
			}
		}
		int r=input.nextInt();  //蚂蚁行
		int c=input.nextInt();   //蚂蚁列		
		String temp=input.next();//方向
		int t=0;
		if(temp.equals("U")){
			t=0;
		}else if(temp.equals("R")){
			t=1;
		}else if(temp.equals("D")){
			t=2;
		}else{
			t=3;
		}		
		Ant ant=new Ant(r,c,t);
		int step=input.nextInt();//步数
		
		//用for代表走的步数
		for (int i = 0; i < step; i++) {
			//行走方法
			Go(ant,arr);
		}		
		//输出蚂蚁的位置
		System.out.println(ant.r+" "+ant.c);
	}

	
	//写一个类，包含蚂蚁的位置，方向
	public static void Go(Ant ant,int arr[][]) {
		// TODO Auto-generated method stub
		if(arr[ant.r][ant.c]==1){
			ant.aspect=(ant.aspect+1)%4;   //方向改变
			arr[ant.r][ant.c]=0;   //格子颜色改变
			Run(ant);   //蚂蚁行走
		}else{
			ant.aspect=(ant.aspect+3)%4;
			arr[ant.r][ant.c]=1;
			Run(ant);
		}
		
	}

	private static void Run(Ant ant) {
		if(ant.aspect==0){
			ant.r--;
		}else if(ant.aspect==1){
			ant.c++;
		}else if(ant.aspect==2){
			ant.r++;	
		}else{
			ant.c--;
		}
	}

}
class Ant{
	public int aspect;  //方向
	public int r=0;  //蚂蚁的行
	public int c=0;   //列
	public Ant(int r,int c,int aspect) {
		this.aspect=aspect;
		this.r=r;
		this.c=c;
	}
}
```

M:这道题很简单，无非就是用两个方法，将规定好的行为表现出来。这里的核心就是用Ant对象来模拟蚂蚁的对象，而写单独的方法来表现行走的状态。

D: