import java.util.Scanner;
/*ʮ������ת�˽���  


��������
��������n��ʮ��������������������Ƕ�Ӧ�İ˽�������

�����ʽ
��������ĵ�һ��Ϊһ��������n ��1<=n<=10����
����������n�У�ÿ��һ����0~9����д��ĸA~F��ɵ��ַ�������ʾҪת����ʮ��������������ÿ��ʮ�����������Ȳ�����100000��

�����ʽ
�������n�У�ÿ��Ϊ�����Ӧ�İ˽�����������

������ע�⡿
���������ʮ��������������ǰ��0������012A��
��������İ˽�����Ҳ������ǰ��0��

��������
����2
����39
����123ABC

�������
����71
����4435274

��������ʾ��
�����Ƚ�ʮ��������ת����ĳ������������ĳ������ת���ɰ˽��ơ�*/

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
                     if(c[j]=='0'){     //15��������16����
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
