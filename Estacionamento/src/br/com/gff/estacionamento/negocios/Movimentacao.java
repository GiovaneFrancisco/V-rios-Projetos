package br.com.gff.estacionamento.negocios;

import java.time.LocalDateTime;

/**
 * Repressenta o fluxo do veículo dentro do estacionamento
 * Contem as informações de entrada e saída, e do valor a ser pago
 * @author Giovane
 *
 */
public class Movimentacao {
	private Veiculo veiculo; 
	//Cria uma associação com a classe Veículo
	private LocalDateTime dataHoraEntrada;
	private LocalDateTime dataHoraSaida;
	public double valor;
	
	public Movimentacao (Veiculo veiculo, LocalDateTime dataEntrada) {
		//Criação de um cosntrutor
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
