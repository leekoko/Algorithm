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

