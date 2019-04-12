package banco;

public class Main {

	public static void main(String[] args) throws SaldoInsuficienteException {
		Conta minhaConta = new Conta();
		minhaConta.deposita(500);
		minhaConta.sacar(501);
	}

}
