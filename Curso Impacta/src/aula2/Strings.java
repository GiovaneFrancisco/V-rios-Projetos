package aula2;

public class Strings {
	public static void main(String[] args) {
		String frase1 = "Curso de Java";
		String frase2 = "CURSO DE JAVA";
		String frase3 = "Curso de JavaCURSO DE JAVA";
		
		System.out.println(frase1.length()); //Exibe o tamanho da String
		
		System.out.println(frase1.charAt(7)); //Mostra qual caractere está na casa ()
		
		System.out.println(frase1.equals(frase2)); //True se ambas forem iguais
		
		System.out.println(frase1.equalsIgnoreCase(frase2)); //True se ambas fores iguais (ignorando maiúsculas e acentuação)
		
		System.out.println(frase1.indexOf("J")); //Mostra qual casa está o caractere ()
		
		System.out.println(frase1.concat(" Giovane")); //Adiciona () no final da frase
		
		System.out.println(frase1.replaceAll("Java", "AAAAAAAAAA")); //Troca todos os 1os pelo 2o
		
		System.out.println(frase1.substring(2, 6)); //Mostra a frase entre o indice () e ()
		System.out.println(frase1.substring(2)); //Mostra a frase começando pelo índice até o final 
		
		System.out.println(frase1.toLowerCase()); //Deixa tudo em minúsculo
		System.out.println(frase1.toUpperCase()); //Deixa tudo em maiúsculo
		
		String frase = "                Curso de Java             ";
		System.out.println(frase.trim()); //Remove os espaços sobresalentes no começo e no final da frase
		
		String num1 = String.format("%10s > %-20s","5","10"); //Cria um formatador com espaços à esquerda e à direita
		String num2 = String.format("%12s < %-10s","10","4");
		String num3 = String.format("%14s > %-10s","10","20");
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		
		int idade = 18;
		String idadeStr = String.valueOf(idade); //Transforma o int em String
		
		double salario = 500.3;
		String salarioStr = String.valueOf(salario); //Transforma o double em String
		
	}
}
