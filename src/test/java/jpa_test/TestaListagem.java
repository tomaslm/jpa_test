package jpa_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {
	public static void main(String[] args) throws SQLException {
		String stringConnection = "jdbc:postgresql://localhost:5432/loja_virtual";
		Connection connection = DriverManager.getConnection(stringConnection, "tomas", "");
		try (Statement statement = connection.createStatement()) {
			statement.execute("select * from Produto");
			try (ResultSet rs = statement.getResultSet()) {
				while (rs.next()) {
					String nome = rs.getString("nome");
					String descricao = rs.getString("descricao");
					Long id = rs.getLong("id");

					System.out.println("Nome: " + nome + ", " + descricao + ", " + id);
				}
			}
		}
		connection.close();
	}

}
