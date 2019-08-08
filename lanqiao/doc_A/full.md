# 组合-全排列

D：今天练一下全排列，比较两种解法。

```
有重复的字母中求取出m个所有组合

例如： "AAABBCCCCCCDD" 中取3个字母的所有组合
```

D:解法1如下

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
			temp=arr[point];   //回溯
			arr[point]=arr[i];
			arr[i]=temp;
		}
	}
	
}
```
M：它通用式的解法怎么理解？

```java
		for (int i = point; i < arr.length; i++) {
			char temp=arr[point];
			arr[point]=arr[i];
			arr[i]=temp;
			f(point+1);
			temp=arr[point];   //回溯
			arr[point]=arr[i];
			arr[i]=temp;
		}
```

Z：我用point代表当前指针的位置，每指到一个数，这个数就和后边的任何一个数交换位置。

```java
		for (int i = point; i < arr.length; i++) {
			char temp=arr[point];
			arr[point]=arr[i];
			arr[i]=temp;
```

交换完位置，就指向下一个数。

```java
f(point+1);
```

由于操作的是数组，交换完一个数之后，要对交换的数进行回溯恢复。

```java
			temp=arr[point];   //回溯
			arr[point]=arr[i];
			arr[i]=temp;
```

M：那怎么设置出口呢？

Z：不断地与后面的数交换，当指向最后一个数的时候，它就没有后面的数了，这就是出口。这时候把数组输出即可

```java
		if (point==arr.length) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]);
			}
			System.out.println();
			return;
		}
```

D：解法2如下：

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

M：上面是用指定数和后面的每个数交换，那解法2有什么区别呢？

Z：解法2是将指定的数抽取出来，放在串的开头。而他的出口就是，当抽到最后一个数的时候，就是没有抽取出来后的数字的全排列。

M：用文字来判断是否可以将当前式子写成递归式：

解法一，交换法：假设我有字母ABC，我分别将A ，B ， C与其他两个字母交换位置，就可以获得所有的可能排列。  

解法二，抽取法：假设我有数字123，如果我要将它全排列，一般我会从小到大：123 , 132，213 ，231，321, 312。我每次都尽可能将没列举过的小的数放到开头，这就可以形成全排列。   

