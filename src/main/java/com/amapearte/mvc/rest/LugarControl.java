package com.amapearte.mvc.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amapearte.vista.IDelegadoDeNegocio;

@RestController
@RequestMapping(value = "/elementoCapaRest")
public class LugarControl {
	
	private final static Logger log = LoggerFactory.getLogger(LugarControl.class);
	
	@Autowired
	private IDelegadoDeNegocio delegadoDeNegocio;
	
	@GetMapping(value = "/guardarLugar/{nombreLugar}/{descLugar}/{longitud}/{latitud}")
	public ResultadoLugarControl registrarElementoCapa(@PathVariable("nombreLugar") String nombreLugar, @PathVariable("descLugar") String descLugar, @PathVariable("longitud") double longitud, @PathVariable("latitud") double latitud) throws Exception {
		ResultadoLugarControl resultado = new ResultadoLugarControl();
		resultado.setMensaje(delegadoDeNegocio.saveLugar(nombreLugar, descLugar, longitud, latitud));
		return resultado;
		
	}

}
