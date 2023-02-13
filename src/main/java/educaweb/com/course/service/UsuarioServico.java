package educaweb.com.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import educaweb.com.course.entidade.Usuario;
import educaweb.com.course.repositores.UsuarioRepositor;

@Service
public class UsuarioServico {
	
	@Autowired
	private UsuarioRepositor repositor;
	
	public List<Usuario> findAll(){
		
		
		return repositor.findAll();
		
	}
	public Usuario findById(Long id) {
	Optional<Usuario> obj = repositor.findById(id);
	return obj.get();
	
	}
	public Usuario insert(Usuario obj) {
		return repositor.save(obj);
	}

}
