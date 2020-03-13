package main;

public class CaixaEletronico {
	
	private boolean estaVazio = true;

	public void saque() {
		
		String nome = Thread.currentThread().getName();
		
		System.out.println(nome + " chegou no banco para saque");
		
		synchronized(this) {
			
			System.out.println(nome + " chegou ao caixa eletr�nico para saque");
			
			while(this.estaVazio) {
				System.out.println(nome + " reclama. Sem c�dulas para saque!");
				espera();
			}
			
			System.out.println(nome + " realizando saque...");
			
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			this.estaVazio = true;
			
			System.out.println(nome + " saindo do caixa eletr�nico");
			
		}
		
	}
	
	public void transferencia() {
		
		String nome = Thread.currentThread().getName();
		
		System.out.println(nome + " chegou no banco para realizar transfer�ncia");
		
		synchronized(this) {
			
			System.out.println(nome + " chegou ao caixa eletr�nico para transfer�ncia");
			
			System.out.println(nome + " realizando transfer�ncia...");
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(nome + " saindo do caixa eletr�nico");
			
		}
		
	}
	
	public void alimentacaoCaixa() {
		System.out.println("Verificando o caixa eletr�nico...");
		
		synchronized (this) {
			
			if(!estaVazio) {
				System.out.println("Caixa eletr�nico cont�m c�dulas para saque");
				return;
			}
			System.out.println("Alimentando caixa...");
			this.estaVazio = false;
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("Caixa alimentado. C�dulas no caixa");
			this.notifyAll();
			
		}
	}
	
	public void espera() {
		System.out.println("Caixa sem Dinheiro");
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
