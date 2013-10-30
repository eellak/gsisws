//------------------------------------------------------------------------
package  org.ellak.datalayer.persistence.services.interfaces;
//------------------------------------------------------------------------
import org.ellak.datalayer.persistence.model.GsisRegistryEntryDTO;
//------------------------------------------------------------------------
public interface IGsisRegistryService {
	//------------------------------------------------------------------------
	public GsisRegistryEntryDTO fetchByTaxId(GsisRegistryEntryDTO filter);
	//------------------------------------------------------------------------
}
//------------------------------------------------------------------------
