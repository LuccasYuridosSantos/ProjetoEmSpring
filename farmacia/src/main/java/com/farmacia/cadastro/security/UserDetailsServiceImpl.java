package com.farmacia.cadastro.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.farmacia.cadastro.model.entities.Farmaceutico;
import com.farmacia.cadastro.repository.FarmaceuticoRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private FarmaceuticoRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
		Optional<Farmaceutico> user = userRepository.findByUsuario(userName);
		user.orElseThrow(() -> new  UsernameNotFoundException(userName + "not found."));
		
		return user.map(UserDetailsImpl::new ).get();
	}
}
