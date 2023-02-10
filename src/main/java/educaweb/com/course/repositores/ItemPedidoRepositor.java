package educaweb.com.course.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import educaweb.com.course.entidade.ItemPedido;


public interface ItemPedidoRepositor extends JpaRepository<ItemPedido, Long> {
		
}
