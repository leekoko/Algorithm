import java.util.Scanner;

/*��������
�����Ӽ�������һ��������8λ������ʮ���������ַ���������ת��Ϊ����ʮ�������������
����ע��ʮ���������е�10~15�ֱ��ô�д��Ӣ����ĸA��B��C��D��E��F��ʾ��
��������
FFFF
�������
65535*/

public class Main {
/*	��Ŀ������
	��ÿ���ַ�ֱ��ת��Ϊ
	1.��������ַ����ָ�ж����Ƿ�Ϊ��ĸ��Ϊ��ĸ�Ļ����������� ����*16 �� 0�����η�
	2.���Ϊ���ֵĻ�-��0����õ�ֵ*16��0�����η�*/
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String st=input.nextLine();
		char[] arr=st.toCharArray();
		long sum=0;
		int len=arr.length;
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]=='A'){
				sum+=10*(Math.pow(16, (len-i-1)));
			}else if(arr[i]=='B'){
				sum+=11*(Math.pow(16, (len-i-1)));
			}else if(arr[i]=='C'){
				sum+=12*(Math.pow(16, (len-i-1)));
			}else if(arr[i]=='D'){
				sum+=13*(Math.pow(16, (len-i-1)));
			}else if(arr[i]=='E'){
				sum+=14*(Math.pow(16, (len-i-1)));
			}else if(arr[i]=='F'){
				sum+=15*(Math.pow(16, (len-i-1)));
			}else{
				sum+=(arr[i]-'0')*(Math.pow(16, (len-i-1)));
			}
		}
		System.out.println(sum);
	}

}
