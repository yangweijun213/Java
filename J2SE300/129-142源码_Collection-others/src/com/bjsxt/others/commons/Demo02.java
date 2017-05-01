package com.bjsxt.others.commons;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.SwitchTransformer;

/**
 ���ҵ�������жϽ��з���
 ����ʽ��� Transformer ����ת��
 1��new Transformer() +transform
 2��SwitchTransformer
 CollectionUtils.collect(����,ת����)
 * @author Administrator
 *
 */
public class Demo02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("===�Զ�������ת��==");
		//�б�ʽ
		Predicate<Employee> isLow=new Predicate<Employee>(){

			@Override
			public boolean evaluate(Employee emp) {
				return emp.getSalary()<10000;
			}
			
		};
		Predicate<Employee> isHigh=new Predicate<Employee>(){

			@Override
			public boolean evaluate(Employee emp) {
				return emp.getSalary()>=10000;
			}
			
		};
		Predicate[] pres ={isLow,isHigh};
		
		//ת��
		Transformer<Employee,Level> lowTrans =new Transformer<Employee,Level>(){

			@Override
			public Level transform(Employee input) {
				return new Level(input.getName(),"������");
			}};
		
		Transformer<Employee,Level> highTrans =new Transformer<Employee,Level>(){

			@Override
			public Level transform(Employee input) {
				return new Level(input.getName(),"������");
			}};
		Transformer[] trans ={lowTrans,highTrans};	
		
		//���߽����˹���
		Transformer switchTrans =new SwitchTransformer(pres, trans, null);
		
		//����
		List<Employee> list =new ArrayList<Employee>();
		list.add(new Employee("����",1000000));
		list.add(new Employee("����",999));
		
		Collection<Level> levelList = CollectionUtils.collect(list,switchTrans);
		
		
		//��������
		Iterator<Level> levelIt =levelList.iterator();
		while(levelIt.hasNext()){
			System.out.println(levelIt.next());
		}
		
	}
	/**
	 * �������͵�ת��
	 */
	public static void inner(){
		System.out.println("===��������ת��  ������ʱ�����ڣ�ת��ָ����ʽ���ַ���==");
		//����ת����
		Transformer<Long,String> trans =new Transformer<Long,String>(){

			@Override
			public String transform(Long input) {
				return new SimpleDateFormat("yyyy��MM��dd��").format(input);
			}};
		//����
		List<Long> list =new ArrayList<Long>();	
		list.add(999999999999L);
		list.add(300000000L);
		
		//������ ����Գ��Ǯ---������---ũ�񹤳���
		Collection<String>  result=CollectionUtils.collect(list, trans);
		//�����鿴���
		for(String time:result){
			System.out.println(time);
		}
	}

}
