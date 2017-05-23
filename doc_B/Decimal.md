# 进制转换

## 1.十六进制转十进制  
>问题描述  
>　　从键盘输入一个不超过8位的正的十六进制数字符串，将它转换为正的十进制数后输出。  
>　　注：十六进制数中的10~15分别用大写的英文字母A、B、C、D、E、F表示。  
>样例输入  
>FFFF  
>样例输出  
>65535  

---

题目分析：  
1.将输入的字符串分割，判断其是否为字母，为字母的话，用其代表的 数字*16 的 0个数次方  
2.如果为数字的话-‘0’获得的值  *   16的0个数次方  

```java
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String st=input.nextLine();
		char[] arr=st.toCharArray();
		long sum=0;
		int len=arr.length;
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]=='A'){
				sum+=10*(Math.pow(16, (len-i-1)));
			}else if(arr[i]=='B'){
				sum+=11*(Math.pow(16, (len-i-1)));
			}else if(arr[i]=='C'){
				sum+=12*(Math.pow(16, (len-i-1)));
			}else if(arr[i]=='D'){
				sum+=13*(Math.pow(16, (len-i-1)));
			}else if(arr[i]=='E'){
				sum+=14*(Math.pow(16, (len-i-1)));
			}else if(arr[i]=='F'){
				sum+=15*(Math.pow(16, (len-i-1)));
			}else{
				sum+=(arr[i]-'0')*(Math.pow(16, (len-i-1)));
			}
		}
		System.out.println(sum);
	}
```
[源码](../SourceCode/16to10.java)

---
