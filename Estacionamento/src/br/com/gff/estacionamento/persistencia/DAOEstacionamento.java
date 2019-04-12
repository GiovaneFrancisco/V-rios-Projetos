package br.com.gff.estacionamento.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import br.com.gff.estacionamento.controle.EstacionamentoException;
import br.com.gff.estacionamento.negocios.Movimentacao;
import br.com.gff.estacionamento.negocios.Vaga;
import br.com.gff.estacionamento.utilitario.EstacionamentoUtil;

public class DAOEstacionamento {
	
	/**
	 * Armazena dados da movimentação
	 * @param movimentacao
	 * @throws EstacionamentoException Se houver erro de registro
	 */
	public void criar(Movimentacao movimentacao) throws EstacionamentoException {
		String cmd1 = EstacionamentoUtil.get("insertMov");
		String cmd2 = EstacionamentoUtil.get("atualizaVaga");
		
		Connection conexao = null;
		try {
			conexao = getConnection();
			conexao.setAutoCommit(false); //Faz com que seja possível executar mais de um comando na base de dados
		
			PreparedStatement stmt = conexao.prepareStatement(cmd1); //Faz com que o cmd1 seja lido e executado
				stmt.setString(1, movimentacao.getVeiculo().getPlaca());
				stmt.setString(2, movimentacao.getVeiculo().getMarca()); //Pega a marca informada pelo usuário
				stmt.setString(3, movimentacao.getVeiculo().getModelo()); //Pega o modelo informada pelo usuário
				stmt.setString(4, movimentacao.getVeiculo().getCor()); //Pega a cor informada pelo usuário
				stmt.setString(5, EstacionamentoUtil.getDataAsString(movimentacao.getDataHoraEntrada())); 
				//Criação de um método no EstacionamentoUtil para pegar a data e transformar em String
				stmt.execute(); //Executa o comando
		
				stmt = conexao.prepareStatement(cmd2); //Faz com que o cmd2 seja lido e executado
				stmt.setInt(1, Vaga.ocupadas()+1); //Chama o método e adiciona 1
		
				stmt.execute(); //Executa o comando
		
				conexao.commit();
		} catch (SQLException e) {
			try {
				conexao.rollback();
				throw new EstacionamentoException("Erro ao registrar veículo");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} 
	}
	
	public void atualizar(Movimentacao movimentacao) {
		//TODO implementar
	}
	
	public Movimentacao buscarMovimentacaoAberta(String placa) {
		//TODO implementar
		return null;
	}
	
	public List<Movimentacao> consultarMovimentacoes(LocalDateTime data){
		//TODO implementar
		return null;
	}
	
	/**
	 * Método para testar a conexão 
	 * @return
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException {
		
		String url = EstacionamentoUtil.get("url");
		//Criação de um método para pegar a URL do servidor de um jeito que não irá deixa-lo fixo
		
		String usuario = EstacionamentoUtil.get("usuario");
		//Criação de um método para pegar o nome do usuário
		
		String senha = EstacionamentoUtil.get("senha");
		//Criação de um método para pegar a senha do usuário
		
		Connection conexao = DriverManager.getConnection(url,usuario,senha); //Faz a conexao com o servidor
		
		return conexao;
		
	}
	
	public void closeConnection(Connection conexao) {
		if(conexao != null) { //Se a conexão estiver aberta
			try {
				conexao.close(); //Tente fechar a conexão
			} catch (SQLException e) {
				e.printStackTrace(); //Se der erro, imprima
			}
		}
	}

	public int getOcupadas() {
		int ocupadas = 0;
		Connection conexao = null;
		String cmd = EstacionamentoUtil.get("getOcupadas");
		try {
			conexao = getConnection(); //Faz conexão
			PreparedStatement ps = conexao.prepareStatement(cmd); //Executa o comando
			
			ResultSet resultado = ps.executeQuery(); //Atribui em uma variável
			if(resultado.next()) { //Se houver resultado
				ocupadas = resultado.getInt("ocupadas"); //ocupadas recebe o valor do banco de dados
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection(conexao);
		}
		return ocupadas;
	}
	
}
