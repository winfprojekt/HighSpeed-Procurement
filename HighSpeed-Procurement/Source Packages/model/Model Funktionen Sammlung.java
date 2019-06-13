package model.Bestellung;

import java.util.ArrayList;


import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Produkt.Grafikkarte;

public class TestMain {
	public static void main(String[] args) {
	
//Erstellen und speichern
	//User
	
		
	//Lieferant
	Lieferant.readLayer(new TextField[] {} ).create();
	
	//Produkt
	Grafikkarte.readLayer(new TextField[] {} ).create();
	
	//Angebot
	Angebot.readLayer(new TableView<Lieferant>(), new TableView<Produkt>(), new TextField(), new TextField()).create();
	
	//Produktportfolio
	Produktportfolio.readLayer(new TableView<TableAngebot>()).create();
	
	//Position (speichern nicht möglich, jedoch hinzufügen zum SammelbestellungsTable
	Position.readLayer(new TableView<TableAngebot>(), new TextField()).addToSB(new TableView<TablePosition>(), new TableView<TableAngebot>(), new TextField());
	
	//Teilbestellung + Sammelbestellung (speichern nicht möglich,jedoch split() und dann speichern)
	ArrayList<Teilbestellung> teilbestellungen  = Sammelbestellung.readLayer(User.isLoggedIn().getiD(),new TableView<TablePosition>()).split();
	teilbestellungen.forEach(teilbestellung->{teilbestellung.create();});
	
	
//Einlesen und updaten
	//User
	
	//Lieferant
	Lieferant.readLayer(new TextField[] {} ).update( new Integer(1)/*Lieferant iD*/);
	
	//Produkt
	Produkt.readLayer(new TextField[] {} ).update( new Integer(1)/*Lieferant iD*/);

	//Angebot
	//nicht updatebar
	
	//Produktportfolio
	//nicht updatebar
	
	//Teilbestellung + Sammelbestellung
	Teilbestellung.updateStatus(0,"Versendet"); //Bsp
	
	
// Laden und Ausgeben
	//User
	
	//Lieferant 
	//Alle
	Lieferant.writeAll(Lieferant.readAll(),new TableView<Lieferant>());
	//Einer
	Lieferant.readOne(new Integer(1)/*Lieferant iD*/).writeOne(new TextField[] {});
	
	//Produkt
	//Alle
	Produkt.writeAll(Produkt.readAll(),new TableView<Produkt>());
	//Einer
	Produkt.readOne(new Integer(1)/*Angebot iD*/).writeOne(new TextField[] {});
	
	//Angebot
	//Alle aktiven
	Angebot.writeList(Angebot.readActive(),new TableView<TableAngebot>());
	
	//Produktportfolio
	//Alle (Nur Namen)
	Produktportfolio.writeAllNames(Produktportfolio.readAllID(),new TableView<String>());
	//Eins (Alle Angebote)
	Angebot.writeList(Produktportfolio.readOne(new Integer(1)/*Angebot iD*/).getAngebote(),new TableView<TableAngebot>());
	
	//Teilbestellung
	//Alle
	Teilbestellung.writeAll(Teilbestellung.readAll(),new TableView<Teilbestellung>());
		
	//Eins
	Position.writeList(Teilbestellung.readOne(new Integer(1)/*Teilbestellung iD*/).getPositionen(),new TableView<TablePosition>());
}
}
