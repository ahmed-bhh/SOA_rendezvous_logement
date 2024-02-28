package com.esprit.busniss;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.esprit.entities.Logement;
import com.esprit.entities.Logement.Type;
import com.esprit.entities.RendezVous;


public class LogementBusiness {
	
	public static List<Logement> logements;

	
	public LogementBusiness() {
		logements=new ArrayList<Logement>();
		logements.add(new Logement(1,"27, Rue des roses", "El ghazela","Ariana",Type.Studio,"cuisine equipee",300f));
		logements.add(new Logement(2,"201, R�sidence Omrane4", "Riadh El Andalous","Ariana",Type.Appartement,"chauffage central, ascenseur, climatisation",700f));
		logements.add(new Logement(3,"540, R�sidence Les Tulipes", "El Aouina","Ariana",Type.Appartement,"S+2, chauffage central, ascenseur, climatisation",500f));
		logements.add(new Logement(4,"78, Rue des Oranges", "Bardo","Tunis",Type.EtageVilla,"chauffage central, ascenseur, climatisation",400f));
		logements.add(new Logement(5,"58, Rue des roses", "El ghazela","Ariana",Type.EtageVilla,"cuisine equipee",450f));
	}

	public List<Logement> getLogements() {
		return logements;
	}

	public void setLogements(List<Logement> logements) {
		this.logements = logements;
	}
	
	public Logement getLogementsByReference(int reference){
		
		for (Logement l:logements){
			if(l.getReference()==reference)
				return l;
		}
		return null;
	}
	
	public List<Logement> getLogementsByDeleguation(String deleguation){
		List<Logement> liste=new ArrayList<Logement>();
		for (Logement l:logements){
			if(l.getDeleguation().equals(deleguation))
				liste.add(l);
		}
		return liste;
	}
	
	public List<Logement> getLogementsByGouvernorat(String gouvernorat){
		List<Logement> liste=new ArrayList<Logement>();
		for (Logement l:logements){
			if(l.getGouvernorat().equals(gouvernorat))
				liste.add(l);
		}
		return liste;
	}
	
	public List<Logement> getLogementsByType(Type type){
		List<Logement> liste=new ArrayList<Logement>();
		for (Logement l:logements){
			if(l.getType().equals(type))
				liste.add(l);
		}
		return liste;
	}
	
	public List<Logement> getLogementsByPrix(float prix){
		List<Logement> liste=new ArrayList<Logement>();
		for (Logement l:logements){
			if(l.getPrix()<=prix)
				liste.add(l);
		}
		return liste;
	}

	public Logement getlogementVousById(int id){
		Logement rendezVous=null;
		for(Logement r:logements){
			if(r.getReference()==id)
				rendezVous=r;
		}
		return rendezVous;
	}

	public boolean deletelogement(int id){
		Iterator<Logement> iterator=logements.iterator();
		while(iterator.hasNext()){
			Logement r=iterator.next();
			if(r.getReference()==id){
				iterator.remove();
				return true;
			}
		}
		return false;
	}

	
	

}
