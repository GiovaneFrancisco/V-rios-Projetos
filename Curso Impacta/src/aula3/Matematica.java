package aula3;

public class Matematica {
	public static void main(String[] args) {
		double a = 3123.9012;
		double b = 5;
		double angulo = Math.PI/2;
		
		double abs = Math.abs(a); //Valor absoluto
		System.out.println(abs);
		
		double sen = Math.sin(angulo); //Seno 
		System.out.println(sen);
		
		double cos = Math.cos(angulo); //Cosseno
		System.out.println(cos);
		
		double tg = Math.tan(angulo); //Tangente
		System.out.println(tg);
		
		double anguloC = Math.toDegrees(angulo); //Muda de radiano pra Grau
		System.out.println(anguloC);
		
		double anguloR = Math.toRadians(anguloC); //Muda de grau pra radiano
		System.out.println(anguloR);
		
		double log = Math.log(angulo); //Logarítmo
		System.out.println(log);
		
		double max = Math.max(a,b); //Valor máximo
		System.out.println(max);
		
		double min = Math.min(a,b); //Valor mínimo
		System.out.println(min);
		
		double pow = Math.pow(a,b); //Potência com (base,expoente)
		System.out.println(pow);
		
		double random = Math.random(); //Valor aleatório entre 0 e 1
		System.out.println(random);

		double round = Math.round(a); //Arredonda numericamente
		System.out.println(round);

		double sqrt = Math.sqrt(a); //Raiz quadrada
		System.out.println(sqrt);
		
		System.out.println(Math.PI);
		
	}
}
