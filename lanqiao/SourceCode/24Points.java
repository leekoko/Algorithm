import java.util.Scanner;
import java.util.Stack;


//����4���˿��ƣ�������1~10����+-*/���㣬�������Ϊ24

//4 4 10 10     ����10*10��-4��/4)
//3 4 5 6    (6*((3+5)-4))


public class Main {
/*	��Ŀ������
	1. ����һ���µĻ�ȡ���ݵķ�ʽ������������ݷָ�����������
	String[] ss=scan.nextLine().split("\\,");   //���������ָ� ��������
	2.����ʹ����ջStack��������ʹ�÷�������
	     Stack st=new Stack();   //����������
	     System.out.println(st);
	     st.push(new Integer(3));   //���Object��������
	     st.push(new String("kkk")); //���Object��������2���������ࣩ
	     System.out.println(st);
	     st.pop();   //ɾ������ӵ�����
	     System.out.println(st);
	3.��������֮��������ɷ��ţ������沨�����ʽ
	ÿ�ν���ϴ�ƣ��ж��Ƿ���ϣ��ǵĻ������
	4.��ô�ж���
	�жϷ��ţ���������
	���žͽ��������ִ�������
	���־ͼ���ѹջ������ǵ�λ������
	�ж���������֮�����Ƿ�Ϊ24������boolean
	5.��ô�����
	�������������жϣ�ת��Ϊ�ַ�������ջ��
	���ջ������*/

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String[] temp=input.nextLine().split(" ");
		String[] arr=new String[7]; 
		while(true){
			for (int i = 0; i < 4; i++) {     //ÿ��һ�ζ�Ҫ�Է��Ž���ϴ�ƣ���������Ӧ��ÿ����������
				arr[i]=temp[i];
			}
			for (int i = 4; i < arr.length; i++) {   //��ȡ�������
				arr[i]=suiFu();
			}
			xi(arr);   //ϴ��
			if(jisuan(arr)){    //����沨�������պ�������ȷ
				show(arr);    //��ʾ����
				return;
			}
		}
	}

	public static void show(String[] arr) {
		Stack<String> stack=new Stack<String>();
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].equals("+")||arr[i].equals("-")||arr[i].equals("*")||arr[i].equals("/")){
				String b=(String)stack.pop();
				String a=(String)stack.pop();
				stack.push("("+a+arr[i]+b+")");   //ͳһ�洢Ϊ�ַ���
			}else{
				stack.push(arr[i]);
			}
		}
		System.out.println(stack.pop());
		
	}

	public static boolean jisuan(String[] arr) {
		Stack<String> stack=new Stack<String>();
		try{
			for (int i = 0; i < arr.length; i++) {
				if(arr[i].equals("+")||arr[i].equals("-")||arr[i].equals("*")||arr[i].equals("/")){
					int b=Integer.parseInt((String)stack.pop());     //ȡ��ջ�еĶ������ܻ��׳�����
					int a=Integer.parseInt((String)stack.pop());
					stack.push(yun(a,b,arr[i])+"");   //ͳһ�洢Ϊ�ַ�������ֹintת��int��
				}else{
					stack.push(arr[i]);    //ѹջ����
				}
			}
		}catch (Exception e) {
			return false;   //���쳣�ͷ���false    
		}
		if(stack.size()==1&&stack.pop().toString().equals("24")){  //����ջ��ֻ��һ������������Ϊ24
			return true;
		}
		return false;
	}

	private static int yun(int a, int b, String st) throws Exception {
		if(st.equals("+")){
			return a+b;
		}else if(st.equals("-")){
			return a-b;
		}else if(st.equals("*")){
			return a*b;
		}else{
			if(a%b!=0){
				throw new Exception("no /");
			}
		}
		return a/b;
	}

	public static void xi(String[] arr) {
		for (int i = 0; i < arr.length; i++) {   //ÿ����������ϴ��    
			int num=(int) (Math.random()*7);
			String temp=arr[i];
			arr[i]=arr[num];
			arr[num]=temp;
		}
	}

	public static String suiFu() {
		int num=(int) (Math.random()*4);
		if(num==0){
			return "+";
		}else if(num==1){
			return "-";
		}else if(num==2){
			return "*";
		}else{
			return "/";
		}
	}

}
