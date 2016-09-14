package priv.practices.log4j;
import org.apache.log4j.*;


/**
 * @author Jeff Yang
 *
 */
public class TestLog4j {
	
	//取得logger
	static Logger logger = Logger.getLogger(TestLog4j.class);  

	/** 
     * @param args 
     */  
    public static void main(String[] args) {  
        
    	//我想把log4j.properties放在其他目录中，这样一来，在修改log4j配置文件的时候无需重新打jar包。 
		PropertyConfigurator.configure(System.getProperty("user.dir") + "/conf/log4j.properties"); 

        // 记录debug级别的信息  
        logger.debug("This is debug message.");  
        // 记录info级别的信息  
        logger.info("This is info message.");  
        // 记录error级别的信息  
        logger.error("This is error message.");  
    }  

}
