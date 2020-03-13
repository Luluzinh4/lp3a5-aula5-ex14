package main;

public class Alimentacao implements Runnable {
	
	private CaixaEletronico caixa;

	public Alimentacao(CaixaEletronico caixa) {
		this.caixa = caixa;
	}

	@Override
	public void run() {
		while(true) {
			this.caixa.alimentacaoCaixa();
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
