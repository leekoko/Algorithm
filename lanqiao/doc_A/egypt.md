# 埃及分数  

D：简单的题目

```
标题：埃及分数

    古埃及曾经创造出灿烂的人类文明，他们的分数表示却很令人不解。古埃及喜欢把一个分数分解为类似： 1/a + 1/b 的格式。

    这里，a 和 b 必须是不同的两个整数，分子必须为 1

    比如，2/15 一共有 4 种不同的分解法（姑且称为埃及分解法）：

1/8 + 1/120
1/9 + 1/45
1/10 + 1/30
1/12 + 1/20

    那么， 2/45 一共有多少个不同的埃及分解呢（满足加法交换律的算同种分解）？ 请直接提交该整数（千万不要提交详细的分解式！）。

    请严格按照要求，通过浏览器提交答案。
    注意：只提交分解的种类数，不要写其它附加内容，比如：说明性的文字
```

M：题是读懂了，但是关于分数的相加，要怎么验算对不对呢？

Z：看一下网友的解法  [链接](https://blog.csdn.net/bear_huangzhen/article/details/78513838)

```java
public static void main(String[] args) {  
        //新建2/45  
        Rational r = new Rational(2, 45);  
        //计数变量  
        int counter = 0;  
        for (int a = 23; a < 45; a++) {  
            Rational ra = new Rational(1, a);  
            Rational rb = r.sub(ra);  
            if(rb.x == 1 && rb.y > a) {  
                System.out.println(ra.toString() + "+" + rb.toString());  
                counter++;  
            }  
        }  
        System.out.println(counter);  
    }  
```

```java
public class Rational {  
    int x;  
    int y;  
      
    public Rational(int x, int y){  
        int gcd = gcd(x,y);  
        this.x = x/gcd;  
        this.y = y/gcd;  
    }  
      
    //辗转相除法求最大公约数  
    //(10,5) == (5,0) == 5  
    private int gcd(int x, int y){  
        if(y == 0) return x;  
        return gcd(y,x%y);  
    }  
      
    //x1/y1 +x2/y2 == (x1y2+x2y1)/y1y2  
    public Rational add(Rational r){  
        return new Rational(this.x*r.y + r.x*this.y, this.y*r.y);  
    }  
      
    //x1/y1 - x2/y2 = (x1y2-x2y1)/y1y2  
    public Rational sub(Rational r) {  
        return new Rational(this.x*r.y - r.x*this.y, this.y*r.y);  
    }  
      
    @Override  
    public String toString() {  
        return this.x +"/" + this.y;  
    }  
  
}  
```

M：我试了一下 2/15 测试用例的结果出不来，为什么？

Z：for循环的遍历需要对应改变，分母的可能由15的一半到15，也就是7-15。``for (int a = 7; a < 15; a++) {  ``  

M：分数的相加怎么计算？

Z：该方法就是模拟出了一个分数类，当执行add方法，根据分数的特点可以转化等式``x1/y1 +x2/y2 == (x1y2+x2y1)/y1y2 ``  ,然后再将结果以分数类的形式展示出来

```java
    //x1/y1 +x2/y2 == (x1y2+x2y1)/y1y2  
    public Rational add(Rational r){  
        return new Rational(this.x*r.y + r.x*this.y, this.y*r.y);  
    } 
```

M：这个方法是什么？

Z：每次生成分数对象都会执行的初始化方法，是一个常见的算法``辗转相除法``，可以算出最大公约数，直接记忆即可

```java
     //辗转相除法求最大公约数  
	private int gcd(int x, int y){  
        if(y == 0) return x;  
        return gcd(y,x%y);  
    }  
```

M：这道题主要就是通过模拟分数来实现对分数的运算，其中重要的就是约分，通过辗转相除法寻找最大公约数，除掉之后获得的值就是最简值。

 