# 闲聊蓝桥杯JAVA - 约瑟夫环

D:现在我们要研究一道不是很熟悉的题目，约瑟夫环

```
约瑟夫环就是循环不断地减少数量的规则  
问题：41人循环报数，数到3的就自杀，最后两个不想自杀，请问最后两个是谁?
```

Z:这道题之前的解决过程是这样的：

```java
	public static void main(String[] args) {
		int[] arr=new int[41];
		int point=0;
		int deal=0;
		int num=0;
		while(deal<39){
			if(arr[point]==0){
				num++;
			}
			if(num==3){
				arr[point]=1;
				deal++;
				num=0;   //第三个后念出的数字注意清0
			}
			point=(point+1)%41;   //point递增但不超出循环
		}
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==0){
				System.out.println(i+1);  //序号需要加1
			}
		}
	}
```

M:这段代码有什么作用？

```java 
			if(arr[point]==0){
				num++;
			}
```

Z:arr是一个存活数组，其长度有41位，每位代表一个人，而它的值0说明存活，1说明已经挂了。这个判断的意思就是让存活者报数。

M:那这一段是什么意思呢？

```java
			if(num==3){
				arr[point]=1;
				deal++;
				num=0;   //第三个后念出的数字注意清0
			}
```

Z:当报数为3的那个人，它的存活数组值改为1，表示已经挂了。然后deal表示挂了的数量，num重置报数。

M:但是``point=(point+1)%41;``在这里什么作用呢？

Z:表示当前报数的人的编号，本来只要``point++;``就可以了,但是因为这是一个环的循环，所以当point变成42的时候，要转化为1。

M:总结一下，这道题的核心就在于创建一个生存的数组，该数组用0，1表示对应值是否生存。根据num增加来确定数字3的落脚点。

D:相类似的题目还有分糖果：

```
有n个小朋友围坐成一圈。老师给每个小朋友随机发偶数个糖果，然后进行下面的游戏：    
每个小朋友都把自己的糖果分一半给左手边的孩子。  
一轮分糖后，拥有奇数颗糖的孩子由老师补给1个糖果，从而变成偶数。  
反复进行这个游戏，直到所有小朋友的糖果数都相同为止。  
你的任务是预测在已知的初始糖果情形下，老师一共需要补发多少个糖果。  
输入格式  
程序首先读入一个整数N(2<N<100)，表示小朋友的人数。  
接着是一行用空格分开的N个偶数（每个偶数不大于1000，不小于2）  
输出格式  
要求程序输出一个整数，表示老师需要补发的糖果数。  

样例输入  
3  
2 2 4  
样例输出  
4  
```

Z:这道题以前完成过，是这样写的：

```java
	static int addSweet=0;   //初始化补发的糖果数
	public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in);
		
		//获取学生数
		int student=input.nextInt();
		
		//定义每个人的糖果数数组
		int[] sweet=new int[student];
		for (int i = 0; i < sweet.length; i++) {
			sweet[i]=input.nextInt();
		}
		
		//定义分出的糖果数组
		int[] temp=new int[student];
		//while循环
		while(true){
			//执行糖果变化的方法
			chang(sweet,temp);
			//执行检查是否相同
			if(check(sweet)){
				System.out.println(addSweet);
				return;
			}
			//执行补发糖果的操作，传补发糖果数，返回是否进行补发，判断为没有补发break循环
			add(sweet);   
			//执行检查是否相同
			if(check(sweet)){
				System.out.println(addSweet);
				return;
			}
		}
	}

	public static boolean check(int[] sweet) {
		// TODO Auto-generated method stub
		boolean flag=true;   //初始化判断都相同
		for (int i = 0; i < sweet.length; i++) {
			for (int j = 0; j < sweet.length; j++) {
				if(sweet[i]!=sweet[j]){   //产生了不同
					flag=false;
				}
			}
		}
		return flag;
	}

	public static void chang(int[] sweet, int[] temp) {
		//数组每个除以2
		for (int i = 0; i < sweet.length; i++) {
			sweet[i]=sweet[i]/2;
			//遍历存进temp数组里
			temp[i]=sweet[i];
		}
		for (int i = 0; i < sweet.length; i++) {
			if(i==0){  //当最后一个的时候跟第一个拿
				sweet[i]=sweet[i]+temp[temp.length-1];
			}else{   //这是选择发生的事件
				sweet[i]=sweet[i]+temp[i-1]; //补充糖果				
			}
		}
	}
	
	public static void add(int[] sweet) {

		//循环判断，如果是奇数，补充一个糖果，添加计数
		for (int i = 0; i < sweet.length; i++) {
			if(sweet[i]%2!=0){
				sweet[i]++;
				addSweet++;
			}
		}
	}	
```

M:``while(true){``是干嘛的？

Z:因为糖果循环的次数是不确定的，所以使用无限循环。

M:那这个chang()方法是干什么？

```java
	public static void chang(int[] sweet, int[] temp) {
		//数组每个除以2
		for (int i = 0; i < sweet.length; i++) {
			sweet[i]=sweet[i]/2;
			//遍历存进temp数组里
			temp[i]=sweet[i];
		}
		for (int i = 0; i < sweet.length; i++) {
			if(i==0){  //当最后一个的时候跟第一个拿
				sweet[i]=sweet[i]+temp[temp.length-1];
			}else{   //这是选择发生的事件
				sweet[i]=sweet[i]+temp[i-1]; //补充糖果				
			}
		}
	}
```

Z:temp是一个空的数组，前边的操作用temp来存储孩子拿出的一半糖果数。而后边的操作是，将这一半的糖果给旁边的人。其中第一个需要特殊处理，因为他的糖果来自于最后一个。

M:``check()``方法是检查各糖果数是否相同，``add()``方法是为奇数的孩子补糖果。在``chang()``方法后面添加``check()``检查，但是为什么在``add()``后面也要添加``check()``检查？

Z:这是隐藏的题意所在，只要改变糖果数量，就要进行检验``check()``。

M:所以本题的重点就是对糖果转移的处理，通过两个数组的方式来对糖果进行变化。其中要注意转移糖果 & 补糖果 操作之后都要对其进行检验。

