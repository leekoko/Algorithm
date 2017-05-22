# 约瑟夫环  

## 1.分糖果  
>有n个小朋友围坐成一圈。老师给每个小朋友随机发偶数个糖果，然后进行下面的游戏：  
>每个小朋友都把自己的糖果分一半给左手边的孩子。  
>一轮分糖后，拥有奇数颗糖的孩子由老师补给1个糖果，从而变成偶数。  
>反复进行这个游戏，直到所有小朋友的糖果数都相同为止。  
>你的任务是预测在已知的初始糖果情形下，老师一共需要补发多少个糖果。  
>输入格式  
>程序首先读入一个整数N(2<N<100)，表示小朋友的人数。  
>接着是一行用空格分开的N个偶数（每个偶数不大于1000，不小于2）  
>输出格式  
>要求程序输出一个整数，表示老师需要补发的糖果数。  
>样例输入  
>3  
>2 2 4  
>样例输出  
>4  

---
题目分析：  
1. 将每个小孩的糖果数存入数组里面  
2. 执行分糖方法，之后执行补奇数方法  
3. 在补奇数前后还要添加一个检验方法，一旦全部都相等，则停止程序  
 

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
[源码](../SourceCode/Sweet.java)

---