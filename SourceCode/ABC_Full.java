//×ÖÄ¸ABCµÄÈ«ÅÅÁĞ



public class Main {
	static char[] arr="ABCD".toCharArray();
	public static void main(String[] args) {
		f(0);
	}

	public static void f(int point) {
		if (point==arr.length) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]);
			}
			System.out.println();
			return;
		}
		
		for (int i = point; i < arr.length; i++) {
			char temp=arr[point];
			arr[point]=arr[i];
			arr[i]=temp;
			f(point+1);
			temp=arr[point];
			arr[point]=arr[i];
			arr[i]=temp;
		}
	}
	
}
