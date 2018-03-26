# 闲聊蓝桥杯JAVA - 打印图形

M:有一点繁琐的题目，打印十字图。

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

Z:









