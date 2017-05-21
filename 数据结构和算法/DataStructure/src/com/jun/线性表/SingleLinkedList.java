package com.jun.线性表;

/*
 * http://www.jianshu.com/p/230e6fde9c75
 * 链表
 */
public class SingleLinkedList {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <E> void main(String[] args) {

		// 头节点和尾节点进行初始化
		Node<E> head = null;
		Node<E> tail = null;

		// 空链表创建一个新节点(只有一个节点)
		head = new Node("node1");
		// 让尾部指向此节点
		tail = head;

		// 链表追加一个节点
		tail.next = new Node("node2");
		tail = tail.next; // xx.next可以看成一个节点

		// 顺序遍历链表
		Node<E> current = head;
		while (current != null) {
			System.out.println("顺序遍历链表"+current.item);
			current = current.next;
		}
		
		//倒序遍历链表
		printListRev (head);
		
		//单链表反转
		Node<E> current2 = revList(head);
		while (current2 != null) {
			System.out.println("单链表反转"+current2.item);
			current2 = current2.next;
		}

	}

	// 倒序遍历链表
	static <E> void printListRev(Node<E> head) {
		//倒序遍历链表主要用了递归的思想
	    if (head != null) {
	        printListRev(head.next);
	        System.out.println(head.item);
	    }
	}
	
	//单链表反转 主要是逐一改变两个节点间的链接关系来完成
	static <E> Node<E> revList(Node<E> head) {

	    if (head == null) {
	        return null;
	    }

	    Node<E> nodeResult = null;
	    Node<E> nodePre = null;
	    Node<E> current = head;

	    while (current != null) {

	        Node<E> nodeNext = current.next;

	        if (nodeNext == null) {
	            nodeResult = current; //将整个单链表赋值打印
	        }
	        
	        //先将nodeNext反转current,然后第二次遍历，在反转current.
	        current.next = nodePre;
	        nodePre = current;
	        current = nodeNext;
	    }

	    return nodeResult;
	}

}

class Node<E> {
	E item;
	Node<E> next;

	// 构造函数
	Node(E element) {
		this.item = element;
		this.next = null;
	}
}
