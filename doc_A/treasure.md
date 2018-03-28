# 地宫寻宝   

D:今晚完成一道比较麻烦的题目，地宫寻宝

```
标题：地宫取宝
    X 国王有一个地宫宝库。是 n x m 个格子的矩阵。每个格子放一件宝贝。每个宝贝贴着价值标签。
    地宫的入口在左上角，出口在右下角。
    小明被带到地宫的入口，国王要求他只能向右或向下行走。
    走过某个格子时，如果那个格子中的宝贝价值比小明手中任意宝贝价值都大，小明就可以拿起它（当然，也可以不拿）。
    当小明走到出口时，如果他手中的宝贝恰好是k件，则这些宝贝就可以送给小明。
    请你帮小明算一算，在给定的局面下，他有多少种不同的行动方案能获得这k件宝贝。

【数据格式】
    输入一行3个整数，用空格分开：n m k (1<=n,m<=50, 1<=k<=12)
    接下来有 n 行数据，每行有 m 个整数 Ci (0<=Ci<=12)代表这个格子上的宝物的价值
    要求输出一个整数，表示正好取k个宝贝的行动方案数。该数字可能很大，输出它对 1000000007 取模的结果。

例如，输入：
2 2 2
1 2
2 1
程序应该输出：
2

再例如，输入：
2 3 2
1 2 3
2 1 5
程序应该输出：
14


资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 2000ms
```

Z:看一下网友是怎么完成这一道题的？  [链接](https://blog.csdn.net/qq_34789775/article/details/72910025)  

```java
import java.util.Scanner;

public class Main9 {
    private static int count = 0;
     //start实际件数  end设定的件数，max手中的最大值 ，s1矩阵,  总的x1, 总的 y1
    public void remove(int start, int end, int max, int s1[][], int x, int y, int x1, int y1) {
        if (start > end)
            return;
        if (x == x1 - 1 && y == y1 - 1) {
            if (start == end) {
                count++;
            }
                        else {
                if (start == end - 1 && s1[x][y] > max)
                    count++;
            }
        }
        if (x + 1 < x1) {
            if (s1[x][y] > max) {
                remove(start + 1, end, s1[x][y], s1, x + 1, y, x1, y1);
                remove(start, end, max, s1, x + 1, y, x1, y1);
            }
            else {
                remove(start, end, max, s1, x + 1, y, x1, y1);
            }
        }
        if (y + 1 < y1) {
            if (s1[x][y] > max) {
                remove(start + 1, end, s1[x][y], s1, x, y + 1, x1, y1);
                remove(start, end, max, s1, x, y + 1, x1, y1);
            } 
                        else {
                remove(start, end, max, s1, x, y + 1, x1, y1);
            }
        }
    }

    public static void main(String args[]) {
        int a, b, c;
        Scanner input = new Scanner(System.in);
        a = input.nextInt();
        b = input.nextInt();
        c = input.nextInt();
        int[][] s = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                s[i][j] = input.nextInt();
            }
        }
        Main9 A = new Main9();
        A.remove(0, c, -1, s, 0, 0, a, b);
        System.out.println(count % 1000000007);
    }
}
```

可能因为强迫症，我把他的代码整理修改了一下：

```java
public class Main {
    static int count = 0;
    static int height = 0;
    static int width = 0;
    static int wentGet = 0;    //预想拿到
    static int[][] arr = null;  //地图数组
 
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        height = input.nextInt();
        width = input.nextInt();
        wentGet = input.nextInt();
        arr = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                arr[i][j] = input.nextInt();
            }
        }
        move(0, -1, 0, 0);
        System.out.println(count % 1000000007);
    }
    /**
     * 行走方法 
     * @param finGet  最终获得数量
     * @param max   手中最大价值
     * @param x   当前位置[x][]
     * @param y   当前位置[][y]
     */
    public static void move(int finGet, int max, int x, int y) {
        if (finGet > wentGet){
        	return;
        }
        if (x == height - 1 && y == width - 1){
            if (finGet == wentGet) {    //刚好相等
                count++;
            }else{
	            if (finGet == wentGet - 1 && arr[x][y] > max){   //处于最后一格
	            	count++;
	            }
	        }
        }
        if (x + 1 < height) {
            if (arr[x][y] > max) {
            	move(finGet + 1, arr[x][y], x + 1, y);
            }
            move(finGet, max, x + 1, y);
        }
        if (y + 1 < width) {
            if (arr[x][y] > max) {
            	move(finGet + 1,arr[x][y], x, y + 1);
            }
            move(finGet,max, x, y + 1);
        }
    }
}
```

M:为什么要判断会不会超出边界，去掉行不行？

```java
        if (x + 1 < height) {
            ...
```

Z:不行，因为递归方法在里面不止一个，并且其参数不同(一个向下的，一个向右的)。而当方法进行递归之后，如果没经过if的筛选，它可能会在不该调用该方法的情况下不断调用该方法(超出边界后仍然不断向下)，所以使用递归前要先做范围筛选。

M:那为什么还要再判断呢？``if (arr[x][y] > max) {...``  

Z:因为就算是向下，它也会分两种情况：拿 / 不拿。但是呢，拿是有条件的，就是必须格子的价值大于手上最大的价值，所以才有这个筛选。而不拿和不想拿则是同一种情况。

M:那考虑到``move(finGet, max, x + 1, y);``这条算式的呢？

Z:其实也就将所有会变的数据作为参数而已，例如拿到的数量，最大的加个，位置的x，y值。

M:所有 可能的情况 都模拟出来了，但是怎么判定是否符合结果呢？

Z:判断符合情况就count++

```java
        if (x == height - 1 && y == width - 1){
            if (finGet == wentGet) {    //刚好相等
                count++;
            }else{
	            if (finGet == wentGet - 1 && arr[x][y] > max){   //处于最后一格
	            	count++;
	            }
	        }
        }
```

M:为什么要这么复杂呢？反正所有的情况都会走，上方对超出的情况进行排除，直接判断相等就count++不行么?

```java
        if(x >= height && y >= width){
        	return;
        }
	    if (finGet == wentGet) {    //刚好相等
            count++;
        }
```

但是为什么结果却比原来的代码数量还要少，例如第二个测试数据得到的是8。

Z:遇到这种情况，只好对数据进行调试比较了：

```
数据
```















M:所以说，重点也就是用max来表示最大值，并且使用不同的递归来模拟各种可能的情况。

  











