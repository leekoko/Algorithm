# 1. ����

---

## 1.��100002������
>���100002�������Ƕ��٣�

---

��Ŀ������  
������Ҫ�����ַ�ʽ���м��٣�  
1. ��������������������  
2. ������mol��ֵ���������������������ÿ��ǣ��Ѿ��������������ˣ�����Ҫ����������������棨�����ǵü��ϣ�  
3. ����������������С�ڱ�mol��������ƽ�������ÿ��ˣ����������  

```java
static ArrayList<Integer> al;
public static void main(String[] args) {
	al=new ArrayList<Integer>();
	al.add(2);
	al.add(3);
	al.add(5);
	al.add(7);
	
	int count=4;
	
	for (int i = 11; ; i+=2) {
		if(isPrime(i)){
			count++;
			if(count==100002){
				System.out.println(i);
				return;
			}
		}
		
	}
}

private static boolean isPrime(int num) {
	for (int j = 0; j < al.size(); j++) {
		if(num%al.get(j)==0){
			return false;
		}
		if(num<al.get(j)*al.get(j)){
			break;
		}
	}
	al.add(num);
	return true;
}
```
[Դ��](../SourceCode/Prime100002.java)

---


