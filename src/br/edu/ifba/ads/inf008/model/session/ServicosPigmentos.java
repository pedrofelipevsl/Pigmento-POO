package br.edu.ifba.ads.inf008.model.session;

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

public class ServicosPigmentos implements ServicosPigmentoApp {

	private PigmentoDAO pigmentoDAO;

	public ServicosPigmentos() {
		this.pigmentoDAO = new PigmentoSQLDAO();
	}

	@Override
	public Pigmento localizarPigmento(String corHexa, Double quantidadeSolicitada) throws Exception {

		Pigmento.validacaoCorHexadecimal(corHexa); // Valida se a cor passada está correta

		List<Pigmento> pigmentos = new ArrayList<>(); // Criado um list para receber os dados que vierem do Banco
		List<PigmentoMensagem> pigmentosEquivalencia = new ArrayList<>();

		try {
			pigmentos = this.pigmentoDAO.buscarTodosPigmentos();

			// preenchendo a lista pigmentosEquivalencia com os itens da lista pigmentos,
			// calculando a equival�ncia relativa e armazena na lista
			for (Pigmento p : pigmentos) { // ((RGB)p).getId()

				PigmentoMensagem pt = new PigmentoMensagem();

				if (p.getTipo() == TipoCor.RGB) { // se o pigmento p for do tipo RGB

					pt.setId(p.getId());
					pt.setNome(p.getNome());
					pt.setEstoque(p.getEstoque());
					pt.setPreco(p.getPreco());
					pt.setTipo(p.getTipo());// <--- Pigmento
					pt.setR(((RGB) p).getR());
					pt.setG(((RGB) p).getG());
					pt.setB(((RGB) p).getB());// <--- RGB
					pt.setEquivalencia(RGB.hexaParaRBG("#" + corHexa));// <--- PigmentoMensagem // calcula e insere a
																		// equivalencia

				} else if (p.getTipo() == TipoCor.CMYK) { // se o pigmento p for do tipo CMYK converte para RGB

					RGB toRGB = ((CMYK) p).converterCMYKparaRGB();

					pt.setId(toRGB.getId());// calcula e insere a equivalencia
					pt.setNome(toRGB.getNome());
					pt.setEstoque(toRGB.getEstoque());
					pt.setPreco(toRGB.getPreco());
					pt.setTipo(toRGB.getTipo());// <--- Pigmento
					pt.setR(toRGB.getR());
					pt.setG(toRGB.getG());
					pt.setB(toRGB.getB());// <--- RGB
					pt.setEquivalencia(RGB.hexaParaRBG("#" + corHexa));// <--- PigmentoMensagem // calcula e insere a
																		// equivalencia
				}

				pigmentosEquivalencia.add(pt);// inserindo os itens na lista PigmentoMensagem
			}

		} catch (PigmentoException e) {
			throw new PigmentoException(e.getMessage());
		}

		return PigmentoMensagem.pigmentoMaisEquivalente(pigmentosEquivalencia, quantidadeSolicitada);
	}

	public String PigmentoToStr() throws Exception {
		String str = "BALANCO\n";
		for (Pigmento p : this.pigmentoDAO.buscarTodosPigmentos())
			str += p + "\n";
		return str;
	}

	@Override
	public boolean finalizarCompra(Pigmento pigmento, Double quantidadeSolicitada) throws Exception {
		
		boolean finalizou;
		
		Double quantidadeAtual;
		
		quantidadeAtual = pigmento.getEstoque() - quantidadeSolicitada;
		
		try {
			finalizou = this.pigmentoDAO.baixaDeEstoqueUpdate(pigmento, quantidadeAtual);
			
		} catch(PigmentoException e) {
			throw new PigmentoException(e.getMessage());
			
		}
		return finalizou;
	}

}
