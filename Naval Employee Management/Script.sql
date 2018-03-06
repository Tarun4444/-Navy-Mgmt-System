--<ScriptOptions statementTerminator=";"/>

CREATE TABLE  TBL_Officer(
         Officer_No     NUMBER(4) 		PRIMARY KEY,
         Officer_Name    VARCHAR2(25)	,
         Officer_Rank    VARCHAR2(25) 	,
         Officer_Sal	VARCHAR2(7)	,
		 Base_Camp_Id	number(5),
		 FOREIGN KEY (Base_Camp_Id) REFERENCES TBL_Base_Camp(Base_Camp_Id)
);

CREATE TABLE  TBL_Base_Camp(
         Base_Camp_Id      NUMBER(2)		PRIMARY KEY,
         Base_Camp_Name   VARCHAR2(50) 	,
         Base_Camp_Loc    VARCHAR2(50) 	
);


DROP table TBL_Officer;
DROP table TBL_Base_Camp;