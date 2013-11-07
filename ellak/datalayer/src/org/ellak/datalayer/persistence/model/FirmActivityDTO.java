//--------------------------------------------------------------------------
package org.ellak.datalayer.persistence.model;
//--------------------------------------------------------------------------
/**
 * @author George Lamprakis
 * @date Nov 06, 2013
 */
public class FirmActivityDTO {
	//--------------------------------------------------------------------------
	private int firm_act_code;	
	private String firm_act_descr;
	private String firm_act_kind;
	//--------------------------------------------------------------------------
	public FirmActivityDTO(){		
	}
	//--------------------------------------------------------------------------
	public int getFirm_act_code() {
		return firm_act_code;
	}
	//--------------------------------------------------------------------------
	public void setFirm_act_code(int firm_act_code) {
		this.firm_act_code = firm_act_code;
	}
	//--------------------------------------------------------------------------
	public String getFirm_act_descr() {
		return firm_act_descr;
	}
	//--------------------------------------------------------------------------
	public void setFirm_act_descr(String firm_act_descr) {
		this.firm_act_descr = firm_act_descr;
	}
	//--------------------------------------------------------------------------
	public String getFirm_act_kind() {
		return firm_act_kind;
	}
	//--------------------------------------------------------------------------
	public void setFirm_act_kind(String firm_act_kind) {
		this.firm_act_kind = firm_act_kind;
	}
	//--------------------------------------------------------------------------
}
//------------------------------------------------------------------------------