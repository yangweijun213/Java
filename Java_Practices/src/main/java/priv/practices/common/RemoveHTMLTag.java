package priv.practices.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveHTMLTag {
	
	//remove <!--###Debug Setting###--> part from script template
	
	public static void main(String[] args)
	    {
	        FileReader fr;
	        String content =null;
	        String regex = "<!--###Debug Setting###-->[\\s\\S]*?<\\/tr>\n";

	        try
	        {
	            fr = new FileReader("AR_crawl_script_template - Copy.html");
	            BufferedReader br = new BufferedReader(fr);
	            String str = null;
	            StringBuffer sb = new StringBuffer();
	            
	            //当readline到了流结尾时（readline取到null时），自动会结束while循环
	            while((str = br.readLine()) != null)
	            {
	            	sb.append(str+"\n");
	            	
	            }
	            content = sb.toString();
	            System.out.println(content);
	            
	            br.close();
	             
	        } catch (FileNotFoundException e)
	        {
	            e.printStackTrace();
	        } catch (IOException e)
	        {
	            e.printStackTrace();
	        }
	        
	        // 创建 Pattern 对象
	        Pattern pattern = Pattern.compile(regex);
	        
	        // 现在创建 matcher 对象
	        Matcher matcher = pattern.matcher(content);
	       
	        StringBuffer sb1 = new StringBuffer();
	        while(matcher.find())
	        {
	            sb1.append(matcher.replaceFirst(""));      
	        	//System.out.println(matcher.group(0));
	            System.out.println(sb1);
	        }
	        try
	        {
	            FileWriter fw = new FileWriter("AR_crawl_script_template - Copy_new.html");
	            BufferedWriter bw = new BufferedWriter(fw);
	            fw.write(sb1.toString().replaceAll("\n\n", "").replaceAll("\n\n", ""));     
	            System.out.println(sb1.toString().replaceAll("\n\n", "").replaceAll("\n\n", ""));
	            
	            bw.close();
	        } catch (IOException e)
	        {
	            e.printStackTrace();
	        }
	    }

}
