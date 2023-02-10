package educaweb.com.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import educaweb.com.course.entidade.Categoria;
import educaweb.com.course.entidade.Pedido;
import educaweb.com.course.entidade.Usuario;
import educaweb.com.course.entidade.enums.PedidoStatus;
import educaweb.com.course.repositores.CategoriaRepositor;
import educaweb.com.course.repositores.PedidoRepositor;
import educaweb.com.course.repositores.UsuarioRepositor;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepositor usuarioRepositor;
	
	@Autowired
	private PedidoRepositor pedidoRepositor;
	
	@Autowired 
	private CategoriaRepositor categoriaRepositor;
	
	
	
	
	
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Electronicos"); 
		Categoria cat2 = new Categoria(null, "Livros"); 
		Categoria cat3 = new Categoria(null, "Computadores"); 
		
		categoriaRepositor.saveAll(Arrays.asList(cat1,cat2,cat3));
					
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
	
	
	Pedido o1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.PAGO, u1); 
	Pedido o2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), PedidoStatus.AGURDANDO_PAGAMENTO, u2); 
	Pedido o3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), PedidoStatus.AGURDANDO_PAGAMENTO, u1); 	
	
		
		usuarioRepositor.saveAll(Arrays.asList(u1, u2));
		pedidoRepositor.saveAll(Arrays.asList(o1,o2,o3));
		
		
	}
	
	
}
