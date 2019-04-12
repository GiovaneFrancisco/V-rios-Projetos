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
	 * Armazena dados da movimenta��o
	 * @param movimentacao
	 * @throws EstacionamentoException Se houver erro de registro
	 */
	public void criar(Movimentacao movimentacao) throws EstacionamentoException {
		String cmd1 = EstacionamentoUtil.get("insertMov");
		String cmd2 = EstacionamentoUtil.get("atualizaVaga");
		
		Connection conexao = null;
		try {
			conexao = getConnection();
			conexao.setAutoCommit(false); //Faz com que seja poss�vel executar mais de um comando na base de dados
		
			PreparedStatement stmt = conexao.prepareStatement(cmd1); //Faz com que o cmd1 seja lido e executado
				stmt.setString(1, movimentacao.getVeiculo().getPlaca());
				stmt.setString(2, movimentacao.getVeiculo().getMarca()); //Pega a marca informada pelo usu�rio
				stmt.setString(3, movimentacao.getVeiculo().getModelo()); //Pega o modelo informada pelo usu�rio
				stmt.setString(4, movimentacao.getVeiculo().getCor()); //Pega a cor informada pelo usu�rio
				stmt.setString(5, EstacionamentoUtil.getDataAsString(movimentacao.getDataHoraEntrada())); 
				//Cria��o de um m�todo no EstacionamentoUtil para pegar a data e transformar em String
				stmt.execute(); //Executa o comando
		
				stmt = conexao.prepareStatement(cmd2); //Faz com que o cmd2 seja lido e executado
				stmt.setInt(1, Vaga.ocupadas()+1); //Chama o m�todo e adiciona 1
		
				stmt.execute(); //Executa o comando
		
				conexao.commit();
		} catch (SQLException e) {
			try {
				conexao.rollback();
				throw new EstacionamentoException("Erro ao registrar ve�culo");
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
	 * M�todo para testar a conex�o 
	 * @return
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException {
		
		String url = EstacionamentoUtil.get("url");
		//Cria��o de um m�todo para pegar a URL do servidor de um jeito que n�o ir� deixa-lo fixo
		
		String usuario = EstacionamentoUtil.get("usuario");
		//Cria��o de um m�todo para pegar o nome do usu�rio
		
		String senha = EstacionamentoUtil.get("senha");
		//Cria��o de um m�todo para pegar a senha do usu�rio
		
		Connection conexao = DriverManager.getConnection(url,usuario,senha); //Faz a conexao com o servidor
		
		return conexao;
		
	}
	
	public void closeConnection(Connection conexao) {
		if(conexao != null) { //Se a conex�o estiver aberta
			try {
				conexao.close(); //Tente fechar a conex�o
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
			conexao = getConnection(); //Faz conex�o
			PreparedStatement ps = conexao.prepareStatement(cmd); //Executa o comando
			
			ResultSet resultado = ps.executeQuery(); //Atribui em uma vari�vel
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
