//--------------------------------------------------------------------------
package org.ellak.datalayer.persistence.model;
//--------------------------------------------------------------------------
import java.io.Serializable;
import java.util.Calendar;
//--------------------------------------------------------------------------
/**
 * @author George Lamprakis
 * @date Oct 28, 2013
 */
public class  GsisRegistryEntryDTO  implements Serializable {
	//--------------------------------------------------------------------------
    private static final long serialVersionUID = 3335239994225810763L;
    //--------------------------------------------------------------------------      
    private int activationStatus;	
	private Calendar endDate;
	private String enterpriseTitle;
	private int errorCode;
	private String errorDescription;
	private String municipality;
	private String notes;
	private String phone;
	private String postalAddress;
	private String postalAddressNo;
	private Calendar startDate;
	private String taxId;
	private String taxOfficeDescr;
	private String taxOfficeId;
	private String zipCode;
	//--------------------------------------------------------------------------    
    public GsisRegistryEntryDTO() {
    }
	//--------------------------------------------------------------------------
    public GsisRegistryEntryDTO(String taxId) {
    	this.taxId = taxId;
    }
	//--------------------------------------------------------------------------
    public int getActivationStatus() {
		return activationStatus;
	}
    //--------------------------------------------------------------------------
	public void setActivationStatus(int activationStatus) {
		this.activationStatus = activationStatus;
	}
    //--------------------------------------------------------------------------
	public Calendar getEndDate() {
		return endDate;
	}
    //--------------------------------------------------------------------------
	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}
    //--------------------------------------------------------------------------
	public String getEnterpriseTitle() {
		return enterpriseTitle;
	}
    //--------------------------------------------------------------------------
	public void setEnterpriseTitle(String enterpriseTitle) {
		this.enterpriseTitle = enterpriseTitle;
	}
    //--------------------------------------------------------------------------
	public int getErrorCode() {
		return errorCode;
	}
    //--------------------------------------------------------------------------
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
    //--------------------------------------------------------------------------
	public String getErrorDescription() {
		return errorDescription;
	}
    //--------------------------------------------------------------------------
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
    //--------------------------------------------------------------------------
	public String getMunicipality() {
		return municipality;
	}
    //--------------------------------------------------------------------------
	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}
    //--------------------------------------------------------------------------
	public String getNotes() {
		return notes;
	}
    //--------------------------------------------------------------------------
	public void setNotes(String notes) {
		this.notes = notes;
	}
    //--------------------------------------------------------------------------
	public String getPhone() {
		return phone;
	}
    //--------------------------------------------------------------------------
	public void setPhone(String phone) {
		this.phone = phone;
	}
    //--------------------------------------------------------------------------
	public String getPostalAddress() {
		return postalAddress;
	}
    //--------------------------------------------------------------------------
	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}
    //--------------------------------------------------------------------------
	public String getPostalAddressNo() {
		return postalAddressNo;
	}
    //--------------------------------------------------------------------------
	public void setPostalAddressNo(String postalAddressNo) {
		this.postalAddressNo = postalAddressNo;
	}
    //--------------------------------------------------------------------------
	public Calendar getStartDate() {
		return startDate;
	}
    //--------------------------------------------------------------------------
	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}
    //--------------------------------------------------------------------------
	public String getTaxId() {
		return taxId;
	}
    //--------------------------------------------------------------------------
	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}
    //--------------------------------------------------------------------------
	public String getTaxOfficeDescr() {
		return taxOfficeDescr;
	}
    //--------------------------------------------------------------------------
	public void setTaxOfficeDescr(String taxOfficeDescr) {
		this.taxOfficeDescr = taxOfficeDescr;
	}
    //--------------------------------------------------------------------------
	public String getTaxOfficeId() {
		return taxOfficeId;
	}
    //--------------------------------------------------------------------------
	public void setTaxOfficeId(String taxOfficeId) {
		this.taxOfficeId = taxOfficeId;
	}
    //--------------------------------------------------------------------------
	public String getZipCode() {
		return zipCode;
	}
    //--------------------------------------------------------------------------
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}    
    //--------------------------------------------------------------------------
}
//------------------------------------------------------------------------------