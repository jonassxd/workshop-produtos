package educaweb.com.course.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import educaweb.com.course.entidade.Produto;


public interface ProdutoRepositor extends JpaRepository<Produto, Long> {
		
}
