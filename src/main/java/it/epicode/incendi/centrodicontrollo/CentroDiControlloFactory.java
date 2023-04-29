package it.epicode.incendi.centrodicontrollo;

public class CentroDiControlloFactory {
public static CentroDiControllo setTipo(String tipo) {
	if(tipo.equalsIgnoreCase("fuoco")) {
		return new CentroDiControlloVigiliDelFuoco();
	}
	return null;
}
}
