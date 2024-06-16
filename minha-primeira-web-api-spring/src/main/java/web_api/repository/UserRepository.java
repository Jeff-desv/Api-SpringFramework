package web_api.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import web_api.model.Usuario;

@Repository
public class UserRepository {
	
	public void save(Usuario usuario) {
		if(usuario.getId()==null) {
			System.out.println("SAVE - Recebendo o usuário na camada de repositorio");
		} else {
			System.out.println("UPDATE - Recebendo o usuário na camada de repositorio");
		}
		
		System.out.println(usuario);
	}
	
	public void deleteById(Integer id) {
		System.out.println(String.format("DELETE/id - Recebendo o id: %d para excluir um usuário", id));
		System.out.println(id);
	}
	
	public List<Usuario> findAll(){
		System.out.println("LIST - Listando os usuário do Sistema");
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Jeffson", "password"));
		usuarios.add(new Usuario("Auridelha", "masterpass"));
		return usuarios;
	}
	
	public Usuario findById(Integer id) {
		System.out.println(String.format("FIND/id - Recebendo o id: %d para localizar um usuário", id));
		return new Usuario("Jeffson", "password");
	}
	
	public Usuario findByUsername(String username) {
		System.out.println(String.format("FIND/username - Recebendo o username: %s para localizar um usuario", username));
		return new Usuario("Jeffson", "password");
	}

}
