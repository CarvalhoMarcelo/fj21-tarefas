package br.com.caelum.tarefas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.caelum.tarefas.ConnectionFactory;
import br.com.caelum.tarefas.modelo.Tarefa;


public class JdbcTarefaDao {	
	private final Connection conn;
	private PreparedStatement stmt;
	public JdbcTarefaDao() throws SQLException {
		this.conn = new ConnectionFactory().getConnection();
	}	

	public void adiciona(Tarefa tarefa) {		
		String sql = "insert into tarefas (descricao, finalizado) " +
		             "values (?, ?)";		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, tarefa.getDescricao());
			stmt.setBoolean(2, tarefa.isFinalizado());
			/* stmt.setDate(3, tarefa.getDataFinalizado().getTimeInMillis()); */
			stmt.execute();			
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void remove(Long id) throws SQLException {
		String sql = "delete from tarefas where id=?";
		stmt = conn.prepareStatement(sql);
		stmt.setLong(1, id);
		stmt.execute();	
		stmt.close();
	}		
	
	public Tarefa mostra(Long id) throws SQLException {
		String sql = "select * from tarefas where id=?";
		stmt = conn.prepareStatement(sql); 
		stmt.setLong(1, id);
		
		ResultSet rs = stmt.executeQuery();
		
		Tarefa tarefa = new Tarefa();
		
		while(rs.next()) {
			tarefa.setDescricao(rs.getString("descricao"));
			tarefa.setFinalizado(rs.getBoolean("finalizado"));
			tarefa.setId(rs.getLong("id"));
			
			if(rs.getDate("dataFinalizacao") != null) {
				Date data = new Date();
				data.setTime(rs.getDate("dataFinalizacao").getTime());
				Calendar cal = Calendar.getInstance();
				cal.setTime(data);
				tarefa.setDataFinalizacao(cal);
			}			
		}
		stmt.close();
		return tarefa;		
	}
	
	public void altera(Tarefa tarefa) throws SQLException {
		String sql = "update tarefas set descricao=?, finalizado=?, dataFinalizacao=? where id=?";
		stmt = conn.prepareStatement(sql);	
		
		stmt.setString(1, tarefa.getDescricao());
		stmt.setBoolean(2, tarefa.isFinalizado());		
		
		if(!tarefa.isFinalizado()) {
			stmt.setDate(3, null);
		}
		else {
			if(tarefa.getDataFinalizacao() != null) {			
				stmt.setDate(3, new java.sql.Date(tarefa.getDataFinalizacao().getTimeInMillis()));
			}
			else {
				stmt.setDate(3, new java.sql.Date(new Date().getTime()));
			}			
		}		
		
		stmt.setLong(4, tarefa.getId());	
		stmt.execute();
		stmt.close();
	}

	
	public List<Tarefa> lista() {
		String sql = "select * from tarefas";
		List<Tarefa> lista = new ArrayList<Tarefa>();
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Tarefa tarefa = new Tarefa();
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setFinalizado(rs.getBoolean("finalizado"));
				tarefa.setId(rs.getLong("id"));

				if(rs.getDate("dataFinalizacao") != null) {
					Date data = new Date();
					data = rs.getDate("dataFinalizacao");
					Calendar cal = Calendar.getInstance();
					cal.setTime(data);
					tarefa.setDataFinalizacao(cal);				
				}
				
				lista.add(tarefa);				
			}	
			
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;		
	}
	
	
	public void finalizaTarefa(Long id) throws SQLException {
		String sql = "update tarefas set finalizado=?, dataFinalizacao=? where id=?";
				
		stmt = conn.prepareStatement(sql);		
		stmt.setBoolean(1, true);		
		Calendar cal = Calendar.getInstance();		
		stmt.setDate(2, new java.sql.Date(cal.getTimeInMillis()));
		stmt.setLong(3, id);
				
		stmt.execute();
		stmt.close();				
				
	}
	

	public Tarefa buscaTarefa(Long id) throws SQLException {
		String sql = "select * from tarefas where id = ?";
		stmt = conn.prepareStatement(sql);
		stmt.setLong(1, id);
		
		ResultSet rs = stmt.executeQuery();
		Tarefa tarefa = null;
		
		while(rs.next()) {
			tarefa = new Tarefa();
			tarefa.setId(rs.getLong("id"));
			tarefa.setDescricao(rs.getString("descricao"));
			tarefa.setFinalizado(rs.getBoolean("finalizado"));			
			
			Date data = new Date();
			data.setTime(rs.getDate("dataFinalizacao").getTime());
			Calendar cal = Calendar.getInstance();
			cal.setTime(data);			
			tarefa.setDataFinalizacao(cal);
				
		}
		return tarefa;
		
	}
	
	

	
	
}
