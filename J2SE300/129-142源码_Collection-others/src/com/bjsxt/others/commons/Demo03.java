package com.bjsxt.others.commons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.ChainedClosure;
import org.apache.commons.collections4.functors.IfClosure;
import org.apache.commons.collections4.functors.WhileClosure;

/**
 ����ʽ��� Closure �հ� ��װ�ض���ҵ����
 1��Closure
 2��IfClosure  IfClosure.ifClosure(����,����1,����2)
 3��WhileClosure WhileClosure.whileClosure(����,����,��ʶ) 
 4��ChainedClosure.chainedClosure(�����б�);
 CollectionUtils.forAllDo(����,���������);
 * @author Administrator
 *
 */
public class Demo03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//basic();		
		ifClosure();
		//whileClosure();
		chainClosure();
	}
	/**
	 * ���ϼ�   �ȴ�����Ʒ������9�ۣ������ټ�20
	 */
	public static void chainClosure(){
		List<Goods> goodsList =new ArrayList<Goods>();
		goodsList.add(new Goods("javase��Ƶ",120,true));
		goodsList.add(new Goods("javaee��Ƶ",100,false));
		goodsList.add(new Goods("���¼�����Ƶ",80,false));
				
		//���ټ�20
		Closure<Goods> subtract=new Closure<Goods>(){
			public void execute(Goods goods) {
				if(goods.getPrice()>=100){
					goods.setPrice(goods.getPrice()-20);
				}
			}};
		//����
		Closure<Goods> discount=new Closure<Goods>(){
			public void execute(Goods goods) {
				if(goods.isDiscount()){
					goods.setPrice(goods.getPrice()*0.9);
				}
			}};	
		
	
			
		//��ʽ����
		Closure<Goods> chainClo=ChainedClosure.chainedClosure(discount,subtract);
		
		//����
		CollectionUtils.forAllDo(goodsList,chainClo);
		
		//�鿴�����������
		for(Goods temp:goodsList){
			System.out.println(temp);
		}
		
	}
	
	/**
	 * ȷ�����е�Ա�����ʶ�����10000,����Ѿ������Ĳ�������
	 */
	public static void whileClosure(){
		//����
		List<Employee> empList =new ArrayList<Employee>();
		empList.add(new Employee("bjsxt",20000));
		empList.add(new Employee("is",10000));
		empList.add(new Employee("good",5000));
		
		//ҵ���� ÿ������0.2 
		Closure<Employee> cols=new Closure<Employee>(){
			public void execute(Employee emp) {
				emp.setSalary(emp.getSalary()*1.2);
			}};
		
		//�ж�
		Predicate<Employee> empPre=new Predicate<Employee>(){
			@Override
			public boolean evaluate(Employee emp) {
				return emp.getSalary()<10000;
			}			
		};	
		//false ��ʾ while�ṹ ���жϺ�ִ��   true do..while ��ִ�к��ж�
		Closure<Employee> whileCols =WhileClosure.whileClosure(empPre, cols, false);
			
		//������
		CollectionUtils.forAllDo(empList, whileCols)	;
		
		//�����������
		Iterator<Employee> empIt=empList.iterator();
		while(empIt.hasNext()){
			System.out.println(empIt.next());
		}
	}
	/**
	 * ��ѡһ  ����Ǵ�����Ʒ������9�ۣ��������ټ�20
	 */
	public static void ifClosure(){
		List<Goods> goodsList =new ArrayList<Goods>();
		goodsList.add(new Goods("javase��Ƶ",120,true));
		goodsList.add(new Goods("javaee��Ƶ",100,false));
		goodsList.add(new Goods("���¼�����Ƶ",80,false));
				
		//���ټ�20
		Closure<Goods> subtract=new Closure<Goods>(){
			public void execute(Goods goods) {
				if(goods.getPrice()>=100){
					goods.setPrice(goods.getPrice()-20);
				}
			}};
		//����
		Closure<Goods> discount=new Closure<Goods>(){
			public void execute(Goods goods) {
				if(goods.isDiscount()){
					goods.setPrice(goods.getPrice()*0.9);
				}
			}};	
		
		//�ж�
		Predicate<Goods> pre=new Predicate<Goods>(){
			public boolean evaluate(Goods goods) {
				return goods.isDiscount();
			}}; 
			
		//��ѡһ
		Closure<Goods> ifClo=IfClosure.ifClosure(pre, discount,subtract);
		
		//����
		CollectionUtils.forAllDo(goodsList,ifClo);
		
		//�鿴�����������
		for(Goods temp:goodsList){
			System.out.println(temp);
		}
		
	}
	/**
	 * ��������
	 */
	public static void basic(){
		//����
		List<Employee> empList =new ArrayList<Employee>();
		empList.add(new Employee("bjsxt",20000));
		empList.add(new Employee("is",10000));
		empList.add(new Employee("good",5000));
		
		//ҵ����
		Closure<Employee> cols=new Closure<Employee>(){
			public void execute(Employee emp) {
				emp.setSalary(emp.getSalary()*1.2);
			}};
		
		//������
		CollectionUtils.forAllDo(empList, cols)	;
		
		//�����������
		Iterator<Employee> empIt=empList.iterator();
		while(empIt.hasNext()){
			System.out.println(empIt.next());
		}
	}

}
