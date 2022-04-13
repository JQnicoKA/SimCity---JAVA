package simcity;

public class Construction {

	protected int coutArgent;
	protected int coutBois;
	protected int coutFer;
	
		public Construction() {
			
		}

	//getter et setters pour les attributs de la classe construction
	public int getcoutArgent() {
		return this.coutArgent;
	}
	public int getcoutBois() {
		return this.coutBois;
	}
	public int getcoutFer() {
		return this.coutFer;
	}

	public void setcoutArgent(int argent){
		this.coutArgent=argent;
	}

	public void setcoutBois(int bois) {
		this.coutBois=bois;
	}
	public void setcoutFer(int fer){
		this.coutFer=fer;
	}
	//fonction boolean qui vérifie si les ressources de la ville sont suffisantes pour construire une construction
	public boolean RessourcesEnoughToBuild() {
		return ((Ville.argent>=this.coutArgent)&&(Ville.Bois>=this.coutBois)&&(Ville.fer>=this.coutFer));
	}
	//fonction qui permet de mettre à jour les ressources de la ville après une construction
	public void MajRessources() {
		Ville.argent=Ville.argent-this.coutArgent;
		Ville.Bois=Ville.Bois-this.coutBois;
		Ville.fer=Ville.fer-this.coutFer;
	}
	}
