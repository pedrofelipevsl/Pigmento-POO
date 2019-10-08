package br.edu.ifba.ads.inf008.model.entidades;

import java.awt.Color;

public class RGB extends Pigmento {

	// atributos
	protected Integer R;
	protected Integer G;
	protected Integer B;

	// construtores
	public RGB() {
		super();
	}

	public RGB(Integer r, Integer g, Integer b) {
		super();
		this.setR(r);
		this.setG(g);
		this.setB(b);
	}

	public RGB(String id, String nome, Double estoque, Double preco, TipoCor tipo, Integer r, Integer g, Integer b) {
		super(id, nome, estoque, preco, tipo);
		this.setR(r);
		this.setG(g);
		this.setB(b);
	}

	/*public RGB(String id, String nome, double estoque, double preco, TipoCor tipo, int r, int g, int b) {
		super(id, nome, estoque, preco, tipo);
		this.setR(r);
		this.setG(g);
		this.setB(b);
	}*/
	
	// metodos

	// devolve um RGB baseado em um numero Hexa
	public static RGB hexaParaRBG(String hexa) {

		// cria uma cor e atribue-se os valores do hexa
		Color c = new Color(Integer.valueOf(hexa.substring(1, 3), 16), Integer.valueOf(hexa.substring(3, 5), 16),
				Integer.valueOf(hexa.substring(5, 7), 16));

		// instancia e retorna um RGB baseado na cor montada acima
		return new RGB(c.getRed(), c.getGreen(), c.getBlue());
	}

	// distancia euclidiana
	public Double calculaEquivalenciaEntreCores(RGB rgb) {

		Double soma;
		Double exp = 2.0;

		soma = Math.pow((this.getR() - rgb.getR()), exp);
		soma += Math.pow((this.getG() - rgb.getG()), exp);
		soma += Math.pow((this.getB() - rgb.getB()), exp);

		return Math.sqrt(soma);
	}

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

	// Getters e Setters
	public Integer getR() {
		return R;
	}

	public void setR(Integer r) {
		this.R = r;
	}

	public Integer getG() {
		return G;
	}

	public void setG(Integer g) {
		this.G = g;
	}

	public Integer getB() {
		return B;
	}

	public void setB(Integer b) {
		this.B = b;
	}

	// hashCode -- mesmo da classe mae

	// Equals -- mesmo da classe mae

	// toString
	@Override
	public String toString() { // para imprimir a cor
		return "RGB "+ id +"[R=" + R + ", G=" + G + ", B=" + B + "]";
	}

}
