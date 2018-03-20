# 闲聊蓝桥杯JAVA - 搭积木  

D:搭积木

```
搭积木

小明最近喜欢搭数字积木，
一共有10块积木，每个积木上有一个数字，0~9。

搭积木规则：
每个积木放到其它两个积木的上面，并且一定比下面的两个积木数字小。
最后搭成4层的金字塔形，必须用完所有的积木。

下面是两种合格的搭法：

   0
  1 2
 3 4 5
6 7 8 9

   0
  3 1
 7 5 2
9 8 6 4    

请你计算这样的搭法一共有多少种？

请填表示总数目的数字。
注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。
```

M:这是考什么的题目？

Z:这是网上找到的参考资料    [链接](http://blog.csdn.net/aketoshknight/article/details/54177162)  

```c++
#define Totol 45  
void putNum(int a[],int n,int key);//核心函数  
int getSum(int a[],int n);//获取当前数字的和  
int judgeTower(int a[],int key);//判断塔结构是否合法  
int judgeNum(int a[],int key);//判断数字是否合法  
int count=0;//计数  
int main()  
{  
    int a[10],n=10,tkey=0;//tkey即初始赋值的数组下标,a数组用于存放数字塔(0~3为最底层，4~6为第二层，以此类推),n为数组长度  
    putNum(a,n,tkey);  
    printf("%d",count);  
    return 0;  
}  
void putNum(int a[],int n,int key)  
{  
    int i;  
    for(i=0;i<10;i++)  
    {  
        a[key]=i;//给数组中的一个元素赋值  
        if(judgeTower(a,key))//判断此时的数字塔是否合法  
        {  
            if(key==n-1)//当数字塔的最后一个元素也被确定时（一个数字塔完成时）。。。  
            {  
                count++;  
                return;  
            }  
            putNum(a,n,key+1);//递归  
        }  
    }  
}  
int getSum(int a[],int n)  
{  
    int i,sum=0;  
    for(i=0;i<n;i++)  
        sum+=a[i];  
    return sum;  
}  
int judgeTower(int a[],int key)  
{  
    if(!judgeNum(a,key))//如果数字不合法，就直接返回假  
        return 0;  
    int i=(key<4)+(key<7)+(key<9)+(key<10);//i作为判断条件，当所有情况满足i的值将是4,每少满足一个情况，i的值就减小1。  
    if(i==0)//如果i的值是零，说明程序出错  
    {  
        printf("wrong key!");  
        return 0;  
    }  
    else if(i==4)//当i的值时4，即正在为数字塔的底层赋值，此时不需要判断  
        return 1;  
    else  
        if(a[key]<a[key-i]&&a[key]<a[key-i-1])//当i的值在(0,4)，通过题目要求得到如此的判断条件  
            return 1;  
        else  
            return 0;  
    printf("jugeTower—————>error");//如果程序能运行到这一步，说明哪里出了问题.....  
    return 0;  
}  
int judgeNum(int a[],int key)  
{  
    int i,j,t,b[10];//定义临时变量和数组  
    for(i=0;i<key+1;i++)//为临时数组赋值  
        b[i]=a[i];  
    for(i=1;i<key+1;i++)//冒泡排序法给临时数组排序(直接给传入的a数组排序会导致程序出错)  
        for(j=0;j<key+1-i;j++)  
            if(b[j]>b[j+1])  
                t=b[j],b[j]=b[j+1],b[j+1]=t;  
//对排序后的数组进行比对，如果有两个数字相同，则本次传入的数字不合法。(数字塔中每个数字只能出现一次)  
    for(i=0;i<key;i++)  
        if(b[i]==b[i+1])  
            return 0;  
    return 1;  
} 
```

M:但我仔细研究这种做法，也尝试简化它的步骤，但还是有点绕，不好理解。

Z:又找了一篇    [链接](http://blog.csdn.net/sangjinchao/article/details/68953989)   

```c++
static int[] v = new int[10];  
static int[][] s = new int[4][4];  
static int sum = 0;  
public static void main(String[] args) {  
    s[0][0] = 0;  
    s(1);  
    System.out.println(sum);  
}  
public static void s(int code){  
    if(code==10) {  
        sum++;  
        return;  
    }  
    for (int i = 1; i < 10; i++) {  
        if(v[i]!=0) continue;  
        else {  
            int c=0,t=0;  
            switch (code) {  
            case 1:t = 1;c=0;break;  
            case 2:t = 1;c=1;break;  
            case 3:t = 2;c=0;break;  
            case 4:t = 2;c=1;break;  
            case 5:t = 2;c=2;break;  
            case 6:t = 3;c=0;break;  
            case 7:t = 3;c=1;break;  
            case 8:t = 3;c=2;break;  
            case 9:t = 3;c=3;break;  
            }  
            s[t][c] = i;  
            if(s[t][c]<s[t-1][c]){  
                continue;  
            }  
            if(c-1>=0){  
                if(s[t][c]<s[t-1][c-1]){  
                    continue;  
                }  
            }  
            v[i] = 1;  
            s(code+1);  
            v[i] = 0;  
        }  
    }  
}  
```

M:这个看起来简洁了不少，而且刚好是JAVA写的。但是...感觉这思路也是够崎岖的，只好再次放弃。

Z:再找了一家  [链接](http://blog.csdn.net/obession/article/details/54898274)  

```java
public class Main{
    static int count = 0;  
    public static void main(String[] args) {  
        int a[] = new int[10];  
        boolean visit[] = new boolean[10];  
        dfs(a,visit,0);  
        System.out.println(count);  
    }  
    private static void dfs(int[] a, boolean[] visit, int num) {  
        if (num==10) {  
            if (judge(a)) {  
                count++;  
            }  
            return;  
        }  
        for (a[num] = 0; a[num]<10; a[num]++) {  
            if (visit[a[num]]==false) {  
                visit[a[num]]=true;  
                num = num + 1;  
                dfs(a, visit, num);  
                num = num - 1;//注意回溯  
                visit[a[num]]=false;//注意回溯  
            }else {  
                continue;  
            }  
        }  
    }  
    private static boolean judge(int[] a) {  
        if (a[0]<a[1]&&a[0]<a[2]&&a[1]<a[3]&&a[1]<a[4]  
                &&a[2]<a[4]&&a[2]<a[5]&&a[3]<a[6]&&a[3]<a[7]  
                        &&a[4]<a[7]&&a[4]<a[8]&&a[5]<a[8]&&a[5]<a[9]) {  
            return true;  
        }else {  
            return false;  
        }  
          
    }  
}
```

M:这家解法就感觉靠谱多了，应该就是这种解法。得到的结果是**768**。

M:``for (a[num] = 0; a[num]<10; a[num]++) {  ``在这里是什么意思呢？

Z:``for (a[num] = 0; a[num]<10; a[num]++) {  ``  就是这道题的难点了，对比

``for(int i=1 ;i<10 ;i++){``,它这里用的不是一个变量，而是一个数组的元素。这个数组是指哪个元素，则由num变量来决定。

也就是说，a[]数组的长度为10，那么``for (a[num] = 0; a[num]<10; a[num]++) {  `` 其实也可以拆解成10个循环:

```java
for(int a=1 ; a<10 ; a++){}
for(int b=1 ; b<10 ; b++){}
for(int c=1 ; c<10 ; c++){}
for(int d=1 ; d<10 ; d++){}
for(int e=1 ; e<10 ; e++){}
for(int f=1 ; f<10 ; f++){}
for(int g=1 ; g<10 ; g++){}
for(int h=1 ; h<10 ; h++){}
for(int i=1 ; i<10 ; i++){}
for(int j=1 ; j<10 ; j++){}
```

其中  a代表a[1]，b代表a[2] , c代表a[3] , d代表a[4] , e代表a[5] ...

我们暂时给它起个外号 “数组的十倍循环”   

M:我觉得这又可以分割成一部分，应该怎么理解呢？

```java
            if (visit[a[num]]==false) {  
                visit[a[num]]=true;  
```

Z:这个visit[]数组其实很好理解，我们可以想象成visit[]数组其实就是数字0-9的家，例如数字0，就住在visit[0]这个房子里，数字1-->visit[1]房子，而这个家只传达一种信息，就是通过boolean(灯有没有亮)来判断这个数字是否在家。

所以这里的``if (visit[2]==false)``其实就是说，如果数字2在家（灯没关为false），那就把它的灯关了``visit[a[num]]=true;``。

主要就是用来防止数字被重复使用 , 外号“关灯筛选”。

M:那这一块应该就是核心了，怎么理解呢？

```java
                num = num + 1;  
                dfs(a, visit, num);  
```

Z:这就要开始举栗子了，num从0变成了1，并且dfs调用了自身的方法，下面是前面几次dfs参数的变化：

```
a[]={0, 0, 0, 0, 0, 0, 0, 0, 0, 0}   
visit={true, false, false, false, false, false, false, false, false, false}
num=1

a[]={0, 1, 0, 0, 0, 0, 0, 0, 0, 0}   
visit={true, true, false, false, false, false, false, false, false, false}
num=2

a[]={0, 1, 2, 0, 0, 0, 0, 0, 0, 0}   
visit={true, true, true, false, false, false, false, false, false, false}
num=3

a[]={0, 1, 2, 3, 0, 0, 0, 0, 0, 0}   
visit={true, true, true, true, false, false, false, false, false, false}
num=4
...
```

也就是说，利用 “数组的十倍循环” + “关灯筛选” ，我们就能实现所谓的数字不重复的全排列。

而num其实就是指定操作数组哪个位置上的元素，当指向最后一个元素的时候，就说明   该情况的排列已准备完毕   请系统进行判断，是否符合。

```java
        if (num==10) {  
            if (judge(a)) {  
                count++;  
            }  
            return;  
        }  
```

M:那回溯的步骤又是什么鬼呢？

```java
                num = num - 1;//注意回溯  
                visit[a[num]]=false;//注意回溯  
```

Z:这个用语言来说确实不好描述，但我们大概能够感觉到

例如数组 0，1，2，3，4，5，6，7，8，9

当我们要对它的顺序进行变化的时候，最简单情况莫过于交换两个数，比如8，9

那么我们就要将8，9拿掉，在手上做个颠倒，再放回数组中

 0，1，2，3，4，5，6，7，9，8

而要交换三个数，拿出来的将会是7，8，9三个，以此类推。

所以回溯做的就是这种将数组元素拿出来的操作，而利用前面说的 “数组的十倍循环” + “关灯筛选” ，就可以将数字进行顺序调换，重新放入到数组当中。

M:总结一下，这道题其实就是先用一个10位数组来存放不同排序的数字，通过判断对排序类型进行计数。而难点在于怎么进行全排列，网友的做法是使用“数组的十倍循环” + “关灯筛选” + “递归回溯” 的方式，最后在num脚标到达最后一个元素的地方进行拦截判断。