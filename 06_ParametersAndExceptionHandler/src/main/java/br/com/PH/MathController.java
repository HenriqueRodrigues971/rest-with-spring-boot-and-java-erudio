package br.com.PH;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.PH.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {
	private static final String modeloMensagem = "Hello, %s";
	private final AtomicLong contador = new AtomicLong();
	
	String msgSetNumericValue = "Please set a numeric value";

	@RequestMapping(value = "/soma/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double soma(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		if (!Metodos.isNumeric(numberOne) || !Metodos.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException(msgSetNumericValue);
		}
		return Metodos.convertToDouble(numberOne) + Metodos.convertToDouble(numberTwo);
	}
	
	@RequestMapping(value = "/subtracao/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtracao(@PathVariable(value = "numberOne") String numberOne, 
    		@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		if (!Metodos.isNumeric(numberOne) || !Metodos.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException(msgSetNumericValue);
		}
		
		return Metodos.convertToDouble(numberOne) - Metodos.convertToDouble(numberTwo);
	}
	
	@RequestMapping(value = "/multi/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multi(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception{
		if (!Metodos.isNumeric(numberOne) || !Metodos.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException(msgSetNumericValue);
		}
		return Metodos.convertToDouble(numberOne) * Metodos.convertToDouble(numberTwo);
	}
  @RequestMapping(value = "/dividir/{numberOne}/{numberTwo}", method = RequestMethod.GET)
  public Double dividir(@PathVariable(value = "numberOne")String numberOne, 
		  @PathVariable(value = "numberTwo")String numberTwo) throws Exception{
	  if (!Metodos.isNumeric(numberOne) || !Metodos.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException(msgSetNumericValue);
		}
	  double n1 = Metodos.convertToDouble(numberOne);
	  double n2 = Metodos.convertToDouble(numberTwo);
	 if(n2 == 0){
		throw new UnsupportedMathOperationException("Cannot divide by zero ");
	 }
	 return n1 / n2;
	 
  }
  
  @RequestMapping(value = "/media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double media(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
	  if (!Metodos.isNumeric(numberOne) || !Metodos.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException(msgSetNumericValue);
		}
		double n1 = Metodos.convertToDouble(numberOne) + Metodos.convertToDouble(numberTwo);
		return n1 /2;
	}
  
  
  @RequestMapping(value = "/raiz/{numberOne}")
  public Double raiz(@PathVariable(value = "numberOne") String numberOne) throws Exception{
	  if(!Metodos.isNumeric(numberOne)) {
		  throw new UnsupportedMathOperationException("Please set a numeric value");
	  }
	  return Math.sqrt(Metodos.convertToDouble(numberOne));
	 
  }
  
	/* A anotação PathVariable é usado para recuperar dados da url */
}
