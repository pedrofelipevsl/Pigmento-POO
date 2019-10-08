package br.edu.ifba.ads.inf008.exceptions;//novo

public class PigmentoException extends Exception {
	private static final long serialVersionUID = 1L;// necessario porque Exception é serializado

	// contrutor que permite instaciar o tipo de excecao e passar uma mensagem de erro.
	
	public PigmentoException(String mensageDeErro) {
		super(mensageDeErro);
	}

}
