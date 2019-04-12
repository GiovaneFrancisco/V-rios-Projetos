package aula1;

public class Array {
	public static void main(String[] args) {

		/**
		 * Tipos e nomeações de Arrays
		 */
		double[] salario; // Criação do Array

		/**
		 * Tamanho do Aray
		 */
		salario = new double[5]; // Quantificação do Array
		float comprimento[] = new float[3]; // Criação e quantificação do Array
		String telefone[] = { "1111-1111", "2222-2222", "3333-3333", "4444-4444" }; // Criação e preenchimento do Array

		/**
		 * Preenchimento do Array
		 */
		salario[0] = 1250.3;
		salario[1] = 520.6;
		salario[2] = 5200;
		salario[3] = 2500.15;
		salario[4] = 840.2;

		/**
		 * Varredura do Array
		 */
		for (int i = 0; i < salario.length; i++) { // (int [contador] = 0; [contador] < comprimento do Array;
													// [contador]++
			System.out.println(salario[i]); // Escreve o Array na posição [i]
		}

		System.out.println();

		for (double s : salario) { // ([tipo] [variável] : (Array))
			System.out.println(s); // Escreve todo o conteúdo do (Array)
		}
		System.out.println();
		
		/**
		 * Array Bidimensional/Matriz
		 */
		int[][] matricula = new int[3][3]; //Criação da matriz [linha][coluna]
		matricula[0][0] = 11; //Preenchimento da matriz
		matricula[0][1] = 12;
		matricula[0][2] = 13;
		matricula[1][0] = 21;
		matricula[1][1] = 22;
		matricula[1][2] = 23;
		matricula[2][0] = 31;
		matricula[2][1] = 32;
		matricula[2][2] = 33;
		for (int l = 0; l < matricula.length; l++) { //Para cada linha
			for (int c = 0; c < matricula.length; c++) { //Para cada coluna
				System.out.print(matricula[l][c] + "    "); //Escreva a linha e a coluna
			}
			System.out.println(); //Faz com que fique com efeito 3X3
		}
		
		System.out.println();
		int numero[][] = {
						 {11, 12, 13},
						 {21, 22, 23},
						 {31, 32, 33}
						 };
		for(int[]linha : numero) {
			for(int celula : linha) {
				System.out.println(celula);
			}
			System.out.println();
		}
		
		/**
		 * Array de objetos
		 */
		Conta[] c = new Conta[2];
		//Quando não houver um construtor
		//c[0] = new Conta();
		c[0].setNumero(5003);
		c[0].setNome("Giovane");
		c[0].setSaldo(800.0);
		
		//c[1] = new Conta();
		c[1].setNumero(5004);
		c[1].setNome("Luiza");
		c[1].setSaldo(650.0);
		
		//Quando houver contrutor
		Conta[] co = {
				new Conta(5000, "Deboráh", 1000.0),
				new Conta(5001, "Larissa", 2000.0),
				new Conta(5002, "Alguém", 3000.0),
		};
		
		
		
		
		
		
		
		
	}
}
