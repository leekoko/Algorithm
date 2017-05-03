# 递归

## 1.奇怪的比赛
>某电视台举办了低碳生活大奖赛。题目的计分规则相当奇怪：  
>（1）每位选手需要回答10个问题（其编号为1到10），越后面越有难度。答对的，当前分数翻倍；答错了则扣掉与题号相同的分数（选手必须回答问题，不回答按错误处理）。  
>（2）每位选手都有一个起步的分数为10分。 某获胜选手最终得分刚好是100分，如果不让你看比赛过程，你能推断出他（她）哪个题目答对了，哪个题目答错了吗？  
>（3）如果把答对的记为1，答错的记为0，则10个题目的回答情况可以用仅含有1和0的串来表示。例如：0010110011 就是可能的情况。  
>（4） 你的任务是算出所有可能情况。每个答案占一行。  

---

题目分析：  
1.这里用递归解，每一层变化的数据有：a.题目数 b.分数 c.对错情况   （注意分数减的是下一题：+1）  
2.递归的结点是n==10  

```java
	public static void main(String[] args) {
		f(0,10,"");
	}

	public static void f(int num, int fen, String st) {
		if(num==10){
			if(fen==100){
				System.out.println(st);
			}
			return;
		}
		f(num+1,fen*2,st+1);
		f(num+1,fen-num-1,st+0);
	}
```
[源码](../SourceCode/OddMatch.java)

---

## 2.加法划分  
>如，对于正整数n=6，可以分划为：  
>6  
>5+1  
>4+2, 4+1+1  
>3+3, 3+2+1, 3+1+1+1  
>2+2+2, 2+2+1+1,2+1+1+1+1  
>1+1+1+1+1+1+1  
>现在的问题是，对于给定的正整数n,编写算法打印所有划分。  
>用户从键盘输入 n（范围1~10）  

---

题目分析：  
1. 这里使用递归式生成，递归的参数是 现在剩余的数值，已用的数字量  
2. 一旦剩余数为0，输出数字量之内的内容  
3. 要解决交换重复的问题：统一前面大于后边，判断后边如果大于前边就continue，为了防止空指针异常，还需要对脚标进行限制  

```java
public static void main(String[] args) {
	arr=new int[10000];
	f(6,0);
}
public static void f(int num, int point) {
	if(num==0){
		for (int i = 0; i < point-1; i++) {
			System.out.print(arr[i]+"+");
		}
		System.out.print(arr[point-1]);   //解决最后一个不用+问题
		System.out.println();
	}
	
	for (int i = num; i >0; i--) {
		if(point>0&&i>arr[point-1]){
			continue;
		}
		arr[point]=i;
		f(num-i,point+1);
	}
}
```
[源码](../SourceCode/AddCut.java)

---

## 3.绳圈
>今有 100 根绳子，当然会有 200 个绳头。   
>如果任意取绳头两两配对，把所有绳头都打结连接起来。最后会形成若干个绳圈（不考虑是否套在一起）。   
>我们的问题是：请计算最后将形成多少个绳圈的概率最大？   

---

题目分析：  
1. 递归式子：m个绳子n个圈  
第一种情况：f(n-1,m-1)    表示一条绳子自己相连  
第二种情况：2*(n-1)*f(n-1,m)   不形成一个绳子的话有2*(m-1)种连法，其结果就是绳子少了一根，但是圈数没有减少  
2. 结点：  
n==m：表示各自为圈，有1种结果  
m==1：表示形成一个大圈，有2*(n-1)*f(n-1,1)种结果  
3. 要点：  
返回值为double ， 用二维数组存储  

```java
	static double[][] arr=new double[1000][1000];
	public static void main(String[] args) {
		for (int i = 1; i <=10; i++) {
			System.out.println(f(10,i));
		}
	}

	public static double f(int n, int m) {
		if(arr[n][m]!=0){
			return arr[n][m];
		}
		if(n==m){     //这里n逐渐递减，总有和m相同的时候，所以不用判断m>n
			return 1;
		}
		if(m==1){
			return arr[n][m]=2*(n-1)*f(n-1,1);
		}
		return arr[n][m]=f(n-1,m-1)+2*(n-1)*f(n-1,m);    
	}
```
[源码](../SourceCode/RopeCircle.java)

---





