package banco;

public class Conta {
	int saldo;

	public void deposita(int valor) {
		this.saldo += valor;
	}

	public void sacar(int valor) throws SaldoInsuficienteException {
		if (saldo < valor) {
			int diferenca = valor - this.saldo;
			System.out.println("Saldo insuficiente para o saque");
			System.out.println("Saldo: R$" + this.saldo);
			System.out.println("Valor da tentativa de saque: R$" + valor);
			System.out.println("Diferença de valores: R$" + diferenca);
		} else {
			this.saldo -= valor;
			System.out.println("Saque realizado com sucesso");
		}
	}

}
