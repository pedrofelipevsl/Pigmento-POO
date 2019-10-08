package br.edu.ifba.ads.inf008.model.entidades;

public enum TipoCor {
	RGB(1), CMYK(2);

	private final Integer valor;

	TipoCor(Integer valorCor) {
		valor = valorCor;
	}
	
	public Integer getValor() {
		return valor;
	}

}
