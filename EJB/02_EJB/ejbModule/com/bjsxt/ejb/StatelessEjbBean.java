package com.bjsxt.ejb;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote
public class StatelessEjbBean implements StatelessEjb {
	
	private int state;
	
	@Override
	public void compute(int i) {
		state=state+i;
		
	}

	@Override
	public int getResult() {
		
		return state;
	}

}
