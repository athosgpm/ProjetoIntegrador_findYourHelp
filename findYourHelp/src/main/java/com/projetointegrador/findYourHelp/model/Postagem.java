package com.projetointegrador.findYourHelp.model;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "postagem")
public class Postagem {
	// create table postagem
	// criando tabela postagem

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPostagem;

	@NotNull
	@Size(min = 5, max = 500)
	private String descricaoPostagem;

	@NotNull
	@Size(min = 5, max = 255)
	private String urlImagemPostagem;

	@NotNull
	@Size(min = 5, max = 100)
	private String tituloPostagem;
	
	@NotNull
	@Size(min = 5, max = 50)
	private String tipoAjudaPostagem;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPostagem = new java.sql.Date(System.currentTimeMillis());

	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;

	// getters and setters
	public long getIdPostagem() {
		return idPostagem;
	}

	public void setIdPostagem(long idPostagem) {
		this.idPostagem = idPostagem;
	}

	public String getDescricaoPostagem() {
		return descricaoPostagem;
	}

	public void setDescricaoPostagem(String descricaoPostagem) {
		this.descricaoPostagem = descricaoPostagem;
	}

	public String getUrlImagemPostagem() {
		return urlImagemPostagem;
	}

	public void setUrlImagemPostagem(String urlImagemPostagem) {
		this.urlImagemPostagem = urlImagemPostagem;
	}

	public String getTituloPostagem() {
		return tituloPostagem;
	}

	public void setTituloPostagem(String tituloPostagem) {
		this.tituloPostagem = tituloPostagem;
	}

	public Date getDataPostagem() {
		return dataPostagem;
	}

	public void setDataPostagem(Date dataPostagem) {
		this.dataPostagem = dataPostagem;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public String getTipoAjudaPostagem() {
		return tipoAjudaPostagem;
	}

	public void setTipoAjudaPostagem(String tipoAjudaPostagem) {
		this.tipoAjudaPostagem = tipoAjudaPostagem;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



}
