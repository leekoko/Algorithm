import java.util.Scanner;

/*С��Ϊĳ���������һ��ʮ���͵Ļձ꣨���Ǻ�ʮ�ֻᰡ����������ʾ��

�����ʽ
һ�������� n (n<30) ��ʾҪ���ӡͼ�εĲ�����
�����ʽ
��Ӧ��Χ�����ĸñ�־��
��������1
1
�������1
..$$$$$..
..$...$..
$$$.$.$$$
$...$...$
$.$$$$$.$
$...$...$
$$$.$.$$$
..$...$..
..$$$$$..
��������2
3
�������2
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
��ʾ
����ϸ�۲�����������Ҫע��������������λ�á�*/

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
