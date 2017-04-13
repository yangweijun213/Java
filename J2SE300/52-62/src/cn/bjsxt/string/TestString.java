package cn.bjsxt.string;

/**
 * String：不可变字符序列！
 * 三个作业：
 * 1. 练习String类的常用方法
 * 2. 结合数组查看源码
 * 3. 提高：按照老师的方法将String类中相关方法的源码看一看。
 * @author dell
 *
 */
public class TestString {
	public static void main(String[] args) {
		String str = new String("abcd");
		String str2 = new String("abcd");
		System.out.println(str2.equals(str));   //比较内容是否相等。
		System.out.println(str2==str); //地址不同

		System.out.println(str.charAt(2)); //位于第2个字符
		
		String str3 = "def";
		String str4 = "def";
		System.out.println(str3.equals(str4));
		System.out.println(str3==str4);
		
		System.out.println(str3.indexOf('d')); //返回 d的位置
		String s = str3.substring(0); //从0开始的位置之后的字符串
		System.out.println(s);
		String str5 = str3.replace('e', '*'); //将e替换了*
		System.out.println(str5);
		
		String str6 = "abcde,rrtt,cccee";
		String[] strArray = str6.split(","); //逗号方式分开
		for(int i=0;i<strArray.length;i++){
			System.out.println(strArray[i]);
		}
		String str7 = "  aa  bb  ";
		String str77 = str7.trim(); //去处左右空格
		System.out.println(str77.length()); 
		
		System.out.println("Abc".equalsIgnoreCase("abc"));
		System.out.println("Abcbd".indexOf('b')); 
		System.out.println("Abcbd".lastIndexOf('b')); 
		System.out.println("Abcbd".startsWith("Ab")); //是否Ab开头
		System.out.println("Abcbd".endsWith("bd")); //是否bd结尾
		System.out.println("Abcbd".toLowerCase()); 
		System.out.println("Abcbd".toUpperCase()); 
		
		System.out.println("##################");
		String gh = new String("a");
		for (int i = 0; i < 1000; i++) {
			gh = gh + i;
		}
		System.out.println(gh); 
		
		
	}
	

}
