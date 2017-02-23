package com.jun.peformance;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.Set;

/**
 * @author jeff yang ��ȡϵͳ���Ե���ݣ�Ȼ��������ı��ļ�
 *         �ο���https://my.oschina.net/zhxm/blog/60110
 */
public class GetSystemProperities {

	public static void main(String[] args) throws Exception {
		// ͨ��StringBuilder������Ҫ���������
		StringBuilder sb = new StringBuilder();
		sb.append("Java ����ʱ�����汾:" + System.getProperty("java.version") + "\n");
		sb.append("Java ����ʱ������Ӧ��:" + System.getProperty("java.vendor") + "\n");
		sb.append("Java ��Ӧ�̵�URL:" + System.getProperty("java.vendor.url") + "\n");
		sb.append("Java ��װĿ¼:" + System.getProperty("java.home") + "\n");
		sb.append("Java �����淶�汾:" + System.getProperty("java.vm.specification.version") + "\n");
		sb.append("Java ���ʽ�汾��:" + System.getProperty("java.class.version") + "\n");
		sb.append("Java��·����" + System.getProperty("java.class.path") + "\n");
		sb.append("���ؿ�ʱ������·���б�:" + System.getProperty("java.library.path") + "\n");
		sb.append("Ĭ�ϵ���ʱ�ļ�·��:" + System.getProperty("java.io.tmpdir") + "\n");
		sb.append("Ҫʹ�õ� JIT �����������:" + System.getProperty("java.compiler") + "\n");
		sb.append("һ��������չĿ¼��·��:" + System.getProperty("java.ext.dirs") + "\n");
		sb.append("����ϵͳ�����:" + System.getProperty("os.name") + "\n");
		sb.append("����ϵͳ�ļܹ�:" + System.getProperty("os.arch") + "\n");
		sb.append("����ϵͳ�İ汾:" + System.getProperty("os.version") + "\n");
		sb.append("�ļ��ָ����� UNIX ϵͳ���ǡ�/����:" + System.getProperty("file.separator") + "\n");
		sb.append("·���ָ����� UNIX ϵͳ���ǡ�:����:" + System.getProperty("path.separator") + "\n");
		sb.append("�зָ����� UNIX ϵͳ���ǡ�/n����:" + System.getProperty("line.separator") + "\n");
		sb.append("�û����˻����:" + System.getProperty("user.name") + "\n");
		sb.append("�û�����Ŀ¼:" + System.getProperty("user.home") + "\n");
		sb.append("�û��ĵ�ǰ����Ŀ¼:" + System.getProperty("user.dir") + "\n");

		// �½�һ���ļ��������ļ��������򴴽�һ��
		File file = new File("d:\\t.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		OutputStream ous = new FileOutputStream(file);

		// ��ȡϵͳ������
		Properties ps = System.getProperties();
		// ���ϵͳ�����еļ�ֵ
		Set<String> set = ps.stringPropertyNames();
		for (String name : set) {
			sb.append(name + " : " + ps.getProperty(name) + "\n");
			System.out.println(name + " : " + ps.getProperty(name));
		}
		ous.write(sb.toString().getBytes());
		ous.close();

		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("os.version"));
		System.out.println("Java����ʱ�����汾:" + System.getProperty("java.version"));
		System.out.println("Java ����ʱ������Ӧ��:" + System.getProperty("java.vendor"));
		System.out.println("Java ��Ӧ�̵�URL:" + System.getProperty("java.vendor.url"));
		System.out.println("Java ��װĿ¼:" + System.getProperty("java.home"));
		System.out.println("Java �����淶�汾:" + System.getProperty("java.vm.specification.version"));
		System.out.println("Java ���ʽ�汾��:" + System.getProperty("java.class.version"));
		System.out.println("Java ��·����" + System.getProperty("java.class.path"));
		System.out.println("���ؿ�ʱ������·���б�:" + System.getProperty("java.library.path"));
		System.out.println("Ĭ�ϵ���ʱ�ļ�·��:" + System.getProperty("java.io.tmpdir"));
		System.out.println("Ҫʹ�õ� JIT �����������:" + System.getProperty("java.compiler"));
		System.out.println("һ��������չĿ¼��·��:" + System.getProperty("java.ext.dirs"));
		System.out.println("����ϵͳ�����:" + System.getProperty("os.name"));
		System.out.println("����ϵͳ�ļܹ�:" + System.getProperty("os.arch"));
		System.out.println("����ϵͳ�İ汾:" + System.getProperty("os.version"));
		System.out.println("�ļ��ָ����� UNIX ϵͳ���ǡ�/����:" + System.getProperty("file.separator"));
		System.out.println("·���ָ����� UNIX ϵͳ���ǡ�:����:" + System.getProperty("path.separator"));
		System.out.println("�зָ����� UNIX ϵͳ���ǡ�/n����:" + System.getProperty("line.separator"));
		System.out.println("�û����˻����:" + System.getProperty("user.name"));
		System.out.println("�û�����Ŀ¼:" + System.getProperty("user.home"));
		System.out.println("�û��ĵ�ǰ����Ŀ¼: " + System.getProperty("user.dir"));
	}

}
