package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Caixa;
import bean.Compra;
import bean.Produto;

public class CompraDAO {
	private Connection connection;
	public CompraDAO() {
		connection = new FabricaConexoes().getConnetion();
	}
	public int inserir(Compra co) {
	   int inseriu = 0;
	   String sql = "INSERT INTO compra(nota_fiscal, cod_produto, cpf_caixa, data, hora, nome_cliente) VALUES (?,?,?,?,?,?);";
	   PreparedStatement stmt;
	   try { 
		   stmt = (PreparedStatement) connection.prepareStatement(sql);
	       stmt.setString(1, co.getNota_fiscal());
		   stmt.setString(2, co.getCod_produto());
		   stmt.setString(3, co.getCpf_caixa());
	       stmt.setString(4, co.getData());
	       stmt.setString(5, co.getHora());
	       stmt.setString(6, co.getNome_cliente());
		   inseriu = stmt.executeUpdate();
		   stmt.close();
	  } catch(SQLException e) {
		  e.printStackTrace();
	  }
	   return inseriu;
	}
	
	public ArrayList<Compra> getLista(){
		String sql = "SELECT * FROM compra;";
		PreparedStatement stmt;
		Compra co;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList <Compra> compras = new ArrayList<>();
			while (rs.next()) {
				co = new Compra();
				co.setNota_fiscal(rs.getString("nota_fiscal"));
				co.setCod_produto(rs.getString("cod_produto"));
				co.setCpf_caixa(rs.getString("cpf_caixa"));
				co.setData(rs.getString("data"));
				co.setHora(rs.getString("hora"));
				co.setNome_cliente(rs.getString("nome_cliente"));
				compras.add(co);
			}
			rs.close();
			stmt.close();
			return compras;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int remover (Compra co) {
		int removeu = 0;
		String sql = "DELETE FROM compra WHERE nota_fiscal = ? and cod_produto = ? and cpf_caixa = ?;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, co.getNota_fiscal());
			stmt.setString(2, co.getCod_produto());
			stmt.setString(3, co.getCpf_caixa());
			removeu = stmt.executeUpdate();
			stmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return removeu;
	}
	
	public int alterar (Compra co) {
		int alterou = 0;
		String sql = "UPDATE compra SET data=?, hora=?, nome_cliente=? WHERE nota_fiscal like ? and cpf_caixa like ? and cod_produto like ?;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, co.getData());
			stmt.setString(2, co.getHora());
			stmt.setString(3, co.getNome_cliente());
			stmt.setString(4, co.getNota_fiscal());
			stmt.setString(5, co.getCpf_caixa());
			stmt.setString(6, co.getCod_produto());
			alterou = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alterou;
	}
	
	public int removerCompraProduto (Produto p ) {
		int removeu = 0;
		String sql = "DELETE FROM compra WHERE cod_produto like ?;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, p.getCod());
			removeu = stmt.executeUpdate();
			stmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return removeu;
	}
	
	public int removerCompraCaixa (Caixa c) {
		int removeu = 0;
		String sql = "DELETE FROM compra WHERE cpf_caixa like ?;";
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
	public ArrayList<String> getNota_Fiscal(){
		String sql = "SELECT nota_fiscal FROM compra;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList <String> notaFiscal = new ArrayList<>();
			while (rs.next()) {
				notaFiscal.add(rs.getString("nota_fiscal"));
			}
			rs.close();
			stmt.close();
			return notaFiscal;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public double valorTotal () {
		double valor_total = 0;
		String sql = "SELECT sum(p.preco) as valor_total FROM produto p, compra co WHERE p.cod = co.cod_produto;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				valor_total = rs.getInt("valor_total");
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return valor_total;
	}
	public ArrayList<Compra> getListaData(String data){
		String sql = "SELECT co.* FROM compra co WHERE co.data like ? ;";
		Compra co;
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, data);
			ResultSet rs = stmt.executeQuery();
			ArrayList <Compra> data_solicitada = new ArrayList<>();
			while (rs.next()) {
				co = new Compra();
				co.setNota_fiscal(rs.getString("nota_fiscal"));
				co.setCod_produto(rs.getString("cod_produto"));
				co.setCpf_caixa(rs.getString("cpf_caixa"));
				co.setData(rs.getString("data"));
				co.setHora(rs.getString("hora"));
				co.setNome_cliente(rs.getString("nome_cliente"));
				data_solicitada.add(co);
			}
			rs.close();
			stmt.close();
			return data_solicitada;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<String> getDataSolicitada(){
		String sql = "SELECT data FROM compra;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList <String> data = new ArrayList<>();
			while (rs.next()) {
				data.add(rs.getString("data"));
			}
			rs.close();
			stmt.close();
			return data;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
