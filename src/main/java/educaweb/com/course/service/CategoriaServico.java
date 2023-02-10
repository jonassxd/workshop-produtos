package educaweb.com.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import educaweb.com.course.entidade.Categoria;
import educaweb.com.course.repositores.CategoriaRepositor;

@Service
public class CategoriaServico {
	
	@Autowired
	private CategoriaRepositor repositor;
	
	public List<Categoria> findAll(){
		
		
		return repositor.findAll();
		
	}
	public Categoria findById(Long id) {
	Optional<Categoria> obj = repositor.findById(id);
	return obj.get();
	
	}


}
