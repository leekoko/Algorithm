# ������ݴ���

�������������һЩ����֪ʶ

---

## 1.���ֻ�����ͬ
���ֻ�����ͬ������������ű꣬����¼���������û�г��ֹ�

���⣺�ж�3,4,2,1,6,0,5,3ÿ�����ֳ��ֵĴ���

public static void main(String[] args) {
	int[] arr=new int[20];
	int[] num={3,4,2,1,6,0,5,3};
	for (int i = 0; i < num.length; i++) {
		arr[num[i]]=1;
	}
	int count=0;   //�ж��������ֵĸ���
	for (int i = 0; i < arr.length; i++) {
		if(arr[i]==1){
			count++;			
		}
	}
	System.out.println(count);
}


---


