//------------------------------------------------------------------------
package  org.ellak.datalayer.persistence.services.interfaces;
//------------------------------------------------------------------------
import org.ellak.datalayer.persistence.model.GsisRegistryEntryDTO;
//------------------------------------------------------------------------
public interface GsisRegistryService {
	//------------------------------------------------------------------------
	public GsisRegistryEntryDTO fetchByTaxId(GsisRegistryEntryDTO filter);
	//------------------------------------------------------------------------
}
//------------------------------------------------------------------------