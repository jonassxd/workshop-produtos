package educaweb.com.course.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import educaweb.com.course.entidade.Categoria;


public interface CategoriaRepositor extends JpaRepository<Categoria, Long> {
		
}
