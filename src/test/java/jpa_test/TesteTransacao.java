package jpa_test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TesteTransacao {

	Connection connection;

	@Before
	public void before() throws SQLException {
		this.connection = Database.getConnection();
		this.connection.setAutoCommit(false);
	}

	@After
	public void after() throws SQLException {
		this.connection.rollback();
		this.connection.close();
	}

	@Test
	public void shouldRollback() throws SQLException {
		try (PreparedStatement statement = connection
				.prepareStatement("insert into Produto(nome,descricao) values (?,?) ")) {

			statement.setString(1, "nome2");
			statement.setString(2, "descricao2");
			System.out.println(statement.execute());

			int i = 1 / 0;

			statement.setString(1, "nome3");
			statement.setString(2, "descricao3");
			System.out.println(statement.execute());

			connection.commit();
		} catch (Exception ex) {
			//System.out.println(ex);
		}

	}

	@Test
	public void shouldWorlLocally() throws SQLException {
		
		
		try (PreparedStatement statement = connection
				.prepareStatement("insert into Produto(nome,descricao) values (?,?) ")) {

			statement.setString(1, "asd");
			statement.setString(2, "asdDescricao");
			System.out.println(statement.execute());
		} catch (Exception ex) {
			System.out.println(ex);
		}
		try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM Produto WHERE nome=?")) {

			statement.setString(1, "asd");
			try (ResultSet rs = statement.executeQuery()) {
				assertTrue(rs.next());
				assertEquals("asd", rs.getString("nome"));
				assertEquals("asdDescricao", rs.getString("descricao"));
				System.out.println("success!");
			} catch (Exception ex) {
				System.out.println(ex);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}
}
