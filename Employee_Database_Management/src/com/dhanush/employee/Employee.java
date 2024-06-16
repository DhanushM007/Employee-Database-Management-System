package com.dhanush.employee;

public class Employee {
	private int empid;
	private String empname;
	private double empsal;
	private int age;
	
	public Employee()
	{
	
	}
	
	
	public Employee(int empid, String empname, double empsal, int age) {
	
		this.empid = empid;
		this.empname = empname;
		this.empsal = empsal;
		this.age = age;
	}

	public int getEmpid() 
	{
		return empid;
	}
	
	public void setEmpid(int empid) 
	{
		this.empid = empid;
	}
	
	public String getEmpname() 
	{
		return empname;
	}
	
	public void setEmpname(String empname) 
	{
		this.empname = empname;
	}
	
	public double getEmpsal() 
	{
		return empsal;
	}
	
	public void setEmpsal(double empsal) 
	{
		this.empsal = empsal;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public void setAge(int age) 
	{
		this.age = age;
	}


	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", empsal=" + empsal + ", age=" + age + "]";
	}
	
	
	
}
