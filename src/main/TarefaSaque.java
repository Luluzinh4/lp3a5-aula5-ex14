package main;

public class TarefaSaque implements Runnable {
	
	private CaixaEletronico caixa;

	public TarefaSaque(CaixaEletronico caixa) {
		this.caixa = caixa;
	}

	@Override
	public void run() {
		this.caixa.saque();
	}

}
