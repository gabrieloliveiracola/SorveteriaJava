package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexoes {
	public Connection getConnetion() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/sorveteriadb?", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
