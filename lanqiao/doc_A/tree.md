# 树形显示   

D:树形图打印了解下：

```java
标题：树形显示

对于分类结构可以用树形来形象地表示。比如：文件系统就是典型的例子。
树中的结点具有父子关系。我们在显示的时候，把子项向右缩进（用空格，不是tab），并添加必要的连接线，以使其层次关系更醒目。
下面的代码就是为了这个目的的，请仔细阅读源码，并填写划线部分缺少的代码。

import java.util.*;

class MyTree {
	private Map<String, List<String>> map_ch = new HashMap<String, List<String>>();
	private Map<String, String> map_pa = new HashMap<String, String>();

	public void add(String parent, String child) {
		map_pa.put(child, parent);

		List<String> lst = map_ch.get(parent);
		if (lst == null) {
			lst = new ArrayList<String>();
			map_ch.put(parent, lst);
		}
		lst.add(child);
	}

	public String get_parent(String me) {
		return map_pa.get(me);
	}

	public List<String> get_child(String me) {
		return map_ch.get(me);
	}

	private String space(int n) {
		String s = "";
		for (int i = 0; i < n; i++)
			s += ' ';
		return s;
	}

	private boolean last_child(String x) {
		String pa = map_pa.get(x);
		if (pa == null)
			return true;

		List<String> lst = map_ch.get(pa);
		return lst.get(lst.size() - 1).equals(x);
	}

	public void show(String x) {

		String s = "+--" + x;

		String pa = x;
		while (true) {
			pa = map_pa.get(pa);
			if (pa == null)
				break;
			s = ___________________________________; // 填空
		}

		System.out.println(s);
	}

	public void dfs(String x) {
		show(x);

		List<String> lst = map_ch.get(x);
		if (lst == null)
			return;

		for (String it : lst) {
			dfs(it);
		}
	}
}

public class TreeView {
	public static void main(String[] args) {
		MyTree tree = new MyTree();
		tree.add("root", "dog");
		tree.add("root", "cat");
		tree.add("root", "duck");
		tree.add("dog", "AAdog");
		tree.add("dog", "BBdog");
		tree.add("dog", "CCdog");
		tree.add("AAdog", "AAdog01");
		tree.add("AAdog", "AAdog02");
		tree.add("cat", "XXcat");
		tree.add("cat", "YYcat");
		tree.add("XXcat", "XXcat-oo");
		tree.add("XXcat", "XXcat-qq");
		tree.add("XXcat-qq", "XXcat-qq-hahah");
		tree.add("duck", "TTduck");
		tree.add("TTduck", "TTduck-001");
		tree.add("TTduck", "TTduck-002");
		tree.add("TTduck", "TTduck-003");
		tree.add("YYcat", "YYcat.hello");
		tree.add("YYcat", "YYcat.yes");
		tree.add("YYcat", "YYcat.me");
		
		tree.dfs("root");
	}
}


对于题目中的测试数据，输出结果:
+--root
     +--dog
     |    +--AAdog
     |    |    +--AAdog01
     |    |    +--AAdog02
     |    +--BBdog
     |    +--CCdog
     +--cat
     |    +--XXcat
     |    |    +--XXcat-oo
     |    |    +--XXcat-qq
     |    |         +--XXcat-qq-hahah
     |    +--YYcat
     |         +--YYcat.hello
     |         +--YYcat.yes
     |         +--YYcat.me
     +--duck
          +--TTduck
               +--TTduck-001
               +--TTduck-002
               +--TTduck-003

注意，只填写划线部分缺少的代码，不要抄写已有的代码或符号。
```
Z：MyTree类有两个数组，一个是``<String, List<String>>`` (SL数组),另一个是``<String, String>`` （SS数组）。作为整个树形结构的容器。

M：MyTree的add方法有什么用呢？

```java
		tree.add("root", "dog");       //父节点，子节点
```

Z：打开其类中的方法：

```java
	public void add(String parent, String child) {
		map_pa.put(child, parent);    //往SS数组存进 子，父 节点

		List<String> lst = map_ch.get(parent);    //拿父节点问问 SL 数组中有没有对应键值
		if (lst == null) {       //容器存在判断
			lst = new ArrayList<String>();
			map_ch.put(parent, lst);     //没有就创建一个键值
		}
		lst.add(child);    //把子节点放进键值里
	}
```

add方法做的就是往两个数组放值：

