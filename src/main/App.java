package main;

public class App {

	public static void main(String[] args) {
		
		CaixaEletronico caixa = new CaixaEletronico();
		
		Thread cliente1 = new Thread(new TarefaSaque(caixa), "Victoria");
		Thread cliente2 = new Thread(new TarefaTransferencia(caixa), "Carol");
		Thread cliente3 = new Thread(new TarefaSaque(caixa), "Pedro");
		Thread alimentacao = new Thread(new Alimentacao(caixa), "Alimentação do Caixa");
		
		alimentacao.setDaemon(true);
		
		cliente1.start();
		cliente2.start();
		cliente3.start();
		alimentacao.start();

	}

}
