package br.com.PH.exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = 1L;
    
	private Date horaDoErro;
	private String mensagem;
	private String detalhes;
	
	public ExceptionResponse(Date horaDoErro, String mensagem, String detalhes) {
		this.horaDoErro = horaDoErro;
		this.mensagem = mensagem;
		this.detalhes = detalhes;
	}

	public Date getHoraDoErro() {
		return horaDoErro;
	}

	

	public String getMensagem() {
		return mensagem;
	}

	

	public String getDetalhes() {
		return detalhes;
	}


	
}
