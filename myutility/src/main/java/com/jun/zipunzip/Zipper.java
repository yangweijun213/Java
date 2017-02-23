package com.jun.zipunzip;

import java.io.File;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Expand;
import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.ant.types.FileSet;

/**
 * 使用 apache ant 轻松实现文件压缩/解压缩 reference
 * http://www.cnblogs.com/zj0208/p/5977385.html
 */
public class Zipper {

	public final static String encoding = "UTF-8";

	/**
	 * 压缩文件和文件夹
	 * 
	 * @param srcPathname
	 *            需要被压缩的文件或文件夹路径
	 * @param zipFilepath
	 *            将要生成的zip文件路径
	 * @throws BuildException
	 * @throws RuntimeException
	 */
	public static void zip(String srcPathname, String zipFilepath) throws BuildException, RuntimeException {
		File file = new File(srcPathname);
		if (!file.exists()) {
			throw new RuntimeException("source file or directory " + srcPathname + " does not exist.");
		}

		//将project实例添加到文件集
		Project proj = new Project();
		FileSet fileSet = new FileSet();
		fileSet.setProject(proj);
		// 判断是目录还是文件
		if (file.isDirectory()) {
			fileSet.setDir(file);
			// ant中include/exclude规则在此都可以使用
			// 比如:
			 fileSet.setExcludes("**/*.txt");
			// fileSet.setIncludes("**/*.xls");
		} else {
			fileSet.setFile(file);
		}
		
		//new zip实例
		Zip zip = new Zip();
		//添加project实例
		zip.setProject(proj);
		//指定目标压缩的文件路径
		zip.setDestFile(new File(zipFilepath));
		//添加文件集
		zip.addFileset(fileSet);
		//设置编码
		zip.setEncoding(encoding);
		//执行压缩
		zip.execute();

		System.out.println("compress successed.");
	}

	/**
	 * 解压缩文件和文件夹
	 * 
	 * @param zipFilepath
	 *            需要被解压的zip文件路径
	 * @param destDir
	 *            将要被解压到哪个文件夹
	 * @throws BuildException
	 * @throws RuntimeException
	 */
	public static void unzip(String zipFilepath, String destDir) throws BuildException, RuntimeException {
		if (!new File(zipFilepath).exists()) {
			throw new RuntimeException("zip file " + zipFilepath + " does not exist.");
		}
		
		//实例化project
		Project proj = new Project();
		//实例化expand
		Expand expand = new Expand();
		//设置项目
		expand.setProject(proj);
		//一个称呼
		expand.setTaskType("unzip");
		//一个称呼,在日志里使用
		expand.setTaskName("unzip");
		expand.setEncoding(encoding);
		//设置压缩文件的路径
		expand.setSrc(new File(zipFilepath));
		//设置解压路径
		expand.setDest(new File(destDir));
		expand.execute();

		System.out.println("uncompress successed.");
	}

}