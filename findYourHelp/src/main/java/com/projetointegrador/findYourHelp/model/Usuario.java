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

// Criação da tabela: Usuario
@Entity
@Table(name = "usuario")
public class Usuario {

// Atributo ID Chave Primaria
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUsuario;

// Atributo nomeUsuario com suas caracteristicas	
	@NotEmpty(message="O nome do usuário é um campo obrigatório.")
	@NotNull(message="O nome do usuário é um campo obrigatório.")
	@Size(min = 2, max = 100, message="O nome do usuário deve possuir entre 2 e 100 caracteres.")
	private String nomeUsuario;

// Atributo emailUsuario com suas caracteristicas
	@NotEmpty(message="O E-mail do usuário é um campo obrigatório.")
	@NotNull(message="O E-mail do usuário é um campo obrigatório.")
	@Email(message="O E-mail do usuário precisa ser válido.")
	@Size(min = 5, max = 100, message="O E-mail do usuário deve possuir entre 5 e 100 caracteres.")
	private String emailUsuario;

// Atributo senhaUsuario com suas caracteristicas
	@NotEmpty(message="A senha do usuário é um campo obrigatório.")
	@NotNull(message="A senha do usuário é um campo obrigatório.")
	@Size(min = 5, max = 100, message="A senha do usuário deve possuir entre 5 e 100 caracteres.")
	private String senhaUsuario;

// Atributo imagemUsuario com suas caracteristicas	
	@URL(message="O campo precisa possuir uma URL.")
	private String imagemUsuario;

// Atributo tipoUsuario com suas caracteristicas
	@NotEmpty(message="O tipo de usuário é um campo obrigatório.")	
	@NotNull(message="O tipo de usuário é um campo obrigatório.")
	private String tipoUsuario;

// Relacionamento entre tabela postagem
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
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

}
