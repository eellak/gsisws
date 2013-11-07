

CREATE OR REPLACE TYPE RG_WS_PUBLIC_BASIC_RT AS OBJECT
(
  AFM CHAR (12) -- ΑΦΜ  NOT NULL
 ,DOY CHAR (4) -- ΔΟΥ  NOT NULL
 ,DOY_DESCR VARCHAR2 (60) -- ΠΕΡΙΓΡΑΦΗ ΔΟΥ
 ,I_NI_FLAG_DESCR CHAR (5) --  (ΦΠ /ΜΗ ΦΠ)  NOT NULL
 ,DEACTIVATION_FLAG CHAR (1) -- ΕΝΔΕΙΞΗ ΑΠΕΝΕΡΓ ΑΦΜ 1=ΕΝΕΡΓΟΣ ΑΦΜ 2=/ΑΠΕΝΕΡΓΟΠΟΙΗΜΕΝΟΣ ΑΦΜ NOT NULL
 ,DEACTIVATION_FLAG_DESCR CHAR (21) -- ΕΝΔΕΙΞΗ ΑΠΕΝΕΡΓ ΑΦΜ (ΕΝΕΡΓΟΣ ΑΦΜ/ΑΠΕΝΕΡΓΟΠΟΙΗΜΕΝΟΣ ΑΦΜ) NOT NULL
 ,FIRM_FLAG_DESCR CHAR (20) --  ΕΠΙΤΗΔΕΥΜΑΤΙΑΣ /ΜΗ ΕΠΙΤΗΔΕΥΜΑΤΙΑΣ /ΠΡΩΗΝ ΕΠΙΤΗΔΕΥΜΑΤΙΑΣ NOT NULL
 ,ONOMASIA VARCHAR2 (120) -- Επωνυμία NOT NULL
 ,COMMER_TITLE VARCHAR2 (80) -- Τίτλος Επιχείρησης
 ,LEGAL_STATUS_DESCR VARCHAR2 (40) -- ΠΕΡΙΓΡΑΦΗ ΜΟΡΦΗΣ ΜΗ ΦΠ
 ,POSTAL_ADDRESS VARCHAR2 (60) -- Οδός επιχείρησης
 ,POSTAL_ADDRESS_NO CHAR (9) -- Αριθμός επιχείρησης
 ,POSTAL_ZIP_CODE CHAR (5) -- ΤΑΧΥΚΩΔ επιχείρησης
 ,PAR_DESCRIPTION VARCHAR2 (40) -- Περιοχή επιχείρησης
 ,REGIST_DATE DATE --  Ημερ/νία Εναρξης
 ,STOP_DATE DATE --  Ημερ/νία Διακοπής
)
/

CREATE OR REPLACE TYPE RG_WS_PUBLIC_FIRM_ACT_RT AS OBJECT
( /* ΔΡΑΣΤΗΡΙΟΤΗΤΕΣ ΕΠΙΧΕΙΡΗΣΗΣ */
  FIRM_ACT_CODE NUMBER (8) -- Κωδικός δραστηριότητας  NOT NULL
 ,FIRM_ACT_DESCR VARCHAR2 (300) -- Περιγραφή Κύριας Δραστηριότητας NOT NULL
 ,FIRM_ACT_KIND CHAR (1) -- Είδος δραστηριότητας 1=ΚΥΡΙΑ 2=ΔΕΥΤΕΡΕΥΟΥΣΑ 3=ΛΟΙΠΗ 4=ΒΟΗΘΗΤΙΚΗ  NOT NULL
)
/

CREATE OR REPLACE TYPE RG_WS_PUBLIC_FIRM_ACT_TT IS TABLE OF RG_WS_PUBLIC_FIRM_ACT_RT
/

CREATE OR REPLACE TYPE GEN_WS_ERROR_RT AS OBJECT
(
  ERROR_CODE VARCHAR2 (60)
 ,ERROR_DESCR VARCHAR2 (200)
)
/