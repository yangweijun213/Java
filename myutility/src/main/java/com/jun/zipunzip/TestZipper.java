package com.jun.zipunzip;

public class TestZipper {
	

	public static void main(String[] args) {
		
		//压缩目录下的所有文件
/*		String srcPathname ="D:\\workspace\\Java\\myutility\\demo\\zipunzip";
		String zipFilepath ="D:\\workspace\\Java\\myutility\\demo\\zipunzip.zip";
		Zipper.zip(srcPathname, zipFilepath);*/
		
		//解压文件
		String zipFilepath = "D:\\workspace\\Java\\myutility\\demo\\zipunzip.zip";
		String destDir ="D:\\workspace\\Java\\myutility\\demo\\zipunzip";
		Zipper.unzip(zipFilepath, destDir);
	}

}
