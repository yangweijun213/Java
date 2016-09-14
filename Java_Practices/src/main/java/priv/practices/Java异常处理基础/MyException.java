package priv.practices.Java异常处理基础;

class MyException extends Exception {
	private int detail;

	MyException(int a) {
		detail = a;
	}

	public String toString() {
		return "MyException[" + detail + "]";
	}
}
