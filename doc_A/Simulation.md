# ģ����ʵ

һЩ�����еĻ�е��̣�һ��Ϊ����֮��֪ʶ��

---

## 1.����������

����ͨ������ı仯�����жϱ仯����x����y

���⣺L��ʾ��ת��R��ʾ��ת��L5R3R1 ����֮���ƶ��ľ��루������λС����
�������ⲻ�Ǽ��ķ����������������������

```java
static int x=0;  //�����굥����ȡ��������Ϊ��������
static int y=0;
public static void main(String[] args) {

	int point=0;
	//�����+3�����������������Ϊ������0~3��ʾ������%4
	point=(point+3)%4;  //��ת  ����ֻ��һ����һ�����ֱ�ʾ
	run(point,5);  //��5��
	
	point=(point+1)%4;  //��ת  
	run(point,3);  
	
	point=(point+1)%4; 
	run(point,1);  
	
	System.out.println(new DecimalFormat("0.00").format(Math.sqrt(x*x+y*y)));
		
}
public static void run(int point, int i) {
	if(point==0){ //����
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


[����������](../doc_B/RobotRun.md#1����������) 


---
