# 平方末尾  

D：今天先来一道简单的题目

```
平方末尾

能够表示为某个整数的平方的数字称为“平方数”
比如，25,64
虽然无法立即说出某个数是平方数，但经常可以断定某个数不是平方数。
因为平方数的末位只可能是：[0, 1, 4, 5, 6, 9] 这6个数字中的某个。
所以，4325435332必然不是平方数。

如果给你一个2位或2位以上的数字，你能根据末位的两位来断定它不是平方数吗？

请计算一下，一个2位以上的平方数的最后两位有多少种可能性？

注意：需要提交的是一个整数，表示2位以上的平方数最后两位的不同情况数。
不要填写任何多余内容（比如，说明解释文字等）
```
M：我想到的做法就是循环大量的数，验证之后使用数组进行标记，最后统计被标记的个数。标记数组就是用key代表标记的内容，用value为 0未标记 ，1已标记 代表标记结果。

```java
public class Test2{
	public static void main(String[] args) {
		int[] arr = new int[100];
		for (int i = 10; i < 10000000; i++) {
			if((int)(Math.sqrt(i))*(int)(Math.sqrt(i)) == i){
				arr[i%100] = 1;   //标记末尾
			}
		}
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == 1){
				count++;  //统计符合情况
			}
		}
		System.out.println(count);
	}
}
```

不知包不包括0为十位数的情况，我获得的答案是22

Z：为了优化自己的算法，在网上找了另一种解法[链接](https://blog.csdn.net/sword_anyone/article/details/71773797) ,答案也是 22 ，说明上面解法正确。

```java
import java.util.HashSet;
import java.util.Set;

public class Test2{
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        for (int i = 10; i < 100; i++) {
            int len = String.valueOf(i*i).length();  //获取积的长度
            String str = String.valueOf(i*i).substring(len-2,len); //截取及的末尾两位
            set.add(str);   //利用Set不重复的特性
        }
        System.out.println(set.size());
    }
}
```

M：它这种解法跟我们的解法比较有什么不同？

Z：我们的解法是，循环足够多的数，对它们开方后进行判断，统计符合的个数。

网友的解法是，遍历所有可能符合的情况（10-100），将其平方后进行截取统计。

网友的做法来得更简洁方便，而我们自己的写法则直观易考虑到。

M：但我觉得网友使用String好像有点麻烦，为什么不直接用int型

```java
import java.util.HashSet;
import java.util.Set;

public class Test2{
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        for (int i = 10; i < 100; i++) {
        	int result = i*i%100;
            set.add(result);
        }
        System.out.println(set.size());
    }
}
```

Z：结果也是22，同样我们也可以用标注数组代替Set进行符合情况的统计。

M：总结，当我们要对数的符合情况进行统计的时候，可以用以下两种方式：

1. 【Set】自动识别重复内容，只能知道结果数目
2. 【标记数组】对数组符合的数值进行标记，能知道每个单位标记情况

