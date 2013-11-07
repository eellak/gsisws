//------------------------------------------------------------------------
package  org.ellak.datalayer.persistence.services.interfaces;
//------------------------------------------------------------------------
import org.ellak.datalayer.persistence.model.GsisRegistryEntryDTO;
//------------------------------------------------------------------------
/**
 * @author George Lamprakis
 * @date Oct 28, 2013
 */
public interface IGsisRegistryService {
	//------------------------------------------------------------------------
	public GsisRegistryEntryDTO fetchByTaxId(String taxId);
	//------------------------------------------------------------------------
}
//------------------------------------------------------------------------