package web_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import web_api.model.Usuario;
import web_api.repository.UserRepository;

@RestController
public class UsuarioController {

	@Autowired
	private UserRepository repository;
	
	@GetMapping("/users")
	public List<Usuario>getUsers(){
		return repository.findAll();
	}
	@GetMapping("/users/{username}")
	public Usuario getOne(String username) {
		return repository.findByUsername(username);
	}
}
