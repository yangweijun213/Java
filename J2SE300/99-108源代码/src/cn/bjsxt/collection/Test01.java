package cn.bjsxt.collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ����List�еĻ�������
 * @author Administrator
 *
 */
public class Test01 {

	public static void main(String[] args) {
		List list = new ArrayList();
		//ArrayList:�ײ�ʵ��ʱ����,�̲߳���ȫ��Ч�ʸߡ����ԣ���ѯ�졣�޸ġ����롢ɾ������
		//LinkedList:�ײ�ʵ��������,�̲߳���ȫ��Ч�ʸߡ����ԣ���ѯ�����޸ġ����롢ɾ���졣
		//Vector:�̰߳�ȫ�ģ�Ч�ʵ͡�
		
		list.add("aaa");
		list.add("aaa");
		list.add(new Date());
		list.add(new Dog());
		list.add(1234);  //��װ��ģ��Զ�װ�䣡
		list.remove(new String("aaa"));
		System.out.println(list.size());
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i)); 
		}
		
		list.set(3, new String("3333"));
		list.add(4, new String("3333"));
/*		System.out.println(list.isEmpty());
		list.remove(new Dog());      //hashcode��equals
		System.out.println(list.size());
		
		List list2 = new ArrayList();
		list2.add("bbb");
		list2.add("ccc");
		
		list.add(list2);
		
		//��˳��Ĳ���
		String str = (String) list.get(0);
		System.out.println(str); 
		list.set(1, "ababa");
		list.remove(0);*/
		
 	}

}

class Dog {
	
}