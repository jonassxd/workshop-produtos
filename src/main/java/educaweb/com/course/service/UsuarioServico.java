package educaweb.com.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import educaweb.com.course.entidade.Usuario;
import educaweb.com.course.repositores.UsuarioRepositor;
import educaweb.com.course.service.exceptions.DataBaseException;
import educaweb.com.course.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioServico {

	@Autowired
	private UsuarioRepositor repositor;

	public List<Usuario> findAll() {

		return repositor.findAll();

	}

	public Usuario findById(Long id) {
		Optional<Usuario> obj = repositor.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));

	}

	public Usuario insert(Usuario obj) {
		return repositor.save(obj);
	}

	public void delete(Long id) {
		try {
			repositor.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}

	public Usuario atualizar(Long id, Usuario obj) {
		try {

			Usuario entidade = repositor.getReferenceById(id);
			atualizarDados(entidade, obj);
			return repositor.save(entidade);
		} catch (EntityNotFoundException e) {
			
		}throw new ResourceNotFoundException(id);

	}

	private void atualizarDados(Usuario entidade, Usuario obj) {
		entidade.setNome(obj.getNome());
		entidade.setEmail(obj.getEmail());
		entidade.setTelefone(obj.getTelefone());
	}
}