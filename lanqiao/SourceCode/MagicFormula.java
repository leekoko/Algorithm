import java.util.Arrays;

/*2.神奇算式
由4个不同的数字，组成的一个乘法算式，它们的乘积仍然由这4个数字组成。
比如：
210 x 6 = 1260
8 x 473 = 3784
27 x 81 = 2187
都符合要求。
如果满足乘法交换律的算式算作同一种情况，那么，包含上边已列出的3种情况，一共有多少种满足要求的算式。
题目分析：
1.这里需要解决三个问题：
          a.数字互不相同     b.左右数字相同     c.交换律不算
2.数字互不相同用存入数组解决
3.左右数字相同也用存入数组，进行比较解决
4.交换律排除用分离法，或者是半分离法：
          a.分离法，分成1&3和2&2（需要判断前面小于后面）     b.半分离法：第一部分与第二部分，只是第二部分一定大于第一部分
*/

public class Test9 {
	public static void main(String[] args) {
		int count=0;
		for (int i = 1; i < 100; i++) {
			for (int j = 10; j < 1000; j++) {
				String st=i+""+j;
				String result=i*j+"";
				if(st.length()!=4||result.length()!=4||i>=j){   //限定长度			前面小于后面（防止重复）
					continue;
				}
				if(f(st,result)){
					count++;
				}	
			}			
		}
		System.out.println(count);
		
	}

	public static boolean f(String st, String jieguo) {
		char[] num1=st.toCharArray();
		char[] num2=jieguo.toCharArray();
		Arrays.sort(num1);   //排序进行对比
		Arrays.sort(num2);
		for (int i = 0; i < num2.length; i++) {    //判断相同
			if(num1[i]!=num2[i]){
				return false;
			}
		}
		for (int i = 0; i < num2.length; i++) {     //各个数字不同
			for (int j = i+1; j < num2.length; j++) {
				if(num2[i]==num2[j]){
					return false;
				}
			}
		}
		return true;
	}

}
