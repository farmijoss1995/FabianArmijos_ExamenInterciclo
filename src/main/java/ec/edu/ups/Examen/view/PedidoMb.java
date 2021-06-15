package ec.edu.ups.Examen.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.Examen.bussiness.PedidoOn;
import ec.edu.ups.Examen.bussiness.TarjetaOn;
import ec.edu.ups.Examen.entity.Comida;
import ec.edu.ups.Examen.entity.Pedido;
import ec.edu.ups.Examen.entity.Tarjeta;



@ManagedBean
@ViewScoped
public class PedidoMb {

	@Inject
	private PedidoOn pedidoOn;
	
	@Inject
	private TarjetaOn tarjetaOn;
	
	private String criterioBusqueda;
	
	private Pedido pedido;
	
	private List<Pedido> pedidos;
	
	
	private String nombre;
	private double precioUniatrio;
	private String tarjeta;
	private double subtotal;
	private double iva;
	private double total;
	
	private List<Comida> comidas = new ArrayList<Comida>();
	
	@PostConstruct
	public void init() {
		cargarPedidos();
		pedido = new Pedido();
		precioUniatrio = 0;
		nombre = "";
		criterioBusqueda = "";
		tarjeta = "";
		subtotal = 0;
		iva = 0;
		total = 0;
	}
	
	
	public void cargarPedidos() {
		pedidos = pedidoOn.pedidos();
	}
	
	public String agregarComida() {
		Comida comida = new Comida();
		comida.setNombre(nombre);
		comida.setPrecioUnitario(precioUniatrio);
		this.comidas.add(comida);
		this.subtotal += precioUniatrio;
		iva = this.subtotal * 0.12;
		total = iva + subtotal;
		nombre="";
		precioUniatrio=0;
		return "";
	}
	
	public String realizarPedido() {
		this.pedido.setComidas(comidas);
		this.pedido.setTotal(total);
		this.pedido.setComidas(comidas);
		System.out.println(pedido.toString());
		if (this.pedido.getTarjeta() != null ) {
			pedidoOn.nuevoPedido(pedido);
			cargarPedidos();
			pedido = null;
			this.nombre = "";
			this.precioUniatrio = 0;
			this.iva = 0;
			this.subtotal = 0;
			this.total=0;
			this.tarjeta="";
			this.criterioBusqueda="";
		} else {
			tarjeta = "Tarjeta no asocida";
		}
		
		return "";
	}
	
	/*public  void generarNuevaTarjeta() {
		System.out.println("hol..............."+tarjeta);
		
		tarjeta.setNombreTitular(pedido.getNombreCliente());
		tarjeta.setFechaCaducidad(pedido.getFecha());
		
		int numeroTarjeta = (int)(Math.random()*10+1);
		tarjeta.setNumeroTrajeta(numeroTarjeta);
		
		int cvv = (int)(Math.random()*4+1);
		tarjeta.setCvv(cvv);
		
		//tarjeta.addPedido(pedido);
		
		System.out.println("......"+tarjeta.getNombreTitular() + "..."+tarjeta.getNumeroTrajeta());
		
		Tar.create(tarjeta);
		
	}*/
	
		
	
	public String buscarTarjeta() {
		try {
			Tarjeta tar = tarjetaOn.buscarTarjeta(Integer.parseInt(criterioBusqueda));
			tarjeta = tar.getNombreTitular() + " "+ tar.getNumero();
			this.pedido.setTarjeta(tar);
			
		} catch (Exception e) {
			// TODO: handle exception
			tarjeta = "Error";
		}
		return "";
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
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


	public PedidoOn getPedidoOn() {
		return pedidoOn;
	}


	public void setPedidoOn(PedidoOn pedidoOn) {
		this.pedidoOn = pedidoOn;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getPrecioUniatrio() {
		return precioUniatrio;
	}


	public void setPrecioUniatrio(double precioUniatrio) {
		this.precioUniatrio = precioUniatrio;
	}


	public String getCriterioBusqueda() {
		return criterioBusqueda;
	}


	public void setCriterioBusqueda(String criterioBusqueda) {
		this.criterioBusqueda = criterioBusqueda;
	}


	public String getTarjeta() {
		return tarjeta;
	}


	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}




	public List<Pedido> getPedidos() {
		return pedidos;
	}




	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	
	
	
	
}
