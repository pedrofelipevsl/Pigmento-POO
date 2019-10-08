package br.edu.ifba.ads.inf008.teste;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifba.ads.inf008.exceptions.PigmentoException;
import br.edu.ifba.ads.inf008.model.entidades.CMYK;
import br.edu.ifba.ads.inf008.model.entidades.Pigmento;
import br.edu.ifba.ads.inf008.model.entidades.PigmentoMensagem;
import br.edu.ifba.ads.inf008.model.entidades.RGB;
import br.edu.ifba.ads.inf008.model.entidades.TipoCor;
import br.edu.ifba.ads.inf008.persistence.PigmentoDAO;
import br.edu.ifba.ads.inf008.persistence.sql.PigmentoSQLDAO;

public class App {
	/*
	 * Para usar em efeito na interface no momento que que for digitada uma cor pelo
	 * usuario ou retornar a mais equivalente Color minhaCor = new Color(217, 228,
	 * 241); getContentPane().setBackground(minhaCor);
	 *
	 */

	private void run() {

		// entradas do usuario----------------
		String cor = "0000FFA";
		Double quantidadeSolicitada = 30.0;
		//------------------------------------
		try {

			// testa se a cor eh valida
			Pigmento.validacaoCorHexadecimal(cor);

			// devolve uma instancia da pigmento RBG preenchido com a cor hexadecimal
			// informada
			RGB rgb = RGB.hexaParaRBG("#" + cor);

			// imprime o pigmeto RBG no console
			System.out.println(rgb);

			// instacia uma cor para comparar com a entrada hexadecimal do usuário
			RGB rgbComp = new RGB(180, 108, 114);

			// compara e imprime a relacao de distancia euclidiana entre as cores
			System.out.printf("\nA distancia entre %s e %s eh de -> %.3f", rgb, rgbComp,
					rgb.calculaEquivalenciaEntreCores(rgbComp));

			// mostra o tipo de cor selecionada do enum TipoCor
			System.out.println("\n\nTipo de cor: " + TipoCor.CMYK.getValor() +"\n");

			/*
			 * Simulacao de acesso a dados e preencimento da lista em mem�ria para teste das
			 * fun��es implementadas em PigmentoMensagem
			 * 
			 */

			// criacao da lista de Pigmentos <- como se fosse de origem de uma Tabela F�sica
			List<Pigmento> pigmentos = new ArrayList<>();

			// inser��o dos pigmentos na "Tabela"
			// DEPOIS
			pigmentos.add(new RGB("Blue0255", "Blue", 11.6, 1.34, TipoCor.RGB, 0, 0, 255));
			pigmentos.add(new CMYK("Oran021", "Orange021", 12.7, 2.35, TipoCor.CMYK, 0, 53, 100, 0));
			pigmentos.add(new RGB("FGree34", "ForestGreen", 7.9, 3.62, TipoCor.RGB, 34, 139, 34));
			pigmentos.add(new RGB("Choc210","Chocolate", 10.30, 4.10, TipoCor.RGB, 210, 105, 30));
			pigmentos.add(new CMYK("WRed75","WarmRed", 7.6, 4.69, TipoCor.CMYK, 0, 75, 90, 0));
			pigmentos.add(new RGB("Gold255","Gold", 12.6, 4.91, TipoCor.RGB, 255, 215, 0));
			pigmentos.add(new RGB("Khaki125","Khaki1", 34.3, 5.28, TipoCor.RGB, 255, 246, 143));
			pigmentos.add(new RGB("Thistle21","Thistle", 24.3, 5.46, TipoCor.RGB, 216, 191, 216));
			pigmentos.add(new CMYK("Yellow30","Yellow", 11.3, 6.91, TipoCor.CMYK, 0, 3, 100, 0));
			pigmentos.add(new RGB("Alfa42B","Especiaria Antiga", 32.5, 7.5, TipoCor.RGB, 180, 108, 114));
			pigmentos.add(new CMYK("Violet100","Violet", 12.3, 7.55, TipoCor.CMYK, 98, 100, 0, 0));
			pigmentos.add(new RGB("Brown16","Brown", 22.9, 7.94, TipoCor.RGB, 165, 42, 42));
			pigmentos.add(new CMYK("Beta46c","Vermelho Desbotado", 32.5, 8.35, TipoCor.CMYK, 0, 40, 37, 29));
			pigmentos.add(new CMYK("Green05","Green", 10.7, 9.25, TipoCor.CMYK, 100, 0, 59, 0));
			pigmentos.add(new RGB("DRed139","DarkRed", 22.3, 13.75, TipoCor.RGB, 139, 0, 0));
			pigmentos.add(new CMYK("Red3290","Red032", 22.6, 13.97, TipoCor.CMYK, 0, 90, 86, 0));
			pigmentos.add(new RGB("Tomat41","Tomato4", 16.9, 15.0, TipoCor.RGB, 139, 54, 38));
			pigmentos.add(new RGB("Mage255","Magenta", 19.3, 15.45, TipoCor.RGB, 255, 0, 255));
			pigmentos.add(new CMYK("Purple88","Purple", 32.3, 24.76, TipoCor.CMYK, 38, 88, 0, 0));
			pigmentos.add(new CMYK("Black131","Black", 35.9, 33.2, TipoCor.CMYK, 0, 13, 49, 98));
			// pigmentos.add(new RGB("","", 0.0, 0.0, TipoCor.RGB, 0, 0, 0));
			// pigmentos.add(new CMYK("","", 0.0, 0.0, TipoCor.CMYK, 0, 0, 0, 0));

			// cria��o da lista produtoTotal do tipo produtoMensagem
			List<PigmentoMensagem> pigmentosEquivalencia = new ArrayList<>();

			// preenchendo a lista pigmentosEquivalencia com os itens da lista pigmentos,
			// calculando a equival�ncia relativa e armazena na lista
			for (Pigmento p : pigmentos) { // ((RGB)p).getId()

				PigmentoMensagem pt = new PigmentoMensagem();
				
				if (p.getTipo() == TipoCor.RGB) { //se o pigmento p for do tipo RGB 
					
					pt.setId(p.getId());
					pt.setNome(p.getNome());
					pt.setEstoque(p.getEstoque());
					pt.setPreco(p.getPreco());
					pt.setTipo(p.getTipo());//<--- Pigmento
					pt.setR(((RGB)p).getR());
					pt.setG(((RGB)p).getG());
					pt.setB(((RGB)p).getB());//<--- RGB
					pt.setEquivalencia(RGB.hexaParaRBG("#" + cor));//<--- PigmentoMensagem // calcula e insere a equivalencia
					
				} else if (p.getTipo() == TipoCor.CMYK) { //se o pigmento p for do tipo CMYK converte para RGB
					
					RGB toRGB = ((CMYK)p).converterCMYKparaRGB(); 
					
					pt.setId(toRGB.getId());// calcula e insere a equivalencia
					pt.setNome(toRGB.getNome());
					pt.setEstoque(toRGB.getEstoque());
					pt.setPreco(toRGB.getPreco());
					pt.setTipo(toRGB.getTipo());//<--- Pigmento
					pt.setR(toRGB.getR());
					pt.setG(toRGB.getG());
					pt.setB(toRGB.getB());//<--- RGB
					pt.setEquivalencia(RGB.hexaParaRBG("#" + cor));//<--- PigmentoMensagem // calcula e insere a equivalencia
				}
				
				pigmentosEquivalencia.add(pt);// inserindo os itens na lista PigmentoMensagem
			}
			
			System.out.println(PigmentoMensagem.exibirLista(pigmentosEquivalencia)); //exibe os pigmentos da lista em rgb
			
			System.out.printf("----> Cor solicitada: %s --> Na quantidade: %.2f -----------\n", rgb, quantidadeSolicitada);
			System.out.println("O mais proximo e disponivel na qtd solicitada eh:\n");
						
			System.out.println(PigmentoMensagem.pigmentoMaisEquivalente(pigmentosEquivalencia, quantidadeSolicitada));
			
			System.out.println("\n\n:: Lista de todos os pigmentos do estoque por ordem de equivalencia ::\n");
			
			pigmentosEquivalencia.sort((p1, p2) -> p1.getEquivalencia().compareTo(p2.getEquivalencia())); //ordena a lista por equivalencia
			
			System.out.println(PigmentoMensagem.exibirLista(pigmentosEquivalencia));
			
		} catch (PigmentoException e) {
			// se der erro informa, informa
			System.out.println(e.getMessage());

		}

	}

	public static void main(String[] args) {
		(new App()).run();
	}
}
