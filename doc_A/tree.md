# 树形显示   



```
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
  
如有平字体对齐问题，可以参见图【p1.png】


注意，只填写划线部分缺少的代码，不要抄写已有的代码或符号。
```