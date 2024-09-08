package com.tap.model;
import java.io.Serializable;
public class UserModel  implements Serializable {
	   private static final long serialVersionUID = 1L;
    private int employeeId;
    private String firstName;
    private String lastName;
    private String department;
    private double salary;

    
    public UserModel(int employeeId, String firstName, String lastName, String department, double salary) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.salary = salary;
	}
    
    

	public UserModel(String firstName, String lastName, String department, double salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.salary = salary;
	}
	
	



	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}



	// Getters and Setters
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }



	@Override
	public String toString() {
		return "UserModel [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", department=" + department + ", salary=" + salary + "]";
	}
    
    
}
