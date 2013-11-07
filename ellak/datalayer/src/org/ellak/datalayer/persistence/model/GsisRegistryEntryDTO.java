//--------------------------------------------------------------------------
package org.ellak.datalayer.persistence.model;
//--------------------------------------------------------------------------
import java.io.Serializable;
import java.util.ArrayList;
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
    private String taxId; // The taxId of the Firm
    private String deactivationFlag; //- 	    
	private String deactivationFlagDescr;
	private String firmName;
	private String firmTitle;
	private String firmFlagDescr;
	private String legalStatusDescr;
	private String iniFlagDescr;		
	private String region;
	private String postalAddress;
	private String postalAddressNo;
	private String zipCode;
	private String startDate;
	private String endDate;
	private String taxOfficeId;	
	private String taxOfficeDescr;	
	private String errorCode;
	private String errorDescription;
	private ArrayList<FirmActivityDTO> firmActivities;
	//--------------------------------------------------------------------------    
    public GsisRegistryEntryDTO() {
    }
	//--------------------------------------------------------------------------
    public GsisRegistryEntryDTO(String taxId) {
    	this.taxId = taxId;
    }  
    //--------------------------------------------------------------------------
	public String getEndDate() {
		return endDate;
	}
    //--------------------------------------------------------------------------
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
    //--------------------------------------------------------------------------
	public String getFirmTitle() {
		return firmTitle;
	}
    //--------------------------------------------------------------------------
	public void setFirmTitle(String firmTitle) {
		this.firmTitle = firmTitle;
	}
    //--------------------------------------------------------------------------
	public String getErrorCode() {
		return errorCode;
	}
    //--------------------------------------------------------------------------
	public void setErrorCode(String errorCode) {
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
	public String getRegion() {
		return region;
	}
    //--------------------------------------------------------------------------
	public void setRegion(String region) {
		this.region = region;
	}
    //--------------------------------------------------------------------------
	public String getLegalStatusDescr() {
		return legalStatusDescr;
	}
    //--------------------------------------------------------------------------
	public void setLegalStatusDescr(String legalStatusDescr) {
		this.legalStatusDescr = legalStatusDescr;
	}
    //--------------------------------------------------------------------------
	public String getFirmName() {
		return firmName;
	}
    //--------------------------------------------------------------------------
	public void setFirmName(String firmName) {
		this.firmName = firmName;
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
	public String getStartDate() {
		return startDate;
	}
    //--------------------------------------------------------------------------
	public void setStartDate(String startDate) {
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
	public ArrayList<FirmActivityDTO> getFirmActivities() {
		return firmActivities;
	}
    //--------------------------------------------------------------------------
	public void setFirmActivities(ArrayList<FirmActivityDTO> firmActivities) {
		this.firmActivities = firmActivities;
	}
    //--------------------------------------------------------------------------
	public void addFirmActivity(FirmActivityDTO firmActivity){
		this.firmActivities.add(firmActivity);
	}
    //--------------------------------------------------------------------------
	public int firmActivitiesSize(){
		return this.firmActivities.size();
	}
    //--------------------------------------------------------------------------
	public String getFirmFlagDescr() {
		return firmFlagDescr;
	}
    //--------------------------------------------------------------------------
	public void setFirmFlagDescr(String firmFlagDescr) {
		this.firmFlagDescr = firmFlagDescr;
	}
    //--------------------------------------------------------------------------
	public String getDeactivationFlag() {
		return deactivationFlag;
	}
    //--------------------------------------------------------------------------
	public void setDeactivationFlag(String deactivationFlag) {
		this.deactivationFlag = deactivationFlag;
	}
    //--------------------------------------------------------------------------
	public String getDeactivationFlagDescr() {
		return deactivationFlagDescr;
	}
    //--------------------------------------------------------------------------
	public void setDeactivationFlagDescr(String deactivationFlagDescr) {
		this.deactivationFlagDescr = deactivationFlagDescr;
	}
    //--------------------------------------------------------------------------
	public String getIniFlagDescr() {
		return iniFlagDescr;
	}
    //--------------------------------------------------------------------------
	public void setIniFlagDescr(String iniFlagDescr) {
		this.iniFlagDescr = iniFlagDescr;
	}
    //--------------------------------------------------------------------------
}
//------------------------------------------------------------------------------