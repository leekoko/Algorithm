# 1. 暴力破解法

## 1.神奇算式
>由4个不同的数字，组成的一个乘法算式，它们的乘积仍然由这4个数字组成。  
>比如：  
>210 x 6 = 1260  
>8 x 473 = 3784  
>27 x 81 = 2187  
>都符合要求。  
>如果满足乘法交换律的算式算作同一种情况，那么，包含上边已列出的3种情况，一共有多少种满足要求的算式。  

---

题目分析：  
1.这里需要解决三个问题：  
&nbsp;    a.左右数字相同     b.交换律不算     c.数字互不相同  
2.左右数字相同：将结果排序后进行比较  
3.交换律不算：限定前面的数小于后面的数  
4.数字互不相同，用自身与自身进行比较  

```java
	public static void main(String[] args) {
		int count=0;
		for (int i = 1; i < 100; i++) {
			for (int j = 10; j < 1000; j++) {
				String st=i+""+j;
				String result=i*j+"";
				if(st.length()!=4||result.length()!=4||i>=j){  //限定长度		前面小于后面（防止重复）
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
```
[源码](../SourceCode/MagicFormula.java)

---

## 2.熄灯问题
>请你写一个程序, 确定需要按下哪些按钮, 恰好使得所 有的灯都熄灭  
>每个案例由5行组成, 每一行包括6个数字  
>这些数字以空格隔开, 可以是0或1  
>0 表示灯的初始状态是熄灭的  
>1 表示灯的初始状态是点亮的  
>  
>接着按照该案例的输入格式输出5行  
>1 表示需要把对应的按钮按下   
>0 表示不需要按对应的按钮   
>每个数字以一个空格隔开  
>  
>输入：  
>0 1 1 0 1 0  
>1 0 0 1 1 1  
>0 0 1 0 0 1  
>1 0 0 1 0 1  
>0 1 1 1 0 0  
>  
>输出：  
>1 0 1 0 0 1  
>1 1 0 1 0 1  
>0 0 1 0 1 1  
>1 0 0 1 0 0  
>0 1 0 0 0 0   
>  
>输入：  
>0 0 1 0 1 0  
>1 0 1 0 1 1  
>0 0 1 0 1 1  
>1 0 1 1 0 0  
>0 1 0 1 0 0  
>  
>输出：  
>1 0 0 1 1 1  
>1 1 0 0 0 0  
>0 0 0 1 0 0  
>1 1 0 1 0 1  
>1 0 1 1 0 1  

---

题目分析：  
1.为了处理外围的问题，在数组左上右包上一层  
2.因为第一行确定，后面的也随之确定。   
所以已知第一行按钮情况，根据    n个按钮+灯亮    作用！！的灯亮情况，推出下一列按钮的情况（下一行的按钮与上一行的作用相同即可）  
3.推出到最后一行的按钮情况，（再次根据多个按钮的作用只有按钮）最终情况与灯亮对比，按钮结果与灯亮相同则说明全部都被熄灭。  

```java
	static int[][] arr;
	static int[][] press;
	public static void main(String[] args) {
		arr=new int[6][8];
		press=new int[6][8];
		Scanner input=new Scanner(System.in);
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[i].length-1; j++) {
				arr[i][j]=input.nextInt();
			}
		}
		for (int a1 = 0; a1 < 2; a1++) {
			for (int a2 = 0; a2 < 2; a2++) {
				for (int a3 = 0; a3 < 2; a3++) {
					for (int a4 = 0; a4 < 2; a4++) {
						for (int a5 = 0; a5 < 2; a5++) {
							for (int a6 = 0; a6 < 2; a6++) {
								press[1][1]=a1;
								press[1][2]=a2;
								press[1][3]=a3;
								press[1][4]=a4;
								press[1][5]=a5;
								press[1][6]=a6;
								if(f()){
									show();
								}
							}
						}
					}
				}
			}
		}
	}
	
	public static void show() {
		for (int i = 1; i < press.length; i++) {
			for (int j = 1; j < press[i].length-1; j++) {
				System.out.print(press[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static boolean f() {
		for (int i = 2; i < press.length; i++) {
			for (int j = 1; j < press[i].length-1; j++) {
				press[i][j]=(arr[i-1][j]+press[i-1][j]+press[i-1][j-1]+press[i-1][j+1]+press[i-2][j])%2;   //按钮和灯的共同作用
			}
		}
		for (int j = 1; j < arr[5].length-1; j++) {
			if(arr[5][j]!=(press[5][j]+press[5][j-1]+press[5][j+1]+press[4][j])%2){
				return false;
			}
		}
		return true;
	}

```
[源码](../SourceCode/BlackOut.java)

---

## 3.讨厌的青蛙  
>每只青蛙总是沿着一条直线跳跃稻田 • 且每次跳跃的距离都相同  
>请写一个程序, 确定: 在各条青蛙行走路径中, 踩踏水稻最多的那一条上, 有多 少颗水稻被踩踏   
>例如, 图4中答案是7, 因为第6行上全部水稻恰好构成一 条青蛙行走路径  
>程序输入  
>从标准输入设备上读入数据  
>第一行上两个整数R, C, 分别表示稻田中水稻的行数和 列数, 1≤R, C≤5000  
>第二行是一个整数N, 表示被踩踏的水稻数量, 3≤N≤5000  
>在剩下的N行中, 每行有两个整数, 分别是一颗被踩踏水 稻的行号(1~R)和列号(1~C), 两个整数用一个空格隔开  
>且每棵被踩踏水稻只被列出一次  
>程序输出    
>从标准输出设备上输出一个整数     
>如果在稻田中存在青蛙行走路径, 则输出包含最多水稻 的青蛙行走路径中的水稻数量, 否则输出0  
>  
>样例输入   //6 行 7 列  
>6 7   
>14  
>2 1  
>6 6  
>4 2  
>2 5  
>2 6  
>2 7  
>3 4  
>6 1  
>6 2  
>2 3  
>6 3  
>6 4  
>6 5  
>6 7  
>  
>样例输出  
>7  

---

题目分析：  
1. 下次输入

