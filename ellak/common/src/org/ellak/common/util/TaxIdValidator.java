//---------------------------------------------------------------------------------------
package org.ellak.common.util;
//---------------------------------------------------------------------------------------
/**
 * @author George Lamprakis
 * @date Oct 28, 2013
 *
 * @author Vasilis Stergioulis
 * @date Oct 31, 2013
 * @version  1.0 more efficient validator
 * 
 */
public class TaxIdValidator {
	//---------------------------------------------------------------------------------------
    public static boolean checkTaxId(String taxId) {
	        try {
	            Integer.parseInt(taxId);
	        } catch (NumberFormatException e) {
	            return false;
	        }
	        
	        if (taxId.trim().length() != 9) {
	            return false;
	        }

	        int sum = 0;
	        for (int i = 0; i < 8; i++) {
	            sum += (taxId.charAt(i) - '0') << (8 - i);
	        }
	        return ((taxId.charAt(8) - '0') == ((sum % 11) % 10));
    }   
    //---------------------------------------------------------------------------------------
}
//-------------------------------------------------------------------------------------------
