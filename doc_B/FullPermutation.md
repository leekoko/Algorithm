# ȫ����

## 1.ABC����ȫ����
>�г���ĸABCȫ���е��������

---

��Ŀ������  
1. ���ַ���ת��Ϊchar����  
2. �ݹ�ʽ��ͨ��ָ��λ�ã�����λ����������λ�ý���
3. ִ����һ������ִ����֮����л���
4. �����ǵ�ָ��ָ�����һ������ʱ��

```java
	static char[] arr="ABCD".toCharArray();
	public static void main(String[] args) {
		f(0);
	}

	public static void f(int point) {
		if (point==arr.length) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]);
			}
			System.out.println();
			return;
		}
		
		for (int i = point; i < arr.length; i++) {
			char temp=arr[point];
			arr[point]=arr[i];
			arr[i]=temp;
			f(point+1);
			temp=arr[point];
			arr[point]=arr[i];
			arr[i]=temp;
		}
	}
```
[Դ��](../SourceCode/ABC_Full.java)

---