package com.dhanush.employee;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		employeeinterf obj= new employeeimple();
		
		System.out.println("welcome to Employee Database Management System");
		Scanner sc=new Scanner(System.in);
		do 
		{
			System.out.print("Menu\n1. Add Employee details\n2. Show all Employees details\n3. Show Employee details based on id\n4. update the employee details\n5. delete the employee details\n");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1: Employee emp=new Employee();
					System.out.print("Enter id:");
			   		int empid=sc.nextInt();
				
					if (obj.isEmployeeExists(empid)) 
					{
						System.out.print("ID already exists\nTry for someother ID\n");
						break;
					
					}
					else {
				
				   System.out.print("Enter name:");
				   String empname=sc.next();
				   System.out.print("Enter sal:");
				   Double empsal=sc.nextDouble();
				   System.out.print("Enter age:");
				   int age=sc.nextInt();
				   emp.setEmpid(empid);
				   emp.setEmpname(empname);
				   emp.setEmpsal(empsal);
				   emp.setAge(age);
 		           obj.createEmployee(emp);
				   break;
					}
			case 2:obj.showAllEmployee();
			       break;
			       
			case 3:System.out.println("enter id to show the details");
				   int id=sc.nextInt();
				   obj.showEmployeeBasedOnId(id);
				   break;
			case 4:System.out.println("enter id to update the details");
				   int ID=sc.nextInt();
				   if (obj.isEmployeeExists(ID)) 
				   {
				   System.out.println("select 1=name updation 2=salary updation 3=age updation");
				   int choice=sc.nextInt();
				 
				   switch(choice)
				   		{
			       		case 1: System.out.println("enter name to update");
			       		String name=sc.next();
			       		obj.updateEmployee(ID,name);
			       		break;
			       		
			       		case 2:System.out.println("enter salary to update");
			       		Double sal=sc.nextDouble();
			       		obj.updateEmployee(ID,sal);
			       		break;
			       		
			       		case 3:System.out.println("enter age to update");
			       		int age1=sc.nextInt();
			       		obj.updateEmployee(ID,age1);
			       		break;
			       		
			       		default:System.out.println("Enter valid option!");
				   		}
				   }
				   else {

					        System.out.println("Invalid ID");
				   		}
				   break;
				   
			case 5:System.out.println("enter id to delete");
			       int id1=sc.nextInt();
			       obj.deleteEmployee(id1);
			       break;
			default:
				    System.out.println("enter valid choice\n");
				    break;
				
			}
		}while(true);

	}

}
