import java.text.DecimalFormat;
import java.util.Scanner;

/*3.����������
ĳ���깬������һ��������С�������Խ���Ԥ�������ָ���ָ���ж���С���Ļ��������ܼ򵥣�ֻ��3�֣���ת����ΪL������ת����ΪR������ǰ���������ף�ֱ�Ӽ����֣���

���磬���ǿ��Զ�С���������µ�ָ�15L10R5LRR10R20 ��С����ֱ��15���ף���ת������10���ף�����ת����
���ѿ��������ڴ�ָ���С���ֻص��˳����ء�
��������ǣ���д�������û�����ָ��������ÿ��ָ��ִ�к�С��λ����ָ��ִ��ǰС��λ�õ�ֱ�߾��롣

���롢�����ʽҪ��
�û�������һ������n��n<100������ʾ����������n��ָ�����������n��ָ�ÿ��ָ��ֻ��L��R��������ɣ�������0~100֮�����������ÿ��ָ��ĳ��Ȳ�����256���ַ���
���������n�н����ÿ�������ʾС��ִ����Ӧ��ָ��ǰ��λ�õ�ֱ�߾��롣Ҫ���������뵽С����2λ�� ���磺�û����룺
5
L100R50R10
3LLL5RR4L12
LL
100R
5L5L5L5

����������
102.96
9.06
0.00
100.00
0.00
��Ŀ������
1.����Ҫ���λ�����⣬����xyȫ�ֱ���
2.�������⣬ʹ��xy��������
3.�������⣬�����input.nextLine��β
4.�ж��ǲ������֣��ǵĻ��Ѳ���������������������*10�ۼ�
5.�Բ�����Ӧ����������ߣ�ע���ʼ�������������ַ��ı䷽��ע��%�������鷶Χ
6.���������λ���֣���ʼ��x��y��ֵ*/

public class Main {
	static int point=0;
	static int x=0;
	static int y=0;
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int num=in.nextInt();
		String[] arr=new String[num];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=in.next();
		}
		for (int i = 0; i < arr.length; i++) {
			run(arr[i]+"L");
		}
	}

	private static void run(String st) {
		int step=0;
		for (int i = 0; i < st.length(); i++) {
			char a=st.charAt(i);
			if(a>='0'&&a<='9'){
				step=step*10;
				step+=a-'0';
			}else{
				if(point%4==0){
					x=x-step;
				}else if(point%4==1){
					y=y+step;
				}else if(point%4==2){
					x=x+step;
				}else{
					y=y-step;
				}
				if(a=='L'){
					point+=3;
				}else if(a=='R'){
					point+=1;
				}
				step=0;
			}
		}
		System.out.println(new DecimalFormat("0.00").format(Math.sqrt(x*x+y*y)));
		x=0;
		y=0;
	}

}
