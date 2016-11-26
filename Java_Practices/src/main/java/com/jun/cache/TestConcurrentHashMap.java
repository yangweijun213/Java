package com.jun.cache;

import java.util.concurrent.ConcurrentHashMap;

/*
 * ConcurrentHashMapʵ��һ�����ػ���
 * http://www.cnblogs.com/parryyang/p/5779984.html
 */

public class TestConcurrentHashMap {

	private static ConcurrentHashMap<String, String> cacheMap = new ConcurrentHashMap<>();

	/*
	 **
	 * ��ȡ����Ķ���
	 * 
	 * @param account
	 * 
	 * @return
	 */
	public static String getCache(String account) {

		account = getCacheKey(account);
		// ����������и��˺ţ��򷵻�value
		if (cacheMap.containsKey(account)) {
			return cacheMap.get(account);
		}
		// ���������û�и��˺ţ��Ѹ��ʺŶ��󻺴浽concurrentHashMap��
		initCache(account);
		return cacheMap.get(account);
	}

	/**
	 * ��ʼ������
	 * 
	 * @param account
	 */
	private static void initCache(String account) {
		// һ���ǽ������ݿ��ѯ������ѯ�Ľ�����л���
		cacheMap.put(account, "18013093863");
	}
	
	 /**
     * ƴ��һ������key
     * 
     * @param account
     * @return
     */
    private static String getCacheKey(String account) {
        return Thread.currentThread().getId() + "-" + account;
    }
    
    /**
     * �Ƴ�������Ϣ
     * 
     * @param account
     */
    public static void removeCache(String account) {
        cacheMap.remove(getCacheKey(account));
    }
    
    
    public static void main (String arg[]) {
    	
    	TestConcurrentHashMap concur = new TestConcurrentHashMap();
    	String account = "id";
    	concur.initCache(account);
    	concur.getCacheKey(account);
    	concur.getCache(account);
    //	concur.removeCache(account);
    		
    }
}
