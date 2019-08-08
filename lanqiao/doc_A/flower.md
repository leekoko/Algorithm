# 花朵数   

D:现在追加分析一下一道觉得有点重要的题目：花朵数

```
花朵数一个 N 位的十进制正整数，如果它的每个位上的数字的 N 次方的和等于这个数本身，则称其为花朵数。例如：当 N=3 时，153 就满足条件，因为 1^3 + 5^3 + 3^3 = 153，这样的数字也被称为水仙花数
（其中，“^”表示乘方，5^3 表示 5 的 3 次方，也就是立方）。
当 N=4 时，1634 满足条件，因为 1^4 + 6^4 + 3^4 + 4^4 = 1634。
当 N=5 时，92727 满足条件。实际上，对 N 的每个取值，可能有多个数字满足条件。
程序的任务是：求 N=21 时，所有满足条件的花朵数。
注意：这个整数有 21 位，它的各个位数字的 21 次方之和正好等于这个数本身。
如果满足条件的数字不只有一个，请从小到大输出所有符合条件的数字，每个数字占一行。
因为这个数字很大，请注意解法时间上的可行性。
要求程序在 1 分钟内运行完毕。【程序运行参考结果】

128468643043731391252
449177399146038697307
```

Z:这道题之前做过，只是现在看起来都有点晦涩难懂

```java
public class Main
{
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
```

M:``ciFan(i)``方法是干嘛用的？

Z:计算21次方，由于涉及到大数运算，所以需要使用BigInteger

```java
	public static BigInteger ciFan(int num) {      //计算每个数的21次方
		BigInteger temp=new BigInteger("1");
		for (int j = 0; j < 21; j++) {
			temp=temp.multiply(new BigInteger(num+""));
		}
		return temp;
	}
```

M:这段代码什么意义?``for (int i = 0; i < sum; i++) {``   

Z:sum是用来表示所指数字的数目，这里的主角是0-9这10个数字。

M:那``arr[point]=i;``表示的是什么呢？

Z:point是一个指向0-9的指针，当它指向0的时候，就说明0出现了i次。

M:用数组来统计阿拉伯数字出现的次数，真神奇，不知是怎么想到的。

Z:当数字涉及很大的时候，又需要灵活运算，就得考虑用数组脚标特性了。

M:那它调用自身又是什么意思？``huoshu(arr, point+1, sum-i);``   

Z:因为它猜测第一个数字的数量，接下来就要猜测第二个了。所以把 数组，指针，剩余数量 传到下一级。

M:为什么剩余的数量也要传下去？

Z:因为数字的数量是一定的，只有将剩余的数量传下去，才可以更精准地进行递归。

M:那这样递归下去，到什么情况才结束呢？

当数字指向倒数二个，剩下地数字就会都给最后一个。

loading