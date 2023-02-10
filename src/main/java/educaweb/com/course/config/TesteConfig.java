package educaweb.com.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import educaweb.com.course.entidade.Categoria;
import educaweb.com.course.entidade.Pedido;
import educaweb.com.course.entidade.Produto;
import educaweb.com.course.entidade.Usuario;
import educaweb.com.course.entidade.enums.PedidoStatus;
import educaweb.com.course.repositores.CategoriaRepositor;
import educaweb.com.course.repositores.PedidoRepositor;
import educaweb.com.course.repositores.ProdutoRepositor;
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
	
	@Autowired 
	private ProdutoRepositor produtoRepositor;
	
	
	
	
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Electronicos"); 
		Categoria cat2 = new Categoria(null, "Livros"); 
		Categoria cat3 = new Categoria(null, "Computadores"); 
		
		Produto p1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Produto p2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Produto p3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Produto p4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Produto p5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		categoriaRepositor.saveAll(Arrays.asList(cat1,cat2,cat3));
		produtoRepositor.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
					
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
	
	
	Pedido o1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.PAGO, u1); 
	Pedido o2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), PedidoStatus.AGURDANDO_PAGAMENTO, u2); 
	Pedido o3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), PedidoStatus.AGURDANDO_PAGAMENTO, u1); 	
	
		
		usuarioRepositor.saveAll(Arrays.asList(u1, u2));
		pedidoRepositor.saveAll(Arrays.asList(o1,o2,o3));
		
		
	}
	
	
}
