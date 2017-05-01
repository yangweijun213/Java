package cn.bjsxt.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
/**
һ�����
add(int index, E element)  ָ��λ����Ӷ���
 �����鿴
get(int index) ָ��λ�û�ȡԪ��
�����޸�|����Ԫ��
set(int , E) ָ��λ�ø��� 
�ġ�ɾ��
remove(int index) ָ��λ��ɾ��
�塢����
1��for
2��listIterator

 * @author Administrator
 *
 */
public class ListDemo01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Fruit> list = new ArrayList<Fruit>();
		create(list);
		System.out.println(list.size());
		retrieve(list);
		update(list);
		delete(list);
		
		list.clear();
		create(list);
		iterCol(list);
	}
	/**
	 * ��������
	 */
	public static void iterCol(List<Fruit> list){
		System.out.println("=========��ǿfor foreach �������±�======");
		for(Fruit temp:list){
			System.out.println(temp);
		}
		System.out.println("=========������======");
		Iterator<Fruit>  it =list.iterator();
		while(it.hasNext()){
			Fruit temp =it.next();
			System.out.println(temp);
		}
		
		System.out.println("========��ͨfor +get+size=======");
		int size =list.size();
		for(int i=0;i<size;i++){
			System.out.println("�±�Ϊ:"+i+",����Ϊ:"+list.get(i));
		}
		
		System.out.println("========listiterator=======");
		ListIterator<Fruit> it2 =list.listIterator();
		//�������
		while(it2.hasNext()){ //�жϣ������ƶ�
			it2.next();
		}
		System.out.println("�������");
		while(it2.hasPrevious()){
			System.out.println(it2.previous());
		}
		
		
	}
	
	
	/**
	 * �޸�Ԫ��
	 * @param list
	 */
	public static void update(List<Fruit> list){
		System.out.println("before==>"+list.get(1));
		list.set(4,new Fruit());
		System.out.println("after==>"+list.get(1));
		
	}
	
	
	/**
	 *ɾ��
	 * 1��remove(����)
	 * 2��clear() �������
	 * 3��remove(ָ������)
	 * @param col
	 */
	public static void delete(List<Fruit> list){
		boolean flag =list.remove(new Fruit(5,6));
		System.out.println(flag);
		Fruit f1 =list.remove(0);
		System.out.println(f1);
		
		
	}
	
	/**
	 * �鿴
	 * 1����С
	 * 2���鿴
	 * 3���Ƿ�Ϊ��
	 * 4��
	 * @param col
	 */
	public static void retrieve(List<Fruit> list){
		System.out.println("�����Ĵ�С:"+list.size());
		System.out.println("�鿴"+list.contains(new Fruit(2,20)));
		System.out.println("�����Ƿ����Ԫ��"+list.isEmpty());
		
		Fruit fruit =list.get(0); //ָ��λ�ò鿴
		System.out.println(fruit);
	}
	
	
	/**
	 * ���Ԫ��
	 * 1��������������
	 * 2��������ָ��λ�����Ԫ��
	 * @param col
	 */
	public static void create(List<Fruit> col){
		col.add(new Fruit(1,20));
		col.add(new Fruit(2,20));
		col.add(0,new Fruit(3,20)); // ����Ԫ��
		col.add(3,new Fruit(4,20));
		//col.add(5,new Fruit(1,20)); //��������Խ��
		col.add(4,new Fruit(5,20));
	}

}
