package educaweb.com.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import educaweb.com.course.entidade.Usuario;
import educaweb.com.course.repositores.UsuarioRepositor;

@Service
public class UsuarioServico {

	@Autowired
	private UsuarioRepositor repositor;

	public List<Usuario> findAll() {

		return repositor.findAll();

	}

	public Usuario findById(Long id) {
		Optional<Usuario> obj = repositor.findById(id);
		return obj.get();

	}

	public Usuario insert(Usuario obj) {
		return repositor.save(obj);
	}

	public void delete(Long id) {
		repositor.deleteById(id);
	}

	public Usuario atualizar(Long id, Usuario obj) {
		Usuario entidade = repositor.getReferenceById(id);
		atualizarDados(entidade, obj);
		return repositor.save(entidade);
	}

	private void atualizarDados(Usuario entidade, Usuario obj) {
		entidade.setNome(obj.getNome());
		entidade.setEmail(obj.getEmail());
		entidade.setTelefone(obj.getTelefone());
	}
}