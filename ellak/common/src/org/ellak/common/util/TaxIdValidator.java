//---------------------------------------------------------------------------------------
package org.ellak.common.util;
//---------------------------------------------------------------------------------------
/**
 * @author George Lamprakis
 * @date Oct 28, 2013
 */
public class TaxIdValidator {
	//---------------------------------------------------------------------------------------
    public static boolean checkTaxId(String taxId) {
        int nExp = 1;
        try {
            Integer.parseInt(taxId);
            taxId = taxId.trim();
            if (taxId.length() != 9){
                return false;
            }
            int nSum = 0;
            int xDigit = 0;
            int nT = 0;
            for (int i = taxId.length() - 2; i >=0; i--) {
                xDigit = Integer.parseInt((taxId.substring (i, i+1)));
                nT = xDigit * (int) (Math.pow(2,nExp));
                nSum += nT;
                nExp++;
            }
            xDigit = Integer.parseInt(taxId.substring (taxId.length()-1, taxId.length()));
            nT = nSum / 11;
            int k = nT * 11;
            k = nSum - k;
            if (k == 10) {
                k = 0;
            }
            if (xDigit != k) {
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
        	e.printStackTrace();
            return false;
        } catch (Exception e) {
        	e.printStackTrace();
            return false;
        }
    }   
    //---------------------------------------------------------------------------------------
}
//-------------------------------------------------------------------------------------------
