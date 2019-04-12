package br.com.gff.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DAO {
	Connection conexao = null; // Puxa o status da conexão do banco de dados
	PreparedStatement pst = null; // Executa os comandos do banco
	ResultSet rs = null; // Recupera os valores do banco

	/**
	 * Faz a cnexão com o BD, essencial para todos os outros métodos funcionárem
	 * 
	 * @return
	 */
	public Connection conectar() {
		String driver = "com.mysql.jdbc.Driver"; // Caminho para chegar no banco
		String url = "jdbc:mysql://192.168.2.119:3306/brigadeiro?useSSL=false"; // //ip:porta padrão/nome do
																				// banco/ignorar criptografia
		String user = "root"; // Define o nome do usuário
		String senha = "tobinho1"; // Define a senha do usuário
		try {
			Class.forName(driver);
			conexao = DriverManager.getConnection(url, user, senha); // Tenta fazer a coneção com o BD
			return conexao;
		} catch (SQLException e) { // Caso haja erro de comunicação com o Banco de dados Crie uma mensagem de erro
			JOptionPane.showMessageDialog(null, "Erro ao comunicar com o banco de dados", "Erro",
					JOptionPane.ERROR_MESSAGE);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conexao;
	}

	public void registrar(String nome, String data, String tipo, String sabor1, String sabor2, String sabor3, String sabor4, String sabor5, String nota) {
		conectar();

		String adicionar = "insert into tb_brigadeiro(nome,data,tipo, 1_sabor, 2_sabor, 3_sabor, 4_sabor, 5_sabor, nota) values(?,?,?,?,?,?,?,?,?)";

		try {
			pst = conexao.prepareStatement(adicionar);
			pst.setString(1, nome);
			pst.setString(2, data);
			pst.setString(3, tipo);
			pst.setString(4, sabor1);
			pst.setString(5, sabor2);
			pst.setString(6, sabor3);
			pst.setString(7, sabor4);
			pst.setString(8, sabor5);
			pst.setString(9, nota);
			
			int adc = pst.executeUpdate(); // Inserir ou alterar uma linha na tabela
			if (adc > 0) {
				JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso", "Adicionado",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception ee) {
			ee.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto", "Erro", JOptionPane.ERROR_MESSAGE);
		}

	}

}
