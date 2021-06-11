package ec.edu.ups.Examen.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.edu.ups.Examen.entity.Tarjeta;



public class TarjetaDao {

	@Inject
	private EntityManager em;
	
	
	public void agregarTarjeta(Tarjeta tarjeta) {
		em.persist(tarjeta);
	}
	
}
