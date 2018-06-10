package model;

public class Pessoa {
	protected String matricula;
	protected String nome;
	protected Endereco endereco;
	protected Agenda telefone;
	
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Agenda getTelefone() {
		return telefone;
	}
	public void setTelefone(Agenda telefone) {
		this.telefone = telefone;
	}

	
	
}
