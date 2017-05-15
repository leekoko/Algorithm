import java.math.BigInteger;

/*14.������
һ��Nλ��ʮ�������������������ÿ��λ�ϵ����ֵ�N�η��ĺ͵�����������������Ϊ��������
���磺
��N=3ʱ��153��������������Ϊ 1^3 + 5^3 + 3^3 = 153������������Ҳ����Ϊˮ�ɻ��������У���^����ʾ�˷���5^3��ʾ5��3�η���Ҳ������������
��N=4ʱ��1634������������Ϊ 1^4 + 6^4 + 3^4 + 4^4 = 1634��
��N=5ʱ��92727����������
ʵ���ϣ���N��ÿ��ȡֵ�������ж����������������

����������ǣ���N=21ʱ���������������Ļ�������ע�⣺���������21λ�����ĸ���λ���ֵ�21�η�֮�����õ������������
*/
public class Main {
/*	��Ŀ������
	1.���������˼·���ǣ���������һ����������
	���ݹ鷽�����ݹ����Ϊ�����飨�������飩��ָ�룬ʣ�µĲ�������   ��ѭ���ķ�ʽ�ǣ�10����ÿ�����ڲ�ͬλ�ó��ֵĴ�����
	�ݹ�ʽΪ ��  �����ֵ�������Ǽ������飬λ�ò���Ҫ��ֻҪȷ������������бȽϾÿ��ԣ���ָ����һ������������-���ֵĴ��������21��
	�ݹ���Ϊ
	     ��ָ��Ϊ���һ��ʱ��arr.length-1��Ҳ����9������ʣ��ĸ����������һ�������λ�ã��Ͳ�forѭ���ˣ�
	     ��ʣ��ĸ���Ϊ0��ʱ��ִ�� ��֤����   
	2.Ȼ������֤����
	     ͨ���ݹ������ȡ��ֵ����������*ÿ������21�η�����Ҫ�����ÿ������21�η���
	    ��õ���ֵ������toString��ת��Ϊ�������飨charAt-'0'�����ж��������������Ƿ���ȣ�
	     a.�����ֽ�����֤����һ��ɸѡ��ɸѡ���ȡ�
         b.��ֵҪת��Ϊ�������飬Ȼ��ͨ���жϼ����������ж�������ֵ�Ƿ����
	������λ�Ĳ�ͬλ����϶Խ����û��Ӱ��ġ���һ�����Ƚϴ���ˮ�ɻ����㲻��λ�ñ仯�Ļ����*/
static BigInteger[] bi;
public static void main(String[] args) {
	bi=new BigInteger[10];
	for (int i = 0; i < 10; i++) {
		bi[i]=ciFan(i);
	}
	int[] arr=new int[10];
	huoshu(arr,0,21);
}

public static void huoshu(int[] arr, int point, int sum) {
	if(sum==0){  //���е����ֶ�����
		jisuan(arr);   //��֤���ϲ�
		return;
	}
	if(point==arr.length-1){
		arr[point]=sum;    //ָ��������ڶ�����ʣ�µ����ָ���ȫ���������һ��
		huoshu(arr, point+1, 0);   //���ָ�����0
		return;
	}
	for (int i = 0; i < sum; i++) {
		arr[point]=i;   //ѭ����������
		huoshu(arr, point+1, sum-i);   //��ֵ��һ��֮��ָ����һ����ʣ������ָ���
		arr[point]=0;   //��������
	}
	
	
}

public static void jisuan(int[] arr) {
	BigInteger temp=new BigInteger("0");
	for (int i = 0; i < bi.length; i++) {
		temp=temp.add(bi[i].multiply(new BigInteger(arr[i]+"")));   //�������21�η�������*���ִ�����*ȫ��=ԭ��
	}
	String de=temp.toString();
	if(de.length()!=21){             //��һ��ɸѡ������ɸѡ
		return;
	}
	int[] ji=new int[10];
	for (int i = 0; i < de.length(); i++) {
		ji[de.charAt(i)-'0']++;
	}
	for (int i = 0; i < ji.length; i++) {    //�ڶ���ɸѡ�������Ա�
		if(ji[i]!=arr[i]){
			return;
		}
	}
	System.out.println(de);
}

public static BigInteger ciFan(int num) {      //����ÿ������21�η�
	BigInteger temp=new BigInteger("1");
	for (int j = 0; j < 21; j++) {
		temp=temp.multiply(new BigInteger(num+""));
	}
	return temp;
}



}

