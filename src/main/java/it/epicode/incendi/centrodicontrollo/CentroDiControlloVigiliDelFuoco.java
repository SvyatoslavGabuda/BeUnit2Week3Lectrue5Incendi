package it.epicode.incendi.centrodicontrollo;

import java.util.Observable;
import java.util.Observer;

import it.epicode.incendi.sonda.Sonda;

public class CentroDiControlloVigiliDelFuoco implements CentroDiControllo, Observer {

	@Override
	public void avvisaVigilidelfuoco(Object o) {
		System.out.println("http:/host/alarm?=" + 
	((Sonda) o).getId_sonda() 
	+ "&lat=" + ((Sonda) o).getLat()
				+ "&lon=" + ((Sonda) o).getLng() 
				+ "&smokelevel=" + ((Sonda) o).getLivelloFumo());

	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Centro di Controllo vigili del fuoco: messaggio sonda id numero: " + ((Sonda) o).getId_sonda()
				+" " +(String)arg);
		
		if(((String)arg).equals("incendio in corso")) {
			avvisaVigilidelfuoco(o);
			
	}
	}

}
