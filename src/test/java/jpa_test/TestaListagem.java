package jpa_test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestaListagem {


	@Test
	public void shouldList() throws SQLException {
		try (Connection connection = Database.getConnection()) {
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

		}
	}

	@Test
	public void shouldInsert() throws SQLException {
		try (Connection connection = Database.getConnection()) {
			try (Statement statement = connection.createStatement()) {
				System.out.println(statement
						.execute("insert into Produto(nome,descricao) " + "values ('notebook','notebook semi-novo')	"));

			}

		}
	}

	@Test
	public void shouldPreventSqlInjection() throws SQLException {
		try (Connection connection = Database.getConnection()) {
			try (PreparedStatement statement = connection
					.prepareStatement("insert into Produto(nome,descricao) values (?,?) ")) {
				statement.setString(1, "nome");
				statement.setString(2, "descricao");
				System.out.println(statement.execute());

			}

		}
	}

	@Test
	public void shouldDelete() throws SQLException {
		try (Connection connection = Database.getConnection()) {
			try (Statement statement = connection.createStatement()) {
				System.out.println(statement.execute("delete from Produto " + " where id > 3"));

			}

		}
	}

}
