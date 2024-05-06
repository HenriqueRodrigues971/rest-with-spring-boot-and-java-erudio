package br.com.PH;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
	private static final String modeloMensagem = "Hello, %s";
	private final AtomicLong contador = new AtomicLong();

	@RequestMapping(value = "/soma/{num1}/{numer2}", method = RequestMethod.GET)
	public Double soma(@PathVariable(value = "num1") String num1, @PathVariable(value = "num2") String num2) {
		return 1D;
	}

	/* A anotação PathVariable é usado para recuperar dados da url */
}
