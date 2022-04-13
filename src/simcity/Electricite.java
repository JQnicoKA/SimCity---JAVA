package simcity;

public class Electricite extends Energie {
	//fonction qui permet de mettre a  jour la production d'electricite
	public void MajProductionElectricite() {
		Ville.electriciteP= Ville.electriciteP+this.getProduction();
	}
	
}
