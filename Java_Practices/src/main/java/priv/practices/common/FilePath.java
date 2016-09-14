package priv.practices.common;



/*根据java.io.File的Doc文挡，可知:
默认情况下new File("/")代表的目录为：System.getProperty("user.dir")。
一下程序获得执行类的当前路径*/

/**
 * @author http://www.iteye.com/topic/117978/
 *
 */
public class FilePath {
	
	public static void main(String[] args) throws Exception {  
        System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));  
  
        System.out.println(FilePath.class.getClassLoader().getResource(""));  
  
        System.out.println(ClassLoader.getSystemResource(""));  
        System.out.println(FilePath.class.getResource(""));  
        System.out.println(FilePath.class.getResource("/"));
        //Class文件所在路径
   //     System.out.println(new File("/").getAbsolutePath());  
        System.out.println(System.getProperty("user.dir"));  
    }  

}
