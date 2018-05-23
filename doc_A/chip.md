# 生物芯片

D：一道蛮有意思的题目：

```
标题：生物芯片
    X博士正在研究一种生物芯片，其逻辑密集度、容量都远远高于普通的半导体芯片。
    博士在芯片中设计了 n 个微型光源，每个光源操作一次就会改变其状态，即：点亮转为关闭，或关闭转为点亮。
    这些光源的编号从 1 到 n，开始的时候所有光源都是关闭的。
    博士计划在芯片上执行如下动作：
    所有编号为2的倍数的光源操作一次，也就是把 2 4 6 8 ... 等序号光源打开
    所有编号为3的倍数的光源操作一次, 也就是对 3 6 9 ... 等序号光源操作，注意此时6号光源又关闭了。
    所有编号为4的倍数的光源操作一次。
    .....
    直到编号为 n 的倍数的光源操作一次。
    X博士想知道：经过这些操作后，某个区间中的哪些光源是点亮的。
    
【输入格式】
3个用空格分开的整数：N L R  (L<R<N<10^15)  N表示光源数，L表示区间的左边界，R表示区间的右边界。

【输出格式】
输出1个整数，表示经过所有操作后，[L,R] 区间中有多少个光源是点亮的。

例如：
输入：
5 2 3
程序应该输出：
2

再例如：
输入：
10 3 6
程序应该输出：
3

资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 1000ms

请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。

所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
注意：不要使用package语句。不要使用jdk1.7及以上版本的特性。
注意：主类的名字必须是：Main，否则按无效代码处理。
```
M：解法如下，很简单

```java
import java.util.Scanner;

public class Test4 {
	static boolean[] openLight = null;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		openLight = new boolean[num];
		int start = input.nextInt();
		int end = input.nextInt();
		for (int a = 2; a <= num; a++) {
			run(a);
		}
		int result = 0;
		for (int i = start-1; i <= end-1; i++) {
			if(openLight[i] == true){
				result++;
			}
		}
		System.out.println(result);
	}
	
	private static void run(int mulNum) {
		for (int i = 0; i < openLight.length; i++) {
			if((i+1) % mulNum == 0){
				//操作灯泡
				if(openLight[i] == false){
					openLight[i] = true;
				}else{
					openLight[i] = false;
				}
			}
		}
	}
}
```
M：等等，为什么我这个测试案例不通过

``99775626426233 78471826423591 92775626426233``   

Exception in thread "main" java.util.InputMismatchException: For input string: "99775626426233"

Z：做题的时候，千万要考虑大数，所以用int做获取值要多考虑一步。这将是别人会落的坑，也是你的机会所在。

M：这就很麻烦了，大数怎么进行循环呢？

Z：看一下网友的解法吧 [链接](https://blog.csdn.net/newmemory/article/details/51474377)  

```java
import java.util.Scanner;
public class Main {
    public static long N,L,R;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        N = in.nextLong();
        L = in.nextLong();
        R = in.nextLong();
        long sum = R - L + 1;//[L,R]区间共有多少个数
        long a = (long)(Math.sqrt(L-1));
        long b = (long)(Math.sqrt(R));
        System.out.println(sum-(b-a));
    }

}
```

这位朋友是以推算规律式来求解，过程有点复杂，表示驾驭不了。

loading：暂时挂起











