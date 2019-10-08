package br.edu.ifba.ads.inf008.model.session;

import br.edu.ifba.ads.inf008.exceptions.PigmentoException;
import br.edu.ifba.ads.inf008.model.entidades.Pigmento;

public interface ServicosPigmentoApp {
	
	public Pigmento localizarPigmento(String corHexa, Double estoque) throws PigmentoException, Exception; //Alterar Exceção
	public boolean finalizarCompra(Pigmento pigmento, Double estoque) throws PigmentoException, Exception; 
	
}
