package com.bjsxt.gen02;

import java.io.Closeable;
import java.io.IOException;

/**
 * ���ͷ��� <> ��������ǰ��
 * ֻ�ܷ��ʶ������Ϣ�������޸���Ϣ
 * @author Administrator
 *
 */
public class TestMethod {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test("a"); //T -->String
	}
	//���ͷ���
	public static <T> void test(T a){		
		System.out.println(a);
	}
	// extends <=
	public static <T extends Closeable> void test(T... a){		
		for(T temp:a){
			try {
				if(null!=temp){
					temp.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
