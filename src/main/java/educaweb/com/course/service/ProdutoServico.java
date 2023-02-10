package educaweb.com.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import educaweb.com.course.entidade.Produto;
import educaweb.com.course.repositores.ProdutoRepositor;

@Service
public class ProdutoServico {
	
	@Autowired
	private ProdutoRepositor repositor;
	
	public List<Produto> findAll(){
		
		
		return repositor.findAll();
		
	}
	public Produto findById(Long id) {
	Optional<Produto> obj = repositor.findById(id);
	return obj.get();
	
	}


}
