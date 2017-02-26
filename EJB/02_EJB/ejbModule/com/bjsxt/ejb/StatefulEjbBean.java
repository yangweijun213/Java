package com.bjsxt.ejb;

import javax.ejb.Remote;
import javax.ejb.Stateful;

@Stateful
@Remote
public class StatefulEjbBean implements StatefulEjb {
	
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
