package com.projetointegrador.findYourHelp.service;

import java.nio.charset.Charset;
import java.util.Optional;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.projetointegrador.findYourHelp.model.UserLogin;
import com.projetointegrador.findYourHelp.model.Usuario;
import com.projetointegrador.findYourHelp.repository.UsuarioRepository;

@Service	//classe de serviço
public class UsuarioService {

	//cadastra nossos usuarios, localiza eles no banco de dados e gera o token
	@Autowired
	private UsuarioRepository repository;

	//metodo para cadastrar usuario
	public Optional<Usuario> CadastrarUsuario(Usuario usuario) {

		//não permite o cadastro de usuarios iguais
		if (repository.findByEmailUsuario(usuario.getEmailUsuario()).isPresent()) {
			return null;
		}

		//instanciando um novo objeto chamado encoder
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		//encriptografa a senha em variavel spring chamada senhaEncoder
		String senhaEncoder = encoder.encode(usuario.getSenhaUsuario());
		
		//substitui a senha do objeto pela senha encriptografada
		usuario.setSenhaUsuario(senhaEncoder);

		//salva a senha encriptografada no banco de dados através do repository
		return Optional.of(repository.save(usuario));
	}

	//metodo logar
	public Optional<UserLogin> Logar(Optional<UserLogin> user) {

		//intaciando um novo objeto
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = repository.findByEmailUsuario(user.get().getEmailUsuario());

		if (usuario.isPresent()) {
			
			//compara a senha digitada pelo usuario com a senha encriptografada
			if (encoder.matches(user.get().getSenhaUsuario(), usuario.get().getSenhaUsuario())) {

				//concatena o usuario e senha para gerar um token "encodado"
				String auth = user.get().getEmailUsuario() + ":" + user.get().getSenhaUsuario();
				
				//"encoda" usuario e senha no padrão US-ASCII e coloca em uma array de bytes
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				
				//Coloca tudo em uma spring com prefixo "Basic"
				String authHeader = "Basic " + new String(encodedAuth);

				user.get().setToken(authHeader);
				user.get().setNomeUsuario(usuario.get().getNomeUsuario());
				user.get().setEmailUsuario(usuario.get().getEmailUsuario());
				
//### 			//TipoAdmin
//###			//user.get().setTipoAdmin(usuario.get().isTipoAdmin());
				
				user.get().setIdUsuario(usuario.get().getIdUsuario());
				user.get().setImagemUsuario(usuario.get().getImagemUsuario());
				user.get().setTipoUsuario(usuario.get().getTipoUsuario());
				user.get().setTelefoneUsuario(usuario.get().getTelefoneUsuario());
				
				user.get().setSenhaUsuario(usuario.get().getSenhaUsuario());

				return user;

			}
		}
		return null;
	}

	public Optional<Usuario> atualizaUsuario(Usuario usuario)
    {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String senhaEncoder = encoder.encode(usuario.getSenhaUsuario());
        usuario.setSenhaUsuario(senhaEncoder);

        return Optional.of(repository.save(usuario));
    }
	
}
