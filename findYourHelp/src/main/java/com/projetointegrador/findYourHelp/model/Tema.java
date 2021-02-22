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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_tema")
public class Tema {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_Tema;
	
	@NotNull
	private String descricao_Tema;
	
	@NotNull
	private String categoria_Tema;
	
	@NotNull
	private String tipoAjuda_Tema;
	
	@OneToMany(mappedBy = "tema", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("tema")
	private List<Postagem> postagem;

	
	public long getId_Tema() {
		return id_Tema;
	}

	public void setId_Tema(long id_Tema) {
		this.id_Tema = id_Tema;
	}

	public String getDescricao_Tema() {
		return descricao_Tema;
	}

	public void setDescricao_Tema(String descricao_Tema) {
		this.descricao_Tema = descricao_Tema;
	}

	public String getCategoria_Tema() {
		return categoria_Tema;
	}

	public void setCategoria_Tema(String categoria_Tema) {
		this.categoria_Tema = categoria_Tema;
	}

	public String getTipoAjuda_Tema() {
		return tipoAjuda_Tema;
	}

	public void setTipoAjuda_Tema(String tipoAjuda_Tema) {
		this.tipoAjuda_Tema = tipoAjuda_Tema;
	}

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}
	
}
