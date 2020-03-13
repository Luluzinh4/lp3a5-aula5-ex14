package main;

public class TarefaTransferencia implements Runnable {

	private CaixaEletronico caixa;

	public TarefaTransferencia(CaixaEletronico caixa) {
		this.caixa = caixa;
	}

	@Override
	public void run() {
		this.caixa.transferencia();
	}
	
}
