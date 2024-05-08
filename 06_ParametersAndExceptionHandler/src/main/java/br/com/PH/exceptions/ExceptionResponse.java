package br.com.PH.exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = 1L;
    
	private Date horaDoErro;
	private String mensagem;
	private String detalhes;
}
