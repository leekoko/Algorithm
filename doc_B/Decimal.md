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

## 2.十六进制转八进制  
>问题描述  
>　　给定n个十六进制正整数，输出它们对应的八进制数。  
>  
>输入格式  
>　　输入的第一行为一个正整数n （1<=n<=10）。  
>　　接下来n行，每行一个由0~9、大写字母A~F组成的字符串，表示要转换的十六进制正整数，每个十六进制数长度不超过100000。  
>  
>输出格式  
>　　输出n行，每行为输入对应的八进制正整数。  
>  
>　【注意】  
>　　输入的十六进制数不会有前导0，比如012A。  
>　　输出的八进制数也不能有前导0。  
>  
>样例输入  
>　　2  
>　　39  
>　　123ABC  
>  
>样例输出  
>　　71  
>　　4435274  
>  
>　　【提示】  
>　　先将十六进制数转换成某进制数，再由某进制数转换成八进制。  

---

题目分析：  
大体思路就是将十六进制转化为二进制，再将二进制转化为八进制  
1. 怎么将十六进制转化为二进制呢，将1-F一个个匹配四位的二进制，组成一个二进制串  
2. 二进制转化为八进制之前要进行处理，变成3的倍数    补0或者删除0  
3. 成为3的倍数之后就对字符进行3个3个划分，从000对应0开始一直到8，最后输出组成的八进制  

```java
public class Main {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String st=input.nextLine();

		//转化为二进制
		char[] arr=st.toCharArray();
		StringBuffer sb=new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]=='0'){
				sb.append("0000");
			}if(arr[i]=='1'){
				sb.append("0001");
			}if(arr[i]=='2'){
				sb.append("0010");
			}if(arr[i]=='3'){
				sb.append("0011");
			}if(arr[i]=='4'){
				sb.append("0100");
			}if(arr[i]=='5'){
				sb.append("0101");
			}if(arr[i]=='6'){
				sb.append("0110");
			}if(arr[i]=='7'){
				sb.append("0111");
			}if(arr[i]=='8'){
				sb.append("1000");
			}if(arr[i]=='9'){
				sb.append("1001");
			}if(arr[i]=='A'){
				sb.append("1010");
			}if(arr[i]=='B'){
				sb.append("1011");
			}if(arr[i]=='C'){
				sb.append("1100");
			}if(arr[i]=='D'){
				sb.append("1101");
			}if(arr[i]=='E'){
				sb.append("1110");
			}if(arr[i]=='F'){
				sb.append("1111");
			}
		}
		//补串
		if(sb.length()%3==0){
			if(sb.substring(0,3).equals("000")){
				sb.delete(0, 3);
			}
		}else if(sb.length()%3==1){
			if(sb.substring(0,1).equals("0")){
				sb.delete(0, 1);
			}else{
				sb.insert(0, "00");
			}
		}else if(sb.length()%3==2){
			if(sb.substring(0,2).equals("00")){
				sb.delete(0, 2);
			}else{
				sb.insert(0, "0");
			}
		}
		//转化为八进制
		int point=0;
		StringBuilder sb_2=new StringBuilder();
		while(point<sb.length()){
			if(sb.substring(point, point+3).equals("000")){
				sb_2.append("0");
			}else if(sb.substring(point, point+3).equals("001")){
				sb_2.append("1");
			}else if(sb.substring(point, point+3).equals("010")){
				sb_2.append("2");
			}else if(sb.substring(point, point+3).equals("011")){
				sb_2.append("3");
			}else if(sb.substring(point, point+3).equals("100")){
				sb_2.append("4");
			}else if(sb.substring(point, point+3).equals("101")){
				sb_2.append("5");
			}else if(sb.substring(point, point+3).equals("110")){
				sb_2.append("6");
			}else if(sb.substring(point, point+3).equals("111")){
				sb_2.append("7");
			}
			point=point+3;
		}
		System.out.println(sb_2.toString());
	}
}
```
[源码](../SourceCode/16to8.java)

---

