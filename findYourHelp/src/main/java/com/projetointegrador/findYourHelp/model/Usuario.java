/* Projeto Integrador Find Your Help
 Comentários criados por: Gustavo de Souza Guilhen e Tatiane Tissoni Antunes. 
 */

package com.projetointegrador.findYourHelp.model;

// Import de Bibliotecas.
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

// Criação da tabela: Usuario
@Entity
@Table(name = "usuario")
public class Usuario {

// Atributo ID Chave Primaria
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUsuario;

// Atributo nomeUsuario com suas caracteristicas	
	@NotEmpty
	@NotNull
	@Size(min = 2, max = 100)
	private String nomeUsuario;

// Atributo emailUsuario com suas caracteristicas
	@NotEmpty
	@NotNull
	@Email
	@Size(min = 5, max = 100)
	private String emailUsuario;

// Atributo senhaUsuario com suas caracteristicas
	@NotEmpty
	@NotNull
	@Size(min = 5, max = 100)
	private String senhaUsuario;

// Atributo imagemUsuario com suas caracteristicas	
	@URL
	private String imagemUsuario;

// Atributo tipoUsuario com suas caracteristicas
	@NotEmpty	
	@NotNull
	private String tipoUsuario;
	
// Atributo telefoneUsuario com suas caracteristicas
	@NotEmpty
	@NotNull
	@Pattern(regexp="((?\\d{2})?\\s)?(\\d{4,5}-\\d{4})")
	private String telefoneUsuario;

// Relacionamento entre tabela postagem
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Postagem> postagem;

//Getters e Setters
	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public String getImagemUsuario() {
		return imagemUsuario;
	}

	public void setImagemUsuario(String imagemUsuario) {
		this.imagemUsuario = imagemUsuario;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}

	public String getTelefoneUsuario() {
		return telefoneUsuario;
	}

	public void setTelefoneUsuario(String telefoneUsuario) {
		this.telefoneUsuario = telefoneUsuario;
	}

	
}
