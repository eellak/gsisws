CREATE OR REPLACE PROCEDURE rg_ws_public_afm_info_DEMO (P_AFM_CALLED_FOR   IN     CHAR
                                                  ,P_BASIC_REC           OUT RG_WS_PUBLIC_BASIC_RT
                                                  ,P_FIRM_ACT_TAB        OUT RG_WS_PUBLIC_FIRM_ACT_TT
                                                  ,P_ERROR_REC           OUT GEN_WS_ERROR_RT) IS
BEGIN
  P_BASIC_REC :=
    RG_WS_PUBLIC_BASIC_RT (NULL
                          ,NULL
                          ,NULL
                          ,NULL
                          ,NULL
                          ,NULL
                          ,NULL
                          ,NULL
                          ,NULL
                          ,NULL
                          ,NULL
                          ,NULL
                          ,NULL
                          ,NULL
                          ,NULL
                          ,NULL);

  P_FIRM_ACT_TAB := RG_WS_PUBLIC_FIRM_ACT_TT ();

  P_Error_Rec := GEN_WS_ERROR_RT (NULL, NULL);

  CASE
    WHEN P_AFM_CALLED_FOR = '001010100' THEN
      P_Error_Rec := GEN_WS_ERROR_RT ('RG_WRONG_AFM', 'Λάθος Α.Φ.Μ.');
    WHEN P_AFM_CALLED_FOR = '001010101' THEN
      P_Error_Rec := GEN_WS_ERROR_RT ('RG_TAXPAYER_NF', 'Ανύπαρκτος Α.Φ.Μ.');
    WHEN P_AFM_CALLED_FOR = '001010102' THEN
      P_Error_Rec := GEN_WS_ERROR_RT ('RG_EPIT_NF', 'Ο Α.Φ.Μ. δεν ανήκει και δεν ανήκε ποτέ σε επιτηδευματία.');
    WHEN P_AFM_CALLED_FOR = '001010103' THEN
      P_Error_Rec := GEN_WS_ERROR_RT ('GEN_OTHER_EXCEPTION', 'Σοβαρό πρόβλημα στη βάση δεδομένων');
    WHEN P_AFM_CALLED_FOR = '001010104' THEN
      P_Error_Rec :=
        GEN_WS_ERROR_RT ('GEN_EXCEPTION_ON_EXCEPTION'
                        ,'Σοβαρό πρόβλημα στη βάση δεδομένων και στο χειρισμό του λάθους που προέκυψε');
    WHEN P_AFM_CALLED_FOR = '001010105' THEN
