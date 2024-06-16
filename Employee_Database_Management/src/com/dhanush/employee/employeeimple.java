package com.dhanush.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;





public class employeeimple implements employeeinterf {
	Connection con;
	@Override
	public void createEmployee(Employee emp)
	{
		 con=DBconnection.createDbconnection();
		 String query="insert into employee values(?,?,?,?)";
		 try 
		{
			 PreparedStatement pstm=con.prepareStatement(query);
			 pstm.setInt(1,emp.getEmpid());
			 pstm.setString(2,emp.getEmpname());
			 pstm.setDouble(3,emp.getEmpsal());
			 pstm.setInt(4,emp.getAge());
			 int cnt=pstm.executeUpdate();
			 if(cnt!=0)
				 System.out.println("inserted successfully");
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
		
	}
	@Override
	public void showAllEmployee()
	{

		 con=DBconnection.createDbconnection();
		 String query="SELECT * FROM employee";
		 System.out.println("-------------------------------------------------");
		 System.out.format("%s\t%s\t\t%s\t\t%s\n","ID","Name","Salary","Age");
		 System.out.println("-------------------------------------------------");
		 try 
		 {
			Statement stmt=con.createStatement();
			ResultSet result=stmt.executeQuery(query);
			while(result.next())
			{
				System.out.format("%d\t%s\t\t%.2f\t\t%d\n",result.getInt(1),result.getString(2),result.getDouble(3),result.getInt(4));
				System.out.println("-------------------------------------------------");
			}
		 } 
		 catch (Exception e) 
		 {
			e.printStackTrace();
			
		}
		
		
	}

	@Override
	public void showEmployeeBasedOnId(int id) 
	{
		 con=DBconnection.createDbconnection();
		 String query="SELECT * FROM employee where empid="+id;
		 try 
		 {
			 Statement stmt=con.createStatement();
			 ResultSet result=stmt.executeQuery(query);
			 boolean found = false;
		        while (result.next()) 
		        {
		            found = true;
		            System.out.format("%d\t%s\t\t%.2f\t\t%d\n", result.getInt(1), result.getString(2), result.getDouble(3), result.getInt(4));
		        }
		        if (found==false) {
		            System.out.println("Invalid ID\n");
		        }
				
		 } 
		 catch (Exception e) 
		 {
			 e.printStackTrace();
			
		 }
		 
		
		
	}
	@Override
	public void updateEmployee(int id,String name)
	{

		 con=DBconnection.createDbconnection();
		 String query="update employee set empname=? where empid=?";
		 try {
			 PreparedStatement pstm=con.prepareStatement(query);
			 pstm.setString(1,name);
			 pstm.setInt(2,id);
			
			 int cnt=pstm.executeUpdate();
			 if(cnt!=0)
				 System.out.println("Employee name updated succesfully");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void updateEmployee(int id,int age)
	{
		con=DBconnection.createDbconnection();
		 String query="update employee set age=? where empid=?";
		 try {
			 PreparedStatement pstm=con.prepareStatement(query);
			 pstm.setInt(1,age);
			 pstm.setInt(2,id);
			
			 int cnt=pstm.executeUpdate();
			 if(cnt!=0)
				 System.out.println("Employee age updated succesfully");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	@Override
	public void updateEmployee(int id,double sal)
	{
		con=DBconnection.createDbconnection();
		 String query="update employee set empsal=? where empid=?";
		 try {
			 PreparedStatement pstm=con.prepareStatement(query);
			 pstm.setDouble(1,sal);
			 pstm.setInt(2,id);
			
			 int cnt=pstm.executeUpdate();
			 if(cnt!=0)
				 System.out.println("Employee salary updated succesfully");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	@Override
	public void deleteEmployee(int id) {
		 con=DBconnection.createDbconnection();
		 String query="delete from employee where empid=?";
		 try {
			 PreparedStatement pstm=con.prepareStatement(query);
			 pstm.setInt(1,id);
			 int cnt=pstm.executeUpdate();
			 if(cnt!=0)
				 System.out.println("Employee Deleted Succesfully!");
			 
			 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public boolean isEmployeeExists(int ID) {
	    con = DBconnection.createDbconnection();
	    String query = "SELECT COUNT(*) FROM employee WHERE empid=?";
	    try {
	        PreparedStatement pstmt = con.prepareStatement(query);
	        pstmt.setInt(1, ID);
	        ResultSet result = pstmt.executeQuery();
	        if (result.next()) {
	            int count = result.getInt(1);
	            if (count > 0) {
	                return true;
	            }
	        }
	    } 
	    catch (Exception e) 
	    {
	        e.printStackTrace();
	    } 
	    return false;
	}
}

