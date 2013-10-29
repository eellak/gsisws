//-----------------------------------------------------------------------------
package org.ellak.common.context;
//-----------------------------------------------------------------------------
import org.springframework.context.ApplicationContextAware;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
//-----------------------------------------------------------------------------
/**
 * @author George Lamprakis
 * @date Oct 28, 2013
 */
public class ApplicationContextProvider implements ApplicationContextAware {
	//-----------------------------------------------------------------------------
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        AppContext.setApplicationContext(ctx);        
    }
    //-----------------------------------------------------------------------------
}
//---------------------------------------------------------------------------------