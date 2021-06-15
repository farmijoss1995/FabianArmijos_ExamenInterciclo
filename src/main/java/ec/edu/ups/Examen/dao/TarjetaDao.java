package ec.edu.ups.Examen.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.Examen.entity.Tarjeta;



public class TarjetaDao {

	@Inject
	private EntityManager em;
	
	
	public Tarjeta buscarTarjeta(int numero) {
		String jpql = "Select t from Tarjeta t where t.numero = :numero";
		Query query = em.createQuery(jpql, Tarjeta.class);
		query.setParameter("numero", numero);
		Tarjeta tarjeta = (Tarjeta) query.getSingleResult();
		return tarjeta;
	}
	
}
