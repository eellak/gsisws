package org.ellak.gsisws.server.auth.interfaces;
//------------------------------------------------------------------------

public interface IUserPwdAuthenticator {
	//------------------------------------------------------------------------
		public boolean authenticate(String username, String password) throws Exception;
	//------------------------------------------------------------------------
}
//----------------------------------------------------------------------------
