# 数字拆分   

D：填空题来一道

```java
标题：数字拆分

  正整数可以表示为若干正整数的累加和。

  如，对于正整数n=6，可以分划为： 
6
5+1
4+2
4+1+1
3+3
3+2+1
3+1+1+1
2+2+2
2+2+1+1
2+1+1+1+1
1+1+1+1+1+1

  现在的问题是，对于给定的正整数n,计算出所有划分情况。
  下面的代码实现了这个功能。仔细分析，填写划线部分缺失的代码。

public class MyTest
{	public static List fen(int n, int limit)
	{
		Vector v = new Vector();
		if(n<=limit) v.add(n);
		
		for(int i=1; i<n; i++)
		{
			if(n-i > limit) continue;

			List t = fen(i,n-i);
			
			for(int k=0; k<t.size(); k++)
				__________________________;  //填空位置
		}
		
		return v;
	}
	
	public static void main(String[] args)
	{		
		List v = fen(6,6);		
		for(int i=0; i<v.size(); i++)
			System.out.println(v.get(i));
	}
}
```

M：这个递归有点看不懂，怎么理解呢？

Z：看一下网友的解法 [链接](https://blog.csdn.net/calculate23/article/details/79366154)  

网友为C++写法  ``v.push_back(to_string(n-i)+"+"+t[k]); `` 

这里我将它转化为java   ``v.add((n-i)+"+"+t.get(k));``    

M：看了答案仍然不知道为什么这么写，调试一下。





loading之后再理解















