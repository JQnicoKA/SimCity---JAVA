package simcity;

public  abstract class Eau extends Energie {
//fonction qui permet de mettre ра jour la production d'eau
	public void MajProductionEau() {
		Ville.eauP= Ville.eauP+this.getProduction();
	}
}
