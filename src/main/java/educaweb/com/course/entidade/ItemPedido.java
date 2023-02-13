package educaweb.com.course.entidade;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import educaweb.com.course.entidade.pk.ItemPedidoPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pedido_item")
public class ItemPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ItemPedidoPK id = new ItemPedidoPK();

	private Integer quantidade;
	private Double preco;

	public ItemPedido() {

	}

	public ItemPedido(Pedido pedido, Produto prroduto, Integer quantidade, Double price) {
		super();

		id.setPedido(pedido);
		id.setProduto(prroduto);
		this.quantidade = quantidade;
		this.preco = price;

	}

	@JsonIgnore
	public Pedido getPedido() {
		return id.getPedido();
	}

	public void SetPedido(Pedido pedido) {
		id.setPedido(pedido);
	}

	public Produto getProduto() {
		return id.getProduto();
	}

	public void setProduto(Produto produto) {
		id.setProduto(produto);

	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrice() {
		return preco;
	}

	public void setPrice(Double price) {
		this.preco = price;
	}
	
	public Double getSubTotal() {
		return preco*quantidade;
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		return Objects.equals(id, other.id);
	}

}
