package aula2;

public class StringsBuilders {
	public static void main(String[] args) {
		StringBuilder frase = new StringBuilder("Curso de Java");
		System.out.println("Original: " + frase);
		
		frase.append(" do Giovane"); //Adiciona uma frase no final
		System.out.println("Append: " + frase);
		
		frase.delete(0, 7); //Deleta a frase do 1o até o 2o
		System.out.println("Delete: " + frase);
		
		frase.insert(6, " AAAA"); //Adiciona uma frase no índice
		System.out.println("Insert: " + frase);
		
		
		
		
	}
}
