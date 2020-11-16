package com.it_talent.exceptions;

import org.springframework.web.bind.MethodArgumentNotValidException;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorMessages {

	@JsonProperty("mensaje")
	private String mensaje;
	
	public ErrorMessages(MethodArgumentNotValidException exception, String uriRequested) {
	       this.mensaje = exception.getMessage();
	   }

	public ErrorMessages(String mensaje) {
		super();
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	
}
