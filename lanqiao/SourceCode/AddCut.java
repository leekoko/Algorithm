/*�磬����������n=6�����Էֻ�Ϊ��
6
5+1
4+2, 4+1+1
3+3, 3+2+1, 3+1+1+1
2+2+2, 2+2+1+1,2+1+1+1+1
1+1+1+1+1+1+1
���ڵ������ǣ����ڸ�����������n,��д�㷨��ӡ���л��֡�
�û��Ӽ������� n����Χ1~10��*/

public class Main {
/*	��Ŀ������
	1.ǰ���������֣���������ָ�룬���ڵڼ�����
	2.�ݹ�ʽ�������ִ������飬ʣ�µĴ�����һ��������+1
	3.�ڵ㣺�жϵ�һ����Ϊ0��ʱ������ڵ㷶Χ�ڵ���������
	4.���λ�ý������ظ����ڴ�������֮ǰ�жϣ�1.�ڷǵ�һ�����������    2.Ҫ��������������ǰһ��󣬾�continue����*/
static int[] arr;
public static void main(String[] args) {
	arr=new int[10000];
	f(6,0);
}
public static void f(int num, int point) {
	if(num==0){
		for (int i = 0; i < point-1; i++) {
			System.out.print(arr[i]+"+");
		}
		System.out.print(arr[point-1]);   //������һ������+����
		System.out.println();
	}
	
	for (int i = num; i >0; i--) {
		if(point>0&&i>arr[point-1]){
			continue;
		}
		arr[point]=i;
		f(num-i,point+1);
	}
}
}
