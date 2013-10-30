//-------------------------------------------------------------------------------------
package org.ellak.gsisws.client;
//-------------------------------------------------------------------------------------
import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;
//-------------------------------------------------------------------------------------
public class PWHandlerGsisClient implements CallbackHandler {
	//-------------------------------------------------------------------------------------
    public void handle (Callback[] callbacks) throws IOException, UnsupportedCallbackException {
    	try{
	        for (int i = 0; i < callbacks.length; i++) {
	            WSPasswordCallback pwcb = (WSPasswordCallback) callbacks[i];
	            pwcb.setIdentifier("usr");
	            pwcb.setPassword("pwd");
	        }
    	}catch(Exception e){
    		e.printStackTrace();
    		System.out.println("Problem in setting the PWHandlerGsisClient credebtials: " + e);
    	}
    }
    //-------------------------------------------------------------------------------------
}
//---------------------------------------------------------------------------------------
