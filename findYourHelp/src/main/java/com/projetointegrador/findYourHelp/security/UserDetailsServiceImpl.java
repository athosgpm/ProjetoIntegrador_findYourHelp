package com.projetointegrador.findYourHelp.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projetointegrador.findYourHelp.model.Usuario;
import com.projetointegrador.findYourHelp.repository.UsuarioRepository;

//recebe os usuarios e converte para user details
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	//injeta o repositório para localiza-lo no banco de dados e converte-lo em user details
	@Autowired
	private UsuarioRepository userRepository;

	//obrigatório pelo implements
	//pesquisa um usuario retornando ele no user details
	@Override
	public UserDetails loadUserByUsername(String userName) {// throws UsernameNotFoundException {
		Optional<Usuario> user = userRepository.findByEmailUsuario(userName);
		user.orElseThrow(() -> new UsernameNotFoundException(userName + " not found."));

		return user.map(UserDetailsImpl::new).get();
	}

}
