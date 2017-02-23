package com.jun.peformance;

import java.io.File;

/**
 * @author jeff yang 
 * ��ȡ�ļ�ϵͳ����Ϣ
 *
 */
public class GetFileSystem {

	public static void main(String[] args) {
		File[] roots = File.listRoots();
		for (File root : roots) {
			System.out.println("total space of " + root.getAbsolutePath() + root.getTotalSpace());
			System.out.println("free space of " + root.getAbsolutePath() + root.getFreeSpace());
			System.out.println("usable space of " + root.getAbsolutePath() + root.getUsableSpace());
		}
	}
}
