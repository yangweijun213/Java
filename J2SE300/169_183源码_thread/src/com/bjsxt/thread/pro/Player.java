package com.bjsxt.thread.pro;
/**
 * ������
 * @author Administrator
 *
 */
public class Player implements Runnable {
	private Movie m ;
	
	public Player(Movie m) {
		super();
		this.m = m;
	}

	@Override
	public void run() {
		for(int i=0;i<20;i++){
			if(0==i%2){
				m.play("������");
			}else{
				m.play("�Ұ׻�");
			}
		}
	}

}
