//------------------------------------------------------------------------
package org.ellak.datalayer.persistence.services;
//------------------------------------------------------------------------
import org.ellak.datalayer.persistence.dao.GsisRegistryDao;
import org.ellak.datalayer.persistence.model.GsisRegistryEntryDTO;
import org.ellak.datalayer.persistence.services.interfaces.GsisRegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//------------------------------------------------------------------------
/**
 * @author George Lamprakis
 * @date Oct 28, 2013
 */
@Service("gsisRegistryService")
public class GsisRegistryServiceImpl implements IGsisRegistryService {
	//------------------------------------------------------------------------
	@Autowired
    private GsisRegistryDao gsisRegistryDao;
	//------------------------------------------------------------------------
    public GsisRegistryEntryDTO fetchByTaxId(GsisRegistryEntryDTO filter){
    	return gsisRegistryDao.fetchByTaxId(filter);
    }
	//---------------------------------------------------------------------
}
//-------------------------------------------------------------------------
