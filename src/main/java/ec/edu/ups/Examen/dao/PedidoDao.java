package ec.edu.ups.Examen.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.Examen.entity.Pedido;



public class PedidoDao {

	@Inject
	EntityManager em;
	
	
	public void nuevoPedido(Pedido pedido) {
		em.persist(pedido);
	}
	
	public List<Pedido> general() {
		System.out.println("LOLOLOL");
		String jpql = "Select p from Pedido p";
		Query query = em.createQuery(jpql, Pedido.class);
		List<Pedido> pedidos = query.getResultList();
		return pedidos;
	}
}
