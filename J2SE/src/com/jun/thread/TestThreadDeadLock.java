package com.jun.thread;

/**
 * @author HP
 *
 */
public class TestThreadDeadLock {
	
	public static void main(String[] args) {
		
	}
	

}

//银行账号
class Account {
	int money;
	String aname;
	public Account(int money, String aname) {
		super();
		this.money = money;
		this.aname = aname;
	}
}


//模拟提款操作
class Drawing extends Thread {
	int drawingNum; //取多少钱
	Account account; //要取钱的账户
	int expenseTotal; //总共取的钱数
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