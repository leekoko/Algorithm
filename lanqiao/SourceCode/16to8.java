import java.util.Scanner;
/*十六进制转八进制  


问题描述
　　给定n个十六进制正整数，输出它们对应的八进制数。

输入格式
　　输入的第一行为一个正整数n （1<=n<=10）。
　　接下来n行，每行一个由0~9、大写字母A~F组成的字符串，表示要转换的十六进制正整数，每个十六进制数长度不超过100000。

输出格式
　　输出n行，每行为输入对应的八进制正整数。

　　【注意】
　　输入的十六进制数不会有前导0，比如012A。
　　输出的八进制数也不能有前导0。

样例输入
　　2
　　39
　　123ABC

样例输出
　　71
　　4435274

　　【提示】
　　先将十六进制数转换成某进制数，再由某进制数转换成八进制。*/

public class Main{
	   public static void main(String[] args) {
           Scanner input=new Scanner(System.in);
           int num=input.nextInt();
           String[] arr=new String[num];
           for (int i = 0; i < arr.length; i++) {
                arr[i]=input.next();
           }
           for (int i = 0; i < arr.length; i++) {
                char[] c=arr[i].toCharArray();
                StringBuilder sb=new StringBuilder();
                for (int j = 0; j < c.length; j++) {
                     if(c[j]=='0'){     //15个数就是16进制
                           sb.append("0000");
                     }else if(c[j]=='1'){
                           sb.append("0001");
                     }else if(c[j]=='2'){
                           sb.append("0010");
                     }else if(c[j]=='3'){
                           sb.append("0011");
                     }else if(c[j]=='4'){
                           sb.append("0100");
                     }else if(c[j]=='5'){
                           sb.append("0101");
                     }else if(c[j]=='6'){
                           sb.append("0110");
                     }else if(c[j]=='7'){
                           sb.append("0111");
                     }else if(c[j]=='8'){
                           sb.append("1000");
                     }else if(c[j]=='9'){
                           sb.append("1001");
                     }else if(c[j]=='A'){
                           sb.append("1010");
                     }else if(c[j]=='B'){
                           sb.append("1011");
                     }else if(c[j]=='C'){
                           sb.append("1100");
                     }else if(c[j]=='D'){
                           sb.append("1101");
                     }else if(c[j]=='E'){
                           sb.append("1110");
                     }else if(c[j]=='F'){
                           sb.append("1111");
                     }
                }
                if(sb.length()%3==0){
                     if(sb.substring(0,3).equals("000")){
                           sb.delete(0, 3);
                     }
                }else if(sb.length()%3==2){
                     if(sb.substring(0, 2).equals("00")){
                           sb.delete(0, 2);
                     }else{
                           sb.insert(0, "0");
                     }
                }else{
                     if(sb.substring(0, 1).equals("0")){
                           sb.delete(0, 1);
                     }else {
                           sb.insert(0, "00");
                     }
                }
                int point=0;
                StringBuilder sb2=new StringBuilder();
                while(point<sb.length()){
                     if(sb.substring(point, point+3).equals("000")){
                           sb2.append("0");
                     }else if(sb.substring(point, point+3).equals("001")){
                           sb2.append("1");
                     }else if(sb.substring(point, point+3).equals("010")){
                           sb2.append("2");
                     }else if(sb.substring(point, point+3).equals("011")){
                           sb2.append("3");
                     }else if(sb.substring(point, point+3).equals("100")){
                           sb2.append("4");
                     }else if(sb.substring(point, point+3).equals("101")){
                           sb2.append("5");
                     }else if(sb.substring(point, point+3).equals("110")){
                           sb2.append("6");
                     }else if(sb.substring(point, point+3).equals("111")){
                           sb2.append("7");
                     }
                     point=point+3;
                }
                System.out.println(sb2.toString());
           }
     }

}
