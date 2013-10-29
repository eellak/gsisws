//------------------------------------------------------------------------
package  org.ellak.gsisws.server.services;
//------------------------------------------------------------------------
import gsisws.services.GsisServiceSkeletonInterface;
import gsisws.services.parameters.GsisRegisrtyInfoType;
import gsisws.services.parameters.QueryByTaxIdRequest;
import gsisws.services.parameters.QueryByTaxIdResponse;

import java.math.BigInteger;
import java.util.Calendar;

import org.apache.axis2.context.MessageContext;
import org.ellak.common.context.ServiceLocator;
import org.ellak.common.util.TaxIdValidator;
import org.ellak.datalayer.persistence.model.GsisRegistryEntryDTO;
import org.ellak.datalayer.persistence.services.GsisRegistryServiceImpl;
import org.ellak.gsisws.server.auth.WSContext;
import org.ellak.gsisws.server.auth.WSCredentials;
//------------------------------------------------------------------------
/**
 * @author George Lamprakis
 * @date Oct 28, 2013
 */
//------------------------------------------------------------------------
public class GsisServiceImpl implements GsisServiceSkeletonInterface {
	//------------------------------------------------------------------------
    public QueryByTaxIdResponse queryByTaxId(QueryByTaxIdRequest queryTaxIdReq){
    	GsisRegisrtyInfoType registryEntry = new  GsisRegisrtyInfoType();
    	QueryByTaxIdResponse queryTaxIdRsp = new QueryByTaxIdResponse();
    	try {    
    		System.out.println("Query gsis registry from IP:" + getClientIP());
    		//- use the credentials for auditing - logging ... 
    		WSCredentials credentials = WSContext.get();    		    		
    		//- clear credentials when no longer need them. 
    		WSContext.unset();
    		if(queryTaxIdReq.getRegisrty() != null &&
    		   queryTaxIdReq.getRegisrty().getTaxId() != null &&
			   !queryTaxIdReq.getRegisrty().getTaxId().isEmpty() &&
    		   TaxIdValidator.checkTaxId(queryTaxIdReq.getRegisrty().getTaxId())){
	    		
    			/* At this point real code will use the data layer module.
	    		 * In this case would be like that:
	    		
	    		GsisRegistryServiceImpl dbService = (GsisRegistryServiceImpl)ServiceLocator.locate("gsisRegistryService");    			
    			GsisRegistryEntryDTO r = dbService.fetchByTaxId(new GsisRegistryEntryDTO(queryTaxIdReq.getRegisrty().getTaxId()));
    			if(r == null){
    				registryEntry.setErrorCode(BigInteger.valueOf(-3L));
    	    		registryEntry.setErrorDescription("DB Error.");    			
    	    		registryEntry.setTaxId("XXX");
    	    		queryTaxIdRsp.setRegisrty(registryEntry);
    	    		return queryTaxIdRsp;
    			}else{
    				-- Here would nice to use a proper technology
    				-- for attribute assignment between Data Transfer Objects
    				-- and data binding objects. Dozer mapping service would be
    				-- an excellent choice, while performs nicely.
    				--
    				registryEntry.setActivationStatus(BigInteger.valueOf(r.getActivationStatus()));
    		    	registryEntry.setEndDate(r.getEndDate());
    		    	registryEntry.setEnterpriseTitle(r.getEnterpriseTitle());	    		
    		    	registryEntry.setMunicipality(r.getMunicipality());
    		    	registryEntry.setNotes(r.getNotes());
    		    	registryEntry.setPhone(r.getPhone());
    		    	registryEntry.setPostalAddress(r.getPostalAddress());
    		    	registryEntry.setPostalAddressNo(r.getPostalAddressNo());
    		    	registryEntry.setStartDate(r.getStartDate());    	
    		    	registryEntry.setTaxOfficeDescr(r.getTaxOfficeDescr());
    		    	registryEntry.setTaxOfficeId(r.getTaxOfficeId());
    				registryEntry.setZipCode(r.getZipCode());    				
    			}	    	
	    		 */    			    			
    			loadDummyData(registryEntry);	
    			registryEntry.setTaxId(queryTaxIdReq.getRegisrty().getTaxId());	    		
    			queryTaxIdRsp.setRegisrty(registryEntry);
	    		registryEntry.setErrorCode(BigInteger.valueOf(0));
	    		registryEntry.setErrorDescription(null);
	    		return queryTaxIdRsp;
    		}else{
    			registryEntry.setTaxId(queryTaxIdReq.getRegisrty().getTaxId());    			
    			registryEntry.setErrorCode(BigInteger.valueOf(-2L));
    			registryEntry.setErrorDescription("Invalid request, Check the taxId.");
        		queryTaxIdRsp.setRegisrty(registryEntry);
        		return queryTaxIdRsp;
    		}
    	}catch(Exception e){  
    		e.printStackTrace();
    		System.out.println("Exception Message: " + e.getMessage());   
    		registryEntry.setErrorCode(BigInteger.valueOf(-1L));
    		registryEntry.setErrorDescription("General Error: " + e.getMessage());    			
    		registryEntry.setTaxId("XXX");
    		queryTaxIdRsp.setRegisrty(registryEntry);
    		return queryTaxIdRsp;
    	}   
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
    private void loadDummyData(GsisRegisrtyInfoType registryEntry){
    	registryEntry.setActivationStatus(BigInteger.ONE);
    	registryEntry.setEndDate(Calendar.getInstance());
    	registryEntry.setEnterpriseTitle("a title");	    		
    	registryEntry.setMunicipality("a municipality");
    	registryEntry.setNotes("some notes if any");
    	registryEntry.setPhone("a phone");
    	registryEntry.setPostalAddress("a postal address");
    	registryEntry.setPostalAddressNo("a postal address number");
    	registryEntry.setStartDate(Calendar.getInstance());    	
    	registryEntry.setTaxOfficeDescr("a tax office decription");
    	registryEntry.setTaxOfficeId("a tax office Id");
		registryEntry.setZipCode("a zip code");
    }
    //------------------------------------------------------------------------
}
//----------------------------------------------------------------------------
