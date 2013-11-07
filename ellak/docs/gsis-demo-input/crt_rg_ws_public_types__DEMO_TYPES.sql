

CREATE OR REPLACE TYPE RG_WS_PUBLIC_BASIC_RT AS OBJECT
(
  AFM CHAR (12) -- ���  NOT NULL
 ,DOY CHAR (4) -- ���  NOT NULL
 ,DOY_DESCR VARCHAR2 (60) -- ��������� ���
 ,I_NI_FLAG_DESCR CHAR (5) --  (�� /�� ��)  NOT NULL
 ,DEACTIVATION_FLAG CHAR (1) -- ������� ������� ��� 1=������� ��� 2=/����������������� ��� NOT NULL
 ,DEACTIVATION_FLAG_DESCR CHAR (21) -- ������� ������� ��� (������� ���/����������������� ���) NOT NULL
 ,FIRM_FLAG_DESCR CHAR (20) --  �������������� /�� �������������� /����� �������������� NOT NULL
 ,ONOMASIA VARCHAR2 (120) -- �������� NOT NULL
 ,COMMER_TITLE VARCHAR2 (80) -- ������ �����������
 ,LEGAL_STATUS_DESCR VARCHAR2 (40) -- ��������� ������ �� ��
 ,POSTAL_ADDRESS VARCHAR2 (60) -- ���� �����������
 ,POSTAL_ADDRESS_NO CHAR (9) -- ������� �����������
 ,POSTAL_ZIP_CODE CHAR (5) -- ������� �����������
 ,PAR_DESCRIPTION VARCHAR2 (40) -- ������� �����������
 ,REGIST_DATE DATE --  ����/��� �������
 ,STOP_DATE DATE --  ����/��� ��������
)
/

CREATE OR REPLACE TYPE RG_WS_PUBLIC_FIRM_ACT_RT AS OBJECT
( /* �������������� ����������� */
  FIRM_ACT_CODE NUMBER (8) -- ������� ��������������  NOT NULL
 ,FIRM_ACT_DESCR VARCHAR2 (300) -- ��������� ������ �������������� NOT NULL
 ,FIRM_ACT_KIND CHAR (1) -- ����� �������������� 1=����� 2=������������ 3=����� 4=���������  NOT NULL
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