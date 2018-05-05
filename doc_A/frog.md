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

M:我刚刚解读了一下代码，主要就是这一段的逻辑很绕，只要理解了就可以解决这道题了。

```java
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
```

这段代码大概意思就是：

1. 我现在用一个容器A，将当前排列情况存进去。
2. 我将当前排列的所有可能变化的情况列出来，存进容器A里。
3. 然后对容器A的内容提取出未执行步骤2的第一个元素，执行步骤2。

这就相当于一个死循环，而容器的内容也会不断暴增。

停止这段循环的条件就是，下一步刚好为目标结果。

那这道题的难点就是它步数的确定，该网友使用了数组step来存储当前步骤对应的步数。

我觉得这种做法是没有什么问题的，但是不够清晰，容易出错。在比赛过程中也很难短时间内想出这么精细的做法。所以改造成通用的递归方式来实现...

Z:且慢，虽然你想用递归的方式减少了步数统计数组。但是从结构上改变了这道题的解法。

首先，原先题目遍历的情况是 方法一：第一步所有的情况，第二步所有的情况，第三步所有的情况...  到情况一符合，马上就停止步数统计。一种广度的思想。

方法二：但是如果采用递归，那就是第一步的一种情况，第二步的一种情况，第三步的一种情况，回到上一步的第二种情况。这是一种深度的思想。

所以在要求获取最短步数的情况下，方法二根本就不知道什么时候的步数最少，会不会是下一种情况步数少呢？于是它就得把所有的情况走一遍才能下结论。大大耗费了资源和时间。

所以，要想优化这道题目，我建议你先了解一下广度搜索bfs和深度搜索dfs的使用场景。

D：深度搜索，广度搜索详情查看另外一篇文章。






