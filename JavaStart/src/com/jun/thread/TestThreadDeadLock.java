package com.jun.thread;

/**
 * @author HP
 *
 */
public class TestThreadDeadLock {
	
	public static void main(String[] args) {
		
	}
	

}

//�����˺�
class Account {
	int money;
	String aname;
	public Account(int money, String aname) {
		super();
		this.money = money;
		this.aname = aname;
	}
}


//ģ��������
class Drawing extends Thread {
	int drawingNum; //ȡ����Ǯ
	Account account; //ҪȡǮ���˻�
	int expenseTotal; //�ܹ�ȡ��Ǯ��
	public Drawing(int drawingNum, Account account, int expenseTotal) {
		super();
		this.drawingNum = drawingNum;
		this.account = account;
		this.expenseTotal = expenseTotal;
	}
	@Override
	public void run() {
		
	}
	
	
	
	
}