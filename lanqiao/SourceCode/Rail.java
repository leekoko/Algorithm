import java.util.Scanner;
import java.util.Stack;

/*某城市有一个火车站，有n节车厢从A方向驶入车站，按进站的顺序编号为1~n。现让它们按照某种特定的顺序进入B方向的铁轨并驶出车站。为了重组车厢，你可以借助中转站C。在程序中输入车厢数目和出站的特定顺序，如果可以则输出Yes，否者输出No。
样例输入：
5
1 2 3 4 5
5
5 4 1 2 3
6
6 5 4 3 2 1
样例输出：
Yes
No
Yes */

public class Main{  
/*	1.  循环数组，放入栈中
	要求：当入栈的序号还没到最后一个（<arr.length）,
	要压栈之前先检查顶端是不是要出栈的数（是的话break跳出），检查之前还要看看有没有东西
	然后将下一个数压入栈中
	继续循环，一旦顶端是要出栈的数，就进行出栈

	2.最后判断栈中是否为空，为空就说明情况符合*/
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int num=input.nextInt();
		int[] arr=new int[num];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=input.nextInt();
		}
		Stack<Integer> stack=new Stack<Integer>();
		int point=0;
		for (int i = 1; i <= arr.length; i++) {
			stack.push(i);
			while(stack.size()>0&&stack.peek()==arr[point]){
				stack.pop();
				point++;
			}
		}
		if(stack.size()==0){
			System.out.println("Yes");
		}else{
			System.out.println("No");
		}
	}
}


