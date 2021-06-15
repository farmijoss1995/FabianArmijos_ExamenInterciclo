package ec.edu.ups.Examen.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import ec.edu.ups.Examen.bussiness.PedidoOn;
import ec.edu.ups.Examen.entity.Comida;
import ec.edu.ups.Examen.entity.Pedido;

@ManagedBean
@SessionScoped
public class PedidoMb {

	@Inject
	private PedidoOn pedidoOn;
	
	
	private Pedido pedido;
	
	private Comida comida;
	
	
	private double subtotal;
	private double iva;
	private double total;
	
	private List<Comida> comidas;
	
	@PostConstruct
	public void init() {
		pedido = new Pedido();
		comida = new Comida();
		comidas = new ArrayList<Comida>();
		subtotal = 0;
		iva = 0;
		total = 0;
	}
	
	
	public String agregarComida() {
		this.comidas.add(comida);
		for (int i = 0; i < comidas.size(); i++) {
			this.subtotal += this.comidas.get(i).getPrecioUnitario();
		}
		iva = this.subtotal * 0.12;
		total = iva + subtotal;
		return "";
	}
	
	public String realizarPedido() {
		this.pedido.setTotal(total);
		this.pedido.setComidas(comidas);
		pedidoOn.nuevoPedido(pedido);
		return "";
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Comida getComida() {
		return comida;
	}

	public void setComida(Comida comida) {
		this.comida = comida;
	}

	public List<Comida> getComidas() {
		return comidas;
	}

	public void setComidas(List<Comida> comidas) {
		this.comidas = comidas;
	}


	public double getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}


	public double getIva() {
		return iva;
	}


	public void setIva(double iva) {
		this.iva = iva;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}
	
	
	
	
	
}
