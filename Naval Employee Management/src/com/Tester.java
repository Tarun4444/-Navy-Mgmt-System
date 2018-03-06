package com;

import java.util.ArrayList;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			
		NavalMgmtDAO dao=new NavalMgmtDAO();
		

		NavalOfficer no=new NavalOfficer(1800 ,"Harmeet Singh" , "Captain", 42000 ,35);
		
		NavalOfficer no1=new NavalOfficer(1810, "Rahul Gaur ","Vice Admiral", 57000, 38);
		NavalOfficer no2=new NavalOfficer(1992 ,"Sayan Paul", "Captain", 45000, 38);
		NavalOfficer no3=new NavalOfficer(8765 ,"Sumeet Tripathi" ,"Lieutenant" ,59000, 36);
		NavalOfficer no4=new NavalOfficer(9090, "Romi DSouza", "Vice Admiral", 55000 , 37);
		
		BaseCamp bc = new BaseCamp(35,"INS Kalinga","BHOPAL");
		BaseCamp bc1 = new BaseCamp(36,"INS Dronacharya","UDAIPUR");
		BaseCamp bc2= new BaseCamp(37, "INS Virbahu ","HARYANA");
		BaseCamp bc3 = new BaseCamp(38,"INS Kardip ","KOLKATA");
		
		dao.addBaseCamp(bc);
		dao.addBaseCamp(bc1);
		dao.addBaseCamp(bc2);
		dao.addBaseCamp(bc3);
		
		dao.addNavalOfficer(no);
		dao.addNavalOfficer(no1);
		dao.addNavalOfficer(no2);
		dao.addNavalOfficer(no3);
		dao.addNavalOfficer(no4);
		
		ArrayList<String> a=dao.getOfficersNameSortedBySal();
		
		for(int i=0;i<a.size();i++){
			System.out.println(a.get(i));
			i++;
		}
		String g="HARYANA";
		
		ArrayList<String> aa=dao.getOfficersNameForBaseCampLoc(g);
		
		for(int i=0;i<aa.size();i++){
			System.out.println(aa.get(i));
			i++;
		}
		
		//System.out.println(dao.getOfficersTotalSalOnBaseCamp(38));
	}

}

/*SCRAP BOOK
 * REATE TABLE  TBL_Officer(
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

 */


