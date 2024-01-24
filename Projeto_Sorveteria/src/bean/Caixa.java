package bean;

public class Caixa {
	protected String cpf;
	protected String nome;
	protected double salario;
	protected String carga_horaria;
	protected String cep;
	protected String cidade;
	protected String rua;
	protected String estado;
	protected int num;
	public Caixa(String cpf, String nome, double salario, String carga_horaria, String cep, String cidade, String rua,
			String estado, int num) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.salario = salario;
		this.carga_horaria = carga_horaria;
		this.cep = cep;
		this.cidade = cidade;
		this.rua = rua;
		this.estado = estado;
		this.num = num;
	}
	
	public Caixa() {
		super();
	}

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getCarga_horaria() {
		return carga_horaria;
	}
	public void setCarga_horaria(String carga_horaria) {
		this.carga_horaria = carga_horaria;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "Caixa [cpf=" + cpf + ", nome=" + nome + ", salario=" + salario + ", carga_horaria=" + carga_horaria
				+ ", cep=" + cep + ", cidade=" + cidade + ", rua=" + rua + ", estado=" + estado + ", num=" + num + "]";
	}
	
	
}
