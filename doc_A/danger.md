# 危险系数

D：可能有点困难的题目

```
标题：危险系数
    抗日战争时期，冀中平原的地道战曾发挥重要作用。
    地道的多个站点间有通道连接，形成了庞大的网络。但也有隐患，当敌人发现了某个站点后，其它站点间可能因此会失去联系。
    我们来定义一个危险系数DF(x,y)：
    对于两个站点x和y (x != y), 如果能找到一个站点z，当z被敌人破坏后，x和y不连通，那么我们称z为关于x,y的关键点。相应的，对于任意一对站点x和y，危险系数DF(x,y)就表示为这两点之间的关键点个数。
    本题的任务是：已知网络结构，求两站点之间的危险系数。
    输入数据第一行包含2个整数n(2 <= n <= 1000), m(0 <= m <= 2000),分别代表站点数，通道数；
    接下来m行，每行两个整数 u,v (1 <= u, v <= n; u != v)代表一条通道；
    最后1行，两个数u,v，代表询问两点之间的危险系数DF(u, v)。

    输出：一个整数，如果询问的两点不连通则输出-1.

例如：
用户输入：
7 6
1 3
2 3
3 4
3 5
4 5
5 6
1 6
则程序应该输出：
2

资源约定：
峰值内存消耗（含虚拟机） < 64M
CPU消耗  < 2000ms

请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。

所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
注意：不要使用package语句。不要使用jdk1.6及以上版本的特性。
注意：主类的名字必须是：Main，否则按无效代码处理。
```

Z：简单说就是通过站点对，判断两个点之间有多少个唯一结点。

M：没有什么思路，怎么表示两点之间的连通路线？

Z：看一下网友的实现方式   [链接](http://www.cnblogs.com/liuzhen1995/p/6825404.html)    

```java
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int n, m;
    public static int count;
    public static int[] DFN;
    public static int[] Low;
    public static int[] parent;
    public static ArrayList<Integer>[] list;
    public static ArrayList<Integer> point;
    
    @SuppressWarnings("unchecked")
    public void init() {
        count = 0;
        DFN = new int[n + 1];
        Low = new int[n + 1];
        parent = new int[n + 1];
        list = new ArrayList[n + 1];
        point = new ArrayList<Integer>();
        for(int i = 1;i <= n;i++)
            list[i] = new ArrayList<Integer>();
    }
    
    public void TarJan(int start, int father) {
        DFN[start] = ++count;
        Low[start] = DFN[start];
        parent[start] = father;
        int childern = 0;
        for(int i = 0;i < list[start].size();i++) {
            int j = list[start].get(i);
            if(DFN[j] == 0) {
                childern++;
                TarJan(j, start);
                Low[start] = Math.min(Low[start], Low[j]);
                if(parent[start] == -1 && childern > 1) {
                    if(!point.contains(start))
                        point.add(start);
                }
                if(parent[start] != -1 && Low[j] >= DFN[start]) {
                    if(!point.contains(start))
                        point.add(start);
                }
                
            } else if(j != parent[start]) {
                Low[start] = Math.min(Low[start], DFN[j]);
            }
        }
    }
    
    public void dfs(int a, boolean[] visited) {
        visited[a] = true;
        for(int i = 0;i < list[a].size();i++) {
            int j = list[a].get(i);
            if(visited[j] == false)
                dfs(j, visited);
        }
    }
    
    public void getResult(int a, int b) {
        TarJan(1, -1);
        int result = 0;
        for(int i = 0;i < point.size();i++) {
            if(point.get(i) == a || point.get(i) == b)
                continue;
            else {
                boolean[] visited = new boolean[n + 1];
                visited[point.get(i)] = true;
                dfs(a, visited);
                if(visited[b] == false) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
    
    public static void main(String[] args) {
        Main test = new Main();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        test.init();
        for(int i = 1;i <= m;i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            list[u].add(v);
            list[v].add(u);
        }
        int a = in.nextInt();
        int b = in.nextInt();
        test.getResult(a, b);
    }
    
}
```

loading



