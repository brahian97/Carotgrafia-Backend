package com.amapearte.vista;

import com.amapearte.dao.ILugarDAO;
import com.amapearte.logica.ICapaLogica;
import com.amapearte.logica.ILugarLogica;
import com.amapearte.modelo.Capa;
import com.amapearte.modelo.Lugar;

/**import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("delegadoDeNegocio")
@Scope("singleton")**/
public class DelegadoDeNegocio implements IDelegadoDeNegocio {

	private ILugarLogica lugarLogica;	
	private ICapaLogica capaLogica;
	
	@Override
	public String saveLugar(String nombreLugar, String descLugar, double longitud, double latitud) throws Exception{
		Lugar lugar = new Lugar();
		lugar.setNombrelugar(nombreLugar);;
		lugar.setDesclugar(descLugar);
		lugar.setLongitud(longitud);
		lugar.setLatitud(latitud);
		
		return lugarLogica.save(lugar);
	}

	/* Metodos de la clase Capa */	
	public String saveCapa(String nombreCapa, String descripcionCapa, String iconoCapa) throws Exception{
		Capa nuevaCapa = new Capa();
		nuevaCapa.setNombrecapa(nombreCapa);
		nuevaCapa.setDescripcioncapa(descripcionCapa);
		nuevaCapa.setIconocapa(iconoCapa);
		return(capaLogica.saveCapaRest(nuevaCapa));
	}
//	public String update(Capa capa){
//		return("");
//	}
//	public String delete(Capa capa){
//		return("");
//	}
//	public Capa findById(Long idcapa){
//		Capa capa;
//		return(capa);
//	}
//	public List<Capa> findAll(){
//		List<Capa> listaCapas;
//		return(listaCapas);
//	}
	/* Fin Metodos de la clase Capa */	

}
