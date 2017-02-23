package com.jun.peformance;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author jeff yang ��ȡ������� �ο�: https://my.oschina.net/zhxm/blog/60110
 *
 */
public class GetNetwork {

	public static void main(String[] args) {
		InetAddress netAddress = getInetAddress();
		System.out.println("host ip:" + getHostIp(netAddress));
		System.out.println("host name:" + getHostName(netAddress));
	}

	/**
	 * ��ȡ��������
	 * 
	 * @return
	 */
	public static InetAddress getInetAddress() {
		try {
			return InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			System.out.println("unknown host!");
		}
		return null;
	}

	/**
	 * ͨ��InetAddress��ȡ����Ip
	 * 
	 * @param netAddress
	 * @return
	 */
	public static String getHostIp(InetAddress netAddress) {
		if (null == netAddress) {
			return null;
		}
		String ip = netAddress.getHostAddress();
		return ip;
	}

	/**
	 * ͨ��InetAddress��ȡ�������������
	 * 
	 * @param netAddress
	 * @return
	 */
	public static String getHostName(InetAddress netAddress) {
		if (null == netAddress) {
			return null;
		}
		String name = netAddress.getHostName();
		return name;
	}

}
