package exercicios;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExercicioException_TratandoExcecao {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String frase;
		try {
			System.out.println("Digite alguma frase: ");
			frase = teclado.nextLine();
			PrintWriter writer = new PrintWriter("Documentos:\\Recovery.txt");
			writer.println(frase);
			writer.close();
		} catch (IOException e) {
			System.out.println("Falha ao gravar as informações digitadas");
		}
	}

}
