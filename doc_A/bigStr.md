# 稍大的串

D：对大数有要求的题目：

```
标题：稍大的串

  串可以按照字典序进行比较。例如：
  abcd 小于 abdc

  如果给定一个串，打乱组成它的字母，重新排列，可以得到许多不同的串，在这些不同的串中，有一个串刚好给定的串稍微大一些。科学地说：它是大于已知串的所有串中最小的串。你的任务就是求出这个“稍大的串”。

例如：
输入串：
abfxy
程序应该输出：
abfyx

再例如：
输入串：
ayyyxxff
程序应该输出：
fafxxyyy

数据规模约定：
  输入的串不超过1000个字符。

特例：
  如果已知的串已经是所有重组串中最大的，则原样输出读入的那个串。


资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 1000ms


请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。

所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
注意：不要使用package语句。不要使用jdk1.7及以上版本的特性。
注意：主类的名字必须是：Main，否则按无效代码处理。
```

M：实现了基本案例，但是输入字符要达到1000，在这里根本实现不了，怎么解决？

```java
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Test4{
	private static Set<String> set = new HashSet<String>();
	private static char[] arr = null;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.next();
		System.out.println(run(str));
	}

	private static String run(String str) {
		arr = str.toCharArray();
		change(0);
		return toNumCompare(str);
	}

	private static String toNumCompare(String str) {
		int first = toNum(str);
		Iterator<String> iterator = set.iterator();
		int min = 2099999999;
		HashMap<Integer, String> map = new HashMap<Integer,String>();
		while(iterator.hasNext()){
			String next = iterator.next();
			int tempNum = toNum(next);
			if(tempNum > first){
				if(tempNum < min){
					min = tempNum;
					map.put(tempNum, next);
				}
			}
		}
		String result = map.get(min);
		if(result == null){
			result = str;
		}
		return result;
	}

	private static int toNum(String str) {
		char[] strArr = str.toCharArray();
		int result = 0;
		for (int i = strArr.length-1; i >=0; i--) {
			result += ((int)strArr[i]-96)*((int)Math.pow(10, strArr.length-1-i));
		}
		return result;
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

直接使用BigInteger数据类型也可能是行不通的。

Z：看一下网友如何实现 [链接](https://blog.csdn.net/qq_26392583/article/details/65634753)  【错误】

```java
import java.util.Scanner;

public class BiggerString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int i = 0;
        int len = s.length();
        for(i=len-1;i>0;i--) {
            if(s.charAt(i)>s.charAt(i-1))
                break;
        }
        if(i==0) {
            System.out.println(s);
        } else {
            //取出最后的降序部分，反转
            StringBuilder sb = new StringBuilder(s.substring(i, len));
            sb = sb.reverse();
            //插入目标字符
            sb.insert(1, s.charAt(i-1));
            //插入在目标字符之前的字符串
            sb.insert(0, s.substring(0, i-1));
            System.out.println(sb.toString());
        }
    }
}
```

Z：通过测试发现虽然能通过例子给出的测试案例，但是还有相当一部分的测试案例不正确。例如数字``6543721``,输出结果为``6541327`` 显然小于原来的数字，所以该算法有缺陷。   

Z：再看其他网友 [链接](https://blog.csdn.net/sunday_tutu/article/details/45675087)  ,完美通过了各个测试案例

```java
import java.util.*;

public class Test5{

	static boolean f_next(char[] a){
		int x1 = -1;
		for(int i=a.length-1; i>0; i--){
			if(a[i-1]<a[i]){
				x1 = i-1;
				break;
			}
		}
		if(x1<0){
			return false;
		} 
		int x2 = x1 + 1;
		int y = -1;
		for(int i=a.length-1; i>0; i--){
			if(a[i]>a[x1]){
				y = i;
				break;
			}
		}
		{
			char t = a[x1]; 
			a[x1] = a[y]; 
			a[y] = t;
		}
		y = a.length-1;
		while(true){
			if(x2 >= y){
				break;
			} 
			char t = a[x2];
			a[x2] = a[y];	
			a[y] = t;
			x2++;
			y--;
		}
		return true;
	}

	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		char[] a = sc.nextLine().trim().toCharArray();
		f_next(a);
		for(int i=0; i<a.length; i++){
			System.out.print(a[i]);
		}
	}
	
}
```

M：这一段代码是干嘛的？

```java
		int x1 = -1;
		for(int i=a.length-1; i>0; i--){
			if(a[i-1]<a[i]){     
				x1 = i-1;
				break;
			}
		}
```

Z：从个位开始右边到左边遍历，寻找 右边>左边 的情况，记录左边的值到x1中。x1起名叫做  对中较小数。

6543751的 对中较小数 为 3。

M：那这段代码又是什么意思？

```java
		for(int i=a.length-1; i>0; i--){
			if(a[i]>a[x1]){
				y = i;
				break;
			}
		}
```

Z：从个位开始右边到左边遍历，寻找 比 对中较小数x1 大的数，记录其脚标为y。   

M：这一段交换的是什么？

Z：对中较小数x1 与 第一个大于该数的数交换位置。

```java
		{
			char t = a[x1]; 
			a[x1] = a[y]; 
			a[y] = t;
		}
```

6543751 中的 3 和 5 交换位置 6545731

M：这一段执行的是什么操作？

```java
		while(true){
			if(x2 >= y){
				break;
			} 
			char t = a[x2];
			a[x2] = a[y];	
			a[y] = t;
			x2++;
			y--;
		}
```

Z：较大的数，跟最后一个数交换位置。两数往中间靠拢，直到重叠或者超越。   

M：这么做有什么意义？

Z：总结一下，寻找稍大值的操作就是

1. 从右到左寻找，找到相邻右边大于左边的数对，将左边的数跟大于该数的数交换位置（从右到左寻找）
2. 将相邻对 右边的数 跟 数列 最左边的数 交换位置，右边的数右一个 与 最左边的数的左一个 交换位置，彼此靠拢，直到重叠。   

至于为什么，暂时理解不出来，先做记忆即可。