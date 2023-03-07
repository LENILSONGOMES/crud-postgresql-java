package conexao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoJdbc {
	private static String url = "jdbc:postgresql://localhost:5432/nome-db";
	private static String user = "usuario_db";
	private static String password = "senha_db";
	private static Connection connection = null;

	static {
		conectar();

	}

	public ConexaoJdbc() {
		conectar();
	}

	private static void conectar() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(url, user, password);
			connection.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}

}
