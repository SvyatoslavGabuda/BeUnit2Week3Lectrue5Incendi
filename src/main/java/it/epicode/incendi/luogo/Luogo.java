package it.epicode.incendi.luogo;

import java.util.ArrayList;
import java.util.List;

import it.epicode.incendi.puntodiascolto.PuntoDiAscolto;
import it.epicode.incendi.sonda.Sonda;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Luogo {
	private PuntoDiAscolto puntoDiAscolto;
	private List<Sonda> listaSonda;
	
	public void assegnaSonde() {
		for(int i = 0;i<this.listaSonda.size();i++) {
			listaSonda.get(i).addObserver(puntoDiAscolto);
		}
	}
	public void addSonda(Sonda s) {
		if(this.listaSonda == null) {
			this.listaSonda = new ArrayList<Sonda>();
		}
		this.listaSonda.add(s);
	}
	public void controllaSonde() {
		this.getListaSonda().forEach(s->s.controllaSituzione());
	}
	
}
