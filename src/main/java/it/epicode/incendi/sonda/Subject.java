package it.epicode.incendi.sonda;

import java.util.Observer;

public interface Subject {
	public void addObserver(Observer o);
	public void removeObserver();
	public void notifyObserver(String msg);
}
