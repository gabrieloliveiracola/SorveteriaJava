package bean;

public class Adicional {
	protected int cod_produto;
	protected String adicional;
	public Adicional(int cod_produto, String adicional) {
		super();
		this.cod_produto = cod_produto;
		this.adicional = adicional;
	}
	
	public Adicional() {
		super();
	}

	public int getCod_produto() {
		return cod_produto;
	}
	public void setCod_produto(int cod_produto) {
		this.cod_produto = cod_produto;
	}
	public String getAdicional() {
		return adicional;
	}
	public void setAdicional(String adicional) {
		this.adicional = adicional;
	}
	@Override
	public String toString() {
		return "Adicional [cod_produto=" + cod_produto + ", adicional=" + adicional + "]";
	}
}
