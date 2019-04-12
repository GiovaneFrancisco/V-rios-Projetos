package funcional;

public class Principal {

	public static void main(String[] args) {
		OperacaoAritmetica funcao = (x, y) -> x + y;
		//System.out.println(funcao.execute(10, 13));
		exibirTabuada(funcao);
	}
	
	static void exibirTabuada(OperacaoAritmetica funcao) {
		for(int i = 1; i<=10; i++) {
			System.out.println("Tabuada de " + i);
			for(int j = 1; j<=10; j++) {
				System.out.printf("%d\t%d\t%.0f\n", i,j,funcao.execute(i, j));
			}
		}
	}
}
