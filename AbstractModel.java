package com.arcadial.restaurant.model;

import java.io.Serializable;

public abstract class AbstractModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return getClass() + "[" + super.toString() + "]";
	}
	
	

}
