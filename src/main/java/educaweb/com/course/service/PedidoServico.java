package educaweb.com.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import educaweb.com.course.entidade.Pedido;
import educaweb.com.course.repositores.PedidoRepositor;

@Service
public class PedidoServico {
	
	@Autowired
	private PedidoRepositor repositor;
	
	public List<Pedido> findAll(){
		
		
		return repositor.findAll();	
		
	}
	public Pedido findById(Long id) {
	Optional<Pedido> obj = repositor.findById(id);
	return obj.get();
	
	}


}
