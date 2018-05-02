# 闲聊蓝桥杯JAVA - 青蛙跳杯子   

D:今天完成一道比较新的题目，使用的是dfs

```
标题：青蛙跳杯子
    X星球的流行宠物是青蛙，一般有两种颜色：白色和黑色。
    X星球的居民喜欢把它们放在一排茶杯里，这样可以观察它们跳来跳去。
    如下图，有一排杯子，左边的一个是空着的，右边的杯子，每个里边有一只青蛙。

*WWWBBB

    其中，W字母表示白色青蛙，B表示黑色青蛙，*表示空杯子。

    X星的青蛙很有些癖好，它们只做3个动作之一：
    1. 跳到相邻的空杯子里。
    2. 隔着1只其它的青蛙（随便什么颜色）跳到空杯子里。
    3. 隔着2只其它的青蛙（随便什么颜色）跳到空杯子里。

    对于上图的局面，只要1步，就可跳成下图局面：

WWW*BBB

本题的任务就是已知初始局面，询问至少需要几步，才能跳成另一个目标局面。

输入为2行，2个串，表示初始局面和目标局面。
输出要求为一个整数，表示至少需要多少步的青蛙跳。

例如：
输入：
*WWBB
WWBB*

则程序应该输出：
2

再例如，
输入：
WWW*BBB
BBB*WWW

则程序应该输出：
10

我们约定，输入的串的长度不超过15

资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 1000ms


请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。

所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
不要使用package语句。不要使用jdk1.7及以上版本的特性。
主类的名字必须是：Main，否则按无效代码处理。

----------------------------

笨笨有话说：
    我梦见自己是一棵大树，
    青蛙跳跃，
    我就发出新的枝条，
    春风拂动那第 5 层的新枝,
    哦，我已是枝繁叶茂。
```

M:听说这道题是深度优先算法，什么是深度优先算法，今天我一定要搞清楚。 

Z:先看看网友是怎么完成这道题目的：感觉写法蛮规范的   [链接](https://blog.csdn.net/shdhhfhj/article/details/79666397)   

```java
import java.util.HashSet;  
import java.util.Scanner;  
import java.util.Set;  
  
public class Main {  
    static String fs;  
    static String es;  
    public static void main(String[] args) {  
        Scanner in=new Scanner(System.in);  
        fs=in.nextLine();  
        es=in.nextLine();  
        System.out.println(bfs());  
    }  
    public static String swap(String c,int i,int j){  
        char at[]=c.toCharArray();  
        char t=c.charAt(i);  
        at[i]=at[j];  
        at[j]=t;  
        c=String.valueOf(at);  
        return c;  
    }  
    public static int bfs(){  
        Set<String>set=new HashSet<String>();  
        set.add(fs);  
        int step[]=new int[120000];  
        step[0]=0;  
        String q[]=new String[120000];  
        q[0]=fs;  
        int l=0,r=1;  
        while(l<r){  
            String c=q[l];  
            String n;  
            int index=c.indexOf("*");  
            if(index+1<c.length()){  
                n=swap(c,index,index+1);  
                if(!set.contains(n)){  
                    step[r]=step[l]+1;  
                    q[r]=n;  
                    if(n.equals(es)){  
                        return step[r];  
                    }  
                    set.add(n);  
                    r++;  
                }  
            }  
            if(index+2<c.length()){  
                n=swap(c,index,index+2);  
                if(!set.contains(n)){  
                    step[r]=step[l]+1;  
                    q[r]=n;  
                    if(n.equals(es)){  
                        return step[r];  
                    }  
                    set.add(n);  
                    r++;  
                }  
            }  
            if(index+3<c.length()){  
                n=swap(c,index,index+3);  
                if(!set.contains(n)){  
                    q[r]=n;  
                    step[r]=step[l]+1;  
                    if(n.equals(es)){  
                        return step[r];  
                    }  
                    set.add(n);  
                    r++;  
                }  
            }  
            if(index-1>=0){  
                n=swap(c,index,index-1);  
                if(!set.contains(n)){  
                    step[r]=step[l]+1;  
                    q[r]=n;  
                    if(n.equals(es)){  
                        return step[r];  
                    }  
                    set.add(n);  
                    r++;  
                }  
            }  
            if(index-2>=0){  
                n=swap(c,index,index-2);  
                if(!set.contains(n)){  
                    step[r]=step[l]+1;  
                    q[r]=n;  
                    if(n.equals(es)){  
                        return step[r];  
                    }  
                    set.add(n);  
                    r++;  
                }  
            }  
            if(index-3>=0){  
                n=swap(c,index,index-3);  
                if(!set.contains(n)){  
                    step[r]=step[l]+1;  
                    q[r]=n;  
                    if(n.equals(es)){  
                        return step[r];  
                    }  
                    set.add(n);  
                    r++;  
                }  
            }  
            l++;  
        }  
        return -1;  
    }  
}  
```

M:从bfs方法开始，首先为什么要用到``HashSet``呢？   

Z:HashSet的特点就是   不可重复的，仅仅存储对象   

