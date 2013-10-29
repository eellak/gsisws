//-----------------------------------------------------------------------------
package org.ellak.common.context;
//-----------------------------------------------------------------------------
import org.springframework.context.ApplicationContext;
//-----------------------------------------------------------------------------
/**
 * @author George Lamprakis
 * @date Oct 28, 2013
 */
public class AppContext {
	//-----------------------------------------------------------------------------
    private static ApplicationContext ctx;
    //-----------------------------------------------------------------------------    
    public static void setApplicationContext(ApplicationContext applicationContext) {
        ctx = applicationContext;
    }
    //-----------------------------------------------------------------------------    
    public static ApplicationContext getApplicationContext() {
        return ctx;
    }
    //-----------------------------------------------------------------------------
}
//---------------------------------------------------------------------------------