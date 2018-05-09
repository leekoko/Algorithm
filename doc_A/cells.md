# 生命游戏   

D：新鲜的模拟游戏，可能有点麻烦

```
标题：生命游戏

康威生命游戏是英国数学家约翰·何顿·康威在1970年发明的细胞自动机。  
这个游戏在一个无限大的2D网格上进行。

初始时，每个小方格中居住着一个活着或死了的细胞。
下一时刻每个细胞的状态都由它周围八个格子的细胞状态决定。

具体来说：

1. 当前细胞为存活状态时，当周围低于2个（不包含2个）存活细胞时， 该细胞变成死亡状态。（模拟生命数量稀少）
2. 当前细胞为存活状态时，当周围有2个或3个存活细胞时， 该细胞保持原样。
3. 当前细胞为存活状态时，当周围有3个以上的存活细胞时，该细胞变成死亡状态。（模拟生命数量过多）
4. 当前细胞为死亡状态时，当周围有3个存活细胞时，该细胞变成存活状态。 （模拟繁殖）

当前代所有细胞同时被以上规则处理后, 可以得到下一代细胞图。按规则继续处理这一代的细胞图，可以得到再下一代的细胞图，周而复始。

例如假设初始是:(X代表活细胞，.代表死细胞)
.....
.....
.XXX.
.....


下一代会变为:
.....
..X..
..X..
..X..
.....


康威生命游戏中会出现一些有趣的模式。例如稳定不变的模式：
....
.XX.
.XX.
....


还有会循环的模式：
......      ......       ......
.XX...      .XX...       .XX...
.XX...      .X....       .XX...
...XX.   -> ....X.  ->   ...XX.
...XX.      ...XX.       ...XX.
......      ......       ......




本题中我们要讨论的是一个非常特殊的模式，被称作"Gosper glider gun"：
......................................
.........................X............
.......................X.X............
.............XX......XX............XX.
............X...X....XX............XX.
.XX........X.....X...XX...............
.XX........X...X.XX....X.X............
...........X.....X.......X............
............X...X.....................
.............XX.......................
......................................


假设以上初始状态是第0代，请问第1000000000(十亿)代一共有多少活着的细胞？

注意：我们假定细胞机在无限的2D网格上推演，并非只有题目中画出的那点空间。
当然，对于遥远的位置，其初始状态一概为死细胞。

注意：需要提交的是一个整数，不要填写多余内容。
```

M：我不太理解它图形的变化规律，能让我先了解下代码吗？

