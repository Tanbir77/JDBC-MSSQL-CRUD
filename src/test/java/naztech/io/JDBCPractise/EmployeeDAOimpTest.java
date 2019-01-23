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

import DBUtil.DBConnection;
import Model.Employee;
import Services.EmployeeDAOimp;

/**
 * @author tanbirul.hashan
 *
 */
public class EmployeeDAOimpTest {

	private static EmployeeDAOimp empDAOimp;
	Employee emp;

	@BeforeClass
	public static void setUpBeforeClass() {
		DBConnection.EstablishDBConnection();
		empDAOimp = new EmployeeDAOimp();
	}

	@AfterClass
	public static void tearDownAfterClass() {
		DBConnection.closeDBConnection();
	}

	@Test
	public void addEmployeeTest() {
		emp = new Employee("Tanbir Hasan", 20000, "Bashundhara R/A");
		assertTrue(empDAOimp.addEmployee(emp));
	}

	@Test
	public void deleteEmployeeTest() {
		
		assertTrue(empDAOimp.deleteEmployee(12));

	}

	@Test
	public void updateEmployeeTest() {
		emp = new Employee("Tanu Tanbir", 20000, "Bashundhara R/A");
		emp.setEID(6);
		emp.setEName("Tanbir");
		assertThat(emp, is(empDAOimp.updateEmployee(emp)));

	}

	@Test
	public void FindEmployeeByIdTest() {
		emp = new Employee("Tanbir Hasan", 20000, "Bashundhara R/A");
		emp.setEID(6);
		empDAOimp.updateEmployee(emp);
		assertThat(emp,  is(empDAOimp.FindEmployeeById(emp.getEID()) )    );
		
	}

}
