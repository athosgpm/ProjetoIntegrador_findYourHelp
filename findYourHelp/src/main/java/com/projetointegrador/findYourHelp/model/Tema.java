package com.projetointegrador.findYourHelp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tema")
public class Tema {
	// create table tema
	// criando tabela tema
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTema;

	//criando atributo descriçãoTema
	@NotNull
	@Size(min = 5,max = 255)
	private String descricaoTema;

	//criando atributo categoriaTema
	@NotNull
	@Size(min = 5,max = 50)
	private String categoriaTema;

	//relacionando a tabela tema à postagem (chave estrangeira)
	@OneToMany(mappedBy = "tema", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("tema")
	private List<Postagem> postagem;

	// getters and setters
	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}

	public long getIdTema() {
		return idTema;
	}

	public void setIdTema(long idTema) {
		this.idTema = idTema;
	}

	public String getDescricaoTema() {
		return descricaoTema;
	}

	public void setDescricaoTema(String descricaoTema) {
		this.descricaoTema = descricaoTema;
	}

	public String getCategoriaTema() {
		return categoriaTema;
	}

	public void setCategoriaTema(String categoriaTema) {
		this.categoriaTema = categoriaTema;
	}

	

}
