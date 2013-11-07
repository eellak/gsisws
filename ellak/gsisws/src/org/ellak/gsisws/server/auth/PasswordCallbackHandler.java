//---------------------------------------------------------------------------------------
package org.ellak.gsisws.server.auth;
//---------------------------------------------------------------------------------------
import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;
import org.apache.ws.security.WSSecurityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
//---------------------------------------------------------------------------------------
/**
 * @author George Lamprakis
 * @date Oct 28, 2013
 */
public class PasswordCallbackHandler extends SpringBeanAutowiringSupport implements CallbackHandler {
	//---------------------------------------------------------------------------------------
	@Autowired
	UserPwdAuthenticatorImpl gsisWsAuthService;
	//---------------------------------------------------------------------------------------
	private boolean authenticate(String username, String password) throws Exception {			
		return gsisWsAuthService.authenticate(username, password);
	}
	//---------------------------------------------------------------------------------------
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		for (int i = 0; i < callbacks.length; i++) {
			if (callbacks[i] instanceof WSPasswordCallback) {
				String tokenUsername = "default";
				String tokenPassword = "default";
				try {
					WSPasswordCallback pwcb = (WSPasswordCallback)callbacks[i];					
					switch (pwcb.getUsage()) {
						case WSPasswordCallback.USERNAME_TOKEN_UNKNOWN:							
							tokenUsername = pwcb.getIdentifier();
							tokenPassword = pwcb.getPassword();	
							/*
							 * At this point we can use the stored procedure provided by GSIS
							 * for taxis authentication. Alternatively, we can implement oracle LPAD based
							 * java code for taxis authentication. The option of stored procedure usage was
							 * told by GSIS people as far as i remember.
							 */							
							if(!authenticate(tokenUsername, tokenPassword)){
								throw new WSSecurityException("Authentication failed for [" + tokenUsername + "/" + tokenPassword + "]");
							}
							/* 
							 * Use thread local here to provide credential availability
							 * to the main body of the GSIS implementation. Would be 
							 * strongly needed for logging/auditing.   
							 */
							WSCredentials credentials = new WSCredentials();
							credentials.setUsername(tokenUsername);
							credentials.setPassword(tokenPassword);
							WSContext.set(credentials);
							break;						
					}
				} catch (Exception e) {
					throw new WSSecurityException(e.getMessage());
				}				
			} else {
				throw new UnsupportedCallbackException(callbacks[i],"Unknown Callback");
			}
		}
	}
	//---------------------------------------------------------------------------------------
}
//-------------------------------------------------------------------------------------------