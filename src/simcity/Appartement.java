package simcity;

public class Appartement extends Habitation {
	public Appartement() {
		this.population=20;
		this.consommationEau=this.population*1;		//facteur de consommation
		this.consommationElectricite=this.population*2;
		this.coutArgent=500;
		this.coutFer=150;
		this.coutBois=100;
		
	}
}
