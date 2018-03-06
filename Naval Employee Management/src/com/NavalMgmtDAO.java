package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class NavalMgmtDAO {
	
	Connection con = null ;
	public int addNavalOfficer(NavalOfficer no){

		con = DataBaseUtil.getConnection();
		int status = 0;
	
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * from TBL_Officer");
			while(rs.next()){
				if(rs.getLong(1)==no.getOfficerNo()){
					throw new OfficerAlreadyExistsException("The Officer already exists in the database.");
				}
			}
			
			PreparedStatement stmt=con.prepareStatement("insert into TBL_Officer values(?,?,?,?,?)");
			
			stmt.setInt(1,no.getOfficerNo());
			stmt.setString(2,no.getOfficerName());
			stmt.setString(3,no.getOfficerRank());
			stmt.setDouble(4,no.getOfficerSal());
			stmt.setInt(5,no.getBaseCampId());  
				
			status=stmt.executeUpdate();  
			
			if (status> 0){
				return status;
			}

		}catch(OfficerAlreadyExistsException ex){
			System.out.println(ex.getMessage());
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DataBaseUtil.closeConnection();
		}
		return 0;
	}
	
	public int addBaseCamp(BaseCamp bc){
		
		con = DataBaseUtil.getConnection();
		int status = 0;
	
		try {

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * from TBL_Base_Camp");
			while(rs.next()){
				if(rs.getLong(1)==bc.getBaseCampId()){
					throw new BaseCampAlreadyExistsException("The BaseCamp already exists in the database.");
				}
			}
			
			PreparedStatement stmt=con.prepareStatement("insert into TBL_Base_Camp values(?,?,?)");
			
			stmt.setInt(1,bc.getBaseCampId());
			stmt.setString(2,bc.getBaseCampName());
			stmt.setString(3,bc.getBaseCampLoc());
				
			status=stmt.executeUpdate();  
			
			if (status> 0){
				return status;
			}

		}catch(BaseCampAlreadyExistsException ex){
			System.out.println(ex.getMessage());
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DataBaseUtil.closeConnection();
		}
		return 0;

	}
	
	public ArrayList<String> getOfficersNameSortedBySal(){
		ArrayList<String> a=new ArrayList<>();
		con = DataBaseUtil.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT Officer_Name FROM TBL_Officer ORDER BY  Officer_Sal ");
			while(rs.next()){
				String s=rs.getString(1);
				a.add(s);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DataBaseUtil.closeConnection();
		}
	
		
		return a;
	}
	
	public ArrayList<String> getOfficersNameForBaseCampLoc(String baseCampLoc){
		
		ArrayList<String> a=new ArrayList<>();
		con = DataBaseUtil.getConnection();
		try {
			Statement st = con.createStatement();
					
			PreparedStatement statement = con.prepareStatement("SELECT Officer_Name FROM TBL_Officer WHERE Base_Camp_Id IN (SELECT Base_Camp_Id FROM TBL_Base_Camp WHERE Base_Camp_Loc = ? )");    
			statement.setString(1, baseCampLoc);    
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()){
				String q=rs.getString(1);
				a.add(q);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DataBaseUtil.closeConnection();
		}		
		return a;
		
	}
	
	public double getOfficersTotalSalOnBaseCamp(int i){
		double q = 0;
		ArrayList<String> a=new ArrayList<>();
		con = DataBaseUtil.getConnection();
		try {
			Statement st = con.createStatement();
					
			PreparedStatement statement = con.prepareStatement("SELECT Officer_Sal FROM TBL_Officer WHERE Base_Camp_Id IN (SELECT Base_Camp_Id FROM TBL_Base_Camp WHERE Base_Camp_Loc = ? )");    
			statement.setInt(1, 38);    
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()){
				 q=q+rs.getInt(1);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DataBaseUtil.closeConnection();
		}		
		
		return q;
	}
}
