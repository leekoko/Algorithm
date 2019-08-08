# 生成回文数 

D：简单的题目

```
标题：生成回文数

所谓回文数就是左右对称的数字，比如：
585,5885,123321...
当然，单个的数字也可以算作是对称的。

小明发现了一种生成回文数的方法：
比如，取数字19，把它与自己的翻转数相加：
19 + 91 = 110，如果不是回文数，就再进行这个过程：
110 + 011 = 121 这次是回文数了。

200以内的数字中，绝大多数都可以在30步以内变成回文数，只有一个数字很特殊，就算迭代了1000次，它还是顽固地拒绝回文！

请你提交该顽固数字，不要填写任何多余的内容。
```

M：简单解法，这里不做过多解释

```java
import java.math.BigInteger;

public class Test3 {  
	public static void main(String[] args) {
		for (int i = 10; i < 200; i++) {
			BigInteger bi = new BigInteger(i+"");
			if(!back(bi)){
				System.out.println(i);
				return;
			}
		}
	}
	/**
	 * 生成回文过程
	 * @param i
	 * @return   true生成成功   false生成失败
	 */
	private static boolean back(BigInteger num) {
		int count =0;
		while(count <= 1000){
			if(canBack(num)){
				return true;
			}
			num = num.add(changNum(num));
			count++;
		}
		return false;
	}
	/**
	 * 变化数字
	 * @param num
	 * @return
	 */
	private static BigInteger changNum(BigInteger num) {
		//颠倒
		String str = "";
		char[] arr = num.toString().toCharArray();
		for (int i = arr.length-1; i>=0; i--) {
			str += arr[i];
		}
		return new BigInteger(str);
	}
	/**
	 * 判断是否为回文数
	 * @param i
	 * @return
	 */
	private static boolean canBack(BigInteger num) {
		String str = num.toString();
		int start = 0;
		int end = str.length()-1;
		while(start < end){
			char a = str.charAt(start);
			char b = str.charAt(end);
			if(a != b){
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

}  
```

因为int长度不够，故使用BigInteger   
