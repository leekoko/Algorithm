# 闲聊蓝桥杯JAVA -暴力破解法   

Z:最近神清气爽，有很多的劲没地方使，要不就来练练暴力破解吧！

D:ok，第一题

```
标题：奇怪的分式
    上小学的时候，小明经常自己发明新算法。一次，老师出的题目是：
    1/4 乘以 8/5 
    小明居然把分子拼接在一起，分母拼接在一起，答案是：18/45 （参见图1.png）
    老师刚想批评他，转念一想，这个答案凑巧也对啊，真是见鬼！
    对于分子、分母都是 1~9 中的一位数的情况，还有哪些算式可以这样计算呢？
    请写出所有不同算式的个数（包括题中举例的）。
    显然，交换分子分母后，例如：4/1 乘以 5/8 是满足要求的，这算做不同的算式。
    但对于分子分母相同的情况，2/2 乘以 3/3 这样的类型太多了，不在计数之列!
注意：答案是个整数（考虑对称性，肯定是偶数）。请通过浏览器提交。不要书写多余的内容。
```

Z:叫小明的都是很无聊...

M:用不同变量代表不同分子分母，将其对等的等式列出来，如果存在分母，使用交叉相乘法转化，最后用暴力循环的方式得出符合的变量值。

![](..\image\p3.jpg)  

```java
	public static void main(String[] args) {
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		int count = 0; 
		for (a = 1; a < 10; a++) {
			for (b = 1; b < 10; b++) {
				for (c = 1; c < 10; c++) {
					for (d = 1; d < 10; d++) {
						int temp1 = a * c;
						int temp2 = b * d;
						int temp3 = a * 10 + c;
						int temp4 = b * 10 + d;
						if(temp1 * temp4 == temp2 * temp3){
							if(a != b && c != d){
								count++;
							}
						}
					}
				}
			}
		}
		System.out.println(count);
	}
```

D:第二题

```
标题：核桃的数量
    小张是软件项目经理，他带领3个开发组。工期紧，今天都在加班呢。为鼓舞士气，小张打算给每个组发一袋核桃（据传言能补脑）。他的要求是：
    1. 各组的核桃数量必须相同
    2. 各组内必须能平分核桃（当然是不能打碎的）
    3. 尽量提供满足1,2条件的最小数量（节约闹革命嘛）

程序从标准输入读入：
a b c
a,b,c都是正整数，表示每个组正在加班的人数，用空格分开（a,b,c<30）

程序输出：
一个正整数，表示每袋核桃的数量。

例如：
用户输入：
2 4 5

程序输出：
20

再例如：
用户输入：
3 1 1

程序输出：
3

资源约定：
峰值内存消耗（含虚拟机） < 64M
CPU消耗  < 1000ms
```

Z:有这种项目经理真好。

M:循环核桃数，当第一次对所有组的%值都为0，则为核桃最少数量。

```java
	public static void main(String[] args) {
		int[] arr = new int[3];
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < arr.length; i++) {
			arr[i] = input.nextInt();
		}
		for(int i = 1;; i++){     //无限循环核桃数量
			if(i % arr[0] == 0 && i % arr[1] == 0 && i % arr[2] == 0){
				System.out.println(i);
				break;
			}
		}
	}
```

D：第三题，简单暴力

```
标题：机器人数目

少年宫新近邮购了小机器人配件，共有3类，其中，
A类含有：8个轮子，1个传感器
B类含有: 6个轮子，3个传感器
C类含有：4个轮子，4个传感器

他们一共订购了100套机器人，收到了轮子600个，传感器280个。
根据这些信息请你计算：B类型机器人订购了多少个？

请直接提交该整数，不要填写任何多余内容。
```

M：直接循环出答案

```java
public class Test3 {  
	public static void main(String[] args) {
		for (int a = 0;a<100 ; a++) {
			for (int b = 0;b<100 ; b++) {
				for (int c = 0;c<100 ; c++) {
					if(((a*8)+(b*6)+(c*4)) == 600 && ((a*1)+(b*3)+(c*4)) == 280 && (a+b+c) == 100){
						System.out.println(a+":"+b+":"+c);
						return;
					}
					
				}
			}
		}
	}
}  
```

D：岁数暴力题

```
public class Test {
	public static void main(String[] args) {
		for (int i = 1800; i < 2014; i++) {
			int num = 2014 - i;
			if(num == run(i)){
				System.out.println(i);
			}
			
		}
		
	}

	private static int run(int year) {
		int num = 0;
		for (int j = 0; j < 4; j++) {
			num += year%10;
			year = year/10;
		}
		return num;
	}
}
```

M：还好周岁计算是 当前年-出生年，不用+1







