package com.mx.Usuarios.dto;

public class Respuesta {
	private String mensaje;
	private boolean success;
	private Object obj;
	
	public Respuesta() {
		
	}
	
	public Respuesta(String mensaje, boolean success, Object obj) {
		this.mensaje = mensaje;
		this.success = success;
		this.obj = obj;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
}
