# 闲聊蓝桥杯JAVA - 拉马车

D:今天研究比较新鲜的题目，拉马车

```
标题：拉马车

小的时候，你玩过纸牌游戏吗？
有一种叫做“拉马车”的游戏，规则很简单，却很吸引小朋友。

其规则简述如下：
假设参加游戏的小朋友是A和B，游戏开始的时候，他们得到的随机的纸牌序列如下：
A方：[K, 8, X, K, A, 2, A, 9, 5, A]
B方：[2, 7, K, 5, J, 5, Q, 6, K, 4]

其中的X表示“10”，我们忽略了纸牌的花色。

从A方开始，A、B双方轮流出牌。

当轮到某一方出牌时，他从自己的纸牌队列的头部拿走一张，放到桌上，并且压在最上面一张纸牌上（如果有的话）。

此例中，游戏过程：
A出K，B出2，A出8，B出7，A出X，此时桌上的序列为：

K,2,8,7,X

当轮到B出牌时，他的牌K与桌上的纸牌序列中的K相同，则把包括K在内的以及两个K之间的纸牌都赢回来，放入自己牌的队尾。注意：为了操作方便，放入牌的顺序是与桌上的顺序相反的。
此时，A、B双方的手里牌为：
A方：[K, A, 2, A, 9, 5, A]
B方：[5, J, 5, Q, 6, K, 4, K, X, 7, 8, 2, K]

赢牌的一方继续出牌。也就是B接着出5，A出K，B出J，A出A，B出5，又赢牌了。
5,K,J,A,5
此时双方手里牌：
A方：[2, A, 9, 5, A]
B方：[Q, 6, K, 4, K, X, 7, 8, 2, K, 5, A, J, K, 5]

    注意：更多的时候赢牌的一方并不能把桌上的牌都赢走，而是拿走相同牌点及其中间的部分。但无论如何，都是赢牌的一方继续出牌，有的时候刚一出牌又赢了，也是允许的。

    当某一方出掉手里最后一张牌，但无法从桌面上赢取牌时，游戏立即结束。

    对于本例的初始手牌情况下，最后A会输掉，而B最后的手里牌为：

9K2A62KAX58K57KJ5

    本题的任务就是已知双方初始牌序，计算游戏结束时，赢的一方手里的牌序。当游戏无法结束时，输出-1。

输入为2行，2个串，分别表示A、B双方初始手里的牌序列。
输出为1行，1个串，表示A先出牌，最后赢的一方手里的牌序。

例如，
输入：
96J5A898QA
6278A7Q973

则程序应该输出：
2J9A7QA6Q6889977

再比如，
输入：
25663K6X7448
J88A5KJXX45A

则程序应该输出：
6KAJ458KXAX885XJ645

我们约定，输入的串的长度不超过30

资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 1000ms
```

Z:现在先自己试做一下。

M:我用stack的方式解了一下，但是花了很长时间还是不正确，可能是我把问题搞复杂了。

```java
package dajimu;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		 Scanner input = new Scanner(System.in);
		 String strA = input.next();
		 String strB = input.next();
		 game(strA, strB);
	}

	private static void game(String strA, String strB) {
		Stack<String> stack = new Stack<String>();
		while(true){
			while(true){
				String a = strA.substring(0, 1);
				strA = strA.substring(1);
				String temp = isWin(stack, a, strA);
				if(temp.equals(strA)){
					break;
				}else{
					strA = temp;
				}
			}
			while(true){
				String b = strB.substring(0, 1);
				strB = strB.substring(1);
				String temp = isWin(stack, b, strB);
				if(temp.equals(strB)){
					break;
				}else{
					strB = temp;
				}
			}
			
			if(strA.length() == 1 || strB.length() == 1){
				break;
			}
		}
		
		if(strA.length() > strB.length()){
			System.out.println(strA);
		}else{
			System.out.println(strB);
		}
	}

	private static String isWin(Stack stack, String a, String str) {
		if(stack.search(a)>0){
			while(true){
				String temp = (String)stack.pop();
				str += temp;
				if(temp.equals(a)){
					break;
				}
			}
			str += a; 
		}else{
			stack.push(a);
		}
		return str;
	}
}
```

