package simcity;

public class GrandeMaison extends Habitation {

	
		public GrandeMaison() {
		this.population=10;
		this.consommationEau=this.population*1;		//facteur de consommation
		this.consommationElectricite=this.population*2;
		this.coutArgent=200;
		this.coutFer=50;
		this.coutBois=30;
	}
	
}
