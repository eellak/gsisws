//------------------------------------------------------------------
package  org.ellak.gsisws.server.auth;
//------------------------------------------------------------------
/**
 * @author George Lamprakis
 * @date Oct 28, 2013
 */
public class WSContext {
	//------------------------------------------------------------------
	public static final ThreadLocal<WSCredentials> userThreadLocal = new ThreadLocal<>();
	//------------------------------------------------------------------
	public static void set(WSCredentials credentials) {
		userThreadLocal.set(credentials);
	}
	//------------------------------------------------------------------
	public static void unset() {
		userThreadLocal.remove();
	}
	//------------------------------------------------------------------
	public static WSCredentials get() {
		return userThreadLocal.get();
	}
	//------------------------------------------------------------------
}
//----------------------------------------------------------------------