Z:看一下网友是怎么实现的。发现一位相当用心的哥们，推荐大家去看一下他的分析。 [链接](https://blog.csdn.net/lzw1604748707/article/details/78822892)    

下面是他的解法：

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class E8 {
    boolean flag;
    char st;
    int onMax;
    boolean fate;
    int a1;

    public void frame(ArrayList<Character> a, ArrayList<Character> b, ArrayList<Character> onging) {
        flag = true;
        fate = true;

        //测试变量
         a1=1;
        while (fate) {

            //测试fate
            System.out.println("第"+a1+"次出牌");
            System.out.println("轮到"+flag+"出牌");
            a1++;//出牌次数
            // flag=   true    false

            if (flag) {
                fate=underway(a, onging);
                  if(fate)
                flag=sourse(flag, st, a, onging);

            } else {
                fate=underway(b, onging);
                if(fate)
                flag=sourse(flag, st, b, onging);
            }
            System.out.println("此时true玩家的手牌是："+a);
            System.out.println("此时false玩家的手牌是："+b+"\n");

        }

if(flag){

    display(b);
System.out.println(flag+"玩家成为最后的冠军！他的手牌有："+b);}
else{
    display(a);
System.out.println(flag+"玩家成为最后的冠军！\n他的手牌有："+a);}

    }
    public void display(ArrayList<Character> x){
        String reult = "";
        for(char ds:x)
            reult+=ds;

        System.out.println(reult);
    }
    public boolean underway(ArrayList<Character> x, ArrayList<Character> onging) {


            onging.add(x.get(0));
//          System.out.println(onging);

            st=x.get(0);//记录打出的牌
            System.out.println("该玩家打出的手牌为"+st);
            x.remove(0);
//          System.out.println(x);

            String reult = "";
            for(char ds:onging)
                reult+=ds;          
            System.out.println(reult);
            if(x.size()==0&& onging.lastIndexOf(st)==onging.indexOf(st)){
                System.out.println("该玩家手中没有牌了另一位玩家获胜");
                return false;}
            return true;
    }
    public boolean sourse(boolean flag, char st, ArrayList<Character> x, ArrayList<Character> onging) {

        System.out.println("桌面上有"+onging.size()+"张牌");

        if(onging.size()!=0){

              if(onging.lastIndexOf(st)==onging.indexOf(st)){
                  System.out.println("桌面上只有一个"+st+"牌\n");
                  return !flag;}
              int na=onging.indexOf(st)-1;
              while(onging.size()-1!=na){
                  System.out.println("此时桌面上有"+onging.size()+"张牌,"+st+"在第"+(onging.indexOf(st)+1)+"张");
                onMax=onging.size()-1;
                  System.out.println("桌面上最后一张牌的下标是："+onMax);

                x.add(onging.get(onMax));
                System.out.println("将"+onging.get(onMax)+"牌加入到"+x+"玩家的手牌");
                onging.remove(onMax);

                a1--;//桌面减少一张牌

                System.out.println("此时桌面上最后一张牌的下标是"+(onging.size()-1));}        
        }
//  System.out.println(onging);
        System.out.println();
        return flag;


    }

    public static void main(String[] args) {
        String str;
        Scanner input = new Scanner(System.in);

        // 赋予A玩家初始手牌
        str = input.next();
        ArrayList<Character> a = new ArrayList<Character>();
        for (char cha : str.toCharArray())
            a.add(cha);

        // 赋予B玩家初始手牌
        str = input.next();
        ArrayList<Character> b = new ArrayList<Character>();
        for (char cha : str.toCharArray())
            b.add(cha);

        // 游戏版面
        ArrayList<Character> onging = new ArrayList<Character>();

        new E8().frame(a, b, onging);
    }
}
```

M:这位小哥因为用List数组来存储，导致写法复杂了一点，但是他这句代码``if(x.size()==0&& onging.lastIndexOf(st)==onging.indexOf(st)){...``很好地提醒了我，当某方只剩一张牌的时候,不一定会输，如果有成对，可能还能挽回局面。

1. 所以我的判断最后一张牌就输了的做法是错误的。所以我修改成某一个人，只要谁没有牌了，马上就结束比赛。所以需要添加两个if判断。

   ```java
   			if(strA.length() == 0 ){
   				break;
   			}
   ```

2. 第二个错误的地方，当牌成对的时候，最后一张牌应该放在最前面，而不是后来才补上，所以修改补上a变量的位置。

   ```java
   		if(stack.search(a)>0){
   			str += a;    ...
   ```

D:那把代码整理一下，重新发布正确的解法吧。

M:

```java
public class Main {
	public static void main(String[] args) {
		 Scanner input = new Scanner(System.in);
		 String strA = input.next();
		 String strB = input.next();
		 game(strA, strB);
	}
	/**
	 * 游戏开始
	 * @param strA
	 * @param strB
	 */
	private static void game(String strA, String strB) {
		Stack<String> stack = new Stack<String>();
		while(true){
			while(true){
				String a = strA.substring(0, 1);  //取出一张牌
				strA = strA.substring(1);   //剩余的牌
				String temp = isWin(stack, a, strA);  //判断是否可赢牌
				if(temp.equals(strA)){   //如果没赢牌，自己的牌不会发生变化，轮到对手
					break;
				}else{
					strA = temp;    //如果赢牌了，自己还将继续游戏
				}
			}
			if(strA.length() == 0 ){    //当自己的牌变为0张的时候，结束比赛，对手无需再下牌
				break;
			}
			while(true){
				String b = strB.substring(0, 1);
				strB = strB.substring(1);
				String temp = isWin(stack, b, strB);
				if(temp.equals(strB)){
					break;
				}else{
					strB = temp;
				}
			}
			if(strB.length() == 0){
				break;
			}
		}
		
		if(strA.length() > strB.length()){   //输出手中有牌选手的手牌
			System.out.println(strA);
		}else{
			System.out.println(strB);
		}
	}
	/**
	 * 判断是否可赢牌
	 * @param stack
	 * @param a
	 * @param str
	 * @return
	 */
	private static String isWin(Stack stack, String a, String str) {
		if(stack.search(a)>0){   //如果存在和a一样的牌
			str += a;    //把a牌放在最后一位
			while(true){
				String temp = (String)stack.pop();   
				str += temp;    //把桌面上的牌倒着一张张放到最后的位置
				if(temp.equals(a)){   //一直放到和a牌一样的牌为止
					break;
				}
			}
		}else{
			stack.push(a);   //没有和a牌一样的牌，放在桌面牌的最后位置
		}
		return str;   //返回自己的牌
	}
}
```

M:总结一下，这道题其实没有什么难点，重点就是stack的使用，如果不利用stack的压栈特性，使用List将会复杂化操作。（stack就是先进的在下面，后进的在上方，每次pop出来的，都是最新鲜的牌）。

而这道题的难点无非就是对规则的细心处理，例如我踩过的几个坑：

1. 自己赢了，自己继续比赛，而不是直接轮到对手。
2. 一旦赢了整局比赛，马上结束比赛，而不是最后还让对手下一张牌。
3. 赢了的牌是倒着放进自己的牌的后面，注意那张选手下的牌要放在最前面。

最后还是，要细心审题，新平气和地多做调试，否则再多的时间可能也不够做这么一道”简单“题。