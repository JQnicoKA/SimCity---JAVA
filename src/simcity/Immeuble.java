package simcity;

public class Immeuble extends Habitation {

	public Immeuble() {
		this.population=50;
		this.consommationEau=this.population*1;		//facteur de consommation
		this.consommationElectricite=this.population*2;
		this.coutArgent=1000;
		this.coutFer=500;
		this.coutBois=450;

	}
}
