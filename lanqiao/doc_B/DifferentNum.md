# 数字互不相同

## 1.买不到的数目
>小明开了一家糖果店。他别出心裁：把水果糖包成4颗一包和7颗一包的两种。糖果不能拆包卖。  
>小朋友来买糖的时候，他就用这两种包装来组合。当然有些糖果数目是无法组合出来的，比如要买 10 颗糖。  
>你可以用计算机测试一下，在这种包装情况下，最大不能买到的数量是17。大于17的任何数字都可以用4和7组合出来。  
>本题的要求就是在已知两个包装的数量时，求最大不能组合出的数字。
>输入：  
>两个正整数，表示每种包装中糖的颗数(都不多于1000)  
>
>要求输出：  
>一个正整数，表示最大不能买到的糖数  
>不需要考虑无解的情况  
>例如：  
>用户输入：  
>4 7  
>程序应该输出：  
>17  
>
>再例如：  
>用户输入：  
>3 5  
>程序应该输出：  
>7  
>
>资源约定：  
>峰值内存消耗（含虚拟机） < 64M  
>CPU消耗  < 3000ms

---

题目分析：  
1. 判断买不到的数目：循环num1和num2，将有的数目存在数组中  
2. 怎么计算连续的个数呢：用count++，当一有非1，马上归0
3. 连续多少个后面都能买到呢：连续num个  
4. 最大的买不到怎么解决：当确定能买到后，减回num  
5. 定义存储存在的数目的数组多大合适，这个需要进行尝试，这里N=1000 00  

```java
		int N=100000;   //定义数值足够大，这里用1000 00 （不能加0了）
		int[] arr=new int[N];
		for (int i = 0; i < N/num1; i++) {
			for (int j = 0; j < (N-i*num1)/num2; j++) {
				arr[i*num1+j*num2]=1;
			}
		}
		int count=0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==1){
				count++;
				if(count==num1){
					System.out.println(i-num1);
					return;
				}else if(count==num2){
					System.out.println(i-num2);
					return;
				}
			}else{
				count=0;
			}
		}
```
[源码](../SourceCode/NoBuySweet.java)

---

## 2.花朵数
>一个N位的十进制正整数，如果它的每个位上的数字的N次方的和等于这个数本身，则称其为花朵数。  
>例如：  
>当N=3时，153就满足条件，因为 1^3 + 5^3 + 3^3 = 153，这样的数字也被称为水仙花数（其中，“^”表示乘方，5^3表示5的3次方，也就是立方）。  
>当N=4时，1634满足条件，因为 1^4 + 6^4 + 3^4 + 4^4 = 1634。  
>当N=5时，92727满足条件。  
>实际上，对N的每个取值，可能有多个数字满足条件。  
>  
>程序的任务是：求N=21时，所有满足条件的花朵数。注意：这个整数21位，它的各个位数字的21次方之和正好等于这个数本身。

---

题目分析：  
1. 计算1-9的21次方，存进数组备用  
2. 获取一个计数数组  
怎么获取呢，使用递归方法  
递归参数为：数组（计数数组），指针，剩下的参数个数  
循环21次，将每个数可能出现的次数赋值给数组，指针指向下一项，运行后需要回溯  
运算的结点就是当21个数全部被使用的时候  
另一个结点就是，当指针指向最后一个数的时候，将剩余的数字全部给最后一个位置，剩余数量清0  
3. 编写验证方法  
将每个位置的次数*21次方值的总和求出，求出之后做筛选：  
  - 筛选1：当长度不为21，方法结束
  - 筛选2：将综合值的计数数组求出，判断计数数组如果不相同，方法结束  
（花朵数本来形态为：数量--拆，次方和--数量  
而本题的转化形态为：计数数组--拆，次方和--数量--计数数组） 

```java
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

```
_答案是：  
128468643043731391252  
449177399146038697307_  

[源码](../SourceCode/FlowerNum.java)

---


























