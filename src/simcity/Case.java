package simcity;

import java.util.Random;

public class Case {

	private boolean eau,vent,soleil,mine,pollution;
	private Construction maConstruction;
	
	public boolean getRandomBoolean() {
	    Random random = new Random();
	    return random.nextBoolean();
	}
	
	Case(){										//dans le constructeur par défaut, on créer une case avec une répartition aléatoires des ressources
		this.eau=getRandomBoolean();			
		this.vent=getRandomBoolean();		
		this.soleil=getRandomBoolean();
		this.mine=getRandomBoolean();
		this.pollution=false;
		Construction maConstruction = new Construction();
	}
	public Construction getMaConstruction() {
		return this.maConstruction;
	}
	
	/**
	 * la fonction SetMaConstruction utilise un type generic, elle permet de construire un batiment,
	 * elle sera appelé une fois que toutes les vérifications dans la fonction setConstruction Plateau.java sont éffectuées
	 * @param <T>
	 * @param construction
	 */
	public <T> void SetMaConstruction(T construction) {
		this.maConstruction=(Construction) construction;
		
		if (construction.getClass().getSuperclass().getTypeName()=="simcity.Habitation"){
			
			((Habitation)construction).MajPopulation();			//si une habitation est construire la population est mise a jour
			((Habitation)construction).MajConsommation();		//de même la consommation également
		}

		
		if(construction.getClass().getSuperclass().getTypeName()=="simcity.Eau") {
			((Eau)construction).MajProductionEau();				//si cette construction est un batiment d'eau, la production d'eau est mise à  jour
		}
		
		if(construction.getClass().getSuperclass().getTypeName()=="simcity.Electricite") {
			((Electricite)construction).MajProductionElectricite();	//si cette construction est un batiment d'electricite, la production d'electricite est mise à jour
		}
		
		if(construction.getClass().getSuperclass().getTypeName()!="simcity.Stockage")
		((Construction)construction).MajRessources();				//les construction ont un prix, donc après une construction, on doit mettre à jour les ressources de l'utilisateur
		
		Ville.updateSatisfaction();
	}
	
	
	//les getters et setters des attributs ressources qui sont boolean
	public boolean getEau(){
		return this.eau;
	}
	
	public boolean getVent() {
		return this.vent;
	}
	
	public boolean getSoleil(){
		return this.soleil;
	}
	
	public boolean getMine() {
		return this.mine;
	}

	public void setEau(boolean eau){this.eau = eau;}
	public void setPollution(boolean pollution){this.pollution=pollution;}
	public void setVent(boolean vent){this.vent=vent;}
	public void setSoleil(boolean soleil){this.soleil=soleil;}
	public void setMine(boolean mine){this.mine=mine;}

	//vérifie si une case est vide, une case est vide si elle ne comporte aucune construction
	public boolean isVide() {
		return this.maConstruction == null;
	}
	
	//vide la construction qui se trouve dans la case 
	public void setVide() {
		 this.maConstruction= null;
	}
	//vérifie si la constructuon est une route
	public boolean isRoad() {
		if(this.maConstruction==null) {
			return false;
		}else {
		return (this.maConstruction.getClass().getTypeName()=="simcity.Route");
	}
	}
	public boolean getPollution() {
		return this.pollution;
	}
	//permet de polluer la case
	public void Pollute() {
		this.pollution=true;
	}
	//permet de depolluer la case
	public boolean Unpolluted() {
    	if(Ville.argent >= 10000) {
    		Ville.argent = Ville.argent-1000;
    		this.pollution=false;
    		return true;
    	}else {
    		return false;
    	}
	}

	
	
}
