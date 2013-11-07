package org.ellak.gsisws.server.auth.interfaces;
//------------------------------------------------------------------------
/**
 * @author George Lamprakis
 * @date Oct 28, 2013
 */
public interface IUserPwdAuthenticator {
	//------------------------------------------------------------------------
		public boolean authenticate(String username, String password) throws Exception;
	//------------------------------------------------------------------------
}
//----------------------------------------------------------------------------
