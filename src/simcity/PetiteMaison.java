package simcity;

public class PetiteMaison extends Habitation {

	
	public PetiteMaison() {
		this.population=5;
		this.consommationEau=this.population*1;		//facteur de consommation
		this.consommationElectricite=this.population*2;
		this.coutArgent=100;
		this.coutFer=20;
		this.coutBois=10;
	}
}
