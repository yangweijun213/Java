package priv.practices.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class generateUniqueID {
	
	/**
	 * generate Unique ID (format: yymmddhhmmss) 
	 * @author jeff yang
	 *
	 */
	public static void main(String args[]) {
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
		String uniqueID = sdf.format(date);
		
		System.out.println(uniqueID);
	}

}
