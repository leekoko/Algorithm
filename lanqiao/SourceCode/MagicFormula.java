import java.util.Arrays;

/*2.������ʽ
��4����ͬ�����֣���ɵ�һ���˷���ʽ�����ǵĳ˻���Ȼ����4��������ɡ�
���磺
210 x 6 = 1260
8 x 473 = 3784
27 x 81 = 2187
������Ҫ��
�������˷������ɵ���ʽ����ͬһ���������ô�������ϱ����г���3�������һ���ж���������Ҫ�����ʽ��
��Ŀ������
1.������Ҫ����������⣺
          a.���ֻ�����ͬ     b.����������ͬ     c.�����ɲ���
2.���ֻ�����ͬ�ô���������
3.����������ͬҲ�ô������飬���бȽϽ��
4.�������ų��÷��뷨�������ǰ���뷨��
          a.���뷨���ֳ�1&3��2&2����Ҫ�ж�ǰ��С�ں��棩     b.����뷨����һ������ڶ����֣�ֻ�ǵڶ�����һ�����ڵ�һ����
*/

public class Test9 {
	public static void main(String[] args) {
		int count=0;
		for (int i = 1; i < 100; i++) {
			for (int j = 10; j < 1000; j++) {
				String st=i+""+j;
				String result=i*j+"";
				if(st.length()!=4||result.length()!=4||i>=j){   //�޶�����			ǰ��С�ں��棨��ֹ�ظ���
					continue;
				}
				if(f(st,result)){
					count++;
				}	
			}			
		}
		System.out.println(count);
		
	}

	public static boolean f(String st, String jieguo) {
		char[] num1=st.toCharArray();
		char[] num2=jieguo.toCharArray();
		Arrays.sort(num1);   //������жԱ�
		Arrays.sort(num2);
		for (int i = 0; i < num2.length; i++) {    //�ж���ͬ
			if(num1[i]!=num2[i]){
				return false;
			}
		}
		for (int i = 0; i < num2.length; i++) {     //�������ֲ�ͬ
			for (int j = i+1; j < num2.length; j++) {
				if(num2[i]==num2[j]){
					return false;
				}
			}
		}
		return true;
	}

}
