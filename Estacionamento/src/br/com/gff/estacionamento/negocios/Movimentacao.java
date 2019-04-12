package br.com.gff.estacionamento.negocios;

import java.time.LocalDateTime;

/**
 * Repressenta o fluxo do ve�culo dentro do estacionamento
 * Contem as informa��es de entrada e sa�da, e do valor a ser pago
 * @author Giovane
 *
 */
public class Movimentacao {
	private Veiculo veiculo; 
	//Cria uma associa��o com a classe Ve�culo
	private LocalDateTime dataHoraEntrada;
	private LocalDateTime dataHoraSaida;
	public double valor;
	
	public Movimentacao (Veiculo veiculo, LocalDateTime dataEntrada) {
		//Cria��o de um cosntrutor
		this.veiculo = veiculo;
		this.dataHoraEntrada = dataEntrada;
	}
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public LocalDateTime getDataHoraEntrada() {
		return dataHoraEntrada;
	}
	public void setDataHoraEntrada(LocalDateTime dataHoraEntrada) {
		this.dataHoraEntrada = dataHoraEntrada;
	}
	public LocalDateTime getDataHoraSaida() {
		return dataHoraSaida;
	}
	public void setDataHoraSaida(LocalDateTime dataHoraSaida) {
		this.dataHoraSaida = dataHoraSaida;
	}
	
	
}
