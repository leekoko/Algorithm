# 全排列模板   

D：通用的全排列

```java
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class Test4{
	private static Set<String> set = new HashSet<String>();
//	private static List<String> list = new ArrayList<String>();
	private static char[] arr = null;
	
	public static void main(String[] args) {
		String str = "122333";
		arr = str.toCharArray();
		change(0);
		show();
	}

	private static void show() {
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()){
			String next = iterator.next();
			System.out.println(next);
		}
	}

	private static void change(int point) {
		
		if(point == arr.length-1){
			set.add(new String(arr));
		}
		
		for (int i = point; i < arr.length; i++) {
			char temp = arr[point];
			arr[point] = arr[i];
			arr[i] = temp;
			change(point+1);
			temp = arr[point];   //回溯
			arr[point] = arr[i];
			arr[i] = temp;
		}
	}
	
}



```







