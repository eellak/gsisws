//--------------------------------------------------------------------
package org.ellak.datalayer.persistence.storedprocedures;
//--------------------------------------------------------------------
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import oracle.jdbc.driver.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.STRUCT;

import org.ellak.datalayer.persistence.model.FirmActivityDTO;
import org.ellak.datalayer.persistence.model.GsisRegistryEntryDTO;
import org.ellak.datalayer.util.GsisToolkit;
import org.springframework.jdbc.core.ParameterMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
//--------------------------------------------------------------------------
/**
 * @author George Lamprakis
 * @date Nov 06, 2013
 */
public class QueryByTaxIdProc extends StoredProcedure {
	//----------------------------------------------------------------------
	private static final String SQL = "RG_WS_PUBLIC_AFM_INFO_DEMO";	
	//----------------------------------------------------------------------
	public QueryByTaxIdProc(DataSource ds){
		super(ds, SQL); 		
		declareParameter(new SqlParameter("P_AFM_CALLED_FOR", OracleTypes.VARCHAR));        
 		declareParameter(new SqlOutParameter("P_BASIC_REC", OracleTypes.STRUCT, "RG_WS_PUBLIC_BASIC_RT"));
 		declareParameter(new SqlOutParameter("P_FIRM_ACT_TAB", OracleTypes.ARRAY, "RG_WS_PUBLIC_FIRM_ACT_TT"));
 		declareParameter(new SqlOutParameter("P_ERROR_REC", OracleTypes.STRUCT, "GEN_WS_ERROR_RT"));
	    compile();
	}
	//----------------------------------------------------------------------
	private Map _execute(final String taxId) throws SQLException {
        return super.execute(new ParameterMapper() {        	
            public Map createMap(Connection con) throws SQLException {
                Map<String, Object> in = new HashMap<String, Object>();
                in.put("P_AFM_CALLED_FOR", taxId);                               
                return in;
            }
        });
	}
	//----------------------------------------------------------------------
	public GsisRegistryEntryDTO execute(final String taxId) {
		GsisRegistryEntryDTO r = new GsisRegistryEntryDTO();
		try{			
			//- execute the PLSQL procedure
			Map out = _execute(taxId);
			//- get the results
			if(out != null && !out.isEmpty()){
				STRUCT oErrorRec = (STRUCT)out.get("P_ERROR_REC");
				Object[] oErrorRecAttributes = oErrorRec.getAttributes();
				// Watch out !!! The order here is very important ...
				String ERROR_CODE  = (String)oErrorRecAttributes[0];
				String ERROR_DESCR = (String)oErrorRecAttributes[1];
				r.setErrorCode(ERROR_CODE);
				r.setErrorDescription(ERROR_DESCR);
				if(GsisToolkit.getError(ERROR_CODE) == null){
					STRUCT oBasicRec = (STRUCT)out.get("P_BASIC_REC");	
					Object[] oBasicRecAttributes = oBasicRec.getAttributes();
					// Watch out !!! The order here is very important ...
					r.setTaxId((String)oBasicRecAttributes[0]);
					r.setTaxOfficeId((String)oBasicRecAttributes[1]);
					r.setTaxOfficeDescr((String)oBasicRecAttributes[2]);
					r.setIniFlagDescr((String)oBasicRecAttributes[3]);
					r.setDeactivationFlag((String)oBasicRecAttributes[4]);
					r.setDeactivationFlagDescr((String)oBasicRecAttributes[5]);
					r.setFirmFlagDescr((String)oBasicRecAttributes[6]);
					r.setFirmName((String)oBasicRecAttributes[7]);				
					r.setFirmTitle((String)oBasicRecAttributes[8]);					
					r.setLegalStatusDescr((String)oBasicRecAttributes[9]);	
					r.setPostalAddress((String)oBasicRecAttributes[10]);
					r.setPostalAddressNo((String)oBasicRecAttributes[11]);
					r.setZipCode((String)oBasicRecAttributes[12]);	
					r.setRegion((String)oBasicRecAttributes[13]);	
					if(oBasicRecAttributes[14] != null){
						r.setStartDate(((Date)oBasicRecAttributes[14]).toString());
					}else{
						r.setStartDate(null);
					}
					if(oBasicRecAttributes[15] != null){						
						r.setEndDate(((Date)oBasicRecAttributes[15]).toString());
					}else{
						r.setEndDate(null);
					}
			    	ARRAY oFirmActTab = (ARRAY)out.get("P_FIRM_ACT_TAB");
			    	Object[] oFirmActArray = (Object[])oFirmActTab.getArray();
			    	ArrayList<FirmActivityDTO> firmActivities = new ArrayList<FirmActivityDTO>(); 	    	
					for(int i=0; i<oFirmActArray.length; i++){					
						STRUCT oFirmAct = (STRUCT)oFirmActArray[i];				
						Object[] oFirmActAttributes = oFirmAct.getAttributes();
						FirmActivityDTO firmActivity = new FirmActivityDTO();
						// Watch out !!! The order here is very important ...
						if(oFirmActAttributes[0] != null){
							firmActivity.setFirm_act_code(((BigDecimal)oFirmActAttributes[0]).intValue());
						}
						firmActivity.setFirm_act_descr((String)oFirmActAttributes[1]);
						firmActivity.setFirm_act_kind((String)oFirmActAttributes[2]);					
						firmActivities.add(firmActivity);
					}		
					r.setFirmActivities(firmActivities);
				}				
			}else{
				r.setErrorCode(GsisToolkit.GEN_OTHER_EXCEPTION);
				r.setErrorDescription(GsisToolkit.getError(r.getErrorCode()));
			}								
		}catch(Exception e){
			e.printStackTrace();
			r.setErrorCode(GsisToolkit.GEN_EXCEPTION);
			r.setErrorDescription(GsisToolkit.getError(r.getErrorCode()));
		}
		return r;
	}
	//----------------------------------------------------------------------
	
	//---------------------------------------------------------------------------		
}
//--------------------------------------------------------------------------