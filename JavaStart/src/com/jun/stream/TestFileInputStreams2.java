package com.jun.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileInputStreams2  {
	

	//���ļ� - read(byte[)���������˻���أ�һ���ȡ
	static void testRead() {	
		FileInputStream fis = null;
		
		try {
			//ͨ����һ����ʵ���ļ�������������һ�� FileInputStream
			fis = new FileInputStream ("D:\\workspace\\Java\\JavaStart\\src\\com\\jun\\stream\\a.txt");
			
			//һ���ɱ���ַ�����, Ч�ʸ�,���ʹ��str+Ч�ʱȽϵ�
			StringBuilder sb = new StringBuilder();
			int temp=0;
			//�ֽ�����,���建��1k
			byte[] buf =new byte[1024];

			//����һ�� byte ����
			while ((temp=fis.read(buf))!= -1) {
				//����һ���µ� String,����:�ֽ�����,��ʼ,�ֽ������С
				String str =new String(buf, 0, temp);
				//����string
				sb.append(str);
				
			}
			
			//���ɱ��ַ�����ר���ַ�����ӡ����
			System.out.println(sb.toString());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				//����֮��Ҫ�ر�
				if (fis!=null){
					fis.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		
		//���ļ�
		testRead();
		
	}
}
