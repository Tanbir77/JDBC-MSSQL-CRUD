package DAO;

import Model.Employee;

public interface EmployeeDAO {
	public boolean addEmployee(Employee emp);

	public Employee updateEmployee(Employee emp);

	public boolean deleteEmployee(int eId);

	public Employee FindEmployeeById(int eId);
}
