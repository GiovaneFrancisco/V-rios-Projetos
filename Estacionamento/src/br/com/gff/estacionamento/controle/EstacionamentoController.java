package br.com.gff.estacionamento.controle;

import java.time.LocalDateTime;
import java.util.List;

import br.com.gff.estacionamento.negocios.Movimentacao;
import br.com.gff.estacionamento.negocios.Vaga;
import br.com.gff.estacionamento.negocios.Veiculo;
import br.com.gff.estacionamento.persistencia.DAOEstacionamento;
import br.com.gff.estacionamento.utilitario.EstacionamentoUtil;

public class EstacionamentoController {

	/**
	 * Faz o processamento do registro da entrada de um ve�culo baseado nas informa��es dadas pelo operador
	 * @param placa Placa do ve�culo
	 * @param marca Marca do ve�culo
	 * @param modelo Modelo do ve�culo
	 * @param cor Cor do ve�culo
	 * @throws EstacionamentoException Quando estacionamento estiver lotado
	 * @throws VeiculoException Quando a placa estiver incorreta
	 */
	public void processarEntrara(String placa, String marca, String modelo, String cor) throws EstacionamentoException, VeiculoException{
		//Verifica se o estacionamento est� lotado
		if(!Vaga.temVagaLivre()) { //Se o estacionamento estiver lotado 
			throw new EstacionamentoException("Estacionamento lotado");
		}
		
		//Verifica o padr�o da placa -> Fazer verifica��o redundante, no Controller e na interface para ter certeza
		if(!EstacionamentoUtil.validarPadraoPlaca(placa)) {
			throw new VeiculoException("Placa inv�lida");
		}
		
		//Cria uma inst�ncia do ve�culo 
		Veiculo veiculo = new Veiculo(placa, marca, modelo, cor);
		
		//Cria a movimenta��o do ve�culo com data de entrada corrente
		Movimentacao movimentacao = new Movimentacao(veiculo, LocalDateTime.now());
		
		//Registra as informa��es na base de dados
		DAOEstacionamento dao = new DAOEstacionamento();
		dao.criar(movimentacao);
		
		//Atualiza o n�mero de vagas livres
		Vaga.entrou();
		
	}
	
	/**
	 * Faz o processamento da sa�da de ve�culo baseada na placa fornecida pelo operador
	 * @param placa
	 * @return
	 */
	public Movimentacao processarSaida(String placa) {
		//TODO implementar
		return null;
	}

	/**
	 * Cria uma lista de relat�rio baseado na data dado pelo administrador
	 * @param data
	 * @return
	 */
	public List<Movimentacao> emitirRelatorio(LocalDateTime data){
		//TODO implementar
		return null;
	}

	public int inicializarOcupadas() {
		DAOEstacionamento dao = new DAOEstacionamento();
		return dao.getOcupadas();
	}
}