1. SS数组放父子节点，一对一
2. SL数组放父子子子节点，一对多

最后的结果就是：通过SS数组可以找到每个子节点的父亲，通过SL数组可以找到每个父节点的所有儿子。   

M：那这个dfs方法是怎么做到遍历的呢？

```java
tree.dfs("root");
```

Z：在执行dfs方法的第一步会执行``show(x)``方法。

```java
	public void dfs(String x) {
		show(x);

		List<String> lst = map_ch.get(x);
		if (lst == null)
			return;

		for (String it : lst) {
			dfs(it);
		}
	}
```

打开``show(x)``方法，可以看到这么一段代码：

```java
	public void show(String x) {

		String s = "+--" + x;

		String pa = x;
		while (true) {
			pa = map_pa.get(pa);
			if (pa == null)
				break;    //第一行直接打印
			s = ___________________________________; // 填空
		}

		System.out.println(s);
	}
```

s填空那一行就是对分支形状的构造，看一下分支的形状是怎么样的：

```
+--root
     +--dog
     |    +--AAdog
     |    |    +--AAdog01
```

大概就是由  +--  ，  |   ,  空格  三种元素构成。

拿第二行为例，就是  ``空格*5  +   +--dog``  ，也就是  ``s = "     "+s; // 填空``  

M:运行了一遍，出现了树状图大体的效果了。

```
+--root
     +--dog
          +--AAdog
               +--AAdog01
               +--AAdog02
          +--BBdog
          +--CCdog
     +--cat
          +--XXcat
               +--XXcat-oo
               +--XXcat-qq
                    +--XXcat-qq-hahah
          +--YYcat
               +--YYcat.hello
               +--YYcat.yes
               +--YYcat.me
     +--duck
          +--TTduck
               +--TTduck-001
               +--TTduck-002
               +--TTduck-003
```

现在还少了 ``|`` 的内容

Z：观察``|`` 出现的规律，看一下这一段：

```
     +--cat
     |    +--XXcat
     |    |    +--XXcat-oo
     |    |    +--XXcat-qq
     |    |         +--XXcat-qq-hahah
     |    +--YYcat
     |         +--YYcat.hello
     |         +--YYcat.yes
     |         +--YYcat.me
     +--duck
          +--TTduck
               +--TTduck-001
               +--TTduck-002
               +--TTduck-003
```

``|`` 出现其实是跟右边的内容没有直接关系的。回到树形图的特性：

当两个同级的父亲结点中间隔了后代结点，就会在两个父亲结点之间产生``|``进行父亲结点间的连接：

```java
+--XXcat          //父亲结点1
|    +--XXcat-oo      			//后代结点1
|    +--XXcat-qq      			//后代结点2
|         +--XXcat-qq-hahah      //后代结点3
+--YYcat   		//父亲结点2
```

现在目标为 打印第三行：

对比现在  已打印的效果  和  目标效果  ：

```
+--root
     +--dog
          +--AAdog
```

```
+--root
     +--dog
     |    +--AAdog
```

可以发现，两者之间并没有位置偏移。也就是说``|``很有可能就是替换上去的。至于第三行要不要执行替换，取决于下方是否有与第二行同级的项。

我们现在的结果长度是正确的：``空格*5+ +--dog`` ，观察第三行可知，``|``所处的位置是空格的第一位。所以空格的内容大概为：``单个空格 或者 |   +   空格*4   +   +--AAdog``

至于如果控制``单个空格 或者 |``,查看了一下网友的做法，答案竟然是:

``s=last_child(pa)? "     " + s: "|    " + s;``     

M：``last_child(pa)``是什么？为什么可以控制字符串。

Z：这是一种布尔类型特有的写法，在一行内容对两个值进行选择

``System.out.println(true? "one":"two");``  结果为one，true执行第一个，false执行第二个。

而 ``last_child(pa)`` 是被我们忽略的方法，打开如下：

```java
	private boolean last_child(String x) {
		String pa = map_pa.get(x);     //找到父节点
		if (pa == null)
			return true;

		List<String> lst = map_ch.get(pa);   //所有子节点
		return lst.get(lst.size() - 1).equals(x);    //是否为最后的子节点
	}
```

判断如果是最后的子节点，说明后边没有同级节点，则不用添加|。否者有同级节点就要添加|。   

M：到这里答案虽然知道了，但我还想更多了解整块代码的思路。    

loading



















