package ec.edu.ups.Examen.bussiness;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.Examen.dao.ComidaDao;
import ec.edu.ups.Examen.entity.Comida;



@Stateless
public class ComidaOn {
	
	@Inject
	private ComidaDao comidaDao;
	
	public void nuevaComida(Comida comida) {
		comidaDao.nuevaComida(comida);
	}

}
