# ���-ȫ����

D��������һ��ȫ���У��Ƚ����ֽⷨ��

```
���ظ�����ĸ����ȡ��m���������

���磺 "AAABBCCCCCCDD" ��ȡ3����ĸ���������
```

D:�ⷨ1����

```java
import java.util.Scanner;

public class Main3 {
	static Scanner input = new Scanner(System.in);
	static String str = input.next();
	static char[] arr = str.toCharArray();
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
			temp=arr[point];   //����
			arr[point]=arr[i];
			arr[i]=temp;
		}
	}
	
}
```
M����ͨ��ʽ�Ľⷨ��ô��⣿

```java
		for (int i = point; i < arr.length; i++) {
			char temp=arr[point];
			arr[point]=arr[i];
			arr[i]=temp;
			f(point+1);
			temp=arr[point];   //����
			arr[point]=arr[i];
			arr[i]=temp;
		}
```

Z������point����ǰָ���λ�ã�ÿָ��һ������������ͺͺ�ߵ��κ�һ��������λ�á�

```java
		for (int i = point; i < arr.length; i++) {
			char temp=arr[point];
			arr[point]=arr[i];
			arr[i]=temp;
```

������λ�ã���ָ����һ������

```java
f(point+1);
```

���ڲ����������飬������һ����֮��Ҫ�Խ����������л��ݻָ���

```java
			temp=arr[point];   //����
			arr[point]=arr[i];
			arr[i]=temp;
```

M������ô���ó����أ�

Z�����ϵ�����������������ָ�����һ������ʱ������û�к�������ˣ�����ǳ��ڡ���ʱ��������������

```java
		if (point==arr.length) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]);
			}
			System.out.println();
			return;
		}
```

D���ⷨ2���£�

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		List<String> list = f("ABC");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	private static List<String> f(String str) {
		List<String> list =new ArrayList<String>();
		
		if(str.length()==1){
			list.add(str);
			return list;
		}
		
		for (int i = 0; i < str.length(); i++) {
			char x = str.charAt(i);
			List t = f(str.substring(0,i)+str.substring(i+1));
			for (int j = 0; j < t.size(); j++) {
				list.add("" + x + t.get(j));
			}
		}
		return list;
	}
	
}
```

M����������ָ�����ͺ����ÿ�����������ǽⷨ2��ʲô�����أ�

Z���ⷨ2�ǽ�ָ��������ȡ���������ڴ��Ŀ�ͷ�������ĳ��ھ��ǣ����鵽���һ������ʱ�򣬾���û�г�ȡ����������ֵ�ȫ���С�

M�����������ж��Ƿ���Խ���ǰʽ��д�ɵݹ�ʽ��

�ⷨһ��������������������ĸABC���ҷֱ�A ��B �� C������������ĸ����λ�ã��Ϳ��Ի�����еĿ������С�  

�ⷨ������ȡ����������������123�������Ҫ����ȫ���У�һ���һ��С����123 , 132��213 ��231��321, 312����ÿ�ζ������ܽ�û�оٹ���С�����ŵ���ͷ����Ϳ����γ�ȫ���С�   

