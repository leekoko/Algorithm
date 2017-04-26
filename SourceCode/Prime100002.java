import java.util.ArrayList;

//求第100002个素数是多少

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
		//当这个数连素数都不能整除，其他的数都没法整除
		if(num%al.get(j)==0){   
			return false;
		}
		if(num<al.get(j)*al.get(j)){   //当数字小于已有数的平方为素数
			break;  
		}
	}
	al.add(num);  //添加到素数组中
	return true;
}

}
