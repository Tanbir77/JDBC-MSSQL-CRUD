package DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBOrderOperations {
	public static void OrderReport() throws SQLException {
		DBConnection.EstablishDBConnection();
		String sql = "SELECT c.customer_name FROM T_customer AS c INNER JOIN T_customer_order AS co ON c.customer_id= co.customer_id";
		PreparedStatement statement = DBConnection.getConnectionObj().prepareStatement(sql);
		ResultSet result = statement.executeQuery();
		while (result.next()) {
			System.out.println(result.getString(1));
		}
	}
	public static void main(String [] args) {
		try {
			OrderReport();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
