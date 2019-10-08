package br.edu.ifba.ads.inf008.model.entidades;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.edu.ifba.ads.inf008.exceptions.PigmentoException;

public abstract class Pigmento { // implement Serializable

	// atributos
	protected String id;
	protected String nome;
	protected Double estoque;
	protected Double preco;
	protected TipoCor tipo;

	// construtores
	public Pigmento() {

	}

	public Pigmento(String id, String nome, Double estoque, Double preco, TipoCor tipo) {
		this.id = id;
		this.nome = nome;
		this.estoque = estoque;
		this.preco = preco;
		this.tipo = tipo;
	}

	// metodos
	public static void validacaoCorHexadecimal(String hexa) throws PigmentoException {

		// string maior que 6 caracteres
		if (hexa.length() > 6)
			throw new PigmentoException("Cor Hexadecimal MAIOR que 6 caracteres");

		// string menor que 6 caracteres
		if (hexa.length() < 6)
			throw new PigmentoException("Cor Hexadecimal MENOR que 6 caracteres");

		// string igual a 6 caracteres
		if (hexa.length() == 6) { // verifica se tosdos os seis caracteres estao contidos no conjunto

			// relacao de elementos do conjunto
			Character[] elementos = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

			// preenche a lista com os elementos
			List<Character> listaElementos = Arrays.asList(elementos);

			// coloca elementos no conjunto
			Set<Character> conjNumHexa = new HashSet<>(listaElementos);

			// converte para maiusulo para faze a comparação
			hexa = hexa.toUpperCase();

			// verifica se os caracteres da string passada fazem parte do conjunto dos
			// Hexadecimais
			for (int i = 0; i < hexa.length(); i++) {
				Character l = hexa.charAt(i);
				if (!conjNumHexa.contains(l))
					throw new PigmentoException("Caracter > " + l + " < não é um hexadecimal");
			}

		}

	}
	
	// Getters e Setters
	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public double getEstoque() {
		return estoque;
	}

	public Double getPreco() {
		return preco;
	}	
	
	public TipoCor getTipo() {
		return tipo;
	}

	// hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	// Equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pigmento other = (Pigmento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	// toString
	public abstract String toString();

}
