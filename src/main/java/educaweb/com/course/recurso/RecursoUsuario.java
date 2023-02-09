package educaweb.com.course.recurso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import educaweb.com.course.service.UsuarioServico;
import educaweb.com.course.usuario.Usuario;

@RestController
@RequestMapping(value = "/usuario")
public class RecursoUsuario {
	
	@Autowired
	private UsuarioServico servico;
	
	
	@GetMapping
	public ResponseEntity<List<Usuario>>findAll(){
		List<Usuario> list = servico.findAll();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{id}")
	
	public ResponseEntity<Usuario> findById(@PathVariable Long id){
		Usuario obj = servico.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
