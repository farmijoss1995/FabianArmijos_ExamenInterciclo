package ec.edu.ups.Examen.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.edu.ups.Examen.entity.Pedido;



public class PedidoDao {

	@Inject
	EntityManager em;
	
	
	public void nuevoPedido(Pedido pedido) {
		em.persist(pedido);
	}
}
