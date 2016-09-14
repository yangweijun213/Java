package priv.practices.输入输出IO操作;

import java.io.*;

public class RelativePath {
	
	public static void main(String[] args) 
    {
		String content =null;
		
		 try
	        {
				InputStream f = RelativePath.class.getClassLoader().getResourceAsStream("a.html");
				InputStreamReader reader = new InputStreamReader(f, "UTF-8");
	      
	            StringBuffer sb = new StringBuffer();
	            
	            //当readline到了流结尾时（readline取到null时），自动会结束while循环
	            while (reader.ready()) {
	    			sb.append((char) reader.read());
	    			// 转成char加到StringBuffer对象中
	    		}
	            
	            content = sb.toString();
	            System.out.println(content);
	            
	            reader.close();
	             
	        } catch (FileNotFoundException e)
	        {
	            e.printStackTrace();
	        } catch (IOException e)
	        {
	            e.printStackTrace();
	        }
    }

}
