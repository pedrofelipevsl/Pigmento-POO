package br.edu.ifba.ads.inf008.persistence;

import java.util.List;

import br.edu.ifba.ads.inf008.model.entidades.Pigmento;

public interface PigmentoDAO {
	
	public boolean baixaDeEstoqueUpdate(Pigmento pigmento, Double quantidadeAtual) throws Exception; //Alterar Exceção
	public List<Pigmento> buscarTodosPigmentos() throws Exception; //Alterar Exceção e ver a possível necessidade de implementar ele
	
}
