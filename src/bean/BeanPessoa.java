package bean;

import java.io.Serializable;

public class BeanPessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String nome;
	private String pai;
	private String mae;
	private String nascimentto;
	private String cpf;
	private String rg;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPai() {
		return pai;
	}

	public void setPai(String pai) {
		this.pai = pai;
	}

	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}

	public String getNascimentto() {
		return nascimentto;
	}

	public void setNascimentto(String nascimentto) {
		this.nascimentto = nascimentto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	@Override
	public String toString() {
		return "BeanPessoa [id=" + id + ", nome=" + nome + ", pai=" + pai + ", mae=" + mae + ", nascimentto="
				+ nascimentto + ", cpf=" + cpf + ", rg=" + rg + "]";
	}

}
