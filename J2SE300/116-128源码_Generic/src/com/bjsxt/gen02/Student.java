package com.bjsxt.gen02;
/**
 * ������:����ʱʹ�÷���
 * ��ĸ��
 * T  Type ��ʾ���͡� 
	K V �ֱ�����ֵ�е�Key Value�� 
	E ����Element�� 
 ʹ��ʱȷ������
 ע�⣺
 1������ֻ��ʹ���������ͣ����ܻ�������
 2����������ʱ��ĸ����ʹ�� ��̬����|��̬������
 * @author Administrator
 *
 * @param <T>
 */
public class Student<T1,T2> {
	private T1 javaScore;
	private T2 oracleScore;
	
	//��������ʱ����ʹ�� ��̬����|��̬������
	//private static T1 test;
	
	
	public T1 getJavaScore() {
		return javaScore;
	}




	public void setJavaScore(T1 javaScore) {
		this.javaScore = javaScore;
	}




	public T2 getOracleScore() {
		return oracleScore;
	}




	public void setOracleScore(T2 oracleScore) {
		this.oracleScore = oracleScore;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//ʹ��ʱָ������(��������)
		Student<String,Integer> stu = new Student<String,Integer> ();
		//1����ȫ�����ͼ��
		stu.setJavaScore("����");
		//2��ʡ��:����ת��
		int it =stu.getOracleScore(); //�Զ�����
	}

}
