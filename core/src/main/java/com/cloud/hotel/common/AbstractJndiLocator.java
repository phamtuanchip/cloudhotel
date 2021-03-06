package com.cloud.hotel.common;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public abstract class AbstractJndiLocator {

	protected InitialContext ctx;
	protected Context envContext;
	
	public AbstractJndiLocator() throws ServiceLocatorException {
		try {
			ctx = new InitialContext();
		} catch (NamingException e) {
			throw new ServiceLocatorException("Unable to create AbstractJndiLocator line 1: " + e.getMessage(), e);
		}
		
		try {
			envContext = (Context) ctx.lookup ("java:/comp/env");
		} catch (NamingException e) {
			throw new ServiceLocatorException("Unable to create AbstractJndiLocator line 2: " + e.getMessage(), e);
		}
	}

	/**
	 * If this returns null, caller should deal with it
	 */
	public Object lookup(String name) throws NamingException {
		Object o = envContext.lookup(name);
		return o;
	}
	
}
