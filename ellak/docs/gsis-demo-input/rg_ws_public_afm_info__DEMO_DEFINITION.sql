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
      P_Error_Rec := GEN_WS_ERROR_RT ('RG_WRONG_AFM', '����� �.�.�.');
    WHEN P_AFM_CALLED_FOR = '001010101' THEN
      P_Error_Rec := GEN_WS_ERROR_RT ('RG_TAXPAYER_NF', '���������� �.�.�.');
    WHEN P_AFM_CALLED_FOR = '001010102' THEN
      P_Error_Rec := GEN_WS_ERROR_RT ('RG_EPIT_NF', '� �.�.�. ��� ������ ��� ��� ����� ���� �� �������������.');
    WHEN P_AFM_CALLED_FOR = '001010103' THEN
      P_Error_Rec := GEN_WS_ERROR_RT ('GEN_OTHER_EXCEPTION', '������ �������� ��� ���� ���������');
    WHEN P_AFM_CALLED_FOR = '001010104' THEN
      P_Error_Rec :=
        GEN_WS_ERROR_RT ('GEN_EXCEPTION_ON_EXCEPTION'
                        ,'������ �������� ��� ���� ��������� ��� ��� �������� ��� ������ ��� ��������');
    WHEN P_AFM_CALLED_FOR = '001010105' THEN
--      P_Error_Rec :=
--        GEN_WS_ERROR_RT ('GEN_EXCEPTION_ON_EXCEPTION'
--                        ,'������ �������� ��� ���� ��������� ��� ��� �������� ��� ������ ��� ��������');

      P_BASIC_REC :=
        RG_WS_PUBLIC_BASIC_RT (P_AFM_CALLED_FOR -- AFM CHAR (12) -- ���  NOT NULL
                              ,'1209' -- DOY CHAR (4) -- ���  NOT NULL
                              ,'������� �(������� ��, �)' --DOY_DESCR VARCHAR2 (60) -- ��������� ���
                              ,'��' --I_NI_FLAG_DESCR CHAR (5) --  (�� /�� ��)  NOT NULL
                              ,'1' --DEACTIVATION_FLAG CHAR (1) -- ������� ������� ��� 1=������� ��� 2=/����������������� ��� NOT NULL
                              ,'������� ���' --DEACTIVATION_FLAG_DESCR CHAR (21) -- ������� ������� ��� (������� ���/����������������� ���) NOT NULL
                              ,'����� ��������������' --FIRM_FLAG_DESCR CHAR (20) --  �������������� /�� �������������� /����� �������������� NOT NULL
                              ,'������������  ����� ����������' --ONOMASIA VARCHAR2 (120) -- �������� NOT NULL
                              ,NULL --COMMER_TITLE VARCHAR2 (80) -- ������ �����������
                              ,NULL --LEGAL_STATUS_DESCR VARCHAR2 (40) -- ��������� ������ �� ��
                              ,NULL --POSTAL_ADDRESS VARCHAR2 (60) -- ���� �����������
                              ,NULL --POSTAL_ADDRESS_NO CHAR (9) -- ������� �����������
                              ,NULL --POSTAL_ZIP_CODE CHAR (5) -- ������� �����������
                              ,NULL --PAR_DESCRIPTION VARCHAR2 (40) -- ������� �����������
                              ,NULL --REGIST_DATE DATE --  ����/��� �������
                              ,NULL --STOP_DATE DATE --  ����/��� ��������
                                   );

      P_FIRM_ACT_TAB.EXTEND (1);
      P_FIRM_ACT_TAB (P_FIRM_ACT_TAB.LAST) :=
        RG_WS_PUBLIC_FIRM_ACT_RT ( /* �������������� ����������� */
                                  72249 --FIRM_ACT_CODE NUMBER (8) -- ������� ��������������  NOT NULL
                                 ,'30010000    ��������� ������� ��������' --FIRM_ACT_DESCR VARCHAR2 (300) -- ��������� ������ �������������� NOT NULL
                                 ,'1' --FIRM_ACT_KIND CHAR (1) -- ����� �������������� 1=����� 2=������������ 3=����� 4=���������  NOT NULL
                                     );

      P_FIRM_ACT_TAB.EXTEND (1);
      P_FIRM_ACT_TAB (P_FIRM_ACT_TAB.LAST) :=
        RG_WS_PUBLIC_FIRM_ACT_RT ( /* �������������� ����������� */
          72262 --FIRM_ACT_CODE NUMBER (8) -- ������� ��������������  NOT NULL
         ,'30020000    ��������� ������������ ����������� ��� ������ ���������� ������������' --FIRM_ACT_DESCR VARCHAR2 (300) -- ��������� ������ �������������� NOT NULL
         ,'2' --FIRM_ACT_KIND CHAR (1) -- ����� �������������� 1=����� 2=������������ 3=����� 4=���������  NOT NULL
        );
    ELSE
      P_Error_Rec := GEN_WS_ERROR_RT ('RG_TAXPAYER_NF', '���������� �.�.�.');
  END CASE;
END rg_ws_public_afm_info_DEMO;
