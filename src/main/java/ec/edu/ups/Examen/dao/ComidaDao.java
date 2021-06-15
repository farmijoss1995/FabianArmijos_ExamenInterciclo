package ec.edu.ups.Examen.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.edu.ups.Examen.entity.Comida;


public class ComidaDao {

	@Inject
	private EntityManager em;
	
	public void nuevaComida(Comida comida) {
		em.persist(comida);
	}
}
