import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		//��ȡ����
		Scanner input=new Scanner(System.in);
		int row=input.nextInt();//��ȡ��
		int column=input.nextInt();   //��ȡ��
		
		int arr[][]=new int[row][column];//��ȡ��������
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j]=input.nextInt();
			}
		}
		int r=input.nextInt();  //������
		int c=input.nextInt();   //������		
		String temp=input.next();//����
		int t=0;
		if(temp.equals("U")){
			t=0;
		}else if(temp.equals("R")){
			t=1;
		}else if(temp.equals("D")){
			t=2;
		}else{
			t=3;
		}		
		Ant ant=new Ant(r,c,t);
		int step=input.nextInt();//����
		
		//��for�����ߵĲ���
		for (int i = 0; i < step; i++) {
			//���߷���
			Go(ant,arr);
		}		
		//������ϵ�λ��
		System.out.println(ant.r+" "+ant.c);
	}

	
	//дһ���࣬�������ϵ�λ�ã�����
	public static void Go(Ant ant,int arr[][]) {
		// TODO Auto-generated method stub
		if(arr[ant.r][ant.c]==1){
			ant.aspect=(ant.aspect+1)%4;   //����ı�
			arr[ant.r][ant.c]=0;   //������ɫ�ı�
			Run(ant);   //��������
		}else{
			ant.aspect=(ant.aspect+3)%4;
			arr[ant.r][ant.c]=1;
			Run(ant);
		}
		
	}

	private static void Run(Ant ant) {
		if(ant.aspect==0){
			ant.r--;
		}else if(ant.aspect==1){
			ant.c++;
		}else if(ant.aspect==2){
			ant.r++;	
		}else{
			ant.c--;
		}
	}

}
class Ant{
	public int aspect;  //����
	public int r=0;  //���ϵ���
	public int c=0;   //��
	public Ant(int r,int c,int aspect) {
		this.aspect=aspect;
		this.r=r;
		this.c=c;
	}
}

