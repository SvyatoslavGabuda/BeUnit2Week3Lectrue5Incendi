package it.epicode.incendi.puntodiascolto;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import it.epicode.incendi.sonda.Sonda;
import it.epicode.incendi.sonda.Subject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PuntoDiAscolto extends Observable implements Observer {
	private Long id_punto;
	private List<Observer> centriDiControllo = new ArrayList<Observer>();
//private List<Sonda> listaSonde;
//private List<String> listaAllarmi;

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("PUNTO DI ASCOLTO: messaggio sonda id: "
	+ ((Sonda) o).getId_sonda() +" "+ (String)arg);
				notifyObserver(o, (String)arg);

	}

	public void addObserver(Observer o) {
		this.centriDiControllo.add(o);
	}

	public void removeObserver(Observer o) {
		this.centriDiControllo.remove(o);

	}

	public void notifyObserver(Observable o, String arg) {
		for (Observer obs : this.centriDiControllo) {
			obs.update((Observable) o, arg);
		}
	}

}
