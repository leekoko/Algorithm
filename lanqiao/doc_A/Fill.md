# 闲聊蓝桥杯JAVA -括号问题   

M：有点无聊，来几道填空题玩玩，不用烧脑

D：ok,括号问题

```java
下面的代码用于判断一个串中的括号是否匹配
所谓匹配是指不同类型的括号必须左右呼应，可以相互包含，但不能交叉

例如：
..(..[..]..)..  是允许的
..(...[...)....].... 是禁止的 
对于 main 方法中的测试用例，应该输出：
false
true
false
false

import java.util.*;
public class A22
{
	public static boolean isGoodBracket(String s)
	{
		Stack<Character> a = new Stack<Character>();
		
		for(int i=0; i<s.length(); i++)
		{
			char c = s.charAt(i);
			if(c=='(') a.push(')');
			if(c=='[') a.push(']');
			if(c=='{') a.push('}');
			
			if(c==')' || c==']' || c=='}')
			{
				if(____________________) return false;    // 填空
				if(a.pop() != c) return false;
			}
		}
		
		if(___________________) return false;  // 填空
		
		return true;
	}
	
	public static void main(String[] args)
	{
		System.out.println( isGoodBracket("...(..[.)..].{.(..).}..."));
		System.out.println( isGoodBracket("...(..[...].(.).){.(..).}..."));
		System.out.println( isGoodBracket(".....[...].(.).){.(..).}..."));
		System.out.println( isGoodBracket("...(..[...].(.).){.(..)...."));
	}
}
```

Z:汗,对于别人的代码，有一点厌恶和恐惧感，但还是拿到IDE里跑跑看。

第一个空 `` if(a.size() == 0) return false;    // 填空``

第二个空``if(a.size()>0) return false;  // 填空   还有括号``   

M:怎么确定第一个空的？

Z:因为下面的代码是``if(a.pop() != c) return false;`` ,a.pop()的执行必须数组里面有内容，否则就会报``java.util.EmptyStackException``空栈异常（相当于空指针）

M:那第二个空呢？

Z:因为当所有的字符都被循环完之后，那么如果栈中还有括号，说明是非成对的括号，是错误的情况，所以需要进行判断。

M:简单地说，就是要对数组的内部情况比较关心，会不会被掏空啊？会不会有剩余呢？多关心关心数组。