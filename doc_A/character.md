# 填字母游戏

D：今天是一道很有游戏感的题目(只是挂名LOL)：

```
标题：填字母游戏

小明经常玩 LOL 游戏上瘾，一次他想挑战K大师，不料K大师说：
“我们先来玩个空格填字母的游戏，要是你不能赢我，就再别玩LOL了”。

K大师在纸上画了一行n个格子，要小明和他交替往其中填入字母。
并且：
1. 轮到某人填的时候，只能在某个空格中填入L或O
2. 谁先让字母组成了“LOL”的字样，谁获胜。
3. 如果所有格子都填满了，仍无法组成LOL，则平局。

小明试验了几次都输了，他很惭愧，希望你能用计算机帮他解开这个谜。

本题的输入格式为：
第一行，数字n（n<10），表示下面有n个初始局面。
接下来，n行，每行一个串，表示开始的局面。
  比如：“******”, 表示有6个空格。
  “L****”,   表示左边是一个字母L，它的右边是4个空格。

要求输出n个数字，表示对每个局面，如果小明先填，当K大师总是用最强着法的时候，小明的最好结果。
1 表示能赢
-1 表示必输
0 表示可以逼平

例如，
输入：
4
***
L**L
L**L***L
L*****L

则程序应该输出：
0
-1
1
1

资源约定：
峰值内存消耗 < 256M
CPU消耗  < 1000ms

请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
注意：不要使用package语句。不要使用jdk1.7及以上版本的特性。
注意：主类的名字必须是：Main，否则按无效代码处理。
```

Z：这是一道博弈类型的题目，两个空的时候，先下的输。

M：那怎么推测出是谁造成这两个空的情况呢？那个人就是赢家。

