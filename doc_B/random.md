# 随机算法

## 1.运算24点数  
>给定4张扑克牌，点数：1~10，用+-*/运算，结果正好为24,列出请正确的式子

---

题目分析：  
1. 这是一种新的获取数据的方式，将输入的内容分割后放入数组中  
String[] ss=scan.nextLine().split("\\,");   //这是用来分割 “，”的
2. 这里使用了栈Stack容器，其使用方法如下  
     Stack st=new Stack();   //声明空容器  
     System.out.println(st);  
     st.push(new Integer(3));   //添加Object容器内容  
     st.push(new String("kkk")); //添加Object容器内容2（不分种类）  
     System.out.println(st);  
     st.pop();   //删除后添加的内容  
     System.out.println(st);  
3.输入数字之后，随机生成符号，连成逆波兰表达式  
每次进行洗牌，判断是否符合，是的话就输出  
4. 怎么判断呢  
判断符号，还是数字  
符号就将其与数字传进运算  
数字就继续压栈，解决非单位的问题  
判断数字运算之后结果是否为24，返回boolean  
5. 怎么输出呢  
将其数组内容判断，转化为字符串存入栈中  
输出栈的内容  

```java
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String[] temp=input.nextLine().split(" ");
		String[] arr=new String[7]; 
		while(true){
			for (int i = 0; i < 4; i++) {     //每次一次都要对符号进行洗牌，所以数字应该每次重新输入
				arr[i]=temp[i];
			}
			for (int i = 4; i < arr.length; i++) {   //获取随机符号
				arr[i]=suiFu();
			}
			xi(arr);   //洗牌
			if(jisuan(arr)){    //如果逆波兰函数刚好运行正确
				show(arr);    //显示数据
				return;
			}
		}
	}

	public static void show(String[] arr) {
		Stack<String> stack=new Stack<String>();
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].equals("+")||arr[i].equals("-")||arr[i].equals("*")||arr[i].equals("/")){
				String b=(String)stack.pop();
				String a=(String)stack.pop();
				stack.push("("+a+arr[i]+b+")");   //统一存储为字符串
			}else{
				stack.push(arr[i]);
			}
		}
		System.out.println(stack.pop());
		
	}

	public static boolean jisuan(String[] arr) {
		Stack<String> stack=new Stack<String>();
		try{
			for (int i = 0; i < arr.length; i++) {
				if(arr[i].equals("+")||arr[i].equals("-")||arr[i].equals("*")||arr[i].equals("/")){
					int b=Integer.parseInt((String)stack.pop());     //取出栈中的东西可能会抛出错误
					int a=Integer.parseInt((String)stack.pop());
					stack.push(yun(a,b,arr[i])+"");   //统一存储为字符串（防止int转换int）
				}else{
					stack.push(arr[i]);    //压栈数字
				}
			}
		}catch (Exception e) {
			return false;   //有异常就返回false    
		}
		if(stack.size()==1&&stack.pop().toString().equals("24")){  //符合栈中只有一个数，并且其为24
			return true;
		}
		return false;
	}

	private static int yun(int a, int b, String st) throws Exception {
		if(st.equals("+")){
			return a+b;
		}else if(st.equals("-")){
			return a-b;
		}else if(st.equals("*")){
			return a*b;
		}else{
			if(a%b!=0){
				throw new Exception("no /");
			}
		}
		return a/b;
	}

	public static void xi(String[] arr) {
		for (int i = 0; i < arr.length; i++) {   //每个数都彻底洗牌    
			int num=(int) (Math.random()*7);
			String temp=arr[i];
			arr[i]=arr[num];
			arr[num]=temp;
		}
	}

	public static String suiFu() {
		int num=(int) (Math.random()*4);
		if(num==0){
			return "+";
		}else if(num==1){
			return "-";
		}else if(num==2){
			return "*";
		}else{
			return "/";
		}
	}
```
_答案：  
4 4 10 10           （（10*10）-4）/4)  
3 4 5  6             (6*((3+5)-4))_  

[源码](../SourceCode/24Points.java)

---

## 2.第2道题
