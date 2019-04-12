package br.com.gff.estacionamento.utilitario;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.gff.estacionamento.negocios.Movimentacao;
/**
 * Representa uma classe de apoio �s demais do sistema
 * @author Giovane
 *
 */
public class EstacionamentoUtil {
	
	/**
	 * Valida a placa com o padr�o nacional LLL-NNNN
	 * L = Letra
	 * N = N�meto
	 * @param placa
	 * @return true se atender o padr�o e false se n�o
	 */
	public static boolean validarPadraoPlaca(String placa) {
		String padrao = "[A-Z][A-Z][A-Z]-\\d\\d\\d\\d"; //Cria��o do padr�o brasileiro de placas 3 letras 4 n�meros
		Pattern p = Pattern.compile(padrao); //Compila o padr�o 
		Matcher m = p.matcher(placa); //Aplica Matcher ao texto (placa) pada validar com o padrao (p)
		
		return m.matches(); //Verifica a placa est� de acordo com o padr�o p
	}
	
	/**
	 * O calculo do valor da estada do ve�culo baseado no tarif�rio
	 * e na hora de entrada e sa�da 
	 * 
	 * Altera a pr�pria inst�ncis da movimenta��o
	 * 
	 * @param movimentacao - Inst�ncis da movimenta��o
	 * 
	 */
	public void calcularPagamento(Movimentacao movimentacao) {
		//TODO implementar
	}

	/**
	 * Recupera uma propriedade do arquivo de configura��o da aplica��o
	 * configuration.txt
	 * @param string
	 * @return
	 */
	public static String get(String propriedade) {
		Properties prop = new Properties();
		String valor = null;
		try {
			prop.load(EstacionamentoUtil.class.getResourceAsStream("/recursos/configuration.txt"));
			// "/nome do pacote que est� o File/nome do arquivo de texto que tem as informa��es"
			//Um recurso pr�prio para ler arquivos File e mandar as informa��es para o Controller
			
			valor = prop.getProperty(propriedade); //Faz com que o valor receba as informa��es do File
			
		} catch (IOException e) {
			assert false : "Configura��o n�o carregada"; //Configura��o de um tratamento de bug para erro de informa��es
		} 
		
		return valor;
	}

	public static String getDataAsString(LocalDateTime dataHoraEntrada) {
		return dataHoraEntrada.toString();
	}
}
