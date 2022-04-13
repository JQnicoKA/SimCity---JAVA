package simcity;

public abstract class Service extends Construction {
protected int CoefficientRevenu;
//cette fonction permet de mettre à jour le coefficient de revenue, cette attribut permet à l'utilisateur de récolter plus d'impots en fonction de la présence des batiments de service
public void MajCoefficientRevenu() {
	Ville.CoefficientRevenu=this.CoefficientRevenu+Ville.CoefficientRevenu;
}

	
}
