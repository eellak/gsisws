//-----------------------------------------------------------------------
package org.ellak.datalayer.persistence.dao;
//-----------------------------------------------------------------------
import javax.sql.DataSource;

import org.ellak.datalayer.persistence.model.GsisRegistryEntryDTO;
import org.ellak.datalayer.persistence.storedprocedures.QueryByTaxIdProc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
//-----------------------------------------------------------------------
/**
 * @author George Lamprakis
 * @date Oct 28, 2013
 */
@Repository("gsisRegistryDao")
public class GsisRegistryDao {
	//----------------------------------------------------------------------- 
	private JdbcTemplate jdbcTemplate;
	@Autowired	
	public void createTemplate(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	//-----------------------------------------------------------------------
	private QueryByTaxIdProc proc;
	@Autowired	
	public void createProc(DataSource dataSource) {
		this.proc = new QueryByTaxIdProc(dataSource);
	}
	//-----------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    public GsisRegistryEntryDTO fetchByTaxId(String taxId){
    	return proc.execute(taxId);
    }
    //-----------------------------------------------------------------------    
}
//---------------------------------------------------------------------------