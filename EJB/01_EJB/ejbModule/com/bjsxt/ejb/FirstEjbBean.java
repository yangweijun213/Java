package com.bjsxt.ejb;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * @author jeff yang
 * EJB实现类。命名xxBean,就是实现类
 */

@Stateless 
@Remote 
public class FirstEjbBean implements FirstEjb {

	@Override
	public String saySomething(String name) {
		// TODO Auto-generated method stub
		return "hello "+name;
	}
	

}
