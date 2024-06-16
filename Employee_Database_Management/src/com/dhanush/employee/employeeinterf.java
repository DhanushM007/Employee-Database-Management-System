package com.dhanush.employee;

public interface employeeinterf {
	
	public void createEmployee(Employee emp);
	
	public void showAllEmployee();

	public void showEmployeeBasedOnId(int id);
	
	public void updateEmployee(int id,String name);
	public void updateEmployee(int id,int age);
	public void updateEmployee(int id,double sal);
	
	
	public void deleteEmployee(int id);
	public boolean isEmployeeExists(int id);
	
}
