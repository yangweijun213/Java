package com.jun.encapsulations2;
import com.jun.encapsulations.*;

public class child extends TestProtected {
	void ee() {
		//可以调用父类的protected 方法cc(),不在同一个包内
		super.cc();
	}
}
