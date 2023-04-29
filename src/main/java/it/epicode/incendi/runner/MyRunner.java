package it.epicode.incendi.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.epicode.incendi.centrodicontrollo.CentroDiControllo;
import it.epicode.incendi.centrodicontrollo.CentroDiControlloFactory;
import it.epicode.incendi.luogo.Luogo;
import it.epicode.incendi.puntodiascolto.PuntoDiAscolto;
import it.epicode.incendi.sonda.Sonda;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MyRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Run start");	
		PuntoDiAscolto p1 = new PuntoDiAscolto();
		Sonda s1 = new Sonda();
		Sonda s2 = new Sonda();
		Sonda s3 = new Sonda();
		s1.setLivelloFumo(6);
		s1.setId_sonda(1l);
		s1.setLat(100l);
		s1.setLng(100l);
		s1.addObserver(p1);
		s2.setId_sonda(2l);
		s2.setLivelloFumo(6);
		s2.setLat(1000l);
		s2.setLng(1000l);
		s2.addObserver(p1);
		s3.setId_sonda(3l);
		s3.setLivelloFumo(2);
		s3.setLat(22l);
		s3.setLng(22l);
		s3.addObserver(p1);
		Luogo l1 = new Luogo();
		l1.addSonda(s2);
		l1.addSonda(s1);
		l1.addSonda(s3);
		l1.setPuntoDiAscolto(p1);
		l1.assegnaSonde();
		
		
//		s1.incendio();
//		s2.incendio();
		
			CentroDiControllo centro1 = CentroDiControlloFactory.setTipo("fuoco");
		l1.getPuntoDiAscolto().addObserver(centro1);
		
		l1.getListaSonda().forEach(s->s.controllaSituzione());
		l1.controllaSonde();
		System.out.println("Run END");	
	}

}
