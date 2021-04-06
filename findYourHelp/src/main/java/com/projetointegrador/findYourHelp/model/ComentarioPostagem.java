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
@Table(name = "tb_comentario_postagem")
public class ComentarioPostagem {
	
	//criando atributo IdComentario
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idComentario;
	
	

	//criando atributo comentario
	@NotNull
	@Size(max = 9999)
	private String comentario;
	
	//criando atributo comentario
	@Temporal(TemporalType.TIMESTAMP)
    private Date dataComentario = new Date(System.currentTimeMillis());
	
	//relacionando a tabela usuario à comentario (chave estrangeira)
	@ManyToOne
	@JsonIgnoreProperties(value = {"postagem","comentario"})
	private Usuario usuario;
		
	//relacionando a tabela postagem à comentario (chave estrangeira)
	@ManyToOne
	@JsonIgnoreProperties(value = {"usuario","comentario"})
	private Postagem postagem;

	//getters and setters
	public long getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(long idComentario) {
		this.idComentario = idComentario;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getDataComentario() {
		return dataComentario;
	}

	public void setDataComentario(Date dataComentario) {
		this.dataComentario = dataComentario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Postagem getPostagem() {
		return postagem;
	}

	public void setPostagem(Postagem postagem) {
		this.postagem = postagem;
	}
	
	


	

}