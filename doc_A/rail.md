# 闲聊蓝桥杯JAVA - 铁轨  

D:现在研究这道题，之前忽略掉的。

```
某城市有一个火车站，有n节车厢从A方向驶入车站，按进站的顺序编号为1~n。现让它们按照某种特定的顺序进入B方向的铁轨并驶出车站。为了重组车厢，你可以借助中转站C。在程序中输入车厢数目和出站的特定顺序，如果可以则输出Yes，否者输出No。

样例输入：
5
1 2 3 4 5
5
5 4 1 2 3
6
6 5 4 3 2 1

样例输出：
Yes
No
Yes
```

Z:这道题以前是做过的：

```java
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int arrNum = input.nextInt();
		int[] arr = new int[arrNum];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = input.nextInt();
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		int arrPoint = 0;
		for (int i = 1; i <= arrNum; i++) {
			stack.push(i);
			while(stack.size() > 0 && stack.peek() == arr[arrPoint]){
				stack.pop();
				arrPoint++;
			}
		}
		if(stack.size()==0){
			System.out.println("Yes");
		}else{
			System.out.println("No");
		}
	}
```

M:这里主要代码就是这一段，应该怎么理解呢？

```java
		for (int i = 1; i <= arrNum; i++) {
			stack.push(i);
			while(stack.size() > 0 && stack.peek() == arr[arrPoint]){
				stack.pop();
				arrPoint++;
			}
		}
```

为什么每次循环都把i给push到stack呢？``stack.push(i);``  

Z: i 代表的是一个编号，也就是说车厢的编号逐个押进stack中。

M:那这个``while(stack.size() > 0 && stack.peek() == arr[arrPoint]){``又有什么含义呢？

Z:当栈中你 最新压进去的东西 刚好等于输入的 列车编号第一位。那就把压进去的东西弹出来，指向列车编号的下一位。  

这个时候还会重复当前的步骤，一直到不符合为止。

这种做法可能不太好理解，再形象一点描述就是。我现在面前有AB两串麻将：

``` 
1 2 3 4 5 6    和    6 5 4 3 2 1
```

现在我手上有一个空瓶子，接下来做以下操作：

```
将A串的第1个 数字1 放进瓶子里，看看瓶子 最上面的数字1 是否等于结果串 B串的第1个数字6，不相同，继续
将A串的第2个 数字2 放进瓶子里，看看瓶子 最上面的数字2 是否等于结果串 B串的第1个数字6，不相同，继续
将A串的第3个 数字3 放进瓶子里，看看瓶子 最上面的数字3 是否等于结果串 B串的第1个数字6，不相同，继续
...
将A串的第6个 数字6 放进瓶子里，看看瓶子 最上面的数字6 是否等于结果串 B串的第1个数字6，相同，
将瓶子最上面的数字6弹出，看看瓶子 最上面的数字5 是否等于结果串 B串的第2个数字5，相同，
将瓶子最上面的数字5弹出，看看瓶子 最上面的数字4 是否等于结果串 B串的第3个数字4，相同，
...
一旦 A串 为空，判断瓶子是否为空？是的话说明Yes，否则No。
```

M:总结一下，这题的重点就是对压栈排序的使用，每次压一个就进行栈和结果串的比对，最后判断是否能实现结果串。