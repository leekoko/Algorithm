# 1. 栈

## 1.出栈次序  
>X星球特别讲究秩序，所有道路都是单行线。一个甲壳虫车队，共16辆车，按照编号先后发车，夹在其它车流中，缓缓前行  
>路边有个死胡同，只能容一辆车通过，是临时的检查站，如图【p1.png】所示。  
>X星球太死板，要求每辆路过的车必须进入检查站，也可能不检查就放行，也可能仔细检查。  
>如果车辆进入检查站和离开的次序可以任意交错。那么，该车队再次上路后，可能的次序有多少种？  
>为了方便起见，假设检查站可容纳任意数量的汽车。  
>显然，如果车队只有1辆车，可能次序1种；2辆车可能次序2种；3辆车可能次序5种。  
>现在足足有16辆车啊，亲！需要你计算出可能次序的数目。  
>这是一个整数，请通过浏览器提交答案，不要填写任何多余的内容（比如说明性文字）。     

---

题目分析：  
我的个人思路是：  
   1.获取其排列组合的所有情况  
   2.运用铁轨压栈看看情况符不符合，符合就+1  
但是这种解法有缺陷，时间复杂度太高，所以要可行是使用    
卡特兰数         arr[i]=arr[i-1]*(4*i-2)/(i+1);    
角标内的数字代表改数量下可能次序的数目  

```java
	public static void main(String[] args) {
		//数组存储次序的数目
		int[] arr=new int[17];
		arr[1]=1;
		for (int i = 2; i < arr.length; i++) {
			arr[i]=arr[i-1]*(4*i-2)/(i+1);//卡特兰式
		}
		System.out.println(arr[16]);
	}
```
[源码无](#)

---

## 2.铁轨  
>某城市有一个火车站，有n节车厢从A方向驶入车站，按进站的顺序编号为1~n。现让它们按照某种特定的顺序进入B方向的铁轨并驶出车站。为了重组车厢，你可以借助中转站C。在程序中输入车厢数目和出站的特定顺序，如果可以则输出Yes，否者输出No。
>样例输入：
>5
>1 2 3 4 5
>5
>5 4 1 2 3
>6
>6 5 4 3 2 1
>样例输出：
>Yes
>No
>Yes 

---

题目分析：
1. 将数字压入栈中
2. 不断判断栈顶的是不是想要显示的数据，是的话弹出，判断下一个
3. 最终根据栈中是否还有内容来输出Yes/No

```java
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int num=input.nextInt();
		int[] arr=new int[num];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=input.nextInt();
		}
		Stack<Integer> stack=new Stack<Integer>();
		int point=0;
		for (int i = 1; i <= arr.length; i++) {
			stack.push(i);
			while(stack.size()>0&&stack.peek()==arr[point]){
				stack.pop();
				point++;
			}
		}
		if(stack.size()==0){
			System.out.println("Yes");
		}else{
			System.out.println("No");
		}
	}
```
[源码](../SourceCode/Rail.java)

---