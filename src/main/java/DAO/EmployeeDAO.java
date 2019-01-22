package DAO;

import Model.Employee;

public interface EmployeeDAO {
	public boolean addEmployee(Employee emp);
	public Employee updateEmployee(int eId);
	public Employee deleteEmployee(int eId);
	public Employee FindEmployeeById(int eId);
}
