package com.jun.operation;

public class TestOperation {
	
	public static void main(String[] args) {
		
		//��������,˭����˭
		int a=3;
		long b=4;
		long c =a*b;
		
		//����һԪ�����
		int i=4;
		//���
		i--;
		//�ȼ�
		--i;
		
		//��λ��,����λ�����, �����Ƶ�true/false, 1->true, 0 -> false
		int j=3&2;
		System.out.println(j);
		//��λ��
		int g=3|2;
		System.out.println(g);
		
		//��λ,��λ���
		int bb=3<<2; //�൱��3*2*2
		System.out.println(bb);
				
		//�����ַ������ӷ�,�Ӻ�����ֻҪ��һ���ַ�,�����ַ�
		System.out.println(""+3+4); //34
		System.out.println(3+4+""); //7
		
		//������Ŀ�����,x?y:z �������� 
		int aa=1;
		int bbb=2;
	    System.out.println((aa<bbb)?"aa<bbb":"aa>bbb");
	}

}
