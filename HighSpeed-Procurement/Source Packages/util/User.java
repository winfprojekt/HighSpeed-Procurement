/*

Es gibt Fehler an manche Codestellen. 

package util;
public class User {
	private String iD;
	private String email;
	private boolean angemeldet;
	private String passwort;
	
	
	//Konstruktor
	public User(String email, boolean angemeldet, String passwort) {
		super();
		this.email = email;
		this.angemeldet = angemeldet;
		this.passwort = passwort;
	}
	
	//getter+Setter
	public String getiD() {
		return iD;
	}
	public void setiD(String iD) {
		this.iD = iD;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isAngemeldet() {
		return angemeldet;
	}
	public void setAngemeldet(boolean angemeldet) {
		this.angemeldet = angemeldet;
	}
	public String getPasswort() {
		return passwort;
	}
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
	
	//zus�tzliche Logik
	
	public String generatePW() {
		//Aut zuf�lliges automatisch generiertes Passwort erzeugen
	}
	
	public User showLoggedIn() {
		//In der Datenbank den angemeldeten User idetifizieren anhand der boolean Variable und ihn zur�ckgeben
	}
	
	public void create() {
		//Einen User in der Datenbank speichern
	}
	
	public void update(User.iD userID) {
		//Einen bestimmten User (ID) in der Datenbank durch neue Werte ersetzen
	}
	
	//Konstruktor f�r User der von der Konsole aus angesprochen werden kann + speichern in der Datenbank;
	public void konsolenKonstruktor(String email, boolean angemeldet, String passwort) {
		
	}

}
*/