package com.amapearte.vista;

public interface IDelegadoDeNegocio {
	
	public String saveLugar(String nombreLugar, String descLugar, double longitud, double latitud) throws Exception;
	
	/* Metodos de la clase Capa */	
	public String saveCapa(String nombrecapa, String descripcioncapa, String iconocapa) throws Exception;
//	public String update(Capa capa);
//	public String delete(Capa capa);
//	public Capa findById(Long idcapa);
//	public List<Capa> findAll();
	/* Fin Metodos de la clase Capa */	
	
}
