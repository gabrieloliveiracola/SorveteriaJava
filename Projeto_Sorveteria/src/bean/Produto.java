package bean;

public class Produto {
	protected String cod;
	protected String tipo;
	protected double peso;
	protected double preco;
	
	public Produto(String cod, String tipo, double peso, double preco) {
		super();
		this.cod = cod;
		this.tipo = tipo;
		this.peso = peso;
		this.preco = preco;
	}
	

	public Produto() {
		super();
	}


	public String getCod() {
		return cod;
	}

	public void setCod(String item_cod) {
		this.cod = item_cod;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Produto [cod=" + cod + ", tipo=" + tipo + ", peso=" + peso + ", preco=" + preco + "]";
	}
	
}
