package ec.edu.ups.Examen.bussiness;

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
		for (int i = 0; i < pedido.getComidas().size(); i++) {
			Comida comida = pedido.getComidas().get(i);
			comida.setPedido(pedido);
			comidaDao.nuevaComida(comida);
		}
		pedidoDao.nuevoPedido(pedido);
	}
	
}
