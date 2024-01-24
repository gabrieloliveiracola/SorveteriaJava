package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Produto;

public class ProdutoDAO {
	private Connection connection;
	public ProdutoDAO() {
		connection = new FabricaConexoes().getConnetion();
	}
	
	public int inserir(Produto p) {
	   int inseriu = 0;
	   String sql = "INSERT INTO produto(cod, tipo, peso, preco) VALUES (?,?,?,?);";
	   PreparedStatement stmt;
	   try { 
		   stmt = (PreparedStatement) connection.prepareStatement(sql);
	       stmt.setString(1, p.getCod());
		   stmt.setString(2, p.getTipo());
	       stmt.setDouble(3, p.getPeso());
	       stmt.setDouble(4, p.getPreco());
		   inseriu = stmt.executeUpdate();
		   stmt.close();
	  } catch(SQLException e) {
		  e.printStackTrace();
	  }
	   return inseriu;
	}
	
	public ArrayList<Produto> getLista(){
		String sql = "SELECT * FROM produto;";
		PreparedStatement stmt;
		Produto p;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList <Produto> produtos = new ArrayList<>();
			while (rs.next()) {
				p = new Produto();
				p.setCod(rs.getString("cod"));
				p.setTipo(rs.getString("tipo"));
				p.setPeso(rs.getDouble("peso"));
				p.setPreco(rs.getDouble("preco"));
				produtos.add(p);
			}
			rs.close();
			stmt.close();
			return produtos;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int remover (Produto p) {
		int removeu = 0;
		String sql = "DELETE FROM produto WHERE cod like ?;";
		//String sql1 = "DELETE FROM compra WHERE cod_produto like ?;";
		PreparedStatement stmt;
		//PreparedStatement stmt1;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			//stmt1 = (PreparedStatement) connection.prepareStatement(sql1);
			stmt.setString(1, p.getCod());
			//stmt1.setInt(1, p.getCod());
			//stmt1.executeUpdate();
			removeu = stmt.executeUpdate();
			stmt.close();
			//stmt1.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return removeu;
	}
	
	public int alterar (Produto p) {
		int alterou = 0;
		String sql = "UPDATE produto SET tipo=?, peso=?, preco=? WHERE cod=?;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, p.getTipo());
		    stmt.setDouble(2, p.getPeso());
		    stmt.setDouble(3, p.getPreco());
		    stmt.setString(4, p.getCod());
			alterou = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alterou;
	}
	
	public ArrayList<String> getCodProdutos(){
		String sql = "SELECT cod FROM produto;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList <String> codProdutos = new ArrayList<>();
			while (rs.next()) {
				codProdutos.add(rs.getString("cod"));
			}
			rs.close();
			stmt.close();
			return codProdutos;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int quantProduto () {
		int quant = 0;
		String sql = "SELECT count(cod) as quantidade FROM produto;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				quant = rs.getInt("quantidade");
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return quant;
	}
	
	public int quantVezes(Produto p) {
		int quant_vezes = 0;
		String sql = "SELECT count(c.cod_produto) as quantidade FROM produto p, compra c WHERE c.cod_produto = ? and p.cod = c.cod_produto;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, p.getCod());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				quant_vezes = rs.getInt("quantidade");
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return quant_vezes;
	}
	public double valorProduto (Produto p) {
		int valor_produto = 0;
		String sql = "select p.preco from produto p, compra co where p.cod = ?; ";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, p.getCod());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				valor_produto = rs.getInt("preco");
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return valor_produto;
	}

}
