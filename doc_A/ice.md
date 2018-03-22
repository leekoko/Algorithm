# 闲聊蓝桥杯JAVA -冰雹数

D：今天就来一简单题，交交差。

```
冰雹数

任意给定一个正整数N，
如果是偶数，执行： N / 2
如果是奇数，执行： N * 3 + 1

生成的新的数字再执行同样的动作，循环往复。

通过观察发现，这个数字会一会儿上升到很高，
一会儿又降落下来。
就这样起起落落的，但最终必会落到“1”
这有点像小冰雹粒子在冰雹云中翻滚增长的样子。

比如N=9
9,28,14,7,22,11,34,17,52,26,13,40,20,10,5,16,8,4,2,1
可以看到，N=9的时候，这个“小冰雹”最高冲到了52这个高度。

输入格式：
一个正整数N（N<1000000）
输出格式：
一个正整数，表示不大于N的数字，经过冰雹数变换过程中，最高冲到了多少。

例如，输入：
10
程序应该输出：
52

再例如，输入：
100
程序应该输出：
9232

资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 1000ms
```

M:感觉就是按上面规则做，不就行了么？

```java
	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		int num = input.nextInt();
		System.out.println(maxNum(num));
	}

	private static int maxNum(int num) {
		int max = 0;
		for (int i = 0;; i++) {
			if(num == 1){
				return max;
			}else{
				if(num % 2 == 0){
					num = num / 2;
				}else{
					num = num * 3 + 1;
					if(num > max){
						max = num;
					}
				}
			}
		}
	}
```

不过，答案为什么对不上？？晕死！

Z:仔细省题目:  一个正整数，表示**不大于N的数字**，经过冰雹数...  也就是说，他输入的是一个范围，从 0~N 

M:我重新修改了下

```java
	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		int num = input.nextInt();
		int max = 0;
		int temp = 0 ;
		for (int i = 1; i <= num; i++) {
			if((temp = maxNum(i)) > max){
				max = temp;
			}
		}
		System.out.println(max);
	}

	private static int maxNum(int num) {
		int max = 0;
		for (int i = 0;; i++) {
			if(num == 1){
				return max;
			}else{
				if(num % 2 == 0){
					num = num / 2;
				}else{
					num = num * 3 + 1;
					if(num > max){
						max = num;
					}
				}
			}
		}
	}
```

然而中间还有很多坑： 

1. 不大于0的整数，要注意不能把0算进去，否则就会死循环。（因为0属于偶数，0/2 = 0）
2. for循环的时候，注意把变化的参数i传进去，之前差点就遗漏了。

所以总结一下，遇到这种看起来表面很简单的题，做出来却不对。首先检查题意字眼，接着Debug看看是否是遗漏了。