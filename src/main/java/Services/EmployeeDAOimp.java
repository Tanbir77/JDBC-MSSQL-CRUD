/**
 * 
 */
package Services;

import java.sql.SQLException;

import DAO.EmployeeDAO;
import DBUtil.DBEmployeeOperations;
import Model.Employee;
import lombok.extern.slf4j.Slf4j;

/**
 * @author tanbirul.hashan
 *
 */
@Slf4j
public class EmployeeDAOimp implements EmployeeDAO {

	public boolean addEmployee(Employee emp) {
		try {
			return DBEmployeeOperations.addEmployeeToDB(emp);
		} catch (SQLException e) {
			log.error("Insertion Error", e);
		}
		return false;
	}

	public boolean deleteEmployee(int eId) {
		try {
			return DBEmployeeOperations.deleteEmployeeFromDB(eId);
		} catch (SQLException e) {
			log.error("Error during Deletation :", e);
		}
		return false;
	}

	public Employee updateEmployee(Employee emp) {
		try {
			return DBEmployeeOperations.updateEmployeeToDB(emp);
		} catch (SQLException e) {
			log.error("Error during UpdateDB :", e);
		}
		return null;
	}

	public Employee FindEmployeeById(int eId) {
		try {
			return DBEmployeeOperations.FindEmployeeFromDBById(eId);
		} catch (SQLException e) {
			log.error("Error during Searching user :", e);
		}
		return null;
	}

}
