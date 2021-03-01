package com.projetointegrador.findYourHelp.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "usuario")
public class Usuario {
	// create table postagem
		// criando tabela postagem

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long idUsuario;

		@NotNull
		@Size(min = 8, max = 20)
		private String senhaUsuario;

		@NotNull
		@Email
		@Size(min = 5, max = 100)
		private String emailUsuario;

		
		@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
		@JsonIgnoreProperties("usuario")
		private List<Postagem> postagem;


		public long getIdUsuario() {
			return idUsuario;
		}


		public void setIdUsuario(long idUsuario) {
			this.idUsuario = idUsuario;
		}


		public String getSenhaUsuario() {
			return senhaUsuario;
		}


		public void setSenhaUsuario(String senhaUsuario) {
			this.senhaUsuario = senhaUsuario;
		}


		public String getEmailUsuario() {
			return emailUsuario;
		}


		public void setEmailUsuario(String emailUsuario) {
			this.emailUsuario = emailUsuario;
		}


		public List<Postagem> getPostagem() {
			return postagem;
		}


		public void setPostagem(List<Postagem> postagem) {
			this.postagem = postagem;
		}
		
		


}
