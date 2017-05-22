# 模拟真实

一些生活中的机械编程，一般为行走之类知识点

---

## 1.机器人行走

这是通过方向的变化，来判断变化的是x还是y

**问题：L表示左转，R表示右转，L5R3R1 命令之后移动的距离（保留两位小数）**  
分析：这不是简便的方法，但尽量做到容易理解

```java
static int x=0;  //把坐标单独提取，可以作为对象属性
static int y=0;
public static void main(String[] args) {

	int point=0;
	//左边用+3，避免产生负数，因为方向用0~3表示，所以%4
	point=(point+3)%4;  //左转  方向只有一个，一个数字表示
	run(point,5);  //走5步
	
	point=(point+1)%4;  //右转  
	run(point,3);  
	
	point=(point+1)%4; 
	run(point,1);  
	
	System.out.println(new DecimalFormat("0.00").format(Math.sqrt(x*x+y*y)));
		
}
public static void run(int point, int i) {
	if(point==0){ //向上
		x=x-i;
	}else if(point==1){
		y=y+i;
	}else if(point==2){
		x=x+i;
	}else{
		y=y-i;
	}
}
```

[机器人行走](../doc_B/RobotRun.md#1机器人行走) 

---

## 2.计算机模拟  

一般都是模拟计算机的一些操作  

**问题：你在输入文章的时候，键盘上的Home键和End键出了问题，会不定时的按下。给你一段按键的文本，其中'['表示Home键，']'表示End键，输出这段悲剧的文本。**  

Sample Input  
This_is_a_[Beiju]_text  
[[]][][]Happy_Birthday_to_Tsinghua_University  
Sample Output  
BeijuThis_is_a__text  
Happy_Birthday_to_Tsinghua_University  

题目分析：   
本题就是一遇到[ / ] 就对前面的内容添加到链表，至于添加到哪一个位置，那就需要看是否按下[，添加完之后再决定按下[  
1. 则将前面存储的StringBuilder存进LinkedList中，至于存前面还是后面，就判断home键按过没有（之前的是[按过没有，还是外面的）  
2. 每次添加完LinkedList之后都要将StringBuilder清空  
3. 最后StringBuilder之中肯定还有东西，还需要再追加一次  

```java
public static void main(String[] args) {
	
	Scanner input=new Scanner(System.in);
	String t=input.nextLine();
	char[] arr=t.toCharArray();
	StringBuilder sb=new StringBuilder();
	boolean isJin=false;
	LinkedList<StringBuilder> ll=new LinkedList<StringBuilder>();
	
	for (int i = 0; i < arr.length; i++) {
		if(arr[i]=='['){
			f(sb, isJin, ll);   //添加前面的内容
			sb=new StringBuilder();
			isJin=true;   //确定是否按下
		}else if (arr[i]==']') {
			f(sb, isJin, ll);
			sb=new StringBuilder();
			isJin=false;
		}else{
			sb.append(arr[i]);
		}
	}
	
	f(sb, isJin, ll);
	for (int j = 0; j < ll.size(); j++) {
		System.out.print(ll.get(j).toString());
	}
}

private static void f(StringBuilder sb, boolean isJin, LinkedList<StringBuilder> ll) {
	if(isJin){
		ll.addFirst(sb);
	}else{
		ll.addLast(sb);
	}
}
```

---