//----------------------------------------------------------------------------------------------------------------
package  org.ellak.gsisws.client;
//----------------------------------------------------------------------------------------------------------------
import gsisws.services.parameters.GsisRegisrtyInfoType;

import java.io.InputStream;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.neethi.Policy;
import org.apache.neethi.PolicyEngine;
//----------------------------------------------------------------------------------------------------------------
/**
 * @author George Lamprakis
 * @date Oct 28, 2013
 */
public class GsisWSClient {
	//----------------------------------------------------------------------------------------------------------------		
	public static void main(String[] args) throws Exception {
		try{			
			GsisRegisrtyInfoType info = findByTaxId("taxid", "usr", "pwd");			
		} catch (Exception e) {
			System.out.println("Error:" + e.toString());
		}
	}
	//----------------------------------------------------------------------------------------------------------------
	public static GsisRegisrtyInfoType findByTaxId(String taxId, String user, String password) throws XMLStreamException {
		return null;
		/*try{				
			if(TaxIdValidator.checkTaxId(taxId)){
				String urlRepo = "http://localhost:8080/gsisws/repository/";
				String urlConfigFile = (urlRepo + "axis2.xml");
				ConfigurationContext context = ConfigurationContextFactory.createConfigurationContextFromURIs(new URL(urlConfigFile), new URL(urlRepo));
			
				GsisServiceStub gsisWsClient = new GsisServiceStub(context);
				ggpsWsClient._getServiceClient().engageModule("rampart");
				ggpsWsClient._getServiceClient().getOptions().setProperty(RampartMessageData.KEY_RAMPART_POLICY, loadPolicy("META-INF/policy.xml"));
				ggpsWsClient._getServiceClient().getOptions().setUserName(user);
				ggpsWsClient._getServiceClient().getOptions().setPassword(password);
				ggpsWsClient._getServiceClient().getOptions().setProperty(Constants.Configuration.ENABLE_MTOM, "true");

				QueryByTaxIdRequest req = new QueryByTaxIdRequest();
				GsisRegisrtyInfoType registryReq = new  GsisRegisrtyInfoType();
				registryReq.setTaxId(taxId);
				registryReq.setActivationStatus(BigInteger.valueOf(0));
				req.setRegisrty(registryReq);
				
				QueryByTaxIdResponse r = gsisWsClient.queryByTaxId(req);
				GsisRegisrtyInfoType registryRs = null;
				if(r != null && (registryRs = r.getRegisrty()) != null){
					return registryRs;
				}else{					
					return null;
				}
			}else{
				return null;
			}				
		} catch (Exception e) {
			e.printStackTrace();		
			return null;
		}		*/
	}
	//----------------------------------------------------------------------------------------------------------------
	private Policy loadPolicy(String name) throws XMLStreamException {
        ClassLoader loader = this.getClass().getClassLoader();
        InputStream resource = loader.getResourceAsStream(name);
        StAXOMBuilder builder = new StAXOMBuilder(resource);
        return PolicyEngine.getPolicy(builder.getDocumentElement());
    }
	//----------------------------------------------------------------------------------------------------------------
}
//----------------------------------------------------------------------------------------------------------------