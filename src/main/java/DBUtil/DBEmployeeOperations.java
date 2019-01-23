/**
 * 
 */
package DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Employee;

/**
 * @author tanbirul.hashan
 *
 */

public class DBEmployeeOperations {

	public static boolean addEmployeeToDB(Employee emp) throws SQLException {

		String sql = "INSERT INTO NazTech_Employee ( eName, eSalary, eAddress) VALUES (?, ?, ?)";

		PreparedStatement statement = DBConnection.getConnectionObj().prepareStatement(sql);
		statement.setString(1, emp.getEName());
		statement.setInt(2, emp.getESalary());
		statement.setString(3, emp.getEAdress());

		return statement.executeUpdate() > 0 ? true : false;

	}

	public static boolean deleteEmployeeFromDB(int eId) throws SQLException {

		String sql = "DELETE FROM NazTech_Employee WHERE eId=?";

		PreparedStatement statement = DBConnection.getConnectionObj().prepareStatement(sql);
		statement.setInt(1, eId);

		return statement.executeUpdate() > 0 ? true : false;

	}

	public static Employee updateEmployeeToDB(Employee emp) throws SQLException {

		String sql = "UPDATE  NazTech_Employee  SET eName=?, eSalary=?, eAddress=? WHERE eId=?";

		PreparedStatement statement = DBConnection.getConnectionObj().prepareStatement(sql);
		statement.setString(1, emp.getEName());
		statement.setInt(2, emp.getESalary());
		statement.setString(3, emp.getEAdress());
		statement.setInt(4, emp.getEID());

		return statement.executeUpdate() > 0 ? emp : null;
	}

	public static Employee FindEmployeeFromDBById(int eId) throws SQLException {

		String sql = "SELECT * FROM NazTech_Employee WHERE eId=" + eId;

		Statement statement = DBConnection.getConnectionObj().createStatement();
		ResultSet result = statement.executeQuery(sql);

		return result.next() ? new Employee(result.getInt(1),result.getString(2), result.getInt(3), result.getString(4)) : null;
	}
	

}
