# 模拟真实

一些生活中的机械编程，一般为行走之类知识点

---

## 1.机器人行走

这是通过方向的变化，来判断变化的是x还是y

问题：L表示左转，R表示右转，L5R3R1 命令之后移动的距离（保留两位小数）
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
