//------------------------------------------------------------------------
package  org.ellak.gsisws.server.services;
//------------------------------------------------------------------------
import gsisws.services.GsisServiceSkeletonInterface;
import gsisws.services.parameters.GsisErrorInfoType;
import gsisws.services.parameters.GsisFirmActivityInfoType;
import gsisws.services.parameters.GsisFirmActivityType;
import gsisws.services.parameters.GsisRegistryInfoType;
import gsisws.services.parameters.QueryByTaxIdRequest;
import gsisws.services.parameters.QueryByTaxIdResponse;

import java.math.BigInteger;

import org.apache.axis2.context.MessageContext;
import org.ellak.common.util.TaxIdValidator;
import org.ellak.datalayer.persistence.model.FirmActivityDTO;
import org.ellak.datalayer.persistence.model.GsisRegistryEntryDTO;
import org.ellak.datalayer.persistence.services.GsisRegistryServiceImpl;
import org.ellak.datalayer.util.GsisToolkit;
import org.ellak.gsisws.server.auth.WSContext;
import org.ellak.gsisws.server.auth.WSCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
//------------------------------------------------------------------------
/**
 * @author George Lamprakis
 * @date Oct 28, 2013
 */
//------------------------------------------------------------------------
public class GsisServiceImpl extends SpringBeanAutowiringSupport implements GsisServiceSkeletonInterface {
	//------------------------------------------------------------------------
	@Autowired
	GsisRegistryServiceImpl gsisRegistryService;
	//------------------------------------------------------------------------
    public QueryByTaxIdResponse queryByTaxId(QueryByTaxIdRequest queryTaxIdReq){
    	GsisRegistryInfoType registryEntry = new  GsisRegistryInfoType();
    	GsisErrorInfoType errorInfo = new GsisErrorInfoType();
    	QueryByTaxIdResponse queryTaxIdRsp = new QueryByTaxIdResponse();
    	System.out.println("Query gsis registry from IP:" + getClientIP());
    	System.out.println("Character set encoding :" + getCharacterSetEncoding());    	
    	try {    		
    		//- use the credentials for auditing - logging ... 
    		WSCredentials credentials = WSContext.get();    		    		
    		//- clear credentials when no longer need them. 
    		WSContext.unset();
    		if(queryTaxIdReq.getTaxId() != null &&
			   !queryTaxIdReq.getTaxId().isEmpty() &&
    		   TaxIdValidator.checkTaxId(queryTaxIdReq.getTaxId())){    			
    			GsisRegistryEntryDTO r = gsisRegistryService.fetchByTaxId(queryTaxIdReq.getTaxId());
    			if(GsisToolkit.getError(r.getErrorCode()) == null){
    				registryEntry.setDeactivationFlag(r.getDeactivationFlag());
    				registryEntry.setDeactivationFlagDescr(r.getDeactivationFlagDescr());
    				registryEntry.setEndDate(r.getEndDate());    				
    				errorInfo.setErrorCode(r.getErrorCode());
    				errorInfo.setErrorDescription(r.getErrorDescription());    				
    				registryEntry.setErrorData(errorInfo);
    				GsisFirmActivityType activities = new GsisFirmActivityType();
    				for(FirmActivityDTO firmActivity: r.getFirmActivities()){
    					GsisFirmActivityInfoType firmActivityInfo = new GsisFirmActivityInfoType();
    					firmActivityInfo.setFirmActCode(BigInteger.valueOf(firmActivity.getFirm_act_code()));
    					firmActivityInfo.setFirmActDescr(firmActivity.getFirm_act_descr());
    					firmActivityInfo.setFirmActKind(firmActivity.getFirm_act_kind());
    					activities.addFirmActivity(firmActivityInfo);
    				}    				
    				registryEntry.setFirmActivities(activities);
    				registryEntry.setFirmFlagDescr(r.getFirmFlagDescr());
    				registryEntry.setFirmName(r.getFirmName());
    				registryEntry.setFirmTitle(r.getFirmTitle());
    		    	registryEntry.setIniFlagDescr(r.getIniFlagDescr());
    		    	registryEntry.setLegalStatusDescr(r.getLegalStatusDescr());
    		    	registryEntry.setPostalAddress(r.getPostalAddress());
    		    	registryEntry.setPostalAddressNo(r.getPostalAddressNo());
    		    	registryEntry.setRegion(r.getRegion());
    		    	registryEntry.setStartDate(r.getStartDate());   		    	
    		    	registryEntry.setTaxId(r.getTaxId());
    		    	registryEntry.setTaxOfficeDescr(r.getTaxOfficeDescr());
    		    	registryEntry.setTaxOfficeId(r.getTaxOfficeId());
    				registryEntry.setZipCode(r.getZipCode());
    			}else{
    				errorInfo.setErrorCode(r.getErrorCode());
    				errorInfo.setErrorDescription(r.getErrorDescription());     				  	    		
    			}    			
    		}else{
    			errorInfo.setErrorCode(GsisToolkit.RG_WRONG_AFM);
    			errorInfo.setErrorDescription(GsisToolkit.getError(errorInfo.getErrorCode()));     	    		
    		}    		
    	}catch(Exception e){  
    		e.printStackTrace();    		    		
			errorInfo.setErrorCode(GsisToolkit.GEN_EXCEPTION);
			errorInfo.setErrorDescription(GsisToolkit.getError(errorInfo.getErrorCode()));    		 		
    	}   
    	registryEntry.setErrorData(errorInfo);  
    	queryTaxIdRsp.setRegisrty(registryEntry);   
    	return queryTaxIdRsp;
    }
	//------------------------------------------------------------------------    
    private String getClientIP() {
        return (String)(MessageContext.getCurrentMessageContext()).getProperty(MessageContext.REMOTE_ADDR);
    }
    //------------------------------------------------------------------------
    private String getCharacterSetEncoding() {
        return (String)(MessageContext.getCurrentMessageContext()).getProperty(MessageContext.CHARACTER_SET_ENCODING);
    }    
    //------------------------------------------------------------------------
}
//----------------------------------------------------------------------------
