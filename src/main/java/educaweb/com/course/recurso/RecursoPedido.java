package educaweb.com.course.recurso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import educaweb.com.course.entidade.Pedido;
import educaweb.com.course.service.PedidoServico;

@RestController
@RequestMapping(value = "/pedido")
public class RecursoPedido {
	
	@Autowired
	private PedidoServico servico;
	
	
	@GetMapping
	public ResponseEntity<List<Pedido>>findAll(){
		List<Pedido> list = servico.findAll();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{id}")
	
	public ResponseEntity<Pedido> findById(@PathVariable Long id){
		Pedido obj = servico.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
