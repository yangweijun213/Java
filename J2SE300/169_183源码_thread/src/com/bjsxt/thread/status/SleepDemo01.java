package com.bjsxt.thread.status;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ����ʱ
 * 1������10������һ���ڴ�ӡһ��
 * 2������ʱ
 * @author Administrator
 *
 */
public class SleepDemo01 {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Date endTime =new Date(System.currentTimeMillis()+10*1000);
		long end =endTime.getTime();
		while(true){
			//���
			System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
			//�ȴ�һ��
			Thread.sleep(1000);
			//������һ��ʱ��
			endTime =new Date(endTime.getTime()-1000);
			//10������ ���� ���� �˳�
			if(end-10000>endTime.getTime()){
				break;
			}
		}
		
		
		
		
	}
	public static void test1() throws InterruptedException{
		int num =10;
		while(true){
			System.out.println(num--);
			Thread.sleep(1000); //��ͣ
			if(num<=0){
				break;
			}
		}
	}
	

}
