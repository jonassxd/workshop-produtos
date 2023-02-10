package educaweb.com.course.recurso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import educaweb.com.course.entidade.Produto;
import educaweb.com.course.service.ProdutoServico;

@RestController
@RequestMapping(value = "/produtos")
public class RecursoProduto {
	
	@Autowired
	private ProdutoServico servico;
	
	
	@GetMapping
	public ResponseEntity<List<Produto>>findAll(){
		List<Produto> list = servico.findAll();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{id}")
	
	public ResponseEntity<Produto> findById(@PathVariable Long id){
		Produto obj = servico.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
