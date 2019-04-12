package br.com.gff.estacionamento.utilitario;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.gff.estacionamento.negocios.Movimentacao;
/**
 * Representa uma classe de apoio às demais do sistema
 * @author Giovane
 *
 */
public class EstacionamentoUtil {
	
	/**
	 * Valida a placa com o padrão nacional LLL-NNNN
	 * L = Letra
	 * N = Númeto
	 * @param placa
	 * @return true se atender o padrão e false se não
	 */
	public static boolean validarPadraoPlaca(String placa) {
		String padrao = "[A-Z][A-Z][A-Z]-\\d\\d\\d\\d"; //Criação do padrão brasileiro de placas 3 letras 4 números
		Pattern p = Pattern.compile(padrao); //Compila o padrão 
		Matcher m = p.matcher(placa); //Aplica Matcher ao texto (placa) pada validar com o padrao (p)
		
		return m.matches(); //Verifica a placa está de acordo com o padrão p
	}
	
	/**
	 * O calculo do valor da estada do veículo baseado no tarifário
	 * e na hora de entrada e saída 
	 * 
	 * Altera a própria instâncis da movimentação
	 * 
	 * @param movimentacao - Instâncis da movimentação
	 * 
	 */
	public void calcularPagamento(Movimentacao movimentacao) {
		//TODO implementar
	}

	/**
	 * Recupera uma propriedade do arquivo de configuração da aplicação
	 * configuration.txt
	 * @param string
	 * @return
	 */
	public static String get(String propriedade) {
		Properties prop = new Properties();
		String valor = null;
		try {
			prop.load(EstacionamentoUtil.class.getResourceAsStream("/recursos/configuration.txt"));
			// "/nome do pacote que está o File/nome do arquivo de texto que tem as informações"
			//Um recurso próprio para ler arquivos File e mandar as informações para o Controller
			
			valor = prop.getProperty(propriedade); //Faz com que o valor receba as informações do File
			
		} catch (IOException e) {
			assert false : "Configuração não carregada"; //Configuração de um tratamento de bug para erro de informações
		} 
		
		return valor;
	}

	public static String getDataAsString(LocalDateTime dataHoraEntrada) {
		return dataHoraEntrada.toString();
	}
}
