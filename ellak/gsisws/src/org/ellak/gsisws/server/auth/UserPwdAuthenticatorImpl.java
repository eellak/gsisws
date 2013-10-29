//-----------------------------------------------------------------
package org.ellak.gsisws.server.auth;
//-----------------------------------------------------------------
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.ellak.gsisws.server.auth.interfaces.IUserPwdAuthenticator;
import org.springframework.stereotype.Service;
//-----------------------------------------------------------------
/**
 * @author George Lamprakis
 * @date Oct 28, 2013
 */
@Service("gsisWsAuthService")
public class UserPwdAuthenticatorImpl implements IUserPwdAuthenticator {
	//-----------------------------------------------------------------
	public boolean authenticate(String username, String password) throws Exception {
		//- Put authentication code here ...
		return true;	
	}
	//-----------------------------------------------------------------
	@PostConstruct
	public void initAuth(){
		System.out.println(this.getClass().getSimpleName() + " started.");
	}
	//-----------------------------------------------------------------
	@PreDestroy
	public void shutdownAuth(){
		System.out.println(this.getClass().getSimpleName() + " shutdown.");
	}
	//-----------------------------------------------------------------
}
//-----------------------------------------------------------------