package it.epicode.incendi.sonda;

import java.util.Observable;
import java.util.Observer;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Sonda extends Observable implements Subject {
	private Long id_sonda;
	private Long lat;
	private Long lng;
	private int livelloFumo;

	private boolean incendioInCorso;
	private Observer puntoDiAscolto;
 public Sonda(){
	 this.incendioInCorso = false;
 }
	public void addObserver(Observer o) {
		this.puntoDiAscolto = o;
	}

	public void removeObserver() {
		this.puntoDiAscolto = null;
	}

	public String controllaSituzione() {
		if (this.livelloFumo > 5) {
			System.out.println("incendio in corso");
			notifyObserver("incendio in corso");
			this.incendioInCorso = true;
			return "incendio in corso";
		} else if(this.livelloFumo<0) {
			System.out.println("Valore letto non coretto, richiesta di manutenzione");
			notifyObserver("Valore letto non coretto, richiesta di manutenzione");
			return "problema di rilevamento";
		} else {
			System.out.println("Tutto nella norma");
			notifyObserver("Tutto nella norma");
			this.incendioInCorso = false;
			return "ok";
		}
	}

	
	public void notifyObserver(String msg) {
		puntoDiAscolto.update(this, msg);

	}

}
