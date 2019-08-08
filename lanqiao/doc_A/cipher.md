# 密文搜索

D：看起来不是很复杂的题目

```
标题：密文搜索

福尔摩斯从X星收到一份资料，全部是小写字母组成。
他的助手提供了另一份资料：许多长度为8的密码列表。
福尔摩斯发现，这些密码是被打乱后隐藏在先前那份资料中的。

请你编写一个程序，从第一份资料中搜索可能隐藏密码的位置。要考虑密码的所有排列可能性。

数据格式：

输入第一行：一个字符串s，全部由小写字母组成，长度小于1024*1024
紧接着一行是一个整数n,表示以下有n行密码，1<=n<=1000
紧接着是n行字符串，都是小写字母组成，长度都为8

要求输出：
一个整数, 表示每行密码的所有排列在s中匹配次数的总和。

例如：
用户输入：
aaaabbbbaabbcccc
2
aaaabbbb
abcabccc

则程序应该输出：
4

这是因为：第一个密码匹配了3次，第二个密码匹配了1次，一共4次。


资源约定：
峰值内存消耗（含虚拟机） < 512M
CPU消耗  < 5000ms


请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。

所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
注意：不要使用package语句。不要使用jdk1.7及以上版本的特性。
注意：主类的名字必须是：Main，否则按无效代码处理。
```

Z：题目大概理解为，两段输入的字符串，进行全排列。判断全排列匹配的次数总和。

M：我简单地实现一下

```java
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Test4 {
	static Set<String> set = new HashSet<String>();  //存储的数组不能放递归里面，使用Set排除重复
	static String fir = "";
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		fir = input.next();
		int num = input.nextInt();
		String[] arr = new String[num];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = input.next();
		}
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			result += run(arr[i]);
		}
		System.out.println(result);
	}

	private static int run(String str) {
		char[] arr = str.toCharArray();
		allSort(0,arr);   //获取全排列
		int count = 0;
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			if(fir.contains(iterator.next())){
				count++;
			}
		}
		set.clear();    //清空共用的数组
		return count;
	}
	/**
	 * 获取所有全排列情况
	 * @param str
	 * @return
	 */
	private static void allSort(int point, char[] arr) {
		
		if(point == arr.length-1){
			set.add(new String(arr));
		}
		
		for (int i = point; i < arr.length; i++) {
			//和当前的point位置交换
			char temp = arr[point];   
			arr[point] = arr[i];
			arr[i] = temp;
			allSort(point+1,arr);
			//回溯
			temp = arr[point];   
			arr[point] = arr[i];
			arr[i] = temp;
		}
	}
}
```

- 这里就是将全排列进行应用。之前的全排列写法是默认每个数都不一样，而当有重复的数字时，就需要用Set进行存储，排除重复数值。

  ```java
  static Set<String> set = new HashSet<String>();  //存储的数组不能放递归里面，使用Set排除重复
  ```

- 并且数组需要在递归方法之外，否则重复new的数组留不住递归的值。


- 而当数组在递归方法之外，不同的串排列就会使用同个数组，所以在每个串使用之后需要对数组进行清空处理。

  ```java
  		set.clear();    //清空共用的数组
  ```

