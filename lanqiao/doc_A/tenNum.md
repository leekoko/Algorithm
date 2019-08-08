# 平方十位数   

D：今天来一道热乎乎的真题：

```
标题：平方十位数

由0~9这10个数字不重复、不遗漏，可以组成很多10位数字。
这其中也有很多恰好是平方数（是某个数的平方）。
比如：1026753849，就是其中最小的一个平方数。
请你找出其中最大的一个平方数是多少？

注意：你需要提交的是一个10位数字，不要填写任何多余内容。
```

M:这道题暂时没有太好的思路，求帮助！

Z:找到一个java解法，了解一下： [链接](https://blog.csdn.net/Hell_Caesar/article/details/72886719)  

```java
import java.math.BigInteger;  
import java.util.HashSet;  
import java.util.Set;  
  
public class test1 {  
    public static void main(String[] args) {  
        BigInteger x;  
        BigInteger y = new BigInteger("10");  
        BigInteger[] a = new BigInteger[10];  
        String s = "100000";  
        String s2 = "32043";  
        BigInteger t = new BigInteger(s2);  
        for (BigInteger b = new BigInteger(s); b.compareTo(t) >= 0; b = b.subtract(new BigInteger("1"))) {      //for循环递减
            x = b.multiply(b);     //b*b
            for (int m = 9; m >= 0; m--) {  
                a[m] = x.remainder(y);     //a[m] = x % y
                x = x.divide(y);      // x = x / y
            }  
            Set set = new HashSet();  
            for (int i = 0; i < a.length; i++) {   //Set属性：不重复
                set.add(a[i]);  
            }  
            if (set.size() == a.length) {  
                System.out.println(b.multiply(b));     //修改原文：b*b
                break;  
            }  
        }  
    }  
}  
```

得出答案为：9814072356

M：for循环看起来有点复杂，能解释一下吗？

```java 
for (BigInteger b = new BigInteger(s); b.compareTo(t) >= 0; b = b.subtract(new BigInteger("1"))) { 
```

Z：从b=100000开始递减，一直到b < t,类似于

```java
for(int b=100000; b < t; b --){...
```

其中compareTo的返回值：

- 如果参数字符串等于此字符串，则返回值 0；
- 如果此字符串小于字符串参数，则返回一个小于 0 的值；
- 如果此字符串大于字符串参数，则返回一个大于 0 的值。

M：那这个最小数t是怎么由来的呢？

```java
        String s2 = "32043";  
        BigInteger t = new BigInteger(s2);  
```

Z：这是由题目的提示得来，实际上中途就能得出答案，根本就不可能循环到这个数。题目说``1026753849，就是其中最小的一个平方数。``,所以开方之后就得到``32043``,将其设为最小数多少也有一点意义。

M: 那这个for循环的语法也有点陌生：

```java
            for (int m = 9; m >= 0; m--) {  
                a[m] = x.remainder(y);  
                x = x.divide(y);  
            }  
```

Z：``remainder``相当于 % ,``divide``相当于 /

y的值为10，所以这个循环的意思就是把x（也就是b*b）分解成十个数字，存进一个十位数组中。

_这里的存储只对长度刚好是10位的数有效，像第一个数100000*100000是存不完整的。_   

M：这里利用Set存储的数字不重复的特性，将所有的数字存进Set里，如果数字刚好为10个，则说明符合0-10都不重复的情况，妙解！

```java
            for (int i = 0; i < a.length; i++) {   //Set属性：不重复
                set.add(a[i]);  
            }  
            if (set.size() == a.length) {  
                System.out.println(b.multiply(b));     //修改原文：b*b
                break;  
            }  
```

M：这数值非得用BigInteger吗？

Z：int的最大数值是2147483647，十位数，21开头。所以这道题明显考察的就是大数的应用。

M：这道题主要就是：暴力破解，从最大的数往后推，涉及知识点有

1. 大数的使用：循环，四则运算，%，比较，大数数组
2. Set特性的利用：不重复插入，大大简化题目

所以做题还是以暴力优先，不要小看计算机，小数不够就用大数。

Z：这道题还可以简单优化一下，将数组和Set进行合并：

```java
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {  
        BigInteger result;  //平方结果
        final BigInteger TEN = new BigInteger("10"); //定量 
        String s = "100000";  
        String s2 = "32043";  
        BigInteger min = new BigInteger(s2);  
        for (BigInteger num = new BigInteger(s); num.compareTo(min) >= 0; num = num.subtract(new BigInteger("1"))) {  
            result = num.multiply(num);  
            String value =  result.toString();   //最终值
            Set set = new HashSet();  
            for (int m = 9; m >= 0; m--) {  
                set.add(result.remainder(TEN));
                result = result.divide(TEN);  
            }
            if (set.size() == 10) {  
                System.out.println(value);  
                break;  
            }  
        }  
    }  
}
```