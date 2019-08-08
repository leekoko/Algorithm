# 深度搜索模板   

```java
    public static void dfs(String s){  
    	if(x>=N-1 && y>=N-1){  
    		if(canEqual()){
    			System.out.println(s);
    		}
        }  
          
        //朝四个方向走  
        for(int i = 0; i < 4; i++){  
        	x += direction[i][0];     //坐标 
        	y += direction[i][1];  
            if(x >= 0 && y >= 0 && x < N && y < N && mark[x][y] == 0){   //筛选不符合情况  
            	int position = x + N * y;    //所在位置编号  
            	String str = s + " "+ position;  
                mark[x][y]=1;  //标记
                dfs(str);  
                mark[x][y]=0;//数组回溯  
            }  
            x -= direction[i][0];  
            y-= direction[i][1];    //全局回溯  
        }  
    }
```

- 全局参数有 x，y坐标、数组   需要进行回溯
- 递归的时候对情况进行筛选    
- 出口只要认证情况即可