/**
 * 
 */
package naztech.io.JDBCPractise;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import DAO.EmployeeDAO;
import DBUtil.DBConnection;
import Model.Employee;
import Services.EmployeeDAOimp;

/**
 * @author tanbirul.hashan
 *
 */
public class EmployeeDAOimpTest {

	private static EmployeeDAO empDAO;
	Employee emp;

	@BeforeClass
	public static void setUpBeforeClass() {
		DBConnection.EstablishDBConnection();
		empDAO = new EmployeeDAOimp();
	}

	@AfterClass
	public static void tearDownAfterClass() {
		DBConnection.closeDBConnection();
	}

	@Test
	public void addEmployeeTest() {
		emp = new Employee("Tanbir Hasan", 20000, "Bashundhara R/A");
		assertTrue(empDAO.addEmployee(emp));
	}

	@Test
	public void deleteEmployeeTest() {

		assertTrue(empDAO.deleteEmployee(12));

	}

	@Test
	public void updateEmployeeTest() {
		emp = new Employee("Tanu Tanbir", 20000, "Bashundhara R/A");
		emp.setEID(6);
		emp.setEName("Tanbir");
		assertThat(emp, is(empDAO.updateEmployee(emp)));

	}

	@Test
	public void FindEmployeeByIdTest() {
		emp = new Employee("Tanbir Hasan", 20000, "Bashundhara R/A");
		emp.setEID(6);
		empDAO.updateEmployee(emp);
		assertThat(emp, is(empDAO.FindEmployeeById(emp.getEID())));

	}

}
