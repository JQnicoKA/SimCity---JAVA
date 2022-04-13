package simcity;

public abstract class Habitation extends Construction {
protected int population;
protected int consommationEau;
protected int consommationElectricite;


public int getPopulation() {
	return this.population;
}
//permet de mettre ра jour la consommation d'energie pour une habitation
public void MajConsommation() {
Ville.electriciteC=Ville.electriciteC+this.consommationEau;
Ville.eauC=Ville.eauC+this.consommationEau;
}
//permet de mettre ра jour la population
public void MajPopulation() {
	Ville.population=Ville.population+this.getPopulation();
}


}
