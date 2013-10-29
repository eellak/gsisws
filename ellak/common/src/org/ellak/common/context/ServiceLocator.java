//-----------------------------------------------------------------------------------
package org.ellak.common.context;
//-----------------------------------------------------------------------------------
/**
 * @author George Lamprakis
 * @date Oct 28, 2013
 */
public class ServiceLocator {
	//-------------------------------------------------------------------------------	
	public static Object locate(String serviceName) {
		Object service = AppContext.getApplicationContext().getBean(serviceName);
		return service;		
	}
	//-------------------------------------------------------------------------------
}
//-----------------------------------------------------------------------------------