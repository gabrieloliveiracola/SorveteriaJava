package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Caixa;

public class CaixaDAO {
	private Connection connection;
	public CaixaDAO() {
		connection = new FabricaConexoes().getConnetion();
	}
	public int inserir(Caixa c) {
		int inseriu = 0;
	   String sql = "INSERT INTO Caixa(cpf, nome, salario, carga_horaria, cep, cidade, rua, estado, num) VALUES (?,?,?,?,?,?,?,?,?);";
	   PreparedStatement stmt;
	   try { 
		   stmt = (PreparedStatement) connection.prepareStatement(sql);
	       stmt.setString(1, c.getCpf());
		   stmt.setString(2, c.getNome());
	       stmt.setDouble(3, c.getSalario());
	       stmt.setString(4, c.getCarga_horaria());
	       stmt.setString(5, c.getCep());
	       stmt.setString(6, c.getCidade());
	       stmt.setString(7, c.getRua());
	       stmt.setString(8, c.getEstado());
	       stmt.setInt(9, c.getNum());
		   inseriu = stmt.executeUpdate();
		   stmt.close();
	  } catch(SQLException e) {
		  e.printStackTrace();
	  }
	   return inseriu;
	}
	
	public ArrayList<Caixa> getLista(){
		String sql = "SELECT * FROM Caixa;";
		PreparedStatement stmt;
		Caixa c;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList <Caixa> caixas = new ArrayList<>();
			while (rs.next()) {
				c = new Caixa();
				c.setCpf(rs.getString("cpf"));
				c.setNome(rs.getString("nome"));
				c.setSalario(rs.getDouble("salario"));
				c.setCarga_horaria(rs.getString("carga_horaria"));
				c.setCep(rs.getString("cep"));
				c.setCidade(rs.getString("cidade"));
				c.setRua(rs.getString("rua"));
				c.setEstado(rs.getString("estado"));
				c.setNum(rs.getInt("num"));
				caixas.add(c);
			}
			rs.close();
			stmt.close();
			return caixas;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int remover (Caixa c) {
		int removeu = 0;
		String sql = "DELETE FROM Caixa WHERE cpf = ?;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, c.getCpf());
			removeu = stmt.executeUpdate();
			stmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return removeu;
	}
	
	public int alterar (Caixa c) {
		int alterou = 0;
		String sql = "UPDATE Caixa SET nome=?, salario=?, carga_horaria=?, cep=?, cidade=?, rua=?, estado=?, num=? WHERE cpf=?;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, c.getNome());
		    stmt.setDouble(2, c.getSalario());
		    stmt.setString(3, c.getCarga_horaria());
		    stmt.setString(4, c.getCep());
		    stmt.setString(5, c.getCidade());
		    stmt.setString(6, c.getRua());
		    stmt.setString(7, c.getEstado());
		    stmt.setInt(8, c.getNum());
		    stmt.setString(9, c.getCpf());
			alterou = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alterou;
	}
	public ArrayList<String> getCpfCaixas(){
		String sql = "SELECT cpf FROM caixa;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList <String> cpfCaixas = new ArrayList<>();
			while (rs.next()) {
				cpfCaixas.add(rs.getString("cpf"));
			}
			rs.close();
			stmt.close();
			return cpfCaixas;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public int quantCompras(Caixa c) {
		int quant_compras = 0;
		String sql = "SELECT count(co.cpf_caixa) as quantidade FROM caixa c, compra co WHERE c.cpf = ? and c.cpf = co.cpf_caixa;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, c.getCpf());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				quant_compras = rs.getInt("quantidade");
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return quant_compras;
	}
	public ArrayList<Caixa> getListaMaior(){
		String sql = "SELECT c.nome, c.salario FROM caixa c WHERE c.salario = (SELECT max(salario) FROM caixa);";
		PreparedStatement stmt;
		Caixa c;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList <Caixa> maiorCaixa = new ArrayList<>();
			while (rs.next()) {
				c = new Caixa();
				c.setNome(rs.getString("nome"));
				c.setSalario(rs.getDouble("salario"));
				maiorCaixa.add(c);
			}
			rs.close();
			stmt.close();
			return maiorCaixa;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Caixa> getListaMenor(){
		String sql = "SELECT c.nome, c.salario FROM caixa c WHERE c.salario = (SELECT min(salario) FROM caixa);";
		PreparedStatement stmt;
		Caixa c;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList <Caixa> maiorCaixa = new ArrayList<>();
			while (rs.next()) {
				c = new Caixa();
				c.setNome(rs.getString("nome"));
				c.setSalario(rs.getDouble("salario"));
				maiorCaixa.add(c);
			}
			rs.close();
			stmt.close();
			return maiorCaixa;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
