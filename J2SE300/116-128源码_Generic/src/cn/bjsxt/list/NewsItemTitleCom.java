package cn.bjsxt.list;
/**
 * ���������ҵ����
 * @author Administrator
 *
 */
public class NewsItemTitleCom implements java.util.Comparator<NewsItem>{
	//�����������
	@Override
	public int compare(NewsItem o1, NewsItem o2) {
		if(o1==o2){
			return 0;
		}
		if(o1==null ){
			if(null !=o2){
				return -1;
			}else{
				return 0;
			}
		}else{
			if(null==o2){
				return 1;
			}else{
				//�Ƚϱ���
				return -(o1.getTitle().compareTo(o2.getTitle()));
			}
		}
		
	}

}
