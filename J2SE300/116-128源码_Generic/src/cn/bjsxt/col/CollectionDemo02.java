package cn.bjsxt.col;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * ������ɸ�Ա�������Ա�����ܹ��ʣ�ƽ������
 * @author Administrator
 *
 */
public class CollectionDemo02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Collection<Employee> co=new ArrayList<Employee>();
		Employee ee = new Employee("����",199999);
		co.add(ee);
		co.add(ee);
		co.add(new Employee("�ϸ�",99999));
		co.add(new Employee("����",1099999));
		
		//����
		Iterator<Employee> it = co.iterator();
		double total =0.0;
		while(it.hasNext()){
			Employee temp = it.next();
			total +=temp.getSalary();
		}
		int size =co.size();
		System.out.println(size);
		System.out.println("�ܹ���Ϊ:"+total+",ƽ��нˮ"+total/size);
		
	}

}
