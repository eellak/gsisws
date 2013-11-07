//--------------------------------------------------------------------
package org.ellak.datalayer.util;
//--------------------------------------------------------------------
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
//------------------------------------------------------------------------
/**
 * @author George Lamprakis
 * @date Nov 06, 2013
 */
//------------------------------------------------------------------------
public class GsisToolkit {
	//------------------------------------------------------------------------
	public static final String GEN_EXCEPTION_ON_EXCEPTION = "GEN_EXCEPTION_ON_EXCEPTION";
	public static final String GEN_OTHER_EXCEPTION = "GEN_OTHER_EXCEPTION";
	public static final String GEN_EXCEPTION = "GEN_EXCEPTION";
	public static final String RG_EPIT_NF = "RG_EPIT_NF";
	public static final String RG_TAXPAYER_NF = "RG_TAXPAYER_NF";
	public static final String RG_WRONG_AFM = "RG_WRONG_AFM";
	//------------------------------------------------------------------------
	private static final Map<String, String> ERROR_WS_MAP = 
			Collections.unmodifiableMap(new HashMap<String, String>() {{ 
			put(GEN_EXCEPTION_ON_EXCEPTION, "Σοβαρό πρόβλημα στη βάση δεδομένων και στο χειρισμό του λάθους που προέκυψε");
			put(GEN_OTHER_EXCEPTION, "Σοβαρό πρόβλημα στη βάση δεδομένων");
			put(GEN_EXCEPTION, "Γενικό σφάλμα κλήσης της υπηρεσίας.");
			put(RG_EPIT_NF, "Ο Α.Φ.Μ. δεν ανήκει και δεν ανήκε ποτέ σε επιτηδευματία.");
			put(RG_TAXPAYER_NF, "Ανύπαρκτος Α.Φ.Μ.");
			put(RG_WRONG_AFM, "Λάθος Α.Φ.Μ.");
		}});
	//------------------------------------------------------------------------
	public static String getError(String errorCode){
		return ERROR_WS_MAP.get(errorCode);
	}
	//------------------------------------------------------------------------
}
//----------------------------------------------------------------------------
