package com.rsa;

import java.security.MessageDigest;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Coder {
	public static final String KEY_SHA = "SHA";   
    public static final String KEY_MD5 = "MD5"; 
    
    /**  
     * BASE64����  
     *   
     * @param key  
     * @return  
     * @throws Exception  
     */  
    
    public static byte[] decryptBASE64(String key) throws Exception {   
    	return (new BASE64Decoder()).decodeBuffer(key);
    }   
    
    /**  
     * BASE64����  
     *   
     * @param key  
     * @return  
     * @throws Exception  
     */  
    
    public static String encryptBASE64(byte[] key) throws Exception {   
        return (new BASE64Encoder()).encodeBuffer(key);   
    } 
    
    /**  
     * MD5����  
     *   
     * @param data  
     * @return  
     * @throws Exception  
     */  
    public static byte[] encryptMD5(byte[] data) throws Exception {   
  
        MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);   
        md5.update(data);   
  
        return md5.digest();   
  
    }   
    
    /**  
     * SHA����  
     *   
     * @param data  
     * @return  
     * @throws Exception  
     */  
    public static byte[] encryptSHA(byte[] data) throws Exception {   
  
        MessageDigest sha = MessageDigest.getInstance(KEY_SHA);   
        sha.update(data);   
  
        return sha.digest();   
  
    }   

}