--      P_Error_Rec :=
--        GEN_WS_ERROR_RT ('GEN_EXCEPTION_ON_EXCEPTION'
--                        ,'Σοβαρό πρόβλημα στη βάση δεδομένων και στο χειρισμό του λάθους που προέκυψε');

      P_BASIC_REC :=
        RG_WS_PUBLIC_BASIC_RT (P_AFM_CALLED_FOR -- AFM CHAR (12) -- ΑΦΜ  NOT NULL
                              ,'1209' -- DOY CHAR (4) -- ΔΟΥ  NOT NULL
                              ,'ΠΕΙΡΑΙΑ Δ(ΠΕΙΡΑΙΑ ΣΤ, Δ)' --DOY_DESCR VARCHAR2 (60) -- ΠΕΡΙΓΡΑΦΗ ΔΟΥ
                              ,'ΦΠ' --I_NI_FLAG_DESCR CHAR (5) --  (ΦΠ /ΜΗ ΦΠ)  NOT NULL
                              ,'1' --DEACTIVATION_FLAG CHAR (1) -- ΕΝΔΕΙΞΗ ΑΠΕΝΕΡΓ ΑΦΜ 1=ΕΝΕΡΓΟΣ ΑΦΜ 2=/ΑΠΕΝΕΡΓΟΠΟΙΗΜΕΝΟΣ ΑΦΜ NOT NULL
                              ,'ΕΝΕΡΓΟΣ ΑΦΜ' --DEACTIVATION_FLAG_DESCR CHAR (21) -- ΕΝΔΕΙΞΗ ΑΠΕΝΕΡΓ ΑΦΜ (ΕΝΕΡΓΟΣ ΑΦΜ/ΑΠΕΝΕΡΓΟΠΟΙΗΜΕΝΟΣ ΑΦΜ) NOT NULL
                              ,'ΠΡΩΗΝ ΕΠΙΤΗΔΕΥΜΑΤΙΑΣ' --FIRM_FLAG_DESCR CHAR (20) --  ΕΠΙΤΗΔΕΥΜΑΤΙΑΣ /ΜΗ ΕΠΙΤΗΔΕΥΜΑΤΙΑΣ /ΠΡΩΗΝ ΕΠΙΤΗΔΕΥΜΑΤΙΑΣ NOT NULL
                              ,'ΠΑΠΑΔΟΠΟΥΛΟΣ  ΣΩΤΗΡ ΑΝΑΣΤΑΣΙΟΣ' --ONOMASIA VARCHAR2 (120) -- Επωνυμία NOT NULL
                              ,NULL --COMMER_TITLE VARCHAR2 (80) -- Τίτλος Επιχείρησης
                              ,NULL --LEGAL_STATUS_DESCR VARCHAR2 (40) -- ΠΕΡΙΓΡΑΦΗ ΜΟΡΦΗΣ ΜΗ ΦΠ
                              ,NULL --POSTAL_ADDRESS VARCHAR2 (60) -- Οδός επιχείρησης
                              ,NULL --POSTAL_ADDRESS_NO CHAR (9) -- Αριθμός επιχείρησης
                              ,NULL --POSTAL_ZIP_CODE CHAR (5) -- ΤΑΧΥΚΩΔ επιχείρησης
                              ,NULL --PAR_DESCRIPTION VARCHAR2 (40) -- Περιοχή επιχείρησης
                              ,NULL --REGIST_DATE DATE --  Ημερ/νία Εναρξης
                              ,NULL --STOP_DATE DATE --  Ημερ/νία Διακοπής
                                   );

      P_FIRM_ACT_TAB.EXTEND (1);
      P_FIRM_ACT_TAB (P_FIRM_ACT_TAB.LAST) :=
        RG_WS_PUBLIC_FIRM_ACT_RT ( /* ΔΡΑΣΤΗΡΙΟΤΗΤΕΣ ΕΠΙΧΕΙΡΗΣΗΣ */
                                  72249 --FIRM_ACT_CODE NUMBER (8) -- Κωδικός δραστηριότητας  NOT NULL
                                 ,'30010000    ΚΑΤΑΣΚΕΥΗ ΜΗΧΑΝΩΝ ΓΡΑΦΕΙΟΥ' --FIRM_ACT_DESCR VARCHAR2 (300) -- Περιγραφή Κύριας Δραστηριότητας NOT NULL
                                 ,'1' --FIRM_ACT_KIND CHAR (1) -- Είδος δραστηριότητας 1=ΚΥΡΙΑ 2=ΔΕΥΤΕΡΕΥΟΥΣΑ 3=ΛΟΙΠΗ 4=ΒΟΗΘΗΤΙΚΗ  NOT NULL
                                     );

      P_FIRM_ACT_TAB.EXTEND (1);
      P_FIRM_ACT_TAB (P_FIRM_ACT_TAB.LAST) :=
        RG_WS_PUBLIC_FIRM_ACT_RT ( /* ΔΡΑΣΤΗΡΙΟΤΗΤΕΣ ΕΠΙΧΕΙΡΗΣΗΣ */
          72262 --FIRM_ACT_CODE NUMBER (8) -- Κωδικός δραστηριότητας  NOT NULL
         ,'30020000    ΚΑΤΑΣΚΕΥΗ ΗΛΕΚΤΡΟΝΙΚΩΝ ΥΠΟΛΟΓΙΣΤΩΝ ΚΑΙ ΛΟΙΠΟΥ ΕΞΟΠΛΙΣΜΟΥ ΠΛΗΡΟΦΟΡΙΚΗΣ' --FIRM_ACT_DESCR VARCHAR2 (300) -- Περιγραφή Κύριας Δραστηριότητας NOT NULL
         ,'2' --FIRM_ACT_KIND CHAR (1) -- Είδος δραστηριότητας 1=ΚΥΡΙΑ 2=ΔΕΥΤΕΡΕΥΟΥΣΑ 3=ΛΟΙΠΗ 4=ΒΟΗΘΗΤΙΚΗ  NOT NULL
        );
    ELSE
      P_Error_Rec := GEN_WS_ERROR_RT ('RG_TAXPAYER_NF', 'Ανύπαρκτος Α.Φ.Μ.');
  END CASE;
END rg_ws_public_afm_info_DEMO;
