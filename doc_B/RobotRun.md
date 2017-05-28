# 机器人行走

## 1.机器人行走
>某少年宫引进了一批机器人小车。可以接受预先输入的指令，按指令行动。小车的基本动作很简单，只有3种：左转（记为L），右转（记为R），向前走若干厘米（直接记数字）。  
>
>例如，我们可以对小车输入如下的指令：15L10R5LRR10R20 则，小车先直行15厘米，左转，再走10厘米，再右转，…  
>不难看出，对于此指令串，小车又回到了出发地。  
>你的任务是：编写程序，由用户输入指令，程序输出每条指令执行后小车位置与指令执行前小车位置的直线距离。  
>
>输入、输出格式要求用户先输入一个整数n（n<100），表示接下来将有n条指令。接下来输入n条指令。每条指令只由L、R和数字组成（数字是0~100之间的整数），每条指令的长度不超过256个字符。  
>程序则输出n行结果。每条结果表示小车执行相应的指令前后位置的直线距离。要求四舍五入到小数后2位。 例如：用户输入：  
>5  
>L100R50R10  
>3LLL5RR4L12  
>LL  
>100R  
>5L5L5L5  
>  
>则程序输出：  
>102.96  
>9.06  
>0.00  
>100.00  
>0.00  

---

题目分析：  
1. 数据的输入：不能输入一个显示一个，最后一个显示不出来。  
所以要用数组一次性存储，再一个个调用方法。  
2. 判断是字母：就进行行走有一个缺陷，最后的一步不会行走，所以固定每一项加一个“L”  
3. 方向的改变：作为一个方法，左边使用+3，可以防止出现负数（判断方向用%4）  
4. 步数的行走：需要对方向的判断，改变x，y的值  
5. 步数的十位，每次都让步数*10之后再加上新的步数  
（步数从char转化为int：需要-‘0’）  

```java
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
```
[源码](../SourceCode/AndroidRun.java)  

---

## 2.兰顿蚂蚁
>兰顿蚂蚁，是于1986年，由克里斯·兰顿提出来的，属于细胞自动机的一种。  
>平面上的正方形格子被填上黑色或白色。在其中一格正方形内有一只“蚂蚁”。  
>蚂蚁的头部朝向为：上下左右其中一方。  
>  
>蚂蚁的移动规则十分简单：  
>若蚂蚁在黑格，右转90度，将该格改为白格，并向前移一格；  
>若蚂蚁在白格，左转90度，将该格改为黑格，并向前移一格。  
>  
>规则虽然简单，蚂蚁的行为却十分复杂。刚刚开始时留下的路线都会有接近对称，像是会重复，但不论起始状态如何，蚂蚁经过漫长的混乱活动后，会开辟出一条规则的“高速公路”。  
>  
>蚂蚁的路线是很难事先预测的。  
>你的任务是根据初始状态，用计算机模拟兰顿蚂蚁在第n步行走后所处的位置。  
输入格式  
>输入数据的第一行是 m n 两个整数（3 < m, n < 100），表示正方形格子的行数和列数。  
>接下来是 m 行数据。  
>每行数据为 n 个被空格分开的数字。0 表示白格，1 表示黑格。  
>  
>接下来是一行数据：x y s k, 其中x y为整数，表示蚂蚁所在行号和列号（行号从上到下增长，列号从左到右增长，都是从0开始编号）。s 是一个大写字母，表示蚂蚁头的朝向，我们约定：上下左右分别用：UDLR表示。k 表示蚂蚁走的步数。  
输出格式  
>输出数据为两个空格分开的整数 p q, 分别表示蚂蚁在k步后，所处格子的行号和列号。  
>样例输入  
>5 6  
>0 0 0 0 0 0  
>0 0 0 0 0 0  
>0 0 1 0 0 0  
>0 0 0 0 0 0  
>0 0 0 0 0 0  
>2 3 L 5  
>样例输出  
>1 3  
>样例输入  
>3 3  
>0 0 0  
>1 1 1  
>1 1 1  
>1 1 U 6  
>样例输出  
>0 0  

---

题目分析：  
1. 将获取的方向转化为数字，执行行走方法  
2. 行走的方法中需要改变方向，向右就+1，向左就+3  
3. 利用对象存储属性，每到一个格，方向和格子颜色都会变化  
4. 输出最后所在格子的位置  

```java
public class Main {
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
[源码](../SourceCode/Ant.java)

---