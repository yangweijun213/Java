package com.jun.abstractclass;

public class TestAbstractClass {
	
	public static void main(String[] args) {
		//�����಻��ʵ������������new��ʵ����������
		Computer computer = new Laptop();
		
	}

}

//������, û�о����ʵ�� ���������󷽷����ࣩ
abstract class Computer{
	//�ķ����ǳ���ģ�û�о���ķ���ʵ��. �����ķ���������д
	//����淶
	abstract public void startup();
	abstract public void shutdown();
	
	//����ʵ��
	public void cal() {
		System.out.println("���ڼ���");
	}
}

//���������д����ĳ��󷽷�
class Laptop extends Computer{
	
	@Override  //���������򿴡�������������������
	public void shutdown() {  //���������
		
	}

	@Override
	public void startup() {
		// TODO Auto-generated method stub  //���˿�
		
	}
}

//���������д����ĳ��󷽷�
class Mobile extends Computer {

	@Override
	public void startup() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub
		
	}
	
}