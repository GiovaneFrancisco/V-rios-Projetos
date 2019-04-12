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
	 * Faz o processamento do registro da entrada de um veículo baseado nas informações dadas pelo operador
	 * @param placa Placa do veículo
	 * @param marca Marca do veículo
	 * @param modelo Modelo do veículo
	 * @param cor Cor do veículo
	 * @throws EstacionamentoException Quando estacionamento estiver lotado
	 * @throws VeiculoException Quando a placa estiver incorreta
	 */
	public void processarEntrara(String placa, String marca, String modelo, String cor) throws EstacionamentoException, VeiculoException{
		//Verifica se o estacionamento está lotado
		if(!Vaga.temVagaLivre()) { //Se o estacionamento estiver lotado 
			throw new EstacionamentoException("Estacionamento lotado");
		}
		
		//Verifica o padrão da placa -> Fazer verificação redundante, no Controller e na interface para ter certeza
		if(!EstacionamentoUtil.validarPadraoPlaca(placa)) {
			throw new VeiculoException("Placa inválida");
		}
		
		//Cria uma instância do veículo 
		Veiculo veiculo = new Veiculo(placa, marca, modelo, cor);
		
		//Cria a movimentação do veículo com data de entrada corrente
		Movimentacao movimentacao = new Movimentacao(veiculo, LocalDateTime.now());
		
		//Registra as informações na base de dados
		DAOEstacionamento dao = new DAOEstacionamento();
		dao.criar(movimentacao);
		
		//Atualiza o número de vagas livres
		Vaga.entrou();
		
	}
	
	/**
	 * Faz o processamento da saída de veículo baseada na placa fornecida pelo operador
	 * @param placa
	 * @return
	 */
	public Movimentacao processarSaida(String placa) {
		//TODO implementar
		return null;
	}

	/**
	 * Cria uma lista de relatório baseado na data dado pelo administrador
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
