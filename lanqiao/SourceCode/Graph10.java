import java.util.Scanner;

/*小明为某机构设计了一个十字型的徽标（并非红十字会啊），如下所示：

输入格式
一个正整数 n (n<30) 表示要求打印图形的层数。
输出格式
对应包围层数的该标志。
样例输入1
1
样例输出1
..$$$$$..
..$...$..
$$$.$.$$$
$...$...$
$.$$$$$.$
$...$...$
$$$.$.$$$
..$...$..
..$$$$$..
样例输入2
3
样例输出2
..$$$$$$$$$$$$$..
..$...........$..
$$$.$$$$$$$$$.$$$
$...$.......$...$
$.$$$.$$$$$.$$$.$
$.$...$...$...$.$
$.$.$$$.$.$$$.$.$
$.$.$...$...$.$.$
$.$.$.$$$$$.$.$.$
$.$.$...$...$.$.$
$.$.$$$.$.$$$.$.$
$.$...$...$...$.$
$.$$$.$$$$$.$$$.$
$...$.......$...$
$$$.$$$$$$$$$.$$$
..$...........$..
..$$$$$$$$$$$$$..
提示
请仔细观察样例，尤其要注意句点的数量和输出位置。*/

public class Main {
static char[][] arr;
static int bian;
static int mid;
public static void main(String[] args) {
	Scanner input=new Scanner(System.in);
	int num=input.nextInt();
	bian=num*4+5;
	mid=bian/2;
	arr=new char[bian][bian];
	
	init();
	add(num);
	show();

}

private static void add(int num) {
	int x=mid-2;
	int y=mid-2;
	int index=1;
	for (int i = 0; i < num; i++) {
		arr[x][y]='$';
		for (int j = 0; j < 2; j++) {
			y--;
			arr[x][y]='$';
		}
		for (int j = 0; j < index*4; j++) {
			x++;
			arr[x][y]='$';
		}
		for (int j = 0; j < 2; j++) {
			y++;
			arr[x][y]='$';
		}
		for (int j = 0; j < 2; j++) {
			x++;
			arr[x][y]='$';
		}
		for (int j = 0; j < index*4; j++) {
			y++;
			arr[x][y]='$';
		}
		for (int j = 0; j < 2; j++) {
			x--;
			arr[x][y]='$';
		}
		for (int j = 0; j < 2; j++) {
			y++;
			arr[x][y]='$';
		}
		for (int j = 0; j < index*4; j++) {
			x--;
			arr[x][y]='$';
		}
		for (int j = 0; j < 2; j++) {
			y--;
			arr[x][y]='$';
		}
		for (int j = 0; j < 2; j++) {
			x--;
			arr[x][y]='$';
		}
		for (int j = 0; j < index*4; j++) {
			y--;
			arr[x][y]='$';
		}
		for (int j = 0; j < 2; j++) {
			x++;
			arr[x][y]='$';
		}
		index++;
		x=x-2;
		y=y-2;
	}
/*	..$$$$$..
	..$...$..
	$$$.$.$$$
	$...$...$
	$.$$$$$.$
	$...$...$
	$$$.$.$$$
	..$...$..
	..$$$$$..*/
	
}

public static void show() {
	for (int i = 0; i < arr.length; i++) {
		for (int j = 0; j < arr[i].length; j++) {
			System.out.print(arr[i][j]);
		}
		System.out.println();
	}
}

public static void init() {
	for (int i = 0; i < arr.length; i++) {
		for (int j = 0; j < arr[i].length; j++) {
			arr[i][j]='.';
		}
	}
	for (int i = 0; i < 5; i++) {
		arr[mid-2+i][mid]='$';
		arr[mid][mid-2+i]='$';
	}
}


}
