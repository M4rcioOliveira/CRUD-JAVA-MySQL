package br.com.estoque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.estoque.factory.ConnectionFactory;
import br.com.estoque.model.Produto;

public class ProdutoDAO {

	public static void insert(Produto produto) {

		String sql = "INSERT INTO produtos (`nome`, `preco`, `quantidade`) VALUES (? , ? , ?)";
		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionFactory.createConnection();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, produto.getNome());
			pstm.setDouble(2, produto.getPreco());
			pstm.setInt(3, produto.getQuantidade());

			pstm.execute();

			System.out.println("Produto Inserido com Sucesso no Banco de Dados");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	public static void update(Produto produto, int id) {

		String sql = "UPDATE produtos SET nome = ? , preco = ? , quantidade = ? WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionFactory.createConnection();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, produto.getNome());
			pstm.setDouble(2, produto.getPreco());
			pstm.setInt(3, produto.getQuantidade());

			pstm.setInt(4, id);

			pstm.execute();

			System.out.println("Update realizado com sucesso!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	public static List<Produto> listarProdutos() {

		String sql = "SELECT * FROM produtos";

		List<Produto> produtos = new ArrayList<Produto>();

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {

			conn = ConnectionFactory.createConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {

				Produto produto = new Produto();

				produto.setNome(rs.getString("nome"));
				produto.setPreco(rs.getDouble("preco"));
				produto.setQuantidade(rs.getInt("quantidade"));

				produtos.add(produto);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		return produtos;

	}

	public static void delete(int id) {

		String sql = "DELETE from produtos WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionFactory.createConnection();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();
			
			System.out.println("Produto Deletado com Sucesso");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
