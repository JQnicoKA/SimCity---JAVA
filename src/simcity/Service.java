package simcity;

public abstract class Service extends Construction {
protected int CoefficientRevenu;
//cette fonction permet de mettre � jour le coefficient de revenue, cette attribut permet � l'utilisateur de r�colter plus d'impots en fonction de la pr�sence des batiments de service
public void MajCoefficientRevenu() {
	Ville.CoefficientRevenu=this.CoefficientRevenu+Ville.CoefficientRevenu;
}

	
}
