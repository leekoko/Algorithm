/*1.����ĸ
��abcd...s��19����ĸ��ɵ������ظ�ƴ��106�Σ��õ�����Ϊ2014�Ĵ���
������ɾ����1����ĸ������ͷ����ĸa�����Լ���3������5������������λ�õ���ĸ��
�õ����´��ٽ���ɾ������λ����ĸ�Ķ����������ȥ�����ֻʣ��һ����ĸ����д������ĸ��*/


public class Main {
	public static void main(String[] args) {
		int[] arr=new int[2015];
		for (int i = 1; i < 2015; i++) {
			arr[i]=i;
		}
		int num=2015;
		while(num>1){
			num=num/2;   //ɾȥ�������ÿ���+1
			for (int i = 1; i < arr.length; i++) {
				arr[i]=arr[i]*2;   //��������2��������һ��ż����
			}
		}
		System.out.println(arr[1]%19);  //%19��ʾ��ĸѭ��������17�����������ĸq
	}
}