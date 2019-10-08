package br.edu.ifba.ads.inf008.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import br.edu.ifba.ads.inf008.exceptions.PigmentoException;
import br.edu.ifba.ads.inf008.model.entidades.PigmentoMensagem;
import br.edu.ifba.ads.inf008.model.session.ServicosPigmentoApp;
import br.edu.ifba.ads.inf008.model.session.ServicosPigmentos;

public class ConsoleView {
	private ServicosPigmentoApp app;
	
	private BufferedReader br;

	public ConsoleView() {
		this.app = new ServicosPigmentos();
		this.br = new BufferedReader(
	 			new InputStreamReader(System.in));
	}
	
	
	private void buscarPigmento() throws Exception { // alterar Exception
		String corHexa;
		Double quantidadeEscolhida;
		PigmentoMensagem pm;
		
		System.out.println("BUSCAR PIGMENTO");
		
		System.out.println("1. Informe o nome da Cor em Hexadecimal -> 00AAFF : ");
		corHexa = this.br.readLine();
		
		System.out.println("2. Informe a quantidade de Litros:");
		quantidadeEscolhida = Double.parseDouble(this.br.readLine());
		
		try {

			pm = (PigmentoMensagem) this.app.localizarPigmento(corHexa, quantidadeEscolhida);
			
			pm.setTotalQueVaiPagar(quantidadeEscolhida);
			
			System.out.printf(" -> Nome da Cor: %s \n" + 
					  " -> Estoque Disponivel: %.2f litro(s)\n"+
					  " -> Preco Produto: R$ %.2f \n"+
					  " -> Quantidade Solicitada: %.2f litro(s)\n"+
			          " -> Total a Pagar: R$ %.2f\n", 
			          pm.getNome(), pm.getEstoque(), pm.getPreco(), quantidadeEscolhida ,pm.getTotalAPagar());
			
			
			Integer confirma = 0;
			
			System.out.println("3. Deseja Finalizar a Compra da Cor?");
			System.out.println("1 - SIM");
			System.out.println("2 - NÃO");
			
			confirma = Integer.parseInt(this.br.readLine());
			
			if(confirma == 1) {
				
				boolean finalizou = this.app.finalizarCompra(pm, quantidadeEscolhida);
				
				if(finalizou) {
					
					pm.setBaixaNoEstoque(quantidadeEscolhida);					
					System.out.printf(" -> Compra da cor > %s < realizada com sucesso!\n" + 
							  		  " -> Estoque atual: %.2f litro(s)\n", 
							  		  pm.getNome(), pm.getEstoque());
				}		

			} else {
				System.out.println("Obrigado por consultar um Pigmento!");
			}
			
			
		} catch(PigmentoException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	public void run() throws Exception {
		
		char option = '0';
		
		do {
			System.out.println("MENU");
			System.out.println("[1] - BUSCAR TINTA");
			System.out.println("[0] - SAIR");
			try {
				option = br.readLine().charAt(0);
			} catch (IOException e1) {
				System.out.println("ERRO LENDO OPCAO");
			}
			switch(option) {
				case '1' : try {
					this.buscarPigmento();
				} catch (NumberFormatException ex) {
					System.err.println("O valor precisa ser um double");
				}catch(IOException | PigmentoException e) {
					System.err.println("Pigmento não comprado por " + e);
				}
		        break;
			}
		}while(option != '0');
	}
	
	public static void main(String[] args) throws Exception {
		(new ConsoleView()).run();
	}
}
