package dto;

import java.sql.Date;

public class PessoaDTO {
	
	private String nome;
	private int idade;
	private String genero;
	private String telefone;
	private String email;
	
	private int id_pessoa;

	private int numeroDaUnidade;
	private String nomeDaUnidade;
	private String nomeDaUnidade2;
	private String propietario;
	private String condominio;
	private String endereco;
	

	private String descricao;
	private String tipo_despesa;
	private String Status_pagamento;
	private int vencimento_fatura;
	private Double valor;
	private int id_despesas;
	
	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public int getId_despesas() {
		return id_despesas;
	}

	public void setId_despesas(int id_despesas) {
		this.id_despesas = id_despesas;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo_despesa() {
		return tipo_despesa;
	}

	public void setTipo_despesa(String tipo_despesa) {
		this.tipo_despesa = tipo_despesa;
	}

	public String getStatus_pagamento() {
		return Status_pagamento;
	}

	public void setStatus_pagamento(String status_pagamento) {
		Status_pagamento = status_pagamento;
	}

	public int getVencimento_fatura() {
		return vencimento_fatura;
	}

	public void setVencimento_fatura(int vencimento_fatura) {
		this.vencimento_fatura = vencimento_fatura;
	}

	public int getNumeroDaUnidade() {
		return numeroDaUnidade;
	}

	public void setNumeroDaUnidade(int numeroDaUnidade) {
		this.numeroDaUnidade = numeroDaUnidade;
	}

	public String getNomeDaUnidade() {
		return nomeDaUnidade;
	}

	public void setNomeDaUnidade(String nomeDaUnidade) {
		this.nomeDaUnidade = nomeDaUnidade;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public String getCondominio() {
		return condominio;
	}

	public void setCondominio(String condominio) {
		this.condominio = condominio;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getId_pessoa() {
		return id_pessoa;
	}

	public void setId_pessoa(int id_pessoa) {
		this.id_pessoa = id_pessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeDaUnidade2() {
		return nomeDaUnidade2;
	}

	public void setNomeDaUnidade2(String nomeDaUnidade2) {
		this.nomeDaUnidade2 = nomeDaUnidade2;
	}

}
