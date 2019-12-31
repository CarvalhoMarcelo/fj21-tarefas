package br.com.caelum.tarefas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.caelum.tarefas.ConnectionFactory_old;
import br.com.caelum.tarefas.modelo.Usuario_old;

public class JdbcUsuarioDao_old {
	private Connection connection;

	public JdbcUsuarioDao_old() {
		try {
			connection = new ConnectionFactory_old().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean existeUsuario(Usuario_old usuario) {

		if (usuario == null) {
			throw new IllegalArgumentException("Usuário não deve ser nulo");
		}

		try {
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from usuarios where login = ? and senha = ?");
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());
			ResultSet rs = stmt.executeQuery();

			boolean encontrado = rs.next();
			rs.close();
			stmt.close();

			return encontrado;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
