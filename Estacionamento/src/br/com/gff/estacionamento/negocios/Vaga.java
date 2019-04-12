package br.com.gff.estacionamento.negocios;

import br.com.gff.estacionamento.controle.EstacionamentoController;

/**
 * Representa as informa��es relativas � vagas 
 * do estacionamento ou status de ocupa��o
 * @author Giovane
 *
 */
public class Vaga {
	public static int TOTAL_VAGAS = 100;
	private static int vagasOcupadas = inicializarOcupadas();
	
	private Vaga() {}
	
	/**
	 * Verifica a exitencia de alguma vaga livre
	 * @return true se houver e false se estiver lotado
	 */
	public static boolean temVagaLivre() {
		return (vagasOcupadas < TOTAL_VAGAS);
	}
	
	/**
	 * Busca o status atual das vagas
	 */
	public static int inicializarOcupadas() {
		EstacionamentoController controle = new EstacionamentoController();
		return controle.inicializarOcupadas();
	}
	
	/**
	 * Retorna o n�mero de vagas ocupadas
	 * @return n�mero total de vagas ocupadas 
	 */
	public static int ocupadas() {
		return Vaga.vagasOcupadas;
	}
	
	/**
	 * Retorna o n�mero de vagas livres
	 * @return n�mero total de vagas livres
	 */
	public static int livres() {
		return TOTAL_VAGAS - Vaga.vagasOcupadas;
	}
	
	/**
	 * Atualiza o valor de vagas ocupadas ap�s a entrada
	 * de um ve�culo
	 */
	public static void entrou() {
		Vaga.vagasOcupadas ++;
	}
	
	
}
