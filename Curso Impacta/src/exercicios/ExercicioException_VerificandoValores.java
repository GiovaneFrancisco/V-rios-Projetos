package exercicios;

import java.util.Scanner;

public class ExercicioException_VerificandoValores {
	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		try {
			System.out.print("Digite o seu ano de nascimento: ");
			String ano = teclado.nextLine();
			int nascimento = Integer.parseInt(ano);
			int idade = 2018 - nascimento;
			System.out.println("Sua idade é: " + idade);
		} catch (NumberFormatException e) {
			System.out.println("Valor digitado inválido");
		}

	}
}
