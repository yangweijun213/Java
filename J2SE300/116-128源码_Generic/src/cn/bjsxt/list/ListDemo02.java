package cn.bjsxt.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
/**
 * �������͵�����  �����Լ���дð������
 * 1��ʵ����ʵ�ֽӿ� java.lang.Comparable ��дCompareTo
 *   List +Collections����
 * 2���ṩ��������ҵ���� ʵ��java.util.Comparator ��дcompare����
 *   1)һ��ҵ��һ���������
 *   2)Դ���벻���޸�
 *   3)ҵ����ʵ�ַ���
 *   
 * @author Administrator
 *
 */
public class ListDemo02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		System.out.println("abc".compareTo(new String("��abc"))); 
		System.out.println("dabc".compareTo("defg")); //��ͷ��ʼ�ķ��Ӵ������ص�һ����ͬ��unicode��֮��
		System.out.println("abc".compareTo("abcddasf")); //����֮�� ��ͷ��ʼ���Ӵ�
		
		
		
		
		List<NewsItem> news = new ArrayList<NewsItem>();
		news.add(new NewsItem(" ϰ��ƽ����Ա���ͨ�� ����|�Һ˹����������ɽ��",new Date(System.currentTimeMillis()-24*60*60*1000),800));
		news.add(new NewsItem(" ˹ŵ�ǵֶ� �����Ѷ�϶��",new Date(),200));
		//�����������
		NewsItemClickCom clickComp = new NewsItemClickCom();
		Collections.sort(news,clickComp);
		for(NewsItem temp:news){
			System.out.println(temp);
		}
		
		Collections.sort(news,new NewsItemTitleCom());
		for(NewsItem temp:news){
			System.out.println(temp);
		}
		
		
	}
	public static void sort1(){
		List<NewsItem> news = new LinkedList<NewsItem>();
		news.add(new NewsItem(" ϰ��ƽ����Ա���ͨ�� ����|�Һ˹����������ɽ��",new Date(System.currentTimeMillis()-24*60*60*1000),100));
		news.add(new NewsItem(" ˹ŵ�ǵֶ� �����Ѷ�϶��",new Date(),200));
		
		//��ʱ�䵹��
		//˼·һ����ŵ�������
		NewsItem[] newsArray = news.toArray(new NewsItem[0]);
		System.out.println("����ǰ"+Arrays.toString(newsArray));
		
		//ð������
		boolean sorted = true;
		for(int i=0;i<newsArray.length-1;i++){
			 sorted = true;
			for(int j=0;j<newsArray.length-1-i;j++){
				if(newsArray[j].compareTo(newsArray[j+1])>0){
					NewsItem temp =newsArray[j];
					newsArray[j] =newsArray[j+1];
					newsArray[j+1] =temp;
					sorted = false;
				}
			}
			if(sorted){
				break;
			}
		}
		System.out.println("�����"+Arrays.toString(newsArray));
		
		
		news = new ArrayList<NewsItem>();
		news.add(new NewsItem(" ϰ��ƽ����Ա���ͨ�� ����|�Һ˹����������ɽ��",new Date(System.currentTimeMillis()-24*60*60*1000),100));
		news.add(new NewsItem(" ˹ŵ�ǵֶ� �����Ѷ�϶��",new Date(),200));
		//ʹ�� Arrays.sort();
		newsArray = news.toArray(new NewsItem[0]);
		System.out.println("����ǰ"+Arrays.toString(newsArray));
		Arrays.sort(newsArray);
		System.out.println("�����"+Arrays.toString(newsArray));
		
		
		//Collections 
		news = new ArrayList<NewsItem>();
		news.add(new NewsItem(" ϰ��ƽ����Ա���ͨ�� ����|�Һ˹����������ɽ��",new Date(System.currentTimeMillis()-24*60*60*1000),100));
		news.add(new NewsItem(" ˹ŵ�ǵֶ� �����Ѷ�϶��",new Date(),200));
	
		Collections.sort(news);
		System.out.println("==============");
		for(NewsItem temp:news){
			System.out.println(temp);
		}
	}
}
