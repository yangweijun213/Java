package cn.bjsxt.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/**
 * Ĭ�ϵ�hashcodeʱ��ַת���룬��Ҫ��д
 * �ȱȽ�hashcode 
 * �ٱȽ�equals
 * 
 * @author Administrator
 *
 */
public class SetDemo01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Food food1 = new Food("����",5);
		Food food2 = new Food("�ǹ�",10);
		Food food3 = new Food("����",5);
		Food food4 = new Food("����2",5);
		Set<Food> set = new HashSet<Food>();
		set.add(food1);
		set.add(food1);
		set.add(food2);
		set.add(food3);
		set.add(food4);
		System.out.println(set.size());
		
		
		
		System.out.println("===foreach=====");
		for(Food temp:set){
			System.out.println(temp.getPrice()+"-->"+temp.getName());
		}
		System.out.println("======iterator=========");
		Iterator<Food> it =set.iterator();
		while(it.hasNext()){ //�жϣ������ƶ��α� |ָ�� 
			Food temp =it.next(); //һ���ƶ�һ���α� �����ƶ����
			//System.out.println(it.next().getPrice()+"-->"+it.next().getName()); 
			System.out.println(temp.getPrice()+"-->"+temp.getName());
		}
		
		
	}

}
