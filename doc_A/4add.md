# 四平方和

D:这道题有一点复杂，看了

```
四平方和

四平方和定理，又称为拉格朗日定理：
每个正整数都可以表示为至多4个正整数的平方和。
如果把0包括进去，就正好可以表示为4个数的平方和。

比如：
5 = 0^2 + 0^2 + 1^2 + 2^2
7 = 1^2 + 1^2 + 1^2 + 2^2
（^符号表示乘方的意思）

对于一个给定的正整数，可能存在多种平方和的表示法。
要求你对4个数排序：
0 <= a <= b <= c <= d
并对所有的可能表示法按 a,b,c,d 为联合主键升序排列，最后输出第一个表示法


程序输入为一个正整数N (N<5000000)
要求输出4个非负整数，按从小到大排序，中间用空格分开

例如，输入：
5
则程序应该输出：
0 0 1 2

再例如，输入：
12
则程序应该输出：
0 2 2 2

再例如，输入：
773535
则程序应该输出：
1 1 267 838
```

Z:这道题有一个简单，但是不是很优的做法。

```java
	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		int num = input.nextInt();
		double maxNum= Math.sqrt(5000000);
		for (int i = 0; i <maxNum; i++) {
			for (int j = i; j < maxNum; j++) {
				for (int k = j; k < maxNum; k++) {
					int l=(int)Math.sqrt(num-i*i-j*j-k*k);
					if(i*i+j*j+k*k+l*l==num){
						System.out.println(i+" "+j+" "+k+" "+l);
						return;
					}
				}
			}
		}		
	}
```

M:为什么要``double maxNum= Math.sqrt(5000000);``   ?

Z:尽力缩小最大值的范围，因为是平方，最大不会超过开方的数。

M:暴力破解为什么每次从上个数开始？

```java
		for (int i = 0; i <maxNum; i++) {
			for (int j = i; j < maxNum; j++) {
				for (int k = j; k < maxNum; k++) {
```

Z:还是一样，因为数字逐个递增，尽量减少不必要的循环。

M:那为什么只循环三个数呢？

Z:因为只要三个数确定，最后一个数也就确定了。算出那个数，并且进行校验即可。

```java
					int l=(int)Math.sqrt(num-i*i-j*j-k*k);
					if(i*i+j*j+k*k+l*l==num){
						System.out.println(i+" "+j+" "+k+" "+l);
						return;
					}
```

M:总结这道题目，主要就是尽量减少循环的次数。

1.减少循环的最大值。2.for循环从上个数开始。3.第4个数通过其他3个数确定。

最后进行验证。