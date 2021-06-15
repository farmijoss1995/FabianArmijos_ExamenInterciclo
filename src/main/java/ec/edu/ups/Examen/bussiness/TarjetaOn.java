package ec.edu.ups.Examen.bussiness;

import java.util.Date;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.Examen.dao.TarjetaDao;
import ec.edu.ups.Examen.entity.Tarjeta;


@Stateless
public class TarjetaOn {

	@Inject
	private TarjetaDao tarjetaDao;
	
	
	public Tarjeta buscarTarjeta(int numero) {
		return tarjetaDao.buscarTarjeta(numero);
	}
	
}
