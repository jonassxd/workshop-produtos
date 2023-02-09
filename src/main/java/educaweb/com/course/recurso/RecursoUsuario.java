package educaweb.com.course.recurso;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import educaweb.com.course.usuario.Usuario;

@RestController
@RequestMapping(value = "/usuario")
public class RecursoUsuario {
	
	@GetMapping
	public ResponseEntity<Usuario>findAll(){
		Usuario u = new Usuario(1L, "Eduardo", "eduardo@gmail.com", "9993929", "123145");
		return ResponseEntity.ok().body(u);
	}
}
