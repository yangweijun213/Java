package cn.bjsxt.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * shuffle ϴ�� ����˳�� ģ�⶷��������
 * reverse()
 * binarySearch()
 * @author Administrator
 *
 */
public class CollectionsDemo02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> cards = new ArrayList<Integer>();
		//������
		for(int i=0;i<54;i++){
			cards.add(i);
		}
		//ϴ��
		Collections.shuffle(cards);
		//���� 
		List<Integer> p1 =new ArrayList<Integer>();
		List<Integer> p2 =new ArrayList<Integer>();
		List<Integer> p3 =new ArrayList<Integer>();
		for(int i=0;i<cards.size()-3;i+=3){
			p1.add(i);
			p3.add(i+1);
			p2.add(i+2);
		}
		
		
		List<Integer> last =new ArrayList<Integer>();
		last.add(cards.get(54-1));
		last.add(cards.get(54-2));
		last.add(cards.get(54-3));
		
		
		//���
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(last);
		
		
		
		List list =new ArrayList();
		list.add(list);
		System.out.println(list);
	}

}
