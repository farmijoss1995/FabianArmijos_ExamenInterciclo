package ec.edu.ups.Examen.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.Examen.dao.ComidaDao;
import ec.edu.ups.Examen.dao.PedidoDao;
import ec.edu.ups.Examen.entity.Comida;
import ec.edu.ups.Examen.entity.Pedido;





@Stateless
public class PedidoOn {
	
	@Inject
	private PedidoDao pedidoDao;
	
	@Inject
	private ComidaDao comidaDao;
	
	public void nuevoPedido(Pedido pedido) {
		for (Comida comida : pedido.getComidas()) {
			comida.setPedido(pedido);
		}
		pedidoDao.nuevoPedido(pedido);
	}
	
	public List<Pedido> pedidos(){
		return pedidoDao.general();
	}
	
}
