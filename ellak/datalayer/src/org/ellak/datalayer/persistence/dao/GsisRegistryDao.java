//-----------------------------------------------------------------------
package org.ellak.datalayer.persistence.dao;
//-----------------------------------------------------------------------
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import javax.sql.DataSource;

import org.ellak.datalayer.persistence.model.GsisRegistryEntryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
    private String fetchRegistryEntry = "select * from gsis_reg_view where taxId=?";    		
	//-----------------------------------------------------------------------
	/*
	 * We need the columns of the registry view of GSIS. Moreover, the view also.  
	 */
    @SuppressWarnings("unchecked")
    public GsisRegistryEntryDTO fetchByTaxId(final GsisRegistryEntryDTO regDto) { 
    	try{
        return (GsisRegistryEntryDTO) jdbcTemplate.queryForObject(fetchRegistryEntry,
                new Object[]{ regDto.getTaxId() },
                new RowMapper() {
                    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                    	Calendar cDate = Calendar.getInstance();
                    	GsisRegistryEntryDTO regisrtyEntry = new GsisRegistryEntryDTO();
                    	regisrtyEntry.setActivationStatus(rs.getInt("COL1"));                    	
                    	cDate.setTime(rs.getDate("COL2"));
                		regisrtyEntry.setEndDate(cDate);
                		regisrtyEntry.setEnterpriseTitle(rs.getString("COL3"));
                		regisrtyEntry.setMunicipality(rs.getString("COL4"));
                		regisrtyEntry.setNotes(rs.getString("COL5"));
                		regisrtyEntry.setPhone(rs.getString("COL6"));
                		regisrtyEntry.setPostalAddress(rs.getString("COL7"));
                		regisrtyEntry.setPostalAddressNo(rs.getString("COL8"));
                		cDate.setTime(rs.getDate("COL9"));
                		regisrtyEntry.setStartDate(cDate);
                		regisrtyEntry.setTaxId(rs.getString("COL10"));
                		regisrtyEntry.setTaxOfficeDescr(rs.getString("COL11"));
                		regisrtyEntry.setTaxOfficeId(rs.getString("COL12"));
                		regisrtyEntry.setZipCode(rs.getString("COL13"));
                        return regisrtyEntry;
                    }
                });
    	}catch(Exception e){
    		e.printStackTrace();
    		return null;
    	}
    }
    //-----------------------------------------------------------------------    
}
//---------------------------------------------------------------------------