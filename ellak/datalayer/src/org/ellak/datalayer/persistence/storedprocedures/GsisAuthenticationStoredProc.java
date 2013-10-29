//--------------------------------------------------------------------
package org.ellak.datalayer.persistence.storedprocedures;
//--------------------------------------------------------------------
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
//----------------------------------------------------------------------
/**
 * @author George Lamprakis
 * @date Oct 28, 2013
 */
public class GsisAuthenticationStoredProc extends StoredProcedure {
	//----------------------------------------------------------------------
	private static final String PROC_NAME = "GSIS.AUTHENTICATE_USER";
	//----------------------------------------------------------------------	
	public GsisAuthenticationStoredProc(DataSource ds){
		 super(ds, PROC_NAME);
	        setFunction(true);
	        declareParameter(new SqlOutParameter("RESULT", Types.BOOLEAN));	       
	        declareParameter(new SqlParameter("USERNAME", Types.VARCHAR));
	        declareParameter(new SqlParameter("PASSWORD", Types.VARCHAR));
	        compile();
	}
	//----------------------------------------------------------------------
	public Boolean execute(String username, String password) throws Exception {	          	 
	    Map out = _execute(username, password);
	    if(out != null && !out.isEmpty()){	    	
	    	return (Boolean)out.get("RESULT");	    		    	
	    }else{
        	throw new Exception("Failed to execute authentication proc");
	    }	    
	}
	//----------------------------------------------------------------------	
	private Map _execute(String username, String password) {
	        Map inputs = new HashMap();
	        inputs.put("USERNAME", username);
	        inputs.put("PASSWORD", password);	       
	        return super.execute(inputs);
	 }
	 //---------------------------------------------------------------------
}
//--------------------------------------------------------------------------