package br.edu.ifba.ads.inf008.model.entidades;

import java.util.List;

import br.edu.ifba.ads.inf008.exceptions.PigmentoException;

public class PigmentoMensagem extends RGB {

	// atributos
	private Double equivalencia;
	private Double totalAPagar;

	// construtores
	public PigmentoMensagem() {
		super();
	}

	public PigmentoMensagem(String id, String nome, Double estoque, Double preco, TipoCor tipo, Integer r, Integer g,
			Integer b) {
		super(id, nome, estoque, preco, tipo, r, g, b);
	}

	// metodos

	// armazena no objeto intanciado a equivalencia ente ele e a cor passada
	public void setEquivalencia(RGB rgb) {

		setEquivalencia(this.calculaEquivalenciaEntreCores(rgb));
	}

	// campo calculavel automaticamente a partir de um valor passado pelo usuário
	public void setTotalQueVaiPagar(Double qtdLitros) {
		setTotalAPagar(qtdLitros * this.getPreco());
	}
	
	// da baixa no estoque da variavel pigmento mensagem
	public void setBaixaNoEstoque(Double qtdLitros) {
		setEstoque(this.getEstoque() - qtdLitros);
	}

	// ---------------------------- metodos para serem realocados de acordo com a
	// necessidade

	// metodo que exibe uma lista do tipo Pigmento e de qualquer classe filha desta
	public static String exibirLista(List<? extends Pigmento> lista) {

		String texto = "";

		for (Pigmento p : lista)
			texto += p.toString() + "\n";

		return texto;
	}

	// metodo de busca de pigmento mais equivalente e que possua estoque maior ou
	// igual ao valor informado
	// pelo usuario.
	public static Pigmento pigmentoMaisEquivalente(List<PigmentoMensagem> lista, Double quantidadeSolicitada)
			throws PigmentoException {
		Pigmento pp = null;

		// ordena de forma crescente de equivalencia a lista de pigmentos - expressao
		// lambida
		lista.sort((p1, p2) -> p1.getEquivalencia().compareTo(p2.getEquivalencia()));

		// retorna o pigmento mais equivalente e que tenha a qtd de litros maior ou
		// igual ao solicitado
		for (PigmentoMensagem p : lista)
			if (p.getEstoque() >= quantidadeSolicitada) {
				pp = p;
				break;
			}
				
		if (pp == null)
			throw new PigmentoException("O pigmento informado na quantidade solicitada nao possui nenhum equivalente\n"
					+ "disponivel em estoque para a quantidade informada.\n"
					+ "Refaca o pedido com um valor menor de litros!");
		return pp;
	}

	// --------------------------------------------------------------------------------------

	// Getters e Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getEstoque() {
		return estoque;
	}

	public void setEstoque(Double estoque) {
		this.estoque = estoque;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public TipoCor getTipo() {
		return tipo;
	}

	public void setTipo(TipoCor tipo) {
		this.tipo = tipo;
	}

	// get e set
	public Double getEquivalencia() {
		return equivalencia;
	}

	private void setEquivalencia(Double equivalencia) {
		this.equivalencia = equivalencia;
	}

	public Double getTotalAPagar() {
		return totalAPagar;
	}

	private void setTotalAPagar(Double totalAPagar) {
		this.totalAPagar = totalAPagar;
	}

	@Override
	public String toString() {
		return "PigmentoMensagem [R=" + R + ", G=" + G + ", B=" + B + ", id=" + id + ", nome=" + nome + ", estoque="
				+ estoque + ", preco=" + preco + ", tipo=" + tipo + ", eqv=" + equivalencia + "]";
	}

}