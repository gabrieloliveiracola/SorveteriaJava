package bean;

public class Compra {
	protected String nota_fiscal;
	protected String cod_produto;
	protected String cpf_caixa;
	protected String data;
	protected String hora;
	protected String nome_cliente;
	public Compra(String nota_fiscal, String cod_produto, String cpf_caixa, String data, String hora,String nome_cliente) {
		super();
		this.nota_fiscal = nota_fiscal;
		this.cod_produto = cod_produto;
		this.cpf_caixa = cpf_caixa;
		this.data = data;
		this.hora = hora;
		this.nome_cliente = nome_cliente;
	}
	
	public Compra() {
		super();
	}

	public String getNota_fiscal() {
		return nota_fiscal;
	}
	public void setNota_fiscal(String nota_fiscal) {
		this.nota_fiscal = nota_fiscal;
	}
	public String getCod_produto() {
		return cod_produto;
	}
	public void setCod_produto(String cod_produto) {
		this.cod_produto = cod_produto;
	}
	public String getCpf_caixa() {
		return cpf_caixa;
	}
	public void setCpf_caixa(String cpf_caixa) {
		this.cpf_caixa = cpf_caixa;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getNome_cliente() {
		return nome_cliente;
	}
	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}
	@Override
	public String toString() {
		return "Compra [nota_fiscal=" + nota_fiscal + ", cod_produto=" + cod_produto + ", cpf_caixa=" + cpf_caixa
				+ ", data=" + data + ", hora=" + hora + ", nome_cliente="
				+ nome_cliente + "]";
	}
	
	
}
