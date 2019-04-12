import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercicio {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		for(int i =0; i<10; i++) {
			for(int j =0; j<10; j++) {
				System.out.printf("%d %d\n", i, j);
			}
			System.out.println();
		}
}
}
