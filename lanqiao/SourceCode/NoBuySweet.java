import java.util.Scanner;

/*12.�򲻵�����Ŀ
    С������һ���ǹ��ꡣ������Ĳã���ˮ���ǰ���4��һ����7��һ�������֡��ǹ����ܲ������
    С���������ǵ�ʱ�������������ְ�װ����ϡ���Ȼ��Щ�ǹ���Ŀ���޷���ϳ����ģ�����Ҫ�� 10 ���ǡ�
    ������ü��������һ�£������ְ�װ����£�������򵽵�������17������17���κ����ֶ�������4��7��ϳ�����
    �����Ҫ���������֪������װ������ʱ�����������ϳ������֡�
���룺
��������������ʾÿ�ְ�װ���ǵĿ���(��������1000)

Ҫ�������
һ������������ʾ������򵽵�����
����Ҫ�����޽�����
���磺
�û����룺
4 7
����Ӧ�������
17

�����磺
�û����룺
3 5
����Ӧ�������
7

��ԴԼ����
��ֵ�ڴ����ģ���������� < 64M
CPU����  < 3000ms
*/
public class Main {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int num1=in.nextInt();
		int num2=in.nextInt();
		int N=100000;   //������ֵ�㹻��������1000 00 �����ܼ�0�ˣ�
		int[] arr=new int[N];
		for (int i = 0; i < N/num1; i++) {
			for (int j = 0; j < (N-i*num1)/num2; j++) {
				arr[i*num1+j*num2]=1;
			}
		}
		int count=0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==1){
				count++;
				if(count==num1){
					System.out.println(i-num1);
					return;
				}else if(count==num2){
					System.out.println(i-num2);
					return;
				}
			}else{
				count=0;
			}
		}
	}
}
