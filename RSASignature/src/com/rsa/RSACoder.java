package com.rsa;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;

public class RSACoder extends Coder {
	//RSA���ܽ����ྲ̬����
	public static final String KEY_ALGORTHM="RSA";//
	public static final String SIGNATURE_ALGORITHM="MD5withRSA";
	
	public static final String PUBLIC_KEY = "RSAPublicKey";//��Կ
	public static final String PRIVATE_KEY = "RSAPrivateKey";//˽Կ

	/**
	 * ��ʼ����Կ
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> initKey() throws Exception {
		//��������ָ���㷨�� public/private ��Կ�Ե� KeyPairGenerator ���� ʹ��RSA�㷨
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORTHM);
		//��Կ�ĳ�ʼ������Ϊ1024λ����Կ�ĳ���Խ������ȫ�Ծ�Խ�ã����Ǽ��ܽ������õ�ʱ��ͻ�Խ��
		keyPairGenerator.initialize(1024);
		//ͨ���� KeyPairGenerator ����� generateKeyPair ��������һ����Կ��
		KeyPair keyPair = keyPairGenerator.generateKeyPair();

		// ���ɹ�Կ
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		// ����˽Կ
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
		
		//��Կ��˽Կ����map
		Map<String, Object> keyMap = new HashMap<String, Object>(2);
		keyMap.put(PUBLIC_KEY, publicKey);
		keyMap.put(PRIVATE_KEY, privateKey);

		return keyMap;
	}
	
	/**
	 * ȡ�ù�Կ����ת��ΪString����
	 * @param keyMap
	 * @return
	 * @throws Exception
	 */
	public static String getPublicKey(Map<String, Object> keyMap)throws Exception{
		Key key = (Key) keyMap.get(PUBLIC_KEY);  
		return encryptBASE64(key.getEncoded());     
	}

	/**
	 * ȡ��˽Կ����ת��ΪString����
	 * @param keyMap
	 * @return
	 * @throws Exception
	 */
	public static String getPrivateKey(Map<String, Object> keyMap) throws Exception{
		Key key = (Key) keyMap.get(PRIVATE_KEY);  
		return encryptBASE64(key.getEncoded());     
	}
	
	/**
	 * ��˽Կ����
	 * @param data	��������
	 * @param key	��Կ
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptByPrivateKey(byte[] data,String key)throws Exception{
		//������Կ
		byte[] keyBytes = decryptBASE64(key);
		//ȡ˽Կ, ���� ASN.1 ���� PrivateKeyInfo ���б����ר����Կ�� ASN.1 ����
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
		//��Կ�������ڽ���Կ��Key ���͵Ĳ�͸��������Կ��ת������Կ�淶���ײ���Կ���ϵ�͸����ʾ����
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORTHM);
		//�����ṩ����Կ�淶����Կ���ϣ�����˽Կ����
		Key privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
		
		//�����ݼ���
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		//ENCRYPT_MODE, ���ڽ� Cipher ��ʼ��Ϊ����ģʽ�ĳ���
		cipher.init(Cipher.ENCRYPT_MODE, privateKey);
		//�������ֲ������ܻ��������
		return cipher.doFinal(data);
	}
	
	/**
	 * ��˽Կ���� * @param data 	��������
	 * @param key	��Կ
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptByPrivateKey(byte[] data,String key)throws Exception{
		//��˽Կ����
		byte[] keyBytes = decryptBASE64(key);
		
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORTHM);
		Key privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
		//�����ݽ���
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		
		return cipher.doFinal(data);
	}
	
	/**
	 * �ù�Կ����
	 * @param data	��������
	 * @param key	��Կ
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptByPublicKey(byte[] data,String key)throws Exception{
		//�Թ�Կ����
		byte[] keyBytes = decryptBASE64(key);
		//ȡ��Կ, �����ʾ���� ASN.1 ���� SubjectPublicKeyInfo ���б���Ĺ�����Կ�� ASN.1 ����
		X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORTHM);
		Key publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
		
		//�����ݽ���
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		
		return cipher.doFinal(data);
	}
	
	/**
	 * �ù�Կ����
	 * @param data	��������
	 * @param key	��Կ
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptByPublicKey(byte[] data,String key)throws Exception{
		//��˽Կ����
		byte[] keyBytes = decryptBASE64(key);
		X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORTHM);
		Key publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
		
		//�����ݽ���
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, publicKey);
		
		return cipher.doFinal(data);
	}
	
	/**
	 *	��˽Կ����Ϣ��������ǩ��
	 * @param data	//��������
	 * @param privateKey	//˽Կ
	 * @return
	 * @throws Exception
	 */
	public static String sign(byte[] data,String privateKey)throws Exception{
		//����˽Կ
		byte[] keyBytes = decryptBASE64(privateKey);
		//����PKCS8EncodedKeySpec����
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
		//ָ�������㷨
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORTHM);
		//ȡ˽Կ�׶���
		PrivateKey privateKey2 = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
		//��˽Կ����Ϣ��������ǩ��
		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initSign(privateKey2);
		signature.update(data);
		
		return encryptBASE64(signature.sign());
	}
	
	/**
	 * У������ǩ��
	 * @param data	��������
	 * @param publicKey	��Կ
	 * @param sign	����ǩ��
	 * @return
	 * @throws Exception
	 */
	public static boolean verify(byte[] data,String publicKey,String sign)throws Exception{
		//���ܹ�Կ
		byte[] keyBytes = decryptBASE64(publicKey);
		//����X509EncodedKeySpec����
		X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
		//ָ�������㷨
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORTHM);
		//ȡ��Կ�׶���
		PublicKey publicKey2 = keyFactory.generatePublic(x509EncodedKeySpec);
		
		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initVerify(publicKey2);
		signature.update(data);
		//��֤ǩ���Ƿ�����
		return signature.verify(decryptBASE64(sign));
		
	}
	
	
}
