package educaweb.com.course.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import educaweb.com.course.entidade.Pedido;


public interface PedidoRepositor extends JpaRepository<Pedido, Long> {
		
}
