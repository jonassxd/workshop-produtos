package educaweb.com.course.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import educaweb.com.course.entidade.Usuario;


public interface UsuarioRepositor extends JpaRepository<Usuario, Long> {
		
}
