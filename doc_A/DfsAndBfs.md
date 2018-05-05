# 深搜与广搜   

D：今天我们要来研究深度搜索和广度搜索，首先从一道例题开始:   

### 深度搜索  

```
1.油田
输入一个m行n列的字符矩阵，统计字符“@”组成多少个八连快。如果两个字符“@”所在的格子相邻（横、竖或者对角线方向），就说它们属于同一个八连块。例如，下图有两个八连块。
****@
*@@*@
*@**@
@@@*@
@@**@
```
Z：什么八连块不用管，只要知道这张图被分成几个@块就可以了，像此图是2个。   

D：这道题有一个C的解法，我把它转化为JAVA，如下：

```c++
import java.util.Scanner;

public class Main2 {
	static int m;
	static int n;
	static int idx[][] = new int[m][n];
	static char pic[][] = new char[m][n];
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		m = input.nextInt();
		n = input.nextInt();
		idx = new int[m][n];
		pic = new char[m][n];
		for (int i = 0; i < m; i++) {
			String inStr = input.next();
			for (int j = 0; j < n; j++) {
				pic[i][j] = inStr.charAt(j);
			}
		}
		int cnt = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(idx[i][j] == 0 && pic[i][j] == '@'){
					dfs(i , j , ++cnt);
				}
			}
		}
		System.out.println(cnt);
	}
 
	private static void dfs(int i, int j, int k) {
		if(i < 0 || i >= m || j < 0 || j >= n){     //排除出界的格子
			return;
		}
		if(idx[i][j] > 0 || pic[i][j] != '@'){
			return;
		}
		idx[i][j] = k;    //连通分量编号
		for (int dr = -1; dr <= 1; dr++) {
			for (int dc = -1; dc <= 1; dc++) {
				if(dr != 0 || dc != 0){
					dfs(i + dr, j + dc, k);
				}
			}
		}
	}

}
```

Z：这道题研究之后发现简直太帅了，太有智慧了。

M：

