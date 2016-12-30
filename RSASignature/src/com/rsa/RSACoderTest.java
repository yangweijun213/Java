package com.rsa;

import static org.junit.Assert.*;

import org.junit.Before;   
import org.junit.Test;  

import java.util.Map; 

/** *//** 
*   
*   ʹ��Junit4 �����е�Ԫ���ԡ�
* @version 1.0 
* @since 1.0 
*/ 
public class RSACoderTest {   
    private String publicKey;   
    private String privateKey;   

    @Before 
    public void setUp() throws Exception {   
        Map<String, Object> keyMap = RSACoder.initKey();   

        publicKey = RSACoder.getPublicKey(keyMap);   
        privateKey = RSACoder.getPrivateKey(keyMap);   
        System.err.println("��Կ: \n\r" + publicKey);   
        System.err.println("˽Կ�� \n\r" + privateKey);   
    }   

    @Test 
    public void testPub2Pri() throws Exception {   
        System.err.println("��Կ���ܡ���˽Կ����");   
        String inputStr = "abc";   
        byte[] data = inputStr.getBytes();   

        byte[] encodedData = RSACoder.encryptByPublicKey(data, publicKey);   

        byte[] decodedData = RSACoder.decryptByPrivateKey(encodedData,   
                privateKey);   

        String outputStr = new String(decodedData);   
        System.err.println("����ǰ: " + inputStr + "\n\r" + "���ܺ�: " + outputStr);   
        assertEquals(inputStr, outputStr);   

    }   

    @Test 
    public void testPri2Pub() throws Exception {   
        System.err.println("˽Կ���ܡ�����Կ����");   
        String inputStr = "sign";   
        byte[] data = inputStr.getBytes();   

        byte[] encodedData = RSACoder.encryptByPrivateKey(data, privateKey);   

        byte[] decodedData = RSACoder.decryptByPublicKey(encodedData, publicKey);   

        String outputStr = new String(decodedData);   
        System.err.println("����ǰ: " + inputStr + "\n\r" + "���ܺ�: " + outputStr);   
        assertEquals(inputStr, outputStr);    //ʹ��Junit���ԣ�����ǰ��ԭ������ܺ�������Ƿ�һ�¡� 

        System.err.println("˽Կǩ��������Կ��֤ǩ��");   
        // ����ǩ��   �����encodedData�����������encodedDataͬʱ����new int[]{2,45}
        String sign = RSACoder.sign(encodedData, privateKey); //����ǩ��ֻҪ��Կ���õ�ǩ����sign�Ա�
        //���Լ���Կͨ��ͬ����byte[]����õ�ǩ���Ƿ�һ�¡��ǵ��´��������Կ���ǶԵģ�����Ϊ���ڷ�˽Կ�˷���ġ�
        System.err.println("ǩ��:\r" + sign);   

        // ��֤ǩ��   
        boolean status = RSACoder.verify(encodedData, publicKey, sign);   
        System.err.println("״̬:\r" + status);   
        assertTrue(status);   

    }   

} 