Z：这道题目前没有什么思路，看一下网友的解法[链接](https://blog.csdn.net/qq_34525938/article/details/79369315)  。


```java
import java.util.ArrayList;  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;  
import java.util.Scanner;  
  
class Main{  
    static String str;  
    static Map<String, Integer>map=new HashMap<>();  
    public static void main(String[] args) {  
        Scanner s=new Scanner(System.in);  
        int n=s.nextInt();  
        str=s.nextLine();  
        long currentTimeMillis = System.currentTimeMillis();  
        for(int i=0;i<n;i++)  
        {  
            str=s.nextLine();  
            System.out.println(adv());//-1 -1 1   L***L***L  
        }  
//  System.out.println(System.currentTimeMillis()-currentTimeMillis);  
    }  
    private static int adv() {//预处理  
          
        int index=0;  
        int a,b,len1 = 0,len2=0;  
        index=str.indexOf("*L*");  
        if(index>0)  
        {  
            String temp=str;  
            str=temp.substring(0,index+2);  
            for(int i=0;i<str.length();i++)  
                if(str.charAt(i)=='*')  
                    len1++;  
            a=f();  
            str=temp.substring(index+1);  
            for(int i=0;i<str.length();i++)  
                if(str.charAt(i)=='*')  
                    len2++;  
            b=f();  
            str=temp;  
  
            return u(a, b, len1, len2);  
              
        }else  
        {  
          return f();  
        }  
    }  
    private static int u(int a,int b,int len1,int len2)  
    {  
          
        if((a==1&&len1==1)||(b==1&&len2==1))  
            return 1;  
          
        if(a==1&&b==1)  
            return -1;  
        if(a==b)     
            return a;  
          
        if(a!=0&&b!=0)   
            return 1;  
          
        if(a==1||b==1)  
            return 1;  
          
        if(a==-1&&b==0)    
            return (len2%2==0)?a:-a;  
          
        if(a==0&&b==-1)  
            return (len1%2==0)?b:-b;  
          
        if(a==1&&b==0)  
        {  
            if(len1==1)return 1;  
            return (len2%2==0)?a:-a;  
        }  
          
        if(len2==1) return 1;  
        return (len1%2==0)?b:-b;  
          
          
    }  
    private static int f() {  
          
        if(str.contains("*OL")||str.contains("L*L")||str.contains("LO*"))  
          return 1;//终止条件  
        if(!str.contains("*"))  
            return 0;  
          
        //如果L****或者*****L  
        if((str.startsWith("L***")&&!str.substring(1).contains("O")&&!str.substring(1).contains("L"))  
           ||  
        (str.endsWith("***L")&&!str.substring(0,str.length()-1).contains("O")&&!str.substring(0,str.length()-1).contains("L")))  
            return (str.length()%2==0)?1:-1;  
          
        List<Integer> indexs=index(str);//返回*号下标数组  
          
        int [] result=new int[indexs.size()*2];  
        int k=0;  
        for(int i=0;i<indexs.size();i++)  
        {  
            //换  
            str=rep(str, indexs.get(i), 'L');  
              
            if(map.containsKey(tri(str))){  
                result[k++]=map.get(tri(str));  
            }else{  
                map.put(tri(str),result[k++]=f());  
            }  
              
            if(result[k]==-1)  
            {  
                str=rep(str, indexs.get(i), '*');  
                return 1;  
            }  
                  
                  
            str=rep(str, indexs.get(i), 'O');  
              
            if(map.containsKey(tri(str))){  
                result[k++]=map.get(tri(str));  
            }else{  
                map.put(tri(str),result[k++]=f());  
            }  
              
            if(k<result.length&&result[k]==-1)  
            {  
                str=rep(str, indexs.get(i), '*');  
                return 1;  
            }  
              
            str=rep(str, indexs.get(i), '*');  
        }  
          
        return vote(result);  
          
    }  
  
    private static String tri(String str)  
    {  
        int start=str.indexOf('*');  
        int end=str.lastIndexOf('*');  
        if(start-2<0) start=2;  
        if(end+3>=str.length()) end=str.length()-3;  
        str=str.substring(start-2,end+3);   
          
        if(str.startsWith("OL*")||str.startsWith("OO*")||str.startsWith("LL*"))  
            str=str.substring(1);  
        if(str.endsWith("*LO ")||str.endsWith("*OO")||str.endsWith("*LL"))  
            str=str.substring(0,str.length()-1);  
        return str;  
    }  
      
    //replace函数  
    private static String rep(String str,int index,char a)  
    {  
        return str.substring(0,index)+a+str.substring(index+1);  
    }  
      
    //vote函数(全为1返回-1,有一个-1返回1)  
    private static int vote(int []a)  
    {  
        int min=1;  
        for(int i=0;i<a.length;i++)  
        {  
            min=min<a[i]?min:a[i];  
        }  
        return 0-min;  
    }  
      
    //返回*下标数组  
    private static List index(String nextLine) {  
        List<Integer> list=new ArrayList<Integer>();  
        int qian=0;  
        while(nextLine.contains("*"))  
        {  
            int index=nextLine.indexOf("*");  
            list.add(qian+index);  
            nextLine=nextLine.substring(index+1);  
            qian+=index+1;  
        }  
        return list;  
    }  
}  
```

感觉这种解法有点混乱，比赛中可能不适合想这么复杂的解法。

找到了C++的解法，非常简洁 [链接](https://blog.csdn.net/krypton12138/article/details/79631866)：  

```c++
#include <iostream>  
#include <cstring>  
using namespace std;  
int fun(string x){  
    if(x.find("LOL") != -1)return -1;  
    if(x.find("*") == -1)return 0;  
    int res = -1;  
    for(int i = 0;x[i];i++)  
    if(x[i] == '*'){  
        x[i] = 'L';  
        res = max(res,-fun(x));  
        if(res == 1)return x[i] = '*',1;  
        x[i] = 'O';  
        res = max(res,-fun(x));  
        x[i] = '*';  
    }  
    return res;  
}  
int main(){  
    int t;  
    cin >> t;  
    while(t--){  
        string x;  
        cin >> x;  
        cout << fun(x) << endl;  
    }  
    return 0;  
}  
```

这里我将它转化为java：

```java
public class Test2{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		for (int i = 0; i < num; i++) {
			String str = input.next();
			System.out.println(fun(str));
		}
	}

	private static int fun(String str) {
	    if(str.indexOf("LOL") != -1){   //已经有LOL,输了
	    	return -1;  
	    }	
	    if(str.indexOf("*") == -1){   //没有空了，打成平局
	    	return 0;
	    }  
	    int res = -1;  //初始化输了
	    char[] arr = str.toCharArray();
	    for (int i = 0; i < arr.length; i++) {   //遍历每个空
		    if(arr[i] == '*'){
		    	arr[i] = 'L';
		    	res = Math.max(res,-fun(new String(arr)));   //返回最大的那一个，对手
		    	if(res == 1){   //赢了 
		    		arr[i] = '*';   //回溯
		    		return 1;
		    	}
		    	arr[i] = 'O';   
		    	res = Math.max(res,-fun(new String(arr))); 
		    	arr[i] = '*';
		    }
		}
	    return res;  
	}
	
}
```

M：博弈问题的题目有什么大特点呢?

Z：