package com.bjsxt.gen04;
/**
 * ��̬��������ʽ
 * @author Administrator
 *
 */
public class FruitApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Fruit f =new Apple();
		test(new Apple());
	}
	//�β�ʹ�ö�̬
	public static void test(Fruit f){
		
	}
	//��������ʹ�ö�̬
	public static Fruit  test2(){
		return new Apple();
	}

}
