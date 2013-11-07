SPOOL rg_ws_public_afm_info__DEMO_CALL.lst

SET SERVEROUTPUT ON SIZE UNLIMITED
SET LINESIZE 1000

DECLARE
  V_AFM_CALLED_FOR CHAR (12) := '001010105';
  V_BASIC_REC    RG_WS_PUBLIC_BASIC_RT;
  V_FIRM_ACT_TAB RG_WS_PUBLIC_FIRM_ACT_TT;
  V_ERROR_REC    GEN_WS_ERROR_RT;
BEGIN
  rg_ws_public_afm_info_DEMO (P_AFM_CALLED_FOR => V_AFM_CALLED_FOR
                             ,P_BASIC_REC => V_BASIC_REC
                             ,P_FIRM_ACT_TAB => V_FIRM_ACT_TAB
                             ,P_ERROR_REC => V_ERROR_REC);

  IF V_ERROR_REC.ERROR_CODE IS NOT NULL THEN
    DBMS_OUTPUT.PUT_LINE ('V_ERROR_REC.ERROR_CODE = ' || V_ERROR_REC.ERROR_CODE || ', V_ERROR_REC.ERROR_DESCR: ' || V_ERROR_REC.ERROR_DESCR);
  ELSE
    DBMS_OUTPUT.PUT_LINE ('AFM: ' || V_BASIC_REC.AFM || ', DOY_DESCR: ' || V_BASIC_REC.DOY_DESCR || ', ONOMASIA: ' || V_BASIC_REC.ONOMASIA || ', ... more columns');

    IF V_FIRM_ACT_TAB IS NOT NULL
   AND V_FIRM_ACT_TAB.COUNT > 0 THEN
      FOR j IN V_FIRM_ACT_TAB.FIRST .. V_FIRM_ACT_TAB.LAST LOOP
        DBMS_OUTPUT.PUT_LINE ('row: ' || j || ' firm_act: ' || V_FIRM_ACT_TAB (j).FIRM_ACT_CODE || ' / ' || V_FIRM_ACT_TAB (j).FIRM_ACT_DESCR);
      END LOOP;
    END IF;
  END IF;
END;
/

SPOOL OFF