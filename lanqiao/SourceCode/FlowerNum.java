import java.math.BigInteger;

/*14.花朵数
一个N位的十进制正整数，如果它的每个位上的数字的N次方的和等于这个数本身，则称其为花朵数。
例如：
当N=3时，153就满足条件，因为 1^3 + 5^3 + 3^3 = 153，这样的数字也被称为水仙花数（其中，“^”表示乘方，5^3表示5的3次方，也就是立方）。
当N=4时，1634满足条件，因为 1^4 + 6^4 + 3^4 + 4^4 = 1634。
当N=5时，92727满足条件。
实际上，对N的每个取值，可能有多个数字满足条件。

程序的任务是：求N=21时，所有满足条件的花朵数。注意：这个整数有21位，它的各个位数字的21次方之和正好等于这个数本身。
*/
public class Main {
/*	题目分析：
	1.这里的运算思路就是：首先声明一个计数数组
	做递归方法，递归参数为：数组（计数数组），指针，剩下的参数个数   （循环的方式是，10个数每个数在不同位置出现的次数）
	递归式为 ：  数组存值（数组是计数数组，位置不重要，只要确定计数数组进行比较久可以），指针下一个，参数个数-出现的次数（最多21）
	递归结点为
	     当指针为最后一个时（arr.length-1，也就是9），将剩余的个数放在最后一项的数组位置（就不for循环了）
	     当剩余的个数为0的时候，执行 验证函数   
	2.然后做验证方法
	     通过递归数组获取总值：计数数组*每个数的21次方（需要先算出每个数的21次方）
	    获得到总值，将其toString再转化为计数数组（charAt-'0'），判断两个计数数组是否相等：
	     a.对数字进行验证：第一步筛选，筛选长度。
         b.总值要转化为计数数组，然后通过判断计数数组来判断两个数值是否相等
	（各个位的不同位置组合对结果是没有影响的。当一个数比较大，其水仙花运算不怕位置变化的混淆项）*/
static BigInteger[] bi;
public static void main(String[] args) {
	bi=new BigInteger[10];
	for (int i = 0; i < 10; i++) {
		bi[i]=ciFan(i);
	}
	int[] arr=new int[10];
	huoshu(arr,0,21);
}

public static void huoshu(int[] arr, int point, int sum) {
	if(sum==0){  //所有的数字都用完
		jisuan(arr);   //验证符合不
		return;
	}
	if(point==arr.length-1){
		arr[point]=sum;    //指到最后倒数第二个，剩下的数字个数全部交给最后一个
		huoshu(arr, point+1, 0);   //数字个数归0
		return;
	}
	for (int i = 0; i < sum; i++) {
		arr[point]=i;   //循环存入数字
		huoshu(arr, point+1, sum-i);   //赋值完一个之后，指向下一个，剩余的数字个数
		arr[point]=0;   //回溯数组
	}
	
	
}

public static void jisuan(int[] arr) {
	BigInteger temp=new BigInteger("0");
	for (int i = 0; i < bi.length; i++) {
		temp=temp.add(bi[i].multiply(new BigInteger(arr[i]+"")));   //（将算出21次方的数字*出现次数）*全部=原数
	}
	String de=temp.toString();
	if(de.length()!=21){             //第一步筛选：长度筛选
		return;
	}
	int[] ji=new int[10];
	for (int i = 0; i < de.length(); i++) {
		ji[de.charAt(i)-'0']++;
	}
	for (int i = 0; i < ji.length; i++) {    //第二次筛选：个数对比
		if(ji[i]!=arr[i]){
			return;
		}
	}
	System.out.println(de);
}

public static BigInteger ciFan(int num) {      //计算每个数的21次方
	BigInteger temp=new BigInteger("1");
	for (int j = 0; j < 21; j++) {
		temp=temp.multiply(new BigInteger(num+""));
	}
	return temp;
}



}

