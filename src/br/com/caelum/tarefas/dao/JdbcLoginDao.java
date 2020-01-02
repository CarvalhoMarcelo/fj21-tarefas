package br.com.caelum.tarefas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.caelum.tarefas.ConnectionFactory;
import br.com.caelum.tarefas.modelo.Usuario;

public class JdbcLoginDao {
	
	Connection conn;
	
	public boolean login(Usuario usuario) {
		String sql = "select * from login where usuario=? and senha=?";
		boolean retorno = false;
		try {
			conn = new ConnectionFactory().getConnection();			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, usuario.getUsuario());
			stmt.setString(2, usuario.getSenha());			
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next())
				retorno = true;			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retorno;
	}	
}
