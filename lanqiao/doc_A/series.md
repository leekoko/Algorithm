# 奇怪的数列   

D：来一道数列题目

```
标题：奇怪的数列

从X星截获一份电码，是一些数字，如下：
13
1113
3113
132113
1113122113
....

YY博士经彻夜研究，发现了规律：
第一行的数字随便是什么，以后每一行都是对上一行“读出来”
比如第2行，是对第1行的描述，意思是：1个1，1个3，所以是：1113
第3行，意思是：3个1,1个3，所以是：3113

请你编写一个程序，可以从初始数字开始，连续进行这样的变换。

数据格式：

第一行输入一个数字组成的串，不超过100位
第二行，一个数字n，表示需要你连续变换多少次，n不超过20

输出一个串，表示最后一次变换完的结果。

例如：
用户输出：
5
7

则程序应该输出：
13211321322115

资源约定：
峰值内存消耗（含虚拟机） < 512M
CPU消耗  < 1000ms


请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。

所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
注意：不要使用package语句。不要使用jdk1.7及以上版本的特性。
注意：主类的名字必须是：Main，否则按无效代码处理。
```

Z：看到数字的长度，不能用int。通过相同的进行截断，思路虽然有，但是感觉做法不简便。看一下网友是怎么实现的。[链接](https://blog.csdn.net/acm_th/article/details/51361790)     

```c++
#include<cstdio>
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
struct mode {
    int sum, p;
};
int N, M, s2[10000];
char s1[10000];
mode getMode(int start) {
    mode m1;
    int i, sum = 1;
    for (i = start; s1[i] == s1[i+1]; i++) {
        sum++;
    } 
    m1.sum = sum;
    m1.p = i+1;
    return m1;
}
int main() {
    freopen("in.txt", "r", stdin);
    scanf("%d%d", &N, &M);
    int k = 0;
    sprintf(s1, "%d", N);
    while(M--) {
        int len = strlen(s1);
        k = 0;
        for (int i = 0; i < len;) {
            int t = s1[i]-'0';
            mode m1 = getMode(i);
            i = m1.p;
            s2[k++] = m1.sum;
            s2[k++] = t;
        }
        memset(s1, 0, sizeof(s1));
        for (int i = 0; i < k; i++) s1[i] = s2[i]+'0';
    }
    for (int j = 0; j < k; j++) printf("%d", s2[j]);
    return 0;
}
```

用到了递归，虽然简洁，能不用递归我还是不太想用的。

M：用自己风格的方式实现，使用嵌套数组的循环

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main3
{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String num = input.next();
		int count = input.nextInt();
		for (int i = 0; i < count; i++) {   //循环
			num = run(num);					//变换
		}
		System.out.println(num);
	}
	/**
	 * 数字变换
	 * @param num
	 * @return
	 */
	private static String run(String num) {
		List<HashMap<String, Integer>> list = new ArrayList<HashMap<String, Integer>>();
		char[] arr = num.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if(list.size()>0){   
				HashMap<String, Integer> near = list.get(list.size()-1);//最新的map
				Iterator<String> iterator = near.keySet().iterator();   //获取Key的操作
				String key = iterator.next();
				if(key.equals(arr[i]+"")){   //还是上一个
					Integer value = near.get(arr[i]+"");    //更新数量
					near.put(arr[i]+"",++value);
				}else{
					HashMap<String, Integer> map = new HashMap<String,Integer>();   //非上一个，新建map 
					map.put(arr[i]+"", 1);
					list.add(map);
				}
			}else{    //空的时候直接新建map
				HashMap<String, Integer> map = new HashMap<String,Integer>();
				map.put(arr[i]+"", 1);
				list.add(map);
			}
		}
		//map转String
		String str = "";
		for (int i = 0; i < list.size(); i++) {
			Set<String> keySet = list.get(i).keySet();
			Iterator<String> iterator2 = keySet.iterator();
			String key = iterator2.next();
			str += list.get(i).get(key) + key;
		}
		return str;
	}
	
}	
```

M：简单总结一下，就是用一个List来存储map，通过判断最近的map的key是否与当前的值相同，是的话统计数字加1，主要就是对嵌套map的List的操作。