import java.util.Scanner;

/*
��������
������n��С����Χ����һȦ����ʦ��ÿ��С���������ż�����ǹ���Ȼ������������Ϸ��

����ÿ��С���Ѷ����Լ����ǹ���һ������ֱߵĺ��ӡ�

����һ�ַ��Ǻ�ӵ���������ǵĺ�������ʦ����1���ǹ����Ӷ����ż����

�����������������Ϸ��ֱ������С���ѵ��ǹ�������ͬΪֹ��

�������������Ԥ������֪�ĳ�ʼ�ǹ������£���ʦһ����Ҫ�������ٸ��ǹ���
�����ʽ
�����������ȶ���һ������N(2<N<100)����ʾС���ѵ�������
����������һ���ÿո�ֿ���N��ż����ÿ��ż��������1000����С��2��
�����ʽ
����Ҫ��������һ����������ʾ��ʦ��Ҫ�������ǹ�����
��������
3
2 2 4
�������
4*/

public class Main {
	static int addSweet=0;   //��ʼ���������ǹ���
	public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in);
		
		//��ȡѧ����
		int student=input.nextInt();
		
		//����ÿ���˵��ǹ�������
		int[] sweet=new int[student];
		for (int i = 0; i < sweet.length; i++) {
			sweet[i]=input.nextInt();
		}
		
		//����ֳ����ǹ�����
		int[] temp=new int[student];
		//whileѭ��
		while(true){
			//ִ���ǹ��仯�ķ���
			chang(sweet,temp);
			//ִ�м���Ƿ���ͬ
			if(check(sweet)){
				System.out.println(addSweet);
				return;
			}
			//ִ�в����ǹ��Ĳ������������ǹ����������Ƿ���в������ж�Ϊû�в���breakѭ��
			add(sweet);   
			//ִ�м���Ƿ���ͬ
			if(check(sweet)){
				System.out.println(addSweet);
				return;
			}
		}
	}
	/**
	 * ����ǹ��Ƿ���ͬ
	 * @param sweet
	 */
	public static boolean check(int[] sweet) {
		// TODO Auto-generated method stub
		boolean flag=true;   //��ʼ���ж϶���ͬ
		for (int i = 0; i < sweet.length; i++) {
			for (int j = 0; j < sweet.length; j++) {
				if(sweet[i]!=sweet[j]){   //�����˲�ͬ
					flag=false;
				}
			}
		}
		return flag;
	}

	/**
	 * �ı��ǹ�������
	 * @param sweet
	 * @param temp
	 */
	public static void chang(int[] sweet, int[] temp) {
		//����ÿ������2
		for (int i = 0; i < sweet.length; i++) {
			sweet[i]=sweet[i]/2;
			//�������temp������
			temp[i]=sweet[i];
		}
		for (int i = 0; i < sweet.length; i++) {
			if(i==0){  //�����һ����ʱ�����һ����
				sweet[i]=sweet[i]+temp[temp.length-1];
			}else{   //����ѡ�������¼�
				sweet[i]=sweet[i]+temp[i-1]; //�����ǹ�				
			}
		}
	}
	
	/**
	 * �����������ǹ�
	 * @param sweet
	 * @param addSweet2
	 * @return
	 */
	public static void add(int[] sweet) {

		//ѭ���жϣ����������������һ���ǹ�����Ӽ���
		for (int i = 0; i < sweet.length; i++) {
			if(sweet[i]%2!=0){
				sweet[i]++;
				addSweet++;
			}
		}
	}	
	
}
