import java.util.ArrayList;

//���100002�������Ƕ���

public class Main {
static ArrayList<Integer> al;
public static void main(String[] args) {
	al=new ArrayList<Integer>();
	al.add(2);
	al.add(3);
	al.add(5);
	al.add(7);
	
	int count=4;
	
	for (int i = 11; ; i+=2) {
		if(isPrime(i)){
			count++;
			if(count==100002){
				System.out.println(i);
				return;
			}
		}
		
	}
}

private static boolean isPrime(int num) {
	for (int j = 0; j < al.size(); j++) {
		//�����������������������������������û������
		if(num%al.get(j)==0){   
			return false;
		}
		if(num<al.get(j)*al.get(j)){   //������С����������ƽ��Ϊ����
			break;  
		}
	}
	al.add(num);  //��ӵ���������
	return true;
}

}
