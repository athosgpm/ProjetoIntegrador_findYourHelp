package com.projetointegrador.findYourHelp.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "postagem")
public class Postagem {
	// create table postagem
	// criando tabela postagem

	//criando atributo IdPostagem
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPostagem;

	//criando atributo TituloPostagem
	@NotNull (message = "O titulo da postagem é um campo obrigatório")
	@Size(min = 5, max = 50, message = "O titulo da postagem deve possuir de 5 a 50 caracteres")
	private String tituloPostagem;
	
	//criando atributo TipoAjudaPostagem
	@NotNull (message = "O tipo de ajuda é um campo obrigatório")
	@Size(min = 1, max = 50, message = "O campo do tipo de ajuda deve possuir de 5 a 50 caracteres")
	private String tipoAjudaPostagem;
	
	//criando atributo UrlImagemPostagem
	@NotNull (message = "O campo link da imagem é um campo obrigatório")
	@Size(min = 5, max = 255, message = "O campo link da imagem deve possuir de 5 a 255 caracteres")
	@URL(message = "URL é inválida")
	private String urlImagemPostagem;

	//criando atributo descriçãoPostagem
	@NotNull (message = "A descrição da postagem é um campo obrigatório")
	@Size(min = 5, max = 255, message = "O campo link da imagem deve possuir de 5 a 255 caracteres")
	private String descricaoPostagem;

	//criando atributo DataPostagem
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPostagem = new java.sql.Date(System.currentTimeMillis());

	//relacionando a tabela tema à postagem (chave estrangeira)
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	//relacionando a tabela usuario à postagem (chave estrangeira)
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;
	
	//relacionando a tabela comentario à postagem (chave estrangeira)
	@OneToMany(mappedBy = "postagem", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("postagem")
	private List<ComentarioPostagem> comentario;

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

	public List<ComentarioPostagem> getComentario() {
		return comentario;
	}

	public void setComentario(List<ComentarioPostagem> comentario) {
		this.comentario = comentario;
	}
	

}
