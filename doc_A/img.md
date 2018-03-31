# 闲聊蓝桥杯JAVA - 打印图形

D:有一点繁琐的题目，打印十字图。

```

标题：打印十字图

    小明为某机构设计了一个十字型的徽标（并非红十字会啊），如下所示(可参见p1.jpg)

                     $$$$$$$$$$$$$
                     $           $
                   $$$ $$$$$$$$$ $$$
                   $   $       $   $
                   $ $$$ $$$$$ $$$ $
                   $ $   $   $   $ $
                   $ $ $$$ $ $$$ $ $
                   $ $ $   $   $ $ $
                   $ $ $ $$$$$ $ $ $
                   $ $ $   $   $ $ $
                   $ $ $$$ $ $$$ $ $
                   $ $   $   $   $ $
                   $ $$$ $$$$$ $$$ $
                   $   $       $   $
                   $$$ $$$$$$$$$ $$$
                     $           $
                     $$$$$$$$$$$$$


    对方同时也需要在电脑dos窗口中以字符的形式输出该标志，并能任意控制层数。
    
    为了能准确比对空白的数量，程序要求对行中的空白以句点（.）代替。

输入格式：
一个正整数 n (n<30) 表示要求打印图形的层数

输出：
对应包围层数的该标志。

例如：
用户输入：
1
程序应该输出：
..$$$$$..
..$...$..
$$$.$.$$$
$...$...$
$.$$$$$.$
$...$...$
$$$.$.$$$
..$...$..
..$$$$$..

再例如：
用户输入：
3
程序应该输出：
..$$$$$$$$$$$$$..
..$...........$..
$$$.$$$$$$$$$.$$$
$...$.......$...$
$.$$$.$$$$$.$$$.$
$.$...$...$...$.$
$.$.$$$.$.$$$.$.$
$.$.$...$...$.$.$
$.$.$.$$$$$.$.$.$
$.$.$...$...$.$.$
$.$.$$$.$.$$$.$.$
$.$...$...$...$.$
$.$$$.$$$$$.$$$.$
$...$.......$...$
$$$.$$$$$$$$$.$$$
..$...........$..
..$$$$$$$$$$$$$..

请仔细观察样例，尤其要注意句点的数量和输出位置。


资源约定：
峰值内存消耗（含虚拟机） < 64M
CPU消耗  < 1000ms
```
Z:这题我做过，以下可供参考。

```java
public class Main {
	static char[][] arr;
	static int bian;
	static int mid;
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int num=input.nextInt();
        bian=num*4+5;
        mid=bian/2;
        arr=new char[bian][bian];

        init();
        add(num);
        show();

    }

    private static void add(int num) {
        int x=mid-2;
        int y=mid-2;
        int index=1;
        for (int i = 0; i < num; i++) {
            arr[x][y]='$';
            for (int j = 0; j < 2; j++) {
                y--;
                arr[x][y]='$';
            }
            for (int j = 0; j < index*4; j++) {
                x++;
                arr[x][y]='$';
            }
            for (int j = 0; j < 2; j++) {
                y++;
                arr[x][y]='$';
            }
            for (int j = 0; j < 2; j++) {
                x++;
                arr[x][y]='$';
            }
            for (int j = 0; j < index*4; j++) {
                y++;
                arr[x][y]='$';
            }
            for (int j = 0; j < 2; j++) {
                x--;
                arr[x][y]='$';
            }
            for (int j = 0; j < 2; j++) {
                y++;
                arr[x][y]='$';
            }
            for (int j = 0; j < index*4; j++) {
                x--;
                arr[x][y]='$';
            }
            for (int j = 0; j < 2; j++) {
                y--;
                arr[x][y]='$';
            }
            for (int j = 0; j < 2; j++) {
                x--;
                arr[x][y]='$';
            }
            for (int j = 0; j < index*4; j++) {
                y--;
                arr[x][y]='$';
            }
            for (int j = 0; j < 2; j++) {
                x++;
                arr[x][y]='$';
            }
            index++;
            x=x-2;
            y=y-2;
        }
    /*	..$$$$$..
        ..$...$..
        $$$.$.$$$
        $...$...$
        $.$$$$$.$
        $...$...$
        $$$.$.$$$
        ..$...$..
        ..$$$$$..*/

    }

    public static void show() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void init() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j]='.';
            }
        }
        for (int i = 0; i < 5; i++) {
            arr[mid-2+i][mid]='$';
            arr[mid][mid-2+i]='$';
        }
    }

}
```

