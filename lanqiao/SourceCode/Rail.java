import java.util.Scanner;
import java.util.Stack;

/*ĳ������һ����վ����n�ڳ����A����ʻ�복վ������վ��˳����Ϊ1~n���������ǰ���ĳ���ض���˳�����B��������첢ʻ����վ��Ϊ�����鳵�ᣬ����Խ�����תվC���ڳ��������복����Ŀ�ͳ�վ���ض�˳��������������Yes���������No��
�������룺
5
1 2 3 4 5
5
5 4 1 2 3
6
6 5 4 3 2 1
���������
Yes
No
Yes */

public class Main{  
/*	1.  ѭ�����飬����ջ��
	Ҫ�󣺵���ջ����Ż�û�����һ����<arr.length��,
	Ҫѹջ֮ǰ�ȼ�鶥���ǲ���Ҫ��ջ�������ǵĻ�break�����������֮ǰ��Ҫ������û�ж���
	Ȼ����һ����ѹ��ջ��
	����ѭ����һ��������Ҫ��ջ�������ͽ��г�ջ

	2.����ж�ջ���Ƿ�Ϊ�գ�Ϊ�վ�˵���������*/
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


