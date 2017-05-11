import java.util.Scanner;

/*熄灯问题
请你写一个程序, 确定需要按下哪些按钮, 恰好使得所 有的灯都熄灭
每个案例由5行组成, 每一行包括6个数字 
这些数字以空格隔开, 可以是0或1 0 表示灯的初始状态是熄灭的 1 表示灯的初始状态是点亮的

接着按照该案例的输入格式输出5行 
1 表示需要把对应的按钮按下 
0 表示不需要按对应的按钮 
每个数字以一个空格隔开

输入：
0 1 1 0 1 0
1 0 0 1 1 1
0 0 1 0 0 1
1 0 0 1 0 1
0 1 1 1 0 0

输出：
1 0 1 0 0 1
1 1 0 1 0 1
0 0 1 0 1 1
1 0 0 1 0 0
0 1 0 0 0 0 

输入：
0 0 1 0 1 0
1 0 1 0 1 1
0 0 1 0 1 1
1 0 1 1 0 0
0 1 0 1 0 0 

输出：
1 0 0 1 1 1
1 1 0 0 0 0
0 0 0 1 0 0
1 1 0 1 0 1
1 0 1 1 0 1*/



public class Main {
/*	题目分析：
1.为了处理外围的问题，在数组左上右包上一层
2.因为第一行确定，后面的也随之确定。  
所以已知第一行按钮情况，根据    n个按钮+灯亮    作用！！的灯亮情况，推出下一列按钮的情况（只取决于上面一个，与上面一个相同即可）
3.推出到最后一行的按钮情况，再次根据多个按钮的作用（只有按钮）最终情况与灯亮对比，按钮结果与灯亮相同则说明全部都被熄灭。
*/
	static int[][] arr;
	static int[][] press;
	public static void main(String[] args) {
		arr=new int[6][8];
		press=new int[6][8];
		Scanner input=new Scanner(System.in);
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[i].length-1; j++) {
				arr[i][j]=input.nextInt();
			}
		}
		for (int a1 = 0; a1 < 2; a1++) {
			for (int a2 = 0; a2 < 2; a2++) {
				for (int a3 = 0; a3 < 2; a3++) {
					for (int a4 = 0; a4 < 2; a4++) {
						for (int a5 = 0; a5 < 2; a5++) {
							for (int a6 = 0; a6 < 2; a6++) {
								press[1][1]=a1;
								press[1][2]=a2;
								press[1][3]=a3;
								press[1][4]=a4;
								press[1][5]=a5;
								press[1][6]=a6;
								if(f()){
									show();
								}
							}
						}
					}
				}
			}
		}
	}
	
	public static void show() {
		for (int i = 1; i < press.length; i++) {
			for (int j = 1; j < press[i].length-1; j++) {
				System.out.print(press[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static boolean f() {
		for (int i = 2; i < press.length; i++) {
			for (int j = 1; j < press[i].length-1; j++) {
				press[i][j]=(arr[i-1][j]+press[i-1][j]+press[i-1][j-1]+press[i-1][j+1]+press[i-2][j])%2;   //按钮和灯的共同作用
			}
		}
		for (int j = 1; j < arr[5].length-1; j++) {
			if(arr[5][j]!=(press[5][j]+press[5][j-1]+press[5][j+1]+press[4][j])%2){
				return false;
			}
		}
		return true;
	}
	
}
