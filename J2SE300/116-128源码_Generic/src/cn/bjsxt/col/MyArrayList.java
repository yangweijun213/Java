package cn.bjsxt.col;
/**
 * �򻯵�����ԭ��
 * hasNext
 * next
 * @author Administrator
 *
 */
public class MyArrayList {
	private String[] elem ={"a","b","c","d","e","f","g"};
	private int size = elem.length;
	
	
	private int cursor =-1;
	/**
	 * �ж��Ƿ������һ��Ԫ��
	 * @return
	 */
	public boolean hasNext(){		
		return cursor+1<size;
	}
	/**
	 * ��ȡ��һ��Ԫ��
	 */
	public String next(){
		cursor++; //�ƶ�һ��
		return elem[cursor];
	}
	/**
	 * ɾ��Ԫ��
	 */
	public void remove(){
		
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyArrayList list = new MyArrayList();
		while(list.hasNext()){
			System.out.println(list.next());
		}
		
		list = new MyArrayList();
		while(list.hasNext()){
			System.out.println(list.next());
		}
	}

}
