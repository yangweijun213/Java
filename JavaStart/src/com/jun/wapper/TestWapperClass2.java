package com.jun.wapper;

public class TestWapperClass2 {
	
	public static void main(String[] args) {
		
		//�Զ�װ��, �൱��Integer aa2 = new Integer(33); �����������Ż�������new Integer(33)
		Integer aa =3;
		Integer aa2 = new Integer(33);
		
		//�Զ����䣬�������Զ������Ǽ��� new Integer(343).intValue();
		int d = new Integer(343);
		int d2 = new Integer(343).intValue();
		
		////С��100�����ֱȽ�
		Integer b1 = 888;
		Integer b2 = 888;
		
		Integer c1 =100;
		Integer c2 = 100;
		
		System.out.println(b1==b2);
		System.out.println(c1==c2);
	}

}
