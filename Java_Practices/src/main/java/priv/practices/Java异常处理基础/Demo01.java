package priv.practices.Java异常处理基础;

/**
 * @author http://blog.csdn.net/wangyang1354/article/details/8062765
 * 使用 try-catch-final 语句对程序中的异常进行捕获与处理
 */


import java.io.*;  

public class Demo01   
{  
    public static void main(String[] args)   
    {  
    	int i;
    	int a[] = {1,2,3,4};
    	for (i=0;i<5;i++) {
    		try {
    			System.out.print("a["+i+"]/"+i+"="+(a[i]/i));
    		}
    		catch (ArrayIndexOutOfBoundsException e) {
    			System.out.println("捕捉到了 数组 下标 越界 异常");
    		}
    		
    		catch (ArithmeticException e) {
    			System.out.println("异常名称是："+e);
    		}
    		catch (Exception e) {
    			System.out.println("捕获"+e.getMessage()+"异常!");
    		}
    		finally {
    			System.out.println("final i="+i);
    		}
    	}
    	System.out.println("继续！！");
    }
        
}  
