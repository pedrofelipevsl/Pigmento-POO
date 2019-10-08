package br.edu.ifba.ads.inf008.model.entidades;

public class CMYK extends Pigmento {

	// atributos
	private Integer C;
	private Integer M;
	private Integer Y;
	private Integer K;

	// construtores
	public CMYK() {
		super();
	}

	public CMYK(Integer c, Integer m, Integer y, Integer k) {
		super();
		this.setC(c);
		this.setM(m);
		this.setY(y);
		this.setK(k);
	}

	public CMYK(String id, String nome, Double estoque, Double preco, TipoCor tipo, Integer c, Integer m, Integer y, Integer k) {
		super(id, nome, estoque, preco, tipo);
		this.setC(c);
		this.setM(m);
		this.setY(y);
		this.setK(k);
	}

	// metodos

	// devolve um RGB baseado em um CMYK
	public RGB converterCMYKparaRGB() {

		double R = 255.0 * (1.0 - ((double)this.C / 100.0)) * (1.0 - ((double)this.K / 100.0));	
		double G = 255.0 * (1.0 - ((double)this.M / 100.0)) * (1.0 - ((double)this.K / 100.0));	
		double B = 255.0 * (1.0 - ((double)this.Y / 100.0)) * (1.0 - ((double)this.K / 100.0));
		
		return new RGB(getId(), getNome(), getEstoque(), getPreco(), TipoCor.CMYK, (int)Math.round(R), 
				(int)Math.round(G), (int)Math.round(B));

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

	// Getters e Setters
	public Integer getC() {
		return C;
	}

	public void setC(Integer c) {
		this.C = c;
	}

	public Integer getM() {
		return M;
	}

	public void setM(Integer m) {
		this.M = m;
	}

	public Integer getY() {
		return Y;
	}

	public void setY(Integer y) {
		this.Y = y;
	}

	public Integer getK() {
		return K;
	}

	public void setK(Integer k) {
		this.K = k;
	}
	
	public TipoCor getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoCor tipo) {
		this.tipo = tipo;
	}

	// hashCode -- mesmo da classe mae

	// Equals -- mesmo da classe mae

	// toString
	@Override
	public String toString() {
		return "CMYK [C=" + C + ", M=" + M + ", Y=" + Y + ", K=" + K + "]";
	}

	

}