M:首先执行的init()方法是干嘛用的？

Z:就是根据圈数大小画出背景，和固定的图案内容的位置:

```
.............
.............
.............
.............
......$......
......$......
....$$$$$....
......$......
......$......
.............
.............
.............
.............
```

M:那绘图是怎么实现的呢？

Z:绘出圈子的内容:

```java
    private static void add(int num) {
        int x=mid-2;
        int y=mid-2;
        int index=1;
        for (int i = 0; i < num; i++) {
            arr[x][y]='$';
            for (int j = 0; j < 2; j++) {
                y--;
                arr[x][y]='$';
            }
            for (int j = 0; j < index*4; j++) {
                x++;
                arr[x][y]='$';
            }
...
            for (int j = 0; j < 2; j++) {
                x++;
                arr[x][y]='$';
            }
            index++;
            x=x-2;
            y=y-2;
        }
```

实现的方法很简单，就是确定一个点，控制点的轨迹变化，将其绘成图像。

这的x,y是用来控制位置的，而index是边数的比值。

M:这个index的比值关系是怎么得到的呢？

Z:通过观察获得，边数是n*4的倍数增加。

M:总结一下，这道题的重点就是控制一个点来绘边，而绘边的大小通过规律来获得。

D:这一道图像题目简单一点

```
打印大X

小明希望用星号拼凑，打印出一个大X，他要求能够控制笔画的宽度和整个字的高度。
为了便于比对空格，所有的空白位置都以句点符来代替。

要求输入两个整数m n，表示笔的宽度，X的高度。用空格分开(0<m<n, 3<n<1000, 保证n是奇数)
要求输出一个大X

例如，用户输入：
3 9
程序应该输出：
***.....***
.***...***.
..***.***..
...*****...
....***....
...*****...
..***.***..
.***...***.
***.....***

（如有对齐问题，参看【图1.jpg】）

再例如，用户输入：
4 21
程序应该输出
****................****
.****..............****.
..****............****..
...****..........****...
....****........****....
.....****......****.....
......****....****......
.......****..****.......
........********........
.........******.........
..........****..........
.........******.........
........********........
.......****..****.......
......****....****......
.....****......****.....
....****........****....
...****..........****...
..****............****..
.****..............****.
****................****

资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 1000ms
```

Z:这道题我之前完成过

```java
public static void main(String[] args) {
/*	题目分析：
	1.先初始化图形背景
	2.确定一个起始点，利用高的变化打印\
	3.同上打印/，注意起始点-1*/
	Scanner input=new Scanner(System.in);
	int kuan=input.nextInt();
	int height=input.nextInt();
	int width=height-1+kuan;
	
	char[][] arr=new char[height][width];
	for (int i = 0; i < arr.length; i++) {
		for (int j = 0; j < arr[i].length; j++) {
			arr[i][j]='.';
		}
	}
	
	for (int i = 0; i < arr.length; i++) {
		for (int j = 0; j < kuan; j++) {
			arr[i][j+i]='*';
		}
		for (int j = 0; j < kuan; j++) {
			arr[i][width-kuan-i+j]='*';
		}
	}
	//打印图案
	for (int i = 0; i < arr.length; i++) {
		for (int j = 0; j < arr[i].length; j++) {
			System.out.print(arr[i][j]);
		}
		System.out.println();
	}

}
```

M:宽度是怎么算出来的呢？``int width=height-1+kuan;``

Z:因为字的宽度确定，高度确定，就可以得出图形的总宽度。通过比较图形的变化情况可得出该width。

M:这里右边绘 / 这条线是怎么确定的呢？  ``arr[i][width-kuan-i+j]='*';``  

Z:也是通过观察比较得到，不同高度每一个起点都不同，其规律跟高度、宽度有关系。

M:总结就是要观察规律，总宽 跟 字宽，高度 的关系。起点跟 字宽，高度 的关系。