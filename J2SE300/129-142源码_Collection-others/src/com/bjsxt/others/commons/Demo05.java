package com.bjsxt.others.commons;


import java.util.Queue;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.apache.commons.collections4.queue.PredicatedQueue;
import org.apache.commons.collections4.queue.UnmodifiableQueue;

/**
 Queue����
 1��ѭ������:CircularFifoQueue
 2��ֻ������:���ɸı����  UnmodifiableQueue
 3�����Զ���:PredicatedQueue.predicatedQueue()
 * @author Administrator
 *
 */
public class Demo05 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//circular();
		//readOnly();
		predicate();
	}
	/**
	 * ���Զ���
	 */
	public static void predicate(){
		//ѭ������
		CircularFifoQueue<String> que =new CircularFifoQueue<String>(2);
		que.add("a");
		que.add("b");
		que.add("c");
		Predicate notNull=NotNullPredicate.INSTANCE;
		//��װ�ɶ�Ӧ�Ķ���
		Queue<String> que2=PredicatedQueue.predicatedQueue(que, notNull);
		que2.add(null);
	}
	/**
	 * ֻ������
	 */
	public static void readOnly(){
		//ѭ������
		CircularFifoQueue<String> que =new CircularFifoQueue<String>(2);
		que.add("a");
		que.add("b");
		que.add("c");
		Queue<String> readOnlyQue =UnmodifiableQueue.unmodifiableQueue(que);
		readOnlyQue.add("d");
	}
	/**
	 * ѭ������
	 */
	public static void circular(){
		//ѭ������
		CircularFifoQueue<String> que =new CircularFifoQueue<String>(2);
		que.add("a");
		que.add("b");
		que.add("c");
		//�鿴
		for(int i=0;i<que.size();i++){
			System.out.println(que.get(i));
		}
		
	}

}