Z：找到了一个java的  [链接](https://blog.csdn.net/gzj0078/article/details/79434673)   

```java
import java.math.BigInteger;  
import java.util.ArrayList;  
  
public class T2 {  
  
    static ArrayList<point> list = new ArrayList<point>();  
    static ArrayList<point> listcopy = new ArrayList<point>();  
    static String values[] = {   
            "......................................",   
            ".........................X............",  
            ".......................X.X............",   
            ".............XX......XX............XX.",  
            "............X...X....XX............XX.",   
            ".XX........X.....X...XX...............",  
            ".XX........X...X.XX....X.X............",   
            "...........X.....X.......X............",  
            "............X...X.....................",   
            ".............XX.......................",  
            "......................................", };  
    static ArrayList<Integer> sizelist = new ArrayList<Integer>();  
  
    public static void main(String[] Args) {  
        for (int i = 0; i < values.length; i++) {  
            for (int j = 0; j < values[i].length(); j++) {  
                if (values[i].charAt(j) == 'X')  
                    list.add(new point(i + 1, j + 1));  
            }  
        }  
        BigInteger time = new BigInteger("0");// 计数器  
  
        while (true) {  
            // print(list);  
            time = time.add(new BigInteger("1"));  
            // 模拟一轮的变化，并将新的活细胞位置存在listcopy中  
            for (int i = 0; i < list.size(); i++) {  
//              print(list);  
//              System.out.println();  
                int j = 0;  
                int x = list.get(i).x;  
                int y = list.get(i).y;  
  
                if (list.contains(new point(x - 1, y - 1))) {  
                    j++;  
                } else if (round(new point(x - 1, y - 1), list) == 3) {  
                    if (!listcopy.contains(new point(x - 1, y - 1)))  
                        listcopy.add(new point(x - 1, y - 1));  
                }  
  
                if (list.contains(new point(x, y - 1))) {  
                    j++;  
                } else if (round(new point(x, y - 1), list) == 3) {  
                    if (!listcopy.contains(new point(x, y - 1)))  
                        listcopy.add(new point(x, y - 1));  
                }  
  
                if (list.contains(new point(x + 1, y - 1))) {  
                    j++;  
                } else if (round(new point(x + 1, y - 1), list) == 3) {  
                    if (!listcopy.contains(new point(x + 1, y - 1)))  
                        listcopy.add(new point(x + 1, y - 1));  
                }  
  
                if (list.contains(new point(x - 1, y))) {  
                    j++;  
                } else if (round(new point(x - 1, y), list) == 3) {  
                    if (!listcopy.contains(new point(x - 1, y)))  
                        listcopy.add(new point(x - 1, y));  
                }  
  
                if (list.contains(new point(x + 1, y))) {  
                    j++;  
                } else if (round(new point(x + 1, y), list) == 3) {  
                    if (!listcopy.contains(new point(x + 1, y)))  
                        listcopy.add(new point(x + 1, y));  
                }  
  
                if (list.contains(new point(x - 1, y + 1))) {  
                    j++;  
                } else if (round(new point(x - 1, y + 1), list) == 3) {  
                    if (!listcopy.contains(new point(x - 1, y + 1)))  
                        listcopy.add(new point(x - 1, y + 1));  
                }  
  
                if (list.contains(new point(x, y + 1))) {  
                    j++;  
                } else if (round(new point(x, y + 1), list) == 3) {  
                    if (!listcopy.contains(new point(x, y + 1)))  
                        listcopy.add(new point(x, y + 1));  
                }  
  
                if (list.contains(new point(x + 1, y + 1))) {  
                    j++;  
                } else if (round(new point(x + 1, y + 1), list) == 3) {  
                    if (!listcopy.contains(new point(x + 1, y + 1)))  
                        listcopy.add(new point(x + 1, y + 1));  
                }  
  
                if (j == 2 || j == 3)  
                    listcopy.add(list.get(i));  
            }  
            sizelist.add(listcopy.size() - list.size());  
            //System.out.print(listcopy.size() - list.size() + " ");  
            list = listcopy;  
            listcopy = new ArrayList<point>();  
            if (back(sizelist)) {  
                BigInteger arrlenth = new BigInteger(sizelist.size() / 4 + "");  
                int sum = 0;  
                for (Integer inte : sizelist) {  
                    sum += inte;  
                }  
                sum /= 4;  
                BigInteger first = new BigInteger(sum + "");  
                BigInteger change = new BigInteger(sum + "");  
                BigInteger answer = new BigInteger("0");  
                int mut = new BigInteger("1000000000").remainder(arrlenth).intValue();  
                for (int i = 0; i < mut; i++) {  
                    answer = answer.add(new BigInteger("" + sizelist.get(i)));  
                }  
                answer = answer.add(first.add(change.multiply(new BigInteger("1000000000").divide(arrlenth))));  
                System.out.println(answer);  
                break;  
            }  
        }  
    }  
  
    // 返回点i周围存活点的个数  
    public static int round(point i, ArrayList<point> vals) {  
        int j = 0;  
        int x = i.x;  
        int y = i.y;  
        if (list.contains(new point(x - 1, y - 1))) {  
            j++;  
        }  
  
        if (list.contains(new point(x, y - 1))) {  
            j++;  
        }  
  
        if (list.contains(new point(x + 1, y - 1))) {  
            j++;  
        }  
  
        if (list.contains(new point(x - 1, y))) {  
            j++;  
        }  
  
        if (list.contains(new point(x + 1, y))) {  
            j++;  
        }  
  
        if (list.contains(new point(x - 1, y + 1))) {  
            j++;  
        }  
  
        if (list.contains(new point(x, y + 1))) {  
            j++;  
        }  
  
        if (list.contains(new point(x + 1, y + 1))) {  
            j++;  
        }  
        return j;  
    }  
  
    // 当List中数组为4个循环时返回真  
    public static boolean back(ArrayList<Integer> val) {  
        if (val.size() % 4 != 0)  
            return false;  
        else {  
            for (int i = 0; i < val.size() / 4; i++) {  
                if (val.get(i) != val.get(i + val.size() / 4) || val.get(i) != val.get(i + val.size() / 2)  
                        || val.get(i) != val.get(i + 3 * val.size() / 4))  
                    return false;  
            }  
            return true;  
        }  
    }  
  
    // 尝试输出，用于检查错误  
    public static void print(ArrayList<point> val) {  
        point[] vcc = new point[0];  
        vcc = val.toArray(vcc);  
        int maxx = vcc[0].x;  
        int minx = vcc[0].x;  
        int maxy = vcc[0].y;  
        int miny = vcc[0].y;  
        for (point point : vcc) {  
            if (point.x > maxx)  
                maxx = point.x;  
            else if (point.x < minx)  
                minx = point.x;  
            if (point.y > maxy)  
                maxy = point.y;  
            else if (point.y < miny)  
                miny = point.y;  
        }  
        for (int x = minx; x <= maxx; x++) {  
            for (int y = miny; y <= maxy; y++) {  
                if (val.contains(new point(x, y)))  
                    System.out.print("X");  
                else  
                    System.out.print(".");  
            }  
            System.out.println();  
        }  
    }  
}  
  
// 用于代表细胞  
class point {  
    int x;  
    int y;  
  
    public point(int x, int y) {  
        this.x = x;  
        this.y = y;  
    }  
  
    @Override  
    public boolean equals(Object obj) {  
        if (obj instanceof point)  
            if (((point) obj).x == this.x && ((point) obj).y == this.y)  
                return true;  
        return false;  
    }  
}  
```

M：这道题暂时先搁置，日后再做研究

loading