package cn.bjsxt.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * ʹ���ַ��� ����ǩ��:�ӽ����Ͻ��� ������Ա������ ���� HashSet��
	����:�����������

 * @author Administrator
 *
 */
import java.util.Scanner;
public class SetDemo03 {
	private Scanner sc ;
	private Set<String> members;
	private static String[] args;
	SetDemo03(){
		sc = new Scanner(System.in);
		members= new HashSet<String>();
	}
	public String getStringFromConsole(){
		return sc.nextLine();
	}	
	
	//ǩ��:
	public void addMemeber(String name){
		members.add(name);
	}
	//����:�����������
	public void showMemeber(){
		Iterator<String> it = members.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SetDemo03 demo = new SetDemo03();
		System.out.println("====ǩ��======");
		while(true){
			String name =demo.getStringFromConsole();
			if(name.equalsIgnoreCase("over")){
				break;
			}
			demo.addMemeber(name);
		}
		System.out.println("=========�λ���Ա��====");
		demo.showMemeber();
		
	}

}
