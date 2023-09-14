package org.bedu.java.backend.s5;

import org.bedu.java.backend.s5.e1.models.Saludo;
import org.bedu.java.backend.s5.e2.services.SaludoService;
import org.bedu.java.backend.s5.e3.services.SaludoServiceE3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class S5Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(S5Application.class, args);
	}

//	------------------------------------------E1----------------------------------------------

////	@Autowired
////	Cambia el nivel de acceso de privado a publico para asignar
////	la instancia y luego regresa de publico a privado
////	Lo provoca una inicialización lenta
//	private Saludo saludo;
//
////	@Autowired
//////	No cambia el nivel de acceso
//////	Pero permite modificar la instancia
////	public void setSaludo(Saludo saludo){
////		this.saludo = saludo;
////	}
//
//	@Autowired
////	Está es la manera recomendada, ya que no cambia el nivel de acceso
////	y no permite modificar la instancia
//	public S5Application(/*@Autowired*/ Saludo saludo) {
//		this.saludo = saludo;
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println(saludo.getNombre());
//	}


//	------------------------------------------E2----------------------------------------------

//	private final SaludoService saludoService;
//
//	@Autowired
//	public S5Application(SaludoService saludoService) {
//		this.saludoService = saludoService;
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println(saludoService.saluda());
//	}


//	------------------------------------------E3----------------------------------------------

	private final SaludoServiceE3 saludoServiceE3;

	@Autowired
	public S5Application(SaludoServiceE3 saludoServiceE3) {
		this.saludoServiceE3 = saludoServiceE3;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(saludoServiceE3.saluda());
	}
}
